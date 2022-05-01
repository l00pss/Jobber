package com.jobber.ws.model.entity.other;

import com.jobber.ws.model.entity.abstracts.FunctionVisibility;
import com.jobber.ws.model.entity.user.User;
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "VISIBILITY")
@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
@Scope(scopeName = "prototype")
public class Visibility implements FunctionVisibility {
    @SequenceGenerator(name = "COM_GEN_SEQ",
            sequenceName = "COM_SEQ",
            allocationSize = 1
    )

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "COM_GEN_SEQ")
    private Long id;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFICATION_DATE",nullable = false)
    private Date modificationDate = new Date();

    @Column(name = "IS_ACTIVE")
    private boolean isActive = true;

    @Column(name = "IS_BLOCKED")
    private boolean isBlocked = false;

    @Column(name = "IS_FROZEN")
    private boolean isFrozen = false;

    @Column(name = "IS_DELETED")
    private boolean isDeleted = false;

    @Column(name = "RESULT_REASON")
    private String resultReason;

    @Override
    public  boolean isAppropriate(){
        return isActive && !isBlocked && !isFrozen && !isDeleted;
    }

    @Transient
    public static final Visibility ACTIVE  = Visibility.builder().build();

    @Transient
    public static final Visibility INACTIVE
            = Visibility.builder()
            .isBlocked(true)
            .isActive(false)
            .isFrozen(true)
            .isDeleted(true)
            .build();
}
