package advan;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CompareTheLogsFindDifference {

//    static String file1 = "chrome-getGlobalLogs.txt";
//    static String file2 = "chrome-headless-getGlobalLogs.txt";

    static String file1 = "manual-chrome-getGlobalLogs.txt";
    static String file2 = "manual-chrome-getOwnPropertyLogs.txt";

//    static String file1 = "chrome-getOwnPropertyLogs.txt";
//    static String file2 = "chrome-headless-getOwnPropertyLogs.txt";

    public static void main(String[] args) throws IOException {

        File file1Logs = new File(file1);
        BufferedReader file1LogsBuffered = new BufferedReader(new FileReader(file1Logs));

        String[] file1LogsInArray = file1LogsBuffered.readLine().split(",");

        File file2Logs = new File(file2);
        BufferedReader file2LogsBuffered = new BufferedReader(new FileReader(file2Logs));

        String[] file2LogsInArray = file2LogsBuffered.readLine().split(",");

        List<String> file1LogsListed = Arrays.asList(file1LogsInArray);

        System.out.println("file1LogsListed.size() = " + file1LogsListed.size());
        System.out.println("file1LogsListed = " + file1LogsListed);
        List<String> file2LogsListed = Arrays.asList(file2LogsInArray);
        System.out.println("file2LogsListed.size() = " + file2LogsListed.size());

        System.out.println("file2LogsListed = " + file2LogsListed);
        Set<String> setOfFile1Logs = new HashSet<>(file1LogsListed);
        setOfFile1Logs.removeAll(file2LogsListed);

        Set<String> setOfFile2Logs = new HashSet<>(file2LogsListed);
        setOfFile2Logs.removeAll(file1LogsListed);

        System.out.println("Unique SetOfFile2Logs = " + setOfFile2Logs);
        System.out.println("Unique SetOfFile1Logs = " + setOfFile1Logs);

    }
}
