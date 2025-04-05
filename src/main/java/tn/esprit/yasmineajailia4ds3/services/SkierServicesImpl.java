package tn.esprit.yasmineajailia4ds3.services;

        import lombok.AllArgsConstructor;
        import org.springframework.stereotype.Service;
        import tn.esprit.yasmineajailia4ds3.entities.*;
        import tn.esprit.yasmineajailia4ds3.repositories.*;

        import java.util.List;
        import java.util.stream.Collectors;
        import java.util.stream.StreamSupport;

        @Service
        @AllArgsConstructor
        public class SkierServicesImpl implements ISkierServices {
            private ISkierRepository skierRepository;
            private IPisteRepository pisteRepository;
            private ICourseRepository courseRepository;
            private ISubscriptionRepository subscriptionRepository;
            private IRegistrationRepository registrationRepository;

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
                return null;
            }

            @Override
            public Skier addSkierAndAssignToCourse(Skier skier, Long numCourse) {
                Course course = courseRepository.findById(numCourse).orElse(null);
                if (course != null) {
                    skier = skierRepository.save(skier);
                    Subscription subscription = new Subscription();
                    subscription.setSkier(skier);
                    subscriptionRepository.save(subscription);

                    Registration registration = new Registration();
                    registration.setSkier(skier);
                    registration.setCourse(course);
                    registrationRepository.save(registration);

                    return skier;
                }
                return null;
            }
            @Override
            public List<Skier> retrieveSkiersBySubscriptionType(TypeSubscription typeAbonnement) {
                List<Subscription> subscriptions = subscriptionRepository.findByTypeSubscription(typeAbonnement);
                return subscriptions.stream()
                        .map(Subscription::getSkier)
                        .collect(Collectors.toList());
            }
        }