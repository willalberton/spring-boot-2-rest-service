package br.com.cinq.service;

import br.com.cinq.exception.NotFoundException;
import br.com.cinq.model.City;
import br.com.cinq.model.Country;
import br.com.cinq.model.QCity;
import static br.com.cinq.model.QCountry.country;
import com.mysema.query.jpa.impl.JPAQuery;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Service;
import processor.StreamProcessorImpl;
import java.util.logging.Logger;
import javax.transaction.Transactional;
import org.apache.commons.lang.StringUtils;

/**
 * @author William
 */
@Service
public class CityService extends GenericService<City, Integer> {

    private final Logger log = Logger.getLogger(CityService.class.getName());

    @Inject
    public CityService(EntityManager em) {
        this.em = em;
    }

    @Inject
    private CountryService countryService;

    public List<City> getAllCities() {

        JPAQuery query = new JPAQuery(em);

        QCity qCity = QCity.city;
        query.from(qCity);

        return query.list(qCity);
    }

    public City getCity(Integer id) {

        JPAQuery query = new JPAQuery(em);

        QCity qCity = QCity.city;
        query.from(qCity);
        query.where(qCity.id.eq(id));

        Optional<City> city = Optional.ofNullable(query.singleResult(qCity));
        city.orElseThrow(() -> new NotFoundException("City not found!"));

        return city.get();
    }

    @Transactional
    public void loadCities() {

        StreamProcessorImpl streamProcessorImpl = new StreamProcessorImpl();

        List<String> lines = streamProcessorImpl.readLines("cities.txt");

        lines.forEach((line) -> {

            String[] sb = line.split(",");

            Country country = new Country();
            country.setName(StringUtils.trim(sb[1]));

            City city = new City();
            city.setName(sb[0]);
            city.setCountry(country);

            try {
                countryService.save(country);
                this.save(city);
            } catch (Exception ex) {
                ex.printStackTrace();
                log.severe("Error ocorred on save city " + line);
                System.exit(1);
            }
        });
    }
}
