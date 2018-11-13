package db;

import model.Sandwich;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public interface SandwichRepository extends CrudRepository<Sandwich, UUID> {

    public List<Sandwich> findAll();
}
