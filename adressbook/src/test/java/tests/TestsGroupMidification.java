package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;

public class TestsGroupMidification extends TestsBase {

    @Test
    void testModifyGroup() {
        if (!app.groups().isGroupPresent()) {
            app.groups().createGroup(new GroupData("name", "header", "footer"));
        }
        app.groups().modifyGroup(new GroupData().withName("modified name"));
    }
}
