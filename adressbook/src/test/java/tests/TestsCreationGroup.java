package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestsCreationGroup extends TestsBase {

    @Test
    public void testCreateGroup() {
        int groupCount = app.groups().getCount();
        app.groups().createGroup(new GroupData("name", "header", "footer"));
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount + 1, newGroupCount );
    }

    @Test
    public void testCreateGroupWithEmptyName() {
        app.groups().createGroup(new GroupData());
    }
    @Test
    public void testCreateGroupWithNameOnly() {
        app.groups().createGroup(new GroupData().withName("some name"));
    }

    @Test
    public void testCreateGroupWithHeaderOnly() {
        app.groups().createGroup(new GroupData().withHeader("some header"));
    }
}
