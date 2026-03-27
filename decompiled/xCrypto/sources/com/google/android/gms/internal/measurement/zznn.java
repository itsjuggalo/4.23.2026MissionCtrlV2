package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zznn {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static String zza(zznl zznlVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzc(zznlVar, sb, 0);
        return sb.toString();
    }

    public static void zzb(StringBuilder sb, int i4, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzb(sb, i4, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzb(sb, i4, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        zzd(i4, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i5 = 1; i5 < str.length(); i5++) {
                char cCharAt = str.charAt(i5);
                if (Character.isUpperCase(cCharAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(cCharAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            zzlg zzlgVar = zzlg.zzb;
            sb.append(zzof.zza(new zzlf(((String) obj).getBytes(zzmo.zza))));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzlg) {
            sb.append(": \"");
            sb.append(zzof.zza((zzlg) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzme) {
            sb.append(" {");
            zzc((zzme) obj, sb, i4 + 2);
            sb.append("\n");
            zzd(i4, sb);
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        int i6 = i4 + 2;
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        zzb(sb, i6, "key", entry.getKey());
        zzb(sb, i6, "value", entry.getValue());
        sb.append("\n");
        zzd(i4, sb);
        sb.append("}");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void zzc(com.google.android.gms.internal.measurement.zznl r18, java.lang.StringBuilder r19, int r20) {
        /*
            Method dump skipped, instruction units count: 555
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zznn.zzc(com.google.android.gms.internal.measurement.zznl, java.lang.StringBuilder, int):void");
    }

    private static void zzd(int i4, StringBuilder sb) {
        while (i4 > 0) {
            int i5 = 80;
            if (i4 <= 80) {
                i5 = i4;
            }
            sb.append(zza, 0, i5);
            i4 -= i5;
        }
    }
}
