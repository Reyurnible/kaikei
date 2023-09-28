package domain.financial_statements

import java.time.LocalDate

/**
 * 貸借対照表
 *
 * 役割は、「一定時点の財政状態」を示すこと
 * 貸借対照表では、ある時点における資金の調達源泉とその運用状態を表す。
 *
 * 貸借対照表の左側(借方)が資金の運用形態、右側(貸方)が資金の調達源泉を表す。
 * 貸借対照表は、下記の要素で構成される。
 * - 左側(借方)：「資産の部」
 * - 右側(貸方)：「負債の部」、「純資産の部」
 */
// TODO 貸借対照表の項目を記載
data class BalanceSheet(
    override val financialYearEndDate: LocalDate,
) : FinancialStatements(
    financialYearEndDate
) {
    // ===借方===
    // 資産の部
    // ===貸方===
    // 負債の部
    // 純資産の部

    // TODO 左側と右側がバランスしているかをチェックする
    private fun validateBalance() {

    }
}