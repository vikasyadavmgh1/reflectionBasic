import java.lang.reflect.Field;
import java.lang.reflect.Method;

class class_to_reflect {
    private String first_name;
    public class_to_reflect(String name) {
        this.first_name = name;
    }

    public String getX() {
        return this.first_name;
    }
}

public class reflection_first {
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        class_to_reflect to_reflect = new class_to_reflect("vikas");
        Class c = to_reflect.getClass();

        String name_of_class = c.getName();
        System.out.println(name_of_class);
        try {
            // for(Field[] field: c.getFields()
            Field f = to_reflect.getClass().getDeclaredField("first_name");
            f.setAccessible(true);
            f.set(to_reflect, "Arjun");
            System.out.println("vk value is: "+f.get(to_reflect));

        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Method methods[] = c.getDeclaredMethods();
        for(Method method : methods) {
            System.out.println(method.getName());
            // method.invoke(methods, args)
        }

    }

}