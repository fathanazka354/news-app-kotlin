package com.androiddevs.mvvmnewsapp.ui.repository

import com.androiddevs.mvvmnewsapp.ui.api.ApiInstance
import com.androiddevs.mvvmnewsapp.ui.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.ui.models.Article

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        ApiInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(query:String, pageNumber: Int)=
        ApiInstance.api.searchNews(query,pageNumber)

    suspend fun upsertNews(article: Article) =
        db.getArticleDao().upsert(article)

    fun getArticle() =
        db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) =
        db.getArticleDao().deleteArticle(article)
}