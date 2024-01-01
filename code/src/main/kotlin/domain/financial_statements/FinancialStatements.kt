package domain.financial_statements

import java.time.LocalDate

/**
 * FIXME 各財務諸表で項目をすべて列挙するのではなく、まずは主要簿となる仕訳台帳のDBを作った上でビューとして再整理を行う
 *       仕訳する -> 表現するで行う
 *
 * 財務諸表
 *
 * 投資家や債権者などの利害関係者に対して、調達した資金の使い道やその結果得られた成果を報告する必要があり、そのための書類。
 * 会社法によって企業で作成することが義務付けられているのは、下記3つ。
 * - 貸借対照表 : [BalanceSheet]
 * - 損益計算書 : [ProfitAndLossStatement]
 * - 株主資本等変動計算書 : [ShareholdersEquityStatement]
 * - キャッシュフロー計算書 : [CashFlowStatement]
 *     - 金融商品取引法が適用される上場企業のみ、作成を義務付けられている
 *
 * @param financialYearStartDate : 会計年度の開始日
 * @param financialYearEndDate : 会計年度の終了日
 */
sealed class FinancialStatements(
    open val financialYearStartDate: LocalDate,
    open val financialYearEndDate: LocalDate,
)