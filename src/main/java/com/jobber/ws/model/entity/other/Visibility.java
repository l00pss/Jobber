package com.jobber.ws.model.entity.other;

import com.jobber.ws.model.entity.abstracts.FunctionVisibility;
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "VISIBILITY")
@Getter @Setter
@Builder
@NoArgsConstructor @AllArgsConstructor
@Scope(scopeName = "prototype")
@EntityListeners(AuditingEntityListener.class)
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
    private Date modificationDate;

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


    public static Visibility getActive(){  return Visibility.builder().build();}


    public static Visibility getInstance(){
            return Visibility.builder()
            .isBlocked(true)
            .isActive(false)
            .isFrozen(true)
            .isDeleted(true)
            .build();}
}
