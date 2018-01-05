package com.uptake.pages;

public class MyEnums {
	public enum TEXT {
		TEXT1("Text1"), TEXT2("Text2"), TEXT3("Text3"), TEXT4("Text4"),
		TEXT5("Text5"), TEXT6("Text6"), TEXT7("Text7"), TEXT8("Text8"),
		SCROLLUP("Scroll_Up"), SCROLLDOWN("Scroll_Down");
		private final String toString;
	    private TEXT(String toString) {
	         this.toString = toString;
	    }
	    @Override
		public String toString(){
	         return toString;
	    }
	}
}
