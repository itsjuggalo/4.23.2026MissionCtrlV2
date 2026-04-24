package com.revenuecat.purchases.paywalls.components.common;

import F3.b;
import J3.AbstractC0351y;
import W2.j;
import W2.k;
import W2.l;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import java.lang.annotation.Annotation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public enum VariableLocalizationKey {
    DAY,
    DAILY,
    DAY_SHORT,
    WEEK,
    WEEKLY,
    WEEK_SHORT,
    MONTH,
    MONTHLY,
    MONTH_SHORT,
    YEAR,
    YEARLY,
    YEAR_SHORT,
    ANNUAL,
    ANNUALLY,
    ANNUAL_SHORT,
    LIFETIME,
    FREE_PRICE,
    PERCENT,
    NUM_DAY_ZERO,
    NUM_DAY_ONE,
    NUM_DAY_TWO,
    NUM_DAY_FEW,
    NUM_DAY_MANY,
    NUM_DAY_OTHER,
    NUM_WEEK_ZERO,
    NUM_WEEK_ONE,
    NUM_WEEK_TWO,
    NUM_WEEK_FEW,
    NUM_WEEK_MANY,
    NUM_WEEK_OTHER,
    NUM_MONTH_ZERO,
    NUM_MONTH_ONE,
    NUM_MONTH_TWO,
    NUM_MONTH_FEW,
    NUM_MONTH_MANY,
    NUM_MONTH_OTHER,
    NUM_YEAR_ZERO,
    NUM_YEAR_ONE,
    NUM_YEAR_TWO,
    NUM_YEAR_FEW,
    NUM_YEAR_MANY,
    NUM_YEAR_OTHER,
    NUM_DAYS_SHORT,
    NUM_WEEKS_SHORT,
    NUM_MONTHS_SHORT,
    NUM_YEARS_SHORT;

    public static final Companion Companion = new Companion(null);
    private static final j $cachedSerializer$delegate = k.a(l.f5481b, Companion.AnonymousClass1.INSTANCE);

    public static final class Companion {

        /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKey$Companion$1, reason: invalid class name */
        public static final class AnonymousClass1 extends s implements Function0 {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return AbstractC0351y.a("com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKey", VariableLocalizationKey.values(), new String[]{"day", "daily", "day_short", "week", "weekly", "week_short", "month", "monthly", "month_short", "year", "yearly", "year_short", "annual", "annually", "annual_short", "lifetime", "free_price", "percent", "num_day_zero", "num_day_one", "num_day_two", "num_day_few", "num_day_many", "num_day_other", "num_week_zero", "num_week_one", "num_week_two", "num_week_few", "num_week_many", "num_week_other", "num_month_zero", "num_month_one", "num_month_two", "num_month_few", "num_month_many", "num_month_other", "num_year_zero", "num_year_one", "num_year_two", "num_year_few", "num_year_many", "num_year_other", "num_days_short", "num_weeks_short", "num_months_short", "num_years_short"}, new Annotation[][]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, null);
            }
        }

        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        private final /* synthetic */ b get$cachedSerializer() {
            return (b) VariableLocalizationKey.$cachedSerializer$delegate.getValue();
        }

        public final b serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }
    }
}
