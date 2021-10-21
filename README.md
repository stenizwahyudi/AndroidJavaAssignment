# AndroidJavaAssignment

The application consists of 1 activity and 3 fragments:
  - 1 Main Activity with layout.
  - 1st fragment class, layout, and 1st Json file.
  - 2nd fragment class, layout, and 2nd Json file.
  - 3rd fragment class, layout, and 3rd Json file.

The fragment object is programmatically created using Java reflection technique based on the fragment information of the related Json file.

Each fragment layout includes 1 button and 1 text box controls.

* When the app runs, the default fragment (the first fragment) will be displayed.

* When user clicks the button on the first fragment, the fragment will move to the second fragment along with the string inputted in the textbox control and the first fragment class name. The string input concantenated with the first fragment class name will be displayed on the second fragment.

* When user clicks the button on the second fragment, the fragment will move to the third fragment along with the string inputted in the textbox control and the second fragment class name. The string input concantenated with the second fragment class name will be displayed on the third fragment.

* When user clicks the button on the third fragment, the fragment will move to the first fragment along with the string inputted in the textbox control and the third fragment class. The string input concantenated with the third fragment class name will be displayed on the first fragment.

* When user clicks the back button, the fragment will move to the previous fragment. If the user clicks the back button and the current fragment is the default fragment (the very first fragment), the app will exit.
