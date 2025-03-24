ReentrantLock in Java

1. What is ReentrantLock?
   ReentrantLock is a class in Java’s java.util.concurrent.locks package that provides an explicit locking mechanism. It
   is an alternative to the synchronized keyword but offers more flexibility and advanced features.

🔹 Reentrant means a thread can acquire the same lock multiple times without causing a deadlock.

2. Why Use ReentrantLock Over synchronized?
   Feature synchronized ReentrantLock
   Lock Acquisition Implicit Explicit (lock() & unlock())
   Fairness Option No Yes (new ReentrantLock(true))
   Interruptible Lock No Yes (lockInterruptibly())
   Try Lock with Timeout No Yes (tryLock(2, TimeUnit.SECONDS))
   Condition Variables No Yes (newCondition()).


3. Basic Example

``` import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
    private final ReentrantLock lock = new ReentrantLock();

    public void criticalSection() {
        lock.lock(); // Acquire the lock
        try {
            System.out.println(Thread.currentThread().getName() + " is executing");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock(); // Release the lock
        }
    }
}

public class ReentrantLockExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Runnable task = resource::criticalSection;

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}
 Ensures only one thread can enter the criticalSection() at a time.


```

4. Reentrant Behavior
   A thread can acquire the lock multiple times.

```
class ReentrantExample {
    private final ReentrantLock lock = new ReentrantLock();
   
   public static void main(String[] args) {
        ReentrantExample obj = new ReentrantExample();
        obj.methodA();
    }
    
    public void methodA() {
        lock.lock();
        try {
            System.out.println("methodA() - Holding lock");
            methodB(); // Calls another locked method
        } finally {
            lock.unlock();
        }
    }

    public void methodB() {
        lock.lock();
        try {
            System.out.println("methodB() - Lock re-entered");
        } finally {
            lock.unlock();
        }
    }
}
methodA() calls methodB(), and the same thread re-enters the lock.
```
5. Fair vs. Non-Fair Lock
   By default, ReentrantLock is non-fair, meaning threads may not get the lock in the order they requested.
```
ReentrantLock fairLock = new ReentrantLock(true);  // Fair lock
ReentrantLock unfairLock = new ReentrantLock();    // Default: Unfair lock
Fair locks ensure FIFO ordering but have a slight performance cost.
```

6. tryLock() - Avoid Blocking
   Instead of waiting indefinitely, a thread can try acquiring the lock.

```
if (lock.tryLock()) {
    try {
        System.out.println("Lock acquired!");
    } finally {
        lock.unlock();
    }
} else {
    System.out.println("Could not acquire lock!");
}
Prevents deadlocks by not waiting indefinitely.
```

7. lockInterruptibly() - Interruptible Locks
   Allows a thread to abort waiting for a lock if it’s interrupted.

```
try {
    lock.lockInterruptibly();
    // Critical section
} catch (InterruptedException e) {
    System.out.println("Interrupted while waiting for lock");
} finally {
    lock.unlock();
}
Useful when handling timeouts or task cancellations.
```   

8. Condition Variables - newCondition()
   Unlike synchronized, ReentrantLock allows fine-grained control with multiple conditions.

```
import java.util.concurrent.locks.*;

class ConditionExample {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private boolean isReady = false;

    public void producer() throws InterruptedException {
        lock.lock();
        try {
            isReady = true;
            condition.signal();  // Notify waiting consumer
        } finally {
            lock.unlock();
        }
    }

    public void consumer() throws InterruptedException {
        lock.lock();
        try {
            while (!isReady) {
                condition.await();  // Wait until signal is received
            }
            System.out.println("Consumed!");
        } finally {
            lock.unlock();
        }
    }
}
More flexible than wait() & notify() in synchronized.
```

9. When to Use ReentrantLock?
```
Use ReentrantLock instead of synchronized when: ✔ You need interruptible locks (e.g., lockInterruptibly()).
✔ You want to avoid indefinite blocking (e.g., tryLock()).
✔ You need fairness guarantees (e.g., new ReentrantLock(true)).
✔ You need multiple condition variables (newCondition()).

🚀 For most cases, synchronized is simpler and preferred, but ReentrantLock is useful for complex concurrency scenarios.
```