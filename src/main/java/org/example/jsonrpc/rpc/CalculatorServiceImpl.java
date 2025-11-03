package org.example.jsonrpc.rpc;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public int add(int a, int b) {
        System.out.println("add() chaqirildi: " + a + " + " + b);
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        System.out.println("subtract() chaqirildi: " + a + " - " + b);
        return a - b;
    }
}
