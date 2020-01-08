package javasmmr.zoowsome.services.constants;

import javasmmr.zoowsome.Helper;

public final class Constants {

    public final static Integer MAX_NUMBER_OF_FIELDS = 10;
    public final static Package CURRENT_PACKAGE = Helper.class.getPackage();

    public static final class Species {
        public static final String Mammals = "Mammals";
        public static final String Reptiles = "Reptiles";
        public static final String Birds = "Birds";
        public static final String Aquatics = "Aquatics";
        public static final String Insects = "Insects";
    }

    public static final class Animals {

        public static final class Aquatics {
            public static final String Crab = "CRAB";
            public static final String Frog = "FROG";
            public static final String Shark = "SHARK";
        }

        public static final class Birds {
            public static final String Parrot = "PARROT";
            public static final String Pigeon = "PIGEON";
            public static final String Sparrowhawk = "SPARROWHAWK";
        }

        public static final class Insects {
            public static final String Butterfly = "BUTTERFLY";
            public static final String Cockroach = "COCKROACH";
            public static final String Spider = "SPIDER";
        }

        public static final class Mammals {
            public static final String Cow = "COW";
            public static final String Monkey = "Monkey";
            public static final String Tiger = "TIGER";
        }

        public static final class Reptiles {
            public static final String Crocodile = "CROCODILE";
            public static final String Lizard = "LIZARD";
            public static final String Snake = "SNAKE";
        }
    }

    public static final class Employees {
        public static final String Caretaker = "CARETAKER";

        public static final class Caretakers {
            public static final String TCO_SUCCESS = "SUCCESS";
            public static final String TCO_KILLED = "KILLED";
            public static final String TCO_NO_TIME = "NO_TIME";
        }

    }

    public static final class XML_TAGS {
        public static final String EMPLOYEE = "EMPLOYEE";
        public static final String ANIMAL = "ANIMAL";
        public static final String DISCRIMINANT = "DISCRIMINANT";
    }

    public static final class FRAMES {
        public static final Integer WIDTH = 900;
        public static final Integer HEIGHT = 700;
    }
}
