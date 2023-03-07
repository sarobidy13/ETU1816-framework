package fonction;

public class Utils {

    public String getURL(String url) {
        String[] methode = url.split("/");
        String method = methode[methode.length - 1];
        return method;

    }

}