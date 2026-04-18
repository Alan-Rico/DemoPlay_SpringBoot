package com.alan.play.domain.service;

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
}
