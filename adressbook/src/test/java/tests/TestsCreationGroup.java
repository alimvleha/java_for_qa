package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
                    result.add(new GroupData(name, header, footer));
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new GroupData(randomString(i * 10), randomString(i * 10), randomString(i * 10)));
        }
        return result;
    }

    public static List<GroupData> negativeGroupProvider() {
        var result = new ArrayList<GroupData>(List.of(
                new GroupData("name group'", "", "")));
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
