package pl.dawid.web.car;

class Car {
    private String make;
    private String model;
    private int productionYear;
    private String color;
    Car(){}

    String getMake() {
        return make;
    }

    void setMake(String make) {
        this.make = make;
    }

    String getModel() {
        return model;
    }

    void setModel(String model) {
        this.model = model;
    }

    int getProductionYear() {
        return productionYear;
    }

    void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    String getColor() {
        return color;
    }

    void setColor(String color) {
        this.color = color;
    }
}
