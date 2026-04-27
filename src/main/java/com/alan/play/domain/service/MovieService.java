package com.alan.play.domain.service;

import com.alan.play.domain.dto.MovieDto;
import com.alan.play.domain.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> getAll() {
        return this.movieRepository.getAll();
    }

    public MovieDto getById(long id) {
        return  this.movieRepository.getById(id);
    }
}
