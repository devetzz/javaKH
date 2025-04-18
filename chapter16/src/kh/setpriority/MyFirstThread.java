package kh.setpriority;

public class MyFirstThread extends Thread{
	@Override
	public void run() {
		// 시간을 지연시킨다. sleep() or 일을 많이 시킨다
		long sum = 0L;
		for(long i = 0L ; i < 5_000_000_000L; i++) {
			sum += i;
		}
		System.out.printf("%6s 쓰레드는 일을 마침 sum = %d\n", this.getName(), sum);
	}
}
