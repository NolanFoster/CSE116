import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JOptionPane;

public class Main {
	private String _loc;
	private String _name;
	private String file;
	private RandomAccessFile store;
	private MTQueue schQueue;
	final private static int MAX_RECORD_NUMBER = 20;
	final private static int RECORD_LENGTH = 71;
	private int id;
	private String dummy;
	private Thread readThread;
	private Thread writeThread;

	public Main() throws FileNotFoundException {
		dummy = "qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjktnullnull";
		schQueue = new MTQueue();
		readThread = new Thread();
		
		writeThread = new Thread();

	}

	public void setFileLocation(String l) {
		_loc = l;

	}

	public void openFile(String l) throws FileNotFoundException {
		file = _loc;
		store = new RandomAccessFile(file, "rw");
	}

	public String getFileLoc() {
		return _loc;
	}

	public void setFileName(String n) {
		_name = n;
	}

	// read input file
	// File input = new File ("_loc");
	public void createFile() throws IOException {
		// saves the file a txt file
		file = _loc + "/" + _name + ".txt";
		// File fout = new File(file);
		store = new RandomAccessFile(file, "rw");

		for (int i = 0; i < MAX_RECORD_NUMBER; i++) {
			store.writeUTF(dummy);
		}
	}

	public void writeToFile(String ID, String pn, String SK, String tn, String d)
			throws IOException {
		//writeThread.start();
		System.out.println("update thread started");
		try {
			id = Integer.parseInt(ID);
		} catch (NumberFormatException ex) {

		}
		String buffer = "                          ";
		ID = ID + buffer;

		pn = pn + buffer;

		SK = SK + buffer;

		tn = tn + buffer;

		d = d + buffer;

		store.seek((RECORD_LENGTH + 2) * (id - 1));
		schQueue.MTPut(ID.substring(0, 5) + pn.substring(0, 26)
				+ tn.substring(0, 26) + SK.substring(0, 5) + d.substring(0, 9));
		JOptionPane.showMessageDialog(null,"Update is Scheduled");
		store.writeUTF(schQueue.MTGet());
		
		

	}

	public void findByID(int i) throws IOException {
	
		store.seek((RECORD_LENGTH + 2) * (i - 1));
		try {
			String Description = store.readUTF();

			Description.substring(0, RECORD_LENGTH);

			JOptionPane.showMessageDialog(null,
					"ID: " + Description.substring(0, 2) + " Player Name:"
							+ Description.substring(5, 31) + " Team Name:"
							+ Description.substring(31, 57) + " Skill Level:"
							+ Description.substring(57, 62) + " Date Added:"
							+ Description.substring(62, 71));

		} catch (StringIndexOutOfBoundsException ex) {
			// String name = JOptionPane.showMessageDialog(null,
			// "Error 404: Index not found, Try another index");
			System.out.println("Error 404: Index not found");
		} catch (EOFException x) {
			System.out.println("Error 404: Index not found");

		}

	}

}
