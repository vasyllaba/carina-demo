package com.qaprosoft.carina.demo.gui.emuns;

public enum FooterMenuButtons {
    HOME(0),
    NEWS(1),
    REVIEWS(2),
    BLOG(3),
    PHONE_FINDER(4),
    TOOLS(5),
    COMPARE(6),
    COVERAGE(7),
    GLOSSARY(8),
    CONTACT_US(9),
    EDITORIAL_TEAM(10);

    private final int footerElement;

    FooterMenuButtons(int footerElement) {
        this.footerElement = footerElement;
    }

    public int getButton() {
        return footerElement;
    }
}
