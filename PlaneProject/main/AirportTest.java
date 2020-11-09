package PlaneProject.main;

import PlaneProject.model.Plane;
import PlaneProject.service.PlaneService;

public class AirportTest {
    public static void main(String[] args) {

        PlaneService ps = new PlaneService();

        Plane p1 = ps.create();
        Plane p2 = ps.create();
        Plane p3 = ps.create();
        Plane[] array = {p1,p2,p3};
        ps.printInfo(p1);
        ps.planeNewer(p1, p2);
        ps.planeWithBiggerWingspan(p1, p2);
        ps.planeWithHighestCost(p1,p2,p3);
        ps.smallestSeatCount(p1,p2,p3);
        ps.minimalCostMilitaryPlanes(array);
        ps.minimalWeight(array);
        ps.printAcsendingOrderYear(array);
        ps.printDescendingBySeats(array);
        ps.printIfMilitary(p2);
        ps.printNotMilitaryPlanes(array);
        ps.printMilitaryAnd100Hours(array);

    }

}
