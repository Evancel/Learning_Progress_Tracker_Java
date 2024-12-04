package tracker;

public enum Commands {
    EXIT("exit"),
    ADD("add students"),
    LIST("list"),
    ADD_POINTS("add points"),
    FIND("find"),
    STATISTICS("statistics"),
    NOTIFY("notify"),
    BACK ("back");

    private String description;
    Commands(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
}
