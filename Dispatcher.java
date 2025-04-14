import java.util.ArrayList;
import java.util.List;

class Dispatcher {
    private static Dispatcher instance = null;
    List<Order> orders = new ArrayList<>();
    List<DeliveryAgent> drivers = new ArrayList<>();
    List<Restaurant> restaurants = new ArrayList<>();

    private Dispatcher() {}

    public static Dispatcher getInstance() {
        if (instance == null) instance = new Dispatcher();
        return instance;
    }

    public void addOrder(Order order) {
        orders.add(order);
        System.out.println("Order added: " + order.id + " from " + order.restaurant.name + " for " + order.customer.name);
    }

    public void addDriver(DeliveryAgent driver) {
        drivers.add(driver);
        System.out.println("Driver added: ID " + driver.id + " at location " + driver.location);
    }

    public void addRestaurant(Restaurant r) {
        restaurants.add(r);
        System.out.println("Restaurant added: " + r.name + " at location " + r.location);
    }

    public void dispatchOrders() {
        System.out.println("\n--- Dispatching Orders ---");

        List<Order> priority = orders.stream().filter(o -> o.isPriority && o.status == OrderStatus.ACCEPTED).toList();
        List<Order> normal = orders.stream().filter(o -> !o.isPriority && o.status == OrderStatus.ACCEPTED).toList();

        System.out.println("Priority Orders: " + priority.size());
        System.out.println("Normal Orders: " + normal.size());

        List<Order> all = new ArrayList<>();
        all.addAll(priority);
        all.addAll(normal);

        for (Order order : all) {
            System.out.println("Trying to dispatch Order " + order.id + " for " + order.customer.name);

            DeliveryAgent nearest = null;
            double minDist = Double.MAX_VALUE;
            for (DeliveryAgent driver : drivers) {
                if (driver.isFree()) {
                    double dist = Point.distance(driver.location, order.restaurant.location);
                    System.out.println("Driver " + driver.id + " is FREE. Distance to restaurant: " + dist);
                    if (dist < minDist) {
                        minDist = dist;
                        nearest = driver;
                    }
                }
            }

            if (nearest != null) {
                System.out.println("Nearest driver found: Driver " + nearest.id + ". Dispatching now...");
                nearest.assignOrder(order);
                nearest.deliverOrder(order);
            } else {
                System.out.println("No FREE driver available for Order " + order.id);
            }
        }

        System.out.println("--- Dispatch Completed ---\n");
    }
}
