package org.example.proxy;

public class SecurityProxy implements IService{
    private IService service;

    public SecurityProxy(IService service) {
        this.service = service;
    }
    @Override
    public double compute(int parameter) {
        if(!SecurityContext.role.equals("root")){
            throw new RuntimeException("Not authorized");
        }else{
            double result = service.compute(parameter);
            return result;
        }
    }
}
