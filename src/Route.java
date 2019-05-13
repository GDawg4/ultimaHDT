public class Route {
    private String source;
    private String destination;
    private Integer length;

    public Route(String source, String destination, Integer length){
        this.source = source;
        this.destination = destination;
        this.length = length;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public Integer getLength() {
        return length;
    }
}
