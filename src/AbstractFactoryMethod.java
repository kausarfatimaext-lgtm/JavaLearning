// Product
public interface XMLParser{
    public String parse();
}

// Concrete Product
public static class NYErrorXMLParser implements XMLParser{
    @Override
    public String parse(){
        System.out.println("NY Parsing error XML...");
        return "NY Error XML Message";
    }
}

// Concrete Product
public static class NYFeedbackXMLParser implements XMLParser{
    @Override
    public String parse(){
        System.out.println("NY Parsing feedback XML...");
        return "NY Feedback XML Message";
    }
}

// Concrete Product
public static class NYOrderXMLParser implements XMLParser{
    @Override
    public String parse(){
        System.out.println("NY Parsing order XML...");
        return "NY Order XML Message";
    }
}

// Concrete Product
public static class NYResponseXMLParser implements XMLParser{
    @Override
    public String parse(){
        System.out.println("NY Parsing response XML...");
        return "NY Response XML Message";
    }
}

// Concrete Product
public static class TWErrorXMLParser implements XMLParser{
    @Override
    public String parse(){
        System.out.println("TW Parsing error XML...");
        return "TW Error XML Message";
    }
}

// Concrete Product
public static class TWFeedbackXMLParser implements XMLParser{
    @Override
    public String parse(){
        System.out.println("TW Parsing feedback XML...");
        return "TW Feedback XML Message";
    }
}

// Concrete Product
public static class TWOrderXMLParser implements XMLParser{
    @Override
    public String parse(){
        System.out.println("TW Parsing order XML...");
        return "TW Order XML Message";
    }
}

// Concrete Product
public static class TWResponseXMLParser implements XMLParser{
    @Override
    public String parse(){
        System.out.println("TW Parsing response XML...");
        return "TW Response XML Message";
    }
}

// Abstract Factory
public interface AbstractParseFactory{
    public XMLParser getParserInstance(String parseType);
}

// Concrete Factory
public static class NYParseFactory implements AbstractParseFactory{
    private static NYParseFactory instance = null;
    private NYParseFactory(){}
    public static NYParseFactory getInstance(){
        if(instance == null){
            instance = new NYParseFactory();
            return instance;
        }
        System.out.println("Instance already exist");
        return instance;
    }
    @Override
    public XMLParser getParserInstance(String parseType) {
        switch (parseType){
            case "NYERROR": return new NYErrorXMLParser();
            case "NYFEEDBACK": return new NYFeedbackXMLParser();
            case "NYRESPONSE": return new NYResponseXMLParser();
            case "NYORDER": return new NYOrderXMLParser();
        }
        return null;
    }
}

// Concrete Factory
public static class TWParseFactory implements AbstractParseFactory{
    private static TWParseFactory instance = null;
    private TWParseFactory(){}
    public static TWParseFactory getInstance(){
        if(instance == null){
            instance = new TWParseFactory();
            return instance;
        }
        System.out.println("Instance already exist");
        return instance;
    }
    @Override
    public XMLParser getParserInstance(String parseType) {
        switch (parseType){
            case "TWERROR": return new TWErrorXMLParser();
            case "TWFEEDBACK": return new TWFeedbackXMLParser();
            case "TWRESPONSE": return new TWResponseXMLParser();
            case "TWORDER": return new TWOrderXMLParser();
        }
        return null;
    }
}

// Helper
public static final class ParserFactoryProducer{
    private ParserFactoryProducer(){
        throw new AssertionError();
    }
    public static AbstractParseFactory getFactory(String factoryType){
        switch (factoryType){
            case "NYFactory": return NYParseFactory.getInstance();
            case "TWFactory": return TWParseFactory.getInstance();
        }
        return null;
    }
}
void main() {
   AbstractParseFactory parseFactory = ParserFactoryProducer.getFactory("NYFactory");
   String msg = "";

   XMLParser parser = parseFactory.getParserInstance("NYORDER");
   msg = parser.parse();
   System.out.println(msg);

   System.out.println("********************************************");

   parseFactory = ParserFactoryProducer.getFactory("TWFactory");
   msg = parser.parse();
   System.out.println(msg);
}