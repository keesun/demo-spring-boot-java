package whiteship.service;

import org.springframework.data.jpa.repository.JpaRepository;
import whiteship.domain.Address;

/**
 * @author Keesun Baik
 */
public interface AddressRepository extends JpaRepository<Address, Long>{
}
