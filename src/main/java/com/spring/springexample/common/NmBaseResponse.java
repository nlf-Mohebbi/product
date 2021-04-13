package com.spring.springexample.common;

import java.util.ArrayList;
import java.util.List;

public class NmBaseResponse {

    List<String> messages= new ArrayList<String>();
    Integer code;
    Boolean status;

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public static NmBaseResponse badRequest(String input){
        NmBaseResponse response= new NmBaseResponse();
        response.getMessages().add(input);
        response.setCode(400);
        response.setStatus(false);
        return response;
    }

    public static NmBaseResponse tokenIsNotValid(String input){
        NmBaseResponse response= new NmBaseResponse();
        response.getMessages().add(input);
        response.setCode(401);
        response.setStatus(false);
        return response;
    }


    public static NmBaseResponse accessDenied(String input){
        NmBaseResponse response= new NmBaseResponse();
        response.getMessages().add(input);
        response.setCode(403);
        response.setStatus(false);
        return response;
    }

    public static NmBaseResponse notFound(String input){
        NmBaseResponse response= new NmBaseResponse();
        response.getMessages().add(input);
        response.setCode(404);
        response.setStatus(false);
        return response;
    }

    public static NmBaseResponse alreadyExist(String input){
        NmBaseResponse response= new NmBaseResponse();
        response.getMessages().add(input);
        response.setCode(406);
        response.setStatus(false);
        return response;
    }

    public static NmBaseResponse internalServerError(String input){
        NmBaseResponse response= new NmBaseResponse();
        response.getMessages().add(input);
        response.setCode(500);
        response.setStatus(false);
        return response;
    }

    public static NmBaseResponse success(String input){
        NmBaseResponse response= new NmBaseResponse();
        response.getMessages().add(input);
        response.setCode(200);
        response.setStatus(true);
        return response;
    }

    public static NmBaseResponse createSuccessfully(String input){
        NmBaseResponse response= new NmBaseResponse();
        response.getMessages().add(input);
        response.setCode(201);
        response.setStatus(true);
        return response;
    }

    public static NmBaseResponse deleteSuccessfully(String input){
        NmBaseResponse response= new NmBaseResponse();
        response.getMessages().add(input);
        response.setCode(204);
        response.setStatus(true);
        return response;
    }
}
