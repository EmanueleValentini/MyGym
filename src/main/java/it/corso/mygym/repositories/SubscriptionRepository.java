package it.corso.mygym.repositories;

import it.corso.mygym.model.Subscription;
import it.corso.mygym.model.dto.SubscriptionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {
    // TODO: find by paid=true
    List<Subscription> findByPaidTrue();

    // TODO: find by active subscription
    List<Subscription> findBySubscriptionEndDateLowerThanCurrentDate();


}
