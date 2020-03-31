import java.util.*;


public class Main {
    static double edge_max=0,edge=0;
    static int N=5, M=4, L=3;
    static double criterion=0;
    static boolean result;
    
	public static void main(String []args) {
	
	//создание графа
	Point[][] graph = new Point[N+1][M+1];	
	for(int i =0 ;i < N+1 ;i++) 
		for(int j =0 ;j < M+1 ;j++) {
			graph[i][j]=new Point(i ,j ,N ,M);
		}

	//вывод графа
	System.out.println("N:"+ N +" M:"+ M +" L:" + L +'\n');
	for(int i =0 ;i < N+1 ;i++) 
		for(int j =0 ;j < M+1 ;j++) {
			
			System.out.println("i:"+graph[i][j].i+"  j:"+graph[i][j].j);
			edge_max++;
			for(int k =0 ;k < graph[i][j].vector.size() ;k++)
			{
				System.out.println("     i:"+graph[i][j].vector.get(k).i+"  j:"+graph[i][j].vector.get(k).j);
			}
		}
	
	//запуск поиска в глубину
	System.out.println("\nПоиск в глубину");
	if(DFS(graph, 0, 0)!=true)
		System.out.println("Пути не существует");
	
	criterion =(edge-1)/edge_max;
	System.out.println("Критерий целенаправленности:"+criterion + '\n');
	edge=0;
	
    for(int i =0 ;i < N+1 ;i++) 
		for(int j =0 ;j < M+1 ;j++)
				graph[i][j].visited=false;
    
    
    //запуск поиска в ширину
    System.out.println("Поиск в ширину");
    Queue<Point> queu = new LinkedList<Point>();
    if(BFS(queu, graph, 0, 0)!=true)
    	System.out.println("Пути не существует");
    
    criterion=(edge-1)/edge_max;
    System.out.println("Критерий целенаправленности:"+criterion + '\n');
    edge=0;

    for(int i =0 ;i < N+1 ;i++) 
    		for(int j =0 ;j < M+1 ;j++)
    				graph[i][j].visited=false;
	}
	
	
	//поиск в глубину
    public static boolean DFS(Point[][] graph, int i, int j) {
    	graph[i][j].visited=true;
    	edge++;
    	System.out.println("i:"+graph[i][j].i+"  j:"+graph[i][j].j);
    	
    	if((graph[i][j].i!=L) && (graph[i][j].j!=L)) {
    		
    	  for(int k = 0; k < graph[i][j].vector.size(); k++) {
    		if(graph [graph[i][j].vector.get(k).i] [graph[i][j].vector.get(k).j] .visited==false) {
    			    result = DFS(graph,graph[i][j].vector.get(k).i,graph[i][j].vector.get(k).j);
    				if(result==true) 
    					return true;
    				}
    		} } 
    	else 
    		return true;

    	return false;
    }
    
    
    //поиск в ширину
    public static boolean BFS(Queue<Point> queue,Point[][] graph,int i,int j) {
    	graph[i][j].visited=true;
    	System.out.println("i:"+graph[i][j].i+"  j:"+graph[i][j].j);
    	edge++;
    	
    	for (int k = 0 ; k < graph[i][j].vector.size() ; k++) {
    		if(graph [graph[i][j].vector.get(k).i] [graph[i][j].vector.get(k).j] .visited!=true) {
    			queue.add(graph [graph[i][j].vector.get(k).i] [graph[i][j].vector.get(k).j]);
    			graph [graph[i][j].vector.get(k).i] [graph[i][j].vector.get(k).j] .visited=true;
    		} }
    	
    	if(graph[i][j].i!=L && graph[i][j].j!=L) {
    		if(queue.isEmpty()!=true) {
    		  Point tmp=queue.poll();
    		  if(BFS(queue,graph,tmp.i,tmp.j)==true) {
    			return true;
    		} }

    	}
    	else {
    		return true;
    	}
    	
    	return false;
    }
    
}