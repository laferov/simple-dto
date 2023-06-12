class Program {
    static Product[] products = new Product[1];
    public static void main(String[] args) {

        String[] beverages = {"water","juice","tea","cofee","coca-cola","beer"};

        // Заполнение массива products случайными напитками
        for (int i = 0; i < 20; i++) {
            int random_drink = (int) (Math.random() * beverages.length); 
            ProductsImpl.addProduct(new Product(i,beverages[random_drink]));
        }


        // Удаление напитка beer из массива
        Integer[] beverages_to_delete =  ProductsImpl.FindByName("beer");

        for (int i = 0; i < beverages_to_delete.length; i++) {
            ProductsImpl.deleteProduct(beverages_to_delete[i]);
        }

        // Вывод массива products

        for (int i = 0; i < products.length; i++) {
            System.out.printf("[%d] %s \n",products[i].id, products[i].name);
        }
        
    
    }
// класс product, id - уникальный идентификатор, name - название 
public static class Product {
    Integer id;
    String name;
    
    
    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}



public static class ProductsImpl {
    // добавление продукта в массив products
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
    // удаление продукта по id
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

    // Получение названия продукта по id
    public static String getName(Integer id) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].id == id) return products[i].name;
            }
            return "Product not found";
        }
    // поиск id продуктов по названию
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