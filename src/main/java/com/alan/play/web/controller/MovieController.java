package com.alan.play.web.controller;

import com.alan.play.DemoPlayApplication;
import com.alan.play.domain.dto.MovieDto;
import com.alan.play.domain.dto.SuggestRequesDto;
import com.alan.play.domain.dto.UpdateMovieDto;
import com.alan.play.domain.service.DemoPlayAiService;
import com.alan.play.domain.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final DemoPlayAiService aiService;

    public MovieController(MovieService movieService, DemoPlayAiService demoPlayAiService) {
        this.movieService = movieService;
        this.aiService = demoPlayAiService;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAll(){
        return ResponseEntity.ok(this.movieService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getById(@PathVariable long id){
        MovieDto movieDto = this.movieService.getById(id);
        if (movieDto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movieDto);
    }
    @PostMapping("/suggest")
    public ResponseEntity<String> generateMoviesSuggestion(@RequestBody SuggestRequesDto suggestRequesDto){
        return ResponseEntity.ok(this.aiService.generateMovieSuggestion(suggestRequesDto.userPreference()));
    }

    @PostMapping
    public ResponseEntity<MovieDto> add (@RequestBody MovieDto movieDto){
        MovieDto movieDtoResponse = this.movieService.add(movieDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieDtoResponse);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update(@PathVariable long id, @RequestBody UpdateMovieDto updateMovieDto){
        return ResponseEntity.ok(this.movieService.update(id, updateMovieDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        this.movieService.delete(id);
        return ResponseEntity.ok().build();
    }
}
