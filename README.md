
# Spring Boot, MySQL, Spring Security, JWT, JPA, Rest API

Build Restful CRUD API for a blog using Spring Boot, Mysql, JPA and Hibernate.

## Getting Started


Welcome to the **Spring Boot Blog REST API** project! This repository provides an example of building a RESTful API using **Spring Boot**. Let's dive into the details:



##  Introduction

The purpose of this project is to showcase the implementation of a RESTful API for a blog application. Whether you're a beginner or an experienced developer, this project provides valuable insights into building APIs with Spring Boot.

To run this project locally, follow these steps:

1. **Clone the Repository**:
   - Begin by cloning the repository to your local machine:<br>
     ```
     git clone https://github.com/coma123/Spring-Boot-Blog-REST-API.git
     ```

2. **Navigate to the Project Directory**:<br>
   - Change into the cloned project directory:
     ```
     cd Spring-Boot-Blog-REST-API
     ```

3. **Build and Run the Application**:
   - Execute the following command to build and run the Spring Boot application:
     ```
     ./mvnw spring-boot:run
     ```

4. **Access the API**:
   - The API will be available at `http://localhost:8080`.

##  Project Structure

The project adheres to best practices for organizing a Spring Boot application:

- `src/main/java/com/example/blog`: Contains the main application code.
  - `controller`: Handles incoming HTTP requests.
  - `model`: Defines data models (e.g., blog posts, comments).
  - `repository`: Manages data persistence (using JPA).
  - `service`: Implements business logic.
- `src/main/resources`: Contains configuration files (e.g., `application.properties`).


### Spring REST Docs

We use **Spring REST Docs** to generate accurate and concise API documentation. This approach combines hand-written documentation (using **Asciidoctor**) with auto-generated snippets produced by **Spring MVC Test**. The result is high-quality documentation that goes beyond what tools like Swagger provide.

