package tn.esprit.yasmineajailia4ds3.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.yasmineajailia4ds3.entities.Subscription;
import tn.esprit.yasmineajailia4ds3.entities.TypeSubscription;

import java.time.LocalDate;
import java.util.List;

public interface ISubscriptionRepository extends CrudRepository<Subscription, Long> {
    List<Subscription> findByTypeSubscription(TypeSubscription typeSubscription);
    List<Subscription> findByStartDateBetween(LocalDate startDate, LocalDate endDate);

}
