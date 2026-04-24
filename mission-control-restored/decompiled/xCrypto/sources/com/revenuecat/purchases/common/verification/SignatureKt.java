package com.revenuecat.purchases.common.verification;

import X2.AbstractC0763j;
import com.revenuecat.purchases.common.verification.Signature;

/* JADX INFO: loaded from: classes.dex */
public final class SignatureKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] copyOf(byte[] bArr, Signature.Component component) {
        return AbstractC0763j.h(bArr, component.getStartByte(), component.getEndByte());
    }
}
