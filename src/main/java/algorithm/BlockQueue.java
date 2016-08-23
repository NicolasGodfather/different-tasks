package algorithm;

import java.util.LinkedList;

/**
 * Pessimistic lock - можно зайти в критическую секцию только одной нитью
 * Optimistic lock - есть первоначальное полученное состояние, если сотояние объекта неизменилось,
 * то можно сделать эту запись, если изменилось, то повторно перечитываем данные и проверяем все
 * ли правильно, корректно ли состояние объекта.
 * Монитор это замок.
 *
 */
public class BlockQueue<T> {
	public final LinkedList<T> queue = new LinkedList<T>();

	public void push(final T t) {
		synchronized (this.queue) {
			this.queue.add(t);
			this.queue.notifyAll();
		}
	}

	public T poll() {
		synchronized (this.queue) {
			while (this.queue.isEmpty()) {
				try {
					this.queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return this.queue.remove();
		}
	}
}
