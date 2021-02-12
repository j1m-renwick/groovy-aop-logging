package example.micronaut

class Data {

    String text
    Data[] nestedData

    Data(String text) {
        this.text = text
    }


    @Override
    public String toString() {
        return "Data{" +
                "text='" + text +
                '}';
    }
}
