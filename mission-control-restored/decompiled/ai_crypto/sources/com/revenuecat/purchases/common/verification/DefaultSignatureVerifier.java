package com.revenuecat.purchases.common.verification;

import O2.c;
import android.util.Base64;
import java.security.GeneralSecurityException;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultSignatureVerifier implements SignatureVerifier {
    public static final Companion Companion = new Companion(null);
    private static final String DEFAULT_PUBLIC_KEY = "UC1upXWg5QVmyOSwozp755xLqquBKjjU+di6U8QhMlM=";
    private final c verifier;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
            this();
        }

        private Companion() {
        }
    }

    public DefaultSignatureVerifier(byte[] publicKeyBytes) {
        r.f(publicKeyBytes, "publicKeyBytes");
        this.verifier = new c(publicKeyBytes);
    }

    @Override // com.revenuecat.purchases.common.verification.SignatureVerifier
    public boolean verify(byte[] signatureToVerify, byte[] messageToVerify) {
        r.f(signatureToVerify, "signatureToVerify");
        r.f(messageToVerify, "messageToVerify");
        try {
            this.verifier.a(signatureToVerify, messageToVerify);
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DefaultSignatureVerifier(String publicKey) {
        r.f(publicKey, "publicKey");
        byte[] bArrDecode = Base64.decode(publicKey, 0);
        r.e(bArrDecode, "decode(publicKey, Base64.DEFAULT)");
        this(bArrDecode);
    }

    public /* synthetic */ DefaultSignatureVerifier(String str, int i7, AbstractC2148j abstractC2148j) {
        this((i7 & 1) != 0 ? DEFAULT_PUBLIC_KEY : str);
    }
}
