package com.google.protobuf;

import java.nio.Buffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class F {
    public static void a(Buffer buffer, int i7) {
        buffer.limit(i7);
    }

    public static void b(Buffer buffer, int i7) {
        buffer.position(i7);
    }
}
