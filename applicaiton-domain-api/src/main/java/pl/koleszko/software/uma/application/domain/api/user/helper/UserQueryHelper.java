package pl.koleszko.software.uma.application.domain.api.user.helper;

import org.springframework.util.StringUtils;
import pl.koleszko.software.uma.application.domain.api.user.dto.UserSearchParams;
import pl.koleszko.software.uma.application.domain.model.repository.parameters.SearchConditions;

public final class UserQueryHelper {

    private final static String QUERY_BASIC = "select * from User u where id is not null";

    private UserQueryHelper() {
    }

    public static SearchConditions createQuery(UserSearchParams searchParams){
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append(QUERY_BASIC);
        return prepareSearchConditions(queryBuilder, searchParams, new SearchConditions());
    }

    private static SearchConditions prepareSearchConditions(StringBuilder query, UserSearchParams searchParams, SearchConditions
            searchConditions){

        if (!StringUtils.isEmpty(searchParams.getName())){
            query.append(" and name =:name");
            searchConditions.getQueryParams().put("name", searchParams.getName());
        }

        if (!StringUtils.isEmpty(searchParams.getSurname())){
            query.append(" and surname =:surname");
            searchConditions.getQueryParams().put("surname", searchParams.getSurname());
        }

        if (searchParams.getGrade() != null){
            query.append(" and grade =:grade");
            searchConditions.getQueryParams().put("grade", searchParams.getGrade());
        }

        if (searchParams.getSalary() != null){
            query.append(" and salary =:salary");
            searchConditions.getQueryParams().put("salary", searchParams.getSalary());
        }

        searchConditions.setCustomQuery(query.toString());
        return searchConditions;
    }
}
