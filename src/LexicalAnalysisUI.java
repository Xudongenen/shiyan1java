import javax.swing.*;
import java.io.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.filechooser.FileFilter;

public class LexicalAnalysisUI {

    public LexicalAnalysisUI() {
        ����Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                save();
            }
        });
        ��ʼ����Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                textArea2.setText("");
                LexicalAnalysis lexicalAnalysis=new LexicalAnalysis();
                lexicalAnalysis.main(null);
                //lexicalAnalysis.report_error();
                try {
                    File infile = new File("D:\\��ҵ\\����ԭ��\\shiyan1java\\out.txt");//�����ļ�����
                    BufferedReader Breader = null;
                    Breader = new BufferedReader(new FileReader(infile));
                    String fp = null;
                    while ((fp = Breader.readLine()) != null) {           //���ж�ȡ�ļ�
                        textArea2.append(fp + "\r\n");
                    }
                    Breader.close();
                } catch (Exception e1) {
                    System.err.print(e1);
                }
            }
        });
        �鿴ת��ͼButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                label.setVisible(true);
            }
        });
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                label.setVisible(false);
            }
        });
    }
    public void save(){
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        chooser.setFileFilter(new FileFilter(){
            //@Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".txt");
            }
            //@Override

            public String getDescription() {
                return "SAVE TO";
            }
        });
        int r = chooser.showSaveDialog(this.textArea1);
        if(r!=JFileChooser.APPROVE_OPTION) return;
        File f = chooser.getSelectedFile();
        String text = textArea1.getText();
        String[] lines = text.trim().split("\n");
        try {
            PrintWriter out = new PrintWriter(new FileOutputStream(f),true);
            for(String line:lines)
                out.println(line);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("LexicalAnalysisUI");
        frame.setContentPane(new LexicalAnalysisUI().LexicalAnalysis);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    private JButton ��ʼ����Button;
    private JButton �鿴ת��ͼButton;
    private JPanel LexicalAnalysis;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton ����Button;
    private JLabel label;
}
