package it.corso.mygym.services;

import it.corso.mygym.model.Subscription;
import it.corso.mygym.model.User;
import it.corso.mygym.model.dto.SubscriptionDto;
import it.corso.mygym.repositories.SubscriptionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SubscriptionServiceImpl implements SubscriptionService{
    @Autowired
    SubscriptionRepository repo;

    @Override
    public Optional<Subscription> deleteById(Long id, Subscription subscription) {
        return Optional.empty();
    }

    @Override
    public Subscription save(SubscriptionDto subscriptionDto) {
        ModelMapper modelMapper = new ModelMapper();
        return repo.save(modelMapper.map(subscriptionDto, Subscription.class));
    }

    @Override
    public Optional<Subscription> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Subscription> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Subscription> update(Long id, SubscriptionDto subscriptionDto) {
        Optional<Subscription> existingSub = repo.findById(id);
        ModelMapper modelMapper = new ModelMapper();
        if (existingSub.isPresent()) {
            Subscription updatedSub = repo.save(modelMapper.map(subscriptionDto,Subscription.class));
            return Optional.of(updatedSub);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Subscription> deleteById(Long id) {
        Optional<Subscription> subToDelete = repo.findById(id);
        if (subToDelete.isPresent()) {
            repo.deleteById(id);
        }
        return subToDelete;
    }
}
