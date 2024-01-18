import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BlackBoxTest {

    public BlackBoxTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        // Code that runs once before all tests
    }

    @AfterAll
    public static void tearDownClass() {
        // Code that runs once after all tests
    }

    @BeforeEach
    public void setUp() {
        // Code that runs before each test
    }

    @AfterEach
    public void tearDown() {
        // Code that runs after each test
    }

    @Test
    public void testConstructorAndGetters() {
        W1908160CWProducts product = new ConcreteProduct("123", "TestProduct", 19.99);

        assertEquals("123", product.getProductID());
        assertEquals("TestProduct", product.getProductName());
        assertEquals(19.99, product.getProductPrice(), 0.001); // Delta is used for floating-point comparison
    }

    @Test
    public void testSetters() {
        W1908160CWProducts product = new ConcreteProduct();

        product.setProductID("456");
        product.setProductName("UpdatedProduct");
        product.setProductPrice(29.99);

        assertEquals("456", product.getProductID());
        assertEquals("UpdatedProduct", product.getProductName());
        assertEquals(29.99, product.getProductPrice(), 0.001);
    }

    @Test
    public void testCompareTo() {
        W1908160CWProducts product1 = new ConcreteProduct("123", "TestProduct1", 19.99);
        W1908160CWProducts product2 = new ConcreteProduct("456", "TestProduct2", 29.99);

        assertTrue(product1.compareTo(product2) < 0);
    }
}
