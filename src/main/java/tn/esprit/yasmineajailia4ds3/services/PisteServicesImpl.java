package tn.esprit.yasmineajailia4ds3.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.yasmineajailia4ds3.entities.Color;
import tn.esprit.yasmineajailia4ds3.entities.Piste;
import tn.esprit.yasmineajailia4ds3.entities.Skier;
import tn.esprit.yasmineajailia4ds3.repositories.IPisteRepository;
import tn.esprit.yasmineajailia4ds3.repositories.ISkierRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class PisteServicesImpl implements IPisteServices {



    private IPisteRepository pisteRepository;
    private ISkierRepository skierRepository;

    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste retrievePiste(Long numPiste) {
        return pisteRepository.findById(numPiste).orElse(null);
    }

    @Override
    public void removePiste(Long numPiste) {
        pisteRepository.deleteById(numPiste);
    }

    @Override
    public List<Piste> retrieveAll() {
        return List.of();
    }

    @Override
    public List<Piste> retrieveByColor(Color color) {
        return pisteRepository.findByColor(color);
    }

    @Override
    public Piste assignPisteToSkier(Long numPiste, Long numSkier) {
        Piste piste = pisteRepository.findById(numPiste).orElse(null);
        Skier skier = skierRepository.findById(numSkier).orElse(null);
        piste.getSkiers().add(skier);
        return pisteRepository.save(piste);
    }
}
