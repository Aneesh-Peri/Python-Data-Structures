public class Station{
    private int myZone;
    private String myStation;
    public Station()
    {
        myZone = 0;
        myStation = null;
    }

    public Station(String station,int zone)
    {
        this.myStation = station;
        this.myZone = zone;
    }

    public String getName()
    {
        return myStation;
    }

    public int getZone()
    {
        return myZone;
    }

    public String toString()
    {
        return "" + getName() + " zone " + getZone() + "";
    }


}
