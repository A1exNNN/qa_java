import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

// Это аннотация JUnit, которая указывает, что тесты в классе должны запускаться
// с помощью специального «раннера» — MockitoJUnitRunner
// раннер автоматически инициализирует поля, аннотированные как @Mock, @Spy
@RunWith(Parameterized.class)
public class ParameterizedLionTest {
    private final String inputSex;
    private final boolean expectedMane;

    // Аннотация @Mock создаёт объект-имитатор, который реализует поведение реальной подсистемы
    @Mock
    private Feline feline;

    public ParameterizedLionTest(String inputSex, boolean expectedMane) {
        this.inputSex = inputSex;
        this.expectedMane = expectedMane;
    }

    @Before
    public void setUp() {
        // Инициализация моков с помощью Mockito
        MockitoAnnotations.initMocks(this);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][]{
                        {"Самец", true},
                        {"Самка", false}
                }
        );
    }

    // Тест верный ли пол
    @Test
    public void testInvalidSex() {
        assertThrows(Exception.class, () -> new Lion("Неизвестно", feline));
    }

    // Тест есть ли грива
    @Test
    public void testDoesHaveMane() throws Exception {
        Lion lion = new Lion(inputSex, feline);
        assertEquals(expectedMane, lion.doesHaveMane());
    }

}
