package domain.financial_statements

import java.time.LocalDate

/**
 * キャッシュフロー計算書
 *
 * 役割は、「一定期間の経営成績」を示すこと
 */
// TODO キャッシュフロー計算書の項目を記載
data class CashFlowStatement(
    override val financialYearEndDate: LocalDate,
) : FinancialStatements(
    financialYearEndDate
) {

}