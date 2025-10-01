package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;


public class TestsCreationGroup extends TestsBase {

    @Test
    public void testCreateGroup() {
        app.groups().createGroup(new GroupData("name", "header", "footer"));
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
