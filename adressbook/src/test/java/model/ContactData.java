package model;

public record ContactData
        (String firstName, String middleName, String lastName, String nickname, String title, String company,
         String address, String homePhone, String fax, String email, String homepage, String birthDay,
         String birthMonth, String birthYear, String group) {
    public ContactData() {
        this("", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
    }

    public ContactData withFirstName(String firstName) {
        return new ContactData(firstName, this.middleName, this.lastName,
                this.nickname, this.title, this.company, this.address,
                this.homePhone, this.fax, this.email, this.homepage,
                this.birthDay, this.birthMonth, this.birthYear, this.group);
    }

    public ContactData withMiddleName(String middleName) {
        return new ContactData(this.firstName, middleName, this.lastName,
                this.nickname, this.title, this.company, this.address,
                this.homePhone, this.fax, this.email, this.homepage,
                this.birthDay, this.birthMonth, this.birthYear, this.group);
    }

    public ContactData withLastName(String lastName) {
        return new ContactData(this.firstName, this.middleName, lastName,
                this.nickname, this.title, this.company, this.address,
                this.homePhone, this.fax, this.email, this.homepage,
                this.birthDay, this.birthMonth, this.birthYear, this.group);
    }

    public ContactData withNickname(String nickname) {
        return new ContactData(this.firstName, this.middleName, this.lastName,
                nickname, this.title, this.company, this.address,
                this.homePhone, this.fax, this.email, this.homepage,
                this.birthDay, this.birthMonth, this.birthYear, this.group);
    }

    public ContactData withTitle(String title) {
        return new ContactData(this.firstName, this.middleName, this.lastName,
                this.nickname, title, this.company, this.address,
                this.homePhone, this.fax, this.email, this.homepage,
                this.birthDay, this.birthMonth, this.birthYear, this.group);
    }

    public ContactData withCompany(String company) {
        return new ContactData(this.firstName, this.middleName, this.lastName,
                this.nickname, this.title, company, this.address,
                this.homePhone, this.fax, this.email, this.homepage,
                this.birthDay, this.birthMonth, this.birthYear, this.group);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.firstName, this.middleName, this.lastName,
                this.nickname, this.title, this.company, address,
                this.homePhone, this.fax, this.email, this.homepage,
                this.birthDay, this.birthMonth, this.birthYear, this.group);
    }

    public ContactData withHomePhone(String homePhone) {
        return new ContactData(this.firstName, this.middleName, this.lastName,
                this.nickname, this.title, this.company, this.address,
                homePhone, this.fax, this.email, this.homepage,
                this.birthDay, this.birthMonth, this.birthYear, this.group);
    }

    public ContactData withFax(String fax) {
        return new ContactData(this.firstName, this.middleName, this.lastName,
                this.nickname, this.title, this.company, this.address,
                this.homePhone, fax, this.email, this.homepage,
                this.birthDay, this.birthMonth, this.birthYear, this.group);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.firstName, this.middleName, this.lastName,
                this.nickname, this.title, this.company, this.address,
                this.homePhone, this.fax, email, this.homepage,
                this.birthDay, this.birthMonth, this.birthYear, this.group);
    }

    public ContactData withHomepage(String homepage) {
        return new ContactData(this.firstName, this.middleName, this.lastName,
                this.nickname, this.title, this.company, this.address,
                this.homePhone, this.fax, this.email, homepage,
                this.birthDay, this.birthMonth, this.birthYear, this.group);
    }

    public ContactData withBirthDay(String birthDay) {
        return new ContactData(this.firstName, this.middleName, this.lastName,
                this.nickname, this.title, this.company, this.address,
                this.homePhone, this.fax, this.email, this.homepage,
                birthDay, this.birthMonth, this.birthYear, this.group);
    }

    public ContactData withBirthMonth(String birthMonth) {
        return new ContactData(this.firstName, this.middleName, this.lastName,
                this.nickname, this.title, this.company, this.address,
                this.homePhone, this.fax, this.email, this.homepage,
                this.birthDay, birthMonth, this.birthYear, this.group);
    }

    public ContactData withBirthYear(String birthYear) {
        return new ContactData(this.firstName, this.middleName, this.lastName,
                this.nickname, this.title, this.company, this.address,
                this.homePhone, this.fax, this.email, this.homepage,
                this.birthDay, this.birthMonth, birthYear, this.group);
    }

    public ContactData withGroup(String group) {
        return new ContactData(this.firstName, this.middleName, this.lastName,
                this.nickname, this.title, this.company, this.address,
                this.homePhone, this.fax, this.email, this.homepage,
                this.birthDay, this.birthMonth, this.birthYear, group);
    }
}