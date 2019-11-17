public final class Utils {
    public static final void sort(Person[] people,Integer numberOfPeople) {
        for(int i = 0 ; i < numberOfPeople ;i ++) {
            for(int j = i + 1 ; j < numberOfPeople ; j ++) {
                if(people[i].isGreater(people[j])) {
                    Person person = people[i];
                    people[i] = people[j];
                    people[j] = person;
                }
            }
        }
    }
}
