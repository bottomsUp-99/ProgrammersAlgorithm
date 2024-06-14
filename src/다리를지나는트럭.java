public class 다리를지나는트럭 {
    import java.util.*;
    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int time = 0;
            int weightSum = 0;
            Queue<Integer> onTheBridge = new LinkedList<>();
            for(int truck : truck_weights){
                while(true){
                    if(onTheBridge.isEmpty()){
                        onTheBridge.offer(truck);
                        weightSum += truck;
                        time++;
                        break;
                    }else if(onTheBridge.size() == bridge_length){
                        weightSum -= onTheBridge.poll();
                    }else{
                        if(weightSum + truck<=weight){
                            onTheBridge.offer(truck);
                            weightSum +=truck;
                            time++;
                            break;
                        }else{
                            onTheBridge.offer(0);
                            time++;
                        }
                    }
                }
            }
            return time+bridge_length;
        }
    }
}
