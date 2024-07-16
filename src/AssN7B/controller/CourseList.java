
package AssN7B.controller;

import AssN7B.model.Course;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author OS
 */
public class CourseList {
    static List<Course> courseList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    
    
    public static void readFile() throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader("src/AssN7B/course.txt"))) {
        String line;
        
        while ((line = br.readLine()) != null) {
            String[] splitLine = line.split(",");
            String title = null;
            String author = null;
            int publishedYear = 0;
            double unitPrice = 0;
            int quantity = 0;
            boolean flag = true;
            
            for (String part : splitLine) {
                String[] keyValue = part.split("=");
                if (keyValue.length != 2) {
                    flag = false;
                    break;
                }
                String key = keyValue[0].trim();
                String value = keyValue[1].trim();
                
                switch (key) {
                    case "title":
                        title = value;
                        break;
                    case "author":
                        author = value;
                        break;
                    case "publishedYear":
                        try {
                            publishedYear = Integer.parseInt(value);
                        } catch (NumberFormatException e) {
                            flag = false;
                        }
                        break;
                    case "unitPrice":
                        try {
                            unitPrice = Double.parseDouble(value);
                        } catch (NumberFormatException e) {
                            flag = false;
                        }
                        break;
                    case "quantity":
                        try {
                            quantity = Integer.parseInt(value);
                        } catch (NumberFormatException e) {
                            flag = false;
                        }
                        break;
                    default:
                        break;
                }
            }
            
            if (flag) {
                Course course = new Course(title, author, publishedYear, unitPrice, quantity);
                courseList.add(course);
            }
        }
    } catch (IOException e) {
        // Xử lý lỗi khi đọc file
        throw new IOException("Error reading file: " + e.getMessage());
    }
}

    
 public static void writeFile() throws IOException {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/AssN7B/course.txt"))) {
        for (Course course : courseList) {
            bw.write("title=" + course.getTitle() + ", author=" + course.getAuthor() + ", publishedYear=" + course.getPublishedYear() + ", unitPrice=" + course.getUnitPrice() + ", quantity=" + course.getQuantity() + "\n");
        }
    } catch (IOException e) {
        // Xử lý lỗi khi ghi file
        throw new IOException("Error writing file: " + e.getMessage());
    }
}



    public static double totalBookPrice() {
        double total = 0;
        for (Course course : courseList) {
            total += (course.calculateTotalPrice() + course.calculateTransportPrice());
        }
        return total;
    }

    public static void ViewAll(List<Course> b) {
        for (Course course : b) {
            System.out.println(course.toString());
        }
    }

    public static void DisplayAll() throws Exception {
        if (courseList.isEmpty()) {
            readFile();
            ViewAll(courseList);
        } else {
            ViewAll(courseList);
        }
    }

//    public static void Search(Predicate<Course> p) {
//        List<Course> finds = new ArrayList<>();
//        for (Course course : courseList) {
//            if (p.test(course)) {
//                finds.add(course);
//            }
//        }
//        ViewAll(finds);
//    }
    public void searchCourseByTitle(String title) {
        List<Course> result = new ArrayList<>();
        for (Course course : courseList) {
            if (course.getTitle().equalsIgnoreCase(title)) {
                result.add(course);
            }
        }
        displayCourses(result);
    }

    public void searchCourseByAuthor(String author) {
        List<Course> result = new ArrayList<>();
        for (Course course : courseList) {
            if (course.getAuthor().equalsIgnoreCase(author)) {
                result.add(course);
            }
        }
        displayCourses(result);
    }

    public void searchCourseByYear(int year) {
        List<Course> result = new ArrayList<>();
        for (Course course : courseList) {
            if (course.getPublishedYear() == year) {
                result.add(course);
            }
        }
        displayCourses(result);
    }

    private void displayCourses(List<Course> courses) {
        if (courses.isEmpty()) {
            System.out.println("Khong tim thay khoa hoc nao.");
        } else {
            for (Course course : courses) {
                System.out.println(course);
            }
        }
    }
    
    public static void AddCourse(){
        System.out.println("Nhap vao Book Title: ");
        String title = sc.nextLine();
        System.out.println("Nhap vao Author: ");
        String author = sc.nextLine();
        System.out.println("Nhap vao published year: ");
        int publishedYear = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap vao unit price: ");
        double unitPrice = Double.parseDouble(sc.nextLine());
        System.out.println("Nhap vao quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());
        Course course = new Course(title, author, publishedYear, unitPrice, quantity);
        courseList.add(course);
    }

    public static void DeleteCourse() {
        System.out.println("Nhap vao Book Title :");
        String title = sc.nextLine();
        for (int i = 0; i < courseList.size(); i++) {
            if (title.equals(courseList.get(i).getTitle())) {
                courseList.remove(i);
            }
        }
    }

    public static Course findLargestQuantityCourse() {
        if (courseList.isEmpty()) {
            return null;
        }
        Course maxQuantityCourse = courseList.get(0);
        for (Course course : courseList) {
            if (course.getQuantity() > maxQuantityCourse.getQuantity()) {
                maxQuantityCourse = course;
            }
        }
        return maxQuantityCourse;
    }    
    
    
  public static  List<Course> filterCoursesByYear(int year) {
        List<Course> filteredCourses = new ArrayList<>();
        for (Course course : courseList) {
            if (course.getPublishedYear() == year) {
                filteredCourses.add(course);
            }
        }
        return filteredCourses;
    }

    public static List<Integer> getYearsWithCourses() {
        List<Integer> years = new ArrayList<>();
        for (Course course : courseList) {
            int year = course.getPublishedYear();
            if (!years.contains(year)) {
                years.add(year);
            }
        }
        years.sort((y1, y2) -> Integer.compare(y1, y2));
        return years;
    }
  
        
// Trong class CourseMenu
public void printChartStatic(int year) {
    System.out.println("Năm: " + year);
    System.out.println("| Khóa học   | Đơn giá    | Số lượng | Tiền thu được |");
    System.out.println("| ---------- | ---------- | -------- | ------------- |");

    List<Course> coursesInYear = CourseList.filterCoursesByYear(year);

    // In chi tiết cho mỗi khóa học
    for (Course course : coursesInYear) {
        StringBuilder line = new StringBuilder();

        // In tiêu đề khóa học
        line.append(String.format("| %-10s ", course.getTitle()));

        // In đơn giá
        line.append(String.format("| %-10.1f ", course.getUnitPrice()));

        // In số lượng
        line.append(String.format("| %-8d ", course.getQuantity()));

        // In tiền thu được
        double totalRevenue = course.calculateTotalPrice();
        line.append(String.format("| %-13.2f ", totalRevenue));

        line.append("|");
        System.out.println(line);
    }
}

  
}

