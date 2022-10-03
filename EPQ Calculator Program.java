// Create and add program to the package called calculator

package calculator;

// Import Java Swing package. This program will allow us to create a GUI

import javax.swing.*; // [https://docs.oracle.com/javase/tutorial/uiswing/start/about.html]

// Import the Java AWT package. This will allow us to customise the GUI

import java.awt.*;

// Import the action listener and action event classes which are necessary to read the user input

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Import the array list class to allow an array list to be created and used to store the user input of the buttons.

import java.util.ArrayList;





// Create a Java class
// The class should inherit attributes and methods from the JFrame class
// The class should implement the interface action listener

public class CalculatorV24 extends JFrame implements ActionListener {
	
	// Create a serial version user ID

	private static final long serialVersionUID = 1L;
	
	// Create variables outside the scope of the constructor to store the buttons
	
	// Numbers
	
	JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
	
	// Operators
	
	JButton bPlus, bMinus, bMultiply, bDivide;
	
	// Other
	
	JButton bEquals, bDecimalPoint ,bComma;
	
	// Clear
	
	JButton bC, bAC; 
	
	// Special characters
	
	JButton bSquareRoot, bCubeRoot, bSquare, bCube, bSin, bCos, bTan, bLn, bArcSin, bArcCos, bArcTan , bLog, bReciprocal, bLogBase, bFactorial, bPercent;
	
	// Create a name for the text field outside the scope of the constructor to output the buttons pressed and the result
	// The variable txt is static to make it a class variable so it has a scope of the whole class.
	
	static JTextField txt = new JTextField ("", 30); // [https://docs.oracle.com/javase/tutorial/uiswing/components/textfield.html]
	
	// Create an arrayList called calculations.
	// This will store the user input so the final calculation could take place.
	// An array list is used instead of an array as an array list is flexible and has no fixed size.
	// The array list calculations is static to make it a class variable so it has the scope of the whole class.
	
	static ArrayList<String> calculations = new ArrayList<String>(); 
	
	// Create some boolean variables which establish which method to call for the scientific features.
	
	boolean usingSquareRoot = false;
	
	boolean usingCubeRoot = false;
	
	boolean usingSquare = false;
	
	boolean usingCube = false;
	
	boolean usingSin = false;
	
	boolean usingCos = false;
	
	boolean usingTan = false;
	
	boolean usingLn = false;
	
	boolean usingArcSin = false;
	
	boolean usingArcCos = false;
	
	boolean usingArcTan = false;
	
	boolean usingLog = false;
	
	boolean usingReciprocal = false;
	
	boolean usingLogBase = false;
	
	boolean usingFactorial = false;
	
	// Create a variable to store the index of the first digit of a number after an operator
	
	static int firstNumberIndex = 0;
			
	 // Create a variable to store the index of the last digit of a number before an operator
			
	static int finalNumberIndex = 0;
	
	
	
	

	// Create a constructor to initialise attributes for the class
	
