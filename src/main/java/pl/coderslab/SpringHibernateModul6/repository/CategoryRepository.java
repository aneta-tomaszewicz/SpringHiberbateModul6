package pl.coderslab.SpringHibernateModul6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.SpringHibernateModul6.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
