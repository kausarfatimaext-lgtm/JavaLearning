import java.io.ObjectStreamException;
import java.io.Serial;
import java.io.Serializable;

// Simple Singleton
public static class SingletonLazy{
    private static SingletonLazy sc = null;
    private SingletonLazy(){}
    public static SingletonLazy getInstance(){
        if(sc == null){
            sc = new SingletonLazy();
        }
        return sc;
    }
}

// Synchronized Method
public static class SingletonLazyMultithreaded {
    private static SingletonLazyMultithreaded sc = null;
    private SingletonLazyMultithreaded(){}
    public static synchronized SingletonLazyMultithreaded getInstance(){
        if(sc == null){
            sc = new SingletonLazyMultithreaded();
        }
        return sc;
    }
}

// Double-Checked Locking
public static class SingletonLazyDoubleCheck {
    private volatile static SingletonLazyDoubleCheck sc = null;

    private SingletonLazyDoubleCheck() {
    }

    public static SingletonLazyDoubleCheck getInstance() {
        if (sc == null) {
            synchronized (SingletonLazyDoubleCheck.class) {
                if (sc == null) {
                    sc = new SingletonLazyDoubleCheck();
                }
            }
        }
        return sc;
    }
}

// Prevent on Serialization, Clonable, Reflection and class loaders
public static class Singleton implements Serializable {
    private static final long serialVersionUID =  -1093810940935189395L;
    private static Singleton sc = new Singleton();
    private Singleton(){
        if(sc != null){
            throw new IllegalArgumentException("Already created.");
        }
    }
    public static Singleton getInstance(){
        return sc;
    }

    @Serial
    private Object readResolve() throws ObjectStreamException {
        return sc;
    }

    @Serial
    private Object writeReplace() throws ObjectStreamException{
        return sc;
    }

    public Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException("Singleton, cannot be cloned");
    }

    private static Class getClass(String classname) throws ClassNotFoundException{
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if(classLoader == null){
            classLoader = Singleton.class.getClassLoader();
        }
        return (classLoader.loadClass(classname));
    }
}

void main() throws IOException, ClassNotFoundException {
    // Simple Singleton
    SingletonLazy.getInstance();

    // Synchronized Method
    SingletonLazyMultithreaded.getInstance();

    // Double-Checked Locking
    SingletonLazyDoubleCheck.getInstance();

    // Prevent on Serialization, Clonable, Reflection and class loaders
    Singleton obj1 = Singleton.getInstance();

    // 1. Serialization Test
    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("file.ser"));
    out.writeObject(obj1);
    out.close();

    ObjectInputStream in = new ObjectInputStream(new FileInputStream("file.ser"));
    Singleton obj2 = (Singleton) in.readObject();
    in.close();

    System.out.println("Serialization Safe: " + (obj1 == obj2));

    // 2. Cloning Test
    try {
        Singleton obj3 = (Singleton) obj1.clone();
        System.out.println("Cloning Safe: " + (obj1 == obj3));
    } catch (Exception e) {
        System.out.println("Cloning Blocked: " + e.getMessage());
    }

    // 3. Reflection Test
    try {
        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        Singleton obj4 = constructor.newInstance();
        System.out.println("Reflection Safe: " + (obj1 == obj4));
    } catch (Exception e){
        System.out.println("Reflection Blocked: " + e.getMessage());
    }

    // 4. ClassLoader Test (Basic)
    try {
        Class<?> clazz = Singleton.getClass("com.javacodegeeks.patterns.singletonpattern.Singleton");
        Object obj5 = clazz.getDeclaredMethod("getInstance").invoke(null);

        System.out.println("ClassLoader Safe: " + (obj1 == obj5));
    } catch (Exception e) {
        System.out.println("ClassLoader Issue: " + e.getMessage());
    }
}