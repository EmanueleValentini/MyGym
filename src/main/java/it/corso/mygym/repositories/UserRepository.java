package it.corso.mygym.repositories;

import it.corso.mygym.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User,Long> {
    List<User> findByActiveFlagTrue();

    // TODO: find by activeFlag=true AND have an active subscription --> @query
    @Query("SELECT u FROM User u where activeFlag = true && u.subscription.endDate < currentDate")
    List<User> findByActiveFlagTrueAndSubscriptionActive();
}
