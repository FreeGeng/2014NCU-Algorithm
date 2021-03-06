import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.JOptionPane;

public class NaServer {

	public static Vector systemMessage;

	// 整個server的程式進入點
	public static void main(String args[]) {
		new NaServer().setUpTheConnection();
	}

	public void setUpTheConnection() {
		// 儲存訊息用的vector
		systemMessage = new Vector();
		try {

			// 產生socket port
			ServerSocket serverSocket = new ServerSocket(8888);
			while (true) {
				// 等待是否有外部連線請求
				Socket socketSide = serverSocket.accept();
				// 建立系統的input/output,此部分是用來取得socketSide的輸出資料
				PrintStream PSwriter = new PrintStream(
						socketSide.getOutputStream());
				// 將元件加入vector
				systemMessage.add(PSwriter);

				// 使用執行緒,如此便可以實現多人連線
				// 此部分負責建立最主要的執行緒
				Thread primaryThread = new Thread(new connectionProcedure(
						socketSide));
				// 啟動主要執行緒
				primaryThread.start();
				JOptionPane.showMessageDialog(null, "目前主機位址："
						+ socketSide.getLocalSocketAddress()
						+("\n")
						+"目前連線人數："
					    + (primaryThread.activeCount() - 1));
			}
		} catch (Exception ex) {
			System.out.println("連線失敗！請檢查是否有正常開啟serverSide&clientSide");
		}
	}

	// 負責連線之後的處理程序
	public class connectionProcedure implements Runnable {
		// 此部分是用以暫存資料
		BufferedReader bufferedReader;
		// 建立一個暫存socket
		Socket tempSocket;

		// 此部分負責建立起接收的任務
		public connectionProcedure(Socket socketSide) {
			try {
				tempSocket = socketSide;
				// 建立系統的input/output,此部分是用來取得socketSide的輸入資料
				InputStreamReader ISReader = new InputStreamReader(
						tempSocket.getInputStream());

				bufferedReader = new BufferedReader(ISReader);
			} catch (Exception ex) {
				System.out.println("連線失敗！請檢查是否有正常開啟serverSide&clientSide");
			}
		}

		// 此部分負責執行執行緒
		@Override
		public void run() {
			String Message;
			try {
				// 讀取使用者輸入資料
				while ((Message = bufferedReader.readLine()) != null) {
					System.out.println("記錄聊天室內容");
					System.out.println("來自於使用者：" + Message);
					toEveryOne(Message);
				}
			} catch (Exception ex) {
				System.out.println("一個使用者離開聊天室了！");
			}
		}

		// 此部分用以告訴每位使用者聊天訊息
		public void toEveryOne(String Message) {
			// 使用iterator來存取並輸出集合內的資料
			Iterator iterator = systemMessage.iterator();
			// 判斷集合內部是否還有資料
			while (iterator.hasNext()) {
				try {
					// 取得集合內資料
					PrintStream writer = (PrintStream) iterator.next();
					// 印出
					writer.println(Message);
					// 重新更新緩衝區。
					writer.flush();
				} catch (Exception ex) {
					System.out.println("連線失敗！請檢查是否有正常開啟serverSide&clientSide");
				}
			}
		}

	}
}
