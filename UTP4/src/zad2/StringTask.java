package zad2;

public class StringTask implements Runnable {

	Thread thread = new Thread();
    final String str;
    static String result = "";
    int count;
    volatile static TaskState status;

    boolean flagIsDoing;

    enum TaskState {
        RUNNING, ABORTED, READY, CREATED
    }

    StringTask(String str, int countOfConcat) {
        status = TaskState.CREATED;
        this.str = str;
        count = countOfConcat;
    }


    public  void run() {
        while (!this.thread.isInterrupted() || flagIsDoing != true) {
            for (int i = 0; i < count; i++) {
                status = TaskState.RUNNING;
                try {
                    Thread.sleep(1);
                    result += str;

                } catch (InterruptedException e) {
                    status=TaskState.ABORTED;
                    return;
                }

                if (i == count - 1) {
                    status = TaskState.READY;
                    return;
                }

            }
        }
    }

    public synchronized boolean isDone() {
        switch (status) {
            case RUNNING:
                flagIsDoing = false;
                break;
            case ABORTED:
                flagIsDoing = true;
                break;
            case READY:
                flagIsDoing = true;
                break;
        }
        return flagIsDoing;
    }

    public void start() {
        this.thread = new Thread(new StringTask(str, count));
        this.thread.start();
    }

    public synchronized TaskState getState() {
        return status;
    }

    public synchronized String getResult() {
        return result;
    }

    public  void abort() {
        this.thread.interrupt();


    }
}
