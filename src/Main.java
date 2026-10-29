import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pf = new PrintWriter(
                new BufferedWriter(new OutputStreamWriter(System.out)));

        try {
            System.out.print("¿Cuántos casos tienes? ");
            String s = br.readLine();

            if (s == null || s.trim().isEmpty()) {
                pf.flush();
                return;
            }

            int t = Integer.parseInt(s.trim());

            for (int i = 0; i < t; i++) {
                System.out.print("¿Cuál es el caso " + (i + 1) + "? ");
                String line = br.readLine();
                // saltar líneas vacías
                while (line != null && line.trim().isEmpty()) {
                    line = br.readLine();
                }
                if (line == null) break;

                StringTokenizer st = new StringTokenizer(line);
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());

                int dtA = calcularDistancia(A, B);
                int dtC = calcularDistancia(B, C);

                if (dtA < dtC) {
                    pf.println(A);
                } else if (dtA > dtC) {
                    pf.println(C);
                } else {
                    pf.println("EMPATE");
                }
            }
            pf.flush();

        } catch (IOException e) {
            System.out.println("Hay un error con: " + e.getMessage());
        }
    }

    public static int calcularDistancia(int x, int y) {
        if ((x < 0 && y > 0) || (x > 0 && y < 0)) {
            return Math.abs(x - y) - 1;
        }
        return Math.abs(x - y);
    }
}