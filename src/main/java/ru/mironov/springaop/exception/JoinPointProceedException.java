package ru.mironov.springaop.exception;

public class JoinPointProceedException extends RuntimeException{

    public JoinPointProceedException(String message){
        super(message);
    }
}
