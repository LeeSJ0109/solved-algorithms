import java.util.*;

class Solution {
    
    static class Song implements Comparable<Song> {
        int index;
        int play;

        Song(int index, int play) {
            this.index = index;
            this.play = play;
        }
        
        @Override
        public int compareTo(Song o) {
            if (this.play == o.play) {
                // 재생 횟수 같으면 고유 번호가 낮은 노래를 먼저
                return this.index - o.index;
            }
            
            return o.play - this.play; // 많이 재생된 노래 먼저
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        int N = genres.length;
        
        Map<String, Integer> genrePlayCount = new HashMap<>(); // 장르별 재생된 횟수
        Map<String, PriorityQueue<Song>> genreSongs = new HashMap<>(); // 장르별 구분
        
        for (int i = 0; i < N; i++) {
            int play = plays[i];
            String genre = genres[i];
            
            if (genrePlayCount.containsKey(genre)) {
                genrePlayCount.put(genre, genrePlayCount.get(genre) + play);
            }
            else {
                genrePlayCount.put(genre, play);
                genreSongs.put(genre, new PriorityQueue<>());
            }
            
            genreSongs.get(genre).add(new Song(i, play));
        }
        
        // 장르별 재생된 횟수 기준 정렬
        List<String> genreList = new ArrayList<>(genrePlayCount.keySet());
        genreList.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));
        
        List<Integer> answerList = new ArrayList<>();

        for (String genre : genreList) {
            PriorityQueue<Song> pq = genreSongs.get(genre);
            
            int count = 0;
            while(!pq.isEmpty() && count < 2) {
                answerList.add(pq.poll().index);
                count++;
            }
        }
        
        int size = answerList.size();
        int[] answer = new int[size];
        
        for (int s = 0; s < size; s++) {
            answer[s] = answerList.get(s);
        }
        
        return answer;
    }
}