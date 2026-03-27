package com.revenuecat.purchases.utils;

import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public class SerializationException extends RuntimeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SerializationException(String message, Throwable th) {
        super(message, th);
        r.f(message, "message");
    }

    public /* synthetic */ SerializationException(String str, Throwable th, int i7, AbstractC2148j abstractC2148j) {
        this(str, (i7 & 2) != 0 ? null : th);
    }
}
