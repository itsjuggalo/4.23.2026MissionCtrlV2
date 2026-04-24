package com.google.protobuf;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public enum Q {
    VOID(Void.class, null),
    INT(Integer.class, 0),
    LONG(Long.class, 0L),
    FLOAT(Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.class, Boolean.FALSE),
    STRING(String.class, ""),
    BYTE_STRING(AbstractC0472l.class, AbstractC0472l.f5744b),
    ENUM(Integer.class, null),
    MESSAGE(Object.class, null);

    Q(Class cls, Serializable serializable) {
    }
}
