# Implementation Document
### Algorithms
the Algorithms -package contains the classes that are used to run search algorithms on the graph represented by the Grid class. These classes are BestFirstSearch, BreadthFirstSearch, DepthFirstSearch and DijkstraOrAStar. The first three classes are pretty much self-explanatory. DijkstraOrAStar on the other hand can be used to run both Dijkstra's algorithm and the A*-algorithm. The algorithm that's going to be used depends on how the graph has been initialized earlier. If the vertices has only been initialized with weights, Dijkstra's algorithm is going to be used, but if they also have heuristic values A* will be run.  
In addition to these classes Algorithms -package also contains an interface, Algorithm, which contains all the methods that these classes uses. This simplyfies the usage of the algorithm-classes. Package also contains the AlgorithmBase class which implements the Algorithm -interface and has a implementation of the methods that are identical between the algorithm-classes. All algorithm-classes are subclasses for the AlgorithmBase-class.
### DataStructures
The DataStructures package contains all the datastructures that are being used by the programm. These are Heap, LinkedList, Queue, Stack and Vertex. LinkedList, Queue and Stack are the classic versions with nothing special. Heap is implemented as a minimum-Heap which allows the Object with the smallest value being fetched efficiently. Vertex contains all information needed by the graph to work with them.
### UI
the UI-package contains the objects that form the user interface. Grid is the base for the Graph and it contains a two-dimensional array of Squares, which represent the vertices. In addition to these, the package also contains the Menu and SimulationMenu classes that create the UIs to the right border of the screen, from which the user can, for instance, navigate between menus, modify the graph and run simulations.
### UI.Listeners
The UI-listeners package contains the classes that are used to give functionality to UI-classes. These are MenuListener, SimulationMenuListener and SquareListener which are all quite self-explanatory.
#### other
Project also contains the algorithm.algorithmanalyser -package which only contains the Main class. This class is only used to launch the program by creating and running a WindowHandler -object.
