package com.revenuecat.purchases.models;

import W2.m;
import W2.o;
import com.revenuecat.purchases.models.Period;
import k3.AbstractC1575b;
import r3.InterfaceC1761h;
import r3.k;

/* JADX INFO: loaded from: classes3.dex */
public final class PeriodKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Period.Unit.values().length];
            try {
                iArr[Period.Unit.YEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Period.Unit.MONTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Period.Unit.WEEK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Period.Unit.DAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Period.Unit.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final o toPeriod(String str) {
        double d4;
        double d5;
        double d6;
        InterfaceC1761h interfaceC1761hA = new k("^P(?!$)(\\d+(?:\\.\\d+)?Y)?(\\d+(?:\\.\\d+)?M)?(\\d+(?:\\.\\d+)?W)?(\\d+(?:\\.\\d+)?D)?$").a(str);
        if (interfaceC1761hA == null) {
            return new o(0, Period.Unit.UNKNOWN);
        }
        PeriodKt$toPeriod$1$toInt$1 periodKt$toPeriod$1$toInt$1 = PeriodKt$toPeriod$1$toInt$1.INSTANCE;
        InterfaceC1761h.b bVarA = interfaceC1761hA.a();
        String str2 = (String) bVarA.a().b().get(1);
        String str3 = (String) bVarA.a().b().get(2);
        String str4 = (String) bVarA.a().b().get(3);
        String str5 = (String) bVarA.a().b().get(4);
        int iIntValue = ((Number) periodKt$toPeriod$1$toInt$1.invoke((Object) str2)).intValue();
        int iIntValue2 = ((Number) periodKt$toPeriod$1$toInt$1.invoke((Object) str3)).intValue();
        int iIntValue3 = ((Number) periodKt$toPeriod$1$toInt$1.invoke((Object) str4)).intValue();
        int iIntValue4 = ((Number) periodKt$toPeriod$1$toInt$1.invoke((Object) str5)).intValue();
        Period.Unit unit = iIntValue4 > 0 ? Period.Unit.DAY : iIntValue3 > 0 ? Period.Unit.WEEK : iIntValue2 > 0 ? Period.Unit.MONTH : iIntValue > 0 ? Period.Unit.YEAR : Period.Unit.UNKNOWN;
        int i4 = WhenMappings.$EnumSwitchMapping$0[unit.ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                d5 = ((double) iIntValue) * 12.0d;
                d6 = iIntValue2;
            } else if (i4 == 3) {
                d5 = (((double) iIntValue) * 52.142857142857146d) + (((double) iIntValue2) * 4.345238095238096d);
                d6 = iIntValue3;
            } else if (i4 == 4) {
                d5 = (((double) iIntValue) * 365.0d) + (((double) iIntValue2) * 30.0d) + (((double) iIntValue3) * 7.0d);
                d6 = iIntValue4;
            } else {
                if (i4 != 5) {
                    throw new m();
                }
                d4 = 0.0d;
            }
            d4 = d5 + d6;
        } else {
            d4 = iIntValue;
        }
        return new o(Integer.valueOf(AbstractC1575b.c(d4)), unit);
    }
}
