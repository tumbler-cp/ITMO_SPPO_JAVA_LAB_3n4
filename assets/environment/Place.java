package assets.environment;

public class Place {
    private String place;
    public boolean suitNecessity;
    public boolean availability = true;

    public String getPlace() {
        return place;
    }


    public String toString(){
        return this.place;
    }

    @Override
    public int hashCode() {
        return 77*this.place.length();
    }

    @Override
    public boolean equals(Object obj) {
        Place sec = (Place) obj;
        if(this.hashCode()==sec.hashCode()) return this.place.equals(sec.place);
        else return false;
    }

    public Place(String location, boolean is_suit_necessary){
        this.place = location;
        this.suitNecessity = is_suit_necessary;
    }
    public Place(String location, boolean is_suit_necessary, boolean availability){
        this(location, is_suit_necessary);
        this.availability = availability;
    }
}
