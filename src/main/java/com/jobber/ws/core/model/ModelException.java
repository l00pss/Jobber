package com.jobber.ws.core.model;

import com.jobber.ws.core.exception.core.BaseException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.util.Date;

/**
 * Bu sinif yalnız layihədə yer alan {@link BaseException BaseException}
 * törəmələri olan Exceptionları modelləmək üçün istifadə edilə bilər. Bu modeldən tam istifadə edə bilmək üçün
 * {@link BaseException BaseException} qurucu metodlarının hamısı xüsusi {@link Exception Exception}
 * sinifi tərəfindən implement edilməlidir. Bu sinif <strong>Spring</strong> tərəfində <strong>Prototype</strong> olaraq yüklənir.
 * Burada hazırlanan model {@link com.jobber.ws.dataAccess.sys.ExceptionRepository ExceptionRepository} vasitəsi ilə
 * verilənlər bazasına yazılır.
 * Nümunə üçün :
 * <blockquote><pre>
 * ModelException modelException = ModelException
 *                .factory(exception.getMessage(),
 *                         Arrays.toString(exception.getStackTrace()),
 *                         exception.getLocalizedMessage());
 *  </pre></blockquote>
 * @see com.jobber.ws.dataAccess.sys.ExceptionRepository
 * @see BaseException
 * @since 1.0.0
 * @author Vugar Mammadli
 * @version 2022 Aprel 17
 */

@Entity
@Scope("prototype")
@Table(name = "EXCEPTIONS")
@Data @NoArgsConstructor @AllArgsConstructor
public class ModelException {
    @SequenceGenerator(name = "EX_GEN_SEQ",
            sequenceName = "EX_SEQ",
            allocationSize = 1
    )

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator ="EX_GEN_SEQ" )
    private Long id = 1L;

    @Column(name = "NAME")
    private String exceptionName;

    @Column(name = "REPORTER")
    private String reporter;

    @Column(name = "STACK_TRACE",length = 2500)
    private String stackTrace;

    @Column(name = "LOCALIZED_MESSAGE")
    private String localizedMessage;

    @Column(name = "EXTENSION")
    private String extension;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp ;

    private ModelException(String exceptionName, String stackTrace,String localizedMessage,String reporter,String extension){
        this.exceptionName = exceptionName;
        this.stackTrace = stackTrace;
        this.localizedMessage = localizedMessage;
        this.reporter = reporter;
        this.extension = extension;
        this.timeStamp = new Date();
    }




    /**
     * Exception modeli hazırlamaq üçün iki fərqli qurucu metod var.
     * @param exceptionName - Exception sinifinin adı
     * @param stackTraceArr - Exceptionun verdiyi yerlərin başdan sona bütün yerləri
     * @param localizedMessage - Localized ismarıcı
     * @return Xüsusi Exception modeli. Heç vaxt <strong>Null</strong> dəyər döndürməz.
     * @see BaseException
     * @since 1.0.0
     * @author Vugar Mammadli
     * @version 2022 Aprel 17
     */
    @Contract("_, _, _ -> new")
    public static @NotNull ModelException factory(String exceptionName, StackTraceElement[] stackTraceArr, String localizedMessage){
        return new ModelException(exceptionName,ModelException.renderStackTrace(stackTraceArr),localizedMessage,null,null);
    }





    /**
     * Exception modeli hazırlamaq üçün iki fərqli qurucu metod var. <strong>Bu metod reporteridə tutur.</strong>
     * @param exceptionName - Exception sinifinin adı
     * @param stackTraceArr - Exceptionun verdiyi yerlərin başdan sona bütün yerləri
     * @param localizedMessage - Localized ismarıcı
     * @param reporter - Əgər xəta xüsusi bir istifadəçidə və ya yerdə olubdursa onun haqqında məlumatı tutur
     * @return Xüsusi Exception modeli. Heç vaxt <strong>Null</strong> dəyər döndürməz.
     * @see BaseException
     * @since 1.0.0
     * @author Vugar Mammadli
     * @version 2022 Aprel 17
     */
    @Contract("_, _, _, _ -> new")
    public static @NotNull ModelException factory(String exceptionName, StackTraceElement[] stackTraceArr, String localizedMessage, String reporter){
        return new ModelException(exceptionName,ModelException.renderStackTrace(stackTraceArr),localizedMessage,reporter,null);
    }





    /**
     * Exception modeli hazırlamaq üçün iki fərqli qurucu metod var. <strong>Bu metod reporteridə tutur.</strong>
     * @param exceptionName - Exception sinifinin adı
     * @param stackTraceArr - Exceptionun verdiyi yerlərin başdan sona bütün yerləri
     * @param localizedMessage - Localized ismarıcı
     * @param reporter - Əgər xəta xüsusi bir istifadəçidə və ya yerdə olubdursa onun haqqında məlumatı tutur.
     * @param extension - Əlavə qeydlər bildirmək üçün dəyişən
     * @return Xüsusi Exception modeli. Heç vaxt <strong>Null</strong> dəyər döndürməz.
     * @see BaseException
     * @since 1.0.0
     * @author Vugar Mammadli
     * @version 2022 Aprel 17
     */
    @Contract("_, _, _, _ -> new")
    public static @NotNull ModelException factory(String exceptionName, StackTraceElement[] stackTraceArr, String localizedMessage, String reporter,String extension){
        return new ModelException(exceptionName,ModelException.renderStackTrace(stackTraceArr),localizedMessage,reporter,extension);
    }


    private static String renderStackTrace(StackTraceElement[] stackTraceElements) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < 4) {
            builder.append("[ ")
                    .append("{ Class Name:  ")
                    .append(stackTraceElements[i].getClassName())
                    .append("} { Line:  ")
                    .append(stackTraceElements[i].getLineNumber())
                    .append("} { Method Name :  ")
                    .append(stackTraceElements[i].getMethodName())
                    .append(" } ]\n");
            i++;
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return "ModelException{" +
                "id=" + id +
                ", exceptionName='" + exceptionName + '\'' +
                ", reporter='" + reporter + '\'' +
                ", stackTrace='" + stackTrace + '\'' +
                ", localizedMessage='" + localizedMessage + '\'' +
                ", extension='" + extension + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
