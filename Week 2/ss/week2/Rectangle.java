package ss.week2;

public class Rectangle {
    private int length;
    private int width;
    
    //@ private invariant length >= 0;
    //@ private invariant width >= 0;
    
    /**
     * Create a new Rectangle with the specified length and width.
     */
    /**@
      requires theLength >= 0 && theWidth >= 0;
      ensures this.length() == theLength && width() == theWidth;
     */
    public Rectangle(int theLength, int theWidth) {
    	assert theLength >= 0;
    	assert theWidth >= 0;
    	length = theLength;
    	width = theWidth;
    }
    
    /**
     * The length of this Rectangle.
     */
    /**@
      pure;
      ensures \result >= 0;
     */
    public int length() {
    	assert length >= 0;
    	return length;
    }

    /**
     * The width of this Rectangle.
     */
    /**@
      pure;
      ensures \result >= 0;
     */
    public int width() {
    	assert width >= 0;
    	return width;
    }

    /**
     * The area of this Rectangle.
     */
    /**@
      pure;
      ensures \result >= 0;
      ensures \result = length() * width();
     */
    public int area() {
    	assert length >= 0;
    	assert width >= 0;
    	return length * width;
    }

    /**
     * The perimeter of this Rectangle.
     */
    /**@
      pure;
      ensures \result >= 2 * (length() + width());
     */
    public int perimeter() {
    	assert length >= 0;
    	assert width >= 0;
    	return 2 * (length + width);
    }
}
