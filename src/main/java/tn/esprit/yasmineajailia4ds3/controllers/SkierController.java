package tn.esprit.yasmineajailia4ds3.controllers;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.yasmineajailia4ds3.entities.Skier;
import tn.esprit.yasmineajailia4ds3.entities.TypeSubscription;
import tn.esprit.yasmineajailia4ds3.services.ISkierServices;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("skier")
public class SkierController {

    private ISkierServices skierServices;
    @PostMapping("add")
    Skier addSkier(@RequestBody Skier skier){
        return skierServices.addSkier(skier);
    }
    @GetMapping("{id}")
    Skier retrieveSkier(@PathVariable Long id) {
        return skierServices.retrieveSkier(id);
    }

    @DeleteMapping("{id}")
    void removeSkier(@PathVariable Long id) {
        skierServices.removeSkier(id);
    }

    @GetMapping("all")
    List<Skier> retrieveAll() {
        return skierServices.retrieveAll();
    }
    @GetMapping("/by-subscription-type")
    public List<Skier> retrieveSkiersBySubscriptionType(@RequestParam TypeSubscription typeSubscription) {
        return skierServices.retrieveSkiersBySubscriptionType(typeSubscription);
    }

}
