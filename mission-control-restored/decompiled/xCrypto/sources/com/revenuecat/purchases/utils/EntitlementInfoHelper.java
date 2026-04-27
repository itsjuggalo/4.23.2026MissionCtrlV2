package com.revenuecat.purchases.utils;

import com.revenuecat.purchases.PeriodType;
import com.revenuecat.purchases.Store;
import java.util.Date;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class EntitlementInfoHelper {
    public static final EntitlementInfoHelper INSTANCE = new EntitlementInfoHelper();

    private EntitlementInfoHelper() {
    }

    public final boolean getWillRenew(Store store, Date date, Date date2, Date date3, PeriodType periodType) {
        r.f(store, "store");
        return ((store == Store.PROMOTIONAL) || (date == null) || (date2 != null) || (date3 != null) || (periodType == PeriodType.PREPAID)) ? false : true;
    }
}
