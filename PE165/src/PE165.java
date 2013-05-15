import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class PE165 {
	
	private final static long S0 = 290797;
	   private final static long MOD1 = 50515093;
	   private final static long MOD2 = 500;
	
	public static void main(String[] args) {
		long startTime = System.nanoTime();

		PE165 pb = new PE165();
	    String answer = pb.solveIt();
	    System.out.println("Answer: " + answer);
		
		long endTime = System.nanoTime();
		System.out.printf("Total Time: %.6f seconds\n",
				((endTime - startTime) / 1000000000.0));

	}
	
	private String solveIt() {
	      ArrayList<Segment> data = new ArrayList<Segment>();
	      long sval = S0;
	      for (int seg=0; seg<5000; seg++) {
	         long a[] = new long[4];
	         for (int i=0; i<4; i++) {
	            sval = (sval * sval) % MOD1;
	            long tval = sval % MOD2;
	            a[i] = tval;
	         }
	         data.add(new Segment(a[0],a[1],a[2],a[3]));
	      }
	      int answer = compute(data);
	      StringBuilder sb = new StringBuilder();
	      sb.append(answer);
	      return (sb.toString());
	   }
	   private static int compute(ArrayList<Segment> inDatax) {
	      int count = 0;
	      int debug = 0;
	      //
	      // The next two for loops make take the line segments and merge
	      // overlapping segments into one segment.  This eliminates duplicates
	      // where two overlapping segments intersect another segment.
	      //
	      HashMap<String,ArrayList<Segment>> lhash =
	            new HashMap<String,ArrayList<Segment>>();
	      for (int i=0; i<inDatax.size(); i++) {
	        	Segment aline = inDatax.get(i);
	        	Fraction aslope = aline.getRealSlope();
	        	String key = "inf";
	        	if (aslope != null) {
	        		key = aslope.toString();
	        	}
	        	ArrayList<Segment> lyst = lhash.get(key);
	        	if (lyst == null) {
	        		ArrayList<Segment> nulyst = new ArrayList<Segment>();
	        		nulyst.add(aline);
	        		lhash.put(key,nulyst);
	        	}
	        	else {
	        		lyst.add(aline);
	        		lhash.put(key,lyst);
	        	}
	      }
	      ArrayList<Segment> fData = new ArrayList<Segment>();
	      Set<String> keyz = lhash.keySet();
	      for (String strKey : keyz) {
	         ArrayList<Segment> tarray = lhash.get(strKey);
	         boolean looper = true;
	         while (looper) {
	            looper = false;
	           loopy: 
	            for (int i=0; i<tarray.size()-1; i++) {
	               Segment aline = tarray.get(i);
	               for (int j=i+1; j<tarray.size(); j++) {
	                  Segment bline = tarray.get(j);
	                  Segment gnuseg = aline.segOverlap(bline);
	                  if (gnuseg != null) {
	                     tarray.remove(j);
	                     tarray.set(i, gnuseg);
	                     looper = true;
	                     break loopy;
	                  }
	               }
	            }
	         }
	         fData.addAll(tarray);
	      }
	      //
	      // For each segment (variable aline), compare it with all
	      // segments after it to find intersection points.  A hash is
	      // kept to find duplicate points along this line.  The counter
	      // of points found is increased by 1 the first time that a new point
	      // is found.  The second time that same point is found, this counter is
	      // decreased by one, and all subsequent intersections along that line are
	      // ignored.
	      //
	      // Thus, when there are multiple intersections, none are counted until the
	      // last line which has one intersection is found.
	      //
	      for (int i=0; i<fData.size()-1; i++) {
	        	HashMap<Long,String> hash = new HashMap<Long,String>();
	        	Segment aline = fData.get(i);
	        	for (int j=i+1; j<fData.size(); j++) {
	        		Segment bline = fData.get(j);
	        		ArrayList<Long> nxtStr = aline.intersects(bline);
	        		if (nxtStr != null) {
	        			StringBuilder sb = new StringBuilder();
	        			for (int ii=1; ii<4; ii++) {
	        				sb.append(nxtStr.get(ii));
	        				sb.append(":");
	        			}
	        			sb.append("X");
	        			String hval = sb.toString();
	        			Long kval = nxtStr.get(0);
	        			String tval = hash.get(kval);
	           			if (tval == null) {
	        				hash.put(kval,hval);
	        				count++;
	        				continue;
	        			}
	        			int ind1 = tval.indexOf(hval);
	        			if (ind1 == -1) {
	        				String ntval = String.format("%s %s",tval,hval);
	        				hash.put(kval,ntval);
	        				count++;
	        			}
	        			else {
	        				int ind2 = tval.lastIndexOf(hval);
	        				debug++;
	        				if (ind1 == ind2) {
	        					String ntval = String.format("%s %s", tval, hval);
	        					hash.put(kval, ntval);
	        					count--;
	        				}
	        			}
	        		}
	        	}
	      }
	        return count;
	   }
	   class Segment {
	      private final long minx_;
	      private final long maxx_;
	      private final long miny_;
	      private final long maxy_;
	      private final long yfactor_;
	      private final long xfactor_;
	      private final long intercFactor_;
	      private final Fraction slope_;
	      private final Fraction intercept_;
	      public Segment(long x1, long y1, long x2, long y2) {
	         minx_ = (x1 > x2) ? x2 : x1;
	         maxx_ = (x1 > x2) ? x1 : x2;
	         miny_ = (y1 > y2) ? y2 : y1;
	         maxy_ = (y1 > y2) ? y1 : y2;
	         xfactor_ = x1 - x2;
	         yfactor_ = y1 - y2;
	         intercFactor_ = xfactor_ * y1 - yfactor_ * x1;
	         slope_ = adjFraction(yfactor_,xfactor_);
	         intercept_ = adjFraction(intercFactor_,xfactor_);
	      }
	      private Fraction adjFraction(long numer, long denom) {
	         Fraction frac = new Fraction(numer,denom);
	         if (frac.isVertical()) {
	            return null;
	         }
	         return frac;
	      }
	      public long getMinX() {
	         return minx_;
	      }
	      public long getMinY() {
	         return miny_;
	      }
	      public long getMaxX() {
	         return maxx_;
	      }
	      public long getMaxY() {
	         return maxy_;
	      }
	      public long getXfactor() {
	         return xfactor_;
	      }
	      public long getYfactor() {
	         return yfactor_;
	      }
	      public long getInterc() {
	         return intercFactor_;
	      }
	      public Fraction getRealSlope() {
	         return slope_;
	      }
	      public Fraction getIntercept() {
	         return intercept_;
	      }
	      public boolean doWeOverlap(Segment other) {
	         if (maxx_ < other.getMinX()) {
	            return false;
	         }
	         if (other.getMaxX() < minx_) {
	            return false;
	         }
	         if (slope_ == null) {
	            
	         }
	         return false;
	      }
	      public Segment segOverlap(Segment other) {
	         if (maxx_ < other.getMinX()) {
	            return null;
	         }
	         if (other.getMaxX() < minx_) {
	            return null;
	         }
	         if (intercept_ == null) {
	            if (other.getIntercept() != null) {
	               return null;
	            }
	         }
	         else {
	            if (getIntercept().compareTo(other.getIntercept()) != 0) {
	               return null;
	            }
	         }
	         long newminx = (minx_ < other.getMinX()) ? minx_ : other.getMinX();
	         long newminy = (miny_ < other.getMinY()) ? miny_ : other.getMinY();
	         long newmaxx = (maxx_ > other.getMaxX()) ? maxx_ : other.getMaxX();
	         long newmaxy = (maxy_ > other.getMaxY()) ? maxy_ : other.getMaxY();
	         Segment returnv = null;
	         if (other.getRealSlope().getNumer() >= 0) {
	            returnv = new Segment(newminx,newminy,newmaxx,newmaxy);
	         }
	         else {
	            returnv = new Segment(newminx,newmaxy,newmaxx,newminy);
	         }
	         return returnv;
	      }
	      public ArrayList<Long> intersects(Segment other) {
	         long udenom = other.getYfactor() * xfactor_ - 
	               other.getXfactor() * yfactor_;
	         if (udenom == 0) {
	            return null;
	         }
	         long xnumer = intercFactor_ * other.getXfactor() - 
	               other.getInterc() * xfactor_;
	         Fraction xinter = new Fraction(xnumer,udenom);
	         if (minx_ != maxx_) {
	            if (xinter.compareTo(minx_) <= 0) {
	               return null;
	            }
	            if (xinter.compareTo(maxx_) >= 0) {
	               return null;
	            }
	         }
	         if (other.getMinX() != other.getMaxX()) {
	            if (xinter.compareTo(other.getMinX()) <= 0) {
	               return null;
	            }
	            if (xinter.compareTo(other.getMaxX()) >= 0) {
	               return null;
	            }
	         }
	         long ynumer = intercFactor_ * other.getYfactor() -
	               other.getInterc() * yfactor_;
	         Fraction yinter = new Fraction(ynumer,udenom);
	         if (miny_ != maxy_) {
	            if (yinter.compareTo(miny_) <= 0) {
	               return null;
	            }
	            if (yinter.compareTo(maxy_) >= 0) {
	               return null;
	            }
	         }
	         if (other.getMinY() != other.getMaxY()) {
	            if (yinter.compareTo(other.getMinY()) <= 0) {
	               return null;
	            }
	            if (yinter.compareTo(other.getMaxY()) >= 0) {
	               return null;
	            }
	         }
	         ArrayList<Long> retv = new ArrayList<Long>();
	         retv.add(Long.valueOf(xinter.getNumer()));
	         retv.add(Long.valueOf(xinter.getDenom()));
	         retv.add(Long.valueOf(yinter.getNumer()));
	         retv.add(Long.valueOf(yinter.getDenom()));
	         return retv;
	      }
	   }
	   class Fraction implements Comparable<Fraction> {
	      private final long numer_;
	      private final long denom_;
	      private final boolean infSlope_;
	      
	      public Fraction(long numer, long denom) {
	         if (denom == 0) {
	            numer_ = 0;
	            denom_ = 0;
	            infSlope_ = true;
	            return;
	         }
	         long gcdv = gcd(numer, denom);
	         long lnum = numer/gcdv;
	         long lden = denom/gcdv;
	         if (lden < 0) {
	            lden *= -1;
	            lnum *= -1;
	         }
	         numer_ = lnum;
	         denom_ = lden;
	         infSlope_ = false;
	      }
	      public long gcd(long inbig, long inlit) {
	         long big = Math.abs(inbig);
	         long lit = Math.abs(inlit);
	         if (big < lit) {
	            long swtch = lit;
	            lit = big;
	            big = swtch;
	         }
	         while (lit != 0) {
	            long temp = lit;
	            lit = big % lit;
	            big = temp;
	         }
	         return big;
	      }
	      public long getNumer() {
	         return numer_;
	      }
	      public long getDenom() {
	         return denom_;
	      }
	      public boolean isVertical() {
	         return infSlope_;
	      }
	      public int compareTo(long number) {
	         long cval = number * denom_;
	         return Long.valueOf(numer_).compareTo(Long.valueOf(cval));
	      }
	      public int compareTo(Fraction frac) {
	         long us = numer_ * frac.getDenom();
	         long them = denom_ * frac.getNumer();
	         return Long.valueOf(us).compareTo(Long.valueOf(them));
	      }
	      public String toString() {
	         if (infSlope_) {
	            return "infinite";
	         }
	         return String.format("%d//%d",numer_,denom_);
	      }
	   }

}
