package javasmmr.zoowsome.services.constants;

import javasmmr.zoowsome.views.utilities.ReflectionHelper;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ClassFinder {
    @NotNull
    public static ArrayList<String> getAllModels(Class<?> model) {
        ArrayList<String> models = new ArrayList<>();
        List<Class<?>> results = ReflectionHelper.findClassesImplementing(model, Constants.CURRENT_PACKAGE);
        for (Class<?> result : results) {
            if ((!result.isInterface()) && (!Modifier.isAbstract(result.getModifiers()))) {
                String[] tokens = result.toString().split("[.]");
                if (tokens.length > 0) {
                    models.add(tokens[tokens.length - 1]);
                }
            }
        }
        return models;
    }

    @NotNull
    public static ArrayList<String> getAllClasses(Class<?> model) {
        ArrayList<String> models = new ArrayList<>();
        try {
            Class<?> aClass = Class.forName("javasmmr.zoowsome.Helper");
            List<Class<?>> results = ReflectionHelper.findClassesImplementing(model, aClass.getPackage());
            for (Class<?> result : results) {
                if ((!result.isInterface()) && (!Modifier.isAbstract(result.getModifiers()))) {
                    models.add(result.getCanonicalName());
                }
            }
        } catch (ClassNotFoundException ignored) {
        }
        return models;
    }
}
