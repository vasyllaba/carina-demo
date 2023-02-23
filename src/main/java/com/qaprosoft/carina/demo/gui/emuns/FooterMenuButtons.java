package com.qaprosoft.carina.demo.gui.emuns;

public enum FooterMenuButtons {
    HOME("Home"),
    NEWS("News"),
    REVIEWS("Compare"),
    BLOG("Blog"),
    PHONE_FINDER("Phone Finder"),
    TOOLS("Tools"),
    COMPARE("Compare"),
    COVERAGE("Coverage"),
    GLOSSARY("Glossary"),
    CONTACT_US("Contact us"),
    EDITORIAL_TEAM("GSMArena.com");

    private final String footerElement;

    FooterMenuButtons(String footerElement) {
        this.footerElement = footerElement;
    }

    public String getButton() {
        return footerElement;
    }
}
