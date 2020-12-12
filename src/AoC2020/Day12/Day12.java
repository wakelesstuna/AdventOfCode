package AoC2020.Day12;

import utils.FileUtil;

import java.util.List;

public class Day12 {

    private static List<String> input = FileUtil.readFileString("src/AoC2020/Day12/day12.txt");
    private static List<String> testInput = FileUtil.readFileString("src/AoC2020/Day12/test.txt");
    private static Direction direction = Direction.EAST;
    private static int wx = 10;
    private static int wy = 1;

    public static void main(String[] args) {
        part1();
        part2();

    }

    private static void part1() {

        int x = 0; // horizontal
        int y = 0; // vertical

        for (String s : input){
            int move = Integer.parseInt(s.substring(1));
            switch (s.charAt(0)){
                case 'N' -> y += move;
                case 'S' -> y -= move;
                case 'E' -> x += move;
                case 'W' -> x -= move;
                case 'L' -> direction = Direction.newDirection(direction, move/90, false);
                case 'R'-> direction = Direction.newDirection(direction,move/90,true);
                case 'F' -> {x += direction.x * move; y += direction.y * move;}
            }
        }
        System.out.println("Part 1: " + (Math.abs(x) + Math.abs(y)));
    }

    private static void part2(){
        int x = 0; // horizontal
        int y = 0; // vertical

        for (String s : input){
            int move = Integer.parseInt(s.substring(1));
            switch (s.charAt(0)){
                case 'N' -> wy += move;
                case 'S' -> wy -= move;
                case 'E' -> wx += move;
                case 'W' -> wx -= move;
                case 'L' -> rotateWayPoint(move, 'L');
                case 'R'-> rotateWayPoint(move,'R');
                case 'F' -> { x = x + wx * move; y = y + wy * move; }
            }
        }
        System.out.println("Part 2: " + (Math.abs(x) + Math.abs(y)));
    }

    public static void rotateWayPoint(int amount, char whichChar){
        for (int i = 0; i < amount/90; i++) {
            if (whichChar == 'L'){
                int temp = wy;
                wy = wx;
                wx = temp * -1;
            }
            if(whichChar == 'R'){
                int temp = wy;
                wy = wx * -1;
                wx = temp;
            }
        }
    }

    public enum Direction{
        NORTH(0,1),
        EAST(1,0),
        WEST(-1,0),
        SOUTH(0,-1);

        int x;
        int y;

        Direction(int x, int y){
            this.x = x;
            this.y = y;
        }

        public static Direction newDirection(Direction currentDirection, int amountOfTurn, boolean turn){
            Direction newDirection = currentDirection;
            for (int i = 0; i < amountOfTurn; i++) {
                switch (newDirection){
                    case NORTH -> newDirection = turn ? EAST : WEST;
                    case EAST -> newDirection = turn ? SOUTH : NORTH;
                    case WEST -> newDirection = turn ? NORTH : SOUTH;
                    case SOUTH -> newDirection = turn ? WEST : EAST;
                }
            }
            return newDirection;
        }


    }
}
