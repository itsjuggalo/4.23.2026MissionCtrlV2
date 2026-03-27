package com.revenuecat.purchases.common.verification;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class SignatureVerificationException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignatureVerificationException(String apiPath) {
        super("Failed signature verification for request with path " + apiPath);
        r.f(apiPath, "apiPath");
    }
}