	public CalculatorV24 () {

		// Set a size for the window of 400 pixels by 500 pixels
		
		//setSize (1250, 1000);		
		// Set resizable to false.
		// This means the screen remains in a fixed position so the buttons don't move
		
		setResizable (true);  // [Source: https://stackoverflow.com/questions/1840113/is-there-any-way-to-make-a-window-fixed]
	
		// Set a title called calculator for the window
		
		setTitle ("Calculator");

		// Set the layout null for the window to allow the buttons to be placed manually
		
		setLayout(null);

		// Choose a close operation for the window. Exit on close means exit when the user presses X.
		
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		
		

		// Create the buttons and their icons
		
		// Each button is create with their icon
		// The font of each icon is ariel font, 20 pixels and is in bold.
		
		// Numbers
		
		JButton b0 = new JButton ("0");
		b0.setFont(new Font("Ariel", Font.BOLD, 20));
		JButton b1 = new JButton ("1");
		b1.setFont(new Font("Ariel", Font.BOLD, 20));
		JButton b2 = new JButton ("2");
		b2.setFont(new Font("Ariel", Font.BOLD, 20));
		JButton b3 = new JButton ("3");
		b3.setFont(new Font("Ariel", Font.BOLD, 20));
		JButton b4 = new JButton ("4");
		b4.setFont(new Font("Ariel", Font.BOLD, 20));
		JButton b5 = new JButton ("5");
		b5.setFont(new Font("Ariel", Font.BOLD, 20));
		JButton b6 = new JButton ("6");
		b6.setFont(new Font("Ariel", Font.BOLD, 20));
		JButton b7 = new JButton ("7");
		b7.setFont(new Font("Ariel", Font.BOLD, 20));
		JButton b8 = new JButton ("8");
		b8.setFont(new Font("Ariel", Font.BOLD, 20));
		JButton b9 = new JButton ("9");
		b9.setFont(new Font("Ariel", Font.BOLD, 20));
		
		// Operators
		
		JButton bPlus = new JButton ("+");
		bPlus.setFont(new Font("Ariel", Font.BOLD, 20));
		JButton bMinus = new JButton ("-");
		bMinus.setFont(new Font("Ariel", Font.BOLD, 20));
		JButton bMultiply = new JButton ("x");
		bMultiply.setFont(new Font("Ariel", Font.BOLD, 20));
		JButton bDivide = new JButton ("\u00F7");
		bDivide.setFont(new Font("Ariel", Font.BOLD, 20));
		
		// Other
		
		JButton bEquals = new JButton ("=");
		bEquals.setFont(new Font("Ariel", Font.BOLD, 20));
		JButton bDecimalPoint = new JButton (".");
		bDecimalPoint.setFont(new Font("Ariel", Font.BOLD, 20));
		
		// Clear
		
		JButton bC = new JButton ("C");
		bC.setFont(new Font("Ariel", Font.BOLD, 20));
		JButton bAC = new JButton ("AC");
		bAC.setMargin(new Insets(0, 0, 0, 0));
		bAC.setFont(new Font("Ariel", Font.BOLD, 20));
		
		// Special characters
		
		JButton bSquareRoot = new JButton ("\u221A");
		bSquareRoot.setMargin(new Insets(0, 0, 0, 0));
		bSquareRoot.setFont(new Font("Ariel", Font.BOLD, 20));
		
		JButton bCubeRoot = new JButton ("\u221B");
		bCubeRoot.setMargin(new Insets(0, 0, 0, 0));
		bCubeRoot.setFont(new Font("Ariel", Font.BOLD, 20));
		
		JButton bSquare = new JButton ("\u00B2");
		bSquare.setMargin(new Insets (0, 0, 0, 0));
		bSquare.setFont(new Font("Ariel", Font.BOLD, 20));
		
		JButton bCube = new JButton ("\u00B3");
		bCube.setMargin(new Insets (0, 0, 0,0));
		bCube.setFont(new Font ("Ariel", Font.BOLD, 20));
		
		JButton bSin = new JButton ("sin");
		bSin.setMargin (new Insets (0, 0, 0, 0));
		bSin.setFont (new Font ("Ariel", Font.BOLD, 20));
		
		JButton bCos = new JButton ("cos");
		bCos.setMargin (new Insets (0, 0, 0, 0));
		bCos.setFont (new Font ("Ariel", Font.BOLD, 20));
		
		JButton bTan = new JButton ("tan");
		bTan.setMargin (new Insets (0, 0, 0, 0));
		bTan.setFont (new Font ("Ariel", Font.BOLD, 20));
		
		JButton bLn = new JButton ("ln");
		bLn.setMargin (new Insets (0, 0, 0, 0));
		bLn.setFont (new Font ("Ariel", Font.BOLD, 20));
		
		JButton bArcSin = new JButton ("sin" + "\u207B" + "\u00B9");
		bArcSin.setMargin (new Insets (0, 0, 0, 0));
		bArcSin.setFont (new Font ("Ariel", Font.BOLD, 20));
		
		JButton bArcCos = new JButton ("cos" + "\u207B" + "\u00B9");
		bArcCos.setMargin (new Insets (0, 0, 0, 0));
		bArcCos.setFont (new Font ("Ariel", Font.BOLD, 20));
		
		JButton bArcTan = new JButton ("tan" + "\u207B" + "\u00B9");
		bArcTan.setMargin (new Insets (0, 0, 0, 0));
		bArcTan.setFont (new Font ("Ariel", Font.BOLD, 20));
		
		JButton bLog = new JButton ("log");
		bLog.setMargin (new Insets (0, 0, 0, 0));
		bLog.setFont (new Font ("Ariel", Font.BOLD, 20));
		
		JButton bReciprocal = new JButton ("\u207B" + "\u00B9");
		bReciprocal.setMargin (new Insets (0, 0, 0, 0));
		bReciprocal.setFont (new Font ("Ariel", Font.BOLD, 20));
		
		JButton bLogBase = new JButton ("log (x,y)");
		bLogBase.setMargin (new Insets (0, 0, 0, 0));
		bLogBase.setFont (new Font ("Ariel", Font.BOLD, 20));
		
		JButton bComma = new JButton (",");
		bComma.setMargin (new Insets (0, 0, 0, 0));
		bComma.setFont (new Font ("Ariel", Font.BOLD, 20));
		
		JButton bFactorial = new JButton ("!");
		bFactorial.setMargin (new Insets (0, 0, 0, 0));
		bFactorial.setFont (new Font ("Ariel", Font.BOLD, 20));
		
		JButton bPercent = new JButton ("%");
		bPercent.setMargin (new Insets (0, 0, 0, 0));
		bPercent.setFont (new Font ("Ariel", Font.BOLD, 20));
		
		// Place each button in the correct place using the set bounds function
		// (x co-ordinate, y co-ordinate, width, height)
		
		// Numbers
		
		b0.setBounds (675, 500, 100, 75);
		b1.setBounds (550, 400, 100, 75);
		b2.setBounds (675, 400, 100, 75);
		b3.setBounds (800, 400, 100, 75);
		b4.setBounds (550, 300, 100, 75);
		b5.setBounds (675, 300, 100, 75);
		b6.setBounds (800, 300, 100, 75);
		b7.setBounds (550, 200, 100, 75);
		b8.setBounds (675, 200, 100, 75);
		b9.setBounds (800, 200, 100, 75);
		
		// Operators 
		
		bPlus.setBounds (975, 300, 100, 75);
		bMinus.setBounds (1100, 300, 100, 75);
		bMultiply.setBounds (975, 400, 100, 75);
		bDivide.setBounds (1100, 400, 100, 75);
		
		// Other
		
		bDecimalPoint.setBounds (975, 600, 100, 75);
		bEquals.setBounds (1100, 600, 100, 75);
		bComma.setBounds (975, 500, 100, 75);
		
		// Clear
		
		bC.setBounds (975, 200, 100, 75);
		bAC.setBounds (1100, 200, 100, 75);
		
		// Special characters
		
		bSquareRoot.setBounds (50, 200, 100, 75);
		bCubeRoot.setBounds (175, 200, 100, 75);
		bSquare.setBounds (50, 300, 100, 75);
		bCube.setBounds (175, 300, 100, 75);
		
		bSin.setBounds (50, 400, 100, 75);
		bCos.setBounds (175, 400, 100, 75);
		bTan.setBounds (300, 400, 100, 75);
		
		bLn.setBounds (50, 600, 100, 75);
		bLog.setBounds (175, 600, 100, 75);
		
		bArcSin.setBounds (50, 500, 100, 75);
		bArcCos.setBounds (175, 500, 100, 75);
		bArcTan.setBounds (300, 500, 100, 75);
		
		bReciprocal.setBounds (300, 300, 100, 75);
		
		bLogBase.setBounds (300, 600, 100, 75);
		
		bFactorial.setBounds (300, 200, 100, 75);
		
		bPercent.setBounds (1100, 500, 100, 75);
		
		
		
		
		// Display the buttons by adding them to the JFrame
		
		
		  add (b0); add (b1); add (b2); add (b3); add (b4); add (b5); add (b6); add
		  (b7); add (b8); add (b9);
		  
		  add (bPlus); add (bMinus); add (bMultiply); add (bDivide);
		  
		  add (bDecimalPoint); add (bEquals); add (bComma);
		  
		  add (bC); add (bAC);
		  
		  add (bSquareRoot); add (bCubeRoot); add (bSquare); add (bCube);
		  
		  add (bSin); add (bCos); add (bTan);
		  
		  add (bLn);
		  
		  add (bArcSin); add (bArcCos); add (bArcTan);
		  
		  add (bLog);
		  
		  add (bReciprocal);
		  
		  add (bLogBase);
		  
		  add (bFactorial);
		  
		  add (bPercent);
		 
		
		add (bLogBase);
		
		// Create, position and display a text field
		
		txt.setBounds (550, 50, 650, 100);
		txt.setFont(new Font("Ariel", Font.BOLD, 30));
		txt.setEditable (false);
		txt.setBackground(Color.WHITE);
		add (txt);
		
		// Display the window
		
		setVisible (true);
		

		
		
		
		// Create an action listener for the button 0
		
		ActionListener num0 = new ActionListener () {
			
			// Create a method for what to do for this action listener
			
			public void actionPerformed (ActionEvent ae) {
				
				// Display in the text field the text currently there and the number "0"
				// For this line of code I adapted similar code from this website:
				// http://embscomputerart.com/java-gui-graphical-user-interface-calculator-program/ 
				
				txt.setText(txt.getText() +"0");
				
				// Add "0" to the array list called calculations.
				// This will store the user input to allow the final calculation to take place.
				// I used this website below to use the right syntax to add to an array list.
				// Source: https://www.w3schools.com/java/java_arraylist.asp
				
				calculations.add("0");
				
			}
						
		};
		
		// Create an action listener for the button 1
		
		ActionListener num1 = new ActionListener () {
			
			// Create a method for what to do for this action listener
			
			public void actionPerformed (ActionEvent ae) {
				
				// Display in the text field the text currently there and the number "1"
				// For this line of code I adapted similar code from this website:
				// http://embscomputerart.com/java-gui-graphical-user-interface-calculator-program/
				
				txt.setText(txt.getText() + "1");
				
				// Add "1" to the array list called calculations.
				// This will store the user input to allow the final calculation to take place.
				// I used this website below to use the right syntax to add to an array list.
				// Source: https://www.w3schools.com/java/java_arraylist.asp
				
				calculations.add("1");
				
			}
		};
		
		// Create an action listener for the button 2
		
		ActionListener num2 = new ActionListener () {
			
			// Create a method for what to do for this action listener
			
			public void actionPerformed (ActionEvent ae) {
				
				// Display in the text field the text currently there and the number "2"
				// For this line of code I adapted similar code from this website:
				// http://embscomputerart.com/java-gui-graphical-user-interface-calculator-program/
				
				txt.setText(txt.getText()+ "2");
				
				// Add "2" to the array list called calculations.
				// This will store the user input to allow the final calculation to take place.
				// I used this website below to use the right syntax to add to an array list.
				// Source: https://www.w3schools.com/java/java_arraylist.asp
				
				calculations.add("2");
				
			}

		};
		
		// Create an action listener for the button 3
		
		ActionListener num3 = new ActionListener () {
			
			// Create a method for what to do for this action listener
			
			public void actionPerformed (ActionEvent ae) {
				
				// Display in the text field the text currently there and the number "3"
				// For this line of code I adapted similar code from this website:
				// http://embscomputerart.com/java-gui-graphical-user-interface-calculator-program/
				
				txt.setText(txt.getText()+ "3");
				
				// Add "3" to the array list called calculations.
				// This will store the user input to allow the final calculation to take place.
				// I used this website below to use the right syntax to add to an array list.
				// Source: https://www.w3schools.com/java/java_arraylist.asp
				
				calculations.add("3");
				
			}
			
		};
		
		// Create an action listener for the button 4
		
		ActionListener num4 = new ActionListener () {
			
			// Create a method for what to do for this action listener
			
			public void actionPerformed (ActionEvent ae) {
				
				// Display in the text field the text currently there and the number "4"
				// For this line of code I adapted similar code from this website:
				// http://embscomputerart.com/java-gui-graphical-user-interface-calculator-program/
				
				txt.setText(txt.getText()+ "4");
				
				// Add "4" to the array list called calculations.
				// This will store the user input to allow the final calculation to take place.
				// I used this website below to use the right syntax to add to an array list.
				// Source: https://www.w3schools.com/java/java_arraylist.asp
				
				calculations.add("4");
				
			}

		};
		
		// Create an action listener for the button 5
		
		ActionListener num5 = new ActionListener () {
					
			// Create a method for what to do for this action listener
					
			public void actionPerformed (ActionEvent ae) {
				
				// Display in the text field the text currently there and the number "5"
				// For this line of code I adapted similar code from this website:
				// http://embscomputerart.com/java-gui-graphical-user-interface-calculator-program/
						
				txt.setText(txt.getText()+ "5");
				
				// Add "5" to the array list called calculations.
				// This will store the user input to allow the final calculation to take place.
				// I used this website below to use the right syntax to add to an array list.
				// Source: https://www.w3schools.com/java/java_arraylist.asp
				
				calculations.add("5");
						
			}
					
		};
		
		// Create an action listener for the button 6
		
		ActionListener num6 = new ActionListener () {
			
			// Create a method for what to do for this action listener
			
			public void actionPerformed (ActionEvent ae) {
				
				// Display in the text field the text currently there and the number "6"
				// For this line of code I adapted similar code from this website:
				// http://embscomputerart.com/java-gui-graphical-user-interface-calculator-program/
				
				txt.setText(txt.getText()+ "6");
				
				// Add "6" to the array list called calculations.
				// This will store the user input to allow the final calculation to take place.
				// I used this website below to use the right syntax to add to an array list.
				// Source: https://www.w3schools.com/java/java_arraylist.asp
				
				calculations.add("6");
				
			}
		
		};
		
		// Create an action listener for the button 7

		ActionListener num7 = new ActionListener () {
			
			// Create a method for what to do for this action listener
			
			public void actionPerformed (ActionEvent ae) {
				
				// Display in the text field the text currently there and the number "7"
				// For this line of code I adapted similar code from this website:
				// http://embscomputerart.com/java-gui-graphical-user-interface-calculator-program/
				
				txt.setText(txt.getText()+ "7");
				
				// Add "7" to the array list called calculations.
				// This will store the user input to allow the final calculation to take place.
				// I used this website below to use the right syntax to add to an array list.
				// Source: https://www.w3schools.com/java/java_arraylist.asp
				
				calculations.add("7");
				
			}
		};
		
		// Create an action listener for the button 8

		ActionListener num8 = new ActionListener () {
			
			// Create a method for what to do for this action listener
			
			public void actionPerformed (ActionEvent ae) {
				
				// Display in the text field the text currently there and the number "8"
				// For this line of code I adapted similar code from this website:
				// http://embscomputerart.com/java-gui-graphical-user-interface-calculator-program/
				
				txt.setText(txt.getText()+ "8");
				
				// Add "8" to the array list called calculations.
				// This will store the user input to allow the final calculation to take place.
				// I used this website below to use the right syntax to add to an array list.
				// Source: https://www.w3schools.com/java/java_arraylist.asp
				
				calculations.add("8");
				
			}

		};
		
		// Create an action listener for the button 9

		ActionListener num9 = new ActionListener () {
			
			// Create a method for what to do for this action listener
			
			public void actionPerformed (ActionEvent ae) {
				
				// Display in the text field the text currently there and the number "9"
				// For this line of code I adapted similar code from this website:
				// http://embscomputerart.com/java-gui-graphical-user-interface-calculator-program/
				
				txt.setText(txt.getText()+ "9");
				
				// Add "9" to the array list called calculations.
				// This will store the user input to allow the final calculation to take place.
				// I used this website below to use the right syntax to add to an array list.
				// Source: https://www.w3schools.com/java/java_arraylist.asp
				
				calculations.add("9");
				
			}

		};
		
		// Create an action listener for the plus button

		ActionListener plus = new ActionListener () {
			
			// Create a method for what to do for this action listener
			
			public void actionPerformed (ActionEvent ae) {
				
				// Display in the text field the text currently there and the symbol "+"
				// For this line of code I adapted similar code from this website:
				// http://embscomputerart.com/java-gui-graphical-user-interface-calculator-program/
				
				txt.setText(txt.getText()+ " + ");
				
				// Add "+" to the array list called calculations.
				// This will store the user input to allow the final calculation to take place.
				// I used this website below to use the right syntax to add to an array list.
				// Source: https://www.w3schools.com/java/java_arraylist.asp
				
				calculations.add("+");
				
				
			}
			
		};
		
		// Create an action listener for the minus button

		ActionListener minus = new ActionListener () {
			
			// Create a method for what to do for this action listener
			
			public void actionPerformed (ActionEvent ae) {
				
				// Display in the text field the text currently there and the symbol "-"
				// For this line of code I adapted similar code from this website:
				// http://embscomputerart.com/java-gui-graphical-user-interface-calculator-program/
				
				txt.setText(txt.getText()+ " - ");
				
				// Add "-" to the array list called calculations.
				// This will store the user input to allow the final calculation to take place.
				// I used this website below to use the right syntax to add to an array list.
				// Source: https://www.w3schools.com/java/java_arraylist.asp
				
				calculations.add("-");
				
			}
		};
		
		// Create an action listener for the multiply button

		ActionListener multiply = new ActionListener () {
			
			// Create a method for what to do for this action listener
			
			public void actionPerformed (ActionEvent ae) {
				
				// Display in the text field the text currently there and the symbol "*"
				// For this line of code I adapted similar code from this website:
				// http://embscomputerart.com/java-gui-graphical-user-interface-calculator-program/
				
				txt.setText(txt.getText()+ " x ");
				
				// Add "*" to the array list called calculations.
				// This will store the user input to allow the final calculation to take place.
				// I used this website below to use the right syntax to add to an array list.
				// Source: https://www.w3schools.com/java/java_arraylist.asp
				
				calculations.add("x");
				
			}
			
		};
		
		// Create an action listener for the divide button

		ActionListener divide = new ActionListener () {
			
			// Create a method for what to do for this action listener
			
			public void actionPerformed (ActionEvent ae) {
				
				// Display in the text field the text currently there and the symbol "/"
				// For this line of code I adapted similar code from this website:
				// http://embscomputerart.com/java-gui-graphical-user-interface-calculator-program/
				
				txt.setText(txt.getText()+ " \u00F7 ");
				
				// Add "/" to the array list called calculations.
				// This will store the user input to allow the final calculation to take place.
				// I used this website below to use the right syntax to add to an array list.
				// Source: https://www.w3schools.com/java/java_arraylist.asp
				
				calculations.add("\u00F7");
				
			}

		};
		
		// Create an action listener for the decimal point button

		ActionListener decimalPoint = new ActionListener () {
			
			// Create a method for what to do for this action listener
			
			public void actionPerformed (ActionEvent ae) {
				
				// Display in the text field the text currently there and the symbol "."
				// For this line of code I adapted similar code from this website:
				// http://embscomputerart.com/java-gui-graphical-user-interface-calculator-program/
				
				txt.setText(txt.getText()+ ".");
				
				// Add "." to the array list called calculations.
				// This will store the user input to allow the final calculation to take place.
				// I used this website below to use the right syntax to add to an array list.
				// Source: https://www.w3schools.com/java/java_arraylist.asp
				
				calculations.add(".");
				
			}
		};
		
		// Create an action listener for the comma button

		ActionListener comma = new ActionListener () {
			
			// Create a method for what to do for this action listener
			
			public void actionPerformed (ActionEvent ae) {
				
				// Display in the text field the text currently there and the symbol ","
				// For this line of code I adapted similar code from this website:
				// http://embscomputerart.com/java-gui-graphical-user-interface-calculator-program/
				
				txt.setText(txt.getText()+ ",");
				
				// Add "." to the array list called calculations.
				// This will store the user input to allow the final calculation to take place.
				// I used this website below to use the right syntax to add to an array list.
				// Source: https://www.w3schools.com/java/java_arraylist.asp
				
				calculations.add(",");
				
			}
		};
		
		// Create an action listener for the AC button

		ActionListener AC = new ActionListener () {
					
			// Create a method for what to do for this action listener
					
			public void actionPerformed (ActionEvent ae) {
				
				// Clear the screen
						
				txt.setText("");
						
				// Clear the calculations array 
				
				calculations.clear();
						
			}
		};
		
		// Create an action listener for the C button

		ActionListener C = new ActionListener () {
							
			// Create a method for what to do for this action listener
							
			public void actionPerformed (ActionEvent ae) {
				
				// Find the length of the array list calculations
				
				int length = calculations.size();
				
				// Remove the last element in calculations array list
				
				calculations.remove(length-1);
				
				// Create a variable newText to store the new text
				
				String newText = ""; 
				
				// Create a for loop to add everything back into the variable newText to display the new text to the user.
				
				for (int index = 0; index < calculations.size(); index++) {
					
					newText = newText + calculations.get(index);
				      
				}			
				
				// Display the new text in the variable newText
				
				txt.setText(newText);
								
				
								
			}
		};
		
		// Create an action listener for the square root button

		ActionListener squareRoot = new ActionListener () {
							
			// Create a method for what to do for this action listener
							
			public void actionPerformed (ActionEvent ae) {
				
				// Display the square root sign
				
				txt.setText(txt.getText() + "\u221A" + "");
				
				// Add sqrt to the calculations array
				
				calculations.add("Sqrt");
				
				// Set the boolean usingSquareRoot to true to use the sRoot method.
				
				usingSquareRoot = true;
								
				
								
			}
		};
		
		// Create an action listener for the cube root button
		
		ActionListener cubeRoot = new ActionListener () {
			
			// Create a method for what to do for this action listener

			public void actionPerformed (ActionEvent ae) {
				
				// Display the cube root sign
				
				txt.setText(txt.getText() + "\u221B");
				
				// Add "CubeRoot" to the calculations array
				
				calculations.add ("CubeRoot");
				
				// Set the boolean usingCubeRoot to true to use the cRoot method.
				
				usingCubeRoot = true;
				
			}
			
		};
		
		// Create an action listener for the square button
		
		ActionListener square = new ActionListener () {
			
			// Create a method for what to do for this action listener

			public void actionPerformed (ActionEvent ae) {
				
				// Display the square symbol
				
				txt.setText(txt.getText() + "\u00B2");
				
				// Add "Square" to the calculations array
				
				calculations.add ("Square");
				
				// Set the boolean usingSquare to true to use the square method
				
				usingSquare = true;
				
			}
			
		};
		
		// Create an action listener for the cube button
		
		ActionListener cube = new ActionListener () {
			
			// Create a method for what to do for this action listener

			public void actionPerformed (ActionEvent ae) {
				
				// Display the cube symbol
				
				txt.setText(txt.getText() + "\u00B3");
				
				// Add "Cube" to the calculations array
				
				calculations.add ("Cube");
				
				// Set the boolean usingCube to true to use the cube method
				
				usingCube = true;
				
			}
			
		};
		
		// Create an action listener for the sin button
		
		ActionListener sin = new ActionListener () {
			
			// Create a method for what to do for this action listener

			public void actionPerformed (ActionEvent ae) {
				
				// Display sin
				
				txt.setText(txt.getText() + "sin ");
				
				// Add "sin" to the calculations array
				
				calculations.add ("sin");
				
				// Set the boolean usingSin to true to use the sin method
				
				usingSin = true;
				
			}
			
		};
		
		// Create an action listener for the cos button
		
		ActionListener cos = new ActionListener () {
			
			// Create a method for what to do for this action listener

			public void actionPerformed (ActionEvent ae) {
				
				// Display cos
				
				txt.setText(txt.getText() + "cos ");
				
				// Add "cos" to the calculations array
				
				calculations.add ("cos");
				
				// Set the boolean usingCos to true to use the cos method
				
				usingCos = true;
				
			}
			
		};
		
		// Create an action listener for the tan button
		
		ActionListener tan = new ActionListener () {
			
			// Create a method for what to do for this action listener

			public void actionPerformed (ActionEvent ae) {
				
				// Display tan
				
				txt.setText(txt.getText() + "tan ");
				
				// Add "tan" to the calculations array
				
				calculations.add ("tan");
				
				// Set the boolean usingTan to true to use the tan method
				
				usingTan = true;
				
			}
			
		};
		
		// Create an action listener for the ln button
		
		ActionListener ln = new ActionListener () {
					
			// Create a method for what to do for this action listener

			public void actionPerformed (ActionEvent ae) {
						
				// Display ln
						
				txt.setText(txt.getText() + "ln ");
						
				// Add "ln" to the calculations array
						
				calculations.add ("ln");
				
				// Set the boolean usingLn to true to use the ln method
						
				usingLn = true;
						
			}
					
		};
		
		// Create an action listener for the arcSin button
		
		ActionListener arcSin = new ActionListener () {
					
			// Create a method for what to do for this action listener

			public void actionPerformed (ActionEvent ae) {
						
				// Display arcSin
						
				txt.setText(txt.getText() + "Sin" + "\u207B" + "\u00B9");
						
				// Add "ArcSin" to the calculations array
						
				calculations.add ("ArcSin");
				
				// Set the boolean usingArcSin to true to use the arcSin method
						
				usingArcSin = true;
						
			}
					
		};
		
		// Create an action listener for the arcCos button
		
		ActionListener arcCos = new ActionListener () {
					
			// Create a method for what to do for this action listener

			public void actionPerformed (ActionEvent ae) {
						
				// Display arcCos
						
				txt.setText(txt.getText() + "Cos" + "\u207B" + "\u00B9");
						
				// Add "arcCos" to the calculations array
						
				calculations.add ("ArcCos");
				
				// Set the boolean usingArcCos to true to use the arcCos method
						
				usingArcCos = true;
						
			}
					
		};
		
		// Create an action listener for the arctan button
		
		ActionListener arcTan = new ActionListener () {
					
			// Create a method for what to do for this action listener

			public void actionPerformed (ActionEvent ae) {
						
				// Display arctan
						
				txt.setText(txt.getText() + "Tan" + "\u207B" + "\u00B9");
						
				// Add "ArcTan" to the calculations array
						
				calculations.add ("ArcTan");
				
				// Set the boolean usingArcTan to true to use the arcTan method
						
				usingArcTan = true;
						
			}
					
		};
	
		// Create an action listener for the log (base 10) button
			
		ActionListener log = new ActionListener () {
			
			// Create a method for what to do for this action listener

			public void actionPerformed (ActionEvent ae) {
						
				// Display log
						
				txt.setText(txt.getText() + "log");
						
				// Add "log" to the calculations array
						
				calculations.add ("log");
				
				// Set the boolean usingLog to true to use the performLog method
						
				usingLog = true;
						
			}
					
		};
		
		// Create an action listener for the reciprocal button
		
		ActionListener reciprocal = new ActionListener () {
			
			// Create a method for what to do for this action listener

			public void actionPerformed (ActionEvent ae) {
						
				// Display the reciprocal sign
						
				txt.setText(txt.getText() + "\u207B" + "\u00B9");
						
				// Add "reciprocal" to the calculations array
						
				calculations.add ("reciprocal");
				
				// Set the boolean usingReciprocal to true to use the performReciprocal method
						
				usingReciprocal = true;
						
			}
					
		};
		
		// Create an action listener for the logBase button
		
		ActionListener logBase = new ActionListener () {
					
			// Create a method for what to do for this action listener

			public void actionPerformed (ActionEvent ae) {
						
				// Display log
						
				txt.setText(txt.getText() + "log ");
						
				// Add "log" to the calculations array
						
				calculations.add ("log");
				
				// Set the boolean usingLogBase to true to use the performLogBase method
						
				usingLogBase = true;
						
			}
					
		};
		
		// Create an action listener for the factorial button
		
		ActionListener factorial = new ActionListener () {
							
			// Create a method for what to do for this action listener

			public void actionPerformed (ActionEvent ae) {
						
				// Display the factorial sign
						
				txt.setText(txt.getText() + "! ");
						
				// Add "!" to the calculations array
						
				calculations.add ("!");
				
				// Set the boolean usingFactorial to true to use the performFactorial method
						
				usingFactorial = true;
						
			}
					
		};
		
		// Create an action listener for the percent button
		
		ActionListener percent = new ActionListener () {
							
			// Create a method for what to do for this action listener

			public void actionPerformed (ActionEvent ae) {
						
				// Display the % sign
						
				txt.setText(txt.getText() + "% ");
						
				// Add "%" to the calculations array
						
				calculations.add ("%");
				
				// Call the performPercentage method
				
				performPercentage ();
						
			}
					
		};
				
		

		// Create an action listener for the equals button

		ActionListener equals = new ActionListener () {
			
			// Create a method for what to do for this action listener
			
			public void actionPerformed (ActionEvent ae) {
				
				// Display in the text field the text currently there and the symbol "="
				// For this line of code I adapted similar code from this website:
				// http://embscomputerart.com/java-gui-graphical-user-interface-calculator-program/
				
				txt.setText(txt.getText()+ " = ");
				
				// Add "=" to the array list called calculations.
				// This will store the user input to allow the final calculation to take place.
				// I used this website below to use the right syntax to add to an array list.
				// Source: https://www.w3schools.com/java/java_arraylist.asp
				
				calculations.add("=");
				
				// Create the boolean foundMethod to allow the code below to continue until the relevant method is found.
				// Set the boolean to false as the create method is not found yet. 
				
				boolean foundMethod = false;
				
				// While the correct method is not found, repeat this code
				
				while (foundMethod == false) {
					
					// If using the square root
				
					if (usingSquareRoot == true) {
						
						// Call the sRoot method
						
						sRoot ();
						
						// Switch the boolean usingSquareRoot to false as the method is no longer needed
						
						usingSquareRoot = false;
						
						// Exit out of the while loop
						
						break;
						
					}
					
					// If using the cube root
					
					if (usingCubeRoot == true) {
						
						// Call the cRoot method
						
						cRoot ();
						
						// Switch the boolean usingCubeRoot to false as the method is no longer needed
						
						usingCubeRoot = false;
						
						// Exit out of the while loop
						
						break;
						
					}
					
					// If using square
					
					if (usingSquare == true) {
						
						// Call the squareNumber method
						
						squareNumber ();
						
						// Switch the boolean usingSquare to false as the method is no longer needed
						
						usingSquare = false;
						
						// Exit out of the while loop
						
						break;
						
					}
					
					// If using cube
					
					if (usingCube == true) {
						
						// Call the cubeNumber method
						
						cubeNumber (); 
						
						// Switch the boolean usingCube to false as the method is no longer needed
						
						usingCube = false;
						
						// Exit out of the while loop
						
						break;
						
					}
					
					// If using sin
					
					if (usingSin == true) {
						
						// Call the sinNumber method
						
						sinNumber ();
						
						// Switch the boolean usingSin to false as the method is no longer needed
						
						usingSin = false;
						
						// Exit out of the while loop
						
						break;
						
					}
					
					// If using cos
					
					if (usingCos == true) {
						
						// Call the cosNumber method
						
						cosNumber ();
						
						// Switch the boolean usingCos to false as the method is no longer needed
						
						usingCos = false;
						
						// Exit out of the while loop
						
						break;
						
					}
					
					// If using tan
					
					if (usingTan == true) {
						
						// Call the tanNumber method
						
						tanNumber ();
						
						// Switch the boolean usingTan to false as the method is no longer needed
						
						usingTan = false;
						
						// Exit out of the while loop
						
						break;
						
					}
					
					// If using ln
					
					if (usingLn == true) {
						
						// Call the performLn method
						
						performLn ();
						
						// Switch the boolean usingLn to false as the method is no longer needed
						
						usingLn = false;
						
						// Exit out of the while loop
						
						break;
						
					}
					
					// If using arcsin
					
					if (usingArcSin == true) {
						
						// Call the arcSinNumber method
						
						arcSinNumber ();
						
						// Switch the boolean usingArcSin to false as the method is no longer needed
						
						usingArcSin = false;
						
						// Exit out of the while loop
						
						break;
						
					}
					
					// If using arccos
					
					if (usingArcCos == true) {
						
						// Call the arcCosNumber method
						
						arcCosNumber ();
						
						// Switch the boolean usingArcCos to false as the method is no longer needed
						
						usingArcCos = false;
						
						// Exit out of the while loop
						
						break;
						
					}
					
					// If using arctan
					
					if (usingArcTan == true) {
						
						// Call the arcTanNumber method
						
						arcTanNumber ();
						
						// Switch the boolean usingArcTan to false as the method is no longer needed
						
						usingArcTan = false;
						
						// Exit out of the while loop
						
						break;
						
					}
					
					// If using log
					
					if (usingLog == true) {
						
						// Call the performLog method
						
						performLog ();
						
						// Switch the boolean usingLog to false as the method is no longer needed
						
						usingLog = false;
						
						// Exit out of the while loop
						
						break;
						
					}
					
					// If using reciprocal
					
					if (usingReciprocal == true) {
						
						// Call the performReciprocal method
						
						performReciprocal ();
						
						// Switch the boolean usingReciprocal to false as the method is no longer needed
						
						usingReciprocal = false;
						
						// Exit out of the while loop
						
						break;
						
					}
					
					// If using logBase
					
					if (usingLogBase == true) {
						
						// Call the performLogBase method
						
						performLogBase ();
						
						// Switch the boolean usingLogBase to false as the method is no longer needed
						
						usingLogBase = false;
						
						// Exit out of the while loop
						
						break;
						
					}
					
					// If using factorial
					
					if (usingFactorial == true) {
						
						// Call the factorialNumber method
						
						factorialNumber ();
						
						// Switch the boolean usingFactorial to false as the method is no longer needed
						
						usingFactorial = false;
						
						// Exit out of the while loop
						
						break;
						
					}
					
					// Else (no scientific features used - perform a normal calculation)
					
					else {
	
						// Call the method perform calculation which will work out and output the answer.
						// This performs basic addition, subtraction, multiplication and division (two numbers only)
					
						performCalculation ();
						
						// Exit out of the while loop
						
						break;
					
					}
				
				}
						
			}
		};
		

		
		
		
		
		
		
		
		// Link each button to their relevant action listeners

		b0.addActionListener (num0);
		b1.addActionListener (num1);
		b2.addActionListener (num2);
		b3.addActionListener (num3);
		b4.addActionListener (num4);
		b5.addActionListener (num5);
		b6.addActionListener (num6);
		b7.addActionListener (num7);
		b8.addActionListener (num8);
		b9.addActionListener (num9);
		bPlus.addActionListener (plus);
		bMinus.addActionListener (minus);
		bMultiply.addActionListener (multiply);
		bDivide.addActionListener (divide);
		bDecimalPoint.addActionListener (decimalPoint);
		bEquals.addActionListener (equals);
		bAC.addActionListener(AC);
		bC.addActionListener(C);
		bSquareRoot.addActionListener(squareRoot);
		bCubeRoot.addActionListener (cubeRoot);
		bSquare.addActionListener (square);
		bCube.addActionListener (cube);
		bSin.addActionListener (sin);
		bCos.addActionListener (cos);
		bTan.addActionListener (tan);
		bLn.addActionListener (ln);
		bLog.addActionListener (log);
		bArcSin.addActionListener (arcSin);
		bArcCos.addActionListener (arcCos);
		bArcTan.addActionListener (arcTan);
		bReciprocal.addActionListener (reciprocal);
		bLogBase.addActionListener (logBase);
		bComma.addActionListener (comma);
		bFactorial.addActionListener (factorial);
		bPercent.addActionListener (percent);
		
		
		
	} 
	
