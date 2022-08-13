package com.example.demo.domain.exception;

public class ManyDuplicationException extends RuntimeException{
    public ManyDuplicationException(){

    }
    public ManyDuplicationException(String message){
        super(message);
    }
};
