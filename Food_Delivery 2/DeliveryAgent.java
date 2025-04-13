class DeliveryAgent {
    int id;
    Point location;
    DriverStatus status;

    public DeliveryAgent(int id, Point location) {
        this.id = id;
        this.location = location;
        this.status = DriverStatus.FREE;
    }

    public void assignOrder(Order order) {
        if (this.status == DriverStatus.FREE) {
            this.status = DriverStatus.BUSY;
            order.assignedDriver = this;
            order.updateStatus(OrderStatus.DEPLOYED);
            System.out.println("Driver " + id + " assigned to Order " + order.id + " and is heading to deliver.");
        }
    }

    public void deliverOrder(Order order) {
        Point destination = order.getCustomerLocation();
        int x = location.x;
        int y = location.y;
        int destX = destination.x;
        int destY = destination.y;

        System.out.println("Driver " + id + " starting delivery from (" + x + "," + y + ") to (" + destX + "," + destY + ")");

        while (x != destX || y != destY) {
            if (x < destX) x++;
            else if (x > destX) x--;

            if (y < destY) y++;
            else if (y > destY) y--;

            this.location = new Point(x, y);
            System.out.println("Driver " + id + " moved to location (" + x + "," + y + ")");

            try {
                Thread.sleep(300); // Simulate time delay for movement
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        order.updateStatus(OrderStatus.DELIVERED);
        System.out.println("Driver " + id + " delivered Order " + order.id + " to Customer " + order.customer.name);
        this.status = DriverStatus.FREE;
        System.out.println("Driver " + id + " is now FREE.");
    }

    public void setBusy(boolean busy) {
        this.status = busy ? DriverStatus.BUSY : DriverStatus.FREE;
    }

    public boolean isFree() {
        return this.status == DriverStatus.FREE;
    }
}
