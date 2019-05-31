package com.lv.csvparse.repositories;

import com.lv.csvparse.models.MosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CsvUploadRepository extends JpaRepository<MosModel, Long> {

    @Query(value = "SELECT * FROM public.mos_uslugi ORDER BY ts limit :limit", nativeQuery = true)
    List<MosModel> getTopFormsInLastOur(@Param("limit") int limit);
}
