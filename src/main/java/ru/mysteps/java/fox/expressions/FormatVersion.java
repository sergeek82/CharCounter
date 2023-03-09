package ru.mysteps.java.fox.expressions;

public enum FormatVersion {
    CUSTOM_ONE("The repeats of \"%c\" character = %d%n"),
    CUSTOM_TWO("Character \"%c\" was repeated %d times%n"),
    OFFICIAL("\"%c\" = %d%n");

    private String version;

    FormatVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }
}