import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.JOptionPane;
//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
public class TesteProjetoChatGPT {
    public static void main(String[] args) throws Exception {
        var properties = new Properties();
        properties.load(new FileInputStream("src/app.properties"));
        final String OPENAI_API_KEY = 
            properties.getProperty("OPENAI_API_KEY");
        
            String opcoes = "1. Traduzir frase para Português\n2. Filme em Emoji\n3. Explicação para Criança\n4. Sair";
            int op = 3;
            do {
                    op = Integer.parseInt(JOptionPane.showInputDialog(opcoes));  
                    var chatGPTClient = new ChatGPTClient();
                    switch(op){
                        case 1:
                        //Pegar uma frase em ingles
                        String fraseIngles = JOptionPane.showInputDialog("Entre com uma frase em Inglês");
                        //Chamar o método criarPergunta, obter o resultado
                        String s = chatGPTClient.criarPerguntaOp1(OPENAI_API_KEY, fraseIngles);
                        //e exibir
                        JOptionPane.showMessageDialog(null, s);
                        break;
                        case 2:
                        //Pegar o nome do filme
                        String nomeFilme = JOptionPane.showInputDialog("Nome de um filme");
                        //Chamar o método criarPergunta, obter o resultado
                        String t = chatGPTClient.criarPerguntaOp2(OPENAI_API_KEY, nomeFilme);
                        //e exibir
                        JOptionPane.showMessageDialog(null, t);
                        break;
                        case 3:
                        //Pegar um assunto a ser explicado
                        String explicacaoCrianca = JOptionPane.showInputDialog("Entre com a pergunta a ser explicada");
                        //Chamar o método criarPergunta, obter o resultado
                        String u = chatGPTClient.criarPerguntaOp3(OPENAI_API_KEY, explicacaoCrianca);
                        //e exibir
                        JOptionPane.showMessageDialog(null, u);
                        break;        
                    }
            }while (op != 4);
    }
}