Learn more about **Spring REST Docs** on the official [Spring REST Docs page](https://spring.io/projects/spring-restdocs/).

##  Best Practices

The project follows best practices for building RESTful APIs with Spring Boot:

- Use meaningful endpoints.
- Implement proper error handling.
- Validate input data.
- Follow RESTful conventions (e.g., HTTP methods, status codes).

##  Exception Handling

We handle exceptions gracefully by providing clear error messages and appropriate HTTP status codes. The global exception handler ensures consistent behavior across the API.




## Steps to Setup

### Prerequisites

- Java Development Kit (JDK) 8 or later
- Maven

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/coma123/Spring-Boot-Blog-REST-API.git

**2. Create Mysql database**
```bash
create database blogapi
```
- run `src/main/resources/blogapi.sql`

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`
+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Run the app using maven**

```bash
mvn spring-boot:run
```
The app will start running at <http://localhost:8080>

## Explore Rest APIs


The application defines the following CRUD APIs:
- Auth
- Users
- Posts
- Comments
- Albums
- Photos
- Todos

##API Documentation

### Auth

| Method | Url | Decription | Sample Valid Request Body | 
| ------ | --- | ---------- | --------------------------- |
| POST   | /api/auth/signup | Sign up | [JSON](#signup) |
| POST   | /api/auth/signin | Log in | [JSON](#signin) |

### Users

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /api/users/me | Get logged in user profile | |
| GET    | /api/users/{username}/profile | Get user profile by username | |
| GET    | /api/users/{username}/posts | Get posts created by user | |
| GET    | /api/users/{username}/albums | Get albums created by user | |
| GET    | /api/users/checkUsernameAvailability | Check if username is available to register | |
| GET    | /api/users/checkEmailAvailability | Check if email is available to register | |
| POST   | /api/users | Add user (Only for admins) | [JSON](#usercreate) |
| PUT    | /api/users/{username} | Update user (If profile belongs to logged in user or logged in user is admin) | [JSON](#userupdate) |
| DELETE | /api/users/{username} | Delete user (For logged in user or admin) | |
| PUT    | /api/users/{username}/giveAdmin | Give admin role to user (only for admins) | |
| PUT    | /api/users/{username}/TakeAdmin | Take admin role from user (only for admins) | |
| PUT    | /api/users/setOrUpdateInfo | Update user profile (If profile belongs to logged in user or logged in user is admin) | [JSON](#userinfoupdate) |

### Posts

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /api/posts | Get all posts | |
| GET    | /api/posts/{id} | Get post by id | |
| POST   | /api/posts | Create new post (By logged in user) | [JSON](#postcreate) |
| PUT    | /api/posts/{id} | Update post (If post belongs to logged in user or logged in user is admin) | [JSON](#postupdate) |
| DELETE | /api/posts/{id} | Delete post (If post belongs to logged in user or logged in user is admin) | |

### Comments

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /api/posts/{postId}/comments | Get all comments which belongs to post with id = postId | |
| GET    | /api/posts/{postId}/comments/{id} | Get comment by id if it belongs to post with id = postId | |
| POST   | /api/posts/{postId}/comments | Create new comment for post with id = postId (By logged in user) | [JSON](#commentcreate) |
| PUT    | /api/posts/{postId}/comments/{id} | Update comment by id if it belongs to post with id = postId (If comment belongs to logged in user or logged in user is admin) | [JSON](#commentupdate) |
| DELETE | /api/posts/{postId}/comments/{id} | Delete comment by id if it belongs to post with id = postId (If comment belongs to logged in user or logged in user is admin) | |

### Albums

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /api/albums | Get all albums | |
| GET    | /api/albums/{id} | Get album by id | |
| POST   | /api/albums | Create new album (By logged in user) | [JSON](#albumcreate) |
| PUT    | /api/albums/{id} | Update album (If album belongs to logged in user or logged in user is admin) | [JSON](#albumupdate) |
| DELETE | /api/albums/{id} | Delete album (If album belongs to logged in user or logged in user is admin) | |
| GET    | /api/albums/{id}/photos | Get all photos which belongs to album with id = id | |

### Photos

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /api/photos | Get all photos | |
| GET    | /api/photos/{id} | Get photo by id | |
| POST   | /api/photos | Create new photo (By logged in user) | [JSON](#photocreate) |
| PUT    | /api/photos/{id} | Update photo (If photo belongs to logged in user or logged in user is admin) | [JSON](#photoupdate) |
| DELETE | /api/photos/{id} | Delete photo (If photo belongs to logged in user or logged in user is admin) | |

### Todos

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /api/todos | Get all todos which belongs to logged in user | |
| GET    | /api/todos/{id} | Get todo by id (If todo belongs to logged in user) | |
| POST   | /api/todos | Create new todo (By logged in user) | [JSON](#todocreate) |
| PUT    | /api/todos/{id} | Update todo (If todo belongs to logged in user) | [JSON](#todoupdate) |
| DELETE | /api/todos/{id} | Delete todo (If todo belongs to logged in user) | |
| PUT    | /api/todos/{id}/complete | Mark todo as complete (If todo belongs to logged in user) | |
| PUT    | /api/todos/{id}/unComplete | Mark todo as uncomplete (If todo belongs to logged in user) | |

Test them using postman or any other rest client.

## Sample Valid JSON Request Bodys

##### <a id="signup">Sign Up -> /api/auth/signup</a>
```json
{
	"firstName": "Leanne",
	"lastName": "Graham",
	"username": "leanne",
	"password": "password",
	"email": "leanne.graham@gmail.com"
}
```

##### <a id="signin">Log In -> /api/auth/signin</a>
```json
{
	"usernameOrEmail": "leanne",
	"password": "password"
}
```

##### <a id="usercreate">Create User -> /api/users</a>
```json
{
	"firstName": "Ervin",
	"lastName": "Howell",
	"username": "ervin",
	"password": "password",
	"email": "ervin.howell@gmail.com",
	"address": {
		"street": "Victor Plains",
		"suite": "Suite 879",
		"city": "Wisokyburgh",
		"zipcode": "90566-7771",
		"geo": {
			"lat": "-43.9509",
			"lng": "-34.4618"
		}
	},
	"phone": "010-692-6593 x09125",
	"website": "http://erwinhowell.com",
	"company": {
		"name": "Deckow-Crist",
		"catchPhrase": "Proactive didactic contingency",
		"bs": "synergize scalable supply-chains"
	}
}
```

##### <a id="userupdate">Update User -> /api/users/{username}</a>
```json
{
	"firstName": "Ervin",
	"lastName": "Howell",
	"username": "ervin",
	"password": "updatedpassword",
	"email": "ervin.howell@gmail.com",
	"address": {
		"street": "Victor Plains",
		"suite": "Suite 879",
		"city": "Wisokyburgh",
		"zipcode": "90566-7771",
		"geo": {
			"lat": "-43.9509",
			"lng": "-34.4618"
		}
	},
	"phone": "010-692-6593 x09125",
	"website": "http://erwinhowell.com",
	"company": {
		"name": "Deckow-Crist",
		"catchPhrase": "Proactive didactic contingency",
		"bs": "synergize scalable supply-chains"
	}
}
```

##### <a id="userinfoupdate">Update User Profile -> /api/users/setOrUpdateInfo</a>
```json
{
	"street": "Douglas Extension",
	"suite": "Suite 847",
	"city": "McKenziehaven",
	"zipcode": "59590-4157",
	"companyName": "Romaguera-Jacobson",
	"catchPhrase": "Face to face bifurcated interface",
	"bs": "e-enable strategic applications",
	"website": "http://ramiro.info",
	"phone": "1-463-123-4447",
	"lat": "-68.6102",
	"lng": "-47.0653"
}
```

##### <a id="postcreate">Create Post -> /api/posts</a>
```json
{
	"title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
	"body": "quia et suscipit suscipit recusandae consequuntur expedita et cum reprehenderit molestiae ut ut quas totam nostrum rerum est autem sunt rem eveniet architecto"
}
```

##### <a id="postupdate">Update Post -> /api/posts/{id}</a>
```json
{
	"title": "UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED",
	"body": "UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED "
}
```

##### <a id="commentcreate">Create Comment -> /api/posts/{postId}/comments</a>
```json
{
	"body": "laudantium enim quasi est quidem magnam voluptate ipsam eos tempora quo necessitatibus dolor quam autem quasi reiciendis et nam sapiente accusantium"
}
```

##### <a id="commentupdate">Update Comment -> /api/posts/{postId}/comments/{id}</a>
```json
{
	"body": "UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED UPDATED "
}
```

##### <a id="albumcreate">Create Album -> /api/albums</a>
```json
{
	"title": "quidem molestiae enim"
}
```

##### <a id="albumupdate">Update Album -> /api/albums/{id}</a>
```json
{
	"title": "quidem molestiae enim UPDATED"
}
```

##### <a id="photocreate">Create Photo -> /api/photos</a>
```json
{
	"title": "accusamus beatae ad facilis cum similique qui sunt",
	"url": "https://via.placeholder.com/600/92c952",
	"thumbnailUrl": "https://via.placeholder.com/150/92c952",
	"albumId": 2
}
```

##### <a id="photoupdate">Update Photo -> /api/photos{id}</a>
```json
{
	"title": "accusamus beatae ad facilis ",
	"url": "https://via.placeholder.com/600/771796",
	"thumbnailUrl": "https://via.placeholder.com/150/771796",
	"albumId": 4
}
```

##### <a id="todocreate">Create Todo -> /api/todos</a>
```json
{
	"title": "delectus aut autem",
	"completed": false
}
```

##### <a id="todoupdate">Update Todo -> /api/todos{id}</a>
```json
{
	"title": "delectus aut autem Updated",
	"completed": true
}
```

# Usage

Test these APIs using Postman or any other REST client.


## Additional Resources

Explore these resources to deepen your understanding of Spring Boot and RESTful APIs:

- [Building RESTful APIs with Spring Boot: An In-Depth Guide](https://medium.com/@kavindapvt/building-restful-apis-with-spring-boot-an-in-depth-guide-43aa942e40cc)
- [Spring Boot Rest API Tutorial: Best Practices and Examples](https://pwskills.com/blog/spring-boot-rest-api-tutorial-best-practices-and-examples/)
- [Documenting a Spring REST API Using OpenAPI 3.0](https://www.baeldung.com/spring-rest-openapi-documentation)

Feel free to contribute, explore, and learn from this project! 🌟

