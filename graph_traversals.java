import java.util.*;
public class Solution {
	static int n;
	static ArrayList<Integer> graph[];
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
       
		n = in.nextInt();
		int m = in.nextInt();
		graph = new ArrayList[n];
		for(int i=0; i<n; i++) graph[i] = new ArrayList<Integer>();
		while(m-->0) {
			int u = in.nextInt();
			int v = in.nextInt();
			graph[u].add(v);
			graph[v].add(u);
		}
		
		DFSr();
		
	}
	
	static void BFS(int start) {
		boolean vis[] = new boolean[n];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		while(!q.isEmpty()) {
			int x = q.poll();
			System.out.println(x);
			vis[x] = true;
			
			Iterator it = graph[x].iterator();
			while(it.hasNext()) {
				int curr = (Integer) it.next();
				if(!vis[curr]) {
					vis[curr] = true;
					q.add(curr);
				}
			}
		}
		
	}
	//iterative
	static void DFSi(int start) {
		boolean vis[] = new boolean[n];
		Stack st = new Stack();
		st.add(start);
		System.out.println(start);
		vis[start] = true;
		while(!st.isEmpty()) {
			int x = (Integer) st.peek();
			Iterator it = graph[x].iterator();
			int flag = 0;
			while(it.hasNext()) {
				int curr = (Integer) it.next();
				if(!vis[curr]) {
					flag = 1;
					st.add(curr);
					System.out.println(curr);
					vis[curr] = true;
					break;
				}
			}
			if(flag == 0) st.pop(); 
		}
	}
	
	//recursive
	static void DFSr() {
		boolean visit[] = new boolean[n];
		DFSr(2, visit);
	}
	static void DFSr(int start, boolean visit[]) {
		System.out.println(start);
		visit[start] = true;
		Iterator it = graph[start].iterator();
		while(it.hasNext()) {
			int curr = (Integer) it.next();
			if(!visit[curr]) DFSr(curr, visit);
		}
	}
	
}

