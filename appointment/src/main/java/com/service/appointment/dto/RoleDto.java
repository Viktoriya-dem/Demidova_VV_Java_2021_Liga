package com.service.appointment.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;


@Data
@RequiredArgsConstructor
public class RoleDto {

    private int id;
    @NotBlank
    private String name;


}
