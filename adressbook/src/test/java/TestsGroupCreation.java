import org.junit.jupiter.api.Test;


public class TestsGroupCreation extends TestsBase {

    @Test
    public void testCreateGroup() {
        openGroupsPage();
        createGroup("groupname", "groupheader", "groupfooter");
    }

    @Test
    public void testCreateGroupWithEmptyName() {
        openGroupsPage();
        createGroup("", "", "");
    }
}
