package br.com.cinq.resource;

import br.com.cinq.model.City;
import br.com.cinq.service.CityService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author William
 */
@RestController
public class CityResource {

    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/cities/{id}")
    public City getCity(@PathVariable int id) {
        return cityService.getCity(id);
    }

    @PostMapping("/cities")
    public void loadCities() throws IOException {
        cityService.loadCities();
    }
}
