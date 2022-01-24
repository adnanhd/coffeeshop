import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


class Ingredient {
    String name;
    Integer quantity;

    Ingredient(String name, Integer quantity) { this.name = name; this.quantity = quantity; }
}

class Coffee {
    String name;
    Integer price;
    List<Ingredient> ingredients;

    Coffee(String name, Integer price) {
        this.name = name;
        this.price = price;
        this.ingredients = new LinkedList<>();
    }

    Coffee(String name, Integer price, List<Ingredient> ingredients) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }

    Coffee add_ingredient(Ingredient ingredient) { this.ingredients.add(ingredient); return this; }

}

public class CoffeeShop {
    static String sorgu = "Lütfen içmek istediğiniz kahvenin numarasını giriniz";
    static String[] numbers = new String[] {"Sıfır", "Bir", "İki", "Üç", "Dört",
                                             "Beş", "Altı", "Yedi", "Sekiz", "Dokuz"};
    static List<Coffee> coffees = new LinkedList<>();
    public static void main(String[] args) {
        // initializing a scanner for reading integers from user
        Scanner scan = new Scanner(System.in);

        // initializing names and prices of coffees
        Coffee Espresso = new Coffee("Espresso", 7);
        Coffee DoubleEspresso = new Coffee("Double Espresso", 12);
        Coffee Americano = new Coffee("Americano", 10);
        Coffee Cappuccino = new Coffee("Cappuccino", 12);
        Coffee Latte = new Coffee("Caffe Latte", 12);
        Coffee Mocha = new Coffee("Mocha", 13);
        Coffee HotWater = new Coffee("Hot Water", 3);

        // preparing them for service
        coffees.add(Espresso
                .add_ingredient(new Ingredient("Espresso", 1)));

        coffees.add(DoubleEspresso
                .add_ingredient(new Ingredient("Espresso", 2)));

        coffees.add(Americano
                .add_ingredient(new Ingredient("Espresso", 1))
                .add_ingredient(new Ingredient("Hot Water", 4)));

        coffees.add(Cappuccino
                .add_ingredient(new Ingredient("Espresso", 1))
                .add_ingredient(new Ingredient("Steamed Milk", 2))
                .add_ingredient(new Ingredient("Hot Water", 2)));

        coffees.add(Latte
                .add_ingredient(new Ingredient("Espresso", 1))
                .add_ingredient(new Ingredient("Steamed Milk", 3))
                .add_ingredient(new Ingredient("Milk Foam", 1)));

        coffees.add(Mocha
                .add_ingredient(new Ingredient("Espresso", 1))
                .add_ingredient(new Ingredient("Steamed Milk", 1))
                .add_ingredient(new Ingredient("Milk Foam", 1))
                .add_ingredient(new Ingredient("Hot Chocolate", 2)));

        coffees.add(HotWater
                .add_ingredient(new Ingredient("Hot Water", 5)));

        /** adim 1
         * Kullanıcı önceden belirlenmiş kahve türlerinin ve ücretlerinin listesini konsol çıktısı
         * olarak alabilmelidir. "Lütfen içmek istediğiniz kahvenin numarasını giriniz" mesajı ile
         * kullanıcıdan kahve numarası girişi alınmalıdır.
         */

        System.out.println("Secim\tFiyat\tKahve");
        for(int i = 0; i < coffees.size(); i++)
            System.out.println(i + ")\t\t" + coffees.get(i).price + " TL\t" + coffees.get(i).name);

        int num;
        do {
            System.out.println(sorgu);
            num = scan.nextInt();

        } while (num < 0 || coffees.size() <= num);

        /** adim 2
         * Kullanıcı önceden belirlenmiş kahve türlerinden birini seçtikten sonra "Teşekkürler kahveniz
         * hazırlanıyor." mesajı ile 3. adıma geçilmelidir.
         */

        System.out.println("Teşekkürler kahveniz hazırlanıyor...");

        /** adim 3
         * Alınan sipariş aşağıdaki listedeki tariflere göre hazırlanmalı ve sipariş bilgisi (üretilen
         * kahve, tüketilen hammadde bilgisi ve miktar) kullanıcıya konsol çıktısı olarak geri bildirilmelidir.
         * Örneğin: "Americano seçtiniz. Bu içeceğimiz dört doz sıcak su ve bir doz espresso içermektedir.
         * Afiyet Olsun."
         */

        Coffee coffee = coffees.get(num);
        System.out.print(coffee.name + " seçtiniz.\nBu içeceğimiz ");
        for(int i = 0; i < coffee.ingredients.size(); i++) {
            System.out.print(numbers[coffee.ingredients.get(i).quantity] + " doz " + coffee.ingredients.get(i).name);
            if (i + 2 == coffee.ingredients.size())
                System.out.print(" ve ");
            else if (i + 1 != coffee.ingredients.size())
                System.out.print(", ");
        }
        System.out.println(" içermektedir.\nAfiyet olsun :)");

    }
}

