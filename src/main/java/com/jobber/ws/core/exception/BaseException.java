package com.jobber.ws.core.exception;

import com.jobber.ws.controller.handler.GeneralAdvice;
import com.jobber.ws.core.model.ModelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Layihə daxilində iş məntiqindən irəli gələn bütün Exception- lar bu {@link BaseException BaseException }
 * törəməsi olmaq məcburiyyətindədir. Bu halda alınan xətalar {@link ModelException ModelException } modeli ilə
 * {@link ExceptionProvider ExceptionProvider } vasitəsi ilə verilənlər bazasına yazıla bilir.
 * Dörd əsas qurucu metodu vardır. Sinifi <strong>extend</strong> edən siniflər
 * bu qurucu metodlardan özünə uyğun olanını <strong>override</strong> etməlidirlər.
 * Bu sinif <strong>Spring</strong> tərəfində <strong>Prototype</strong> olaraq yüklənir.
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
 * @see ExceptionProvider
 * @author Vugar Mammadli
 * @version 2022 Aprel 17
 */


public class BaseException extends Exception {

    private final static Logger logger = LoggerFactory.getLogger(GeneralAdvice.class);

    public BaseException(){
        super(" Bilinməyən xəta.");
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String reporter,String message) {
        this(message);
    }

    public BaseException(String reporter,String extension,String message) {
        this(reporter,message);
    }


}
