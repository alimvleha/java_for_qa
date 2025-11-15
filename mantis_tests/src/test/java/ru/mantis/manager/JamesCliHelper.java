package ru.mantis.manager;

import org.openqa.selenium.io.CircularOutputStream;
import org.openqa.selenium.os.CommandLine;

import java.util.stream.Stream;

public class JamesCliHelper extends HelperBase {

    public JamesCliHelper(ApplicationManager manager) {
        super(manager);
    }

//    Указал конкретный путь версии java, чтобы переменные не ломать, т.к рабочие проекты ломаются
    public void addUser(String email, String password) {
        CommandLine cmd = new CommandLine(
                "C:/Program Files/JetBrains/IntelliJ IDEA Community Edition 2022.3.3/jbr/bin/java.exe", "-cp", "\"james-server-jpa-app.lib/*\"",
                "org.apache.james.cli.ServerCmd",
                "AddUser", email, password);
        cmd.setWorkingDirectory(manager.property("james.workDir"));
        CircularOutputStream out = new CircularOutputStream();
        cmd.copyOutputTo(out);
        cmd.execute();
        cmd.waitFor();
        System.out.println(out);
    }
}