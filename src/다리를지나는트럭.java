import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        System.out.println(solution(bridge_length, weight, truck_weights));
    }
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0; //경과시간
        int weightSum = 0; //다리에 올라가 있는 트럭의 무게 합
        Queue<Integer> onTheBridge = new LinkedList<>();
        for (int truck : truck_weights) {
            while (true) {
                if (onTheBridge.isEmpty()) {//다리에 트럭이 없을 경우에는 시간 1초 증가 및 트럭 무게에 합산
                    onTheBridge.add(truck);
                    weightSum += truck;
                    time++;
                    break;
                } else if (onTheBridge.size() == bridge_length) {//꽉 차있는 경우에는 다리에서 맨 앞 트럭 빼주고 총무게에서도 빼준다.
                    weightSum -= onTheBridge.poll();
                } else {//꽉 차있지 않은 경우
                    if (weightSum + truck <= weight) {//트럭이 하나 더 올라가려는데 무게가 초과하지 않은 경우
                        onTheBridge.offer(truck);
                        weightSum += truck;
                        time++;
                        break;
                    } else {//트럭이 하나 더 올라가려는데 무게가 초과한 경우
                        onTheBridge.offer(0);
                        time++;
                    }
                }
            }
        }
        return time + bridge_length;//아직 트럭이 올라갔을 뿐이지, 다리를 온전히 지나가지 못했으므로 트럭이 건너려고 하는 시간(다리의 길이) 더해줌
    }
}