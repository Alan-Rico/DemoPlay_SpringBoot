package com.alan.play.domain.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface DemoPlayAiService {
    @UserMessage ("""
            Genera un saludo de bienvenida a la plataforma de 
            de películas {{plataform}}. Usa menos de 120 caracteres
            y hazlo con un estilo amigable.
            """)
    String generateGreeting(@V("plataform")String plataform);
    @SystemMessage("""
            Eres un experto en cine recomienda peliculas personalizadas segun los gustos del usuario.
            Debes recomendar maximo 3 peliculas.
            No incluyas peliculas que esten por fuera de la plataforma DemoPlay.
            """)
    String generateMovieSuggestion(@UserMessage String userMessage);
}
