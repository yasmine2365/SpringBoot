package tn.esprit.yasmineajailia4ds3.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.yasmineajailia4ds3.entities.Subscription;
import tn.esprit.yasmineajailia4ds3.entities.TypeSubscription;
import tn.esprit.yasmineajailia4ds3.services.ISubscriptionServices;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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

    @GetMapping("/by-type")
    public Set<Subscription> getSubscriptionByType(@RequestParam TypeSubscription type) {
        return subscriptionServices.getSubscriptionByType(type);
    }
    @GetMapping("/by-dates")
    public List<Subscription> retrieveSubscriptionsByDates(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return subscriptionServices.retrieveSubscriptionsByDates(startDate, endDate);
    }
}
