import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class vMem {
	private int index;
	private long value;
	private long[] array;
	private long[] actualArray;
	private RandomAccessFile store;
	private int size;
	private int VIR;
	public vMem(int i, int j) throws IOException{
		array = new long[VIR];
		store = new RandomAccessFile("files", "rw");
		for (int k = 0; k < size; k++) {
			store.writeLong(0);
		}
		
	}

	public void put(int i, long v) throws IOException {
		//pull 100 values from file starting from index store values in array add in the index
		store.seek(VIR*i);
		if(i>=0 && i<=99){
			store.readLong();
		}
		index=i;
		value=v;
		array[i]=v;
		
	}

	public long get(int i) throws IOException {
		store.seek(VIR*i);
		
		return array[i];
	}
	
}
