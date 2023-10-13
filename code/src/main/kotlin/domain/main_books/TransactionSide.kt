package domain.main_books

/**
 * 借方(Debit)・貸方(Credit)のモデル
 *
 * 貸方・借方を指す良い言葉がなく、これは複式簿記の仕訳における取引の見方に対する両側面であることから、取引面とした
 * なぜ借方・貸方というかは、深い意味はないとのこと。
 * 一説には「自分が借りた・貸した」ではなく、「自分から借りた・自分に貸した」の相手からの視点で考えるためとのこと
 *
 * @property Debit 借(り)方※左側のこと
 * @property Credit 貸(し)方※右側のこと
 */
enum class TransactionSide {
    Debit,
    Credit,
}