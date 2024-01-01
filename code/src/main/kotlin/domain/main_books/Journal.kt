package domain.main_books

/**
 * 仕訳帳
 *
 * 日々の取引を発生順に「借方」「貸方」に分け、適当な勘定科目を使ってる複式簿記の方式で記録する帳簿。
 * 仕訳は、1つの取引を勘定科目を使って記録することをいう
 * 仕訳帳はお金の流れと、取引の「日付」「金額」「内容」がわかる仕組みになっている
 *
 * @param transactionItemList 仕訳帳の各行
 */
data class Journal(
    // FIXME 仕訳帳は、仕訳のまとめに変更し、仕訳 - 取引の関係でモデル定義をし直す
    val transactionItemList: List<Transactions>
) : MainBooks()