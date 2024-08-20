import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1183 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 물건의 가격 W
		int W = Integer.parseInt(br.readLine());
		
		// 동전의 가치
		int[] coinValues = {500, 100, 50, 10, 5, 1};
		
		// 동전의 개수
		int[] coinCounts = new int[6];
		
		// 전체 동전 개수, 만들 수 있는 최대 가치
        int totalCoins = 0;
        int maxValue = 0;
        
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 6; i++) {
			coinCounts[i] = Integer.parseInt(st.nextToken());
			totalCoins += coinCounts[i];
			maxValue += coinValues[i] * coinCounts[i];
		}
		
		// 목표 가치: 만들 수 있는 최대 가치 - 물건의 가격
		int targetValue = maxValue - W;	// 만들고자 하는 목표 가치
		int usedCoins = 0;				// 사용된 동전의 개수
		
		// 동전의 가치를 큰 것부터 차례로 사용
		for (int i = 0; i < 6; i++) {
			int coinValue = coinValues[i];
            int coinCount = coinCounts[i];
            
            // 현재 동전으로 만들 수 있는 최대 개수
            int useCount = Math.min(targetValue / coinValue, coinCount);
            
            // 동전 사용
            targetValue -= useCount * coinValue;
            usedCoins += useCount;
            
            // 사용된 동전 최신화
            coinCounts[i] -= useCount;
            
            // 목표 가치가 0이 되면 종료
            if (targetValue == 0)
                break;
		}
		
		System.out.println(totalCoins - usedCoins);
		for (int coinCount : coinCounts) {
			System.out.print(coinCount + " ");
		}
	}

}
