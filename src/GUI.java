import anagram.Anagram;
import anagramsolver.Anagramsolver;
import countdown.Countdown;
import findword.FindWord;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.ComponentUI;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GUI extends JPanel implements Runnable, ActionListener{


    public Anagram anagram = new Anagram();
    public Anagramsolver anagramSolver = new Anagramsolver();
    public Countdown countdown;
    public FindWord findWord;

    private static GUI newContentPane;

    private Mode mode = Mode.none;

    private JFrame frame = new JFrame("Text things");

    protected JFormattedTextField textIn;
    protected TextArea textOut;
    protected JButton Go;

    protected JButton create_anagram;
    protected JButton solve_anagram;
    protected JButton solve_countdown;
    protected JButton word_info;

    private static final Insets insets = new Insets(0, 0, 0, 0);

    public String[] Words;

    public GUI(){
        BufferedReader br;
        textOut = new TextArea("Select a mode, and enter a word then press 'Go!'");
        try {
            ArrayList<String> strings = new ArrayList<String>();
            br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/resources/wordsEn.txt")));
            String line = br.readLine();
            while (line != null) {
                strings.add(line);
                line = br.readLine();
            }
            String[] pre = new String[strings.size()];
            Words = strings.toArray(pre);
        }catch (Exception ex){ ex.printStackTrace(); }

        countdown  = new Countdown(Words);
        findWord = new FindWord(Words);

        textOut.setEditable(false);

        textIn = new JFormattedTextField();
        textIn.setPreferredSize(new Dimension(200,25));

        Go = new JButton();
        Go.setText("Go!");
        Go.setHorizontalTextPosition(SwingConstants.CENTER);
        Go.setVerticalTextPosition(SwingConstants.CENTER);
        Go.setActionCommand("Go");
        Go.addActionListener(this);

        create_anagram = new JButton("Create an anagram");
        create_anagram.setActionCommand("create_anagram");
        create_anagram.addActionListener(this);

        solve_anagram = new JButton("Solve an anagram");
        solve_anagram.setActionCommand("solve_anagram");
        solve_anagram.addActionListener(this);

        solve_countdown = new JButton("Solve a Countdown puzzle");
        solve_countdown.setActionCommand("solve_countdown");
        solve_countdown.addActionListener(this);

        word_info = new JButton("Find words");
        word_info.setActionCommand("word_info");
        word_info.addActionListener(this);

        GridBagLayout gridBagLayout = new GridBagLayout();
        frame.setLayout(gridBagLayout);

        addComponent(frame, textOut, 0, 0, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(frame,textIn,0,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        addComponent(frame,Go,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH);

        addComponent(frame,create_anagram,0,2,1,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        addComponent(frame,solve_anagram,1,2,1,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        addComponent(frame,solve_countdown,0,3,1,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        addComponent(frame,word_info,1,3,1,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH);

        frame.setSize(500, 300);
        frame.setIconImage((new ImageIcon(getClass().getResource("/resources/img.png").toString())).getImage());
        try {
            frame.setIconImage(ImageIO.read(new File(getClass().getResource("/resources/img.png").toString())));
        }catch (Exception ex){}

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void addComponent(Container container, Component component, int gridx, int gridy, int gridwidth, int gridheight, int anchor, int fill) {
            GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, 1.0, 1.0, anchor,0, insets, 0, 0);
            container.add(component, gbc);
    }

    public void run(){
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Go")){
            if (mode == Mode.none || textIn.getText().equalsIgnoreCase("")){
                textOut.setText("Sorry, you need to select a mode and enter a word.");
            } else if (mode == Mode.create_anagram){
                textOut.setText("Scrambled word: " + anagram.randomiseString(textIn.getText()));

            } else if (mode == Mode.solve_anagram){
                ArrayList<String> strList = anagramSolver.solve(textIn.getText());
                StringBuilder stringBuilder = new StringBuilder();
                for (String str : strList){
                    stringBuilder.append(str);
                    stringBuilder.append("\n");
                }
                textOut.setText(stringBuilder.toString());
            } else if (mode == Mode.solve_countdown){
                ArrayList<String> strList = countdown.solve(textIn.getText());
                StringBuilder stringBuilder = new StringBuilder();
                for (String str : strList){
                    stringBuilder.append("[").append(str.length()).append("] ").append(str).append("\n");
                }
                textOut.setText(stringBuilder.toString());
            } else if (mode == Mode.word_info){
                ArrayList<String> strList = findWord.getWords(textIn.getText());
                StringBuilder stringBuilder = new StringBuilder();
                for (String str : strList){
                    stringBuilder.append(str);
                    stringBuilder.append("\n");
                }
                textOut.setText(stringBuilder.toString());

            }
        } else if (e.getActionCommand().equalsIgnoreCase("create_anagram")){
            create_anagram.setEnabled(false);
            mode = Mode.create_anagram;
            solve_anagram.setEnabled(true);
            solve_countdown.setEnabled(true);
            word_info.setEnabled(true);
        } else if (e.getActionCommand().equalsIgnoreCase("solve_anagram")){
            solve_anagram.setEnabled(false);
            mode = Mode.solve_anagram;
            create_anagram.setEnabled(true);
            solve_countdown.setEnabled(true);
            word_info.setEnabled(true);
        } else if (e.getActionCommand().equalsIgnoreCase("solve_countdown")){
            solve_countdown.setEnabled(false);
            mode = Mode.solve_countdown;
            create_anagram.setEnabled(true);
            solve_anagram.setEnabled(true);
            word_info.setEnabled(true);
        } else if (e.getActionCommand().equalsIgnoreCase("word_info")){
            word_info.setEnabled(false);
            mode = Mode.word_info;
            create_anagram.setEnabled(true);
            solve_anagram.setEnabled(true);
            solve_countdown.setEnabled(true);
        }
    }

    public Mode getMode(){
        return this.mode;
    }
}
