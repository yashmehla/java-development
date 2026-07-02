class Hello{
    public static void main(String args[]){
        System.out.println("Matrix Sum");
        int matrix1[][] = new int[3][3];
        int matrix2[][] = new int [3][3];
        int result[][] = new int [3][3];
        int i;
        int j;
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                matrix1[i][j]=(int)(Math.random()*10);
                matrix2[i][j]=(int)(Math.random()*10);
            }
        }
        System.out.println("Matrix 1");
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                System.out.print(matrix1[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("Matrix 2");
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                System.out.print(matrix2[i][j]+" ");
            }
            System.out.println("");
        }

        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                result[i][j]=matrix1[i][j]+matrix2[i][j];
            }
        }
        System.out.println("The sum of two matrix is:");
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("Matrix Manupulation");
        for(int n[] : result){
            n[0]=1;
            n[1]=1;
            n[2]=1;
        }
        System.out.println("The modified result is");
        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println("");
        }

    }
}
