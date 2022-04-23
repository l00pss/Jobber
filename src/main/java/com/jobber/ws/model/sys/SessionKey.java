package com.jobber.ws.model.sys;

import com.jobber.ws.model.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SESSION_KEY")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SessionKey {
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "COM_GEN_SEQ")
    private Long id;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;


    @Column(name = "KEY")
    private String key;
}
