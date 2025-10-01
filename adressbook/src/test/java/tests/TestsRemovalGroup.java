package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;


public class TestsRemovalGroup extends TestsBase {
    @Test
    public void testRemoveGroup() {
        app.openGroupsPage();
        if (!app.isGroupPresent()) {
            app.createGroup(new GroupData("name", "header", "footer"));
        }
        app.removeGroup();
    }
}
