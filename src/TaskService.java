import exception.IncorrectArgumentException;
import task.Task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskService {
    private final Map<Integer, Task> taskMap = new HashMap<>();
    private final List<Task> removedTasks = new ArrayList<>();
    public TaskService() {
    }

    public void addTask(Task task){
        taskMap.put(task.getId(), task);
    }

    public void removeTask(int id) throws IncorrectArgumentException {
        if (taskMap.containsKey(id)) {
            removedTasks.add(taskMap.remove(id));
            taskMap.remove(id);
        } else {
            throw new IncorrectArgumentException("Задача" + id + "отсутствует");
        }
    }

    public List<Task> getAllByDate(LocalDateTime dateTime){
        List<Task> tasks = new ArrayList<>();
        for (Task task : taskMap.values()){
            if (task.appearsIn(dateTime)){
                tasks.add(task);
            }
        }
        return tasks;
    }
}