	// Create a method called performCalculation, which will carry out the calculation
	// A static method that does NOT need to be accessed by objects
	// Void method does NOT need to return a value
	
	static void performCalculation() {
		
		// Create some arrays and variables for this part of the method
		
		// Create an array of numbers
		
		String [] numbers = {"0","1","2","3","4","5","6","7","8","9"};
		
		// Create an array of operators
		
		String [] operators = {"+", "-", "x", "\u00F7", "="};
		
		// Create a variable to store the item
		
		String item = "";
		
		// Create a variable to store the previous item
		
		String previousItem = "";
		
		// Create a variable to store the index of the first digit of a number after an operator
		
		int firstNumberIndex = 0;
		
		// Create a variable to store the index of the last digit of a number before an operator
		
		int finalNumberIndex = 0;
		
		// Create a counter variable to control how many numbers are stored in the array
		
		int counter = 0;
		
		// Create a string num1 to store the string value of the first number
		
	    String num1 = "";
	    
	    // Create a string num2 to store the string value of the second number
	    
		String num2 = "";
		
		// Create a double variable number1 to store the decimal value of the first number 
		
		double number1 = 0;
		
		// Create a double variable number2 to store the decimal value of the second number
		
		double number2 = 0;
		
		// Create a double variable result to store the result of the calculation
		
		double result = 0;
		
		// Create a variable operatorPosition to store the position of the operator in the calculation.
		
		int operatorPositon = 0;
		
		
		
		
		
		
		
		
		// Create a for loop to loop through the calculations array.
		// This loops through the array storing the user input.
				
		for (int i = 0; i < calculations.size(); i++) {
			
			// Get the corresponding item in the array and save to the variable currentItem
			
			String currentItem = calculations.get(i);
			
			// Set the boolean foundUseOFItem to false
			
			boolean foundUseOfItem = false;
			
			
			
			
			// Create a while loop
			// The purpose of the while loop is to find out whether the item in the array is a number, an operator or a decimal point
			
			while  (foundUseOfItem == false) {
				
				
				
				// First of all, see if the element is a number
				// For each element in the array called numbers see if the element exists in the array.
				// If true, the element is a number
				// If false, the element is not a number 
				      
				for (String element : numbers) { 
					
					// If the element is found in the array called numbers
					
					if (element == currentItem) {
						
						// Set the value of previousItem to the value of the current item
						
						previousItem = item;
						
						// Set the item to a number
						
						item = "number";
					
				        // We have now found the use of the item. 
				        // We can now set foundUseOfItem to true to break the while loop
				        
				        foundUseOfItem = true;
					} 
					
		        } 
				
				
				
				
				// Now see if the element is a operator (+, -, *, /)
				// For each element in the array called operators see if the element exists in the array.
				// If true, the element is a operator
				// If false, the element is not a operator 
					
				for (String element : operators) {
					
					// If the element is found in the array called operators
					
					if (element == currentItem) {
						
						// Set the value of previousItem to the value of the current item
						
						previousItem = item;
						
						// Set the item to an operator
						
						item = "operator";
						
				        // We have now found the use of the item. 
				        // We can now set foundUseOfItem to true to break the while loop
						
				        foundUseOfItem = true;
				        
					} 
					
				}
				
				
				// If the item is a decimal point, then set the item to a decimal point and break out of the while loop
				
				if (currentItem.equals (".")) {
					
					// Set the item to decimalPoint
					
					item = "decimalPoint";
					
					// We can now set foundUseOfItem to true to break the while loop
					
					foundUseOfItem = true;
					
				}
			
			}
			
			
			
			// If the item is a decimal point, nothing else needs to be done for this iteration of the for loop. 
			// Therefore, the program should continue to the next iteration of the for loop.
			
			if (item.equals("decimalPoint")) {
				
				// Continue - the decimal point can be ignored as float variables are used
				
				continue;
				
			}
	
			
			
			
			

			// If the item is a number
			
			if (item.equals("number")) {
				
				// If the number is the first in the calculations array
				
				if (i==0) {
					
					// The firstNumberIndex of the first number is equals to i (0)
					
					firstNumberIndex = i;
					
				}
				
				// If the previous item was an operator
				
				if (previousItem.equals("operator")) {
					
					// This means that i is the start of the second number
					// The firstNumberIndex is set to 1
					
					firstNumberIndex = i;
					
				}
					
				}
			
			
				
			
			
				
				
				// If the item is an operator
				
				if (item.equals("operator")) {
					
					// If the result is not equals (is +, -, *, /)
					
					if (calculations.get(i).equals("+") || calculations.get(i).equals("-") || calculations.get(i).equals("x") || calculations.get(i).equals("\u00F7")) {
						
						// Find the position of the operator
						
						operatorPositon = i;
					
					}
					
					
					
					
					// If this is the first value in the calculations array
					
					if (i==0) {
						
						// As the first value cannot be an operator, print an error message (syntax error)
						
						txt.setText("Syntax error");
						
						// Break out of the while loop
						
						break;
						
						// This does causes some problems, as the minus sign is considered an operator, but is actually part of a number.
						// This means that the program cannot work with negative numbers.
						// This could be an area for improvement.
					
						
					}
					
					
					
					// If the previous item was an operator
						
					else if (previousItem.equals("operator")) {
						
						// As there cannot be two operators in a row, print an error message (syntax error)
						
						txt.setText("Syntax error");
						
						// Break out of the while loop
						
						break;
						
					}
					
					
					
					
					else {
						
						// The number before the operator index indicates the final position of the number. Therefore, set the finalNumberIndex
						
						finalNumberIndex = i - 1;
						
						
						
						
						// Convert the user input in an array into a string
						
						// Create a string builder object
						
						StringBuilder sb = new StringBuilder();
						
						// Set the starting index of the number
						
						int a = firstNumberIndex;
						
						// Convert the array list to an array
						
						String[] array = calculations.toArray(new String[0]);
						
						// Create a for loop to add the entire number to the string
						
						for (a = firstNumberIndex; a < finalNumberIndex + 1; a++) {
							
							// If there is an operator, stop the building of the string
							
							if ((array[a].equals("+") || array [a].equals("-") || array[a].equals("x") || array[a].equals("\u00F7"))) {
								
								// Exit the for loop as the operator is found
							
								break;
							
							}
							
							// Add the number to the string
							
							sb.append(array[a]);
							
						}
						
						// Convert the object into a string

						String singleString = sb.toString();
						
						
						
						// Increment the counter by 1 as a number has been created
						
						counter++;
						
						
						// If the counter is 1 (this is the first number)
						
						if (counter == 1) {
							
							// Store the string in the string variable num1
							
							num1 = singleString;
							
							// Cast the string to a double and store in the variable number1 to perform the calculation
							
							number1 = Double.parseDouble(num1);
							
						}
						
						
						// If the counter is 2 (this is the second number)
						
						if (counter == 2) {
							
							// Store the string in the string variable num2
							
							num2 = singleString;
							
							// Cast the string to a double and store in the variable number2 to perform the calculation
							
							number2 = Double.parseDouble(num2);
							
							
							// If the operator is a plus
							
							if (calculations.get(operatorPositon).equals("+")) {
									
								// Add the two numbers and store the answer in the variable result
									
								result = number1 + number2;
								
							}
							
							// If the operator is a minus
								
							if (calculations.get(operatorPositon).equals("-")) {
								
								// Subtract the number2 from number1 and store the answer in the variable result
									
								result = number1 - number2;
								
							}
							
							// If the operator is a multiplication sign
								
							if (calculations.get(operatorPositon).equals("x")) {
								
								// Multiply the two number and store the answer in the variable result
									
								result = number1 * number2;
									
							}
							
							// If the operator is a division sign
								
							if (calculations.get(operatorPositon).equals("\u00F7")) {
								
								// If the second number is a zero
								
								if (number2 == 0) {
									
									// Display a maths error as division by zero is impossible
									
									txt.setText("Maths Error");
									
									// Return (stop) the method
									
									return;
								}
								
								else {
									
									// Divide number1 by number2 and store the answer in the variable result
									
									result = number1 / number2;
								
								}
									
							}
							
							
							
							// Display the current text in the text field and the result
							
							
							txt.setText(txt.getText()+ result + "");
								
								
						}
							
					}
	
				}
				
			}
		
		}
	
	
	
	
	 // Create a method to find the square root of the number and output the result
	
