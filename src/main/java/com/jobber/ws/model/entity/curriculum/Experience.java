package com.jobber.ws.model.entity.curriculum;

import com.jobber.ws.model.entity.curriculum.position.DefaultPosition;
import com.jobber.ws.model.entity.curriculum.position.OtherPosition;
import com.jobber.ws.model.entity.curriculum.position.Position;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EXPERIENCES")
public class Experience {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curriculum_id")
    private Curriculum curriculum;

    @OneToOne
    private Position defaultPosition;

    @Column(name = "IS_REMOTE")
    private Boolean isRemote = false;

    @Column(name = "IS_FULLTIME")
    private Boolean isFullTime = true;

    @Column(name = "WORK_SPACE_NAME")
    private String workSpaceName;

    @Temporal(TemporalType.DATE)
    @Column(name = "EXPERIENCE_START_DATE")
    private Date experienceStartDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "EXPERIENCE_END_DATE")
    private Date experienceEndDate;

    @Column(name = "IS_INTERN")
    private Boolean isIntern = false;
}