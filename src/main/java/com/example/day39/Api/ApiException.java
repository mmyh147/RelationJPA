package com.example.day39.Api;

public class ApiException extends  RuntimeException
{
    public ApiException(String message){
        super(message);
    }
}