	static void sRoot () {
		
		// Convert the user input in an array into a string
		
		// Create a string builder object
		
		StringBuilder sb = new StringBuilder();

		// Convert the array list to an array
		
		String[] array = calculations.toArray(new String[0]);
		
		// Create a for loop to add the entire number to the string
		// Start at 1 to avoid the square root sign
		
		for (int a = 1; a < array.length; a++) {
			
			// When you reach the equals sign, stop building the string
			
			if ((array[a].equals("="))) {
			
				break;
			
			}
			
			// If there is a minus sign, call a maths error, as you cannot square root a negative number
			
			if (array[a].equals("-")) {
				
				// Display a maths error in the textfield
				
				txt.setText("Maths error");
				
				// Return (stop) the method
				
				return;
				
			}
			
			// Add the number to the string
			
			sb.append(array[a]);
			
		}
		
		
		// Convert the object into a string

		String singleString = sb.toString();
		
		// Convert the string to a double
		
		double number1 = Double.parseDouble(singleString);
		
		// Square root the number
		
		double sqrtNum = Math.sqrt(number1);
		
		// Output the result
		
		txt.setText(txt.getText() + sqrtNum);
			
	}
	
	
	
	
	
	// A method to find the cube root of the number and output the result
	
	static void cRoot () {
		
		// Convert the user input in an array into a string
		
		// Create a string builder object
		
		StringBuilder sb = new StringBuilder();

		// Convert the array list to an array
		
		String[] array = calculations.toArray(new String[0]);
		
		// Create a for loop to add the entire number to the string
		
		// Start from 1 to avoid the cube root sign
		
		for (int a = 1; a < array.length; a++) {
			
			// When you reach the equals sign, stop building the string
			
			if ((array[a].equals("="))) {
				
				// Exit the for loop
			
				break;
			
			}
			
			// Add the number to the string
			
			sb.append(array[a]);
			
		}
		
		
		// Convert the object into a string

		String singleString = sb.toString();
		
		// Convert the string to a double
		
		double number1 = Double.parseDouble(singleString);
		
		// Cube root the number
		
		double cubeNum = Math.cbrt(number1);
		
		// Output the result
		
		txt.setText(txt.getText() + cubeNum + "");
		
		
		
		
	}
	
	
	
	
	
	
	// A method to find the square of the number and output the result
	
