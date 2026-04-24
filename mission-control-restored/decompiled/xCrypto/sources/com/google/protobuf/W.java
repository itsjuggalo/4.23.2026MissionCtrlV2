package com.google.protobuf;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public interface W extends X {

    public interface a extends X, Cloneable {
        W build();

        W buildPartial();

        a mergeFrom(W w4);

        a mergeFrom(AbstractC1063j abstractC1063j, C1070q c1070q);
    }

    g0 getParserForType();

    int getSerializedSize();

    a newBuilderForType();

    a toBuilder();

    byte[] toByteArray();

    void writeTo(AbstractC1065l abstractC1065l);

    void writeTo(OutputStream outputStream);
}
