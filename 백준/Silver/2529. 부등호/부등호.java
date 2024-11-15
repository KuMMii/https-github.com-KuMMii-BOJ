import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static char[] arr = new char[10];
    private static boolean[] visited = new boolean[10];
    private static List<String> ans = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        dfs("", 0);
        Collections.sort(ans);

        System.out.println(ans.get(ans.size() - 1));
        System.out.println(ans.get(0));
        br.close();
    }

    private static void dfs(String num, int idx) {
        if (idx == N + 1) {
            ans.add(num);
            return;
        }

        for (int i = 0; i < 10; i++) {
            // 중복 거르기
            if(visited[i]) continue;
            if (idx==0 || ck(Character.getNumericValue(num.charAt(idx-1)),i, arr[idx - 1])){
                visited[i]=true;
                dfs(num + i, idx + 1);
                visited[i]=false;
            }

        }
    }

    private static boolean ck(int a, int b, char c) {
        if (c == '<') {
            if (a>b) return false;
        }
        else if (c=='>'){
            if (a<b) return false;
        }
        return true;
    }
}
