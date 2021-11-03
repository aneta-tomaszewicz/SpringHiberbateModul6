package pl.coderslab.SpringHibernateModul6.dao;


import org.springframework.stereotype.Repository;
import pl.coderslab.SpringHibernateModul6.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    EntityManager entityManager;

    public void persist(Author author){
        entityManager.persist(author);
    }
    public Author findById(long id){
        return entityManager.find(Author.class, id);
    }
    public void update(Author author){
        entityManager.merge(author);
    }
    public void remove(long id){
        Author author = findById(id);
        entityManager.remove(entityManager.contains(author)? author : entityManager.merge(author));
    }
    public List<Author>findAll(){
        Query query = entityManager.createQuery("select a from Author a");
        return query.getResultList();
    }

}
