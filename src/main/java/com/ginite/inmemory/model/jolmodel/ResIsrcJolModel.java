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
 * JOL file-ban levo RESISRC sorok model-je
 * Elvileg immutable, mivel a JOL sor alapjan letrejon, kesobbiekben az azonositashoz van hasznalva.
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
public class ResIsrcJolModel implements Serializable {

    public static final String BLOCK_ID = "blockId";
    public static final String ISRC_CODE = "isrc";

    private String blockId;
    private String isrc;
}
