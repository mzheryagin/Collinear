import java.util.Arrays;
public class BruteCollinearPoints {

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
    Arrays.sort(points);
    for (int i = 1; i < points.length; i++) {
      if (points[i-1].compareTo(points[i]) == 0) {
        throw new java.lang.IllegalArgumentException();
      }
    }

  }

  /**
   * the number of line segments
   */
  public int numberOfSegments() {

  }

  /**
   * // the line segments
   */
  public LineSegment[] segments() {

  }
}
