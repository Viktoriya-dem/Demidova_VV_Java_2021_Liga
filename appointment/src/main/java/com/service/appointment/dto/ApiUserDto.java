package com.service.appointment.dto;


import com.service.appointment.entity.Reserve;
import com.service.appointment.entity.Role;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
public class ApiUserDto {
    private int id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private Role role;

    private List<Reserve> reserveIdList;

    public ApiUserDto(String username, String password) {
     this.username = username;
     this.password = password;
     //reserveIdList=new ArrayList<>();
    }
}
