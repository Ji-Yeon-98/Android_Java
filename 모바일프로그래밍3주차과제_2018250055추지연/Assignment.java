
public class Assignment {

	public static void main(String[] args) {
		
		// 1. 점수에 따라 A~F 학점을 나누는 프로그램 만들기
		
		int input = 85;
		int jumsu = (input/10)*10;
		
		// 1-1. switch-case 문
		
		switch(jumsu) {
			case 100:
			case 90:
				System.out.println("A 학점");
				break;
			case 80:
				System.out.println("B 학점");
				break;
			case 70:
				System.out.println("C 학점");
				break;
			case 60:
				System.out.println("D 학점");
				break;
			default:
				System.out.println("F 학점");
				break;
		}
		
		
		// 1-2. if 문
		
		if(input >=90) {
			System.out.println("A 학점");
		}
		else if (input >= 80) {
			System.out.println("B 학점");
		}
		else if (input >= 70) {
			System.out.println("C 학점");
		}
		else if (input >= 60) {
			System.out.println("D 학점");
		}
		else {
			System.out.println("F 학점");
		}
		
		
		
		// 2. for문을 이용해  array[3][3] 배열 만들기
		
		int[][] a = new int[3][3];
		int num = 0;
		
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a.length; j++) {
				a[i][j] = 100 + num;
				System.out.println("a[" + i + "][" + j + "] = " + a[i][j]);
				num = num + 10;
			}
		}

	}

}
