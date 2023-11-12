package christmas.util.enumerator;

public enum BadgeType {
    STAR("별"),
    TREE("트리"),
    SANTA("산타");

    private final String name;

    BadgeType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
