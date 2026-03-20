import java.util.HashMap;
import java.util.Map;

// Immutable object using final class
final public class ImmutableRGB{
    final private int red;
    final private int green;
    final private int blue;
    final private String name;

    private void check(int red, int green, int blue){
        if(red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255){
            throw new IllegalArgumentException();
        }
    }
    public ImmutableRGB(int red, int green, int blue, String name){
        check(red, green, blue);
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.name = name;
    }
    public int getRGB(){
        return ((red << 16) | (green << 8) | blue);
    }
    public String getName(){
        return name;
    }
    public ImmutableRGB invert(){
        return new ImmutableRGB(255 - red, 255 - green, 255 - blue, "Inverse of " + name);
    }
}

// Immutable object using private constructor
public static class Color{
    private final int red;
    private final int green;
    private final int blue;
    private final String name;

    private static final Map<String, Color> predefinedColors = new HashMap<>();

    private void checkRange(int red, int green, int blue){
        if(red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255){
            throw new IllegalArgumentException("Color values must be 0-255");
        }
    }

    private Color(int red, int green, int blue, String name){
        checkRange(red, green, blue);
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.name = name;
    }

    public static Color of(int red, int green, int blue, String name){
        String key = red + "-" + green + "-" + blue + "-" + name;
        if(predefinedColors.containsKey(key)){
            return predefinedColors.get(key);
        }
        Color color = new Color(red, green, blue, name);
        predefinedColors.put(key, color);
        return color;
    }
    public static Color black(){
        return Color.of(255, 255, 255, "White");
    }
    public static Color white(){
        return Color.of(0, 0, 0, "Black");
    }
    public Color invert(){
        return Color.of(255 - red, 255 - green, 255 - blue, "Inverse of " + name);
    }
}

// Copy Object in Constructor
class Event {
    private final Date date;

    public Event(Date date){
        this.date = new Date(date.getTime());
    }
    public Date getDate(){
        return new Date(date.getTime());
    }
}
void main() {
    // Immutable object using final class
    ImmutableRGB obj1 = new ImmutableRGB(222, 167, 89, "green");
    ImmutableRGB obj2 = obj1.invert();

    // Immutable object using private constructor
    Color c1 = Color.of(100, 150, 200, "MyBlue");
    Color c2 = c1.invert();

    System.out.println(c1);
    System.out.println(c2);

    Color black1 = Color.black();
    Color black2 = Color.black();
    System.out.println(black1 == black2);

    // Copy Object in Constructor
    Date d = new Date();
    Event e = new Event(d);

    d.setTime(0);
    System.out.println(e.getDate());
    e.getDate().setTime(0);
    System.out.println(e.getDate());
}