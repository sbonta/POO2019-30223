package javasmmr.zoowsome.views.utilities;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ConstructorHelper {

    @NotNull
    public static Object createObject(String className, @NotNull ArrayList<String> fields, ArrayList<String> values)
            throws IllegalAccessException, InvocationTargetException, InstantiationException,
            ClassNotFoundException, NoSuchMethodException {

        FieldValue fieldValue = new FieldValue(fields, values);
        Class<?> aClass = Class.forName(className);
        Object object = aClass.getDeclaredConstructor().newInstance();

        while (aClass != null) {
            try {
                Method method = aClass.getMethod("setValuesFromField", FieldValue.class);
                method.invoke(object, fieldValue);
                break;
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                aClass = aClass.getSuperclass();
            }
        }
        return object;
    }

}
