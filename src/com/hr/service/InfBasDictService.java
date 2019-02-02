package com.hr.service;

import java.io.Serializable;
import java.util.List;

import com.hr.pojo.BasDict;
import com.hr.util.PageUtil;

public interface InfBasDictService {
	//��ѯ
	public List<BasDict> findAll();
	//���
	public Serializable addBasDict(BasDict bd);
	//��ѯ��ֵ
	public BasDict findId(Serializable id);
	//�޸�
	public void update(BasDict bd);
	//ɾ��
	public void delete(BasDict bd);
	
	
	//��ѯ����
	public int findcount(String hql,Object...params);
	//��ѯ��ҳ
	public PageUtil findFy(int page, int count,BasDict dict);
}
