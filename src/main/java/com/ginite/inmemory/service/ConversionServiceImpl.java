package com.ginite.inmemory.service;

import com.ginite.inmemory.converter.JolConverter;
import com.ginite.inmemory.factory.enums.JolConstants;
import com.ginite.inmemory.factory.JolModelFactory;
import com.ginite.inmemory.model.jolmodel.DatasetWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConversionServiceImpl implements ConversionService {

    @Autowired
    private SplittedLineListService splittedLineListService;

    private List<String[]> splittedLineList;

    @Override
    public DatasetWrapper getDatasetWrapper() {
        splittedLineList = getSplittedLineList();
        return createDatasets();
    }

    private List<String[]> getSplittedLineList() {
        return splittedLineListService.getSplittedlineList();
    }

    private DatasetWrapper createDatasets() {
        DatasetWrapper datasetWrapper = new DatasetWrapper();
        long iterations = 0;
        for (String[] splittedLine : splittedLineList) {
            iterations++;
            switch (splittedLine[JolConstants.LINE_CODE_POSITION]) {
                case JolConstants.RES_LINE_CODE:
                    datasetWrapper.getResDs().add(JolModelFactory.getResourceModel(splittedLine));
                    break;
                case JolConstants.REL_LINE_CODE:
                    datasetWrapper.getRelDs().add(JolModelFactory.getRelJolModel(splittedLine));
                    break;
                case JolConstants.TX_LINE_CODE:
                    datasetWrapper.getTxDs().add(JolModelFactory.getTxModel(splittedLine, iterations));
                    break;
                case JolConstants.PRONTO_LINE_CODE:
                    datasetWrapper.getResProntoDs().add(JolModelFactory.getProntoModel(splittedLine));
                    break;
                case JolConstants.RESARTIST_LINE_CODE:
                    datasetWrapper.getResArtistJolModelDs().add(JolModelFactory.getArtistModel(splittedLine));
                    break;
                case JolConstants.RESCONTR_LINE_CODE:
                    datasetWrapper.getResContributorJolModelDs().add(JolModelFactory.getContribModel(splittedLine));
                    break;
//                case JolConstants.
            }
        }
        return datasetWrapper;
    }
}
//            switch (splittedLine[JolConstants.LINE_CODE_POSITION]) {
//                case JolConstants.RESISWC_LINE_CODE:
//                    datasetWrapper.getResIswcTransactionDs().add(JolModelFactory.getResIswcModel(splittedLine));
//                    break;
//                case JolConstants.RESISRC_LINE_CODE:
//                    datasetWrapper.getResIswcEnrichedDs().add(JolModelFactory.getResIswcModel(splittedLine));
//                    break;
//                case JolConstants.
