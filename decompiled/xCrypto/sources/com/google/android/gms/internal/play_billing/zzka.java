package com.google.android.gms.internal.play_billing;

import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import io.flutter.Build;

/* JADX INFO: loaded from: classes.dex */
final class zzka implements zzhm {
    static final zzhm zza = new zzka();

    private zzka() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzhm
    public final boolean zza(int i4) {
        switch (i4) {
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
            case FirestoreIndexValueWriter.INDEX_TYPE_NUMBER /* 15 */:
                return true;
            default:
                switch (i4) {
                    case Build.API_LEVELS.API_22 /* 22 */:
                    case Build.API_LEVELS.API_23 /* 23 */:
                    case 24:
                    case 25:
                    case Build.API_LEVELS.API_26 /* 26 */:
                    case Build.API_LEVELS.API_27 /* 27 */:
                    case Build.API_LEVELS.API_28 /* 28 */:
                    case Build.API_LEVELS.API_29 /* 29 */:
                    case 30:
                        return true;
                    default:
                        return false;
                }
        }
    }
}
