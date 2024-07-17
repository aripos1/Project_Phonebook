package com.javaex.phonebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Phonebook {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		Reader in = new FileReader("C:\\javaStudy\\miniProject\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(in);
		List<Phone> pList = new ArrayList<Phone>();
		// phoneDB 불러오기
		while (true) {
			String str = br.readLine();

			if (str == null) {
				break;
			}
			String[] aArr = str.split(",");
			Phone phone = new Phone(aArr[0], aArr[1], aArr[2]);
			pList.add(phone);
		}

		// 프로그램 실행
		System.out.println("==================");
		System.out.println("* 전화번호 관리프로그램 *");
		System.out.println("==================");

		while (true) {
			System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
			System.out.println("-----------------------------");
			System.out.print(">메뉴번호: ");
			int num = sc.nextInt();

			switch (num) {

			case 1:
				System.out.println("<1.리스트>");
				for (int i = 0; i < pList.size(); i++) {

					if (i == pList.size()) {
					} else {
						int a = i + 1;
						System.out.print(a);
					}
					pList.get(i).showList();
					System.out.println("");
				}
				continue;
			case 2:
				System.out.println("<2.등록>");

				System.out.print(">이름 : ");
				sc.nextLine();
				String n = sc.nextLine();

				System.out.print(">휴대전화 : ");
				String h = sc.nextLine();

				System.out.print(">회사전화 : ");
				String c = sc.nextLine();

				Phone p = new Phone(n, h, c);
				pList.add(p);
				System.out.println("[등록되었습니다.]");

				Writer out = new FileWriter("C:\\javaStudy\\miniProject\\PhoneDB1.txt");
				BufferedWriter bw = new BufferedWriter(out);
				for (Phone phone : pList) {
					bw.write(phone.writeList());
					bw.newLine();
				}
				bw.close();
				continue;
			case 3:
				System.out.println("<3.삭제>");
				System.out.print(">번호 : ");
				int delNum = sc.nextInt();
				int sum = delNum - 1;
				pList.remove(sum);
				System.out.println("[삭제되었습니다.]");

				Writer out1 = new FileWriter("C:\\javaStudy\\miniProject\\PhoneDB1.txt");
				BufferedWriter bw1 = new BufferedWriter(out1);
				for (Phone phone : pList) {
					bw1.write(phone.writeList());
					bw1.newLine();
				}
				bw1.close();
				continue;
			case 4:
				System.out.println("<4.검색>");
				System.out.print(">이름 : ");
				sc.nextLine();
				String search = sc.nextLine();
				for (int i = 0; i < pList.size(); i++) {
					Phone p1 = pList.get(i);
					if (p1.getName().contains(search)) {
						int a = i + 1;
						System.out.print(a);
						pList.get(i).showList();
					}
				}
				continue;
			case 5:
				System.out.println("==================");
				System.out.println("*     감사합니다     *");
				System.out.println("==================");

				break;
			default:
				System.out.println("[다시 입력해주세요.]");
			}

		}
	}
}
