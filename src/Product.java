public class Product {
    public enum productType{ONE, TWO, THREE}
    private productType pType;
    private double completionTime;

    public Product(productType pType, double completionTime) {
        this.pType = pType;
        this.completionTime = completionTime;
    }

    public productType getProductType() {
        return pType;
    }

    public void setProductType(productType productType) {
        this.pType = productType;
    }

    public double getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(double completionTime) {
        this.completionTime = completionTime;
    }
}
