
package com.basistech.arraytc;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

/**
 *
 */
@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@JsonPropertyOrder(alphabetic = true)
public class TheItem {

    @JsonFormat(shape = JsonFormat.Shape.ARRAY)
    @JsonPropertyOrder(alphabetic = true)
    public static class NestedItem {
        private String nestedStrValue;

        @JsonCreator
        public NestedItem(@JsonProperty("nestedStrValue") String nestedStrValue) {
            this.nestedStrValue = nestedStrValue;
        }

        public String getNestedStrValue() {
            return nestedStrValue;
        }

        public void setNestedStrValue(String nestedStrValue) {
            this.nestedStrValue = nestedStrValue;
        }
    }

    private String strValue;
    private boolean boolValue;
    private List<NestedItem> nestedItems;

    @JsonCreator
    public TheItem(@JsonProperty("strValue") String strValue, @JsonProperty("boolValue") boolean boolValue, @JsonProperty("nestedItems") List<NestedItem> nestedItems) {
        this.strValue = strValue;
        this.boolValue = boolValue;
        this.nestedItems = nestedItems;
    }

    public String getStrValue() {
        return strValue;
    }

    public void setStrValue(String strValue) {
        this.strValue = strValue;
    }

    public boolean isBoolValue() {
        return boolValue;
    }

    public void setBoolValue(boolean boolValue) {
        this.boolValue = boolValue;
    }

    public List<NestedItem> getNestedItems() {
        return nestedItems;
    }

    public void setNestedItems(List<NestedItem> nestedItems) {
        this.nestedItems = nestedItems;
    }
}
