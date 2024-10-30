package vttp.batch5.sdf.task02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {

		// 1. Program accept single para for CSV file name: day.csv
        if(args.length == 0){
            System.err.println("Error: No file name provided.");
            return; // End program if nth given
        }

        String fileName = args[0];
        Path p = Paths.get("task02\\TTT", fileName); // Input file
        String absPath = p.toAbsolutePath().toString();

        if(!Files.exists(p))
        {
            System.err.println("Error: File does not exist. Terminating program..");
            return; // End program if nth given
        }
        else
        {
            System.out.printf("File found at <%s> \n", absPath);
            System.out.printf("Processing: %s \n", p.toString()); 
            System.out.println();
        }

		System.out.println("Board: ");

		String[][] board = new String[3][3]; // Initialize the board with 3x3 size;

		List<String> inputs = new ArrayList<>();
		List<Integer[]> coordinatesList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(p.toFile()))) 
		{
            String line;
            while ((line = br.readLine()) != null) 
			{
                System.out.println(line);

				String[] tempList = line.toUpperCase().split("");

				String a = tempList[0];
				String b = tempList[1];
				String c = tempList[2];

				inputs.add(a);
				inputs.add(b);
				inputs.add(c);	
            }
        } catch (IOException e) 
		{
            e.printStackTrace();
        }

		System.out.println();

		int k = 0;

		for (int i = 0; i < 3; i++) // Loop through rows
		{ 
            for (int j = 0; j < 3; j++) // Loop through columns
			{ 

				String input = inputs.get(k);
				board[i][j] = input; // populate the board
				k++;

				// find coordinates with "." indicating empty box
				if (input.equals(".")) 	
				{	
					Integer[]coordinates = {j,i};
					coordinatesList.add(coordinates);
				}

            }
        }
		
		// Place "X" at empty coordinates and check if win
		System.out.println("x, y, utility");
		for (int i = 0 ; i < coordinatesList.size(); i++ )
		{
			Integer[] tempList = coordinatesList.get(i);

			int x = tempList[0];
			int y = tempList[1];

			String [][] tempBoard = boardCopy(board);
			tempBoard[y][x] = "X";

			int utility = utility(board);
			System.out.println(x + ", " + y + ", " + utility);
		}
	
    }
	
	// METHODS
	// Copy board for player move
	public static String[][] boardCopy(String[][] board) 
	{
		String[][] boardCopy = new String[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				boardCopy[i][j] = board[i][j];
			}
		}
		return boardCopy;
	}

	public static int utility(String[][] board)
	{
		// For checking if "X" wins next turn
		if(checkWin("X", board))
		{
			return 1;
		}

		// For checking if "O" wins next turn
		for (int i = 0; i < 3; i++) 
		{
			for (int j = 0; j < 3; j++) 
			{
				if (board[i][j].equals(".")) 
				{
					board[i][j] = "O";
					if (checkWin("O", board)) 
					{
						board[i][j] = "."; // backtrack
						return -1;
					}
					board[i][j] = "."; // backtrack
				}
			}
		}

		return 0; // neutral outcome

	}

	// Check if player won
    public static boolean checkWin(String symbol, String[][] board) 
	{
        for (int i = 0; i < 3; i++) 
		{ 
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) // Row win
				|| 
                (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) // Column win
			{
				return true;
            }
        }

		if ((board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) // Diagonal win
			||
		 	(board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) // Diagonal win	
        {
			return true;
		}

		return false;
	}
		
}


// PSUEDO CODE
// 1. Program start
//	a. Ensure args[0] passed in .txt for current state of tictactoe board to analyse
// 2. initiliase empty board
// 	a. populate empty board with information from .txt file
// 3. Find coordinates of empty boxes on the board
// 4. Check utility
//	a. Check if player will win after place 'X' on any of the empty coordinates assign utility 1
// 	b. If player cannot win after placing, check if will lose immediately after placing, assign utility -1
//	c. If player neither wins or lose after placing, assign utility 0
// 5. display utility after checks
// 6. Program ends
