package com.epam.movie_reporting_analitics.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GenericService<A> {

    List<A> getAll();
    A getById(Long id);


}
