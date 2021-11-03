package pl.coderslab.SpringHibernateModul6.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.SpringHibernateModul6.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDao {

    @PersistenceContext
    EntityManager entityManager;

    public void persist(Person person){
        entityManager.persist(person);
    }

    public Person findById(long id){
        return entityManager.find(Person.class, id);
    }

    public Person update(Person person){
        return entityManager.merge(person);
    }

    public void remove(Person person){
        entityManager.remove(entityManager.contains(person) ? person : entityManager.merge(person));
    }
}
