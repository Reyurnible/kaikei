package domain.main_books

/**
 * 勘定アイテム
 *
 * @param transactionSide 借方・貸方
 * FIXME 勘定科目は後ほどenumなどモデル化
 * @param titleOfAccount 勘定科目
 * @param amount 金額
 * @param generalLedgerPage 元丁。転記先の総勘定元帳のページ数を記入する項目
 */
data class AccountItem(
    val transactionSide: TransactionSide,
    val titleOfAccount: String,
    val amount: Int,
    val generalLedgerPage: Int?,
)