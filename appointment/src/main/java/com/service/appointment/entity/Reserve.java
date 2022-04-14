package com.service.appointment.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reserves")
@Setter
@Getter
//@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;

    @NotNull
    @Column(name="date", unique = true)
   @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm", timezone = "UTS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name="active")
    private boolean isActive;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST,
            CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @NotNull
    private ApiUser apiUser;


    @Override
    public String toString() {
        return "Reserve{" +
                "id=" + id +
                ", date=" + date +
                ", isActive=" + isActive +
                '}';
    }
}


