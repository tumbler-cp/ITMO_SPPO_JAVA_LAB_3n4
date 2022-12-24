package assets.environment;

public class Place {
    private String place;
    public boolean availability = true;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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

    public Place(String location){
        this.place = location;
    }
    public Place(String location, boolean availability){
        this(location);
        this.availability = availability;
    }
}
