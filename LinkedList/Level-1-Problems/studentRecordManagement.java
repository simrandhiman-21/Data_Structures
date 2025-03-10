class Student{
    int rollno;
    String name;
    int age;
    String grade;
    Student next;

    Student(int rollno,String name,int age,String grade){
        this.rollno = rollno;
        this.name=name;
        this.age=age;
        this.grade=grade;
        this.next=null;
    }
}
class StudentLinkedList{

    private Student head;

    public void add(int rollno,String name,int age,String grade,int postition){
        Student newStudent=new Student(rollno, name, age, grade);

        if(postition==0 || head==null){
            newStudent.next=head;
            head=newStudent;
            return;
        }
        Student temp=head;
        for(int i=0;temp!=null && i<postition-1 ;i++){
            temp=temp.next;
        }
        newStudent.next=temp.next;
        temp.next=newStudent;
    }

    
    public void delete(int rollno){
        if(head==null) return;
        if(head.rollno==rollno){
            head=head.next;
            return;
        }
        Student temp=head;
        while(temp!=null && temp.next.rollno!=rollno){
            temp=temp.next;
        }
        if(temp.next!=null){
            temp.next=temp.next.next;
        }
    }
    
    public boolean search(int rollno){
        if(head.rollno==rollno){
            return true;
        }
        Student temp=head;
        while(temp!=null){
            if(temp.rollno==rollno){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
    
    public void displayRecords() {
        if (head == null) {
            System.out.println("No student records available.");
            return;
        }
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll Number: " + temp.rollno + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    public void update(int rollno){
        if(head==null) return;
        if(head.rollno==rollno){
            head.grade="A";
            return;
        }
        Student temp=head;
        while(temp!=null && temp.next.rollno!=rollno){
            temp=temp.next;
        }
            if(temp.next!=null){
                temp.next.grade="A";
            }
    }
}
class studentRecordManagement{
    public static void main(String[] args) {

        StudentLinkedList list=new StudentLinkedList();
        list.add(1,"John",20,"A",0);
        list.add(2,"Peter",21,"B",1);
        list.add(3,"Jack",22,"C",2);
        list.add(4,"alexa",18,"A+",3);
        list.add(5,"adam",25,"B+",4);


        System.out.println("Student Records:");
        list.displayRecords();

        list.delete(1);
        System.out.println("After deleting the first record:");
        list.displayRecords();

        System.out.println(list.search(2));

        list.update(3);
        System.out.println("After updating the third record Grades :");
        list.displayRecords();





        
    }
}