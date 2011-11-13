package com.pokle.robot;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Command {

    private static final Pattern PLACE_PATTERN = Pattern.compile("PLACE\\W*(\\d+)\\W*,\\W*(\\d+)\\W*,\\W*(\\w+)");


    public static void main(String args[]) throws IOException {

        if (args.length == 0) {
            System.err.println("Missing file(s) on the command line");
            System.exit(1);
        }

        for (String filename : args) {
            simulateFile(filename);
        }
    }

    private static void simulateFile(String filename) throws IOException {
        final LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(filename));
        try {
            System.out.println("Simulating file: " + filename);
            Robot robot = new Robot();
            String line;
            while (null != (line = lineNumberReader.readLine())) {
                processCommand(line, robot);
            }
        } finally {
            try {
                lineNumberReader.close();
            } catch (IOException ioe) { /* innocuous */ }
        }
    }


    private static void processCommand(String line, Robot robot) {
        line = line.trim();
        if (line.equalsIgnoreCase("MOVE")) {
            robot.move();
        } else if (line.equalsIgnoreCase("LEFT")) {
            robot.left();
        } else if (line.equalsIgnoreCase("RIGHT")) {
            robot.right();
        } else if (line.equalsIgnoreCase("REPORT")) {
            System.out.println(robot.getVector());
        } else {
            Matcher matcher = PLACE_PATTERN.matcher(line);
            if (matcher.matches()) {
                Vector vec = new Vector(Integer.valueOf(matcher.group(1)),
                        Integer.valueOf(matcher.group(2)),
                        Cardinal.valueOf(matcher.group(3))
                );
                robot.place(vec);
            } else {
                System.err.println("ERROR> " + line);
            }
        }
    }

}
