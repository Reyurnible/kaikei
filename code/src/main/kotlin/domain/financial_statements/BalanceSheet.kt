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
 * - 左側(借方)
 *   - 資産の部 : [Assets]
 * - 右側(貸方)
 *   - 負債の部
 *   - 純資産の部
 */
// TODO 貸借対照表の項目を記載
data class BalanceSheet(
    override val financialYearStartDate: LocalDate,
    override val financialYearEndDate: LocalDate,
    // ===借方===
    val assets: BalanceSheet.Assets,
    // ===貸方===
) : FinancialStatements(
    financialYearStartDate,
    financialYearEndDate
) {
    // ===借方===

    // ===貸方===
    // 負債の部

    // 純資産の部

    // TODO 左側と右側がバランスしているかをチェックする
    private fun validateBalance() {

    }

    /**
     * 資産の部 ：資産の種類により下記に分類
     * 並び順 : 一般的には、現金化しやすいものから順に、上から流動資産、固定資産、繰延資産と並べる。
     * 流動資産の中でも現金化しやすいものから並べるため、ほとんどの場合、一番上は現金・預貯金になります。この並べ方を「流動性配列法」という。
     * また、固定資産の占める割合が極めて高い企業に限り、流動性の低い資産から順に並べる「固定性配列法」が認められています。この場合は、流動資産よりも固定資産が上に記載される。
     *
     * @param currentAssets : 流動資産
     * @param fixedAssets : 固定資産
     * @param deferredAssets : 繰延資産
     */
    data class Assets(
        val currentAssets:  AssetsItems.CurrentAssets,
        val fixedAssets: AssetsItems.FixedAssets,
        val deferredAssets: AssetsItems.DeferredAssets,
    )

    /**
     * 資産の部の各資産種別のアイテム
     */
    sealed class AssetsItems {

        /**
         * 流動資産
         * 企業の通常の営業サイクルに含まれ、比較的短期に現金化できる資産。「当座資産」と「棚卸資産」、「その他の流動資産」に大きく分けられる。
         *     「当座資産」
         *       「現金預金」
         *       「受取手形」
         *       「売掛金」
         *       「貸倒引当金(売上債権から控除)」 : 売掛金、受取手形などの債権の貸し倒れリスクに備えて、あらかじめ貸し倒れの見積額を計上しておくもの
         *       「有価証券」 : 会社が保有している株式や債券のこと.有価証券のうち売買目的有価証券、および決算日の翌日から1年以内に満期の到来する債券の合計額が表示される
         *     「棚卸資産」
         *     「短期貸付金」
         *     「前払費用」: 経過勘定
         *     「未収収益」: 経過勘定
         *     など
         */
        class CurrentAssets(
            // ===当座資産===
            // 現金及び預金 : 社内に保有する現金の他、銀行預金や郵便貯金、金銭信託もすぐに現金化できるので当座資産に含まれます。また、1年以内に満期を迎える定期預金も該当します。
            // 受取手形 : 商品やサービスを販売したときに対価として受け取る手形です。満期日と取引銀行が指定され、期日が来れば支払いを受けることができます。
            // 売掛金 : 商品やサービスを販売し、後日支払われることを約束した代金のことで、将来代金を請求できる権利ともいえます。
            // 有価証券 : 売買や満期保有を目的とする株券や債券などのうち、満期日が1年以内の有価証券は当座資産に該当します。
            // ===棚卸資産===
            // 商品(棚卸資産) : 仕入れた物品のうち加工を行わなくてもそのまま販売できるものを指します。
            // 製品 : 自社で製造や加工を行ったもので、主とする製品の製造過程から派生する副産物や、製品の製造に使った原材料の残りも含まれます。
            // 原材料 : 製品を作るために必要な原料や材料、部品などが該当します。
            // 仕掛品 : 製造途中でまだ完成していない状態の製品のことです。原材料を少しでも加工していれば、仕掛品になります。
            // ===その他の流動資産===
            // 前払金（前渡金） : 事業に必要な商品などの購入時に代金の一部または全部を前払いした費用のことで、前渡金とも呼ばれます。
            // 未収入金 : 固定資産や有価証券を売却した場合など、営業活動以外の取引によって生じた債権を指します。
            // 未収収益
            // 前払費用 : 継続的なサービスを受けるために前払いした費用のうち、期末時点でまだサービスの提供を受けていない部分についての費用です。
            // 貸倒引当金 : 将来貸倒れが起こるかもしれないリスクに備えて、事前に計上するのが貸倒引当金です。
            // 仮払金 : 経費の用途や金額が決まっていない場合に、会社が一時的に支払うお金のこと
            // 短期貸付金 : 決算日の翌日から1年以内に返済期日を迎える貸付金は「短期貸付金」として流動資産に計上します。なお、返済期日までの期間が1年を超える場合は、「長期貸付金」として固定資産に分類されます。
        ) : AssetsItems() {

            /**
             * 流動資産の種別
             *
             * @property CashAndCashEquivalents 当座資産
             * @property Inventories 棚卸資産
             * @property OtherCurrentAssets その他の流動資産
             */
            enum class CurrentAssetsType {
                CashAndCashEquivalents,
                Inventories,
                OtherCurrentAssets,
            }
        }

        /**
         * 固定資産
         */
        class FixedAssets() : AssetsItems() {

        }

        /**
         * 繰延資産
         */
        class DeferredAssets() : AssetsItems() {

        }
    }

}