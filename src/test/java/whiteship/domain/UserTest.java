package whiteship.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import whiteship.Application;
import whiteship.service.AddressRepository;
import whiteship.service.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
@ActiveProfiles("test")
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class UserTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;

    @Before
    public void setUp() {
        userRepository.deleteAll();
        addressRepository.deleteAll();
    }

    @Test
    public void addingAddress() {
        User yoon = new User();
        yoon.setName("Yoon");
        userRepository.save(yoon);

        Address address = new Address();
        address.setCity("San Hose");
        addressRepository.save(address);

        yoon.setAddress(address);
    }

}
