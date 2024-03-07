package blogapi.crud.service;

import blogapi.crud.model.Post;
import blogapi.crud.payload.ApiResponse;
import blogapi.crud.payload.PagedResponse;
import blogapi.crud.payload.PostRequest;
import blogapi.crud.payload.PostResponse;
import blogapi.crud.security.UserPrincipal;

public interface PostService {

	PagedResponse<Post> getAllPosts(int page, int size);

	PagedResponse<Post> getPostsByCreatedBy(String username, int page, int size);

	PagedResponse<Post> getPostsByCategory(Long id, int page, int size);

	PagedResponse<Post> getPostsByTag(Long id, int page, int size);

	Post updatePost(Long id, PostRequest newPostRequest, UserPrincipal currentUser);

	ApiResponse deletePost(Long id, UserPrincipal currentUser);

	PostResponse addPost(PostRequest postRequest, UserPrincipal currentUser);

	Post getPost(Long id);

}
