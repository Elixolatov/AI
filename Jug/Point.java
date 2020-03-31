import java.util.*;

public class Point {
   public int i,j;
   boolean visited=false;
   Vector <Edge> vector = new Vector();
   
   public Point(int i,int j, int i_max ,int j_max) {
	   this.i=i;
	   this.j=j;
	   
	   //���������� ������� �������
	   int new_i = i_max, new_j = j;
	   if(new_i != i || new_j !=j)
		   vector.add(new Edge(new_i,new_j));
	   
	   //���������� ������� �������
	   new_i = i; new_j = j_max;
	   if(new_i != i || new_j !=j)
		   vector.add(new Edge(new_i,new_j));
	   
	   //���� ������� �������
	   new_i = 0; new_j = j;
	   if(new_i != i || new_j !=j)
		   vector.add(new Edge(new_i,new_j));
	   
	   //���� ������� �������
	   new_i = i; new_j = 0;
	   if(new_i != i || new_j !=j)
		   vector.add(new Edge(new_i,new_j));
	   
	   //������������ �� ������� ������� �� ������
	   new_i = j+i-j_max; new_j = 0;
	   if(new_i >= 0) {
		   new_i = new_i ; 
		   new_j=j_max;
	   }
	    else {
	    	new_i = 0;
	    	new_j = j+i;
	    }
	   if(new_i != i || new_j !=j)
		   vector.add(new Edge(new_i,new_j));
	   
	   
	   //������������ �� ������� ������� �� ������
	   new_i = 0; new_j = j+i-i_max;
	   if(new_j >= 0) {
		   new_j = new_j ; 
		   new_i=i_max;
	   }
		else {
			new_i = j+i;
	    	new_j = 0;
		}
	   if(new_i != i || new_j !=j)
		   vector.add(new Edge(new_i,new_j));
	   
   }
}
