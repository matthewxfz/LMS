package edu.lms.util;

import java.util.HashMap;
import java.util.Stack;

public class Condition {
	public Stack<String> computingStack = new Stack<String>();
	public Stack<String> helpStack = new Stack<String>();
	
	public Condition(String conditin){}
	
	public boolean isSatisfied(String[] tuple, HashMap<String, Integer> schema){return true;}
	
}
