# Subject definition
This program is used to simulate and analyse the efficiency of different graph-search-algorithms.
### Available algorithms:
Breadth-first search  
Depth-first search  
Dijkstra  
Best-first search  
A*
### Simulation:
The program will contain a grid that is used to simulate the progress of the algorithms execution. Each rectangle represents a vertex that has an edge to its' neighbours above and beneath it and right and left from it (User can also allow edges to the vertices that are next to each other diagonally). The size of the grid can be changed from 15 x 10 to 90 x 60 (the user gives the width x and the given value will be scaled to the closest real number that is divisible by 1.5).
### Speedtesting:
In addition to simulation, user can also run speed test with multiple algorithms, which will produce a diagram showing the efficiency differences between the algorithms being used in the given graph. (Unfortunately this doesn't give reliable results most likely due to java's built-in-tools such as garbage collector that disrupt the algorithm's executions and thus change the result)
### Weights
User can also give weights for the graphs' edges. Some algorithms can't be used when the graph is weighted and vice versa.
#### NOT Weighted:
BFS  
DFS  
Best-first search  
A*
#### Weighted:
Dijkstra  
A*
### Datastructures being used:
#### Queue
BFS
#### Stack
DFS
#### Heap
Dijkstra
A*
Best-first search
### Time and space complexity:
#### BFS
Time: O(|V| + |E|)  
Space: O(|V|)
#### DFS
Time: O(|V| + |E|)  
Space: O(|V|)
#### Dijkstra
Time: O((|E| + |V|) * log|V|)  
Space: O(|V|)
#### A* & Best-first
Time and space complexity depends on the selected heuristicfunction.
###### Source: the Datastructures and algorithms course-slides by Patrik Floréen
[source](http://www.cs.helsinki.fi/u/floreen/tira2012/tira.pdf)
### Additional information
The program will be written in Java.
