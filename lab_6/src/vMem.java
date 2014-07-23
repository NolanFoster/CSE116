
import java.io.IOException;
import java.io.RandomAccessFile;

public class vMem {
	private long[] array;
	private RandomAccessFile store;
	private long result;

	public vMem(int i, int j) throws IOException {
		array = new long[101];
		store = new RandomAccessFile("files/swapfile", "rw");
		for (int k = 0; k <= i * 8; k++) {
			store.seek(k * 8);
			store.writeLong(1);
		}

	}

	public long vRead(int low, int i, int high) throws IOException {
	
		for (int k = 0; k < 99; k++) {
		if (k == 0) { store.seek((low*8)+k);  }
		array[k] = store.readLong();
	}
			int index =high-i;
			store.seek(i*8);
			array[index] = store.readLong();
        
		return array[index];

	}

	public void vWrite(int low, int i, long val, int high) throws IOException {
		
		vRead(low, i, high);
		int index =high-i;
		array[index] = val;
		store.seek(i * 8);
		store.writeLong(array[index]);
		
	}

	public void put(int i, long v) throws IOException {
			int low = (i / 100) * 100;
			int high = low + 100;
			vWrite(low, i, v, high);
	}

	public long get(int i) throws IOException {
			int low = (i / 100) * 100;
			int high = low + 100;
			result= vRead(low, i, high);
		
		return result;
	}

}
