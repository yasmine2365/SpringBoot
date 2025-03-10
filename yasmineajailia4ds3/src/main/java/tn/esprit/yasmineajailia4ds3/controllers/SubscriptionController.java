package tn.esprit.yasmineajailia4ds3.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.yasmineajailia4ds3.entities.Subscription;
import tn.esprit.yasmineajailia4ds3.services.ISubscriptionServices;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("subscription")
public class SubscriptionController {

    private ISubscriptionServices subscriptionServices;

    @PostMapping("add")
    Subscription addSubscription(@RequestBody Subscription subscription) {
        return subscriptionServices.addSubscription(subscription);
    }

    @PutMapping("update")
    Subscription updateSubscription(@RequestBody Subscription subscription) {
        return subscriptionServices.updateSubscription(subscription);
    }

    @GetMapping("{id}")
    Subscription retrieveSubscription(@PathVariable Long id) {
        return subscriptionServices.retrieveSubscription(id);
    }

    @DeleteMapping("{id}")
    void removeSubscription(@PathVariable Long id) {
        subscriptionServices.removeSubscription(id);
    }

    @GetMapping("all")
    List<Subscription> retrieveAll() {
        return subscriptionServices.retrieveAll();
    }
}
