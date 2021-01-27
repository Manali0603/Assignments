package testMockito;

import com.maersk.testMockito.ExternalService;
import com.maersk.testMockito.MyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class mockitoDemo {
    @InjectMocks
    MyService myService;

    @Mock
    ExternalService externalService;

    @BeforeEach
    void setup()
    {
        MockitoAnnotations.initMocks(this);
        //myService=new MyService(externalService);
    }
    @Test
    void test1()
    {
       // Mockito.when(externalService.getValidation("Manali")).thenReturn("something");
        Mockito.when(externalService.getValidation("Manali")).thenReturn("something");
        assertTrue(myService.validate("Manali"));
        Mockito.verify(externalService,Mockito.times(1)).getValidation("Manali");
    }

}
