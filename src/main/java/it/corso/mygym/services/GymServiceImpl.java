package it.corso.mygym.services;

import it.corso.mygym.model.Gym;
import it.corso.mygym.model.User;
import it.corso.mygym.model.dto.GymDto;
import it.corso.mygym.repositories.GymRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class GymServiceImpl implements GymService{
    @Autowired
    GymRepository repo;
    @Override
    public Gym save(GymDto gymDto) {
        ModelMapper modelMapper = new ModelMapper();
        return repo.save(modelMapper.map(gymDto, Gym.class));
    }

    @Override
    public Optional<Gym> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Gym> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Gym> update(Long id, GymDto gymDto) {
        Optional<Gym> existingGym = repo.findById(id);
        ModelMapper modelMapper = new ModelMapper();
        if (existingGym.isPresent()) {
            Gym updatedGym = repo.save(modelMapper.map(gymDto,Gym.class));
            return Optional.of(updatedGym);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Gym> deleteById(Long id) {
        Optional<Gym> gymToDelete = repo.findById(id);
        if (gymToDelete.isPresent()) {
            repo.deleteById(id);
        }
        return gymToDelete;
    }
}
