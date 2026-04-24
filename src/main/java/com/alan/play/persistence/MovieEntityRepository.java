package com.alan.play.persistence;

import com.alan.play.domain.dto.MovieDto;
import com.alan.play.domain.repository.MovieRepository;
import com.alan.play.persistence.crud.CrudMovieEntity;
import com.alan.play.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MovieEntityRepository implements MovieRepository {
    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;

    public MovieEntityRepository(CrudMovieEntity crudMovieEntity, MovieMapper movieMapper) {
        this.crudMovieEntity = crudMovieEntity;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDto> getAll() {
        return this.movieMapper.toDtos(this.crudMovieEntity.findAll());
    }
}
