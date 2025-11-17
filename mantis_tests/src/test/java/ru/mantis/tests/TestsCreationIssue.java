package ru.mantis.tests;

import org.junit.jupiter.api.Test;
import ru.mantis.common.CommonFunctions;
import ru.mantis.model.IssueData;

public class TestsCreationIssue extends TestBase {


    @Test
    public void testCreateIssue() {
        app.rest().createIssue(new IssueData()
                .withSummary(CommonFunctions.randomString(10))
                .withDescription(CommonFunctions.randomString(50))
                .withProject(1L));
    }
}
