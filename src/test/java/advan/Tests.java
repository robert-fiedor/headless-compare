package advan;

import static advan.Utilities.logChecker;

public class Tests {

    public static void main(String[] args) {

//        logChecker("chrome", "getOwnPropertyLogs");
//        logChecker("chrome-headless", "getOwnPropertyLogs");

        /*
        Browser type:
                        chrome
                        chrome-headless
        Property Type:
                        getOwnPropertyLogs
                        getGlobalLogs
         */

        logChecker("chrome-headless", "getGlobalLogs");
        logChecker("chrome", "getGlobalLogs");

    }

}