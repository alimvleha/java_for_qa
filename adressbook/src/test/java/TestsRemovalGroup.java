import model.GroupData;
import org.junit.jupiter.api.Test;


public class TestsRemovalGroup extends TestsBase {
    @Test
    public void testRemoveGroup() {
        openGroupsPage();
        if (!isGroupPresent()) {
            createGroup(new GroupData("name", "header", "footer"));
        }
        removeGroup();
    }
}
