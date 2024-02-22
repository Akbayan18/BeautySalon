package kz.baibalaeva.success;

public class Salon {
    long id;
    String hair;
    int price;
    String master;

    public Salon() {
    }

    public Salon(long id, String hair, int price, String master) {
        this.id = id;
        this.hair = hair;
        this.price = price;
        this.master = master;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

}
