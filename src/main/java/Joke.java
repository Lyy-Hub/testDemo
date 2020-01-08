
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;

/**
 * @author Lightcolour
 */
public class Joke {

    private JFrame frmLightcolour;
    private JTextField mthing;
    private JLabel label_1;
    private JTextField mman;
    private JLabel label_2;
    private JTextField mtheory;
    private JLabel label_3;
    private JTextField mvictim;
    private JLabel label_4;
    private JTextField mrange;
    Random random = new Random();
    private JTextArea joke;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Joke window = new Joke();
                    window.frmLightcolour.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Joke() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmLightcolour = new JFrame();
        frmLightcolour.setTitle("苏联笑话生成器 Lightcolour");
        frmLightcolour.setBounds(100, 100, 600, 632);
        frmLightcolour.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLightcolour.getContentPane().setLayout(null);

        JLabel label = new JLabel("讽刺的事情是？");
        label.setBounds(46, 102, 179, 21);
        frmLightcolour.getContentPane().add(label);

        mthing = new JTextField();
        mthing.setText("996");
        mthing.setBounds(46, 135, 182, 23);
        frmLightcolour.getContentPane().add(mthing);
        mthing.setColumns(10);

        label_1 = new JLabel("这件事是谁提出来的？");
        label_1.setBounds(46, 166, 179, 21);
        frmLightcolour.getContentPane().add(label_1);

        mman = new JTextField();
        mman.setText("强东哥");
        mman.setColumns(10);
        mman.setBounds(46, 199, 182, 23);
        frmLightcolour.getContentPane().add(mman);

        label_2 = new JLabel("提出者声称这件事有助于什么？");
        label_2.setBounds(46, 232, 179, 21);
        frmLightcolour.getContentPane().add(label_2);

        mtheory = new JTextField();
        mtheory.setText("建设一流公司");
        mtheory.setColumns(10);
        mtheory.setBounds(46, 265, 182, 23);
        frmLightcolour.getContentPane().add(mtheory);

        label_3 = new JLabel("这件事针对的是哪些人？");
        label_3.setBounds(46, 298, 179, 21);
        frmLightcolour.getContentPane().add(label_3);

        mvictim = new JTextField();
        mvictim.setText("程序员");
        mvictim.setColumns(10);
        mvictim.setBounds(46, 331, 182, 23);
        frmLightcolour.getContentPane().add(mvictim);

        label_4 = new JLabel("这件事起作用的范围？");
        label_4.setBounds(46, 364, 179, 21);
        frmLightcolour.getContentPane().add(label_4);

        mrange = new JTextField();
        mrange.setText("公司");
        mrange.setColumns(10);
        mrange.setBounds(46, 397, 182, 23);
        frmLightcolour.getContentPane().add(mrange);

        JButton button = new JButton("生成");

        button.setBounds(83, 472, 93, 23);
        frmLightcolour.getContentPane().add(button);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(241, 104, 333, 281);
        frmLightcolour.getContentPane().add(scrollPane);

        joke = new JTextArea();
        scrollPane.setViewportView(joke);

