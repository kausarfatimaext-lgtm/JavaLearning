void main() {
    printInformation("Hello World");
    printInformation("");
    printInformation("\t \n");

    String helloWorld = "My Hello World";
    System.out.printf("index of r = %d %n", helloWorld.indexOf('r'));
    System.out.printf("index of World = %d %n", helloWorld.indexOf("World"));

    System.out.printf("index of l = %d %n", helloWorld.indexOf('l'));
    System.out.printf("index of l = %d %n", helloWorld.lastIndexOf('l'));

    System.out.printf("index of l = %d %n", helloWorld.indexOf('l', 3));
    System.out.printf("index of l = %d %n", helloWorld.lastIndexOf('l', 8));

    String helloWorldLower = helloWorld.toLowerCase();
    if(helloWorld.equals(helloWorldLower)){
        System.out.println("Values match exactly");
    }
    if(helloWorld.equalsIgnoreCase(helloWorldLower)){
        System.out.println("Values match ignoring case");
    }

    if(helloWorld.startsWith("Hello")){
        System.out.println("String starts with Hello");
    }
    if(helloWorld.endsWith("World")){
        System.out.println("String ends with World");
    }
    if(helloWorld.contains("World")){
        System.out.println("String contains World");
    }
    if(helloWorld.contentEquals("Hello World")){
        System.out.println("Values match exactly");
    }

    // String Manipulation methods
    String birthDate = "25/11/1982";
    int startingIndex = birthDate.indexOf("1982");
    System.out.println("startingIndex = " + startingIndex);
    System.out.println("Birth year = " + birthDate.substring(startingIndex));

    System.out.println("Month = " + birthDate.substring(3, 5));
    String newDate = String.join("/", "15", "09", "2002");
    System.out.println("newDate = " + newDate);

    newDate = "15".concat("/").concat("11").concat("/").concat("2002");
    System.out.println(newDate.replace('/', '-'));

    System.out.println("XYZ\n".repeat(3).indent(8));
    System.out.println("-".repeat(25));
    System.out.println("      ABC\n".repeat(3).indent(-2) );

    // StringBuilder
    String string = "Hello" + "World";
    string.concat(" of coding");

    StringBuilder stringBuilder = new StringBuilder("Hello" + "World");
    stringBuilder.append(" of coding");

    System.out.println("String output " + string);
    System.out.println("StringBuilder output " + stringBuilder);

    StringBuilder emptyStart = new StringBuilder();
    emptyStart.append("x".repeat(47));

    StringBuilder emptyStart32 = new StringBuilder(32);
    emptyStart32.append("Y".repeat(17));

    printStringBuilder(emptyStart);
    printStringBuilder(emptyStart32);

    stringBuilder.deleteCharAt(11).insert(11, 'O');
    System.out.println(stringBuilder);

    stringBuilder.replace(14, 15, "C");
    System.out.println(stringBuilder);

    stringBuilder.reverse().setLength(7);
    System.out.println(stringBuilder);
}
public static void printInformation(String string){
    int length = string.length();
    System.out.println("Length = " + length);

    if(string.isEmpty()){
        System.out.println("String is Empty");
        return;
    }

    if(string.isBlank()){
        System.out.println("String is Empty");
    }
    System.out.printf("First char = %c %n", string.charAt(0));

    System.out.printf("Last char = %c %n", string.charAt(length - 1));
}

public static void printStringBuilder(StringBuilder str){
    System.out.println("StringBuilder content: " + str);
    System.out.println("StringBuilder length: " + str.length());
    System.out.println("StringBuilder capacity: " + str.capacity());
}