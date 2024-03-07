package blogapi.crud.service;

import blogapi.crud.model.Tag;
import blogapi.crud.payload.ApiResponse;
import blogapi.crud.payload.PagedResponse;
import blogapi.crud.security.UserPrincipal;

public interface TagService {

	PagedResponse<Tag> getAllTags(int page, int size);

	Tag getTag(Long id);

	Tag addTag(Tag tag, UserPrincipal currentUser);

	Tag updateTag(Long id, Tag newTag, UserPrincipal currentUser);

	ApiResponse deleteTag(Long id, UserPrincipal currentUser);

}
