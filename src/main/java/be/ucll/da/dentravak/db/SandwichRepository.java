package be.ucll.da.dentravak.db;

import be.ucll.da.dentravak.model.Sandwich;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

//@Repository
//@Component
public interface SandwichRepository extends CrudRepository<Sandwich, UUID> {


}
