package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestsRemovalGroup extends TestsBase {
    @Test
    public void testRemoveGroup() {
        if (app.groups().getCount() == 0) {
            app.groups().createGroup(new GroupData("name", "header", "footer"));
        }
        int groupCount = app.groups().getCount();
        app.groups().removeGroup();
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount - 1, newGroupCount );
    }
}
