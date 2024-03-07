package blogapi.crud.service;

import blogapi.crud.model.Comment;
import blogapi.crud.payload.ApiResponse;
import blogapi.crud.payload.CommentRequest;
import blogapi.crud.payload.PagedResponse;
import blogapi.crud.security.UserPrincipal;

public interface CommentService {

	PagedResponse<Comment> getAllComments(Long postId, int page, int size);

	Comment addComment(CommentRequest commentRequest, Long postId, UserPrincipal currentUser);

	Comment getComment(Long postId, Long id);

	Comment updateComment(Long postId, Long id, CommentRequest commentRequest, UserPrincipal currentUser);

	ApiResponse deleteComment(Long postId, Long id, UserPrincipal currentUser);

}
