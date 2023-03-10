package com.example.cadox.repository

import com.example.cadox.bo.Article
import com.example.cadox.dao.DAOFactory
import com.example.cadox.dao.DAOType

object ArticleRepository{

    private var daoMemory = DAOFactory.getDAO(DAOType.MEMORY)
//    private var daoInternet = DAOFactory.getDAO(DAOType.INTERNET)
//    private var daoDb = DAOFactory.getDAO(DAOType.DB)

    fun getArticle (id: Long) = daoMemory.selectById(id)

//    fun getAllArticle () {
//        val listeArticles : List<Article> = daoDb.getAllArticles()
//        if(listeArticles.isEmpty()) {
//            listeArticles = daoInternet.getAllArticles ()
//        }
//        return listeArticles
//    }


}