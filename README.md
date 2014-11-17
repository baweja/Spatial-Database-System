Spatial-Database-System
=======================
----IMPORTANT NOTE BEFORE RUNNING THIS PROGRAM----
 PLEASE SAVE THE INPUT FILES FROM THE "INPUT FILES" FOLDER AND CHANGE THEIR PATH IN THE populate.java PROGRAM.
-------------------------------------------------------

The goal of this assignment is to design an application that queries a spatial database. This assignment will make you familiar with spatial data types using Oracle11g, Oracle Spatial features, and Java (JDBC). You are required to write two Java programs to 1) store and 2) query your spatial database.
Prerequisite:
It is highly recommended that students be familiar with
JDBC/ODBC concepts, Spatial database and writing spatial
queries.
Scenario:
A new Public Announcement System is getting installed at the
campus. We need a system to keep track of all the area that this
new announcement System can cover. Each Announcement
System is represented as a point with a radius for coverage and
each building is represented as a polygon.
Input Files:
You will be given the following files:
1. Image file: MAP - an 820x580 JPEG file that is an image of
some area of USC.
2. Following input files:
a). buildings.xy.
Each building is represented by a 2D polygon. Col 1:
building ID. Col 2: building name. Col3: number of vertices on
the polygon. The numbers after column 3 are the coordinates of
the vertices. They are comma separated. For example, a row: b1,
PHA, 4, 100, 120, 150, 130, 120, 200, 120, 220 represents a
building with its building ID as "b1" and its name as "PHA". It
has 4 vertices whose coordinates are (100, 120), (150, 130),
(120, 200) and (120, 220) respectively.
b).students.xy
Col 1: personID Col2: x coordinate of the student location.
Col3: y coordinate of the student location.
c). announcementSystems.xy
Col 1: asID. Col2: x coordinate of the announcement
system location. Col3: y coordinate of the announcement system
location. Col4: Radius of announcement system. People can
listen to the announcements if they are within the radius.
Required .sql files:
You are required to create two .sql files:
1. createdb.sql: This file should create all required tables. In
addition, it should include constraints, indexes, and any other
DDL statements you might need for your application.
2. dropdb.sql: This file should drop all tables and the other
objects once created by your createdb.sql file.
Required Java Programs:
You are required to implement two Java programs:
1. populate.java: This program should get the names of the input
files as command line parameters and populate them into your
database. It should be executed as: “> java populate
buildings.xy students.xy announcementSystems.x”. Note that
every time you run this program, it should remove the previous
data in your tables; otherwise the tables will have redundant
data.
2. hw2.java:
This program should provide a GUI, similar to figure 1, to query
your database. The GUI should include:
a) An 820x580 panel that shows the map when the application is
started up.
b) The tile of the main window should display your full name
and your student ID.
c) Text field (or Label) that shows the coordinates (x, y) of the
current mouse location as it moves over the image. Please notice
that the coordinates given in .xy files are based on the origin (0,
0) at the upper left corner of the image and (820, 580) at its
lower right corner.
d) 3 Check boxes that specify the feature types that we are
currently interested in. Multiple feature types can be checked at
the same time. They are called active feature types.
e) 5 Radio buttons that specify the kind of query we are going
to do. Only one radio button can be checked at any moment.
When a different radio button is selected, the screen should clear
the previous results.
f) One button to submit the required query.
g) One text field to display the SQL statements for the queries
that has been submitted so far. Use incremental counter for the
queries, and print the counter along with the SQL statement (e.g.,
“Query 1: select * from restaurants;”, “Query 2: select *
from people where ...”).

1. 10 Points
Whole Region: This is to display all the features of the active
feature types in the whole map. They should be displayed in the
following way:
Graphical representation of Students, Buildings and Transmission
points if checked should show up when we click the submit
button.
2. 10 Points
Point Query: When this radio button is checked, the user can
select a point in the map. This point is displayed as a red square
(5x5 pixels). You should also display a red circle centered at
this point whose radius is 50 pixels. After pushing the Submit
Query button, only the active features that are inside (or
intersect with) of the circle will be displayed. Their shapes are
specified in Table 1. Their colors are as follows: for each active
feature type, the feature that is nearest to the selected point
among all the features of this type inside the red circle is
displayed in yellow. All the other features are displayed in green
color. When the Point Query radio button is unchecked, the
selected point and the associated red circle should disappear.
3. 15 Points
Range Query: When this radio button is checked, the user can
draw a polygon in the map. After pushing the Submit Query
button, only the features of the active feature types that are
inside (or intersect with) the polygons are displayed. These
features should be displayed in the same way as specified in
Table 1. The user draws the polygon by clicking the left mouse
button to select its vertices sequentially and then clicking the
right mouse button to close the polygon. Red line segments on
the screen should connect the vertices as they are being selected.
When the Range Query radio button is unchecked, the selected
polygon should disappear.
4. 15 Points
Surrounding Students Query: When this radio button is clicked,
the user can select a point in the map. The nearest
Announcement System should be highlighted at this time. When
the submit query button is pushed, the students in the region of
the highlighted AS should be displayed.
5. 20 Points
Emergency Query: Imagine a AS breaks down. The students
near this AS cannot hear the announcements and hence need to
go to the next nearest AS. You need to help them.
When this radio button is clicked, the user can select a point in
the map. The nearest Announcement System should be
highlighted at this time, indicating that this is the AS that is
broken. When the submit query button is pushed, the students
that were covered by the broken AS system should be color
coordinated with the remaining announcement systems, i.e. a
student should have the same color as its second nearest
announcement system. You can use any color for the
announcement system here, but all AS should have different
colors