        JLabel label_5 = new JLabel("笑话生成器");
        label_5.setHorizontalAlignment(SwingConstants.CENTER);
        label_5.setFont(new Font("微软雅黑", Font.PLAIN, 28));
        label_5.setBounds(61, 20, 454, 63);
        frmLightcolour.getContentPane().add(label_5);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<String> jokelist = new ArrayList();
                jokelist.add("\n在" + mrange.getText() + "庆典的聚会上，一位35岁的" + mvictim.getText() + "高举着牌子，上面写着“感谢" + mthing.getText() + "赐予我的快乐的童年”。\n\n" + mman.getText() + "呵斥道，“你是在嘲讽" + mthing.getText() + "吗？" + mthing.getText() + "才实行了20年。”\n\n“确切地说，这正是我感谢它的原因。”\n\n");
                jokelist.add("\n" + mman.getText() + "发言道：“从下个礼拜开始我们要做两件事，一，全面在" + mrange.getText() + "实行" + mthing.getText() + "；二，周六所有" + mvictim.getText() + "都要去酒吧里拿一条蜥蜴。大家有什么意见可以提出来。”\n\n过了一会儿，台下有个声音怯生生地提问：“为什么要拿蜥蜴？”\n\n“很好，我就知道大家对" + mthing.getText() + "没有异议。”\n\n");
                jokelist.add("\n“" + mthing.getText() + "真**的智障！”\n\n“你涉嫌恶意攻击" + mman.getText() + ",跟我走一趟。”\n\n“我又没说是哪里的" + mthing.getText() + "！”\n\n“废话！哪里的" + mthing.getText() + "智障我会不知道吗！”\n\n");
                jokelist.add("\n" + mman.getText() + "在向" + mvictim.getText() + "们讲话：\n\n“很快我们就能" + mtheory.getText() + "！”\n\n台下传来一个声音：“那我们怎么办？”\n\n");
                jokelist.add("\n一个" + mvictim.getText() + "的鹦鹉丢了。这是只会说话的鹦鹉，要是落到" + mman.getText() + "的手里可糟了。\n\n这人便发表了一篇声明：“本人遗失鹦鹉一只，另外，本人不同意它关于" + mthing.getText() + "的观点。”\n\n");
                jokelist.add("\n“" + mthing.getText() + "是艺术还是科学?”\n\n”我说不好，但肯定不是科学。”\n\n“何以见得?”\n\n“如果" + mthing.getText() + "是科学的话，他们至少应该先用小白鼠做实验。”\n\n");
                jokelist.add("\n大会主持人:”请支持" + mthing.getText() + "的人坐在左边，反对" + mthing.getText() + "的坐在右边。”\n\n大多数人坐在了右边，少数人坐在了左边，只有一个人坐在中间纹丝不动。\n\n主持人很不解，询问情况。\n\n“我对" + mvictim.getText() + "们的情况表示十分理解，但我支持" + mthing.getText() + "。”\n\n”那您赶快坐到主席台来。”主持人急忙说道。\n\n");
                jokelist.add("\n" + mman.getText() + "关于“关爱" + mvictim.getText() + " 支持" + mthing.getText() + "”的会议纪要正在以超光速增长，但这并没有违背相对论，因为会议纪要里不含有任何信息。\n\n");
                jokelist.add("\n" + mman.getText() + ":“我们要不惜一切代价，为了我们的主人翁" + mtheory.getText() + "！”\n\n一个" + mvictim.getText() + "对另一个" + mvictim.getText() + "说:“看哪 ，" + mman.getText() + "把咱们当主人翁。”\n\n另一个" + mvictim.getText() + "说:“不，我们是‘代价’。”\n\n");
                jokelist.add("\n“如果你在" + mrange.getText() + "，旁边一个陌生人突然开始唉声叹气，正确的做法是什么?”\n\n“立即阻止这种反对" + mthing.getText() + "的行为。”\n\n");
                jokelist.add("\n" + mman.getText() + ":“由于" + mthing.getText() + "的实行，各位" + mvictim.getText() + "的美好未来前景已经出现在了地平线上。”\n\n一个" + mvictim.getText() + "问另一个" + mvictim.getText() + ":”什么是地平线?”\n\n另一个" + mvictim.getText() + "回答道:“就是那个能看到但是永远都到不了的线。”\n\n");
                jokelist.add("\n" + mman.getText() + "在" + mrange.getText() + "随机采访了一位" + mvictim.getText() + ":“请问你对" + mthing.getText() + "有什么意见吗?”\n\n" + mvictim.getText() + "答道:“我有一些意见，但我不同意我的意见!”\n\n");
                jokelist.add("\n两个骷髅相遇，一骷髅问另一个骷髅:“我是被" + mman.getText() + "的" + mthing.getText() + "逼死的，你是怎么死的？”\n\n另一个骷髅回答说:“我还活着。”\n\n");
                jokelist.add("\n" + mman.getText() + "的汽车被一头牛挡住了，怎么也赶不走。" + mman.getText() + "便下车对牛说：“你再不走，我就把你送到" + mrange.getText() + "去" + mthing.getText() + "。”牛听了便一溜烟的跑开了。\n\n");
                jokelist.add("\n问：“" + mthing.getText() + "的优越之处是什么？”\n\n答：“成功克服了那些其他情况下不会存在的困难。”\n\n");
                jokelist.add("\n问：“" + mthing.getText() + "在哪些时候会遇到抵制？”\n\n答：“主要有四个时间段：春天、夏天、秋天和冬天。”\n\n");
                jokelist.add("\n" + mman.getText() + "问一名" + mvictim.getText() + ":“你的爸爸是谁？”\n\n他回答说：“是" + mman.getText() + "!”\n\n" + mman.getText() + "很满意，又问：“你的母亲是谁？”\n\n他回答：“是" + mthing.getText() + "！”\n\n" + mman.getText() + "又问：“你将来想当什么？”\n\n“孤儿！”\n\n");
                jokelist.add("\n问：“那些别有用心的人是怎样黑" + mthing.getText() + "的？”\n\n答：“他们把" + mman.getText() + "说的内容原文复述了。”\n\n");
                jokelist.add("\n问：“为什么" + mman.getText() + "把" + mvictim.getText() + "放在中心考虑？”\n\n答：“这样从各个方向都能方便地欺压他们。”\n\n");
                jokelist.add("\n问：“什么叫交换意见？”\n\n答：“带着你的意见去找" + mman.getText() + "理论，然后带着他的回来。”\n\n");
                jokelist.add("\n问：“" + mthing.getText() + "实行的结果如何？”\n\n答：“还是有人活下来了。”\n\n");
                jokelist.add("\n问：“" + mthing.getText() + "的前景是什么？”\n\n答：“有两种可能的情况。现实的可能是火星人会降临地球帮我们打理一切，科幻的可能是我们成功地" + mtheory.getText() + "。”\n\n");
                joke.setText(jokelist.get(random.nextInt(jokelist.size())));

            }
        });


    }
}
