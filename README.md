# InquirySupportManager
Javaで作成した社内向け問い合わせ管理システムです。  
問い合わせの登録・一覧表示・検索・ステータス更新に対応しており、  
CSVエクスポート機能も実装しています。  
業務システムで一般的な CRUD 処理と状態管理を再現したアプリケーションです。

---

## 📌 使用技術（Tech Stack）
- Java 17  
- 標準ライブラリのみで構築（外部ライブラリ不使用）  
- CSV出力（FileWriter / BufferedWriter）  
- コンソールUI  

---

## 📂 プロジェクト構成（Directory Structure）
InquirySupportManager/  
├─ src/  
│   └─ main/  
│        └─ InquirySupportManager.java  
└─ README.md  

---

## 🧩 機能一覧（Features）
- 問い合わせ登録（ID自動採番）  
- 問い合わせ一覧表示  
- タイトル検索（部分一致）  
- ステータス変更（未対応 / 対応中 / 完了）  
- CSVエクスポート（inquiries.csv に保存）  

---

## ▶ 実行方法（How to Run）
1. Java 17 が動作する環境を用意  
2. InquirySupportManager.java を任意のIDEに配置  
3. 実行するとメニューが表示され、コンソール操作で利用できます  

---

## 💡 工夫したポイント（Key Points）
- 業務システムで頻出する **CRUD処理** をすべて実装  
- 問い合わせの **状態管理（ステータス遷移）** を再現  
- CSV出力で **業務データの外部連携** を表現  
- 内部クラスで Inquiry モデルを定義し、Java の基本設計を意識  
- **社内システムを想定したメニュー構成と操作フロー** を再現  

---

## 📈 今後の拡張予定（Future Work）
- ユーザー管理（社員 / 管理者）  
- コメント機能（問い合わせごとのやり取り）  
- 優先度フラグ（高 / 中 / 低）  
- Web版（Spring Boot）への発展  
