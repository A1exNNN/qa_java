import com.example.Animal;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

// Это аннотация JUnit, которая указывает, что тесты в классе должны запускаться
// с помощью специального «раннера» — MockitoJUnitRunner
// раннер автоматически инициализирует поля, аннотированные как @Mock, @Spy

@RunWith(MockitoJUnitRunner.class)

public class FelineTest {

    // аннотация, которая используется для создания и внедрения макета
    @Mock
    private Animal animal;
    private Feline feline;

    // Аннотация, которая указывает на метод, который будет выполняться перед каждым тестом в классе
    @Before
    public void setUp() {
        feline = new Feline(animal); // animal как параметр для Feline
    }

    // Тест метода eatMeat
    @Test
    public void testEatMeat() throws Exception {
        List<String> expectedfoodlist = Arrays.asList("Животные", "Птицы", "Рыба");
        when(animal.getFood("Хищник")).thenReturn(expectedfoodlist);
        List<String> result = feline.eatMeat();
        assertEquals(expectedfoodlist, result);
    }

    // Тест как проходит исключение
    @Test(expected = Exception.class)
    public void testEatMeatException() throws Exception {
        when(animal.getFood("Хищник")).thenThrow(new Exception("Test exception"));
        feline.eatMeat();
    }


    // Тест метода getFamily
    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    // Тест метода getKittens
    @Test
    public void testGetKittens() {
        assertEquals(3, feline.getKittens());
    }

    // Тест метода getKittens с параметрами
    @Test
    public void testGetKittensWithParameter() {
        int kittensCount = 8;
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }

}