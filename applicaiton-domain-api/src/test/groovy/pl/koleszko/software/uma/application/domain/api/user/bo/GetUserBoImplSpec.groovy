package pl.koleszko.software.uma.application.domain.api.user.bo

import org.springframework.util.ReflectionUtils
import pl.koleszko.software.uma.application.domain.api.exception.UserException
import pl.koleszko.software.uma.application.domain.api.user.dto.UserDetailsDto
import pl.koleszko.software.uma.application.domain.api.user.validator.UserIdValidator
import pl.koleszko.software.uma.application.domain.model.repository.UserRepository
import pl.koleszko.software.uma.application.domain.model.user.User
import spock.lang.Specification

import java.lang.reflect.Field

class GetUserBoImplSpec extends Specification {

    def repository = Mock(UserRepository.class)
    def validator = new UserIdValidator(repository)
    def bo = new GetUserBoImpl(validator)

    def ID = 1L

    def "should return user with id 1"(){
        given:
        repository.findOne(ID) >> returnUser()

        when:
        UserDetailsDto result = bo.getUserById(ID)

        then:
        result.id == ID
        result.name == "name"
        result.surname == "surname"
        result.grade == 99
        result.salary == 5000
    }

    def "should throw UserException"(){
        given:
        repository.findOne(ID) >> null

        when:
        UserDetailsDto result = bo.getUserById(ID)

        then:
        thrown(UserException)
    }


    def returnUser(){
        User user = new User()
        setField("id", User.class, user, ID)
        user.name = "name"
        user.grade = 99
        user.surname = "surname"
        user.salary = 5000
        return user

    }

    def setField(name, activeClass, actualView, value) {
        Field field = ReflectionUtils.findField(activeClass, name)
        field.setAccessible(true)
        ReflectionUtils.setField(field, actualView, value)
    }
}
