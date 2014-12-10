

package com.basistech.arraytc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * fail to use array shape with a custom type ID scheme.
 */
public class SerTest extends Assert {
    @Test
    public void trouble() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        List<TheItem.NestedItem> nestedList = new ArrayList<TheItem.NestedItem>();
        nestedList.add(new TheItem.NestedItem("foo1"));
        nestedList.add(new TheItem.NestedItem("foo2"));
        TheItem item = new TheItem("first", false, nestedList);
        Outer outer = new Outer();
        outer.getAttributes().put(TheItem.class.getName(), item);

        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(outer);
        System.out.println(json);

        mapper.readValue(json, Outer.class);
    }
}
