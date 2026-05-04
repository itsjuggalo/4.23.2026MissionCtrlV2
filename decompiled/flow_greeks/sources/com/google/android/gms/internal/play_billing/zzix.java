package com.google.android.gms.internal.play_billing;

import bb.d0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzix implements zzfl {
    static final zzfl zza = new zzix();

    private zzix() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzfl
    public final boolean zza(int i10) {
        switch (i10) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
            case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 19:
            case 20:
                return true;
            case 14:
            case 15:
            case 16:
            default:
                return false;
        }
    }
}
