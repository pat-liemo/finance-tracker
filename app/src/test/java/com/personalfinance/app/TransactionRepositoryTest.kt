package com.personalfinance.app

import com.personalfinance.app.data.local.dao.TransactionDao
import com.personalfinance.app.data.local.entity.TransactionEntity
import com.personalfinance.app.data.repository.TransactionRepositoryImpl
import com.personalfinance.app.domain.model.*
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.datetime.LocalDateTime
import org.junit.Test
import org.mockito.kotlin.*

/**
 * Unit tests for TransactionRepository implementation
 */
class TransactionRepositoryTest {
    
    private val mockDao = mock<TransactionDao>()
    private val repository = TransactionRepositoryImpl(mockDao)
    
    @Test
    fun `addTransaction should insert transaction and return id`() = runBlocking {
        // Arrange
        val transaction = createSampleTransaction()
        val expectedId = 123L
        whenever(mockDao.insertTransaction(any())).thenReturn(expectedId)
        
        // Act
        val result = repository.addTransaction(transaction)
        
        // Assert
        assert(result.isSuccess)
        assert(result.getOrNull() == expectedId)
        verify(mockDao).insertTransaction(any())
    }
    
    @Test
    fun `getTransactionById should return transaction when found`() = runBlocking {
        // Arrange
        val transactionId = 123L
        val entity = createSampleTransactionEntity(transactionId)
        whenever(mockDao.getTransactionById(transactionId)).thenReturn(entity)
        
        // Act
        val result = repository.getTransactionById(transactionId)
        
        // Assert
        assert(result != null)
        assert(result?.id == transactionId)
        assert(result?.amount == entity.amount)
        verify(mockDao).getTransactionById(transactionId)
    }
    
    @Test
    fun `getTransactionById should return null when not found`() = runBlocking {
        // Arrange
        val transactionId = 123L
        whenever(mockDao.getTransactionById(transactionId)).thenReturn(null)
        
        // Act
        val result = repository.getTransactionById(transactionId)
        
        // Assert
        assert(result == null)
        verify(mockDao).getTransactionById(transactionId)
    }
    
    @Test
    fun `updateTransaction should call dao update`() = runBlocking {
        // Arrange
        val transaction = createSampleTransaction()
        
        // Act
        val result = repository.updateTransaction(transaction)
        
        // Assert
        assert(result.isSuccess)
        verify(mockDao).updateTransaction(any())
    }
    
    @Test
    fun `deleteTransaction should call dao delete`() = runBlocking {
        // Arrange
        val transactionId = 123L
        
        // Act
        val result = repository.deleteTransaction(transactionId)
        
        // Assert
        assert(result.isSuccess)
        verify(mockDao).deleteTransactionById(transactionId)
    }
    
    @Test
    fun `getTransactions with empty filter should return all transactions`() = runBlocking {
        // Arrange
        val entities = listOf(createSampleTransactionEntity(1), createSampleTransactionEntity(2))
        whenever(mockDao.getAllTransactions("")).thenReturn(flowOf(entities))
        
        // Act
        val result = repository.getTransactions(TransactionFilter()).first()
        
        // Assert
        assert(result.size == 2)
        assert(result[0].id == 1L)
        assert(result[1].id == 2L)
        verify(mockDao).getAllTransactions("")
    }
    
    @Test
    fun `getTransactions with date range filter should use date range query`() = runBlocking {
        // Arrange
        val startDate = LocalDateTime.parse("2024-01-01T00:00:00")
        val endDate = LocalDateTime.parse("2024-01-31T23:59:59")
        val filter = TransactionFilter(startDate = startDate, endDate = endDate)
        val entities = listOf(createSampleTransactionEntity(1))
        whenever(mockDao.getTransactionsByDateRange("", startDate, endDate)).thenReturn(flowOf(entities))
        
        // Act
        val result = repository.getTransactions(filter).first()
        
        // Assert
        assert(result.size == 1)
        verify(mockDao).getTransactionsByDateRange("", startDate, endDate)
    }
    
    @Test
    fun `getTransactions with category filter should use category query`() = runBlocking {
        // Arrange
        val categoryId = "food"
        val filter = TransactionFilter(categoryIds = listOf(categoryId))
        val entities = listOf(createSampleTransactionEntity(1))
        whenever(mockDao.getTransactionsByCategory("", categoryId)).thenReturn(flowOf(entities))
        
        // Act
        val result = repository.getTransactions(filter).first()
        
        // Assert
        assert(result.size == 1)
        verify(mockDao).getTransactionsByCategory("", categoryId)
    }
    
    private fun createSampleTransaction(id: Long = 0): Transaction {
        return Transaction(
            id = id,
            amount = 100.0,
            categoryId = "food",
            date = LocalDateTime.parse("2024-01-15T12:00:00"),
            description = "Lunch",
            paymentMethod = PaymentMethod.CREDIT_CARD,
            tags = listOf("restaurant"),
            userId = "user123"
        )
    }
    
    private fun createSampleTransactionEntity(id: Long): TransactionEntity {
        return TransactionEntity(
            id = id,
            amount = 100.0,
            categoryId = "food",
            date = LocalDateTime.parse("2024-01-15T12:00:00"),
            description = "Lunch",
            paymentMethod = PaymentMethod.CREDIT_CARD,
            tags = listOf("restaurant"),
            userId = "user123"
        )
    }
}