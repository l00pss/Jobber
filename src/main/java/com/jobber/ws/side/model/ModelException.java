package com.jobber.ws.side.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Bu sinif yalnız layihədə yer alan {@link com.jobber.ws.side.exception.BaseException BaseException}
 * törəmələri olan Exceptionları modelləmək üçün istifadə edilə bilər. Burada hazırlanan model
 * {@link com.jobber.ws.dataAccess.sys.ExceptionRepository ExceptionRepository} vasitəsi ilə
 * verilənlər bazasına yazılır.
 * @see com.jobber.ws.dataAccess.sys.ExceptionRepository
 * @see com.jobber.ws.side.exception.BaseException
 * @author Vugar Mammadli
 */
@Entity
@Table(name = "EXCEPTIONS")
@Getter @NoArgsConstructor @AllArgsConstructor
public class ModelException {
    @SequenceGenerator(name = "EX_GEN_SEQ",
            sequenceName = "EX_SEQ",
            allocationSize = 1
    )

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "EX_GEN_SEQ")
    private Long id;

    @Column(name = "NAME")
    private String exceptionName;

    @Column(name = "REPORTER")
    private String reporter;

    @Column(name = "STACK_TRACE") @Lob
    private String stackTrace;

    @Column(name = "LOCALIZED_MESSAGE")
    private String localizedMessage;

    @Column(name = "EXTENSION")
    private String extension;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp = new Date();

    private ModelException(String exceptionName, String stackTrace,String localizedMessage,String reporter){
        this.exceptionName = exceptionName;
        this.stackTrace = stackTrace;
        this.localizedMessage = localizedMessage;
        this.reporter = reporter;
    }


    /**
     * Exception modeli hazırlamaq üçün iki fərqli qurucu metod var. Bu metod reporteridə tutur.
     * @param exceptionName - Exception sinifinin adı
     * @param stackTrace - Exceptionun verdiyi yerlərin başdan sona bütün yerləri
     * @param localizedMessage - Localized ismarıcı
     * @param reporter - Əgər xüsusi bir istifadəçidə olubdursa onun haqqında məlumat
     * @return Xüsusi Exception modeli
     * @see com.jobber.ws.side.exception.BaseException
     * @author Vugar Mammadli
     */
    public static ModelException factory(String exceptionName, String stackTrace,String localizedMessage,String reporter){
        return new ModelException(exceptionName,stackTrace,localizedMessage,reporter);
    }


    /**
     * Exception modeli hazırlamaq üçün iki fərqli qurucu metod var.
     * @param exceptionName - Exception sinifinin adı
     * @param stackTrace - Exceptionun verdiyi yerlərin başdan sona bütün yerləri
     * @param localizedMessage - Localized ismarıcı
     * @return Xüsusi Exception modeli
     * @see com.jobber.ws.side.exception.BaseException
     * @author Vugar Mammadli
     */
    public static ModelException factory(String exceptionName, String stackTrace,String localizedMessage){
        return new ModelException(exceptionName,stackTrace,localizedMessage,null);
    }


}
