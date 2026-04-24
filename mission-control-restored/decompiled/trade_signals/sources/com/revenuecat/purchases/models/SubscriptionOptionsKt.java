package com.revenuecat.purchases.models;

import com.revenuecat.purchases.models.Period;
import java.util.Map;
import kotlin.Metadata;
import o5.w;
import p5.M;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"DAYS_IN_DAY", "", "DAYS_IN_MONTH", "DAYS_IN_UNIT", "", "Lcom/revenuecat/purchases/models/Period$Unit;", "DAYS_IN_WEEK", "DAYS_IN_YEAR", "purchases_defaultsRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SubscriptionOptionsKt {
    private static final int DAYS_IN_DAY = 1;
    private static final int DAYS_IN_MONTH = 30;
    private static final int DAYS_IN_WEEK = 7;
    private static final int DAYS_IN_YEAR = 365;
    private static final Map<Period.Unit, Integer> DAYS_IN_UNIT = M.k(w.a(Period.Unit.DAY, 1), w.a(Period.Unit.WEEK, 7), w.a(Period.Unit.MONTH, 30), w.a(Period.Unit.YEAR, Integer.valueOf(DAYS_IN_YEAR)));
}
