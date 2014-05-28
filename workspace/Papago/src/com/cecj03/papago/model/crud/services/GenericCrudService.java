package com.cecj03.papago.model.crud.services;

import java.util.List;

import com.cecj03.papago.model.dao.GenericDao;

public class GenericCrudService<T> {

	public GenericDao<T> dao;

	public void setDao(GenericDao<T> dao) {
		this.dao = dao;
	}
	
	public T create(T entity){
		T result = dao.insert(entity);
		if (result != null) {
			return result;
		} else {
			return null;
		}
	}
  
    public T update(T entity) {  
    	T result = dao.update(entity);
    	if (result != null) {
			return result;
		} else {
			return null;
		}
    }  
  
    public boolean delete(int id) {
		return dao.delete(id);
	}

	public T readById(int id) {
		return dao.findById(id);
	}

	public List<T> readAll() {
		return dao.findAll();
	}
	
	public List<T> readByHQL(String hql, Object... params) {  
        return dao.findByHQL(hql, params);  
    }  
}  
