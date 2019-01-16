package be.ucll.da.dentravak.controller;

import be.ucll.da.dentravak.db.SandwichRepository;
import be.ucll.da.dentravak.model.Sandwich;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

//import javax.inject.Inject;

@RestController
public class SandwichController {

    @Autowired
    SandwichRepository sandwichRepository;


    public SandwichController(SandwichRepository sandwichRepository) {
        this.sandwichRepository = sandwichRepository;
    }
    /*
    @Inject
    private SandwichRepository sandwichRepository;
    @Inject
    private DiscoveryClient discoveryClient;
    @Inject
    private RestTemplate restTemplate;
*/

    @RequestMapping
    public String homepage() {
        return "Welkom bij Den Travak!";
    }

    @RequestMapping(value = "/sandwiches", method = RequestMethod.GET)
    public Iterable<Sandwich> getSandwiches() {
       // try {
           // SandwichPreferences preferences = getPreferences("ronald.dehuysser@ucll.be");
            //TODO: sort allSandwiches by float in preferences
            Iterable<Sandwich> allSandwiches = sandwichRepository.findAll();
            return allSandwiches;
       // } catch (ServiceUnavailableException e) {
          //  return sandwichRepository.findAll();
        //}
    }

  /*  private Float rating(SandwichPreferences preferences, Sandwich sandwich) {
        return preferences.getRatingForSandwich(sandwich.getId());
    }*/

    @RequestMapping(value = "/sandwiches/{id}")
    public Sandwich getSandwich(@PathVariable("id") UUID id) {
        Sandwich sandwich = sandwichRepository.findById(id).get();
        return sandwich;
    }

    @RequestMapping(value = "/sandwiches", method = RequestMethod.POST)
    public Sandwich addSandwich(@RequestBody Sandwich sandwich) {
        sandwichRepository.save(sandwich);
        return sandwich;
    }

    @RequestMapping(value = "/sandwiches/{id}", method = RequestMethod.PUT)
    public Sandwich updateSandwich(@PathVariable("id") UUID id, @RequestBody Sandwich sandwich) {
        Sandwich OldSandwich = sandwichRepository.findById(id).get();
        OldSandwich.setName(sandwich.getName());
        OldSandwich.setPrice(sandwich.getPrice());
        OldSandwich.setIngredients(sandwich.getIngredients());
        sandwichRepository.save(OldSandwich);
        return OldSandwich;
    }

    @RequestMapping(value = "/deleteSandwich/{id}", method = RequestMethod.DELETE)
    public void deleteSandwich(@PathVariable("id") UUID id) {
        sandwichRepository.deleteById(id);
    }




  /*  public Optional<URI> recommendationServiceUrl() {
        return discoveryClient.getInstances("recommendation")
                .stream()
                .map(si -> si.getUri())
                .findFirst();
    }

    @GetMapping("/getpreferences/{emailAddress}")
    public SandwichPreferences getPreferences(@PathVariable String emailAddress) throws RestClientException, ServiceUnavailableException {
        URI service = recommendationServiceUrl()
                .map(s -> s.resolve("/recommendation/recommend/" + emailAddress))
                .orElseThrow(ServiceUnavailableException::new);
        return restTemplate
                .getForEntity(service, SandwichPreferences.class)
                .getBody();
    }*/
}