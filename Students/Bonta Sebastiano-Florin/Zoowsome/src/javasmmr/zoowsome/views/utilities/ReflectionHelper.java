package javasmmr.zoowsome.views.utilities;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ReflectionHelper {

    @NotNull
    @Contract(pure = true)
    public static ArrayList<String> getAllFields(Class<?> aClass) {
        ArrayList<String> result = new ArrayList<>();

        Class<?> currentClass = aClass;
        Field[] fields;

        while (currentClass.getSuperclass() != null) {
            currentClass.getFields();
            fields = currentClass.getDeclaredFields();

            for (Field field : fields) {
                result.add(field.getName());
            }
            currentClass = currentClass.getSuperclass();
        }

        return result;
    }

    public static List<Class<?>> findClassesImplementing(final Class<?> interfaceClass, final Package fromPackage) {

        if (interfaceClass == null) {
            return null;
        }

        if (fromPackage == null) {
            return null;
        }

        final List<Class<?>> rVal = new ArrayList<>();
        try {
            final Class<?>[] targets = getAllClassesFromPackage(fromPackage.getName());
            for (Class<?> aTarget : targets) {
                if (aTarget != null) {
                    if (!aTarget.equals(interfaceClass)) {
                        if (interfaceClass.isAssignableFrom(aTarget)) {
                            rVal.add(aTarget);
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | IOException ignored) {
        }

        return rVal;
    }

    @NotNull
    public static Class<?>[] getAllClassesFromPackage(@NotNull final String packageName)
            throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class<?>> classes = new ArrayList<>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes.toArray(new Class[0]);
    }


    @NotNull
    public static List<Class<?>> findClasses(@NotNull File directory, String packageName)
            throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    assert !file.getName().contains(".");
                    classes.addAll(findClasses(file, packageName + "." + file.getName()));
                } else if (file.getName().endsWith(".class")) {
                    classes.add(Class.forName(packageName + '.' + file.getName().
                            substring(0, file.getName().length() - 6)));
                }
            }
        }
        return classes;
    }
}
