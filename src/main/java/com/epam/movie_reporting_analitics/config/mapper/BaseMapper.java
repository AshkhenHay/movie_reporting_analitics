package com.epam.movie_reporting_analitics.config.mapper;

public interface BaseMapper<S, T> {
    T mapToDTO(S s);

    S mapToEntity(T t);

}
