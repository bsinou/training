package net.sinou.sandbox.javafx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.collections.ObservableMap;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/** Simply read a sound media file with javaFX */
public class JavaFxSoundReader {
	private final static Logger logger = LoggerFactory.getLogger(JavaFxSoundReader.class);

	public void simplePlay(String uriString) {
		try {
			Media media = new Media(uriString);
			MediaPlayer player = new MediaPlayer(media);
			player.play();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void printInfo(String filename, String uriString) {
		try {
			System.out.println("=== Printing info for " + uriString);
			Media media = new Media(uriString);
			ObservableMap<String, Object> map = media.getMetadata();
			System.out.println("MetaData size: " + map.size());
			map.forEach((k, v) -> System.out.println(k + " - " + v.toString()));
			ObservableMap<String, Duration> markers = media.getMarkers();
			System.out.println("Markers size: " + markers.size());
			markers.forEach((k, v) -> System.out.println(k + " - " + v.toString()));
		} catch (Exception e) {
			logger.error("Cannot print info for " + filename + " (" + uriString + ")", e);
		}
	}
}
