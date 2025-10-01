package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;


public class TestsRemovalGroup extends TestsBase {
    @Test
    public void testRemoveGroup() {
        if (!app.groups().isGroupPresent()) {
            app.groups().createGroup(new GroupData("name", "header", "footer"));
        }
        app.groups().removeGroup();
    }
}
