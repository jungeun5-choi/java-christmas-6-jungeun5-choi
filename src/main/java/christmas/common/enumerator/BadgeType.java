package christmas.common.enumerator;

import christmas.badge.repository.BadgeRepository;

public enum BadgeType {
    STAR("별") {
        @Override
        public boolean isSatisfied(int totalDiscount) {
            int star = BadgeRepository.findRequiredAdvantageAmountByBadgeType(STAR);
            int tree = BadgeRepository.findRequiredAdvantageAmountByBadgeType(TREE);
            return totalDiscount >= star && totalDiscount < tree;
        }
    },
    TREE("트리") {
        @Override
        public boolean isSatisfied(int totalDiscount) {
            int tree = BadgeRepository.findRequiredAdvantageAmountByBadgeType(TREE);
            int santa = BadgeRepository.findRequiredAdvantageAmountByBadgeType(SANTA);
            return totalDiscount >= tree && totalDiscount < santa;
        }
    },
    SANTA("산타") {
        @Override
        public boolean isSatisfied(int totalDiscount) {
            int santa = BadgeRepository.findRequiredAdvantageAmountByBadgeType(SANTA);
            return totalDiscount >= santa;
        }
    };

    private final String name;

    BadgeType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract boolean isSatisfied(int totalDiscount);
}
