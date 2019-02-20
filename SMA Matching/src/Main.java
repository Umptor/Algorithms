import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Applicant[] applicants;
	static StandOwner[] standOwners;

	private static class Applicant {

		private int id;
		private int[] prefrenceList;
		private int[] crossedList;


		public Applicant(int id, int[] preferenceList) {
			this.id = id;
			this.prefrenceList = preferenceList;
			crossedList = new int[preferenceList.length];
			for(int i = 0; i < crossedList.length; i++)
				crossedList[i] = 0;
		}

		public boolean preferenceIsCrossed(int index) {
			return crossedList[index] == 1;
		}

		public void cross(int index) {
			crossedList[index] = 1;
		}



	}

	private static class StandOwner {

		private int id;
		private int[] prefrenceList;
		private ArrayList<Integer> applicants_On_That_Day = new ArrayList<>();

		public StandOwner(int id, int[] preferenceList) {
			this.id = id;
			this.prefrenceList = preferenceList;
		}
		public void addApplicant(int id) {
			applicants_On_That_Day.add(id);
		}
		public boolean isApplyingToday(int applicantID) {
			return applicants_On_That_Day.contains(applicantID);
		}


	}


	private static boolean isDone() {
		for(StandOwner so: standOwners)
			if(so.applicants_On_That_Day.size() != 1)
				return false;
		return true;
	}

	private static void allocateApplicants() {
		int standCount = applicants.length;
		for(Applicant applicant: applicants) {
			for(int i = 0; i < standCount; i++) {
				if(applicant.preferenceIsCrossed(i))
					continue;
				standOwners[applicant.prefrenceList[i]].addApplicant(applicant.id);
				break;
			}
		}
	}

	public static void selectApplicant(StandOwner stand) {
		if(stand.applicants_On_That_Day.size() < 2) {
			return;
		}
		int id = 0;
		for(int applicant: stand.prefrenceList) {
			if(stand.isApplyingToday(applicant)) {
				id = applicants[applicant].id;
				break;
			}
		}
		while(stand.applicants_On_That_Day.size() > 1) {
			int index = 0;
			if(applicants[stand.applicants_On_That_Day.get(0)].id == id)
				index = 1;

			Applicant curApplicant = applicants[stand.applicants_On_That_Day.get(index)];

			for(int i = 0; i < curApplicant.prefrenceList.length; i++) {
				if(standOwners[curApplicant.prefrenceList[i]].id == stand.id) {
					curApplicant.cross(i);
					break;
				}
			}

			stand.applicants_On_That_Day.remove(index);
		}
	}

	public static void endDay() {
		for(StandOwner so: standOwners) {
			while(so.applicants_On_That_Day.size() > 0) {
				so.applicants_On_That_Day.remove(0);
			}
		}
	}

	public static void SMA() {

		allocateApplicants();

		for(StandOwner so: standOwners)
			selectApplicant(so);

		if(!isDone()) {
			endDay();
			SMA();
		}
	}

	public static void printSMAResult() {
		for(StandOwner so: standOwners) {
			System.out.println("StandOwner id: " + so.id + "   is matched with applicant id: " + so.applicants_On_That_Day.get(0));
		}
	}



	/*
4
1 3 2 0
2 3 1 0
0 2 1 3
3 2 0 1
1 3 2 0
3 1 2 0
2 1 3 0
0 3 2 1

5
3 2 5 1 4
1 2 5 3 4
4 3 2 1 5
1 3 4 2 5
1 2 4 5 3
3 5 2 1 4
5 2 1 4 3
4 3 5 1 2
1 2 3 4 5
2 3 4 1 5

5
2 1 4 0 3
0 1 4 2 3
3 2 1 0 4
0 2 3 1 4
0 1 3 4 2
2 4 1 0 3
4 1 0 3 2
3 2 4 0 1
0 1 2 3 4
1 2 3 0 4





	 */

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) {

		int maxApplicant = scanner.nextInt();
		scanner.nextLine();
		applicants = new Applicant[maxApplicant];
		standOwners = new StandOwner[maxApplicant];

		for(int i = 0; i < maxApplicant; i++) {
			int[] preferences = new int[maxApplicant];
			String[] str = scanner.nextLine().split(" ");
			for(int ii = 0; ii < str.length; ii++)
				preferences[ii] = Integer.parseInt(str[ii]);

			applicants[i] = new Applicant(i, preferences);

		}
		for(int i = 0; i < maxApplicant; i++) {
			int[] preferences = new int[maxApplicant];
			String[] str = scanner.nextLine().split(" ");
			for(int ii = 0; ii < str.length; ii++)
				preferences[ii] = Integer.parseInt(str[ii]);

			standOwners[i] = new StandOwner(i, preferences);
		}

		SMA();

		printSMAResult();
	}
}
