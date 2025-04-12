package com.test.Urban_Village.wishList.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.Urban_Village.wishList.dto.WishListDTO;

@Repository
public class WishListDAOImpl implements WishListDAO{
	
	@Autowired
	private SqlSession session;
	
	private static final String NAMESPACE = "com.test.Urban_Village.wishList.dao.WishListDAO.";

	@Override
	public int insertWishlist(WishListDTO WDTO) {
		// TODO Auto-generated method stub
		return session.insert(NAMESPACE + "insertWishlist", WDTO);
	}

	@Override
	public int deleteWishlist(WishListDTO WDTO) {
		// TODO Auto-generated method stub
		return session.delete(NAMESPACE + "deleteWishlist", WDTO);
	}

	@Override
	public List<WishListDTO> selectWishlistByMemberId(String memberId) {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE + "selectWishlistByMemberId", memberId);
	}

	@Override
	public WishListDTO selectWishlistByMemberIdAndAccommodationId(WishListDTO WDTO) {
		// TODO Auto-generated method stub
		return session.selectOne(NAMESPACE + "selectWishlistByMemberIdAndAccommodationId", WDTO);
	}
	
}
