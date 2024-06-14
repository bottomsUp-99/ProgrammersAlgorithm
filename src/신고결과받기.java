public class 신고결과받기 {
    import java.util.*;
    class Solution{
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] return_mail = new int[id_list.length];
            for(int i = 0 ; i < return_mail.length ; i++){
                return_mail[i] = 0;
            }
            HashMap<String, HashSet<String>> reported_map = new HashMap<>();
            HashMap<String, Integer> id_map = new HashMap<>();
            for(int i = 0 ; i < id_list.length ; i ++){
                id_map.put(id_list[i], i);
                reported_map.put(id_list[i], new HashSet <String>() );
            }
            for(String str : report){
                String[] s = str.split(" ");
                reported_map.get(s[1]).add(s[0]);
            }
            for(int i = 0 ; i < id_list.length ; i++){
                HashSet<String> reported_set = reported_map.get(id_list[i]);
                if(reported_set.size() >= k){
                    for(String user : reported_set){
                        return_mail[id_map.get(user)]++;
                    }
                }
            }
            return return_mail;
        }
    }
}
