import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

// Это аннотация JUnit, которая указывает, что тесты в классе должны запускаться
// с помощью специального «раннера» — MockitoJUnitRunner
// раннер автоматически инициализирует поля, аннотированные как @Mock, @Spy

@RunWith(MockitoJUnitRunner.class)

public class LionTest {
    @Mock
    private Feline feline;
    private Lion lion;

    // Тест метода getFood
    @Test
    public void getFoodCorrect() throws Exception {
        lion = new Lion("Самец", feline);
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
        verify(feline).getFood("Хищник");
    }

    // Тест метода getKittens
    @Test
    public void getKittensCorrect() throws Exception {
        lion = new Lion("Самец", feline);
        when(feline.getKittens()).thenReturn(3);
        assertEquals(3, lion.getKittens());
        verify(feline).getKittens();
    }

    }