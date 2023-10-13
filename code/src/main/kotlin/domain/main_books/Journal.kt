package domain.main_books

/**
 * 仕訳帳
 *
 * 仕訳は、会社の取引を勘定科目に置き換えて、適当な勘定科目に振り分けること。
 * 複式簿記のため、貸方と借方での勘定科目と金額、日付などを記録します。
 *
 * @param transactionItemList 仕訳帳の各行
 */
data class Journal(
    val transactionItemList: List<Transactions>
) : MainBooks()