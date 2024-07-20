public class 붕대감기 {

  public static void main(String[] args) {
    int[] bandage = {5, 1, 5};
    int health = 30;
    int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
    System.out.println(solution(bandage, health, attacks));
  }
  public static int solution(int[] bandage, int health, int[][] attacks) {
    int maxHealth = health;
    int finishAttackTime = attacks[attacks.length - 1][0];
    int attacksIndex = 0;
    int bandageTime = 0;
    for (int i = 0; i <= finishAttackTime; i++) {
      if (i == attacks[attacksIndex][0]){//공격을 받을 경우
        bandageTime = 0;
        health -= attacks[attacksIndex][1];
        if (health <= 0){
          return -1;
        }
        attacksIndex++;
      } else {//공격을 안 받을 경우
        health+= bandage[1];
        bandageTime++;
        if (bandageTime == bandage[0]){
          health += bandage[2];
          bandageTime = 0;
        }
        if (health > maxHealth) health = 30;
      }
    }
    return health;
  }
}
