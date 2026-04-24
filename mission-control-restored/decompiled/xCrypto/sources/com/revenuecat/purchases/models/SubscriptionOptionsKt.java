package com.revenuecat.purchases.models;

import W2.t;
import X2.L;
import com.revenuecat.purchases.models.Period;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class SubscriptionOptionsKt {
    private static final int DAYS_IN_DAY = 1;
    private static final int DAYS_IN_MONTH = 30;
    private static final int DAYS_IN_WEEK = 7;
    private static final int DAYS_IN_YEAR = 365;
    private static final Map<Period.Unit, Integer> DAYS_IN_UNIT = L.g(t.a(Period.Unit.DAY, 1), t.a(Period.Unit.WEEK, 7), t.a(Period.Unit.MONTH, 30), t.a(Period.Unit.YEAR, Integer.valueOf(DAYS_IN_YEAR)));
}
