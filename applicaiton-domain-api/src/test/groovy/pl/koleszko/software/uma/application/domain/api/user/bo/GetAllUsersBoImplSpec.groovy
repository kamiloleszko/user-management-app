package pl.koleszko.software.uma.application.domain.api.user.bo

import org.assertj.core.util.Lists
import org.springframework.util.ReflectionUtils
import pl.koleszko.software.uma.application.domain.api.user.dto.UserDetailsDto
import pl.koleszko.software.uma.application.domain.model.repository.UserRepository
import pl.koleszko.software.uma.application.domain.model.user.User
import spock.lang.Specification

import java.lang.reflect.Field

class GetAllUsersBoImplSpec extends Specification {

    def repository = Mock(UserRepository.class)
    def bo = new GetAllUsersBoImpl(repository)

    def "should return all users"(){
        given:
        repository.findAll() >> returnUserList()
        when:
        List<UserDetailsDto> results = bo.getAllUsers()
        then:
        results.size() == 2
        results[0].name == "name1"
        results[1].surname == "surname2"
        results[0].grade == 1
        results[1].salary == 200
    }


    def returnUserList(){
        List<User> userList = Lists.newArrayList()
        userList.add(createUser(1L, "name1", "surname1", 1, 100))
        userList.add(createUser(2L, "name2", "surname2", 2, 200))
        return userList
    }

    def createUser(id, name, surname, grade, salary){
        User user = new User()
        setField("id", User.class, user, id)
        user.name = name
        user.grade = grade
        user.surname = surname
        user.salary = salary
        return user
    }

    def setField(name, activeClass, actualView, value) {
        Field field = ReflectionUtils.findField(activeClass, name)
        field.setAccessible(true)
        ReflectionUtils.setField(field, actualView, value)
    }
}
