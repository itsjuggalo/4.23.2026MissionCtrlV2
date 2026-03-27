package com.google.android.gms.internal.play_billing;

import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
final class zzkz implements zzhm {
    static final zzhm zza = new zzkz();

    private zzkz() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzhm
    public final boolean zza(int i7) {
        if (i7 == 17 || i7 == 18) {
            return true;
        }
        switch (i7) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
            case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
            case 11:
            case 12:
            case 13:
                return true;
            default:
                return false;
        }
    }
}
