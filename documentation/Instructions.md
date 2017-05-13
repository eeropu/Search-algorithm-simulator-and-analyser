# Search-algorithm-simulator-and-analyser:
### Main menu:
When user starts the program a menu will open.  

From this menu user can choose either simulation or speedtest.  
User can also resize the grid by choosing a new value from the dropdownlist and clicking the resize-button.
### Simulation Menu:
In the simulation menu user can select which algorithm is going to be simulated from a dropdownmenu.  
After choosing the algorithm, start and goal vertices need to be added. User can also add walls to the grid by selecting the "Add/remove walls"-radiobutton and clicking the grids squares.  
A*-algorithm and Dijkstras algorithm also notifies weights on the vertices. These can be added by writing the desired weight to the Set Weight - textarea and selecting the radioButton next to it.  
If the selected algorithm is A* or Best-First-Search, user also has to select the heuristic function!  
User can also allow diagonals via radiobuttons.  
Finally, user can write the desired speed that the algorithm will run on. The speed is given in delation milliseconds so the smaller the number, the faster the simulation runs.  
When user has made all the selections, the simulate-button can be clicked which starts the simulation.
##### Textfields:
The input needs to be an integer! If the integer is not valid, it will not be taken into account. Instead the weight of the vertex will be set to 0 and the speed will be set to 20.
### Speedtest Menu:
The speed test menu contains the same selections that can be used to manipulate the grid as the simulation menu, but it does not let the user choose algorithms or heuristics at this point. The speedsetter has also been removed. When the user has finished editing the grid, the 'run tests' -button can be pressed.  
This will open a new window where user can select which algorithms (and heuristics) are going to be tested. After the selection, clicking the 'continue'-button will start the testing.  
Closing the speedtest- window will not terminate the programs execution.
### Additional buttons:
In both submenus, there is four buttons on the bottom of the menu, under the simulate/run tests - button.  
The top left button is 'clear', which will reset all other colors (and vertice-modes) to white except the start and goal vertices and walls (green, red and black). If there are no other colors than white, green, red and black, all the vertices will be reseted to white.  
The top right is 'fill', which will change all of the vertices to walls (blacks).  
The bottom left is the 'return' button that returns back to main menu.  
the bottom right is the '?' A.K.A. help button that directs to this manual.
