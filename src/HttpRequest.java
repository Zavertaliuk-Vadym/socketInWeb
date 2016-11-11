import java.util.Map;

class HttpRequest {
    private final String param;

    private final Map<String, String> getPath;

    public HttpRequest(String param, Map<String, String> getPath) {
        this.param = param;
        this.getPath = getPath;
    }

//        String name;

    //            return name;

//    public void getParameters(String parameters) {

    //    static String getParam(String parameters) {
//        int index = parameters.indexOf("=");
//        index += 1;
//        String result = parameters.substring(index);
//        return result.isEmpty() ? " world!" : ", " + result + "=)";
//    }
    public String getPath(){
        System.out.println("param="+param);
//        return param.substring(1,param.indexOf(param,1)+1);
        return param;
    }


    //    }
//
//        return "world!";
//        }
//            }
//                e.printStackTrace();
//            } catch (UnsupportedEncodingException e) {
//                name = URLDecoder.decode(name, "UTF-8");
//            try {
//            name = getParam(parameters).replace("+", " ");
//        if (parameters.contains("name")) {
//    static String getPath(String parameters) {




    public String getParam() {
        return param;
    }



//    }
}
