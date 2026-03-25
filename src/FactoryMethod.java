// Product
public interface XMLParser{
    public String parse();
}

// Concrete Product
public class ErrorXMLParser implements XMLParser{
    @Override
    public String parse(){
        System.out.println("Parsing error XML...");
        return "Error XML Message";
    }
}

// Concrete Product
public class FeedbackXML implements XMLParser{
    @Override
    public String parse(){
        System.out.println("Parsing feedback XML...");
        return "Feedback XML Message";
    }
}

// Concrete Product
public class OrderXML implements XMLParser{
    @Override
    public String parse(){
        System.out.println("Parsing order XML...");
        return "Order XML Message";
    }
}

// Concrete Product
public class ResponseXML implements XMLParser{
    @Override
    public String parse(){
        System.out.println("Parsing response XML...");
        return "Response XML Message";
    }
}

// Creator
public abstract class DisplayService{
    public void display(){
        XMLParser parser = getParser();
        String msg = parser.parse();
        System.out.println(msg);
    }
    protected abstract XMLParser getParser();
}

// Concrete Creator
public class ErrorXMLDisplayService extends DisplayService{
    @Override
    public XMLParser getParser(){
        return new ErrorXMLParser();
    }
}

// Concrete Creator
public class FeedbackXMLDisplayService extends DisplayService{
    @Override
    public XMLParser getParser(){
        return new FeedbackXML();
    }
}

// Concrete Creator
public class OrderXMLDisplayService extends DisplayService{
    @Override
    public XMLParser getParser(){
        return new OrderXML();
    }
}

// Concrete Creator
public class ResponseXMLDisplayService extends DisplayService{
    @Override
    public XMLParser getParser(){
        return new ResponseXML();
    }
}
void main() {
    DisplayService service = new FeedbackXMLDisplayService();
    service.display();

    service = new ErrorXMLDisplayService();
    service.display();

    service = new OrderXMLDisplayService();
    service.display();

    service = new ResponseXMLDisplayService();
    service.display();
}