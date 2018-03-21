可重入锁和 非可重入锁
 如果一个线程递归访问当前方法， 如果能够访问的话，就是可重入锁，  如果不能就是非可重入锁
  synchronized 和 lock 都是可重入锁， 非重入锁可以自己手写实现  http://blog.csdn.net/soonfly/article/details/70918802

### 自定义实现可重入锁和不可重入锁

