package entities;

public class Product {

    private String name;
    private int price;
    private int weight;
    private String manufacturer;

    private int id1;
    private String name1;
    private int price1;
    private int weight1;
    private String manufacturer1;

    public Product(int id1, String name1, int price1, int weight1, String manufacturer1) {
        this.id1 = id1;
        this.name1 = name1;
        this.price1 = price1;
        this.weight1 = weight1;
        this.manufacturer1 = manufacturer1;
    }

    public Product(String name,int price, int weight, String manufacturer) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.manufacturer = manufacturer;
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public int getPrice1() {
        return price1;
    }

    public void setPrice1(int price1) {
        this.price1 = price1;
    }

    public int getWeight1() {
        return weight1;
    }

    public void setWeight1(int weight1) {
        this.weight1 = weight1;
    }

    public String getManufacturer1() {
        return manufacturer1;
    }

    public void setManufacturer1(String manufacturer1) {
        this.manufacturer1 = manufacturer1;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }



}
