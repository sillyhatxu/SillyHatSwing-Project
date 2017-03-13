package com.sillyhat.business.backups.listener;

import com.sillyhat.swing.module.container.middle.ModulePanel;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InnerWindowListener implements ActionListener{

	private ModulePanel modulePanel;
	
	public InnerWindowListener(ModulePanel modulePanel){
		this.modulePanel = modulePanel;
	}
	
	final JPanel opPane = new JPanel();
	
	public void actionPerformed(ActionEvent e) {
		InnerFrame iFrame = new InnerFrame(); 
//        windowDialog.add(iFrame);
        iFrame.setVisible(true);
//        System.out.println(windowDialog.getComponentCount());
	}
	
	/** 
     * The Class InnerFrame. 
     */ 
    class InnerFrame extends JInternalFrame {
   
      /** The is hidden. */ 
      boolean isHidden = false; 
   
      /** The old ui. */ 
      BasicInternalFrameUI oldUi = null; 
   
      /** 
       * Instantiates a new inner frame. 
       */ 
      public InnerFrame() { 
          oldUi = (BasicInternalFrameUI)getUI();
          setSize(200, 200); 
          maximizable = true; 
          closable = true; 
//          addComponentListener(new ComponentAdapter() { 
//              public void componentResized(ComponentEvent e) { 
//                  InnerFrame selectedFrame = (InnerFrame)e.getSource(); 
//                  if(selectedFrame.isMaximum()){ 
//                      selectedFrame.hideNorthPanel(); 
//                      opPane.setVisible(true); 
//                      try { 
//                           selectedFrame.setMaximum(true); 
//                      } catch (PropertyVetoException ex) { 
//                           ex.printStackTrace(); 
//                       } 
//                   } 
//               } 
//          }); 
      } 
   
      /** 
       * Hide north panel. 
       */ 
      public void hideNorthPanel(){ 
          ((BasicInternalFrameUI) this.getUI()).setNorthPane(null); 
          this.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE); 
          isHidden = true; 
      } 
   
      /** 
       * Show north panel. 
       */ 
      public void showNorthPanel() { 
          this.setUI(oldUi); 
          this.putClientProperty("JInternalFrame.isPalette", Boolean.FALSE); 
          isHidden = false; 
      } 
   
      /* (non-Javadoc) 
       * @see javax.swing.JInternalFrame#updateUI() 
       */ 
      public void updateUI() { 
          super.updateUI(); 
          if (isHidden) { 
              hideNorthPanel(); 
          } 
       } 
    }
}
