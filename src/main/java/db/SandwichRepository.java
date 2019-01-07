package db;

import model.Sandwich;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

//@Repository
//@Component
public interface SandwichRepository extends CrudRepository<Sandwich, UUID> {


}
