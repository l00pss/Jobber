package com.jobber.ws.controller.api;

import com.jobber.ws.business.TestManager;
import com.jobber.ws.core.exception.UnknownException;
import com.jobber.ws.core.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test/")
@RequiredArgsConstructor
public class TestController {
    private final TestManager testManager;
    @GetMapping("one")
    public ResponseEntity<Response> test()  {
        this.testManager.test();
        return null;
    }

    @GetMapping("two")
    public ResponseEntity<Response> test2() throws UnknownException {
        this.testManager.test2();
        return null;
    }
}
