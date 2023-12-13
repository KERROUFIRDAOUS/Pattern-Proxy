package org.example;

import org.example.proxy.*;

public class Main {
    public static void main(String[] args) {

        SecurityContext.authenticate("user1", "1234","root");
        Context context = new Context();
        context.setService(new SecurityProxy(new CacheProxy(new LoggingProxy(new ServiceImpl()))));
        context.compute(3);
        context.compute(4);
        context.compute(8);
        context.compute(3);

    }
}