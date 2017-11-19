package rest.linear.gui;

import org.json.JSONArray;
import org.json.JSONObject;
import rest.linear.sound.SoundParser;

import javax.sound.midi.MidiUnavailableException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * Decodes the received booleans into information for channels and values for notes to be played.
 * After that the information is passed on to the SoundParser for playing.
 */

@Path("/data")
public class JSONParser {
	@POST
	public void getPost(String json){
		try {
			Map<Integer, Boolean[][]> map = parse(json);
			SoundParser.parse(map);
		} catch (MidiUnavailableException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Map<Integer, Boolean[][]> parse(String json) throws IOException {
		
		Map<String,Integer> instrumentColor = new HashMap<>();
		instrumentColor.put("black", 32);  // 32 Guitar Harmonics
		instrumentColor.put("red", 55);  // 55 Synth Choir
		instrumentColor.put("orange", 107);  // 107 Shamisen
		instrumentColor.put("yellow", 113);  // 113 Tinkle Bell
		instrumentColor.put("blue", 118);  // 118 Melodic Tom
		instrumentColor.put("green", 127);  // 127 Applause
		JSONObject obj = new JSONObject(json);
		String objName = null;
		Map<Integer, Boolean[][]> map = new HashMap<>();

		Boolean[][] boolMatr = new Boolean[6][15];

		for (int i = 0; i < obj.names().length(); i++) {
			objName = obj.names().getString(i);

			JSONArray ja = (JSONArray) obj.get(objName);
			for (int j = 0; j < ja.length(); j++) {
				JSONArray ja2 = (JSONArray) ja.get(j);
				
				for (int k = 0; k < ja2.length(); k++) {
					System.out.println(ja2.get(k));
					boolMatr[j][k] = (Boolean) ja2.get(k);
				}
				map.put(instrumentColor.get(objName), boolMatr);
			}
		}
		return map;
	}

}
