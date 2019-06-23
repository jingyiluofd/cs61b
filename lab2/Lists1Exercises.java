public class Lists1Exercises {
    /** Returns an IntList identical to L, but with
      * each element incremented by x. L is not allowed
      * to change. */
    public static IntList incrList(IntList L, int x) {
	if (L == null) {
	    return null;
	}
	IntList p = new IntList(L.first + x, null);
	p.rest = incrList(L.rest, x);
	return p;
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x. Not allowed to use
      * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        /* Your code here. */
        IntList head = new IntList(12312312, null);
	IntList p = head;
        while (L != null){
             p = L;
             p.first = L.first + x; 
             L = L.rest; 
             p = p.rest;
        }
        return p;
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(7, null);
        L.rest.rest = new IntList(9, null);


        // Test your answers by uncommenting. Or copy and paste the
        // code for incrList and dincrList into IntList.java and
        // run it in the visualizer.
        // System.out.println(L.get(1));
	IntList in = incrList(L, 3);
	while (in != null) {
	    System.out.println("v2:" + in.first);
	    in = in.rest;
	}

    }
}

