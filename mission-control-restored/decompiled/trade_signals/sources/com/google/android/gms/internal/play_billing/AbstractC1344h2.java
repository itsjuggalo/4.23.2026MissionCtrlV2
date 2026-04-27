package com.google.android.gms.internal.play_billing;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.h2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1344h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f15423a;

    static {
        char[] cArr = new char[80];
        f15423a = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static String a(InterfaceC1334f2 interfaceC1334f2, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        d(interfaceC1334f2, sb, 0);
        return sb.toString();
    }

    public static void b(StringBuilder sb, int i8, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                b(sb, i8, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                b(sb, i8, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        c(i8, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i9 = 1; i9 < str.length(); i9++) {
                char cCharAt = str.charAt(i9);
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
            AbstractC1378o1 abstractC1378o1 = AbstractC1378o1.f15475b;
            sb.append(AbstractC1403t2.a(new C1368m1(((String) obj).getBytes(P1.f15203a))));
            sb.append('\"');
            return;
        }
        if (obj instanceof AbstractC1378o1) {
            sb.append(": \"");
            sb.append(AbstractC1403t2.a((AbstractC1378o1) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof J1) {
            sb.append(" {");
            d((J1) obj, sb, i8 + 2);
            sb.append("\n");
            c(i8, sb);
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        int i10 = i8 + 2;
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        b(sb, i10, "key", entry.getKey());
        b(sb, i10, "value", entry.getValue());
        sb.append("\n");
        c(i8, sb);
        sb.append("}");
    }

    public static void c(int i8, StringBuilder sb) {
        while (i8 > 0) {
            int i9 = 80;
            if (i8 <= 80) {
                i9 = i8;
            }
            sb.append(f15423a, 0, i9);
            i8 -= i9;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void d(com.google.android.gms.internal.play_billing.InterfaceC1334f2 r18, java.lang.StringBuilder r19, int r20) {
        /*
            Method dump skipped, instruction units count: 515
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.AbstractC1344h2.d(com.google.android.gms.internal.play_billing.f2, java.lang.StringBuilder, int):void");
    }
}
