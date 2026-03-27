package com.revenuecat.purchases.utils;

import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public class SerializationException extends RuntimeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SerializationException(String message, Throwable th) {
        super(message, th);
        r.f(message, "message");
    }

    public /* synthetic */ SerializationException(String str, Throwable th, int i4, AbstractC1585j abstractC1585j) {
        this(str, (i4 & 2) != 0 ? null : th);
    }
}
