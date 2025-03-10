package tn.esprit.yasmineajailia4ds3.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.yasmineajailia4ds3.entities.Course;
import tn.esprit.yasmineajailia4ds3.entities.Piste;
import tn.esprit.yasmineajailia4ds3.entities.Registration;
import tn.esprit.yasmineajailia4ds3.entities.Skier;
import tn.esprit.yasmineajailia4ds3.repositories.IPisteRepository;
import tn.esprit.yasmineajailia4ds3.repositories.ISkierRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class SkierServicesImpl implements ISkierServices {
    private ISkierRepository skierRepository;
    private IPisteRepository pisteRepository;
    @Override
    public Skier addSkier(Skier skier) {
        return skierRepository.save(skier);
    }

    @Override
    public Skier updateSkier(Skier skier) {
        return skierRepository.save(skier);
    }

    @Override
    public Skier retrieveSkier(Long numSkier) {
        return skierRepository.findById(numSkier).orElse(null);
    }

    @Override
    public void removeSkier(Long numSkier) {
        skierRepository.deleteById(numSkier);
    }

    @Override
    public List<Skier> retrieveAll() {

        Iterable<Skier> skiers = skierRepository.findAll();
        return StreamSupport.stream(skiers.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Skier assignSkierToPiste(Long numSkier, Long numPiste) {
        Skier skier = skierRepository.findById(numSkier).orElse(null);
        Piste piste = pisteRepository.findById(numPiste).orElse(null);
        if (skier != null && piste != null) {
            skier.setPiste(piste);
            return skierRepository.save(skier);
        }
    }


}
