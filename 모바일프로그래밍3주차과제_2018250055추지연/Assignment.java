
public class Assignment {

	public static void main(String[] args) {
		
		// 1. ������ ���� A~F ������ ������ ���α׷� �����
		
		int input = 85;
		int jumsu = (input/10)*10;
		
		// 1-1. switch-case ��
		
		switch(jumsu) {
			case 100:
			case 90:
				System.out.println("A ����");
				break;
			case 80:
				System.out.println("B ����");
				break;
			case 70:
				System.out.println("C ����");
				break;
			case 60:
				System.out.println("D ����");
				break;
			default:
				System.out.println("F ����");
				break;
		}
		
		
		// 1-2. if ��
		
		if(input >=90) {
			System.out.println("A ����");
		}
		else if (input >= 80) {
			System.out.println("B ����");
		}
		else if (input >= 70) {
			System.out.println("C ����");
		}
		else if (input >= 60) {
			System.out.println("D ����");
		}
		else {
			System.out.println("F ����");
		}
		
		
		
		// 2. for���� �̿���  array[3][3] �迭 �����
		
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
