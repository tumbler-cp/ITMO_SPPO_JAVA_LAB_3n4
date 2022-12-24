package assets.creatures.tech;

public enum techHealth {
    BROKEN("сломан(-а)"),
    NORMAL("в норме");
    String text;
    techHealth(String s){
        text = s;
    }
    public String toString(){
        return this.text;
    }
}
