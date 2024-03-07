package blogapi.crud.service;

import blogapi.crud.model.user.User;
import blogapi.crud.payload.ApiResponse;
import blogapi.crud.payload.InfoRequest;
import blogapi.crud.payload.UserIdentityAvailability;
import blogapi.crud.payload.UserProfile;
import blogapi.crud.payload.UserSummary;
import blogapi.crud.security.UserPrincipal;

public interface UserService {

	UserSummary getCurrentUser(UserPrincipal currentUser);

	UserIdentityAvailability checkUsernameAvailability(String username);

	UserIdentityAvailability checkEmailAvailability(String email);

	UserProfile getUserProfile(String username);

	User addUser(User user);

	User updateUser(User newUser, String username, UserPrincipal currentUser);

	ApiResponse deleteUser(String username, UserPrincipal currentUser);

	ApiResponse giveAdmin(String username);

	ApiResponse removeAdmin(String username);

	UserProfile setOrUpdateInfo(UserPrincipal currentUser, InfoRequest infoRequest);

}