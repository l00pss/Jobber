package com.jobber.ws.util.exception;

import com.jobber.ws.util.model.ModelException;
import com.jobber.ws.dataAccess.sys.ExceptionRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExceptionProvider {
    private  final ExceptionRepository repository;

    /**
     * Exception-nun verilənlər bazasına yazmaq üçün bu metodu istifadə edər.
     * @param exception - Hər hansı {@Link Exception Exception} obyekti.
     * @author Vugar Mammadli
     * @version 2022 Aprel 17
     */
    public void saveException(@NotNull Exception exception){
        ModelException modelException = ModelException
                .factory(exception.getMessage(),
                        exception.getStackTrace(),
                        exception.getLocalizedMessage());
//        repository.save(modelException);
    }

    /**
     * Exception-nun verilənlər bazasına yazmaq üçün bu metodu istifadə edər.
     * @param exception - Hər hansı {@Link Exception Exception} obyekti.
     * @param reporter - Əgər varsa xüsusi yeri və ya istifadəçini qeyd etmək üçün.
     * @author Vugar Mammadli
     * @version 2022 Aprel 17
     */
    public void saveException(@NotNull Exception exception, String reporter){
        ModelException modelException = ModelException
                .factory(exception.getMessage(),
                        exception.getStackTrace(),
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
    public void saveException(@NotNull Exception exception, String reporter, String extension){
        ModelException modelException = ModelException
                .factory(exception.getMessage(),
                        exception.getStackTrace(),
                        exception.getLocalizedMessage(),
                        reporter);
        repository.save(modelException);
    }

}
