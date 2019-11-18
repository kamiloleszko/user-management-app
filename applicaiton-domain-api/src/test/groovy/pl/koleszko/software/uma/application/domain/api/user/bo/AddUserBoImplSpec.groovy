package pl.koleszko.software.uma.application.domain.api.user.bo

import pl.koleszko.software.uma.application.domain.api.user.dto.UserInsertDto
import pl.koleszko.software.uma.application.domain.model.repository.UserRepository
import pl.koleszko.software.uma.application.domain.model.user.User
import spock.lang.Specification

class AddUserBoImplSpec extends Specification {

    def repository = Mock(UserRepository.class)
    def bo = new AddUserBoImpl(repository)

    def "should add new user"(){
        given:
        User user
        when:
        bo.addNewUser(prepareUserDto(true))
        then:
        1* repository.save(_) >> {arguments -> user = arguments[0]}
        user.name == "name"
        user.surname == "surname"
        user.grade == 1
        user.salary == 2000
    }

    def prepareUserDto(){
        UserInsertDto dto = new UserInsertDto()
            dto.name = "name"
        dto.surname = "surname"
        dto.grade = 1
        dto.salary = 2000
        return dto
    }
}
