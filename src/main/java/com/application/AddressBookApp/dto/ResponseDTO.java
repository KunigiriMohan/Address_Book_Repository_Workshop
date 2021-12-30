package com.application.AddressBookApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @Data : To auto Generate Getters and Setters
 * @NoArgumentConstructor : To Generate No Argument Constructer
 * @AllArgumentConstructor : To Generate All Argument Constructer
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    public String message;
    public Object person;
}
