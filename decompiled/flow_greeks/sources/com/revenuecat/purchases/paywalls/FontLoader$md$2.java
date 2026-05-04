package com.revenuecat.purchases.paywalls;

import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.v;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/security/MessageDigest;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class FontLoader$md$2 extends v implements Function0 {
    public static final FontLoader$md$2 INSTANCE = new FontLoader$md$2();

    public FontLoader$md$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final MessageDigest invoke() {
        return MessageDigest.getInstance("MD5");
    }
}
