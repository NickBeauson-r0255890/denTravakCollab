package controller;

import db.SandwichRepository;
import model.Sandwich;
import model.SandwichPreferences;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import javax.naming.ServiceUnavailableException;
import java.net.URI;
import java.util.Optional;
import java.util.UUID;

//import javax.inject.Inject;

@RestController
public class SandwichController {

    SandwichRepository repository;

    @Inject
    private SandwichRepository sandwichRepository;
    @Inject
    private DiscoveryClient discoveryClient;
    @Inject
    private RestTemplate restTemplate;


    @RequestMapping
    public String homepage() {
        return "Welkom bij Den Travak!";
    }

    @RequestMapping(value = "/sandwiches", method = RequestMethod.GET)
    public Iterable<Sandwich> getSandwiches() {
        try {
            SandwichPreferences preferences = getPreferences("ronald.dehuysser@ucll.be");
            //TODO: sort allSandwiches by float in preferences
            Iterable<Sandwich> allSandwiches = repository.findAll();
            return allSandwiches;
        } catch (ServiceUnavailableException e) {
            return repository.findAll();
        }
    }

    private Float rating(SandwichPreferences preferences, Sandwich sandwich) {
        return preferences.getRatingForSandwich(sandwich.getId());
    }

    @RequestMapping(value = "/sandwiches/{id}")
    public Sandwich getSandwich(@PathVariable("id") UUID id) {
        Sandwich sandwich = repository.findById(id).get();
        return sandwich;
    }

    @RequestMapping(value = "/sandwiches", method = RequestMethod.POST)
    public Sandwich addSandwich(@RequestBody Sandwich sandwich) {
        repository.save(sandwich);
        return sandwich;
    }

    @RequestMapping(value = "/sandwiches/{id}", method = RequestMethod.PUT)
    public Sandwich updateSandwich(@PathVariable("id") UUID id, @RequestBody Sandwich sandwich) {
        Sandwich OldSandwich = repository.findById(id).get();
        OldSandwich.setName(sandwich.getName());
        OldSandwich.setPrice(sandwich.getPrice());
        OldSandwich.setIngredients(sandwich.getIngredients());
        repository.save(OldSandwich);
        return OldSandwich;
    }

    @RequestMapping(value = "/deleteSandwich/{id}", method = RequestMethod.DELETE)
    public void deleteSandwich(@PathVariable("id") UUID id) {
        repository.deleteById(id);
    }




    public Optional<URI> recommendationServiceUrl() {
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
    }
}