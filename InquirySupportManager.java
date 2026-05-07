package main;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InquirySupportManager {
	// ■ 問い合わせデータを表す内部クラス
    static class Inquiry {
        int id;
        String title;
        String detail;
        String category;
        String status; // 未対応 / 対応中 / 完了

        Inquiry(int id, String title, String detail, String category) {
            this.id = id;
            this.title = title;
            this.detail = detail;
            this.category = category;
            this.status = "未対応";
        }
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        List<Inquiry> list = new ArrayList<>();
        int idCounter = 1;

        while (true) {
            System.out.println("\n=== Inquiry Support Manager ===");
            System.out.println("1. 問い合わせ登録");
            System.out.println("2. 問い合わせ一覧");
            System.out.println("3. 問い合わせ検索（タイトル）");
            System.out.println("4. ステータス変更");
            System.out.println("5. CSV保存");
            System.out.println("0. 終了");
            System.out.print("選択：");

            int select = Integer.parseInt(sc.nextLine());

            switch (select) {

            case 1:
                System.out.print("タイトル：");
                String title = sc.nextLine();
                System.out.print("内容：");
                String detail = sc.nextLine();
                System.out.print("カテゴリ（PC/ネットワーク/アカウント/その他）：");
                String category = sc.nextLine();

                Inquiry iq = new Inquiry(idCounter++, title, detail, category);
                list.add(iq);
                System.out.println("→ 登録しました。");
                break;

            case 2:
                System.out.println("\n--- 問い合わせ一覧 ---");
                for (Inquiry q : list) {
                    System.out.println("ID:" + q.id + " / " + q.title + " / " + q.category + " / " + q.status);
                }
                break;

            case 3:
                System.out.print("検索ワード：");
                String word = sc.nextLine();
                System.out.println("\n--- 検索結果 ---");
                for (Inquiry q : list) {
                    if (q.title.contains(word)) {
                        System.out.println("ID:" + q.id + " / " + q.title + " / " + q.status);
                    }
                }
                break;

            case 4:
                System.out.print("ステータス変更するID：");
                int targetId = Integer.parseInt(sc.nextLine());
                System.out.print("新ステータス（未対応/対応中/完了）：");
                String newStatus = sc.nextLine();

                boolean found = false;
                for (Inquiry q : list) {
                    if (q.id == targetId) {
                        q.status = newStatus;
                        found = true;
                        System.out.println("→ ステータスを変更しました。");
                        break;
                    }
                }
                if (!found) {
                    System.out.println("→ IDが見つかりません。");
                }
                break;

            case 5:
                saveCSV(list);
                break;

            case 0:
                System.out.println("終了します。");
                sc.close();
                return;

            default:
                System.out.println("→ 無効な入力です。");
            }
        }
    }

    // ■ CSV保存処理
    static void saveCSV(List<Inquiry> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("inquiries.csv"))) {
            bw.write("ID,タイトル,内容,カテゴリ,ステータス\n");
            for (Inquiry q : list) {
                bw.write(q.id + "," + q.title + "," + q.detail + "," + q.category + "," + q.status + "\n");
            }
            System.out.println("→ inquiries.csv に保存しました。");
        } catch (IOException e) {
            System.out.println("→ 保存に失敗しました。");
        }
    }

	}


