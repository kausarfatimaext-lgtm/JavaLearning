// Product
public interface XMLParser{
    public String parse();
}

// Concrete Product
public static class ErrorXMLParser implements XMLParser{
    @Override
    public String parse(){
        System.out.println("Parsing error XML...");
        return "Error XML Message";
    }
}

// Concrete Product
public static class FeedbackXML implements XMLParser{
    @Override
    public String parse(){
        System.out.println("Parsing feedback XML...");
        return "Feedback XML Message";
    }
}

// Concrete Product
public static class OrderXML implements XMLParser{
    @Override
    public String parse(){
        System.out.println("Parsing order XML...");
        return "Order XML Message";
    }
}

// Concrete Product
public static class ResponseXML implements XMLParser{
    @Override
    public String parse(){
        System.out.println("Parsing response XML...");
        return "Response XML Message";
    }
}

// Creator
public static abstract class DisplayService{
    public void display(){
        XMLParser parser = getParser();
        String msg = parser.parse();
        System.out.println(msg);
    }
    protected abstract XMLParser getParser();
}

// Concrete Creator
public static class ErrorXMLDisplayService extends DisplayService{
    private static ErrorXMLDisplayService instance = null;
    private ErrorXMLDisplayService(){}
    public static ErrorXMLDisplayService getInstance(){
        if(instance == null){
            instance = new ErrorXMLDisplayService();
            return instance;
        }
        System.out.println("Instance already exist");
        return instance;
    }
    @Override
    public XMLParser getParser(){
        return new ErrorXMLParser();
    }
}

// Concrete Creator
public static class FeedbackXMLDisplayService extends DisplayService{
    private static FeedbackXMLDisplayService instance = null;
    private FeedbackXMLDisplayService(){}
    public static FeedbackXMLDisplayService getInstance(){
        if(instance == null){
            instance = new FeedbackXMLDisplayService();
            return instance;
        }
        System.out.println("Instance already exist");
        return null;
    }
    @Override
    public XMLParser getParser(){
        return new FeedbackXML();
    }
}

// Concrete Creator
public static class OrderXMLDisplayService extends DisplayService{
    private static OrderXMLDisplayService instance = null;
    private OrderXMLDisplayService(){}
    public static OrderXMLDisplayService getInstance(){
        if(instance == null){
            instance = new OrderXMLDisplayService();
            return instance;
        }
        System.out.println("Instance already exist");
        return instance;
    }
    @Override
    public XMLParser getParser(){
        return new OrderXML();
    }
}

// Concrete Creator
public static class ResponseXMLDisplayService extends DisplayService{
    private static ResponseXMLDisplayService instance = null;
    private ResponseXMLDisplayService(){}
    public static ResponseXMLDisplayService getInstance(){
        if(instance == null){
            instance = new ResponseXMLDisplayService();
            return instance;
        }
        System.out.println("Instance already exist");
        return null;
    }
    @Override
    public XMLParser getParser(){
        return new ResponseXML();
    }
}
void main() {
    DisplayService service = FeedbackXMLDisplayService.getInstance();
    service.display();

    service = ErrorXMLDisplayService.getInstance();
    service.display();
    service = ErrorXMLDisplayService.getInstance();
    service.display();

    service = OrderXMLDisplayService.getInstance();
    service.display();

    service = ResponseXMLDisplayService.getInstance();
    service.display();
}