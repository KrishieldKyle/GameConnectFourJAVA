
package MP2;

import java.util.*;
public class Game {
    static Scanner scan = new Scanner(System.in);
    static int ctr=0, ctr1=0, playerScorer=0, pcScorer=0, turn=0;
    static String result="", banner="";
    static int makeMove(int [][] configuration, int column, char color)//placing the valid inputs, printing the board and checking the winner.
    {
           if(configuration[ctr][column]==0)
           {
               ctr1++;
               configuration[ctr][column]=turn;
           }
           else if(configuration[ctr][column]==1 || configuration[ctr][column]==2)//ctr=0
           {
               ctr++;
               if(configuration[ctr][column]==0)
               {
                    ctr1++;
                   configuration[ctr][column]=turn;
               }
               else if(configuration[ctr][column]==1 || configuration[ctr][column]==2)//ctr=1
               {
                   ctr++;
                    if(configuration[ctr][column]==0)
                    {
                    ctr1++;
                    configuration[ctr][column]=turn;
                    }
                    else if(configuration[ctr][column]==1 || configuration[ctr][column]==2)//ctr2
                    {
                        ctr++;
                        if(configuration[ctr][column]==0)
                        {
                        ctr1++;
                        configuration[ctr][column]=turn;
                        }
                        else if(configuration[ctr][column]==1 || configuration[ctr][column]==2)//ctr3
                        {
                            ctr++;
                            if(configuration[ctr][column]==0)
                            {
                            ctr1++;
                            configuration[ctr][column]=turn;
                            }
                            else if(configuration[ctr][column]==1 || configuration[ctr][column]==2)//ctr4
                            {
                                ctr++;
                                if(configuration[ctr][column]==0)
                                {
                                ctr1++;
                                configuration[ctr][column]=turn;
                                }
                                else if(configuration[ctr][column]==1 || configuration[ctr][column]==2)//ctr5
                                {
                                    ctr++;
                                    if(configuration[ctr][column]==0)
                                    {
                                    ctr1++;
                                    configuration[ctr][column]=turn;
                                    }
                                }//6th else if
                            }//5ft else if
                        }//4th else if
                    }//3rd else if
               }//2nd else if
           }//1st else if
        int winnerCtr=0;
        int playerMarker=0;
        for(int x=0; x<6; x++)//checkHorizontal
        {
            for(int y=0; y<7; y++)
            {
                if(configuration[x][y]==turn)
                {
                    winnerCtr++;
                }
                else
                {
                    winnerCtr=0;
                }
                if(winnerCtr==4)
                {
                    playerMarker=1;
                    banner="***********************************************";
                    result=" by HORIZONTAL";
                }
            }
            winnerCtr=0;
        }
        winnerCtr=0;
        for(int x=0; x<7; x++)//checkVertical
        {
            for(int y=0; y<6; y++)
            {
                if(configuration[y][x]==turn)
                {
                    winnerCtr++;
                }
                else
                {
                    winnerCtr=0;
                }
                if(winnerCtr==4)
                {
                    playerMarker=1;
                    banner="***********************************************";
                    result=" by VERTICAL";
                }
            }
            winnerCtr=0;
        }//checkVertical
        for(int x=0; x<6; x++)//checkDiagonalRight
        {
            for(int y=0; y<7; y++)
            {
                if(configuration[x][y]==turn && x<3 && y<4)
                {
                    if(configuration[x + 1][y + 1]==turn)
                    {
                        if(configuration[x + 2][y + 2]==turn)
                        {
                            if(configuration[x + 3][y + 3]==turn)
                            {
                                playerMarker=1;
                                banner="***********************************************************************";
                                result=" by DIAGONAL from LEFT to RIGHT UPWARDS";
                            }//4th IF
                        }//3rd IF
                    }//2nd IF
                }//1st IF
            }//forY
        }//checkDiagonalRight
        for(int x=0; x<6; x++)//checkDiagonalLeft
        {
            for(int y=0; y<7; y++)
            {
                if(configuration[x][y]==turn && y>2 && x<3)
                {
                    if(configuration[x + 1][y - 1]==turn)//+1
                    {
                       if(configuration[x + 2][y - 2]==turn)//+2
                       {
                         if(configuration[x + 3][y - 3]==turn)//+3
                         {
                            playerMarker=1;
                            banner="***********************************************************************";
                            result=" by DIAGONAL from RIGHT to LEFT UPWARDS";
                         }//4th IF
                       }//3rd IF
                    }//2nd IF
                }//1st IF
            }//forY
        }//checkDiagonalLeft
        if(playerMarker==1 && turn==1)
        {
            color='G';
        }
        else if(playerMarker==1 && turn==2)
        {
            color='B';
        }
        else
        {
            color='N';
        }
        System.out.println("      -----------------------");
       for(int x=5; x>=0; x--)
       {
           System.out.print("      |");
           for(int y=0; y<7; y++)
           {
               if(x==ctr && y==column)
               {
                   System.out.print("(");
               }
               else
               {
                   System.out.print(" ");
               }
               System.out.print(configuration[x][y]);
               if(x==ctr && y==column)
               {
                   System.out.print(")");
               }
               else
               {
                   System.out.print(" ");
               }
               if(x==2 && y==6)
               {
                   System.out.print("|  The () indicates the chosen column of the player.. ");
               }
           }//forY
           if(x!=2)
           {
               System.out.print("|");
           }
           System.out.println("");
       }//forX
            System.out.println("      -----------------------");
            System.out.println("      |[1][2][3][4][5][6][7]|  <- This Numbers at the bottom (1 to 7) represents the columns of Zeros (0) above.");
        System.out.println("                                          Please input 1-7 (1,2,3,4,5,6,7) only, other inputs are INVALID");
        System.out.println("");
       return color;
    }//makeMove
    static int checkLegal(int [][] check, String userInput)//cheking the validity of the inputs
    {
        int test=0;
        if(ctr1==42)
            {
                test=5;
            }
        else if(userInput.equalsIgnoreCase("1") || userInput.equalsIgnoreCase("2") || userInput.equalsIgnoreCase("3") || userInput.equalsIgnoreCase("4") ||
                    userInput.equalsIgnoreCase("5") || userInput.equalsIgnoreCase("6") || userInput.equalsIgnoreCase("7") || userInput.equalsIgnoreCase("8") ||
                    userInput.equalsIgnoreCase("9") || userInput.equalsIgnoreCase("0"))
            {
                int input= Integer.parseInt(userInput);
                if(input>7 || input==0)
                {
                    test=2;
                }
                else
                {
                    input-=1;
                    if(check[5][input]!=0)
                    {
                        test=3;
                    }
                    else
                    {
                     ctr=0;
                     test=1;
                    }
                }
            }//if
            else
            {
                test=4;
            }//else
        return test;
    }
    public static void main(String[] args) {//main
        Scanner again = new Scanner(System.in);
        String tryAgain="Y";
        String tryAgainAns="";
        do{
            ctr1=0;
      int board[][] = new int [6][7];
      for(int x=0; x<6; x++)
       {
           for(int y=0; y<7; y++)
           {
               board[x][y]=0;
           }
       }
        System.out.println("*****************************************                               OBJECTIVES!! MUST READ!!");
        System.out.println("              -CONNECT FOUR-                            ");
        System.out.println("*****************************************                   The pieces fall straight down, occupying the next ");
        System.out.println("                                                        available space within the column. The objective of the ");
        System.out.println("      -YOU        ||      PC-                           game is to be the first to form a horizontal, vertical ");
        System.out.println("        "+playerScorer+"         ||      "+pcScorer+"                             or diagonal line of four of one's own discs.");
        System.out.println("      -----------------------");
       for(int x=5; x>=0; x--)
       {
           System.out.print("      |");
           for(int y=0; y<7; y++)
           {
               System.out.print(" "+board[x][y]+" ");
           }
           System.out.print("|");
           System.out.println("");
       }
        System.out.println("      -----------------------");
        System.out.println("      |[1][2][3][4][5][6][7]|  <- This Numbers at the bottom (1 to 7) represents the columns of Zeros (0) above.");
        System.out.println("                                          Please input 1-7 (1,2,3,4,5,6,7) only, other inputs are INVALID");
        System.out.println("");
        int input=0;
        while(true)
        {
            String a="1";
            int fullCaller = checkLegal(board, a);
            if(fullCaller==5)
            {
                System.out.println("");
                System.out.println("      -------------------------");
                System.out.println("          Memory Full...");
                System.out.println("      -------------------------");
                System.out.println("");
                System.out.println("");
                System.out.println("      *************************");
                System.out.println("             GAME IS TIE");
                System.out.println("      *************************");
                System.out.print("Do You Want to Play Again? [Y/y]: ");
                tryAgainAns = again.nextLine();
                break;
            }
            System.out.println("            It's your turn....");
            System.out.println("Use 1-7 to choose what column you want..");
            System.out.print("Enter Column: ");
            while(true)
            {
            String userinput = scan.nextLine();
            turn=1;
            int checkCaller = checkLegal(board, userinput);
            if(checkCaller==1)
            {
                input = Integer.parseInt(userinput);
                input-=1;
                break;
            }
            else if(checkCaller==2)
            {
                System.out.println("");
                System.out.println("");
                System.out.println("Invalid Input must input a number within 1-7");
                System.out.println("");
                System.out.println("");
                System.out.println("            It's your turn....");
                System.out.println("Use 1-7 to choose what column you want..");
                System.out.print("Enter NEW Column: ");
            }
            else if(checkCaller==3)
            {
                System.out.println("      -------------------------");
                System.out.println("            Column Full..");
                System.out.println("      -------------------------");
                System.out.println("            It's your turn....");
                System.out.println("Use 1-7 to choose what column you want..");
                System.out.print("Enter NEW Column: ");
            }
            else if(checkCaller==4)
            {
                System.out.println("");
                System.out.println("");
                System.out.println("Invalid Input LETTERS and SPECIAL CHARACTERS are invalid, must input a number within 1-7 ONLY");
                System.out.println("");
                System.out.println("");
                System.out.println("            It's your turn....");
                System.out.println("Use 1-7 to choose what column you want..");
                System.out.print("Enter NEW Column: ");
            }
            }//while
            char color='N';
            int caller = makeMove(board, input, color);//Player's Caller
            if(caller=='G')
            {
                    System.out.println("");
                    System.out.println(banner);
                    System.out.println("            You Wins" + result);
                    System.out.println(banner);
                    System.out.println("");
                    System.out.println("");
                    playerScorer++;
                    System.out.print("Do You Want to Play Again? [Y/y]: ");
                    tryAgainAns = again.nextLine();
                    break;
            }
            System.out.println("            PC's turn....");
            System.out.print("              ");
            for(int q=0; q<3; q++)
            {
                System.out.print(".");
                for(long p=0; p<500000000; p++)
                {
                }
            }
            System.out.println("");
            System.out.println("");
            System.out.print("PC's Choice: ");
            int compRand;
            String copy="";
            while(true)
            {
            compRand = (int) (Math.random() *(7));//PC's turn
            if(compRand==1)
            {
                copy="2";
            }
            else if(compRand==2)
            {
                copy="3";
            }
            else if(compRand==3)
            {
                copy="4";
            }
            else if(compRand==4)
            {
                copy="5";
            }
            else if(compRand==5)
            {
                copy="6";
            }
            else if(compRand==6)
            {
                copy="7";
            }
            else if(compRand==0)
            {
                copy="1";
            }
            int copyPC=compRand;
            turn=2;
            System.out.println(copyPC+1);
            int checkPcCaller = checkLegal(board, copy);
            if(checkPcCaller==3)
            {
                System.out.println("      -------------------------");
                System.out.println("            Column Full..");
                System.out.println("      -------------------------");
                System.out.println("            PC's turn....");
                System.out.print("              ");
                for(int q=0; q<3; q++)
            {
                System.out.print(".");
                for(long p=0; p<500000000; p++)
                {
                }
            }
            System.out.println("");
                    System.out.print("PC's NEW Choice: ");
            }
            else if(checkPcCaller==1)
            {
                break;
            }
            }//while
            color='N';
            int compCaller = makeMove(board, compRand, color);//PC's caller
             if(compCaller=='B')
            {
                    System.out.println("");
                    System.out.println(banner);
                    System.out.println("            PC Wins" + result);
                    System.out.println(banner);
                    System.out.println("");
                    System.out.println("");
                    pcScorer++;
                    System.out.print("Do You Want to Play Again? [Y/y]: ");
                    tryAgainAns = again.nextLine();
                    break;
            }
        }//BigWhile
        }while(tryAgainAns.equalsIgnoreCase(tryAgain));
        System.out.println("");
        System.out.println("             FINAL SCORE");
        System.out.println("      -YOU        ||      PC-");
        System.out.println("       "+playerScorer+"          ||      "+pcScorer+" ");
        System.out.println("");
        System.out.println("");
        System.out.println("THANKS FOR PLAYING!!!!");
        System.out.println("HOPING YOU ENJOY THE GAME!!!!");
        System.exit(0);
    }//main
}//class
