package com.revenuecat.purchases.models;

import E5.t;
import F5.J;
import com.revenuecat.purchases.models.Period;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class SubscriptionOptionsKt {
    private static final int DAYS_IN_DAY = 1;
    private static final int DAYS_IN_WEEK = 7;
    private static final int DAYS_IN_MONTH = 30;
    private static final int DAYS_IN_YEAR = 365;
    private static final Map<Period.Unit, Integer> DAYS_IN_UNIT = J.g(t.a(Period.Unit.DAY, 1), t.a(Period.Unit.WEEK, 7), t.a(Period.Unit.MONTH, Integer.valueOf(DAYS_IN_MONTH)), t.a(Period.Unit.YEAR, Integer.valueOf(DAYS_IN_YEAR)));
}
