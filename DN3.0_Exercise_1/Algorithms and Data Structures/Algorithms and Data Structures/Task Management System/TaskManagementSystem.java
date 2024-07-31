class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class TaskManagementSystem {
    private Node head;

    public TaskManagementSystem() {
        this.head = null;
    }

    // Method to add a task
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to search a task by ID
    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    // Method to traverse and display all tasks
    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Method to delete a task by ID
    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty!");
            return;
        }

        if (head.task.getTaskId() == taskId) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.task.getTaskId() != taskId) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Task not found!");
        } else {
            current.next = current.next.next;
        }
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        TaskManagementSystem tms = new TaskManagementSystem();

        // Adding Tasks
        System.out.print("\nEnter number of tasks to add: ");
        int numTasks = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        for (int i = 0; i < numTasks; i++) {
            System.out.print("\nEnter task ID: ");
            int taskId = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            System.out.print("\nEnter task name: ");
            String taskName = scanner.nextLine();

            System.out.print("\nEnter task status: ");
            String status = scanner.nextLine();

            Task task = new Task(taskId, taskName, status);
            tms.addTask(task);
        }

        // Traversing Tasks
        System.out.println("\nAll Tasks:");
        tms.traverseTasks();

        // Searching for a Task
        System.out.print("\nEnter task ID to search: ");
        int searchId = scanner.nextInt();
        Task foundTask = tms.searchTask(searchId);
        System.out.println("\nSearch Result: " + (foundTask != null ? foundTask : "Task not found"));

        // Deleting a Task
        System.out.print("\nEnter task ID to delete: ");
        int deleteId = scanner.nextInt();
        tms.deleteTask(deleteId);

        // Traversing Tasks after Deletion
        System.out.println("\nAll Tasks after deletion:");
        tms.traverseTasks();
    }
}