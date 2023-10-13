package domain.main_books

import java.time.LocalDate

/**
 * 取引
 * 仕訳帳に記載される、仕訳された取引。
 * 未仕分けの取引を扱わないため、取引とだけ表現する。
 *
 * @param date 取引日。紙での記入時は、月と日を記載する
 * @param accountItemList 仕訳された各一行。
 * @param explanation 取引内容（摘要に、勘定科目と取引内容を記載するがその中の取引内容のみ）
 * @property debit 借(り)方勘定
 * @property credit 貸(し)方勘定
 */
data class Transactions(
    val date: LocalDate,
    val accountItemList: List<AccountItem>,
    val explanation: String?,
) {
    val debit: List<AccountItem>
        get() = accountItemList.filter { it.transactionSide == TransactionSide.Debit }
    val credit: List<AccountItem>
        get() = accountItemList.filter { it.transactionSide == TransactionSide.Credit }

    init {
        verify()
    }

    private fun verify() {
        // 中身が0件はNG
        check(accountItemList.isNotEmpty())
        // 借方・貸方でどちらかしか存在しないのはNG
        check(debit.isNotEmpty())
        check(credit.isNotEmpty())
        // 借方・貸方で金額が合わないのはNG
        check(debit.sumOf { it.amount } == credit.sumOf { it.amount })
    }
}