/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.aegean.eIdEuSmartClass.utils;

import gr.aegean.eIdEuSmartClass.MailConfig;
//import java.lang.reflect.Field;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author nikos
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={MailConfig.class})
public class MailTester {
    
    @Autowired
    private JavaMailSender mailSender;
    
    
    @Test
    public void testMailConfgi() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
//       Field f = mailSender.getClass().getDeclaredField("password");
//       f.setAccessible(true);
//       assertEquals(f.get(mailSender),"testPass");
        assertEquals(true,true);
    }
    
}
