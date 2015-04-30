package waitlist;

import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JFrame;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BoxView;
import javax.swing.text.ComponentView;
import javax.swing.text.Element;
import javax.swing.text.IconView;
import javax.swing.text.LabelView;
import javax.swing.text.ParagraphView;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;

import advising.Student;
import advising.StudentInterface;

/**
 * This class sets up the waitlist dispaly form.
 * 
 * @author Matthew Kliewer
 *
 */
public class WaitlistView extends JFrame implements WaitlistViewInterface {
	
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JScrollPane jScrollPane6;
    private JScrollPane jScrollPane7;
    private JScrollPane jScrollPane8;
    private MJTextPane jTextPane1;
    private MJTextPane jTextPane2;
    private MJTextPane jTextPane3;
    private MJTextPane jTextPane4;
    private MJTextPane jTextPane5;
    private MJTextPane jTextPane6;
    private MJTextPane jTextPane7;
    private MJTextPane jTextPane8;
    private SimpleAttributeSet center;
    private int total[];
    
    /**
     * Constructor. Setup all the various components.
     * 
     */
    public WaitlistView() {
    	super("Advising Waitlist");

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jScrollPane2 = new JScrollPane();
        jScrollPane3 = new JScrollPane();
        jScrollPane4 = new JScrollPane();
        jScrollPane5 = new JScrollPane();     
        jScrollPane6 = new JScrollPane();       
        jScrollPane7 = new JScrollPane();      
        jScrollPane8 = new JScrollPane();
        jTextPane1 = new MJTextPane();
        jTextPane2 = new MJTextPane();
        jTextPane3 = new MJTextPane();
        jTextPane4 = new MJTextPane();
        jTextPane5 = new MJTextPane();
        jTextPane6 = new MJTextPane();
        jTextPane7 = new MJTextPane();
        jTextPane8 = new MJTextPane();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 370));
        this.center = new SimpleAttributeSet();
        StyleConstants.setAlignment(this.center, StyleConstants.ALIGN_CENTER);
        
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14));
        jLabel1.setText("Advising Center Waitlist");
        jLabel2.setText("Appointments");
        jLabel3.setText("Walk-ins");
        
       
        setUpTextPane(jTextPane1,jScrollPane1);
        setUpTextPane(jTextPane2,jScrollPane2);
        setUpTextPane(jTextPane3,jScrollPane3);
        setUpTextPane(jTextPane4,jScrollPane4);
        setUpTextPane(jTextPane5,jScrollPane5);
        setUpTextPane(jTextPane6,jScrollPane6);
        setUpTextPane(jTextPane7,jScrollPane7);
        setUpTextPane(jTextPane8,jScrollPane8);
        jTextPane1.setMinimumSize(new java.awt.Dimension(176, 36));
        jTextPane2.setMinimumSize(new java.awt.Dimension(176, 36));
        jTextPane3.setMinimumSize(new java.awt.Dimension(176, 36));
        jTextPane4.setMinimumSize(new java.awt.Dimension(176, 36));
        jTextPane5.setMinimumSize(new java.awt.Dimension(176, 36));
        jTextPane6.setMinimumSize(new java.awt.Dimension(176, 36));
        jTextPane7.setMinimumSize(new java.awt.Dimension(176, 36));
        jTextPane8.setMinimumSize(new java.awt.Dimension(176, 36));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(179, 39));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(179, 39));
        jScrollPane3.setMinimumSize(new java.awt.Dimension(179, 39));
        jScrollPane4.setMinimumSize(new java.awt.Dimension(179, 39));
        jScrollPane5.setMinimumSize(new java.awt.Dimension(179, 39));
        jScrollPane6.setMinimumSize(new java.awt.Dimension(179, 39));
        jScrollPane7.setMinimumSize(new java.awt.Dimension(179, 39));
        jScrollPane8.setMinimumSize(new java.awt.Dimension(179, 39));
        
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane4))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8)
                    .addComponent(jScrollPane7)
                    .addComponent(jScrollPane6)))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane6, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7)
                    .addComponent(jScrollPane3, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane8, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)))
        );
        pack();
        
    }
    
    /**
     * This function sets up the text panes. The text to be displayed will be added in another function.
     * 
     * @param pane
     * @param spane
     */
    private void setUpTextPane(MJTextPane pane, JScrollPane spane) {
    	pane.setEditorKit(new MyEditorKit());
    	StyledDocument doc = pane.getStyledDocument();
    	doc.setParagraphAttributes(0, doc.getLength(), this.center, false);
    	pane.setMinimumSize(new Dimension(176, 36));
        pane.setEditable(false);
        pane.setFont(new java.awt.Font("Dialog", 1, 12));
        pane.setFocusable(false);
        
        spane.setMinimumSize(new Dimension(179, 39));
        spane.setViewportView(pane);
    }
    
    /* (non-Javadoc)
	 * @see waitlist.WaitlistViewInterface#addAppointments(java.util.ArrayList)
	 */
    @Override
	public void addAppointments(ArrayList<Student> appts) {
    	total = new int[2];
    	total[0] = 0;
    	total[1] = 0;
    	MJTextPane[][] panes = new MJTextPane[2][4];
    	panes[0][0] = jTextPane1;
    	panes[0][1] = jTextPane2;
    	panes[0][2] = jTextPane3;
    	panes[0][3] = jTextPane4;
    	panes[1][0] = jTextPane5;
    	panes[1][1] = jTextPane6;
    	panes[1][2] = jTextPane7;
    	panes[1][3] = jTextPane8;
    	
    	for(StudentInterface student: appts) {
    		if(student.isWaitlist()) {
    			if(total[1]<4) {
    				panes[1][total[1]].setText(student.getFName()+" "+student.getLName());
    				panes[1][total[1]].setID(student.getBanner());
    				panes[1][total[1]].setWL(student.isWaitlist());
    				
    				total[1]++;
    			}
    		} else {
    			if(total[0]<4) {
    				panes[0][total[0]].setText(student.getFName()+" "+student.getLName()
    						+"\n"+student.getDay()+", "+student.getTime());
    				panes[0][total[0]].setID(student.getBanner());
    				panes[0][total[0]].setWL(student.isWaitlist());
    				total[0]++;
    			}
    		}
    	}
    	this.repaint();
    }
    
    /* (non-Javadoc)
	 * @see waitlist.WaitlistViewInterface#clearAppointments()
	 */
    @Override
	public void clearAppointments() {
    	jTextPane1.setText("");
    	jTextPane2.setText("");
    	jTextPane3.setText("");
    	jTextPane4.setText("");
    	jTextPane5.setText("");
    	jTextPane6.setText("");
    	jTextPane7.setText("");
    	jTextPane8.setText("");
    }
    
    
    /* (non-Javadoc)
	 * @see waitlist.WaitlistViewInterface#setMouseListener(waitlist.WaitlistController)
	 */
    @Override
	public void setMouseListener(WaitlistControllerInterface cntrl) {
    	WaitlistController controller = (WaitlistController) cntrl;
    	jTextPane1.addMouseListener(controller);
    	jTextPane2.addMouseListener(controller);
    	jTextPane3.addMouseListener(controller);
    	jTextPane4.addMouseListener(controller);
    	jTextPane5.addMouseListener(controller);
    	jTextPane6.addMouseListener(controller);
    	jTextPane7.addMouseListener(controller);
    	jTextPane8.addMouseListener(controller);
    }
    

}

