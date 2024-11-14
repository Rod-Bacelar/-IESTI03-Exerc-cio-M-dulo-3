package componentes;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingWorker;
import javax.swing.border.LineBorder;
import javax.swing.tree.DefaultMutableTreeNode;

public class Componentes extends JFrame {
    public void criarBorda(JPanel painel, int largura, int altura) {
        painel.setBorder(new LineBorder(Color.GRAY, 1));
        painel.setPreferredSize(new Dimension(largura, altura));
    }
    
    public JPanel ExercicioA() {
        JPanel a = new JPanel();
        
        criarBorda(a, 550, 50);
        
        a.add(new JLabel("Interface gráfica com Java Swing"));
        return a;
    }

    public JPanel ExercicioB(boolean borda) {
        JPanel b = new JPanel();

        if (borda) 
            criarBorda(b, 550, 50);

        b.add(new JLabel("Nome: "));
        b.add(new JTextField(10));

        return b;
    }

    public JPanel ExercicioC() {
        JPanel c = new JPanel();
        criarBorda(c, 550, 200);

        c.add(new JLabel("Faça um resumo de suas atividades profissionais: "));
        
        JTextArea textArea = new JTextArea(10, 20);
        textArea.setBorder(new LineBorder(Color.GRAY, 1));
        c.add(textArea);

        return c;
    }

    public JPanel ExercicioD() {
        JPanel d = new JPanel();
        criarBorda(d, 550, 50);

        d.add(new JLabel("Cores Preferidas: "));
        
        d.add(new JCheckBox("Azul"));
        d.add(new JCheckBox("Preto"));
        d.add(new JCheckBox("Amarelo"));
        d.add(new JCheckBox("Verde"));

        return d;
    }

    public JPanel ExercicioE(boolean borda) {
        JPanel e = new JPanel();
        
        if (borda)
            criarBorda(e, 550, 50);

        JRadioButton mascRB = new JRadioButton("Masculino");
        JRadioButton femRB = new JRadioButton("Feminino");
        
        // Agrupando os RadioButtons
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(mascRB);
        grupo.add(femRB);
        
        e.add(new JLabel("Sexo: "));
        e.add(mascRB);
        e.add(femRB);

        return e;
    }

    public JButton criarBotao(String texto, int largura, int altura, Color cor) {
        JButton botao = new JButton(texto);
        botao.setPreferredSize(new Dimension(largura, altura));
        botao.setBackground(cor);

        return botao;
    }

    public JPanel ExercicioF() {
        JPanel f = new JPanel();
        criarBorda(f, 550, 50);

        f.add(criarBotao("Cancelar", 150, 30, Color.CYAN));
        f.add(criarBotao("Salvar", 150, 30, Color.CYAN));
        f.add(criarBotao("Enviar", 150, 30, Color.CYAN));

        return f;
    }

    public JPanel ExercicioG() {
        JPanel g = new JPanel();
        criarBorda(g, 550, 50);

        
        g.add(ExercicioB(false));
        g.add(ExercicioE(false));
        g.add(criarBotao("Enviar", 150, 30, Color.CYAN));

        return g;
    }

    public JPanel ExercicioH() {
        JPanel h = new JPanel();
        criarBorda(h, 550, 100);

        String[] nomeColunas = {"Código", "Produto", "Descrição"};

        Object[][] dados = {{1123, "Pendrive", "Pendrive 32 GB"},
                            {2323, "HD SSD", "256 GB"},
                            {3333, "Memória RAM", "16 GB"},
                            {2344, "CPU", "i7"}};
        
        JTable tabela = new JTable(dados, nomeColunas);
        tabela.setPreferredScrollableViewportSize(new Dimension(500, 64));
        tabela.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(tabela);

        h.add(scrollPane);


        return h;
    }

    public JPanel ExercicioI() {
        JPanel i = new JPanel();
        criarBorda(i, 550, 100);

        String[] dados = {"One", "Two", "Three", "Four", "Five", "Six"};
        
        JList<String> lista = new JList<String>(dados);

        JScrollPane scrollPane = new JScrollPane(lista);
        scrollPane.setPreferredSize(new Dimension(70, 70));

        JPanel painel = new JPanel();
        painel.add(scrollPane);

        i.add(painel);

        return i;
    }

    public JPanel ExercicioJ() {
        JPanel j = new JPanel();
        criarBorda(j, 550, 50);

        j.add(new JLabel("Running a Long Task"));

        JLabel taxaCompleto = new JLabel("Completed 0%");
        j.add(taxaCompleto);

        JProgressBar progressBar = new JProgressBar();

        progressBar.setMinimum(0);
        progressBar.setMaximum(100);

        j.add(progressBar);

        // Criando um SwingWorker para atualizar o progresso
        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {

            @Override
            protected Void doInBackground() throws Exception {
                // Simula uma tarefa longa
                for (int i = 0; i <= 100; i++) {
                    // Envia a porcentagem de progresso
                    publish(i);
                    Thread.sleep(100);  // Simula o trabalho com atraso de 100ms
                }
                return null;
            }

            @Override
            protected void process(java.util.List<Integer> chunks) {
                // Atualiza a barra de progresso com o valor recebido do método publish()
                for (int i : chunks) {
                    progressBar.setValue(i);
                    taxaCompleto.setText("Completed: " + i + "%");
                }
            }

            @Override
            protected void done() {
                // Quando o trabalho estiver concluído
                progressBar.setValue(100);  // Assegura que a barra estará cheia ao terminar
                taxaCompleto.setText("Completed: 100%");
            }
        };

        worker.execute();

        j.add(criarBotao("Cancel", 100, 30, Color.CYAN));

        return j;
    }

    public JPanel ExercicioL() {
        JPanel l = new JPanel();
        criarBorda(l, 550, 140);

        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("The Java Series");

        DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("Books for Java I");
        DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("Books for Java II");

        DefaultMutableTreeNode node21 = new DefaultMutableTreeNode("The Java Vir");
        DefaultMutableTreeNode node22 = new DefaultMutableTreeNode("The Java La");

        node2.add(node21);
        node2.add(node22);
        raiz.add(node1);
        raiz.add(node2);

        JTree arvore = new JTree(raiz);

        l.add(arvore);

        return l;
    }
    
    public Componentes(String nomeJanela) {
        // Criando o Painel Principal
        JPanel principal = new JPanel();
        
        // Adicionando os paineis
        principal.add(ExercicioA());
        principal.add(ExercicioB(true));
        principal.add(ExercicioC());
        principal.add(ExercicioD());
        principal.add(ExercicioE(true));
        principal.add(ExercicioF());
        principal.add(ExercicioG());
        principal.add(ExercicioH());
        principal.add(ExercicioI());
        principal.add(ExercicioJ());
        principal.add(ExercicioL());

        // Adicionando o painel principal ao frame
        add(principal);

        // Exibindo a Janela
        setTitle(nomeJanela);
        setSize(600, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
