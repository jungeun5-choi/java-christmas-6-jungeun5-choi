package christmas.common.enumerator;

public enum ApplicationState {
    CREATE_DATA {
        @Override
        public ApplicationState next() {
            return RECEIVE_ORDER_DATA;
        }
    },
    RECEIVE_ORDER_DATA {
        @Override
        public ApplicationState next() {
            return PRESENT_ORDER_DATA;
        }
    },
    PRESENT_ORDER_DATA {
        @Override
        public ApplicationState next() {
            return PROCESS_EVENT_PLANNER;
        }
    },
    PROCESS_EVENT_PLANNER {
        @Override
        public ApplicationState next() {
            return PRESENT_EVENT_PLANNER;
        }
    },
    PRESENT_EVENT_PLANNER {
        @Override
        public ApplicationState next() {
            return PRESENT_BADGE;
        }
    },
    PRESENT_BADGE {
        @Override
        public ApplicationState next() {
            return APPLICATION_QUIT;
        }
    },
    APPLICATION_QUIT {
        @Override
        public ApplicationState next() {
            return null;
        }
    };

    public abstract ApplicationState next();

    public boolean isAvailable() {
        return this != APPLICATION_QUIT;
    }
}