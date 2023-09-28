package domain.financial_statements

/**
 * 財務諸表
 *
 * 投資家や債権者などの利害関係者に対して、調達した資金の使い道やその結果得られた成果を報告する必要があり、そのための書類。
 * 会社法によって企業で作成することが義務付けられているのは、下記3つ。
 * - 貸借対照表 : [BalanceSheet]
 * - 損益計算書 : [ProfitAndLossStatement]
 * - 株主資本等変動計算書 : [ShareholdersEquityStatement]
 *
 * また、キャッシュフロー計算書は、金融商品取引法が適用される上場企業のみ、作成を義務付けられている。
 */
sealed class FinancialStatements