import java.util.*;
public class bitManipulation{
    public static void main(String[] args) {    // find 2 non repeating elemnents in repeating elements
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int xor = 0;
        for(int i = 0;i<n;i++){         // step 1 : finding XOR os complete array
            arr[i] = sc.nextInt();
            xor = xor^arr[i];
        }
        int temp = xor;
        // finding rightmost setbit in XOR
        int c = 0;
        int last = 0;
        while(last < 8){
            int t = xor^1;
            if(t == 1){
                break;
            }else{
                c++;
            }
            xor = xor>>1;
        }
        xor = temp;
        // finding two non repeating elements
        int a = 0,b = 0;
        int mask = 1<<c;
        for(int i = 0;i<n;i++){
            int masking = arr[i]^mask;
            if(masking == 1){
                a = a^arr[i];
            }
        }
        a = a^temp; // a found
        b = a^xor;  // b found
        System.out.println("\nfirst number --> " + a + "\nsecond number --> " + b);
    }
}