package hashtab;

import java.util.Scanner;

/**
 * @program: suamfa
 * @description: 哈希表
 * @author: ZhangChi
 * @create: 2019-11-28 11:02
 **/
public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add:添加:");
            System.out.println("list:显示:");
            System.out.println("find:显示:");
            System.out.println("exit:退出:");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int i = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    Emp emp = new Emp(i, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("输入要查找的ID:");
                    i = scanner.nextInt();
                    hashTab.findEmpById(i);
                    break;
                case "del":
                    System.out.println("输入要删除的ID:");
                    i = scanner.nextInt();
                    hashTab.delEmpById(i);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}

// 创建哈希表,用来管理多条链表
class HashTab {
    EmpLinkedList[] empLinkedListArray;
    private int size; // 表示共有多少条链表

    public HashTab(int size) {
        // 初始化EmpLinkedList
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        // 初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    // 添加
    void add(Emp emp) {
        // 根据id获取应当添加到那条链表
        int empLinkedListNO = hashFun(emp.id);
        // 将数据添加到对应的链表中
        empLinkedListArray[empLinkedListNO].add(emp);
    }

    // 遍历所有的链表
    void list() {
        // 遍历hash表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    // 根据输入的id查找
    void findEmpById(int id) {
        // 使用散列函数确定哪条链表查找
        int empLinkedListNO = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNO].findEmpById(id);
        if (emp != null) {
            System.out.printf("在第 %d 条链表中找到数据 id = %d\n", (empLinkedListNO + 1), id);
        } else {
            System.out.println("在hash表中没有找到对应数据");
        }
    }

    // 根据输入的id删除
    void delEmpById(int id) {
        // 使用散列函数确定哪条链表查找
        int empLinkedListNO = hashFun(id);
        empLinkedListArray[empLinkedListNO].delEmpById(id);
    }


    // 散列函数,使用取模
    int hashFun(int id) {
        return id % size;
    }
}

class Emp {
    int id;
    String name;
    Emp next;

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

// 创建一个LinkedList,表示链表
class EmpLinkedList {
    // 头指针,指向第一个数据,因此这个链表的head是指向第一个emp
    private Emp head; // 默认为空

    // 添加
    // 1.添加的时候,id是自增长的,从小到大,就是在链表的最后
    void add(Emp emp) {
        // 如果是添加第一个数据
        if (head == null) {
            head = emp;
            return;
        }
        // 定位到最后
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) {
                // 说明到链表的最后
                break;
            }
            curEmp = curEmp.next;// 后移
        }
        // 退出时直接将emp加入链表o
        curEmp.next = emp;
    }

    // 遍历链表
    void list(int no) {
        if (head == null) {
            // 当前链表为空
            System.out.println("第" + (no + 1) + "链表为空");
            return;
        }
        System.out.println("第" + (no + 1) + "的信息为:");
        Emp curEmp = head;
        while (true) {
            System.out.printf("==> id = %d name = %s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) {
                // 说明 curEmp已经是最后了
                break;
            }
            curEmp = curEmp.next; // 后移遍历
        }
        System.out.println();
    }

    // 根据id进行查找
    Emp findEmpById(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.id == id) {
                break; // curEmp就是要查找的数据
            }
            // 退出
            if (curEmp.next == null) {
                // 说明当前链表没有找到数据
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }

    // 根据id删除链表
    void delEmpById(int id) {
        Emp temp = head;
        boolean flag = false; // 标识是否找到待删除节点
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.id == id) {
                // 找到了待删除节点的前一个temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            head = temp.next;
        } else {
            System.out.println("要删除的节点不存在 ");
        }
    }

}
