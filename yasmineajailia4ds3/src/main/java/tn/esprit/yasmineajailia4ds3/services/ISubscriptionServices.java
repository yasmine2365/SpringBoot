package tn.esprit.yasmineajailia4ds3.services;

import tn.esprit.yasmineajailia4ds3.entities.Subscription;

import java.util.List;

public interface ISubscriptionServices {
    Subscription addSubscription(Subscription subscription);
    Subscription updateSubscription(Subscription subscription);
    Subscription retrieveSubscription(Long id);
    void removeSubscription(Long id);
    List<Subscription> retrieveAll();
}
