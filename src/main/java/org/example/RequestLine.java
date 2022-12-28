package org.example;

import java.util.Objects;

/**
 * author :  sanghoonkim
 * date : 2022/12/28
 */
public class RequestLine {

    private final String method;    // GET
    private final String urlPath;   // /calculate?operand1=11&operator=*&operand2=55
    private final QueryStrings queryStrings;

    /**
     * GET /calculate?operand1=11&operator=*&operand2=55 HTTP/1.1
     */
    public RequestLine(String requestLine) {
        String[] tokens = requestLine.split(" ");
        this.method = tokens[0];
        String[] urlPathTokens = tokens[1].split("\\?");
        this.urlPath = urlPathTokens[0];

        if (urlPathTokens.length == 2) {
            this.queryStrings = new QueryStrings(urlPathTokens[1]);
        } else {
            this.queryStrings = new QueryStrings();
        }

    }

    public RequestLine(String method, String urlPath, String queryString) {
        this.method = method;
        this.urlPath = urlPath;
        this.queryStrings = new QueryStrings(queryString);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestLine that = (RequestLine) o;

        if (!Objects.equals(method, that.method)) return false;
        if (!Objects.equals(urlPath, that.urlPath)) return false;
        return Objects.equals(queryStrings, that.queryStrings);
    }

    @Override
    public int hashCode() {
        int result = method != null ? method.hashCode() : 0;
        result = 31 * result + (urlPath != null ? urlPath.hashCode() : 0);
        result = 31 * result + (queryStrings != null ? queryStrings.hashCode() : 0);
        return result;
    }

    public boolean isGetRequest() {
        return "GET".equals(this.method);
    }

    public boolean matchPath(String requestPath) {
        return urlPath.equals(requestPath);
    }

    public QueryStrings getQueryStrings() {
        return this.queryStrings;
    }
}
