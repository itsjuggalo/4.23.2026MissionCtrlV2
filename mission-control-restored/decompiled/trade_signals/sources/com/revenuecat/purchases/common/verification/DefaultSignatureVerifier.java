package com.revenuecat.purchases.common.verification;

import D2.c;
import android.util.Base64;
import java.security.GeneralSecurityException;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0013\b\u0016\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/common/verification/DefaultSignatureVerifier;", "Lcom/revenuecat/purchases/common/verification/SignatureVerifier;", "", "publicKeyBytes", "<init>", "([B)V", "", "publicKey", "(Ljava/lang/String;)V", "signatureToVerify", "messageToVerify", "", "verify", "([B[B)Z", "LD2/c;", "verifier", "LD2/c;", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
public final class DefaultSignatureVerifier implements SignatureVerifier {
    private static final String DEFAULT_PUBLIC_KEY = "UC1upXWg5QVmyOSwozp755xLqquBKjjU+di6U8QhMlM=";
    private final c verifier;

    /* JADX WARN: Illegal instructions before constructor call */
    public DefaultSignatureVerifier(String publicKey) {
        AbstractC2304t.f(publicKey, "publicKey");
        byte[] bArrDecode = Base64.decode(publicKey, 0);
        AbstractC2304t.e(bArrDecode, "decode(publicKey, Base64.DEFAULT)");
        this(bArrDecode);
    }

    @Override // com.revenuecat.purchases.common.verification.SignatureVerifier
    public boolean verify(byte[] signatureToVerify, byte[] messageToVerify) {
        AbstractC2304t.f(signatureToVerify, "signatureToVerify");
        AbstractC2304t.f(messageToVerify, "messageToVerify");
        try {
            this.verifier.a(signatureToVerify, messageToVerify);
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    public /* synthetic */ DefaultSignatureVerifier(String str, int i8, AbstractC2296k abstractC2296k) {
        this((i8 & 1) != 0 ? DEFAULT_PUBLIC_KEY : str);
    }

    public DefaultSignatureVerifier(byte[] publicKeyBytes) {
        AbstractC2304t.f(publicKeyBytes, "publicKeyBytes");
        this.verifier = new c(publicKeyBytes);
    }
}
