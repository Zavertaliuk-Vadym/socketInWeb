import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;


class HttpRequestImpl implements HttpRequest {
    private final String fullPath = "";

//    static String getParam(String parameters) {
//        int index = parameters.indexOf("=");
//        index += 1;
//        String result = parameters.substring(index);
//        return result.isEmpty() ? " world!" : ", " + result + "=)";
//    }
    String getPath(){
        return fullPath.substring(1,fullPath.indexOf(fullPath,1)+1);
    }

//    static String getPath(String parameters) {
//        String name;
//        if (parameters.contains("name")) {
//            name = getParam(parameters).replace("+", " ");
//            try {
//                name = URLDecoder.decode(name, "UTF-8");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//            return name;
//        }
//        return "world!";
//    }

    Map<String, String> getPath(String query) throws UnsupportedEncodingException {
        Map<String, String> query_pairs = new LinkedHashMap<>();
        String[] pairs = query.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
        }
        return query_pairs;
    }

    @Override
    public void getVariant(String parameters) {

    }
}
