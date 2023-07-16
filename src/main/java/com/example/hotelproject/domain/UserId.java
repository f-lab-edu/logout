package com.example.hotelproject.domain;

import java.io.Serializable;
import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserId implements Serializable {

    @Column(name = "USER_NO")
    private Long userNo;

    @Column(name = "USER_ID")
    private String userId;
}
