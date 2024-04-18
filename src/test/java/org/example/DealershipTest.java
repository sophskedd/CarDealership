package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealershipTest {
    Dealership dealership;
    @BeforeEach
    void setUp() {
        dealership = new Dealership();
        dealership.loadCarsFromFile();
    }

    @Test
    void add() {
        dealership.browse();
        dealership.add(new Car("Subaru", 260, "Blue", "Wagon", 8999));
        dealership.browse();
    }
}