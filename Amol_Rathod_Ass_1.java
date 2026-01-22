import javax.swing.plaf.synth.SynthStyle;

import org.w3c.dom.Text;

class Book{
    private String title;
    private String author;
    private String isbn;
    private double price;
    private int stockLevel;

    public Book(String title, String author, double price, String isbn, int stockLevel){
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
        this.stockLevel = stockLevel;
    }

    public void displayInfo(){
        System.out.println("-----------------");
        System.out.println("Title : " + title);
        System.out.println("Author : " + author);
        System.out.printf("Price : $%.2f%n",price);
        System.out.println("ISBN : "+isbn);
        System.out.println("Stock Level : " + stockLevel);
        System.out.println("-----------------");
    }

    public void applyDiscount(double percentage){
        if(percentage > 0 && percentage <= 100){
            double discountAmount = price * (percentage/100);
            price = price - discountAmount;
            System.out.println(">>Applied a" + percentage + "%discount.");
            System.out.printf("New Price : ",price);
        }else{
            System.out.println(">> Error:Invalid discount percentage.");
        }
    }

    public void restock(int newCopies){
        if(newCopies > 0){
            stockLevel = stockLevel + newCopies;
            System.out.println(">> Restocked " + newCopies + " copies");
            System.out.println(">> New Stock Level : "+stockLevel);
        }else{
            System.out.println(">>Error : Cannot restock negative or zero copies");
        }
    }

    public boolean isAvailable(){
        if(stockLevel > 0){
            System.out.println(">>Status : In Stock (Available for purchase)");
            return true;
        }else{
            System.out.println(">>Status:Out of Stock");
            return false;
        }
    }
}

class BookstoreSystem{
    public static void main(String[] args){
        System.out.println("==================");
        Book novel = new Book("The Greate Gatsby","F.Scott Fitzgerald",15.00,"978-0743256546521654",10);
        novel.displayInfo();
        novel.applyDiscount(20);
        novel.displayInfo();
        System.out.println("\n");

        Book Textbook = new Book("Pathyapustak","Pune Shiksahan Mandal", 45, "741-258963", 5);
        Textbook.displayInfo();
        Textbook.applyDiscount(15);
        Textbook.displayInfo();
        Textbook.isAvailable();
        Textbook.restock(5);
    }
}