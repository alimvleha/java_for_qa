package tests;

import model.GroupData;
import org.junit.jupiter.api.Test;


public class TestsCreationGroup extends TestsBase {

    @Test
    public void testCreateGroup() {
        app.openGroupsPage();
        app.createGroup(new GroupData("name", "header", "footer"));
    }

    @Test
    public void testCreateGroupWithEmptyName() {
        app.openGroupsPage();
        app.createGroup(new GroupData());
    }
    @Test
    public void testCreateGroupWithNameOnly() {
        app.openGroupsPage();
        var emptyGroup = new GroupData();
        var groupWithName = emptyGroup.withName("some name");
        app.createGroup(groupWithName);
    }

    @Test
    public void testCreateGroupWithHeaderOnly() {
        app.openGroupsPage();
        app.createGroup(new GroupData().withHeader("some header"));
    }
}
