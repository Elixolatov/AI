import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static double edge_max=0,edge=0;
	
	public static void main(String []args) {
	int N=5, M=4, L=3;
	System.out.println("N:"+ N +" M:"+ M +" L:" + L);
	edge_max=(N+1)*(M+1);
	
	Point[][] graph = new Point[N+1][M+1];
			
	for(int i =0 ;i < N+1 ;i++) 
		for(int j =0 ;j < M+1 ;j++)
			graph[i][j]=new Point(i ,j ,N ,M);

	Stack<Integer> path = new Stack<>();
	System.out.println("Поиск в глубину");
	DFS(path,graph,L,0,0);
	double p=edge/edge_max;
	System.out.println("Критерий целенаправленности:"+p);
	 
    for(int i =0 ;i < N+1 ;i++) 
		for(int j =0 ;j < M+1 ;j++)
				graph[i][j].visited=false;
    System.out.println("Поиск в ширину");
    edge=0;
    Queue<Point> queu = new LinkedList<Point>();
    BFS(path,queu,graph,L,0,0);
    p=edge/edge_max;
    if(path.empty()) 
		System.out.println("Невозможно");
    while(!path.empty()) 
    	System.out.println("i:"+path.pop()+"  j:"+path.pop());
        System.out.println("Критерий целенаправленности:"+p);
	}
	
    public static boolean DFS(Stack<Integer> path,Point[][] graph,int goal,int i,int j) {
    	graph[i][j].visited=true;
    	edge++;
    	System.out.println("i:"+graph[i][j].i+"  j:"+graph[i][j].j);
    	for(int k =0 ;k < 6 ;k++) {
    		if(graph [graph[i][j].edge[k].i] [graph[i][j].edge[k].j] .visited==false) 
    			if((graph[i][j].edge[k].i!=goal) && (graph[i][j].edge[k].j!=goal)) {
    				if(DFS(path,graph,goal,graph[i][j].edge[k].i,graph[i][j].edge[k].j)==true) {
    					return true;
    					} }
    			
    			else {
    				path.push(graph[i][j].edge[k].j);
    				path.push(graph[i][j].edge[k].i);
    				System.out.println("i:"+graph[i][j].i+"  j:"+graph[i][j].j);
    				System.out.println("i:"+graph[i][j].edge[k].i+"  j:"+graph[i][j].edge[k].j);
    			    return true;
    			}
    		
    	}
    	return false;
    }
    
    public static boolean BFS(Stack<Integer> path,Queue<Point> queue,Point[][] graph,int goal,int i,int j) {
    	graph[i][j].visited=true;
    	edge++;
    	for (int k = 0 ; k < 6 ; k++)
    		if(graph [graph[i][j].edge[k].i] [graph[i][j].edge[k].j] .visited!=true) {
    			queue.add(graph [graph[i][j].edge[k].i] [graph[i][j].edge[k].j]);
    			graph [graph[i][j].edge[k].i] [graph[i][j].edge[k].j] .visited=true;
    		}
    	
    	if(graph[i][j].i!=goal && graph[i][j].j!=goal) {
    		Point tmp=queue.poll();
    		if(BFS(path,queue,graph,goal,tmp.i,tmp.j)==true) {
    			path.push(j);
    		    path.push(i);
    			return true;
    		}
    	}
    	else {
    		return true;
    	}
    	
    	return false;
    }
    
}