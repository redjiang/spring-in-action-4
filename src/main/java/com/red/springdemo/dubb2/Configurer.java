package com.red.springdemo.dubb2;

import com.red.springdemo.api.IDemoCSV;
import com.red.springdemo.dubb.CSFReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author red
 * @date 2020-02-20
 */
@Component
public class Configurer {

//    @CSFReference(interfaceName = "order")
    @CSFReference(serviceName = "ooo")
    private IDemoCSV iDemoCSV;

    public void helloB(){
        iDemoCSV.sayAbc("as");
    }
}
