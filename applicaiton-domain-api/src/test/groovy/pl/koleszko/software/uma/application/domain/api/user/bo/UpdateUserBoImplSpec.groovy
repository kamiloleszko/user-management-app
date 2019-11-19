package pl.koleszko.software.uma.application.domain.api.user.bo

import org.springframework.util.ReflectionUtils
import pl.koleszko.software.uma.application.domain.api.exception.UserException
import pl.koleszko.software.uma.application.domain.api.user.dto.UserDetailsDto
import pl.koleszko.software.uma.application.domain.api.user.dto.UserInsertDto
import pl.koleszko.software.uma.application.domain.api.user.validator.UserIdValidator
import pl.koleszko.software.uma.application.domain.model.repository.UserRepository
import pl.koleszko.software.uma.application.domain.model.user.User
import spock.lang.Specification

import java.lang.reflect.Field

class UpdateUserBoImplSpec extends Specification {

    def repository = Mock(UserRepository.class)
    def validator = new UserIdValidator(repository)
    def bo = new UpdateUserBoImpl(repository, validator)

    def ID = 1L

    def "should update user name and surname"(){
        given:
        User user
        repository.findOne(ID) >> returnUser()

        when:
        UserDetailsDto result = bo.updateUser(returnUpdateNameAndSurnameUser(), ID)

        then:
        1* repository.save(_) >> {arguments -> user = arguments[0] }
        user.name == "name2"
        result.name == "name2"
        result.surname == "surname2"
        result.grade == 99
        result.salary == 5000
        result.id == ID
    }

    def "should update all user information"(){
        given:
        User user
        repository.findOne(ID) >> returnUser()

        when:
        UserDetailsDto result = bo.updateUser(returnUpdateUser(), ID)

        then:
        1* repository.save(_) >> {arguments -> user = arguments[0] }
        user.name == "name2"
        result.name == "name2"
        result.surname == "surname2"
        result.grade == 11
        result.salary == 99
        result.id == ID
    }

    def "should throw UserException"(){
        given:
        repository.findOne(ID) >> null

        when:
        bo.updateUser(returnUpdateUser(), ID)

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

    def returnUpdateNameAndSurnameUser(){
        UserInsertDto dto = new UserInsertDto()
        dto.name = "name2"
        dto.surname = "surname2"
        return dto
    }

    def returnUpdateUser(){
        UserInsertDto dto = new UserInsertDto()
        dto.name = "name2"
        dto.surname = "surname2"
        dto.grade = 11
        dto.salary = 99
        return dto
    }

    def setField(name, activeClass, actualView, value) {
        Field field = ReflectionUtils.findField(activeClass, name)
        field.setAccessible(true)
        ReflectionUtils.setField(field, actualView, value)
    }
}
