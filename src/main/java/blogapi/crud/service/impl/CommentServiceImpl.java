package blogapi.crud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import blogapi.crud.exception.BlogapiException;
import blogapi.crud.exception.ResourceNotFoundException;
import blogapi.crud.model.Comment;
import blogapi.crud.model.Post;
import blogapi.crud.model.role.RoleName;
import blogapi.crud.model.user.User;
import blogapi.crud.payload.ApiResponse;
import blogapi.crud.payload.CommentRequest;
import blogapi.crud.payload.PagedResponse;
import blogapi.crud.repository.CommentRepository;
import blogapi.crud.repository.PostRepository;
import blogapi.crud.repository.UserRepository;
import blogapi.crud.security.UserPrincipal;
import blogapi.crud.service.CommentService;
import blogapi.crud.utils.AppUtils;

@Service
public class CommentServiceImpl implements CommentService {
	private static final String THIS_COMMENT = " this comment";

	private static final String YOU_DON_T_HAVE_PERMISSION_TO = "You don't have permission to ";

	private static final String ID_STR = "id";

	private static final String COMMENT_STR = "Comment";

	private static final String POST_STR = "Post";

	private static final String COMMENT_DOES_NOT_BELONG_TO_POST = "Comment does not belong to post";

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public PagedResponse<Comment> getAllComments(Long postId, int page, int size) {
		AppUtils.validatePageNumberAndSize(page, size);
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");

		Page<Comment> comments = commentRepository.findByPostId(postId, pageable);

		return new PagedResponse<>(comments.getContent(), comments.getNumber(), comments.getSize(),
				comments.getTotalElements(), comments.getTotalPages(), comments.isLast());
	}

	@Override
	public Comment addComment(CommentRequest commentRequest, Long postId, UserPrincipal currentUser) {
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException(POST_STR, ID_STR, postId));
		User user = userRepository.getUser(currentUser);
		Comment comment = new Comment(commentRequest.getBody());
		comment.setUser(user);
		comment.setPost(post);
		comment.setName(currentUser.getUsername());
		comment.setEmail(currentUser.getEmail());
		return commentRepository.save(comment);
	}

	@Override
	public Comment getComment(Long postId, Long id) {
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException(POST_STR, ID_STR, postId));
		Comment comment = commentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(COMMENT_STR, ID_STR, id));
		if (comment.getPost().getId().equals(post.getId())) {
			return comment;
		}

		throw new BlogapiException(HttpStatus.BAD_REQUEST, COMMENT_DOES_NOT_BELONG_TO_POST);
	}

	@Override
	public Comment updateComment(Long postId, Long id, CommentRequest commentRequest,
			UserPrincipal currentUser) {
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException(POST_STR, ID_STR, postId));
		Comment comment = commentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(COMMENT_STR, ID_STR, id));

		if (!comment.getPost().getId().equals(post.getId())) {
			throw new BlogapiException(HttpStatus.BAD_REQUEST, COMMENT_DOES_NOT_BELONG_TO_POST);
		}

		if (comment.getUser().getId().equals(currentUser.getId())
				|| currentUser.getAuthorities().contains(new SimpleGrantedAuthority(RoleName.ROLE_ADMIN.toString()))) {
			comment.setBody(commentRequest.getBody());
			return commentRepository.save(comment);
		}

		throw new BlogapiException(HttpStatus.UNAUTHORIZED, YOU_DON_T_HAVE_PERMISSION_TO + "update" + THIS_COMMENT);
	}

	@Override
	public ApiResponse deleteComment(Long postId, Long id, UserPrincipal currentUser) {
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException(POST_STR, ID_STR, postId));
		Comment comment = commentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(COMMENT_STR, ID_STR, id));

		if (!comment.getPost().getId().equals(post.getId())) {
			return new ApiResponse(Boolean.FALSE, COMMENT_DOES_NOT_BELONG_TO_POST);
		}

		if (comment.getUser().getId().equals(currentUser.getId())
				|| currentUser.getAuthorities().contains(new SimpleGrantedAuthority(RoleName.ROLE_ADMIN.toString()))) {
			commentRepository.deleteById(comment.getId());
			return new ApiResponse(Boolean.TRUE, "You successfully deleted comment");
		}

		throw new BlogapiException(HttpStatus.UNAUTHORIZED, YOU_DON_T_HAVE_PERMISSION_TO + "delete" + THIS_COMMENT);
	}
}
