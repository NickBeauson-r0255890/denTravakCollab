import db.OrderRepository;
import model.SandwichOrder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class RepositoryTest {
    @Autowired
    private OrderRepository repository;

    @Test
    public void findByDate() throws ParseException {
        List<SandwichOrder> result = repository.findAllByCreationDate(
                new SimpleDateFormat("yyyy-MM-dd").parse("2018-11-18"));

    }
}
