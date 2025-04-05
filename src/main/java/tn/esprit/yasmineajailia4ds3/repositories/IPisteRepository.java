package tn.esprit.yasmineajailia4ds3.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.yasmineajailia4ds3.entities.Color;
import tn.esprit.yasmineajailia4ds3.entities.Piste;

import java.util.List;

public interface IPisteRepository extends CrudRepository<Piste, Long> {
    List<Piste> findByColor(Color color);
    List<Piste> findByNamePisteAndColor(String namePiste, Color color);
}
