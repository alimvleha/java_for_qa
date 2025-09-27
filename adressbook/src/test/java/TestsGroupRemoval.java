import org.junit.jupiter.api.Test;


public class TestsGroupRemoval extends TestsBase {
    @Test
    public void testRemoveGroup() {
        openGroupsPage();
        if (!isGroupPresent()) {
            createGroup("groupname", "groupheader", "groupfooter");
        }
        removeGroup();
    }
}
