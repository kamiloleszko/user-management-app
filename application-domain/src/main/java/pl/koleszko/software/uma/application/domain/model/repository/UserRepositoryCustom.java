package pl.koleszko.software.uma.application.domain.model.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import pl.koleszko.software.uma.application.domain.model.repository.parameters.SearchConditions;
import pl.koleszko.software.uma.application.domain.model.user.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<User> findUsers(SearchConditions searchConditions){
        Session session = (Session) this.entityManager.getDelegate();
        Query query = session
                .createSQLQuery(searchConditions.getCustomQuery())
                .addEntity(User.class);
        addQueryParameters(query, searchConditions);
        return query.list();
    }

    private void addQueryParameters(Query query, SearchConditions searchConditions){
        searchConditions.getQueryParams().forEach(query::setParameter);
    }
}