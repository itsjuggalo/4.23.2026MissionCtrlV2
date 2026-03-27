package w6;

import java.util.Arrays;
import w6.C2795h;

/* JADX INFO: renamed from: w6.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2788a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f25067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f25068b;

    static {
        C2795h.a aVar = C2795h.f25106d;
        f25067a = aVar.c("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").m();
        f25068b = aVar.c("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").m();
    }

    public static final byte[] a(String str) {
        int i7;
        char cCharAt;
        kotlin.jvm.internal.r.f(str, "<this>");
        int length = str.length();
        while (length > 0 && ((cCharAt = str.charAt(length - 1)) == '=' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == '\t')) {
            length--;
        }
        int i8 = (int) ((((long) length) * 6) / 8);
        byte[] bArr = new byte[i8];
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            char cCharAt2 = str.charAt(i12);
            if ('A' <= cCharAt2 && cCharAt2 < '[') {
                i7 = cCharAt2 - 'A';
            } else if ('a' <= cCharAt2 && cCharAt2 < '{') {
                i7 = cCharAt2 - 'G';
            } else if ('0' <= cCharAt2 && cCharAt2 < ':') {
                i7 = cCharAt2 + 4;
            } else if (cCharAt2 == '+' || cCharAt2 == '-') {
                i7 = 62;
            } else if (cCharAt2 == '/' || cCharAt2 == '_') {
                i7 = 63;
            } else {
                if (cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ' && cCharAt2 != '\t') {
                    return null;
                }
            }
            i10 = (i10 << 6) | i7;
            i9++;
            if (i9 % 4 == 0) {
                bArr[i11] = (byte) (i10 >> 16);
                int i13 = i11 + 2;
                bArr[i11 + 1] = (byte) (i10 >> 8);
                i11 += 3;
                bArr[i13] = (byte) i10;
            }
        }
        int i14 = i9 % 4;
        if (i14 == 1) {
            return null;
        }
        if (i14 == 2) {
            bArr[i11] = (byte) ((i10 << 12) >> 16);
            i11++;
        } else if (i14 == 3) {
            int i15 = i10 << 6;
            int i16 = i11 + 1;
            bArr[i11] = (byte) (i15 >> 16);
            i11 += 2;
            bArr[i16] = (byte) (i15 >> 8);
        }
        if (i11 == i8) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i11);
        kotlin.jvm.internal.r.e(bArrCopyOf, "copyOf(this, newSize)");
        return bArrCopyOf;
    }

    public static final String b(byte[] bArr, byte[] map) {
        kotlin.jvm.internal.r.f(bArr, "<this>");
        kotlin.jvm.internal.r.f(map, "map");
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i7 = 0;
        int i8 = 0;
        while (i7 < length) {
            byte b7 = bArr[i7];
            int i9 = i7 + 2;
            byte b8 = bArr[i7 + 1];
            i7 += 3;
            byte b9 = bArr[i9];
            bArr2[i8] = map[(b7 & 255) >> 2];
            bArr2[i8 + 1] = map[((b7 & 3) << 4) | ((b8 & 255) >> 4)];
            int i10 = i8 + 3;
            bArr2[i8 + 2] = map[((b8 & 15) << 2) | ((b9 & 255) >> 6)];
            i8 += 4;
            bArr2[i10] = map[b9 & 63];
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b10 = bArr[i7];
            bArr2[i8] = map[(b10 & 255) >> 2];
            bArr2[i8 + 1] = map[(b10 & 3) << 4];
            bArr2[i8 + 2] = 61;
            bArr2[i8 + 3] = 61;
        } else if (length2 == 2) {
            int i11 = i7 + 1;
            byte b11 = bArr[i7];
            byte b12 = bArr[i11];
            bArr2[i8] = map[(b11 & 255) >> 2];
            bArr2[i8 + 1] = map[((b11 & 3) << 4) | ((b12 & 255) >> 4)];
            bArr2[i8 + 2] = map[(b12 & 15) << 2];
            bArr2[i8 + 3] = 61;
        }
        return c0.c(bArr2);
    }

    public static /* synthetic */ String c(byte[] bArr, byte[] bArr2, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            bArr2 = f25067a;
        }
        return b(bArr, bArr2);
    }
}
