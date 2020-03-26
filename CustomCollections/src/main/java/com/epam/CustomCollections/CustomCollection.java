package com.epam.CustomCollections;
import java.util.*;

public class CustomCollection {
	
		private Object[] objectArray=new Object[100];
		
		private int noOfElements=0; 
		
		private void add(Object obj)
		{
			if(noOfElements==objectArray.length)
			{
				int newCapacity=objectArray.length*2;
				Object[] nextArray=new Object[newCapacity];
				for(int i=0;i<objectArray.length;i++)
				{
					nextArray[i]=objectArray[i];
				} 
				objectArray=nextArray;
			}
			objectArray[noOfElements]=obj;
			noOfElements++;
		}
		
		public int capacity()
		{
			return objectArray.length;
		}
		
		public int size()
		{
			return noOfElements;
		}
		
		public Object get(int index)
		{
			if(index<0||index>=size())
			{
				System.out.println("IndexOutOfBound Exception");
			}
			System.out.println("elemennt of index: "+index);
			System.out.println(objectArray[index]);
			return objectArray[index];
		}
		
		public void replace(int index,Object obj)
		{
			if(index<0||index>=size())
			{
				System.out.println("IndexOutOfBound Exception");
			}
			objectArray[index]=obj;
		}
		
		public void remove(int index)
		
		{
			
			if(index<0||index>=size())
			{
				System.out.println("IndexOutOfBound Exception");
			}
			while(index<size()-1)
			{
				objectArray[index]=objectArray[index+1];
				index++;
			}
			objectArray[index]=null;
			noOfElements--;
		}
		
		public void insert(int index,Object obj)
		{
			
			if(index<0||index>=size())
			{
				System.out.println("IndexOutOfBound Exception");
			}
			if(size()==capacity())
			{
				int newCapacity=objectArray.length*2;
				Object[] nextArray=new Object[newCapacity];
				for(int i=0;i<objectArray.length;i++)
				{
					nextArray[i]=objectArray[i];
				}
				objectArray=nextArray;
			}
			for(int i=size()-1;i>=index;i--)
			{
				objectArray[i++]=objectArray[i];
			}
			objectArray[index]=obj;
			noOfElements++;
		}
		
		public void display(Object obj)
		{	
			System.out.println("Elements in the list");
			for(int i=0;i<size();i++)
			{
				System.out.println(objectArray[i]);
			}
		}
		
		public static void main(String args[])
		{
	 		CustomCollection c=new CustomCollection();
	 		Scanner sc = new Scanner(System.in);
	 		
	 		c.add(45);
	 		c.add(89);
	 		c.add(75);
	 		c.add(26);
	 		c.add(39);
	 		c.add(62);
	 		c.add(15);
	 		c.add(53);
	 		c.add(91);
	 		c.add(107);
	 		c.add(112);
	 		
	 		System.out.println("To DISPLAY the list, Enter 1\n"
	 				+ "To REMOVE an element from the list, Enter 2\nTo INSERT at a specific index, Enter 3\n"
	 				+ "To REPLACE an element, Enter 4");
	 		int ch =sc.nextInt();

	 		
			switch(ch) {
			
			case 1: System.out.println("Displaying the elements of the list : ");
					c.display(c);
					break;
			case 2: System.out.println("Enter the index of element you want to remove : ");
					int index = sc.nextInt();
					c.remove(index);
					c.display(c);
					break;
			case 3: System.out.println("Enter the index of element and it's value to insert: ");
					int ind = sc.nextInt();
					int ele = sc.nextInt();
					c.insert(ind, ele);
					c.display(c);
					break;
			case 4: System.out.println("Enter the index and the element to replace the original value: ");
					int in = sc.nextInt();
					int element = sc.nextInt();
					c.replace(in, element);
					c.display(c);
					break;
			}
			sc.close();
		}		
				
	}


