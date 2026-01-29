package com.deepakLearning.HMS;

import com.deepakLearning.HMS.Service.InsuranceService;
import com.deepakLearning.HMS.entity.Insurance;
import com.deepakLearning.HMS.entity.patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;

@SpringBootTest
public class InsuranceTests {
    @Autowired
    private InsuranceService insuranceService;
    @Test
    public void testInsurance(){
        Insurance insurance=new Insurance("HDFC_1234","HDFC",LocalDate.of(2030,12,31));
              patient p=insuranceService.assignInsurance(insurance,1L);
        System.out.println(p);
    }

}
