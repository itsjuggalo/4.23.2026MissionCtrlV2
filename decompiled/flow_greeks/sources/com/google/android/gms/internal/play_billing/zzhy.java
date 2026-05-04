package com.google.android.gms.internal.play_billing;

import io.flutter.Build;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
final class zzhy implements zzfl {
    static final zzfl zza = new zzhy();

    private zzhy() {
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
            case 14:
            case 15:
                return true;
            default:
                switch (i10) {
                    case Build.API_LEVELS.API_22 /* 22 */:
                    case Build.API_LEVELS.API_23 /* 23 */:
                    case 24:
                    case Build.API_LEVELS.API_25 /* 25 */:
                    case Build.API_LEVELS.API_26 /* 26 */:
                    case Build.API_LEVELS.API_27 /* 27 */:
                    case Build.API_LEVELS.API_28 /* 28 */:
                    case Build.API_LEVELS.API_29 /* 29 */:
                    case Build.API_LEVELS.API_30 /* 30 */:
                    case Build.API_LEVELS.API_31 /* 31 */:
                    case 32:
                    case Build.API_LEVELS.API_33 /* 33 */:
                    case Build.API_LEVELS.API_34 /* 34 */:
                    case Build.API_LEVELS.API_35 /* 35 */:
                    case Build.API_LEVELS.API_36 /* 36 */:
                        return true;
                    default:
                        return false;
                }
        }
    }
}
