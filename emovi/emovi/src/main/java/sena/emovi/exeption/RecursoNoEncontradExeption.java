package sena.emovi.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecursoNoEncontradExeption extends  RuntimeException{
    public RecursoNoEncontradExeption(String mensaje){
        super(mensaje);
    }
}
