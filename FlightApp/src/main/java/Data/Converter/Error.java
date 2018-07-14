package Data.Converter;

public enum Error {
        NULL_OR_EMPTY {
            @Override
            public String toString() {
                return "no input or null";
            }
        },
        INVALID_CITY_NAME {
            @Override
            public String toString() {
                return "invalid City Name";
            }
        },
        INVALID_IANA_CODE {
            @Override
            public String toString() {
                return "invalid IANACode";
            }

        }
}