/**
 * This class enables vertical text alignment in the JTextPane
 * 
 * @author Matthew Kliewer
 *
 */
class MyEditorKit extends StyledEditorKit {

	/**
	 * Returns a ViewFactory
	 */
    public ViewFactory getViewFactory() {
        return new StyledViewFactory();
    }
    
    /**
     * Implements the ViewFactory interface
     * 
     * @author Matthew Kliewer
     */
    static class StyledViewFactory implements ViewFactory {

    	/**
    	 * Create thew
    	 */
        public View create(Element elem) {
            String kind = elem.getName();
            if (kind != null) {
                if (kind.equals(AbstractDocument.ContentElementName)) {
                    return new LabelView(elem);
                } else if (kind.equals(AbstractDocument.ParagraphElementName)) {
                    return new ParagraphView(elem);
                } else if (kind.equals(AbstractDocument.SectionElementName)) {

                    return new CenteredBoxView(elem, View.Y_AXIS);
                } else if (kind.equals(StyleConstants.ComponentElementName)) {
                    return new ComponentView(elem);
                } else if (kind.equals(StyleConstants.IconElementName)) {

                    return new IconView(elem);
                }
            }
 
            return new LabelView(elem);
        }

    }
}

/**
 * This class enables vertical text alignment in the JTextPane
 * 
 * @author Matthew Kliewer
 *
 */
class CenteredBoxView extends BoxView {
	/** 
	 * Contrustor
	 * 
	 * @param elem
	 * @param axis
	 */
    public CenteredBoxView(Element elem, int axis) {
        super(elem,axis);
    }
    
    /**
     * Determine text high in JTextPane
     */
    protected void layoutMajorAxis(int targetSpan, int axis, int[] offsets, int[] spans) {
        super.layoutMajorAxis(targetSpan,axis,offsets,spans);
        int textBlockHeight = 0;
        int offset = 0;
        for (int i = 0; i < spans.length; i++) {
            textBlockHeight = spans[i];
        }
        offset = (targetSpan - textBlockHeight) / 3;
        for (int i = 0; i < offsets.length; i++) {
            offsets[i] += offset;
        }

    }
}   


