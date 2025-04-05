package tn.esprit.yasmineajailia4ds3.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.yasmineajailia4ds3.entities.Subscription;
import tn.esprit.yasmineajailia4ds3.entities.TypeSubscription;
import tn.esprit.yasmineajailia4ds3.repositories.ISubscriptionRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Service
@AllArgsConstructor
public class SubscriptionServicesImpl implements ISubscriptionServices{
    private ISubscriptionRepository subscriptionRepository;

    @Override
    public Subscription addSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription updateSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription retrieveSubscription(Long id) {
        return subscriptionRepository.findById(id).orElse(null);
    }

    @Override
    public void removeSubscription(Long id) {
        subscriptionRepository.deleteById(id);
    }

    @Override
    public List<Subscription> retrieveAll() {
        Iterable<Subscription> subscriptions = subscriptionRepository.findAll();
        return StreamSupport.stream(subscriptions.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Set<Subscription> getSubscriptionByType(TypeSubscription type) {
        return subscriptionRepository.findByTypeSubscription(type).stream()
                .sorted((s1, s2) -> s1.getStartDate().compareTo(s2.getStartDate()))
                .collect(Collectors.toSet());
    }

    @Override
    public List<Subscription> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate) {
        return subscriptionRepository.findByStartDateBetween(startDate, endDate);
    }


}
