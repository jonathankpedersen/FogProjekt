package business.entities;

public class Carport {
    String length;
    String width;
    boolean shed;

    public Carport(String length, String width, boolean shed) {
        this.length = length;
        this.width = width;
        this.shed = shed;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public boolean isShed() {
        return shed;
    }

    public void setShed(boolean shed) {
        this.shed = shed;
    }
}
