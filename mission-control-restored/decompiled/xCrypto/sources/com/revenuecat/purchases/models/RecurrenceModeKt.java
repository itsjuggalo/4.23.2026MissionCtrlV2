package com.revenuecat.purchases.models;

import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class RecurrenceModeKt {
    public static final RecurrenceMode toRecurrenceMode(Integer num) {
        RecurrenceMode recurrenceMode;
        RecurrenceMode[] recurrenceModeArrValues = RecurrenceMode.values();
        int length = recurrenceModeArrValues.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                recurrenceMode = null;
                break;
            }
            recurrenceMode = recurrenceModeArrValues[i4];
            if (r.b(recurrenceMode.getIdentifier(), num)) {
                break;
            }
            i4++;
        }
        return recurrenceMode == null ? RecurrenceMode.UNKNOWN : recurrenceMode;
    }
}
