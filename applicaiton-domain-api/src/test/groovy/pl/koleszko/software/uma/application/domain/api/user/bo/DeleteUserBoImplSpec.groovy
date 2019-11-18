package pl.koleszko.software.uma.application.domain.api.user.bo

import pl.koleszko.software.uma.application.domain.api.exception.UserException
import pl.koleszko.software.uma.application.domain.api.user.validator.UserIdValidator
import pl.koleszko.software.uma.application.domain.model.repository.UserRepository
import pl.koleszko.software.uma.application.domain.model.user.User
import spock.lang.Specification

class DeleteUserBoImplSpec extends Specification {

    def repository = Mock(UserRepository.class)
    def validator = new UserIdValidator(repository)
    def bo = new DeleteUserBoImpl(repository, validator)
    def ID = 1L

    def "should delete user with given Id"(){
        given:
        repository.findOne(ID) >> new User()

        when:
        bo.deleteUser(ID)

        then:
        1* repository.delete(ID)
    }

    def "should throw UserException"(){
        given:
        repository.findOne(ID) >> null

        when:
        bo.deleteUser(ID)

        then:
        thrown(UserException)
    }
}