package com.sillyhat.main;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class EmailTask extends SwingWorker<Void, Void> {
	@Override
	public Void doInBackground() {
		System.out.println("doInBackground");
		Random random = new Random();
		int progress = 0;
		setProgress(0);
		try {
			Thread.sleep(1000);
			while (progress < 100 && !isCancelled()) {
				Thread.sleep(random.nextInt(1000));
				progress += random.nextInt(10);
				setProgress(Math.min(progress, 100));
			}
		} catch (InterruptedException ignore) {
			
		}
		return null;
	}

	@Override
	public void done() {
		System.out.println("done");
		Toolkit.getDefaultToolkit().beep();
		// startButton.setEnabled(true);
		// progressMonitor.setProgress(0);
	}
}
