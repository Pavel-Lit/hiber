import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name ="name")
    private String name;


    @OneToMany(mappedBy = "category_id")
    private List<Product> productList;

    public Category() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
// для вставки записи в таблицу
    public Category(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String allProduct = "";
        for (Product p: productList) {
            allProduct+=p.getName()+", ";
        }
        return "Category{" +
                "id=" + id +
                ", name='" + name + ": " +allProduct+
                '}';
    }
}
