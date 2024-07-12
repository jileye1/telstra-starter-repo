package au.com.telstra.simcardactivator;

import org.springframework.data.repository.CrudRepository;

public interface Repository extends CrudRepository<Sim, Long> {
    
}
