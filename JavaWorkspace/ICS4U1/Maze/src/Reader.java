import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {
    private char[][] map;
    private int r = 8, c = 12;

    private int sx = -1, sy = -1;

    public Reader() throws FileNotFoundException{
        this("C:\\mazefile1.txt");
    }

    public Reader(String fileDir) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        map = new char[r][c];
        readIn(fileDir);
        System.out.println("Where do you want to drop the rat?");
        do {
            sx = sc.nextInt();
            sy = sc.nextInt();
        } while (!isValid(sx, sy));

    }

    /**readIn method
     * Reads a maze in the form of txt file and stores it in a 2d array.
     *  
     * @param fileDir the location of the maze file
     * 
     * @return void
     */

    void readIn(String fileDir) throws FileNotFoundException {
        File maze = new File(fileDir);
        Scanner fsc = new Scanner(maze);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = fsc.next().charAt(0);
            }
        }

    }

    /**isValid method
     * Tests whether a user-input start position is valid
     * 
     * @param x the x coordinate of the starting position
     * @param y the y coordinate of the starting position
     * 
     * @return true if the position is valid, false if it's not
     */

    boolean isValid(int x, int y) {
        boolean valid = true;
        if (x >= r || x < 0 || y >= c || y < 0) {
            valid = false;
        } else if (map[x][y] == 'B')
            valid = false;
        if (!valid) {
            System.out.println("Position not valid, try again");
        }
        return valid;
    }
    
     /**getMaze method
     * Makes a copy of the original maze an returns the copy to make sure the original maze is not changed
     * 
     * @return copy of the original maze
     */
    char[][] getMaze() {
        char[][] copy = new char[r][c];
        for (int i = 0; i < map.length; i++) {
            System.arraycopy(map[i], 0, copy[i], 0, map[i].length);
        }
        return copy;
    }

    /**getX method
     * Accessor that passes the value of starting x-coordinate to outside the class
     * 
     * @return value of starting x-coordinate
     */
    int getX(){
        return sx;
    }//end method getX


      /**getY method
     * Accessor that passes the value of starting y-coordinate to outside the class
     * 
     * @return value of starting y-coordinate
     */
    int getY(){
        return sy;
    }//end method getY


}// end class Reader