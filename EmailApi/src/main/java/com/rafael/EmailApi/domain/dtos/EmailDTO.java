package com.rafael.EmailApi.domain.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(setterPrefix = "with")
public class EmailDTO {

    private String[] to;

    private String from;

    private String emailBody;

    private String subject;




}
