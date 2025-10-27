package model;

import java.util.Objects;

public final class GroupData {
    public String id;
    public String name;
    public String header;
    public String footer;

    public GroupData(String id, String name, String header, String footer) {
        this.id = id;
        this.name = name;
        this.header = header;
        this.footer = footer;
    }

    public GroupData() {
        this("", "", "", "");
    }

    public GroupData withId(String id) {
        return new GroupData(id, this.name, this.header, this.footer);
    }

    public GroupData withName(String name) {
        return new GroupData(this.id, name, this.header, this.footer);
    }

    public GroupData withHeader(String header) {
        return new GroupData(this.id, this.name, header, this.footer);
    }

    public GroupData withFooter(String footer) {
        return new GroupData(this.id, this.name, this.header, footer);
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String header() {
        return header;
    }

    public String footer() {
        return footer;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (GroupData) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.header, that.header) &&
                Objects.equals(this.footer, that.footer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, header, footer);
    }

    @Override
    public String toString() {
        return "GroupData[" +
                "id=" + id + ", " +
                "name=" + name + ", " +
                "header=" + header + ", " +
                "footer=" + footer + ']';
    }

}