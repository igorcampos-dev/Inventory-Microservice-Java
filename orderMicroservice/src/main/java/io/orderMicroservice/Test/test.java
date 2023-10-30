package io.orderMicroservice.Test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class test {

    @GetMapping
    public String status(){
        return "funcionando no microserviços de avaliar crédito!";
    }
}
