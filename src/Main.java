import java.util.Scanner;

public class Main {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    // CSV file header
    private static final String FILE_HEADER = "id,code,name";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        int choice;
        do {
            System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ----");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Tìm sản phẩm có giá đắt nhất");
            System.out.println("7. Đọc từ file");
            System.out.println("8. Ghi vào file");
            System.out.println("9. Thoát");
            System.out.println("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productManager.displayProduct();
                    break;
                case 2:
                    productManager.addProduct(scanner);
                    break;
                case 3:
                    productManager.editProduct(scanner);
                    break;
                case 4:
                    productManager.productRemove(scanner);
                    break;
                case 5:
                    int choice1;
                    System.out.println("1. Sắp xếp tăng dần");
                    System.out.println("2. Sắp xếp giảm dần");
                    choice1 = Integer.parseInt(scanner.nextLine());
                    switch (choice1) {
                        case 1:
                            productManager.sortByIncreasePrice();
                            break;
                        case 2:
                            productManager.sortByDecreasePrice();
                            break;
                    }
                    break;
                case 6:
                    productManager.searchMaxPrice();
                    break;
                case 7:
//                    productManager.readFileCSV();
                    break;
                case 8:
//                    productManager.writeFileCSV("data/products.csv");
                    break;
                case 9:
                    System.exit(0);
                    break;
            }
        } while (choice != 0);
    }
}