	static void squareNumber () {
		
		// Convert the user input in an array into a string
		
		// Create a string builder object
		
		StringBuilder sb = new StringBuilder();

		// Convert the array list to an array
		
		String[] array = calculations.toArray(new String[0]);
		
		// Create a for loop to add the entire number to the string
		
		for (int a = 0; a < array.length; a++) {
			
			// When you reach the square, stop the building of the string
			
			if ((array[a].equals("Square"))) {
				
				// Exit the for loop
				
				break;
				
			}
			
			// Add the number to the string
			
			sb.append(array[a]);
			
		}
		
		
		// Convert the object into a string

		String singleString = sb.toString();
		
		// Convert the string to a double
		
		double number1 = Double.parseDouble(singleString);
		
		// Find the square of the number
		
		double squareNum = number1 * number1;
		
		// Output the result
		
		txt.setText(txt.getText() + squareNum + "");
		
	}
	
	
	
	
	
	
	
	// A method to find the cube of the number and output the result
	  
	static void cubeNumber () {
		
		// Convert the user input in an array into a string
		
		// Create a string builder object
		
		StringBuilder sb = new StringBuilder();

		// Convert the array list to an array
		
		String[] array = calculations.toArray(new String[0]);
		
		// Create a for loop to add the entire number to the string
		
		for (int a = 0; a < array.length; a++) {
			
			// When you reach the cube, stop the building of the string
			
			if (array[a].equals("Cube")) {
				
				// Exit the for loop
				
				break;
				
			}
			
			// Add the number to the string
			
			sb.append(array[a]);
			
		}
		
		
		// Convert the object into a string

		String singleString = sb.toString();
		
		// Convert the string to a double
		
		double number1 = Double.parseDouble(singleString);
		
		// Find the cube of the number
		
		double cubeOfNum = number1 * number1 * number1;
		
		// Output the result
		
		txt.setText(txt.getText() + cubeOfNum + "");
		
	}
	
