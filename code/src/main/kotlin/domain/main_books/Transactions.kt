package domain.main_books

import java.time.LocalDate

/**
 * 取引
 * 仕訳帳に記載される、仕訳された取引。
 * 未仕分けの取引を扱わないため、取引とだけ表現する。
 *
 * @param date 取引日。紙での記入時は、月と日を記載する
 * @param deposit 借(り)方勘定
 * @param credit 貸(し)方勘定
 * @param explanation 取引内容（摘要に、勘定科目と取引内容を記載するがその中の取引内容のみ）
 */
data class Transactions(
    val date: LocalDate,
    val deposit: AccountItem,
    val credit: AccountItem,
    val explanation: String?,
)