package com.cars.exception;

public class RecordAlreadyExists extends Exception{
    public RecordAlreadyExists(String message){
        super(message);
    }
}
