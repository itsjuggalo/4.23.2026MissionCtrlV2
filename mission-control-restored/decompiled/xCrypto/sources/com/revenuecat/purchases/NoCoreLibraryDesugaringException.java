package com.revenuecat.purchases;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class NoCoreLibraryDesugaringException extends RuntimeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoCoreLibraryDesugaringException(Throwable cause) {
        super(NoCoreLibraryDesugaringExceptionKt.NO_CORE_LIBRARY_DESUGARING_ERROR_MESSAGE, cause);
        r.f(cause, "cause");
    }
}
