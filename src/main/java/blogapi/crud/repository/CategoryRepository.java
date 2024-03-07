package blogapi.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blogapi.crud.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
