package edu.se.primesservice.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimesServiceTest {

    PrimesService primesService = new PrimesService();

    @Test
    void _45IsNotPrime(){
        int n = 45;
        boolean expected = false;
        boolean actual = primesService.isPrime(n);
        assertEquals(expected,actual);
    }
    @Test
    void _3252355345IsNotPrime(){
        long n = 3252355345L;
        boolean expected = false;
        boolean actual = primesService.isPrime(n);
        assertEquals(expected,actual);
    }
    @Test
    void _5698798698IsNotPrime(){
        long n = 5698798698L;
        boolean expected = false;
        boolean actual = primesService.isPrime(n);
        assertEquals(expected,actual);
    }

}