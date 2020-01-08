package javasmmr.zoowsome.views.utilities;

import java.util.ArrayList;

public class FieldValue {
    private ArrayList<String> fields;
    private ArrayList<String> values;

    public FieldValue(ArrayList<String> fields, ArrayList<String> values) {
        this.fields = fields;
        this.values = values;
    }

    public String getValueForField(String field) {
        for (int i = 0; i < fields.size(); i++) {
            if (fields.get(i).equals(field)) {
                return values.get(i);
            }
        }
        return null;
    }

}
