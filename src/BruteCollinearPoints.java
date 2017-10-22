import java.util.ArrayList;
import java.util.Arrays;


public class BruteCollinearPoints {
  private ArrayList<LineSegment> segments = new ArrayList<>();
  /**
   * finds all line segments containing 4 points
   * Throw a java.lang.IllegalArgumentException if the argument to the constructor is null,
   * if any point in the array is null, or if the argument to the constructor contains a repeated point.
   * @param points
   */
  public BruteCollinearPoints(Point[] points) {
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

    for (int p = 0; p < copyPoints.length - 3; p++) {
      for (int q = p + 1; q < copyPoints.length - 2; q++) {
        for (int r = q + 1; r < copyPoints.length - 1; r++) {
          for (int s = r + 1; s < copyPoints.length; s++) {
            if (isCollinear(copyPoints[p], copyPoints[q], copyPoints[r], copyPoints[s])) {
              segments.add(new LineSegment(copyPoints[p], copyPoints[s]));
            }
          }
        }
      }
    }
  }

  private static boolean isCollinear(Point p, Point q, Point r, Point s) {
    if ( (p.slopeTo(q) == p.slopeTo(r)) && (p.slopeTo(r) == p.slopeTo(s)) ) {
      return true;
    } else {
      return false;
    }
  }

 /**
   * the number of line segments
   */
  public int numberOfSegments() {
    return segments.size();
  }

  /**
   * // the line segments
   */
  public LineSegment[] segments() {
    LineSegment[] segmentsArray = new LineSegment[segments.size()];
    segmentsArray = segments.toArray(segmentsArray);
    return segmentsArray;
  }
}
