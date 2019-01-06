package db;

import model.Sandwich;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
//@Component
public interface SandwichRepository extends CrudRepository<Sandwich, UUID> {


}
