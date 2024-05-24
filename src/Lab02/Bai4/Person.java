package Lab02.Bai4;
    // tính đóng gói được thể hiện như thế nào ?
    public class Person {
        private int id;
        private String name;
        private boolean gender;

        public Person() {
        }

        // hàm dựng là hàm đặc biệt có tên trùng với tên lớp , không có kiểu trae về
        //hàm dựng có 2 loại : 1 hàm dựng ko có tham số đầu vào (hàm dựng mặc định )
        // ; 2 hàm dựng có tham số đầu vào
        public Person(int id, String name, boolean gender) {
            this.id = id;
            this.name = name;
            this.gender = gender;
        }

        //
        public int getId() {
            return id;
        }

        //gán giá trị cho id
        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isGender() {
            return gender;
        }

        public void setGender(boolean gender) {
            this.gender = gender;
        }
        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

