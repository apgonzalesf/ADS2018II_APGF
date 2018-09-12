package pe.com.apgf.bigonotation;

import java.util.concurrent.TimeUnit;

public class Stopwatch {
	 long startTime;

	    public static Stopwatch start() {
	        return new Stopwatch();
	    }

	    private Stopwatch() {
	        reset();
	    }

	    public Stopwatch reset() {
	        startTime = System.currentTimeMillis();
	        return this;
	    }

	    public long time() {
	        long endTime = System.currentTimeMillis();
	        return endTime - startTime;
	    }

	    public long time(  TimeUnit destino) {
	    	TimeUnit origen = TimeUnit.MILLISECONDS;
	        return destino.convert(time(),origen );
	    }
}
