# Food_Delivery_Project

# 🍕 Food Delivery Simulation (Java)

A simple Java-based console application that simulates a food delivery system. The system allows customers to place orders at restaurants, and delivery agents are assigned to deliver orders based on availability and proximity.

## 🚀 Features

- Add and manage restaurants with menus.
- Register and manage customers.
- Place food orders with optional priority.
- Automatically assign nearest available delivery agents to orders.
- Calculate total delivery fee.
- Command-line interface for user interaction.

## 🧱 Project Structure

- `main.java` — Entry point that sets up data and handles user interaction.
- `Customer.java` — Handles customer details and order placement.
- `Restaurant.java` — Stores restaurant info and menu.
- `Order.java` — Represents an order and its logic.
- `DeliveryAgent.java` — Represents delivery agents and their availability.
- `Dispatcher.java` — Singleton class managing order dispatching.
- `Point.java` — Utility class for coordinates and distance calculation.
