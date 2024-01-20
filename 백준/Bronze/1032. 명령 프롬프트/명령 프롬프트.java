
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int N, len;
        char[][] cmd;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String tmp = br.readLine();
        len = tmp.length();
        cmd = new char[N][len];
        cmd[0] = tmp.toCharArray();
        char[] ans = tmp.toCharArray();

        if (N > 1) {
            for (int i = 1; i < N; i++) {
                cmd[i] = br.readLine().toCharArray();
            }


            //알파벳 iterate
            for (int i = 0; i < len; i++) {
                //글자 iterate
                for (int j = 1; j < N; j++) {
                    if (cmd[0][i] == cmd[j][i]) ans[i] = cmd[0][i];
                    else {
                        ans[i] = '?';
                        break;
                    }
                }
            }
        }

        for (char an : ans) {
            System.out.print(an);
        }

    }
}
