package com.test.Urban_Village.accommodation.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.Urban_Village.accommodation.dto.AccommodationDTO;


@Repository
public class AccommodationDAOImpl implements AccommodationDAO {
@Autowired 
SqlSession session;

@Override
public List<AccommodationDTO> accList() {
	// TODO Auto-generated method stub
	List<AccommodationDTO> accList = session.selectList("mapper.accommodation.accList");
	return accList;
}
@Override
public AccommodationDTO findAccommodationId(String accommodationId) {
    return session.selectOne("mapper.accommodation.findAccommodationId", accommodationId);
}
@Override
public int addAcommodation(AccommodationDTO dto) {
	// TODO Auto-generated method stub
	return session.insert("mapper.accommodation.addAccommodation", dto);
}

@Override
public String getLastInsertedAccommodationId2() {
	// TODO Auto-generated method stub
	  return session.selectOne("mapper.accommodation.getLastInsertedAccommodationId2");
}

@Override
public String getLastInsertedAccommodationId() {
	// TODO Auto-generated method stub
	  return session.selectOne("mapper.accommodation.getLastInsertedAccommodationId");
}

@Override
public int insertAccommodation(Map<String, Object> accommodationMap) {
    return session.insert("mapper.accommodation.insertAccommodation", accommodationMap);
}
@Override
public int delAccommodation(String accommodation_id) {
	// TODO Auto-generated method stub
	return session.delete("mapper.accommodation.delAccommodation", accommodation_id);
}
@Override
public List<AccommodationDTO> idFindByAccList(String accommodation_id) {
	// TODO Auto-generated method stub
	return session.selectList("mapper.accommodation.idFindByAccList", accommodation_id);
}

@Override
public void updateAccommodation(Map<String, Object> accommodationMap) {
	// TODO Auto-generated method stub
	session.update("mapper.accommodation.updateAccommodation", accommodationMap);
}

@Override
public boolean checkAccommodationName(String name) {
    String result = session.selectOne("mapper.accommodation.checkAccommodationName", name);
    return result != null;
}
@Override
public boolean checkName(String accommodation_name) {
   int count = session.selectOne("mapper.accommodation.countName", accommodation_name);
   return count > 0;
}

@Override
//지역 검색
public List<AccommodationDTO> searchByRegions(List<String> regions) {
    return session.selectList("mapper.accommodation.searchByRegions", regions);
}

}
