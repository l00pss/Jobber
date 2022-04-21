package com.jobber.ws.model.entity.other;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;

@Entity
@Table(name = "VISIBILITY")
@Getter @Setter
@Builder
@NoArgsConstructor
@Scope(scopeName = "prototype")
public final class Visibility {
    @SequenceGenerator(name = "COM_GEN_SEQ",
            sequenceName = "COM_SEQ",
            allocationSize = 1
    )

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "COM_GEN_SEQ")
    private Long id;

    @Column(name = "IS_ACTIVE")
    private boolean isActive = true;

    @Column(name = "IS_BLOCKED")
    private boolean isBlocked = false;

    @Column(name = "IS_FROZEN")
    private boolean isFrozen = false;

    @Column(name = "IS_DELETED")
    private boolean isDeleted = false;

    public  boolean isAppropriate(){
        return isActive && !isBlocked && !isFrozen && !isDeleted;
    }

    @Transient
    public static final Visibility ACTIVE = Visibility.builder().build();

    @Transient
    public static final Visibility INACTIVE = Visibility.builder()
            .isBlocked(true)
            .isActive(false)
            .isFrozen(true)
            .isDeleted(true)
            .build();
}
