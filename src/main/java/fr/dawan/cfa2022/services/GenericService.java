package fr.dawan.cfa2022.services;


import fr.dawan.cfa2022.dto.CountDto;

public interface GenericService<TDto> {

	TDto getById(long id);

	abstract TDto saveOrUpdate(TDto tDto) throws Exception;
		
	CountDto count(String search);
	
	void delete(long id);
}
