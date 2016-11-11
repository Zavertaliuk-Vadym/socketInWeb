import java.io.*;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by employee on 11/10/16.
 */
class ParserImpl implements Parser {
    @Override
    public HttpRequest parse(InputStream stream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        try {
            String parameters = reader.readLine().split(" ")[1];
            return new HttpRequest(getPath(parameters), getParameters(parameters));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getPath(String parameters) {
        int par = parameters.lastIndexOf("?");
        par+=1;
        return parameters.substring(0,par==0?parameters.length():par);
    }


    Map<String, String> getParameters(String query) throws UnsupportedEncodingException {
        String string = query.substring(query.indexOf("?")+1);
        Map<String, String> query_pairs = new LinkedHashMap<>();
        String[] pairs = string.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"),
                    URLDecoder.decode(pair.substring(idx + 1),
                            "UTF-8"));
        }
        System.out.println("query_pairs"+query_pairs);
        return query_pairs;
    }


}

