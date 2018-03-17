package br.com.cinq.service;

import br.com.cinq.model.Country;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;

/**
 * @author William
 */
@Service
public class CountryService extends GenericService<Country, Integer> {

    private final Logger log = Logger.getLogger(CountryService.class.getName());

    @Inject
    public CountryService(EntityManager em) {
        this.em = em;
    }
}
