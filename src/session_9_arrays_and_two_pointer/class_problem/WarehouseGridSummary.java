package session_9.class_problem;

class Coordinate {
    private int row;
    private int col;

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString() {
        return "(" + row + ", " + col + ")";
    }
}

class GridSummaryResult {
    private int totalItems;
    private Coordinate maxCoordinate;

    public GridSummaryResult(int totalItems, Coordinate maxCoordinate) {
        this.totalItems = totalItems;
        this.maxCoordinate = maxCoordinate;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public Coordinate getMaxCoordinate() {
        return maxCoordinate;
    }

    @Override
    public String toString() {
        return "(" + totalItems + ", " + maxCoordinate + ")";
    }
}

public class WarehouseGridSummary {
    public static GridSummaryResult warehouseSummary(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return new GridSummaryResult(0, new Coordinate(-1, -1));
        }

        int total = 0;
        int maxVal = -1;
        int maxRow = 0;
        int maxCol = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                int val = grid[r][c];
                total += val;
                if (val > maxVal) {
                    maxVal = val;
                    maxRow = r;
                    maxCol = c;
                }
            }
        }
        return new GridSummaryResult(total, new Coordinate(maxRow, maxCol));
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };

        GridSummaryResult result = warehouseSummary(grid);
        System.out.println(result);
    }
}
