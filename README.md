Core Java Interview Questions — Detailed Explanations

# **1. If an exception occurs inside a constructor, will Java still create the object? Explain the behavior.**

  If a constructor throws an exception, the object will NOT be created.
  Java allocates memory first, but the object becomes valid only after the constructor finishes successfully. If the constructor fails:
  •	The object creation is aborted.
  •	The reference never receives a fully constructed object.
  •	The partially constructed object becomes eligible for Garbage Collection.
  This prevents the program from working with an inconsistent or half-initialized object.

# **2.	How can we notify the Garbage Collector that there are unused or unallocated resources?**

  You cannot force the JVM to run the Garbage Collector, but you can suggest it using:
  System.gc();
  However, this is only a request — JVM may choose to ignore it.
  For external resources (file handles, DB connections, sockets), GC cannot help.
  You must release them manually using:
  •	try-with-resources
  •	close() methods
  •	Proper resource management



# **3. If I manually call the finalize() method and there are 5 resources to clean, but an exception occurs while cleaning one of them—will finalize() continue?**

  If you manually call finalize(), it behaves like a normal method:
  •	If an exception occurs, it will stop executing further lines (unless handled).
  •	Other resources will not be cleaned unless you wrap the cleanup code in try–catch blocks.
  However, note:
  ✔ finalize() is deprecated since Java 9
  ✔ It is not guaranteed to run
  ✔ Should never be used for resource cleanup
  Use try-with-resources or explicit close() methods instead.

# **4.	Suppose you have a shared resource and want only 3 threads to access it simultaneously. How can you achieve this in Java?**

  Use Semaphore with 3 permits.
    Semaphore semaphore = new Semaphore(3);
      
      public void accessResource() {
          try {
              semaphore.acquire();   // Only 3 threads can enter
              // critical section
          } finally {
              semaphore.release();
          }
      }
      
  Semaphore is ideal when you need to limit concurrent access to a resource.

**5.🔹 Core Java & Concurrency**

**6. Explain the internal working of transactions**

**7. Explain the internal working of ConcurrentHashMap**

**8.🔹 Spring & Spring Boot**

**9. What is transaction propagation in Spring?**

**10. Explain the scope of Spring beans**

**11. Explain the internal flow of an API call in Spring Boot**

**12. How does Circuit Breaker work internally?**

**13. How do we integrate the Saga Design Pattern in microservices?**

**14. Difference between @Primary, @Bean, and @Qualifier annotations**

**15. Explain how Spring Boot auto-configuration works internally**

**16.🔹 Microservices & System Design**

**17. How does a system handle two duplicate requests hitting the server at the same time?**

**18. How does the database handle duplicate requests concurrently?**

**19.🔹 Design Principles**

**20. Explain SOLID principles**

**21.🔹 Database Concepts**

**22. Difference between a procedure and a function**

**23. What is a cursor in a database?**





