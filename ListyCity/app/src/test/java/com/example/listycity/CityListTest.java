package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Calgary", "Alberta");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("A", "B");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Calgary", "Alberta ");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }
    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City edmonton = new City("Edmonton", "Alberta");
        assertEquals(true, cityList.hasCity(edmonton));
    }

    @Test
    void testDeleteCity() {
        CityList cityList = mockCityList();
        City calgary = new City("Calgary", "Alberta");

        cityList.add(calgary);
        cityList.delete(calgary);

        assertEquals(false, cityList.hasCity(calgary));
    }

    @Test
    void testDeleteCityException() {
        CityList cityList = mockCityList();
        City vancouver = new City("Vancouver", "BC");

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(vancouver);
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();

        cityList.add(new City("Vancouver", "BC"));
        cityList.add(new City("Calgary", "Alberta"));

        assertEquals(3, cityList.countCities());
    }

}