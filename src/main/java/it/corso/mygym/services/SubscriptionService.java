package it.corso.mygym.services;

import it.corso.mygym.model.Subscription;
import it.corso.mygym.model.dto.SubscriptionDto;

import java.util.List;
import java.util.Optional;

public interface SubscriptionService {

    Optional<Subscription> deleteById(Long id, Subscription subscription);

    Subscription save(SubscriptionDto subscriptionDto);

    Optional<Subscription> findById(Long id);

    List<Subscription> findAll();

    Optional<Subscription> update(Long id, SubscriptionDto subscriptionDto);

    Optional<Subscription> deleteById(Long id);
}
