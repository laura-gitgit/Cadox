package com.example.cadox.dao

import com.example.cadox.dao.memory.ArticleDAOMemoryImpl

object DAOFactory {

    fun getDAO(type : DAOType) : ArticleDAO =
         when (type){
            DAOType.MEMORY -> ArticleDAOMemoryImpl()
//          DAOType.INTERNET -> ArticleDAOInternetImpl()
//          DAOType.DB -> ArticleDAODbImpl()
        }

}