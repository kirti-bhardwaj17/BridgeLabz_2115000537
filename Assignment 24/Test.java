class LegacyAPI {
    @Deprecated
    void oldFeature() {
        System.out.println("This is an old feature.");
    }

    void newFeature() {
        System.out.println("This is a new feature.");
    }
}

public class Test {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();
        api.newFeature();
    }
}
