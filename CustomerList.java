import java.util.ArrayList;

/** Container class so the ArrayList can be saved and loaded without a generics warning. */
public class CustomerList extends ArrayList<Customer> {
    private static final long serialVersionUID = 1L;
}
