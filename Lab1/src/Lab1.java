public class Lab1 {
    public static void main(String args[]) {
        Lab1 lab1 = new Lab1();
        lab1.compulsory();
        int n = Integer.parseInt(args[0]);
        lab1.homework();
        lab1.bonus();
    }


    void compulsory()
    {
        System.out.println("Hello world!");

        String[] languages={"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1000000);
        String binaryString="10101";
        int decimal=Integer.parseInt(binaryString,2);
        String hexadecimalString="FF";
        int hexadecimal=Integer.parseInt(hexadecimalString,16);
        int result= (n*3 + decimal +hexadecimal)*6;

        int new_result;
        do {
            new_result=0;
            while (result>0) {
                new_result = new_result + result % 10;
                result = result / 10;
            }
            result=new_result;
        }while(result>=10);

        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }
    void homework() {
        int[][] matrix=new int[50][50];
        for(int i=0;i<n;i++)
            for(int j=0; j<n;j++)
                matrix[i][j]=(i+j)%n;


        }
    void bonus() {

    }
}

// 0 1 2 3 4 5
// 1 2 3 4 5 0
// 2 3 4 5 0 1
// 3 4 5 0 1 2
// 4 5 0 1 2 3