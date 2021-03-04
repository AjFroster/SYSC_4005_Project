public class Product {
    private int productType;
    private double completionTime;

    public Product(int productType, double completionTime) {
        this.productType = productType;
        this.completionTime = completionTime;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public double getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(double completionTime) {
        this.completionTime = completionTime;
    }
}
