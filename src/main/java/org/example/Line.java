package org.example;

public class Line {
    private int start;
    private int end;

    public Line() {
    }

    public Line(int start, int end) {
        setStart(start);
        setEnd(end);
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        if (start < 0) {
            throw new IllegalArgumentException("Start cannot be negative");
        }
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        if (end < 0) {
            throw new IllegalArgumentException("End cannot be negative");
        }
        if (end < this.start) {
            throw new IllegalArgumentException("End cannot less than start");
        }
        this.end = end;
    }

    public boolean isCrossing(Line anotherLine) {
        return getStart() >= anotherLine.getStart() && getStart() <= anotherLine.getEnd()
                || getEnd() >= anotherLine.getStart() && getEnd() <= anotherLine.getEnd();
    }

    @Override
    public String toString() {
        return start + " " + end;
    }
}
