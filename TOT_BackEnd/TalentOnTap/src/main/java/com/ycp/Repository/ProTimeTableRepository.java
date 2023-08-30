package com.ycp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ycp.Classes.ProfessionalTimeTable;
import com.ycp.Classes.ProfessionalTimeTableKey;


@Repository
public interface ProTimeTableRepository extends JpaRepository<ProfessionalTimeTable, ProfessionalTimeTableKey> {

	ProfessionalTimeTable findByProkey(ProfessionalTimeTableKey id);

	List<ProfessionalTimeTable> findByProkeyId(long id);
}
