package com.revenuecat.purchases.paywalls;

import java.security.MessageDigest;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class FontLoader$md$2 extends s implements Function0 {
    public static final FontLoader$md$2 INSTANCE = new FontLoader$md$2();

    public FontLoader$md$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final MessageDigest invoke() {
        return MessageDigest.getInstance("MD5");
    }
}
