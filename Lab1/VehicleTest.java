import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
class VehicleTest {
    private final Vehicle vehicle1 = new Vehicle(10, "east");
    private final Vehicle vehicle2 = new Vehicle();
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        vehicle1.setSpeed(10);
        vehicle1.setDir("east");
        //System.out.println("setUp" + vehicle1.totalVehicle());
        vehicle2.setSpeed(0);
        vehicle2.setDir("north");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        vehicle1.finalize();

        vehicle2.finalize();
    }

    @org.junit.jupiter.api.Test
    void testFinalize() {
        int numOfTotalVehicle = vehicle1.totalVehicle();
        vehicle1.finalize();
        numOfTotalVehicle--;
        assertEquals(numOfTotalVehicle, vehicle1.totalVehicle());

        vehicle2.finalize();
        numOfTotalVehicle--;
        assertEquals(numOfTotalVehicle, vehicle2.totalVehicle());
    }

    @org.junit.jupiter.api.Test
    void setSpeed() {
        int newSpeed = 20;
        vehicle1.setSpeed(newSpeed);
        assertEquals(newSpeed, vehicle1.getSpeed());

        vehicle2.setSpeed(newSpeed);
        assertEquals(newSpeed, vehicle2.getSpeed());
    }

    @org.junit.jupiter.api.Test
    void setDir() {
        String newDir = "south";
        vehicle1.setDir(newDir);
        assertSame(newDir, vehicle1.getDir());

        vehicle2.setDir(newDir);
        assertSame(newDir, vehicle2.getDir());
    }

    @org.junit.jupiter.api.Test
    void getSpeed() {
        assertEquals(10, vehicle1.getSpeed());

        assertEquals(0, vehicle2.getSpeed());
    }

    @org.junit.jupiter.api.Test
    void getDir() {
        assertSame("east", vehicle1.getDir());

        assertSame("north", vehicle2.getDir());
    }

    @org.junit.jupiter.api.Test
    void totalVehicle() {
        assertEquals(0, vehicle1.totalVehicle());

        assertEquals(0, vehicle2.totalVehicle());
    }
}