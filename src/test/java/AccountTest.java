import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {


    private String name;
    private boolean expected;

    public AccountTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Тимоти Шаламе", true},
                {"Т Ш", true},
                {"Длинношеее животное", true},
                {"Timoti Shalome", true},
                {"Ggg56g hh-h;0).,'", true},

                {"ТШ", false},
                {"Тесттесттесттес тест", false},
                {"Оченьдлинноеслово блабла", false},

                {" Тимоти", false},
                {"Тимоти ", false},
                {"ТимотиШаломе", false},
                {"Тимоти   Шаломе", false},
                {null, false},
                {"   ", false}
        };
    }

        @Test
        public void checkingActualEnteredNameTest() {
            Account account = new Account(name);
            assertEquals("Некорректно введенные данные", account.checkNameToEmboss(), expected);
        }


}
