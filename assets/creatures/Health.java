package assets.creatures;

public enum Health {
    HEALTHY(" здоров"),
    SICK(" болен");
    String str;
    Health(String a){
        this.str= a;
    }
    public String toString(){
        return this.str;
    }

}
