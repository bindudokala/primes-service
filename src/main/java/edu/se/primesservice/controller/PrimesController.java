package edu.se.primesservice.controller;


import ch.qos.logback.classic.spi.ConfiguratorRank;
import edu.se.primesservice.rabbitmq.MQSender;
import edu.se.primesservice.service.IPrimesService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/primes")
public class PrimesController {

    IPrimesService iPrimesService;

    private final MQSender mqSender;


    public PrimesController(IPrimesService iPrimesService, MQSender mqSender){
        this.iPrimesService = iPrimesService;
        this.mqSender = mqSender;
    }
    @GetMapping("/{n}")
    public boolean isPrime(@PathVariable int n){
        boolean result = iPrimesService.isPrime(n);
        mqSender.sendMessage(n,result);
        return iPrimesService.isPrime(n);
    }
}