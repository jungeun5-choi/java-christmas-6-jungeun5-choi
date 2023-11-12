package christmas.common.enumerator;

import christmas.common.Controller;

public enum ApplicationState {
    CREATE {
        @Override
        public void execute(Controller controller) {
            controller.create();
        }
    };

    public abstract void execute(Controller controller);
}
