package it.corso.mygym.services;


import it.corso.mygym.model.Gym;
import it.corso.mygym.model.dto.GymDto;

import java.util.List;
import java.util.Optional;

public interface GymService {
    Gym save(GymDto gymDto);

    Optional<Gym> findById(Long id);

    List<Gym> findAll();

    Optional<Gym> update(Long id, GymDto gymDto);

    Optional<Gym> deleteById(Long id);
}
