import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
  private ArrayList<LineSegment> segments = new ArrayList<>();

  /**
   * finds all line segments containing 4 or more points
   */
  public FastCollinearPoints(Point[] points) {
    if (points == null) {
      throw new java.lang.IllegalArgumentException();
    }
    for (Point p: points) {
      if (p == null) {
        throw new java.lang.IllegalArgumentException();
      }
    }

    Point[] copyPoints = points.clone();
    Arrays.sort(copyPoints);         //now copyPoints sorted by y-coordinate
    for (int i = 1; i < copyPoints.length; i++) {
      if (copyPoints[i-1].compareTo(copyPoints[i]) == 0) {
        throw new java.lang.IllegalArgumentException();
      }
    }

    for (int i = 0; i < copyPoints.length - 3; i++) {
      //this sort give us correct i-point
      Arrays.sort(copyPoints);

      Arrays.sort(copyPoints, copyPoints[i].slopeOrder());
      for (int p = 0, p1 = 1, pLast = 2; pLast < copyPoints.length ; ) {
        while (pLast < copyPoints.length &&
            Double.compare(copyPoints[p].slopeTo(copyPoints[p1]), copyPoints[p].slopeTo(copyPoints[pLast])) == 0) {
          pLast++;
        }

        if ( (pLast - p1 >= 3) && (copyPoints[p].compareTo(copyPoints[p1]) < 0) ) {
          segments.add(new LineSegment(copyPoints[p], copyPoints[pLast - 1]));
        }
        p1 = pLast;
      }

    }
  }

  /**
   * the number of line segments
   */
  public int numberOfSegments() {
    return segments.size();
  }

  /**
   * the line segments
   */
  public LineSegment[] segments() {
    LineSegment[] segmentsArray = new LineSegment[segments.size()];
    segmentsArray = segments.toArray(segmentsArray);
    return segmentsArray;
  }
}
