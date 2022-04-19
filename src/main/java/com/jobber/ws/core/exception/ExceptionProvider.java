package com.jobber.ws.core.exception;

import com.jobber.ws.core.model.ModelException;
import com.jobber.ws.dataAccess.sys.ExampleExReposirory;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class ExceptionProvider {
    private  final ExampleExReposirory repository;

    /**
     * Exception-nun verilənlər bazasına yazmaq üçün bu metodu istifadə edər.
     * @param exception - Hər hansı {@Link Exception Exception} obyekti.
     * @author Vugar Mammadli
     * @version 2022 Aprel 17
     */
    public void saveException(@NotNull Exception exception){
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
    public void saveException(@NotNull Exception exception, String reporter){
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
    public void saveException(@NotNull Exception exception, String reporter, String extension){
        ModelException modelException = ModelException
                .factory(exception.getMessage(),
                        Arrays.toString(exception.getStackTrace()),
                        exception.getLocalizedMessage(),
                        reporter);
        repository.save(modelException);
    }

}
