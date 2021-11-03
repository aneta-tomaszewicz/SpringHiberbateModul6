package pl.coderslab.SpringHibernateModul6.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.SpringHibernateModul6.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    EntityManager entityManager;

    public void persist(Publisher publisher){
        entityManager.persist(publisher);
    }
    public Publisher findById(long id){
        return entityManager.find(Publisher.class, id);
    }
    public void update(Publisher publisher){
        entityManager.merge(publisher);
    }
    public void remove(long id){
        Publisher publisher = findById(id);
        entityManager.remove(entityManager.contains(publisher) ? publisher : entityManager.merge(publisher));
    }
    public List<Publisher>findAll(){
        Query query = entityManager.createQuery("select p from Publisher p");
        return query.getResultList();
    }


}
