package p6;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: p6.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2607j {
    public static final byte[] a(String[] strings) {
        AbstractC2304t.f(strings, "strings");
        int length = 0;
        for (String str : strings) {
            length += str.length();
        }
        byte[] bArr = new byte[length];
        int i8 = 0;
        for (String str2 : strings) {
            int length2 = str2.length();
            int i9 = 0;
            while (i9 < length2) {
                bArr[i8] = (byte) str2.charAt(i9);
                i9++;
                i8++;
            }
        }
        return bArr;
    }
}
