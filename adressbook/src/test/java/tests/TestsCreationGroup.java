package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;



public class TestsCreationGroup extends TestsBase {
    public static List<GroupData> groupProvider() {
        var result = new ArrayList<GroupData>();
        for (var name : List.of("", "name group")){
            for (var header : List.of("", "header group")) {
                for (var footer : List.of("", "footer group")){
                    result.add(new GroupData().withName(name).withHeader(header).withFooter(footer));
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new GroupData()
                    .withName(randomString(i * 10))
                    .withHeader(randomString(i * 10))
                    .withFooter(randomString(i * 10)));
        }
        return result;
    }

    public static List<GroupData> negativeGroupProvider() {
        var result = new ArrayList<GroupData>(List.of(
                new GroupData("", "name group'", "", "")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("groupProvider")
    public void testCreateMultipleGroup(GroupData group) {
        int groupCount = app.groups().getCount();
        app.groups().createGroup(group);


        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount + 1, newGroupCount);
    }

    @ParameterizedTest
    @MethodSource("negativeGroupProvider")
    public void testNotCreateGroup(GroupData group) {
        int groupCount = app.groups().getCount();
        app.groups().createGroup(group);
        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount, newGroupCount);
    }
}
