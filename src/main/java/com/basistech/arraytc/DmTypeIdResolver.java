package com.basistech.arraytc;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.type.TypeFactory;

/**
 * Jackson custom type info resolver; this is a dummy that models the behavior in the real case.
 */
class DmTypeIdResolver implements TypeIdResolver {

    @Override
    public void init(JavaType javaType) {
        //
    }

    @Override
    public String idFromValue(Object o) {
        return idFromValueAndType(o, o.getClass());
    }

    @Override
    public String idFromValueAndType(Object o, Class<?> aClass) {
        return o.getClass().getName();
    }

    @Override
    public String idFromBaseType() {
        throw new RuntimeException("Unsupported serialization case");
    }

    @Override
    public JavaType typeFromId(String key) {
        Class<?> clazz ;
        try {
            clazz = getClass().getClassLoader().loadClass(key);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return TypeFactory.defaultInstance().constructType(clazz);
    }

    @Override
    public JsonTypeInfo.Id getMechanism() {
        return JsonTypeInfo.Id.CUSTOM;
    }
}
