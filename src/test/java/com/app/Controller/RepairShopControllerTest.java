package com.app.Controller;
 
import com.app.model.RepairShop;
import com.app.repository.RepairShopRepository;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
 
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
 
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
 
class RepairShopControllerTest {
 
    @Mock
    private RepairShopRepository repository;
 
    @InjectMocks
    private RepairShopController controller;
 
    private AutoCloseable closeable;
 
    @BeforeAll
    static void beforeAll() {
        System.out.println("⚙️ Runs once before all tests");
    }
 
    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        System.out.println("➡️ Runs before each test");
    }
 
    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
        System.out.println("⬅️ Runs after each test");
    }
 
    @AfterAll
    static void afterAll() {
        System.out.println("🛑 Runs once after all tests");
    }
 
    @Test
    void testGetAllShops() {
        RepairShop shop1 = new RepairShop(1, "Shop A", "Location A", "12345", "Car");
        RepairShop shop2 = new RepairShop(2, "Shop B", "Location B", "67890", "Bike");
 
        when(repository.findAll()).thenReturn(Arrays.asList(shop1, shop2));
 
        List<RepairShop> result = controller.getAllShops();
 
        assertEquals(2, result.size());
        assertEquals("Shop A", result.get(0).getShopName());
        verify(repository, times(1)).findAll();
    }
 
    @Test
    void testCreateShop() {
        RepairShop shop = new RepairShop(1, "New Shop", "City", "11111", "Car");
        RepairShop savedShop = new RepairShop(1, "New Shop", "City", "11111", "Car");
 
        when(repository.save(shop)).thenReturn(savedShop);
 
        RepairShop result = controller.createShop(shop);
 
        assertNotNull(result.getId());
        assertEquals("New Shop", result.getShopName());
        verify(repository, times(1)).save(shop);
    }
 
    @Test
    void testUpdateShop() {
        RepairShop existing = new RepairShop(1, "Old Shop", "Old City", "22222", "Bike");
        RepairShop updateDetails = new RepairShop(2, "Updated Shop", "New City", "33333", "Car");
 
        when(repository.findById(1)).thenReturn(Optional.of(existing));
        when(repository.save(existing)).thenReturn(existing);
 
        RepairShop result = controller.updateShop(1, updateDetails);
 
        assertEquals("Updated Shop", result.getShopName());
        assertEquals("New City", result.getLocation());
        assertEquals("33333", result.getContactNumber());
        assertEquals("Car", result.getServiceType());
        verify(repository, times(1)).findById(1);
        verify(repository, times(1)).save(existing);
    }
 
    @Test
    void testDeleteShop() {
        doNothing().when(repository).deleteById(1);
 
        String result = controller.deleteShop(1);
 
        assertEquals("Shop deleted successfully!", result);
        verify(repository, times(1)).deleteById(1);
    }
}