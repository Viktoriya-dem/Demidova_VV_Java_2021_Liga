package com.service.appointment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.TimeZone;

@Setter
@Getter
//@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class ReserveDto {

    private int id;

    @NotBlank
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private boolean isActive;


    @NotBlank
    private int userId;

    private ReserveDto(int userId, Date date) {
        this.userId = userId;
        this.date = date;
        this.isActive = true;
    }

    private ReserveDto(Date date) {
        this.date = date;
        this.isActive = true;
    }

}
