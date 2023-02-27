package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Line> lines = new ArrayList();
        Line line = new Line();
        Square square = new Square();
        Line[] arr = {line, square};

        lines.add(new Line(1, 3));
        lines.add(new Line(2, 7));
        lines.add(new Line(4, 6));

        lines.add(new Line(8, 10));
        lines.add(new Line(8, 12));

        lines.add(new Line(14, 18));
        lines.add(new Line(15, 20));

        List<Line> resultLines = joinCrossedLines(lines);
        for (Line line1e:
             resultLines) {

        System.out.println(line1e);
        }

    }

    public static int sum(int a, int b) {
        return a + b;

    }

    private static List<Line> joinCrossedLines(List<Line> lines) {

        List<Line> resultLines = new ArrayList();

        Line resultLine = lines.get(0);
        for (Line line : lines) {
            if (line.isCrossing(resultLine)) {
                int minStart = Math.min(line.getStart(), resultLine.getStart());
                int maxEnd = Math.max(line.getEnd(), resultLine.getEnd());
                resultLine.setStart(minStart);
                resultLine.setEnd(maxEnd);
            } else {
                resultLines.add(resultLine);
                lines.set(0, resultLine);
//                lines.add(0, resultLine);
                // call this function again and put in 'a'
                // add result 'a' in resultLines
                joinCrossedLines(lines);
            }
        }

        return resultLines;
    }
}