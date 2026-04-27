package com.revenuecat.purchases.common.verification;

import F5.AbstractC0551i;
import com.revenuecat.purchases.common.verification.Signature;

/* JADX INFO: loaded from: classes2.dex */
public final class SignatureKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] copyOf(byte[] bArr, Signature.Component component) {
        return AbstractC0551i.h(bArr, component.getStartByte(), component.getEndByte());
    }
}
