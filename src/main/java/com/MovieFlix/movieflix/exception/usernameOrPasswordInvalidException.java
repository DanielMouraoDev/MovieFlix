package com.MovieFlix.movieflix.exception;

public class usernameOrPasswordInvalidException extends RuntimeException{

    public usernameOrPasswordInvalidException(String menssage) {
        super(menssage);
    }
}
