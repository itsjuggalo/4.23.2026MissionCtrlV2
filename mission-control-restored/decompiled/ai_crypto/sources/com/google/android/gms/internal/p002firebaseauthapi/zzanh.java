package com.google.android.gms.internal.p002firebaseauthapi;

import k4.C2105D;

/* JADX INFO: loaded from: classes.dex */
final class zzanh {
    public static String zza(zzajp zzajpVar) {
        zzang zzangVar = new zzang(zzajpVar);
        StringBuilder sb = new StringBuilder(zzangVar.zza());
        for (int i7 = 0; i7 < zzangVar.zza(); i7++) {
            byte bZza = zzangVar.zza(i7);
            if (bZza == 34) {
                sb.append("\\\"");
            } else if (bZza == 39) {
                sb.append("\\'");
            } else if (bZza != 92) {
                switch (bZza) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                        sb.append("\\t");
                        break;
                    case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bZza < 32 || bZza > 126) {
                            sb.append('\\');
                            sb.append((char) (((bZza >>> 6) & 3) + 48));
                            sb.append((char) (((bZza >>> 3) & 7) + 48));
                            sb.append((char) ((bZza & 7) + 48));
                        } else {
                            sb.append((char) bZza);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
