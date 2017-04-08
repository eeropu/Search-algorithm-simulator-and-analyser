# Week 4 (2. - 8.4)
This week I have made progress with the UI for the simulation to the point where it's possible to edit the graph. I have also made the Breadth-first- and the Depth-first-algorithms both of which are working correctly based on few test inputs. I haven't made any automatic test for them though and that's one of next weeks tasks.  
The BFS and DFS algorithms can now be tested by clicking simulate in the main menu and selecting one of them from the dropdownlist on top of the opening screen. After that user must add a start point and a goal. Finally user can add walls and enable diagonal movement in the grid. Pressing simulate will start the path finding -simulation.  
Now the user must clear the grid after every simulation or it doesn't work correctly. This will be fixed in the final version.
#### Time used:
I used approximately 15 hours this week.
### Next week(s):
During the next two weeks I'm going to add the rest of the algorithms and make (at least most of) the tests for them. Also I will be starting the testing- and creationdocuments.
### Problems:
For some reason the color of squares in the grid doesn't change during the execution of the algorithms and instead the grid only updates them at the end of the simulation. Thus it doesn't show the actual progression of the algorithm but only the final state from which the user can see what squares were used by the algorithm and the shortest route.
