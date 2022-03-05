import java.util.Random;

public class Main {
    private static int[] message = new int[11];

    private static int[][] C_message = new int[4][4];

    public static void main(String[] args) {
        ZeroCMessage();
        WriteMessage();
        ShowMessages();
        CodeMessage();
        ShowMessages();
    }

    private static void ShowMessages() {
        System.out.println("\nMessage: ");
        for(int i=0;i<11;i++){
            System.out.print(message[i]);
        }

        System.out.println("\nCode: ");
        for(int hor=0, ver=0; hor<4;){
            System.out.print(C_message[hor][ver]);
            if((ver += 1) > 3){
                ver =0;
                hor++;
                System.out.println();
            }
        }
        System.out.println();
    }

    private static void ZeroCMessage() {
        for(int hor=0, ver=0; hor<4;){
            C_message[hor][ver]=0;
            if((ver += 1) > 3){
                ver =0;
                hor++;
            }
        }
    }



    private static void WriteMessage() {
        Random rd = new Random();
        for(int i=0, hor=0, ver=3;i<11;i++){
            message[i]=0;
            if(rd.nextBoolean()) message[i]=1;
            C_message[hor][ver]=message[i];
            if((ver += 1) > 3){
                ver =0;
                hor++;
                if(hor!=3) ver++;
            }

        }


    }
    private static void CodeMessage() {
        if(CheckHor(1, 3)) C_message[0][1]=1;
        if(CheckHor(2, 3)) C_message[0][2]=1;
        if(CheckVer(1, 3)) C_message[1][0]=1;
        if(CheckVer(2, 3)) C_message[2][0]=1;

        ShowMessages();

        if(CheckAll()) C_message[0][0]=1;
    }

    private static boolean CheckAll() {
        int sum=0;
        for(int i=0;i<=3;i++){
            for(int j=0; j<=3; j++){
                sum+=C_message[i][j];
            }
        }

        int newSum = sum/2;
        newSum*=2;
        return (newSum!=sum);
    }

    private static boolean CheckVer(int a, int b) {
        int sum=0;
        for(int i=0;i<=3;i++){
            sum+=C_message[a][i];
        }
        for(int i=0;i<=3;i++){
            sum+=C_message[b][i];
        }

        int newSum = sum/2;
        newSum*=2;
        return (newSum != sum);
    }

    private static boolean CheckHor(int a, int b){
        int sum=0;
        for(int i=0;i<=3;i++){
            sum+=C_message[i][a];
        }
        for(int i=0;i<=3;i++){
            sum+=C_message[i][b];
        }

        int newSum = sum/2;
        newSum*=2;
        return (newSum != sum);
    }
}
