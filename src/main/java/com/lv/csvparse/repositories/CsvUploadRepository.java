package com.lv.csvparse.repositories;

import com.lv.csvparse.dto.TopFormsDto;
import com.lv.csvparse.models.MosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CsvUploadRepository extends JpaRepository<MosModel, Long> {

    @Query("SELECT NEW com.lv.csvparse.dto.TopFormsDto(m.ts, m.grp, m.type, m.url, m.ymdh) FROM MosModel m")
    List<TopFormsDto> getTopUserForms();
}
