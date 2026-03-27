package com.revenuecat.purchases.common;

import com.revenuecat.purchases.PackageType;
import kotlin.jvm.internal.r;
import r3.x;

/* JADX INFO: loaded from: classes.dex */
public final class OfferingParserKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final PackageType toPackageType(String str) {
        PackageType packageType;
        PackageType[] packageTypeArrValues = PackageType.values();
        int length = packageTypeArrValues.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                packageType = null;
                break;
            }
            packageType = packageTypeArrValues[i4];
            if (r.b(packageType.getIdentifier(), str)) {
                break;
            }
            i4++;
        }
        return packageType == null ? x.C(str, "$rc_", false, 2, null) ? PackageType.UNKNOWN : PackageType.CUSTOM : packageType;
    }
}