	// A method to find the sin of the angle and output the result
	
	static void sinNumber () {
		
		// Convert the user input in an array into a string
		
		// Create a string builder object
		
		StringBuilder sb = new StringBuilder();

		// Convert the array list to an array
		
		String[] array = calculations.toArray(new String[0]);
		
		// Create a for loop to add the entire number to the string
		
		for (int a = 1; a < array.length; a++) {
			
			// When you reach the equals sign, stop the building of the string
			
			if (array[a].equals("=")) {
				
				// Exit the for loop
				
				break;
				
			}
			
			// Add the number to the string
			
			sb.append(array[a]);
		
		}
		
		
		
		// Convert the object into a string

		String singleString = sb.toString();
		
		// Convert the string to a double
		
		double number1 = Double.parseDouble(singleString);
		
		// Convert the angle to radians (as Math.sin only works in radians)
		
		double angleInRadians = Math.toRadians(number1);
		
		// Find the sine of the angle
		
		double sinOfNum = Math.sin(angleInRadians);
		
		// Output the result in the textfield
		
		txt.setText(txt.getText() + sinOfNum + "");
			
	}
	
	// A method to find the arcsin of the angle and output the result
	
	static void arcSinNumber () {
		
		// Convert the user input in an array into a string
		
		// Create a string builder object
		
		StringBuilder sb = new StringBuilder();

		// Convert the array list to an array
		
		String[] array = calculations.toArray(new String[0]);
		
		// Create a for loop to add the entire number to the string
		
		for (int a = 1; a < array.length; a++) {
			
			// When you reach the equals sign, stop the building of the string
			
			if (array[a].equals("=")) {
				
				// Exit out of the for loop
				
				break;
				
			}
			
			// Add the number to the string
			
			sb.append(array[a]);
		
		}
		

		
		
		
		// Convert the object into a string

		String singleString = sb.toString();
		
		// Convert the string to a double
		
		double number1 = Double.parseDouble(singleString);
		
		// Find the arcsin of the angle
		
		double degrees = 180*Math.asin(number1)/Math.PI;
		
		// Display the answer in the textfield
		
		txt.setText(txt.getText() + degrees + "");
			
	}
	
