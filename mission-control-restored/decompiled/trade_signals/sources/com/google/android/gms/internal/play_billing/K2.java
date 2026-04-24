package com.google.android.gms.internal.play_billing;

import io.flutter.Build;

/* JADX INFO: loaded from: classes.dex */
public final class K2 implements M1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final M1 f15175a = new K2();

    @Override // com.google.android.gms.internal.play_billing.M1
    public final boolean zza(int i8) {
        switch (i8) {
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
            case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
            case 12:
            case 13:
            case 14:
            case 15:
                return true;
            default:
                switch (i8) {
                    case Build.API_LEVELS.API_22 /* 22 */:
                    case Build.API_LEVELS.API_23 /* 23 */:
                    case Build.API_LEVELS.API_24 /* 24 */:
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
