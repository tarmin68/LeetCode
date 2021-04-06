class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int N = position.length;
        if(N == 0) return 0;
        
        Car[] allCars = new Car[N];
        for(int i = 0; i < N; i++){
            allCars[i] = new Car(position[i], (double) (target - position[i]) / speed[i]);
        }
        
        Arrays.sort(allCars, (a,b) -> Integer.compare(a.position, b.position));
        
        int ans = 0;
        int i = N - 1;
        while(i > 0){
            if(allCars[i].aTime < allCars[i - 1].aTime)
                ans++;
            else{
                allCars[i - 1] = allCars[i];
            }
            i--;
        }
        
        return ans + 1;
    }
    
    public class Car{
        int position;
        double aTime;
        
        Car(int position, double aTime){
            this.position = position;
            this.aTime = aTime;
        }
    }
}