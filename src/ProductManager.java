import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    ArrayList<Product> arrayListProduct = new ArrayList<>();

    public Product createProduct(Scanner scanner) {
        System.out.println("Nhập mã sản phẩm: ");
        String productCode = scanner.nextLine();
        System.out.println("Nhập tên sản phẩm: ");
        String productName = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        int productPrice = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số lượng sản phẩm: ");
        int productAmount = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập mô tả sản phẩm: ");
        String productDescribe = scanner.nextLine();
        return new Product(productCode, productName, productPrice, productAmount, productDescribe);
    }

    public void addProduct(Scanner scanner) {
        Product product = createProduct(scanner);
        arrayListProduct.add(product);
    }

    public void displayProduct() {
        for (Product a : arrayListProduct) {
            System.out.println(a);
        }
    }

    public void editProduct(Scanner scanner) {
        System.out.println("Nhập vào mã sản phẩm cần sửa");
        String code = scanner.nextLine();
        for (Product a : arrayListProduct) {
            if (a.getProductCode().equals(code)) {
                System.out.println("Nhập mã sản phẩm muốn sửa: ");
                String productCode = scanner.nextLine();
                System.out.println("Nhập tên sản phẩm muốn sửa: ");
                String productName = scanner.nextLine();
                System.out.println("Nhập giá sản phẩm muốn sửa: ");
                int productPrice = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập số lượng sản phẩm muốn sửa: ");
                int productAmount = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhâp mô tả sản phẩm cần sửa: ");
                String productDescribe = scanner.nextLine();
                a.setProductCode(productCode);
                a.setProductName(productName);
                a.setProductPrice(productPrice);
                a.setProductAmount(productAmount);
                a.setProductDescribe(productDescribe);
            } else {
                System.out.println("Không tìm được sản phẩm ");
            }
        }
    }

    public void productRemove(Scanner scanner) {
        System.out.println("Nhập vào mã sản phẩm muốn xóa: ");
        String productCode = scanner.nextLine();
        for (Product a : arrayListProduct) {
            if (a.getProductCode().equals(productCode)) {
                System.out.println("Bạn có chắc muốn xóa sản phẩm ?");
                System.out.println("Y: Đồng ý xóa.");
                System.out.println("Nhập ký tự bất kỳ để thoát");
                String confirm = scanner.nextLine();
                if (confirm.equals("Y")) {
                    arrayListProduct.remove(a);
                    break;
                }

            } else {
                System.out.println("Không tìm được sản phẩm");
            }
        }
    }

    public ArrayList<Product> sortByIncreasePrice() {
        Collections.sort(arrayListProduct);
        return arrayListProduct;
    }

    public ArrayList<Product> sortByDecreasePrice() {
        ArrayList<Product> newProducts = sortByIncreasePrice();
        Collections.reverse(newProducts);
        return newProducts;
    }

    public void searchMaxPrice() {
        ArrayList<Product> productArrayList = sortByIncreasePrice();
        System.out.println(productArrayList.get((productArrayList.size() - 1)));
    }
}
