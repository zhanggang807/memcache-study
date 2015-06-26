package org.dean.memcachedemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import com.schooner.MemCached.AbstractTransCoder;
import com.schooner.MemCached.TransCoder;

/**
 * {@link ObjectTransCoder} is the default TransCoder used to handle the
 * serialization and deserialization in memcached operations.
 * 
 * @author Xingen Wang
 * @see AbstractTransCoder
 * @see TransCoder
 */
public class ObjectTransCoder extends AbstractTransCoder {
	/**不是太好用呀*/
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.schooner.MemCached.TransCoder#decode(InputStream)
	 */
	public Object decode(final InputStream input) throws IOException {
		Object obj = null;
		ObjectInputStream ois = new ObjectInputStream(input);
		try {
			obj = ois.readObject();
		} catch (ClassNotFoundException e) {
			throw new IOException(e.getMessage());
		}
		ois.close();
		return obj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.schooner.MemCached.AbstractTransCoder#encode(java.io.OutputStream,
	 * java.lang.Object)
	 */
	public void encode(final OutputStream output, final Object object)
			throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(output);
		oos.writeObject(object);
		oos.close();
	}

//	public Object decode(byte[] input) {
//		Object obj = null;
//		try {
//			ObjectInputStream ois = new ObjectInputStream(
//					new ByteArrayInputStream(input));
//			obj = ois.readObject();
//			ois.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return obj;
//	}
}