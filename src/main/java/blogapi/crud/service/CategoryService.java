package blogapi.crud.service;

import org.springframework.http.ResponseEntity;

import blogapi.crud.exception.UnauthorizedException;
import blogapi.crud.model.Category;
import blogapi.crud.payload.ApiResponse;
import blogapi.crud.payload.PagedResponse;
import blogapi.crud.security.UserPrincipal;

public interface CategoryService {

	PagedResponse<Category> getAllCategories(int page, int size);

	ResponseEntity<Category> getCategory(Long id);

	ResponseEntity<Category> addCategory(Category category, UserPrincipal currentUser);

	ResponseEntity<Category> updateCategory(Long id, Category newCategory, UserPrincipal currentUser)
			throws UnauthorizedException;

	ResponseEntity<ApiResponse> deleteCategory(Long id, UserPrincipal currentUser) throws UnauthorizedException;

}
