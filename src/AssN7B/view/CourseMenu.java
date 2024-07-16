
package AssN7B.view;


import AssN7B.controller.CourseList;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;


public class CourseMenu extends Menu{
    CourseList courseList  = new CourseList();
    Scanner sc = new Scanner(System.in);

//    VaccineManager vaccineManager = new VaccineManager();
//    Scanner scanner = new Scanner(System.in);
//    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//
    public CourseMenu() {
    }

    public CourseMenu(String td, String[] mc) {
        super(td, mc);
    }

    @Override
public void execute(int n) {
    Logger logger = Logger.getLogger(CourseMenu.class.getName());
    switch (n) {
        case 1 -> {
            try {
                courseList.DisplayAll();
            } catch (Exception e) {
                logger.log(Level.SEVERE, null, e);
            }
        }
        case 2 -> {
            try {
                courseList.AddCourse();
            } catch (Exception e) {
                logger.log(Level.SEVERE, null, e);
            }
        }
        case 3 -> {
            try {
                System.out.println("Tong gia sach la: " + courseList.totalBookPrice());
            } catch (Exception e) {
                logger.log(Level.SEVERE, null, e);
            }
        }
        case 4 -> {
            System.out.println("Nhap nam de tinh : ");
            int year = sc.nextInt();
            sc.nextLine();  // Consume newline
            courseList.printChartStatic(year);
        }
        case 5 -> {
            try {
                courseList.DeleteCourse();
            } catch (Exception e) {
                logger.log(Level.SEVERE, null, e);
            }
        }
        case 6 -> {         
            searchCourse();
        }
        case 7 -> {
            try {
                System.out.println("Khoa hoc co so luong lon nhat la: " + courseList.findLargestQuantityCourse());
            } catch (Exception e) {
                logger.log(Level.SEVERE, null, e);
            }
        }
        case 8 -> {
            try {
                courseList.writeFile();
            } catch (Exception e) {
                logger.log(Level.SEVERE, null, e);
            }
        }
        case 9 -> {
            System.out.println("Chuong trinh da ket thuc!!");
            System.exit(0);
        }
    }
}

public void searchCourse() {
        String[] choiceSearch = {"Theo ten", "Theo tac gia", "Theo nam xuat ban" , "Tro ve Main Menu"};
        Menu menu = new Menu("Tim kiem khoa hoc theo tieu chi", choiceSearch) {
            @Override
            public void execute(int ch) {
                switch (ch) {
                    case 1:
                        String title = Utils.getValue("Nhap ten khoa hoc can tim: ");
                        courseList.searchCourseByTitle(title);
                        break;
                    case 2:
                        String author = Utils.getValue("Nhap ten tac gia can tim: ");
                        courseList.searchCourseByAuthor(author);
                        break;
                    case 3:
                        int year = Integer.parseInt(Utils.getValue("Nhap nam xuat ban cua khoa hoc can tim: "));
                        courseList.searchCourseByYear(year);
                        break;
                    default:
                        System.err.println("Tim kiem ket thuc; tro ve Main menu!");
                }
            }
        };
        menu.run();
    }


}