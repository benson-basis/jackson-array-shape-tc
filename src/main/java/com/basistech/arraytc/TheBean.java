

package com.basistech.arraytc;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

/**
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@JsonPropertyOrder(alphabetic = true)
public class TheBean {
    private List<TheItem> items;

    @JsonCreator
    public TheBean(@JsonProperty("items") List<TheItem> items) {
        this.items = items;
    }


    public List<TheItem> getItems() {
        return items;
    }

    public void setItems(List<TheItem> items) {
        this.items = items;
    }
}
