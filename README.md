Maze Escape Planner

DFS and Backtracking Based Pathfinding System

About The Project

The Maze Escape Planner is a pathfinding system that finds a valid route from a starting point to an exit in a maze.

It uses Depth-First Search (DFS) along with backtracking to explore all possible paths and determine a valid solution efficiently.

Key Features
Finds path from start to destination
Handles "No Path Found" scenarios
Prevents revisiting cells
Efficient recursive implementation
Clean and beginner-friendly logic
Algorithm Explanation
Depth-First Search (DFS)

Explores as far as possible along one path before backtracking.

Backtracking

If a path leads to a dead-end:

Undo the last step
Try a different direction
Movement Allowed
Up
Down
Left
Right
Project Structure
Maze-Escape-Planner/
│
├── MazeSolver.java
├── README.md
└── assets/ (optional images)

Input Format
2D Grid (Maze):
1 represents open path
0 represents blocked cell
Start position (sx, sy)
End position (ex, ey)
Output
A valid path from start to end
"No path found" if no valid route exists
How It Works
1. Start from the initial cell
2. Mark it as visited
3. Explore all 4 directions recursively
4. If destination is reached return path
5. If dead-end backtrack
6. Repeat until solution is found or all paths are exhausted

Example
Example 1

Input Maze:

1 1 0
1 1 0
0 1 1


Start: (0,0)
End: (2,2)

Output:

[(0,0), (1,0), (1,1), (2,1), (2,2)]

Example 2

Input:

1 0 0
0 1 0
0 0 1


Output:

No path found

Complexity Analysis

Time Complexity: O(N × M)
Space Complexity: O(N × M)

Applications
Game development (maze solving)
Robotics navigation
Artificial intelligence pathfinding
Puzzle solving systems
Future Scope
Graphical user interface for visualization
Breadth-First Search (BFS) for shortest path
Weighted maze support
3D maze extension
AI-based optimization techniques
Tech Stack

Language: Java
Concepts:

Recursion
Backtracking
Graph traversal
Contributing

Contributions are welcome. You can fork the repository and submit a pull request.

License

This project is open-source and available under the MIT License.

Author

Akshaya
