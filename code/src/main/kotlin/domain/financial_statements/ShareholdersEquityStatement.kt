package domain.financial_statements

import java.time.LocalDate

/**
 * 株主資本等変動計算書
 *
 * Statements of Shareholder’s Equity、略して S/S と 呼ばれる。
 * 役割は、「貸借対照表の純資産の変動状況」を示すこと
 *
 * 2006年の新会社法が施行される前は、利益処分計算書という財務諸表があり、新会社法によって株主資本等変動計算書となった。
 * 純資産の部の項目が表の列として表現され、一番上の行は純資産の部の「当期首残高」、一番下の行が「当期末残高」となっている。
 */
// @TODO 株主資本等変動計算書の項目を記載
data class ShareholdersEquityStatement(
    override val financialYearEndDate: LocalDate,
) : FinancialStatements(
    financialYearEndDate
) {

}