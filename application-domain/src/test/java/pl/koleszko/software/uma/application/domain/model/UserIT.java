package pl.koleszko.software.uma.application.domain.model;

import org.assertj.core.groups.Tuple;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import pl.koleszko.software.uma.application.domain.model.repository.UserRepository;
import pl.koleszko.software.uma.application.domain.model.repository.UserRepositoryCustom;
import pl.koleszko.software.uma.application.domain.model.repository.parameters.SearchConditions;
import pl.koleszko.software.uma.application.domain.model.user.User;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

@RunWith(SpringRunner.class)
@SpringBootApplication
@EnableJpaRepositories(basePackages = "pl.koleszko.software.uma.application.domain")
@EntityScan(basePackages = "pl.koleszko.software.uma.application.domain")
@Transactional
public class UserIT {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserRepositoryCustom repositoryCustom;

    @Test
    public void testFindAll(){
        List<User> res = repository.findAll();
        assertThat(res)
                .hasSize(6)
                .extracting("name", "salary")
                .contains(
                        Tuple.tuple("Krzysztof", 4000),
                        tuple("Aneta", 4000));
    }

    @Test
    public void testAddNew(){
        repository.save(User.of("name", "surname", 1, 1));
    }

    @Test
    public void searchByParams(){
        SearchConditions searchConditions = new SearchConditions();
        searchConditions.getQueryParams().put("grade", 2);
        searchConditions.setCustomQuery("select * from user where grade =:grade");
        List<User> res = repositoryCustom.findUsers(searchConditions);
        assertThat(res).hasSize(2);
    }
}
