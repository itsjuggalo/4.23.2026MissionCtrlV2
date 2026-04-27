package com.revenuecat.purchases.models;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class RecurrenceModeKt {
    public static final RecurrenceMode toRecurrenceMode(Integer num) {
        RecurrenceMode recurrenceMode;
        RecurrenceMode[] recurrenceModeArrValues = RecurrenceMode.values();
        int length = recurrenceModeArrValues.length;
        int i7 = 0;
        while (true) {
            if (i7 >= length) {
                recurrenceMode = null;
                break;
            }
            recurrenceMode = recurrenceModeArrValues[i7];
            if (r.b(recurrenceMode.getIdentifier(), num)) {
                break;
            }
            i7++;
        }
        return recurrenceMode == null ? RecurrenceMode.UNKNOWN : recurrenceMode;
    }
}
