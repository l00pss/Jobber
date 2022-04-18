package com.jobber.ws.side.exception;

import com.jobber.ws.controller.handler.GeneralAdvice;
import com.jobber.ws.dataAccess.sys.ExceptionRepository;
import com.jobber.ws.side.model.ModelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.Arrays;


/**
 * Layihə daxilində iş məntiqindən irəli gələn bütün Exception- lar bu {@link BaseException BaseException }
 * törəməsi olmaq məcburiyyətindədir. Bu halda alınan xətalar {@link ModelException ModelException } modeli ilə
 * {@link ExceptionRepository ExceptionRepository } vasitəsi ilə verilənlər bazasına yazıla bilir.
 * Dörd əsas qurucu metodu vardır. Sinifi <strong>extend</strong> edən siniflər
 * bu qurucu metodları <strong>override</strong> etməlidirlər.
 * <p>Nümunə : </p>
 * <blockquote>
 *     <pre>
 * public class UnknownException extends BaseException{
 *
 *   public UnknownException(){
 *         super();
 *     }
 *
 *   public UnknownException(String message){
 *         super(message);
 *     }
 *
 *   public UnknownException(String message,String reporter){
 *         super(message,reporter);
 *     }
 *
 *   public UnknownException(String message,String reporter,String ext){
 *         super(message,reporter,ext);
 *     }
 *
 * }
 *     </pre>
 * </blockquote>
 * @see ModelException
 * @see ExceptionRepository
 * @author Vugar Mammadli
 * @version 2022 Aprel 17
 */
@Component
public class BaseException extends Exception {

    @Autowired
    private  ExceptionRepository repository;

    private final static Logger logger = LoggerFactory.getLogger(GeneralAdvice.class);

    public BaseException(){
        super(" Bilinməyən xəta.");
        this.saveException(this);
    }

    public BaseException(String message) {
        super(message);
        this.saveException(this);
    }

    public BaseException(String reporter,String message) {
        this(message);
        this.saveException(this,reporter);
    }

    public BaseException(String reporter,String extension,String message) {
        this(reporter,message);
        this.saveException(this,reporter,extension);
    }

    /**
     * Exception-nun verilənlər bazasına yazmaq üçün bu metodu istifadə edər.
     * @param exception - Hər hansı {@Link Exception Exception} obyekti.
     * @author Vugar Mammadli
     * @version 2022 Aprel 17
     */
    private void saveException(Exception exception){
        ModelException modelException = ModelException
                .factory(exception.getMessage(),
                        Arrays.toString(exception.getStackTrace()),
                        exception.getLocalizedMessage());
        repository.save(modelException);
    }

    /**
     * Exception-nun verilənlər bazasına yazmaq üçün bu metodu istifadə edər.
     * @param exception - Hər hansı {@Link Exception Exception} obyekti.
     * @param reporter - Əgər varsa xüsusi yeri və ya istifadəçini qeyd etmək üçün.
     * @author Vugar Mammadli
     * @version 2022 Aprel 17
     */
    private void saveException(Exception exception,String reporter){
        ModelException modelException = ModelException
                .factory(exception.getMessage(),
                        Arrays.toString(exception.getStackTrace()),
                        exception.getLocalizedMessage(),
                        reporter);
        repository.save(modelException);
    }

    /**
     * Exception-nun verilənlər bazasına yazmaq üçün bu metodu istifadə edər.
     * @param exception - Hər hansı {@Link Exception Exception} obyekti.
     * @param reporter - Əgər varsa xüsusi yeri və ya istifadəçini qeyd etmək üçün.
     * @param extension - Exception üçün xüsusi qeyd varsa bu parametrlə göndərilə bilər.
     * @author Vugar Mammadli
     * @version 2022 Aprel 17
     */
    private void saveException(Exception exception,String reporter,String extension){
        ModelException modelException = ModelException
                .factory(exception.getMessage(),
                        Arrays.toString(exception.getStackTrace()),
                        exception.getLocalizedMessage(),
                        reporter);
        repository.save(modelException);
    }
}
