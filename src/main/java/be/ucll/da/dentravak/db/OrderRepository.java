package be.ucll.da.dentravak.db;

import be.ucll.da.dentravak.model.SandwichOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

//@Repository
public interface OrderRepository extends CrudRepository<SandwichOrder, UUID> {


}
