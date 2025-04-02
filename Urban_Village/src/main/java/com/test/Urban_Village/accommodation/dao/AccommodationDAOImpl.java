package com.test.Urban_Village.accommodation.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccommodationDAOImpl implements AccommodationDAO {
@Autowired 
SqlSession session;

}
