package org.apply.methods.webdemodiary.service;

import lombok.AllArgsConstructor;
import org.apply.methods.webdemodiary.model.City;
import org.apply.methods.webdemodiary.repository.CityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public void save(City city) {
        cityRepository.save(city);
    }
}
