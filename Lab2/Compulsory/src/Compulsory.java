public class Compulsory {
    public static void main(String args[])
    {
        Location L1 = new Location("L1", LocationType.City, 14, 15);
        Location L2 = new Location("L2", LocationType.City, 24, 53);
        Location L3 = new Location("L3", LocationType.City, 12, 54);

        Road R1 = new Road("R1", RoadType.Highway, 140, 100, L1, L2);
        Road R2 = new Road("R2", RoadType.ExpressRoad, 70, 113, L2, L3);
        Road R3 = new Road("R3", RoadType.CountryRoad, 50, 214, L3, L1);

        System.out.println(L1);
        System.out.println(R2);
        System.out.println("Length of R3: " + R3.getLength() + " km");
        System.out.println("Speed limit of R1: " + R1.getSpeedLimit() + " km/h");
    }
}
