package com.alan.play.web.controller;

import com.alan.play.DemoPlayApplication;
import com.alan.play.domain.dto.MovieDto;
import com.alan.play.domain.dto.SuggestRequesDto;
import com.alan.play.domain.dto.UpdateMovieDto;
import com.alan.play.domain.service.DemoPlayAiService;
import com.alan.play.domain.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@Tag(name = "Movies", description = "Operations about movies of DemoPlay")
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
    @Operation(
            summary = "Get a movie by ID",
            description = "Retorna la pelicula que coinicida con el ID enviado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Pelicula encontrada"),
                    @ApiResponse(responseCode = "404", description = "Pelicula no ecnontrada", content = @Content)
            }
    )
    public ResponseEntity<MovieDto> getById(@Parameter(description = "Identificador de la pelicula a recuperar", example = "3") @PathVariable long id){
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
    public ResponseEntity<MovieDto> update(@PathVariable long id, @RequestBody @Valid UpdateMovieDto updateMovieDto){
        return ResponseEntity.ok(this.movieService.update(id, updateMovieDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        this.movieService.delete(id);
        return ResponseEntity.ok().build();
    }
}
