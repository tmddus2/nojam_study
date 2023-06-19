package programmers;
import java.util.*;

public class 방금그곡 {
    class Solution {
        public String solution(String m, String[] musicinfos) {
            String answer = "";
            int time = 0;
            for(String s : musicinfos) {
                HashMap<String, Song> result = playMusic(s);
                for (Map.Entry<String, Song> entrySet : result.entrySet()) {
                    if(isDuplication(m, entrySet.getValue().song)) {
                        if (time < entrySet.getValue().totalMin) {
                            answer = entrySet.getKey();
                            time = entrySet.getValue().totalMin;
                        }
                    }
                }
            }
            if (answer.equals("")) {
                return "(None)";
            }
            return answer;
        }

        public ArrayList<String> parseMusic(String music) {
            ArrayList<String> m = new ArrayList<>();
            for(int i=0; i<music.length(); i++) {
                if (i == music.length()-1) {
                    m.add(String.valueOf(music.charAt(i)));
                    continue;
                }
                if (music.charAt(i+1) == '#') {
                    m.add(music.substring(i,i+2));
                    i++;
                } else {
                    m.add(String.valueOf(music.charAt(i)));
                }
            }
            return m;
        }

        public HashMap<String, Song> playMusic(String music) {
            HashMap<String, Song> musics = new HashMap<>();
            String[] info = music.split(",");
            String[] startTime = info[0].split(":");
            String[] endTime = info[1].split(":");
            String title = info[2];
            String song = info[3];
            ArrayList<String> parsedMusic = parseMusic(song);
            ArrayList<String> finalSong = new ArrayList<>();
            int totalMin = calMinute(startTime, endTime);
            if (totalMin < parsedMusic.size()) {
                for(int i=0; i<totalMin; i++) {
                    finalSong.add(parsedMusic.get(i));
                }
            } else {
                for(int i=0; i<totalMin; i++) {
                    finalSong.add(parsedMusic.get(i%parsedMusic.size()));
                }
            }
            musics.put(title, new Song(finalSong, totalMin));
            return musics;
        }

        public int calMinute(String[] startTime, String[] endTime) {
            int startH = Integer.parseInt(startTime[0]);
            int startM = Integer.parseInt(startTime[1]);
            int endH = Integer.parseInt(endTime[0]);
            int endM = Integer.parseInt(endTime[1]);
            if (startH == endH) {
                return endM - startM;
            }
            return (endH - startH)*60 + (endM - startM);
        }

        public boolean isDuplication(String m, ArrayList<String> music) {
            int num = 0;
            String combinedmusic = "";
            for(String mm : music) {
                combinedmusic = combinedmusic+mm+"/";
            }
            ArrayList<String> pm = parseMusic(m);
            m = "";
            for(String mm : pm) {
                m = m+mm+"/";
            }
            if (!combinedmusic.contains(m)) {
                return false;
            }
            return true;
        }
    }

    class Song {
        ArrayList<String> song;
        int totalMin;

        public Song(ArrayList<String> song, int totalMin) {
            this.song = song;
            this.totalMin = totalMin;
        }
    }
}
