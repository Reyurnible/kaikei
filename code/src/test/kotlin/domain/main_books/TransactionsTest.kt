package domain.main_books

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import java.time.LocalDate


internal class TransactionsTest {

    @Test
    fun testVerify_Success() {
        assertDoesNotThrow {
            Transactions(
                date = LocalDate.of(2023, 1, 1),
                accountItemList = listOf(
                    AccountItem(
                        transactionSide = TransactionSide.Debit,
                        titleOfAccount = "電気代",
                        amount = 10000,
                        generalLedgerPage = null,
                    ),
                    AccountItem(
                        transactionSide = TransactionSide.Credit,
                        titleOfAccount = "現金",
                        amount = 10000,
                        generalLedgerPage = null,
                    )
                ),
                explanation = "電気代10,000円、現金で支払い"
            )
        }
    }

    @Test
    fun testVerify_Failure_empty_account() {
        assertThrows<IllegalStateException> {
            Transactions(
                date = LocalDate.of(2023, 1, 1),
                accountItemList = emptyList(),
                explanation = "電気代10,000円、現金で支払い"
            )
        }
    }

    @Test
    fun testVerify_Failure_unbalance() {
        assertThrows<IllegalStateException> {
            Transactions(
                date = LocalDate.of(2023, 1, 1),
                accountItemList = listOf(
                    AccountItem(
                        transactionSide = TransactionSide.Debit,
                        titleOfAccount = "電気代",
                        amount = 9000,
                        generalLedgerPage = null,
                    ),
                    AccountItem(
                        transactionSide = TransactionSide.Credit,
                        titleOfAccount = "現金",
                        amount = 10000,
                        generalLedgerPage = null,
                    )
                ),
                explanation = "電気代10,000円、現金で支払い"
            )
        }
    }



}