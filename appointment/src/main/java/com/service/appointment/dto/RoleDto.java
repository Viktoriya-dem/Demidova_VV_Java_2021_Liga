package com.service.appointment.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;


@Setter
@Getter
//@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class RoleDto {

    private int id;
    @NotBlank
    private String name;


}
