package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.entity.Tour;

public class TourDAOImpl implements TourDAO {
	private Connection conn;

	public TourDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addTour(Tour p) {
		try {
			String sql = "INSERT INTO tour_dt(tourname, location, days, night, travelstyle, city, price, photo) "
					+ " values (?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getTourName());
			ps.setString(2, p.getLocation());
			ps.setString(3, p.getDays());
			ps.setString(4, p.getNights());
			ps.setString(5, p.getTravelStyle());
			ps.setString(6, p.getCity());
			ps.setString(7, p.getPrice());
			ps.setString(8, p.getPhoto());
			if (ps.executeUpdate() == 1)
			{
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Tour> getAllTour() {
		List<Tour> list = new ArrayList<Tour>();
		Tour p = null;
		try {
			String sql = "Select * from tour_dt";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				p = new Tour();
				p.setTourId(rs.getInt(1));
				p.setTourName(rs.getString(2));
				p.setLocation(rs.getString(3));
				p.setDays(rs.getString(4));
				p.setNights(rs.getString(5));
				p.setTravelStyle(rs.getString(6));
				p.setCity(rs.getString(7));
				p.setPrice(rs.getString(8));
				p.setPhoto(rs.getString(9));
				list.add(p);
			}
		}catch(Exception e) {
			
		}
		
		return list;
	}

	public Tour getTourbyID(int id) {
		Tour p = null;
		try {
			String sql="select * from tour_dt where tourId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				p = new Tour();
				p.setTourId(rs.getInt(1));
				p.setTourName(rs.getString(2));
				p.setLocation(rs.getString(3));
				p.setDays(rs.getString(4));
				p.setNights(rs.getString(5));
				p.setTravelStyle(rs.getString(6));
				p.setCity(rs.getString(7));
				p.setPrice(rs.getString(8));
				p.setPhoto(rs.getString(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	public boolean editTour(Tour p) {
		boolean f= false;
		try {
			String sql = "Update tour_dt set tourname=?, location= ?, days= ?, night = ?, travelstyle=?, city=?, price=? where tourId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getTourName());
			ps.setString(2, p.getLocation());
			ps.setString(3, p.getDays());
			ps.setString(4, p.getNights());
			ps.setString(5, p.getTravelStyle());
			ps.setString(6, p.getCity());
			ps.setString(7, p.getPrice());
			ps.setInt(8, p.getTourId());
			
			int i = ps.executeUpdate();
			if(i == 1) {
				f = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean deleteTour(int id) {
		try {
			String sql = "DELETE FROM tour_dt WHERE tourId = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			if (preparedStatement.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Tour> getAllHaNoiTour() {
		List<Tour> list = new ArrayList<Tour>();
		Tour p = null;
		try {
			String sql = "select * from tour_dt where city = ?  order by tourId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
		    ps.setString(1,"HA NOI");
		    ResultSet rs = ps.executeQuery();
		    while(rs.next()) {
		    	p = new Tour();
		    	p.setTourId(rs.getInt(1));
				p.setTourName(rs.getString(2));
				p.setLocation(rs.getString(3));
				p.setDays(rs.getString(4));
				p.setNights(rs.getString(5));
				p.setTravelStyle(rs.getString(6));
				p.setCity(rs.getString(7));
				p.setPrice(rs.getString(8));
				p.setPhoto(rs.getString(9));
				list.add(p);
		    }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Tour> getAllHoChiMinhTour() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Tour> getTourBySearch(String ch) {
		// TODO Auto-generated method stub
		return null;
	}

}