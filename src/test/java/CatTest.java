import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CatTest {

    // Тест метода GetFood
    @Test
    public void testGetFood() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Cat cat = new Cat(feline);
        List foodList = Mockito.mock(List.class);
        Mockito.when(feline.eatMeat()).thenReturn(foodList);
        List<String> result = cat.getFood();
        assertEquals(foodList, result);
    }

    // Тест метода getSound
    @Test
    public void testGetSound() {
        Cat cat = new Cat(Mockito.mock(Feline.class));
        String result = cat.getSound();
        assertEquals("Мяу", result);
    }
}
