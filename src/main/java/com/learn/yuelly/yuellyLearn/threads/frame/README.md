# yuellyLearn


ExecutorService、Callable、Future这个对象实际上都是属于Executor框架中的功能类

线程池的架构图：
http://blog.csdn.net/coslay/article/details/45314749


### 线程池
 #### 线程增长方式

l  如果此时线程池中的数量小于corePoolSize，即使线程池中的线程都处于空闲状态，也要创建新的线程来处理被添加的任务。

2  如果此时线程池中的数量等于 corePoolSize，但是缓冲队列 workQueue未满，那么任务被放入缓冲队列。

3  如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量小于maximumPoolSize，建新的线程来处理被添加的任务。

4  如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量等于maximumPoolSize，那么通过 handler所指定的策略来处理此任务。也就是：处理任务的优先级为：核心线程corePoolSize、任务队列workQueue、最大线程maximumPoolSize，如果三者都满了，使用handler处理被拒绝的任务。

当线程池中的线程数量大于 corePoolSize时，如果某线程空闲时间超过keepAliveTime，线程将被终止。这样，线程池可以动态的调整池中的线程数。

#### 线程四种拒绝策略

AbortPolicy (默认的拒绝策略): 将直接抛出 RejectedExecutionException 异常

CallerRunsPolicy : 如果当前线程池没有shutdown， 将会在调用线程调用当前方法

DiscardPolicy ： 直接丢弃当前任务 不抛出异常

DiscardOldestPolicy ： 丢弃缓存队列里面最老的任务    四种策略都可以从源码看出来区别。




