/*
 *
 *  Copyright (c) 2017 Sonrisa Informatikai Kft. All Rights Reserved.
 *
 *  This software is the confidential and proprietary information of
 *  Sonrisa Informatikai Kft. ("Confidential Information").
 *  You shall not disclose such Confidential Information and shall use it only in
 *  accordance with the terms of the license agreement you entered into
 *  with Sonrisa.
 *
 *  SONRISA MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 *  THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 *  TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 *  PARTICULAR PURPOSE, OR NON-INFRINGEMENT. SONRISA SHALL NOT BE LIABLE FOR
 *  ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 *  DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 *
 */
package com.ginite.inmemory.model.jolmodel;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * JOL file-ban levo TX sorok model-je
 * Elvileg immutable, mivel a JOL sor alapjan letrejon, kesobbiekben az elmeleti jogdij kalkulaciohoz van hasznalva.
 * Azonban a Spark-os belso kodgeneralas miatt szukseg van a bean kompatibilitasra:
 * minden attributumbnak legyen settere is, illetve default konstruktorra.
 * Ezert az attributumok nem lehetnek final-ek, igy csak elvileg immutable, a settereket keretik nem hasznalni...
 *
 * @author Szentes Szabolcs
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TxJolModel implements Serializable {

    /*
    * A feldolgozaskor hivatkozott attributum nevek
     */
    public static final String BLOCK_ID = "blockId";
    public static final String USAGE = "usages";
    public static final String RETURN = "returns";
    public static final String NET_REVENUE = "netRevenue";
    public static final String TRANSACTION_ID = "transactionId";
    public static final String GROSS_REVENUE = "grossRevenue";
    public static final String PRICE_CONSUMER_PAID_EXC_SALES_TAX = "priceConsumerPaidExcSalesTax";
    public static final String FREE_UNITS = "freeUnits";
    public static final String EFD_TX_ID = "efdTxId";

    protected String blockId;
    protected String transactionId;
    protected Integer usages;
    protected Integer returns;
    protected Double netRevenue;
    protected Double grossRevenue;
    protected Double priceConsumerPaidExcSalesTax; // Price per unit
    protected Integer freeUnits;
    protected Long efdTxId;
}
