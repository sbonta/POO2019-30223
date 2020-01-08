package javasmmr.zoowsome.views.utilities;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ObjectSelector {

    @NotNull
    public static ArrayList<Object> selectObjects(String className, @NotNull ArrayList<Object> items) {
        ArrayList<Object> result = new ArrayList<>();

        for (Object object : items) {
            try {
                if (Class.forName(className).isInstance(object)) {
                    result.add(object);
                }
            } catch (ClassNotFoundException ignored) {
            }
        }

        return result;
    }

    @NotNull
    public static String[] getFieldValues(@NotNull Object object) {
        ArrayList<String> strings = new ArrayList<>();
        Class<?> currentClass = object.getClass();
        Field[] fields;

        while (currentClass.getSuperclass() != null) {
            fields = currentClass.getDeclaredFields();

            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    strings.add(field.get(object).toString());
                } catch (IllegalAccessException ignored) {
                }
            }
            currentClass = currentClass.getSuperclass();
        }

        return strings.toArray(new String[0]);
    }

}
