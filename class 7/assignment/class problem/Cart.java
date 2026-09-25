public class Cart {

    private final String cartId;
    private double[] prices;
    private int count;

    public Cart(String cartId, int capacity) {
        this.cartId = cartId;
        this.prices = new double[capacity];
        this.count = 0;
    }

    public String getCartId() {
        return cartId;
    }

    public void addItem(double price) {
        if (count < prices.length) {
            prices[count] = price;
            count++;
        }
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return count;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("cart.getTotal() -> " + (int) cart.getTotal());
        System.out.println("cart.getItemCount() -> " + cart.getItemCount());
    }
}