package org.example.jsonrpc.rpc;

import com.googlecode.jsonrpc4j.JsonRpcServer;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class JsonRpcConfig {

    @Autowired
    private CalculatorService calculatorService;

    @Bean
    public ServletRegistrationBean<HttpServlet> calculatorServlet() {
        // JsonRpcServer obyektini yaratamiz
        JsonRpcServer rpcServer = new JsonRpcServer(calculatorService, CalculatorService.class);

        // Oddiy HttpServlet orqali so‘rovlarni qabul qilamiz
        HttpServlet servlet = new HttpServlet() {
            @Override
            protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
                rpcServer.handleRequest(req.getInputStream(), resp.getOutputStream());
            }
        };

        // Servletni /api/rpc/calculator ga ro‘yxatdan o‘tkazamiz
        return new ServletRegistrationBean<>(servlet, "/api/rpc/calculator");
    }
}
