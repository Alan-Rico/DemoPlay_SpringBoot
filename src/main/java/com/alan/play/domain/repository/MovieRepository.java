package com.alan.play.domain.repository;

import com.alan.play.domain.dto.MovieDto;
import com.alan.play.domain.dto.UpdateMovieDto;

import java.util.List;

public interface MovieRepository {
    List<MovieDto> getAll();
    MovieDto getById(long id);
    MovieDto save(MovieDto movieDto);
    MovieDto update (long id, UpdateMovieDto updateMovieDto);
}
