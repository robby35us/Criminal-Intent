package com.bignerdranch.android.criminalintent.database;

import java.util.UUID;

/**
 * Created by rober on 12/31/2017.
 */

public class CrimeDbSchema {
    public static final class CrimeTable {
        public static final String NAME = "crimes";

        public static final class Cols{
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String HOUR = "hour";
            public static final String MINUTE = "minute";
            public static final String AM_PM = "am_pm";
            public static final String SOLVED = "solved";

        }
    }
}
