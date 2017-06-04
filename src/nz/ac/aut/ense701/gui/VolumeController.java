/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gui;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;

/**
 *
 * @author Near
 */
public class VolumeController {
    /*
        This method is used to set the system volume by using the value from GUI's slider
    */
    public static void setOutputVolume(float value) {
		try {
			Mixer.Info[] mixers = AudioSystem.getMixerInfo();
			for (Mixer.Info mixerInfo : mixers) {
				Mixer mixer = AudioSystem.getMixer(mixerInfo);
				Line.Info[] lineInfos = mixer.getTargetLineInfo();

				// changes all the volumes
				for (Line.Info lineInfo : lineInfos) {
					Line line = null;
					boolean opened = true;
					try {
						line = mixer.getLine(lineInfo);
						opened = line.isOpen() || line instanceof Clip;
						if (!opened) {
							line.open();
						}
						FloatControl volCtrl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);
						volCtrl.setValue((float) value/10);
					} catch (LineUnavailableException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException iaEx) {
					} finally {
						if (line != null && !opened) {
							line.close();
						}
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