	// A method to find the arccos of the angle and output the result
	
	static void arcCosNumber () {
		
		// Convert the user input in an array into a string
		
		// Create a string builder object
		
		StringBuilder sb = new StringBuilder();

		// Convert the array list to an array
		
		String[] array = calculations.toArray(new String[0]);
		
		// Create a for loop to add the entire number to the string
		
		for (int a = 1; a < array.length; a++) {
			
			// When you reach the cube, stop the building of the string
			
			if (array[a].equals("=")) {
				
				// Exit out of the for loop
				
				break;
				
			}
			
			// Add the number to the string
			
			sb.append(array[a]);
		
		}
		
		
		
		// Convert the object into a string

		String singleString = sb.toString();
		
		// Convert the string to a double
		
		double number1 = Double.parseDouble(singleString);
		
		// Find the cube of the number
		
		double degrees = 180*Math.acos(number1)/Math.PI;
		
		txt.setText(txt.getText() + degrees + "");
			
	}
	
	// A method to find the arctan of the angle and output the result
	
	static void arcTanNumber () {
		
		// Convert the user input in an array into a string
		
		// Create a string builder object
		
		StringBuilder sb = new StringBuilder();

		// Convert the array list to an array
		
		String[] array = calculations.toArray(new String[0]);
		
		// Create a for loop to add the entire number to the string
		
		for (int a = 1; a < array.length; a++) {
			
			// When you reach the cube, stop the building of the string
			
			if (array[a].equals("=")) {
				
				// Exit out of the for loop
				
				break;
				
			}
			
			// Add the number to the string
			
			sb.append(array[a]);
		
		}
		
		
		
		// Convert the object into a string

		String singleString = sb.toString();
		
		// Convert the string to a double
		
		double number1 = Double.parseDouble(singleString);
		
		// Find the cube of the number
		
		double degrees = 180*Math.atan(number1)/Math.PI;
		
		txt.setText(txt.getText() + degrees + "");
			
	}
		
	// A method to find the cos of the angle and output the result	
		
	static void cosNumber () {
		
		// Convert the user input in an array into a string
		
		// Create a string builder object
		
		StringBuilder sb = new StringBuilder();

		// Convert the array list to an array
		
		String[] array = calculations.toArray(new String[0]);
		
		// Create a for loop to add the entire number to the string
		
		for (int a = 1; a < array.length; a++) {
			
			// When you reach the cube, stop the building of the string
			
			if (array[a].equals("=")) {
				
				// Exit out of the for loop
				
				break;
				
			}
			
			// Add the number to the string
			
			sb.append(array[a]);
			
		}
	
	
		// Convert the object into a string
	
		String singleString = sb.toString();
		
		// Convert the string to a double
		
		double number1 = Double.parseDouble(singleString);
		
		// Convert the angle to radians (as Math.cos only works in radians)
		
		double angleInRadians = Math.toRadians(number1);
		
		// Find the cosine of the angle
		
		double cosOfNum = Math.cos(angleInRadians);
		
		// Output the result
		
		txt.setText(txt.getText() + cosOfNum + "");
		
	}
		
	// A method to find the tan of the angle and output the result
		
	static void tanNumber () {
		
		// Convert the user input in an array into a string
		
		// Create a string builder object
		
		StringBuilder sb = new StringBuilder();

		// Convert the array list to an array
		
		String[] array = calculations.toArray(new String[0]);
		
		// Create a for loop to add the entire number to the string
		
		for (int a = 1; a < array.length; a++) {
			
			// When you reach the cube, stop the building of the string
			
			if (array[a].equals("=")) {
				
				break;
				
			}
			
			// Add the number to the string
			
			sb.append(array[a]);
			
		}
		
		// Convert the object into a string

		String singleString = sb.toString();
		
		// Convert the string to a double
		
		double number1 = Double.parseDouble(singleString);
		
		// Convert the angle to radians (as Math.tan only works in radians)
		
		double angleInRadians = Math.toRadians(number1);
		
		// Find the tan of the angle
		
		double tanOfNum = Math.tan(angleInRadians);
		
		// Output the result
		
		txt.setText(txt.getText() + tanOfNum + "");
		
	}
	
	// A method to find ln and output the result
	
	static void performLn () {
		
		// Convert the user input in an array into a string
		
		// Create a string builder object
		
		StringBuilder sb = new StringBuilder();

		// Convert the array list to an array
		
		String[] array = calculations.toArray(new String[0]);
		
		// Create a for loop to add the entire number to the string
		// Start at 1 to avoid the square root sign
		
		for (int a = 1; a < array.length; a++) {
			
			// When you reach the equals sign, stop building the string
			
			if ((array[a].equals("="))) {
				
				// Exit out of the for loop
			
				break;
			
			}
			
			// If there is a minus sign, call a maths error, as you cannot square root a negative number
			
			if (array[a].equals("-")) {
				
				// Tell the user there is a maths error
				
				txt.setText("Maths error");
				
				// Return (stop) the function
				
				return;
				
			}
			
			// Add the number to the string
			
			sb.append(array[a]);
			
		}
		
		
		// Convert the object into a string

		String singleString = sb.toString();
		
		// Convert the string to a double
		
		double number1 = Double.parseDouble(singleString);
		
		// Find the log (base 10)
		
		double logNum = Math.log(number1);
		
		// Output the result
		
		txt.setText(txt.getText() + logNum);
			
	}
	
	// A method to find log and output the result

	static void performLog () {
		
		// Convert the user input in an array into a string
		
		// Create a string builder object
		
		StringBuilder sb = new StringBuilder();

		// Convert the array list to an array
		
		String[] array = calculations.toArray(new String[0]);
		
		// Create a for loop to add the entire number to the string
		// Start at 1 to avoid the square root sign
		
		for (int a = 1; a < array.length; a++) {
			
			// When you reach the equals sign, stop building the string
			
			if ((array[a].equals("="))) {
				
				// Exit out of the for loop
			
				break;
			
			}
			
			// If there is a minus sign, call a maths error, as you cannot square root a negative number
			
			if (array[a].equals("-")) {
				
				txt.setText("Maths error");
				return;
				
			}
			
			// Add the number to the string
			
			sb.append(array[a]);
			
		}
		
		
		// Convert the object into a string

		String singleString = sb.toString();
		
		// Convert the string to a double
		
		double number1 = Double.parseDouble(singleString);
		
		// Square root the number
		
		double logNum = Math.log10(number1);
		
		// Output the result
		
		txt.setText(txt.getText() + logNum);
			
	}
	
	// A method to find the log with a specified base and output the result
	
	static void performLogBase () {
		
		int commaPosition = 0;
		
		// Convert the user input in an array into a string
		
		// Create a string builder object
		
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		// Convert the array list to an array
		
		String[] array = calculations.toArray(new String[0]);
		
		// Create a for loop to add the entire number to the string
		// Start at 1 to avoid the square root sign
		
		for (int a = 1; a < array.length; a++) {
			
			// When you reach the equals sign, stop building the string
			
			if ((array[a].equals("="))) {
			
				break;
			
			}
			
			// When your reach a comma
			
			if (array[a].equals(",")) {
				
				commaPosition = a;
				break;
				
			}
			
			// Add the number to the string
			
			sb1.append(array[a]);
			
		}
		
		
		// Convert the object into a string

		String singleString = sb1.toString();
		
		// Convert the string to a double
		
		double number1 = Double.parseDouble(singleString);
		
		for (int b = commaPosition + 1; b < array.length; b++) {
			
			// When you reach the equals sign, stop building the string
			
			if ((array[b].equals("="))) {
			
				break;
			
			}
			
			// Add the number to the string
			
			sb2.append(array[b]);
			
		}
		
		
		// Convert the object into a string

		String singleString2 = sb2.toString();
		
		// Convert the string to a double
		
		double number2 = Double.parseDouble(singleString2);
		
		// Find the log of the number
		
		double logNum = Math.log (number2) / Math.log(number1);
		
		// Output the result
		
		txt.setText(txt.getText() + logNum);
			
	}
	
	// A method to find the reciprocal of the number and output the result
	
	static void performReciprocal () {
		
		// Convert the user input in an array into a string
		
		// Create a string builder object
		
		StringBuilder sb = new StringBuilder();

		// Convert the array list to an array
		
		String[] array = calculations.toArray(new String[0]);
		
		// Create a for loop to add the entire number to the string
		// Start at 1 to avoid the square root sign
		
		for (int a = 0; a < array.length; a++) {
			
			// When you reach the equals sign, stop building the string
			
			
			// If there is a minus sign, call a maths error, as you cannot square root a negative number
			
			if (array[a].equals("reciprocal")) {
				
				break;
				
			}
			
			// Add the number to the string
			
			sb.append(array[a]);
			
		}
		
		
		// Convert the object into a string

		String singleString = sb.toString();
		
		// Convert the string to a double
		
		double number1 = Double.parseDouble(singleString);
		
		// Calculate the reciprocal of the number
		
		double reciprocalNum = 1 / number1;
		
		// Output the result
		
		txt.setText(txt.getText() + reciprocalNum);
			
	}
	
