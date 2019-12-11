package com.ginite.inmemory.model.jolmodel;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class DatasetWrapper implements Serializable {

    private List<ResourceModel> resDs = new ArrayList<>();
    private List<RelJolModel> relDs = new ArrayList<>();
    private List<TxJolModel> txDs = new ArrayList<>();
    private List<ResIswcJolModel> resIswcTransactionDs = new ArrayList<>();
    private List<ResIswcJolModel> resIswcEnrichedDs = new ArrayList<>();
    private List<ResIsrcJolModel> resIsrcTransactionDs = new ArrayList<>();
    private List<ResIsrcJolModel> resIsrcEnrichedDs = new ArrayList<>();
    private List<ResTitleModel> resTitleTransactionalDs = new ArrayList<>();
    private List<ResTitleModel> resTitleEnrichedDs = new ArrayList<>();
    private List<ResProntoJolModel> resProntoDs = new ArrayList<>();
    private List<ResArtistJolModel> resArtistJolModelDs = new ArrayList<>();
    private List<ResContributorJolModel> resContributorJolModelDs = new ArrayList<>();

    public DatasetWrapper() {
    }
}
