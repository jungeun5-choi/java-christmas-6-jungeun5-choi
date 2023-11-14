package christmas.common.enumerator;

public enum BadgeType {
    STAR("별", 5000) {
        @Override
        public boolean isSatisfied(int totalDiscount) {
            return totalDiscount >= STAR.standard
                    && totalDiscount < TREE.standard;
        }
    },
    TREE("트리", 10000) {
        @Override
        public boolean isSatisfied(int totalDiscount) {
            return totalDiscount >= TREE.standard
                    && totalDiscount < SANTA.standard;
        }
    },
    SANTA("산타", 20000) {
        @Override
        public boolean isSatisfied(int totalDiscount) {
            return totalDiscount >= SANTA.standard;
        }
    };

    private final String name;
    private final int standard;

    BadgeType(String name, int standard) {
        this.name = name;
        this.standard = standard;
    }

    public String getName() {
        return name;
    }

    public abstract boolean isSatisfied(int totalDiscount);
}
