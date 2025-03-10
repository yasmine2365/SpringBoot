package tn.esprit.yasmineajailia4ds3.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.yasmineajailia4ds3.entities.Color;
import tn.esprit.yasmineajailia4ds3.entities.Piste;
import tn.esprit.yasmineajailia4ds3.services.IPisteServices;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("piste")
public class PisteController {


    private IPisteServices pisteServices;
    @GetMapping("all")
    public List<Piste> retrieveAll(){
        return pisteServices.retrieveAll();

    }
    @PostMapping("add")
    Piste addPiste(@RequestBody Piste piste){
        return pisteServices.addPiste(piste);
    }
    @PutMapping("update")
    Piste updatePiste(@RequestBody Piste piste){
        return pisteServices.updatePiste(piste);
    }
    @GetMapping("get/{numPiste}")
    Piste retrievePiste(@PathVariable Long numPiste){
        return pisteServices.retrievePiste(numPiste);
    }
    @DeleteMapping("remove/{numPiste}")
    void removePiste(@PathVariable Long numPiste){
        pisteServices.removePiste(numPiste);
    }
    @GetMapping("getByColor/{color}")
    public List<Piste> retrieveByColor(@PathVariable Color color){
        return pisteServices.retrieveByColor(color);
    }
    @GetMapping("assignToSkier/{numSkier}")
    public Piste assignPisteToSkier(Long numPiste,Long numSkier){
        return pisteServices.assignPisteToSkier(numPiste,numSkier);
    }
}
