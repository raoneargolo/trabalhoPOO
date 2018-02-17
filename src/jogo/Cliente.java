package jogo;

import java.awt.EventQueue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Map;

public class Cliente /* implements Runnable */ {
	
	static TelaLogon frame;
	
	public static void main(String args[]) throws UnknownHostException, IOException, ClassNotFoundException {
		Socket cliente = new Socket("127.0.0.1", 12346);

		//LerUsuario objLerUsuario = new LerUsuario();
		Map<String, String> mapaUsuarios; /*= objLerUsuario.lerUsuarios();*/
		
		ObjectOutputStream outToServer = new ObjectOutputStream(cliente.getOutputStream());
		
		ObjectInputStream inFromServer = new ObjectInputStream(cliente.getInputStream());
		mapaUsuarios=(Map<String, String>)inFromServer.readObject();
		frame = new TelaLogon(mapaUsuarios, outToServer);
		frame.setVisible(true);
	}
}

/*public static void main(String[] args) {
LerUsuario objLerUsuario = new LerUsuario();
mapaUsuarios = objLerUsuario.lerUsuarios();

EventQueue.invokeLater(new Runnable() {
	public void run() {
		frame = new TelaLogon();
		frame.setVisible(true);
	}
});
}*/
