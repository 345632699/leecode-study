public class danli {
    private  static final danli instance = new danli();
    private String name;
    public Integer age;

    private danli() {
        this.name = "danli";
        this.age = 222;
    }

    public static danli getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        danli instance = danli.getInstance();
        System.out.println( instance.name);
    }
}
