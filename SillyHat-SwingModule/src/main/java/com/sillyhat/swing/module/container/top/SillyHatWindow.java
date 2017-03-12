package com.sillyhat.swing.module.container.top;

import com.sillyhat.swing.dto.LocationDTO;
import com.sillyhat.swing.module.basic.SillyHatJMenuBar;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;

/** 
 * @ClassName: SillyHatWindow 
 * @Description: 底层窗口
 * @author XUSHIKUAN642
 * @date 2016-11-17 下午2:20:15  
 */ 
public class SillyHatWindow extends JFrame{

	/** 
	 * @Fields serialVersionUID : TODO 
	 */ 
	private static final long serialVersionUID = 1251874788575398317L;

	private Logger logger = Logger.getLogger(SillyHatWindow.class);
	
	private String titleName;
	
	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
		setTitle(titleName);
	}

	public SillyHatWindow(){
		initSillyHatWindow("");
	}
	
	public SillyHatWindow(String titleName){
		initSillyHatWindow(titleName);
	}
	
	private void initSillyHatWindow(String titleName){
		setTitleName(titleName);
	}
	
	/**
	 * <p>Title: setTopJMenuBar</p>
	 * <p>Description: </p>添加顶级菜单
	 * @param jMenuBar
	 * @author XUSHIKUAN642
	 * @date 2016-11-17
	 */
	public void setTopJMenuBar(SillyHatJMenuBar jMenuBar){
		setJMenuBar(jMenuBar);
	}
	
	/**
	 * <p>Title: setWindowSize</p>
	 * <p>Description: </p>设置窗口大小
	 * @param width		窗口宽度
	 * @param height	窗口高度
	 * @author XUSHIKUAN642
	 * @date 2016-11-17
	 */
	public void setWindowSize(int width,int height){
		setSize(width,height);
	}

	/**
	 * <p>Title: setWindowLocation</p>
	 * <p>Description: </p>设置窗体位置(要处于setWindowSize下方，否则窗体左上角位于中间)
	 * @param location
	 * @author XUSHIKUAN642
	 * @date 2016-11-17
	 */
	public void setWindowLocation(LocationDTO dto){
		if(null == dto){
			setLocationRelativeTo(null);
		}else{
			setWindowLocation(dto.getWidth(), dto.getHeight());
		}
	}
	
	/**
	 * <p>Title: setWindowLocation</p>
	 * <p>Description: </p>设置窗体位置(要处于setWindowSize下方，否则窗体左上角位于中间)
	 * @param width		x轴长度
	 * @param height	y轴高度
	 * @author XUSHIKUAN642
	 * @date 2016-11-17
	 */
	public void setWindowLocation(int width,int height){
		setLocation(width, height);
	}
	
	public void setborderLayoutNorth(Container container){
		getContentPane().add(container, BorderLayout.NORTH);
	}
	
	public void setborderLayoutEast(Container container){
		getContentPane().add(container, BorderLayout.EAST);
	}
	
	public void setborderLayoutCenter(Container container){
		getContentPane().add(container, BorderLayout.CENTER);
	}
	
	public void setborderLayoutSouth(Container container){
		getContentPane().add(container, BorderLayout.SOUTH);
	}
	
	public void setborderLayoutWest(Container container){
		getContentPane().add(container, BorderLayout.WEST);
	}
	
	/**
	 * <p>Title: openWindow</p>
	 * <p>Description: </p>打开窗口
	 * @author XUSHIKUAN642
	 * @date 2016-11-17
	 */
	public void openWindow(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
