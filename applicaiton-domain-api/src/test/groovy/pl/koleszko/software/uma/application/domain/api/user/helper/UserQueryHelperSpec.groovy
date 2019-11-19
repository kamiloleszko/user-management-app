package pl.koleszko.software.uma.application.domain.api.user.helper

import pl.koleszko.software.uma.application.domain.api.user.dto.UserSearchParams
import pl.koleszko.software.uma.application.domain.model.repository.parameters.SearchConditions
import spock.lang.Specification

class UserQueryHelperSpec extends Specification {

    def "should return search condition"(){
        when:
        SearchConditions res = UserQueryHelper.createQuery(prepareUserSearchParamWithNameAndGrade())
        then:
        res.getCustomQuery() == "select * from User u where id is not null and name =:name and grade =:grade"
        res.getQueryParams().size() == 2
        res.queryParams.get("name") == "Anna"
        res.queryParams.get("grade") == 2
    }

    def prepareUserSearchParamWithNameAndGrade(){
        UserSearchParams searchParams = new UserSearchParams()
        searchParams.name = "Anna"
        searchParams.grade = 2
        return searchParams
    }
}
