package com.lv.csvparse.services;

import com.lv.csvparse.dto.TopFormsDto;
import com.lv.csvparse.models.MosModel;
import com.lv.csvparse.repositories.CsvUploadRepository;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class CsvUploadService {

    @Autowired
    CsvUploadRepository csvUploadRepository;

    @Transactional
    public List<MosModel> uploadCsv(MultipartFile file) throws IOException {

        InputStream inputStream = file.getInputStream();

        CSVParser parser = new CSVParserBuilder()
                .withSeparator(';')
                .withIgnoreQuotations(true)
                .build();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
             CSVReader reader = new CSVReaderBuilder(br).withCSVParser(parser)
                     .build()) {

            List<String[]> rows = reader.readAll();

            rows.stream().skip(1).forEach(row -> {
                MosModel mos = new MosModel();

                mos.setSsoid        (row[0]);
                mos.setTs           (row[1]);
                mos.setGrp          (row[2]);
                mos.setType         (row[3]);
                mos.setSubtype      (row[4]);
                mos.setUrl          (row[5]);
                mos.setOrgid        (row[6]);
                mos.setFormid       (row[7]);
                mos.setCode         (row[8]);
                mos.setLtpa         (row[9]);
                mos.setSudirresponse(row[10]);
                try {
                    mos.setYmdh(new SimpleDateFormat("yyyy-MM-dd-mm").parse(row[11]));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                csvUploadRepository.save(mos);
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        return csvUploadRepository.findAll();
    }

    public List<TopFormsDto> getTopUserForms() {
        return csvUploadRepository.getTopUserForms();
    }

    public Page<MosModel> getTopFormsInLastOur() {
        return csvUploadRepository.findAll(PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC, "ts")));
    }
}
