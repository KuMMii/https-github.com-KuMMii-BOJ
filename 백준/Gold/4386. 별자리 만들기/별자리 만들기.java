import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Point{
    int num;
    double x;
    double y;
    Point(int num, double x, double y){
        this.num=num;
        this.x=x;
        this.y=y;
    }
}

class Edge implements Comparable<Edge>{
    int start;
    int end;
    double weight;

    Edge(int start,int end, double weight){
        this.start=start;
        this.end=end;
        this.weight=weight;
    }

    @Override
    public int compareTo(Edge o){
        return (int)(this.weight-o.weight);
    }

}
public class Main {
    static int[] parent;
    static ArrayList<Edge> edgeList;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N=Integer.parseInt(br.readLine());
        Point[] points=new Point[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            points[i] = new Point(i, x, y);
        }

        edgeList=new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                double weight=Math.sqrt(Math.pow(points[i].x-points[j].x,2)+Math.pow(points[i].y-points[j].y,2));

                edgeList.add(new Edge(points[i].num, points[j].num, weight));
            }
        }
        Collections.sort(edgeList);

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i]=i;
        }

        double ans=0;

        // 크루스칼
        for(int i=0; i<edgeList.size(); i++){
            Edge edge = edgeList.get(i);

            if(find(edge.start)!=find(edge.end)){
                ans+=edge.weight;
                union(edge.start, edge.end);
            }
        }

        System.out.println(ans);
    }

    public static int find(int x){
        if(x==parent[x]) return x;
        return parent[x]=find(parent[x]);
    }

    public static void union(int x, int y){
        x=find(x);
        y = find(y);

        if(x!=y){
            parent[y]=x;
        }
    }
}
