
public class Point {
   public int i,j;
   boolean visited=false;
   Edge[] edge = new Edge [6];
   public Point(int i,int j, int i_max ,int j_max) {
	   this.i=i;
	   this.j=j;
	   
	   edge[0] = new Edge(i_max,j);
	   edge[1] = new Edge(i,j_max);
		
	   edge[2] = new Edge(0,j);
	   edge[3] = new Edge(i,0);
	   
	   if(j+i-j_max >= 0)
	         edge[4] = new Edge(j+i-j_max,j_max);
	    else
		     edge[4] = new Edge(0,j+i);  
	   
	   if(j+i-i_max >= 0)
		     edge[5] = new Edge(i_max,j+i-i_max);
		else
			 edge[5] = new Edge(j+i,i); 
	   
   }
}
