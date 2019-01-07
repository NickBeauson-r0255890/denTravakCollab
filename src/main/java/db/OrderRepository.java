package db;

import model.SandwichOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

//@Repository
public interface OrderRepository extends CrudRepository<SandwichOrder, UUID> {


}
