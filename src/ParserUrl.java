import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class ParserUrl {
    static String parseUrl(String parameters) {
        String name;
        if (Handler.isContains(parameters, "name")) {
            name = ParserName.parseName(parameters).replace("+", " ");
            try {
                name = URLDecoder.decode(name, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return name;
        }
        return "world!";
    }
}