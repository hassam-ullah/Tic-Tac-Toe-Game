package task.pkg2;
import java.util.Scanner;
public class TicTacToe
    {
    static void viewBoard(int[][] arr)
        {
            for(int i=0;i<3;i++)
                {
                    for(int j=0;j<3;j++)
                        {
                            System.out.print(arr[i][j]+" ");
                        }
                    System.out.print("\n");
                }
        }
    static boolean spaceCheck(int arr[][])
        {
            for(int i=0;i<3;i++)
                {
                for(int j=0;j<3;j++)
                    {
                    if(arr[i][j]==0)
                        return true;
                    }
                }
            return false;
        }
    static boolean indexValidate(int arr[][], int r,int c)
        {
            if(arr[r][c]==0)
                {
                    return true;
                }
            System.out.println("Invalid Coordinates. Index Filled Already.");
            return false;
        }

     static boolean rowCheck(int arr[][])
        {
            int[] ar=new int[3];
        
            for(int i=0;i<3;i++)
                {
                    int count=0;
                    for(int j=0;j<3;j++)
                        {
                            ar[j]=arr[i][j];
                        }
                    for(int k=0;k<3;k++)
                        {
                            if(ar[i]==0)
                                return false;
                            if(ar[0]==ar[k])
                                count++;
                        }
                    if(count==3)
                    return true;
                }
            return false;
        }
    
    static boolean columnCheck(int arr[][])
        {
            int[] ar=new int[3];
        
            for(int i=0;i<3;i++)
                {
                    int count=0;
                    for(int j=0;j<3;j++)
                        {
                            ar[j]=arr[j][i];
                        }
                    for(int k=0;k<3;k++)
                        {
                            if(ar[i]==0)
                                return false;
                            if(ar[0]==ar[k])
                                count++;
                        }
                    if(count==3)
                    return true;
                }
            return false;
        }
    static boolean top_leftDiagonalCheck(int arr[][])
        {
            int[] ar=new int[3];
        
            for(int i=0;i<3;i++)
                {
                    for(int j=0;j<3;j++)
                        {
                            if(i==j)
                                ar[j]=arr[i][j];
                        }   
                }
            for(int k=0;k<3;k++)
                        {
                            if(ar[k]==0)
                                return false;
                            if(ar[k]!=ar[0])
                                return false;
                        }
            return true;
        }
    
    
    static boolean top_rightDiagonalCheck(int arr[][])
        {
            int[] ar=new int[3];
        
            for(int i=0,j=2;i<3;i++,j--)
                {
                    ar[i]=arr[i][j];
                }
            for(int k=0;k<3;k++)
                        {
                            if(ar[k]==0)
                                return false;
                            if(ar[k]!=ar[0])
                                return false;
                        }
            return true;
        }
    static int revertPlayer(int x)
        {
            if(x==1)
                return 2;
            else if(x==2)
                return 1;
                return x;
        }
    public static void main(String[] args)
        {
            int[][] arr={{0,0,0},{0,0,0},{0,0,0}};
            
            System.out.println("TIC TAC TOE GAME");
            
        int player =1;
        int row=0,column=0;
        Scanner s = new Scanner(System.in);
        do{
            viewBoard(arr);
            if(spaceCheck(arr))
                {
                
                    System.out.println("Player "+player+"'s Turn:");
                    System.out.print("Row : ");
                    row=s.nextInt();
                    System.out.print("Column : ");
                    column=s.nextInt();

                    if(indexValidate(arr,row,column))
                        {
                            arr[row][column]=player;
                        }
                    else{
                        continue;
                    }

                    if(rowCheck(arr) || columnCheck(arr) || top_rightDiagonalCheck(arr) || top_leftDiagonalCheck(arr))
                        {
                            viewBoard(arr);
                            System.out.println("PLAYER "+player+" HAS WON!");
                            break;
                        }
                    player=revertPlayer(player);
                }
            else
                {
                    System.out.println("Game Drawn");
                    break;
                }
                
            
            
        }while(true);
        
             
        }
    
    }
