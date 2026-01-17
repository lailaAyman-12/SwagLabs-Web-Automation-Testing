package utils;

public class TestContext {

    private static double[] cartProductPrices;
    private static double cartProductsSum;

    public static double[] getCartProductPrices() {
        return cartProductPrices;
    }

    public static void setCartProductPrices(double[] prices) {
        cartProductPrices = prices;
        cartProductsSum = 0;

        if (prices != null) {
            for (double price : prices) {
                cartProductsSum += price;
            }
        }
    }

    public static double getCartProductsSum() {
        return cartProductsSum;
    }

    public static void reset() {
        cartProductPrices = null;
        cartProductsSum = 0;
    }
}