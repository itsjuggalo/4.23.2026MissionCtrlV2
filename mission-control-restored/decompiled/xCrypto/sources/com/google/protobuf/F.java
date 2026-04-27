package com.google.protobuf;

import java.nio.Buffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class F {
    public static void a(Buffer buffer, int i4) {
        buffer.limit(i4);
    }

    public static void b(Buffer buffer, int i4) {
        buffer.position(i4);
    }
}
