package db;

import model.TravakOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.h2.expression.Function.CURRENT_DATE;

@Repository
public interface OrderRepository extends CrudRepository<TravakOrder, UUID> {


}
