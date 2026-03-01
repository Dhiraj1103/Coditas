package com.reports.model;

public class Report {

    private final int id;
    private final String name;

    public Report(int id) {
        this.id = id;
        this.name = "Report-" + id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
