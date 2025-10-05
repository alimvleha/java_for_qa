import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import tests.TestsBase;

public class TestsRemovalContact extends TestsBase {
    @Test
    public void testRemoveContact() {
        app.contacts().selectContact();
        app.contacts().removeContact();
    }
}
