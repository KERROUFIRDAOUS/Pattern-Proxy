package org.example.proxy;

import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

public class CacheProxy implements IService {
    private Map<Integer,Double> cache = new HashMap<>();
    private IService service;

    public CacheProxy(IService service) {
        this.service = service;
    }
    @Override
    public double compute(int parameter) {
        Double cacheValue = cache.get(parameter);
        if(cacheValue!=null){
            System.out.println("----- cache Result -----");
            return cacheValue;
        }
        else{
            double res = service.compute(parameter);
            cache.put(parameter,res);
            System.out.println("----- New computing result -----");
            return res;
        }
    }
}
