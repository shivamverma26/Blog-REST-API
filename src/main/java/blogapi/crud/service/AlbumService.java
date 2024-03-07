package blogapi.crud.service;

import org.springframework.http.ResponseEntity;

import blogapi.crud.model.Album;
import blogapi.crud.payload.AlbumResponse;
import blogapi.crud.payload.ApiResponse;
import blogapi.crud.payload.PagedResponse;
import blogapi.crud.payload.request.AlbumRequest;
import blogapi.crud.security.UserPrincipal;

public interface AlbumService {

	PagedResponse<AlbumResponse> getAllAlbums(int page, int size);

	ResponseEntity<Album> addAlbum(AlbumRequest albumRequest, UserPrincipal currentUser);

	ResponseEntity<Album> getAlbum(Long id);

	ResponseEntity<AlbumResponse> updateAlbum(Long id, AlbumRequest newAlbum, UserPrincipal currentUser);

	ResponseEntity<ApiResponse> deleteAlbum(Long id, UserPrincipal currentUser);

	PagedResponse<Album> getUserAlbums(String username, int page, int size);

}
