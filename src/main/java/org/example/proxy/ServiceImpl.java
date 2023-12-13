package org.example.proxy;

public class ServiceImpl implements IService{
    @Override
    public double compute(int parameter) {
        double value = 33;
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }

        return value * parameter;
    }
}
