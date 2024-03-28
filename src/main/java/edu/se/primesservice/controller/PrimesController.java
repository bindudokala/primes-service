package edu.se.primesservice.controller;


import ch.qos.logback.classic.spi.ConfiguratorRank;
import edu.se.primesservice.service.IPrimesService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/primes")
public class PrimesController {

    IPrimesService iPrimesService;

    public PrimesController(IPrimesService iPrimesService){
        this.iPrimesService = iPrimesService;
    }
    @GetMapping("/{n}")
    public boolean isPrime(@PathVariable int n){
        return iPrimesService.isPrime(n);
    }
}
