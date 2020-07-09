
public class knightOnBoardProbability {

    static double knightOnBoardProbability(int n, int m, int steps, int x, int y) {

        while (steps!=0){


          //  canMove()


        }

        return 0.0;
    }


    static int canMove(int x, int y,int n,int m){

        Position[] arr = new Position[8];

        int max = 8;

       // System.out.println(arr.length);

        arr[0] = new Position( x+2,y+1);
        arr[1] = new Position( x+2,y-1);
        arr[2] = new Position( x-2,y+1);
        arr[3] = new Position( x-2,y-1);
        arr[4] = new Position( x+1,y+2);
        arr[5] = new Position( x+1,y-2);
        arr[6] = new Position( x-1,y+2);
        arr[7] = new Position( x-1,y-2);


        for(int i=0;i<8;i++){

            if(arr[i].x<=0 || arr[i].y<=0 || arr[i].x>=n  || arr[i].y>=m )
                max--;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(canMove(3, 2,8,8));

    }



}

class Position {
    int x,y;

    Position(int x,int y){
        this.x=x;
        this.y=y;
    }
}

/*

Input:
n: 8
m: 8
steps: 2
x: 4
y: 4
Expected Output:
0.875

nput:
n: 8
m: 5
steps: 1
x: 5
y: 2
Expected Output:


input
n: 4
m: 3
steps: 2
x: 3
y: 2
Expected Output:
0.078125

 */