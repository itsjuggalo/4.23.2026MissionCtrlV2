package com.google.android.gms.internal.play_billing;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzio {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static String zza(zzim zzimVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzimVar, sb, 0);
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
        zzc(i4, sb);
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
            sb.append(zzjh.zza(new zzgi(((String) obj).getBytes(zzhp.zza))));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzgk) {
            sb.append(": \"");
            sb.append(zzjh.zza((zzgk) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzhk) {
            sb.append(" {");
            zzd((zzhk) obj, sb, i4 + 2);
            sb.append("\n");
            zzc(i4, sb);
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
        zzc(i4, sb);
        sb.append("}");
    }

    private static void zzc(int i4, StringBuilder sb) {
        while (i4 > 0) {
            int i5 = 80;
            if (i4 <= 80) {
                i5 = i4;
            }
            sb.append(zza, 0, i5);
            i4 -= i5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void zzd(com.google.android.gms.internal.play_billing.zzim r18, java.lang.StringBuilder r19, int r20) {
        /*
            Method dump skipped, instruction units count: 555
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzio.zzd(com.google.android.gms.internal.play_billing.zzim, java.lang.StringBuilder, int):void");
    }
}
