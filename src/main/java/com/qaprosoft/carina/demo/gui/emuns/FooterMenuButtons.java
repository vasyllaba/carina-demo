package com.qaprosoft.carina.demo.gui.emuns;

public enum FooterMenuButtons {
    HOME(0),
    NEWS(1),
    REVIEWS(2),
    COMPARE(3),
    COVERAGE(4),
    GLOSSARY(5),
    FAQ(6),
    RSS_FEED(7),
    YOUTUBE(8),
    FACEBOOK(9),
    TWITTER(10),
    INSTAGRAM(11),
    TEAM(12),
    MOBILE_VERSION(13),
    ANDROID_APP(14),
    TOOLS(15),
    CONTACT_US(16),
    MERCH_STORE(17),
    PRIVACY(18),
    TERM_OF_USE(19);

    private final int footerElement;

    FooterMenuButtons(int footerElement) {
        this.footerElement = footerElement;
    }

    public int getButtonIndex() {
        return footerElement;
    }
}
