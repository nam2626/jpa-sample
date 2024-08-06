package controller;

public class HandlerMapping {
    private static HandlerMapping handler = new HandlerMapping();
    private HandlerMapping() {}
    public static HandlerMapping getInstance() {
        return handler;
    }
    public Controller createController(int command) {
        Controller controller = null;
        switch (command){
            case 1:
                controller = new RegisterController();
                break;
            case 2:
                controller = new FindController();
                break;
            case 3:
                controller = new ChangeController();
                break;
            case 4:
                controller = new RemoveController();
                break;
            case 5:
                controller = new ListController();
                break;
            case 6:
                controller = new SearchController();
                break;


        }
        return controller;
    }
}
