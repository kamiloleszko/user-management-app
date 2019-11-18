package pl.koleszko.software.uma.application.domain.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import pl.koleszko.software.uma.application.domain.model.repository.UserRepository;
import pl.koleszko.software.uma.application.domain.model.user.User;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootApplication
@EnableJpaRepositories(basePackages = "pl.koleszko.software.uma.application.domain")
@EntityScan(basePackages = "pl.koleszko.software.uma.application.domain")
@Transactional
public class UserIT {

    @Autowired
    private UserRepository repository;

    @Test
    public void testFindAll(){
        repository.findAll();
    }

    @Test
    public void testAddNew(){
        repository.save(User.of("name", "surname", 1, 1));
    }
}
