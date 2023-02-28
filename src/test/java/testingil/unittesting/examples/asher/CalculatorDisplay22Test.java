package testingil.unittesting.examples.asher;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import testingil.unittesting.examples.demos.d04.characterization.CalculatorDisplay;
import testingil.unittesting.examples.demos.d04.characterization.ExternalDsiplay;
import testingil.unittesting.examples.demos.d04.characterization.TestLogger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CalculatorDisplay22Test {
    CalculatorDisplay cd;
    TestLogger log;



    @BeforeEach
    void setup(){
        cd = new CalculatorDisplay();
        log = new TestLogger();
    }

    @Test
    void sanity(){
        ExternalDsiplay ed=mock(ExternalDsiplay.class);
        when(ed.isOn()).thenReturn(true);
        cd.initExternalDisplay(ed);
        cd.press("1");
        cd.press("+");
        cd.press("1");
        cd.press("=");
        assertEquals("2",cd.getDisplay());
    }

    @Test
    void negativeNumbers(){
        ExternalDsiplay ed=mock(ExternalDsiplay.class);
        when(ed.isOn()).thenReturn(true);
        cd.initExternalDisplay(ed);
        cd.press("1");
        cd.press("+");
        cd.press("-");
        cd.press("1");
        cd.press("=");
        assertEquals("0",cd.getDisplay());
    }

    @Test
    void divideByZero(){
        ExternalDsiplay ed=mock(ExternalDsiplay.class);
        when(ed.isOn()).thenReturn(true);
        cd.initExternalDisplay(ed);
        cd.press("10");
        cd.press("/");
        cd.press("0");
        cd.press("=");
        assertEquals("E",cd.getDisplay());
    }

    @Test
    void division(){
        ExternalDsiplay ed=mock(ExternalDsiplay.class);
        when(ed.isOn()).thenReturn(true);
        cd.initExternalDisplay(ed);
        cd.press("10");
        cd.press("/");
        cd.press("5");
        cd.press("=");
        assertEquals("2",cd.getDisplay());
    }

    @Test
    void multiply(){
        ExternalDsiplay ed=mock(ExternalDsiplay.class);
        when(ed.isOn()).thenReturn(true);
        cd.initExternalDisplay(ed);
        cd.press("1");
        cd.press("0");
        cd.press("*");
        cd.press("5");
        cd.press("=");
        assertEquals("50",cd.getDisplay());
    }

    @Test
    void deduct(){
        ExternalDsiplay ed=mock(ExternalDsiplay.class);
        when(ed.isOn()).thenReturn(true);
        cd.initExternalDisplay(ed);
        cd.press("1");
        cd.press("0");
        cd.press("-");
        cd.press("5");
        cd.press("=");
        assertEquals("5",cd.getDisplay());
    }

    @Test
    void longNumber(){
        ExternalDsiplay ed=mock(ExternalDsiplay.class);
        when(ed.isOn()).thenReturn(true);
        cd.initExternalDisplay(ed);
        cd.press("1");
        cd.press("1");
        cd.press("1");
        cd.press("1");
        cd.press("1");
        cd.press("1");
        cd.press("1");
        cd.press("0");
        cd.press("-");
        cd.press("5");
        cd.press("=");
        assertEquals("E",cd.getDisplay());
    }

    @Test
    void textExternalDisplay(){
        ExternalDsiplay ed=mock(ExternalDsiplay.class);
        when(ed.isOn()).thenReturn(true);
        cd.initExternalDisplay(ed);
        cd.press("1");
        Mockito.verify(ed).show("1");

    }

    @Test
    void twoActions(){
        ExternalDsiplay ed=mock(ExternalDsiplay.class);
        when(ed.isOn()).thenReturn(true);
        cd.initExternalDisplay(ed);
        cd.press("1");
        cd.press("+");
        cd.press("+");
        cd.press("1");
        cd.press("=");
        assertEquals("2",cd.getDisplay());
    }

}