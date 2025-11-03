package org.example.jsonrpc.rpc;

import com.googlecode.jsonrpc4j.JsonRpcMethod;
import com.googlecode.jsonrpc4j.JsonRpcService;

//@JsonRpcService("/api/rpc/calculator")
public interface CalculatorService {

    @JsonRpcMethod("add")
    int add(int a, int b);

    @JsonRpcMethod("subtract")
    int subtract(int a, int b);
}
