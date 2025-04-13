# Food_Delivery_Project

# 🍕Food Delivery Simulation

This is a Java-based simulation of a food delivery system that mimics real-world food ordering and dispatching workflows. It includes customers, restaurants, delivery agents, and a central dispatcher to manage orders.

## 🧱Features

- **Customers** can place orders to available restaurants.
- **Restaurants** have menus with item prices.
- **Delivery Agents** are dynamically assigned to orders based on availability and proximity.
- **Dispatcher** matches accepted orders with the nearest available drivers.
- **Dynamic Delivery Fee** is calculated based on linear regression using distance between customer and restaurant.
- **Drivers** move step-by-step to the customer location to simulate real-time delivery.

## 🚀How It Works

1. **Startup:**
   - Menu and location of restaurants are hardcoded.
   - Delivery agents are added with initial coordinates.
   - Two customers are pre-defined for simplicity.

2. **Order Placement:**
   - Run the program.
   - Choose to place an order by selecting customer ID, restaurant ID, menu item, and whether it's a priority order.
   - A delivery fee is calculated based on distance and item price.

3. **Dispatching Orders:**
   - Choose to dispatch orders.
   - Dispatcher finds the nearest **FREE** driver to the restaurant and assigns the order.
   - Driver "moves" step-by-step to the customer location.
   - Upon reaching, the order is marked **DELIVERED**, and the driver becomes free.

4. **Driver Behavior:**
   - Drivers can be busy due to a delivery or manually (simulating rest or break).
   - A busy driver cannot be reassigned to a new delivery.


1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/food-delivery-sim.git
   cd food-delivery-sim
