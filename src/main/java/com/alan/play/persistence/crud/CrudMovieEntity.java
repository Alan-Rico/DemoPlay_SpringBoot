package com.alan.play.persistence.crud;

import com.alan.play.persistence.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudMovieEntity extends CrudRepository<MovieEntity, Long> {
    MovieEntity findFirstByTitulo (String titulo);
}