	// A method to find the factorial of the number and output the result
	
	static void factorialNumber () {
		
		// Convert the user input in an array into a string
		
		// Create a string builder object
		
		StringBuilder sb = new StringBuilder();

		// Convert the array list to an array
		
		String[] array = calculations.toArray(new String[0]);
		
		// Create a for loop to add the entire number to the string
		
		for (int a = 0; a < array.length; a++) {
			
			// When you reach the square, stop the building of the string
			
			if ((array[a].equals("!"))) {
				
				// Exit out of the for loop
				
				break;
				
			}
			
			// Add the number to the string
			
			sb.append(array[a]);
			
		}
		
		
		// Convert the object into a string

		String singleString = sb.toString();
		
		// Convert the string to a double
		
		double number1 = Double.parseDouble(singleString);
		
		// Calculate the factorial of the number
		
		long r = 1;
	    for ( long i = 1; i <= number1; i++ ) 
	    {
	        r*=i;
	    }
	    long ans = r;
		
		// Output the result
		
		txt.setText(txt.getText() + ans + "");
		
	}
	
	// A method to find perform calculations using percentages
	
	static void performPercentage () {
		
		// Create some arrays and variables for this part of the method
		
		// Create an array of numbers
		
		String [] numbers = {"0","1","2","3","4","5","6","7","8","9"};
		
		// Create an array of operators
		
		String [] operators = {"+", "-", "x", "\u00F7", "%"};
		
		// Create a variable to store the item
		
		String item = "";
		
		// Create a variable to store the previous item
		
		String previousItem = "";
		
		// Create a variable to store the index of the first digit of a number after an operator
		
		int firstNumberIndex = 0;
		
		// Create a variable to store the index of the last digit of a number before an operator
		
		int finalNumberIndex = 0;
		
		// Create a counter variable to control how many numbers are stored in the array
		
		int counter = 0;
		
		// Create a string num1 to store the string value of the first number
		
	    String num1 = "";
	    
	    // Create a string num2 to store the string value of the second number
	    
		String num2 = "";
		
		// Create a double variable number1 to store the decimal value of the first number 
		
		double number1 = 0;
		
		// Create a double variable number2 to store the decimal value of the second number
		
		double number2 = 0;
		
		// Create a double variable result to store the result of the calculation
		
		double result = 0;
		
		// Create a variable operatorPosition to store the position of the operator in the calculation.
		
		int operatorPositon = 0;
		
		
		
		
		
		
		
		
		// Create a for loop to loop through the calculations array.
		// This loops through the array storing the user input.
				
		for (int i = 0; i < calculations.size(); i++) {
			
			// Get the corresponding item in the array and save to the variable currentItem
			
			String currentItem = calculations.get(i);
			
			// Set the boolean foundUseOFItem to false
			
			boolean foundUseOfItem = false;
			
			
			
			
			// Create a while loop
			// The purpose of the while loop is to find out whether the item in the array is a number, an operator or a decimal point
			
			while  (foundUseOfItem == false) {
				
				
				
				// First of all, see if the element is a number
				// For each element in the array called numbers see if the element exists in the array.
				// If true, the element is a number
				// If false, the element is not a number 
				      
				for (String element : numbers) { 
					
					// If the element is found in the array called numbers
					
					if (element == currentItem) {
						
						// Set the value of previousItem to the value of the current item
						
						previousItem = item;
						
						// Set the item to a number
						
						item = "number";
					
				        // We have now found the use of the item. 
				        // We can now set foundUseOfItem to true to break the while loop
				        
				        foundUseOfItem = true;
					} 
					
		        } 
				
				
				
				
				// Now see if the element is a operator (+, -, *, /)
				// For each element in the array called operators see if the element exists in the array.
				// If true, the element is a operator
				// If false, the element is not a operator 
					
				for (String element : operators) {
					
					// If the element is found in the array called operators
					
					if (element == currentItem) {
						
						// Set the value of previousItem to the value of the current item
						
						previousItem = item;
						
						// Set the item to an operator
						
						item = "operator";
						
				        // We have now found the use of the item. 
				        // We can now set foundUseOfItem to true to break the while loop
						
				        foundUseOfItem = true;
				        
					} 
					
				}
				
				
				// If the item is a decimal point, then set the item to a decimal point and break out of the while loop
				
				if (currentItem.equals (".")) {
					
					item = "decimalPoint";
					foundUseOfItem = true;
					
				}
			
			}
			
			
			
			// If the item is a decimal point, nothing else needs to be done for this iteration of the for loop. 
			// Therefore, the program should continue to the next iteration of the for loop.
			
			if (item.equals("decimalPoint")) {
				
				continue;
				
			}
	
			
			
			
			

			// If the item is a number
			
			if (item.equals("number")) {
				
				// If the number is the first in the calculations array
				
				if (i==0) {
					
					// The firstNumberIndex of the first number is equals to i (0)
					
					firstNumberIndex = i;
					
				}
				
				// If the previous item was an operator
				
				if (previousItem.equals("operator")) {
					
					// This means that i is the start of the second number
					// The firstNumberIndex is set to 1
					
					firstNumberIndex = i;
					
				}
					
				}
			
			
				
			
			
				
				
				// If the item is an operator
				
				if (item.equals("operator")) {
					
					// If the result is not equals (is +, -, *, /)
					
					if (calculations.get(i).equals("+") || calculations.get(i).equals("-") || calculations.get(i).equals("x") || calculations.get(i).equals("\u00F7")) {
						
						// Find the position of the operator
						
						operatorPositon = i;
					
					}
					
					
					
					
					// If this is the first value in the calculations array
					
					if (i==0) {
						
						// As the first value cannot be an operator, print an error message (syntax error)
						
						txt.setText("Syntax error");
						
						// Break out of the while loop
						
						break;
						
						// This does causes some problems, as the minus sign is considered an operator, but is actually part of a number.
						// This means that the program cannot work with negative numbers.
						// This could be an area for improvement.
					
						
					}
					
					
					
					// If the previous item was an operator
						
					else if (previousItem.equals("operator")) {
						
						// As there cannot be two operators in a row, print an error message (syntax error)
						
						txt.setText("Syntax error");
						
						// Break out of the while loop
						
						break;
						
					}
					
					
					
					
					else {
						
						// The number before the operator index indicates the final position of the number. Therefore, set the finalNumberIndex
						
						finalNumberIndex = i - 1;
						
						
						
						
						// Convert the user input in an array into a string
						
						// Create a string builder object
						
						StringBuilder sb = new StringBuilder();
						
						// Set the starting index of the number
						
						int a = firstNumberIndex;
						
						// Convert the array list to an array
						
						String[] array = calculations.toArray(new String[0]);
						
						// Create a for loop to add the entire number to the string
						
						for (a = firstNumberIndex; a < finalNumberIndex + 1; a++) {
							
							// If there is an operator, stop the building of the string
							
							if ((array[a].equals("+") || array [a].equals("-") || array[a].equals("x") )) {
							
								break;
							
							}
							
							// Add the number to the string
							
							sb.append(array[a]);
							
						}
						
						// Convert the object into a string

						String singleString = sb.toString();
						
						
						
						// Increment the counter by 1 as a number has been created
						
						counter++;
						
						
						// If the counter is 1 (this is the first number)
						
						if (counter == 1) {
							
							// Store the string in the string variable num1
							
							num1 = singleString;
							
							// Cast the string to a double and store in the variable number1 to perform the calculation
							
							number1 = Double.parseDouble(num1);
							
						}
						
						
						// If the counter is 2 (this is the second number)
						
						if (counter == 2) {
							
							// Store the string in the string variable num2
							
							num2 = singleString;
							
							// Cast the string to a double and store in the variable number2 to perform the calculation
							
							number2 = Double.parseDouble(num2);
							
							double answer = 0;
							
							
							// If the operator is a plus
							
							if (calculations.get(operatorPositon).equals("+")) {
									
								// Add the two numbers and store the answer in the variable result
									
								answer = ((number1 / 100) * number2) + number1;
								
							}
							
							// If the operator is a minus
								
							if (calculations.get(operatorPositon).equals("-")) {
								
								// Subtract the number2 from number1 and store the answer in the variable result
									
								answer = ((number1 / 100) * number2) - number1;
								answer = Math.abs(answer);
								
							}
							
							// If the operator is a multiplication sign
								
							if (calculations.get(operatorPositon).equals("x")) {
								
								// Multiply the two number and store the answer in the variable result
									
								answer = ((number1 / 100) * number2);
									
							}
							

							
							
							
							// Display the current text in the text field and the result
							
							
							txt.setText(txt.getText()+ answer + "");
								
								
						}
							
					}
	
				}
				
			}
		
		}
			
		

	// Create main method
	
	public static void main (String args[]) {

		// Run the GUI
		
		new CalculatorV24 ();
		
	}
	
	// Overide of the action performed method

	@Override
	public void actionPerformed(ActionEvent ae) {
		
	}

}

