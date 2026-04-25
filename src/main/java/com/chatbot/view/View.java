package main.java.com.chatbot.view;

import java.util.List;
import javax.swing.JOptionPane;
import main.java.com.chatbot.model.Cliente;

public class View {

    public void showM(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    public String readString(String mensagem) {
        return JOptionPane.showInputDialog(null, mensagem);
    }

    public Cliente escolherCliente(List<Cliente> clientes) {

        Cliente selecionado = (Cliente) JOptionPane.showInputDialog(
                null,
                "",
                "Clientes",
                JOptionPane.QUESTION_MESSAGE,
                null,
                clientes.toArray(),
                clientes.get(0)
        );

        return selecionado;
    }
}
