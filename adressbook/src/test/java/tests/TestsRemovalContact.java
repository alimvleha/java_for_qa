package tests;
import org.junit.jupiter.api.Test;

public class TestsRemovalContact extends TestsBase {
    @Test
    public void testRemoveContact() {
        app.contacts().selectContact();
        app.contacts().removeContact();
    }
}
