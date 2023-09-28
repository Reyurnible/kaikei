package domain.financial_statements

import java.time.LocalDate

/**
 * 損益計算書
 *
 * 略してP/Lとも呼ばれる。米国では、Income Statement と呼ぶことも多い
 * 役割は、「一定期間の経営成績」を示すこと
 *
 * 損益計算書は「収益」と「費用」、「利益」から構成
 */
// @TODO 損益計算書の項目を記載
data class ProfitAndLossStatement(
    override val financialYearEndDate: LocalDate,
) : FinancialStatements(
    financialYearEndDate
) {

}