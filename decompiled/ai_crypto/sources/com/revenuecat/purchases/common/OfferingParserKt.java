package com.revenuecat.purchases.common;

import Z5.t;
import com.revenuecat.purchases.PackageType;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class OfferingParserKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final PackageType toPackageType(String str) {
        PackageType packageType;
        PackageType[] packageTypeArrValues = PackageType.values();
        int length = packageTypeArrValues.length;
        int i7 = 0;
        while (true) {
            if (i7 >= length) {
                packageType = null;
                break;
            }
            packageType = packageTypeArrValues[i7];
            if (r.b(packageType.getIdentifier(), str)) {
                break;
            }
            i7++;
        }
        return packageType == null ? t.y(str, "$rc_", false, 2, null) ? PackageType.UNKNOWN : PackageType.CUSTOM : packageType;
    }
}
