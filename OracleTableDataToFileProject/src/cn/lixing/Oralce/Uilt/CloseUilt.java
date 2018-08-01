package cn.lixing.Oralce.Uilt;

import java.io.Closeable;
import java.io.IOException;

public class CloseUilt {
	public static void close(Closeable ...io) {
		for(Closeable temp:io) {
			try {
				temp.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
