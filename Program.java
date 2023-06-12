class Program {
    static Product[] products = new Product[1];
    public static void main(String[] args) {

        String[] beverages = {"juice","tea","coca-cola","water","cofee"};

        for (int i = 0; i < 10; i++) {
            int random_drink = (int) (Math.random() * beverages.length); 
            ProductsImpl.addProduct(new Product(i,beverages[random_drink]));
        }

        ProductsImpl.deleteProduct(5);

        for (int i = 0; i < products.length; i++) {
            System.out.printf("[%d] %s \n",products[i].id, products[i].name);
        }

        Integer[] FindByName =  ProductsImpl.FindByName("tea");
        for (int i = 0; i < FindByName.length; i++) {
            System.out.printf("%d ",FindByName[i]);
        }
        System.out.println();

        System.out.println("Program Done");
    
    
    }

public static class Product {
    Integer id;
    String name;
    
    
    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}



public static class ProductsImpl {
    public static boolean addProduct(Product product) {
        if (product.id == 0) return false;

        if (products[0] == null ) {
            products[0] = product;
            return true; 
        }

        for (int i = 0; i < products.length; i++) {
            if (products[i].id == product.id) {
                return false;
            }
        }

        Product[] newproducts = new Product[products.length + 1];

        for (int i = 0; i < products.length; i++) {
            newproducts[i] = products[i]; 
        }
        newproducts[newproducts.length - 1] = product;
        products = newproducts;

        return true;
        // return false;
    }

    public static boolean deleteProduct(Integer id) {
        int idToRemove = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i].id == id) {
                idToRemove = id;
                break;
            }
        }

        if (idToRemove == 0) return false;

        Product[] newproducts = new Product[products.length - 1];

        for (int i = 0, j = 0; i < products.length; i++) {
            if (products[i].id != idToRemove) {
            newproducts[j++] = products[i];
            } 
        }
        products = newproducts;
        return true;
        

    }

    public static String getName(Integer id) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].id == id) return products[i].name;
            }
            return "Product not found";
        }

    public static Integer[] FindByName(String name) {

        int count = 0;

        for (int i = 0; i < products.length; i++) {
            if (products[i].name == name) count++;
        }

        Integer [] ListIds = new Integer[count];

        for (int i = 0, j = 0; i < products.length; i++) {
            if (products[i].name == name) {
                ListIds[j++] = products[i].id;
            }
        }

        return ListIds;
    }
        
    } 




}