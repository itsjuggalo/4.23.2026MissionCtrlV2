package u7;

import kotlin.jvm.internal.AbstractC2304t;
import u7.C2814g;

/* JADX INFO: renamed from: u7.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2808a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f23621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f23622b;

    static {
        C2814g.a aVar = C2814g.f23648d;
        f23621a = aVar.a("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").l();
        f23622b = aVar.a("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").l();
    }

    public static final String a(byte[] bArr, byte[] map) {
        AbstractC2304t.f(bArr, "<this>");
        AbstractC2304t.f(map, "map");
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i8 = 0;
        int i9 = 0;
        while (i8 < length) {
            byte b8 = bArr[i8];
            int i10 = i8 + 2;
            byte b9 = bArr[i8 + 1];
            i8 += 3;
            byte b10 = bArr[i10];
            bArr2[i9] = map[(b8 & 255) >> 2];
            bArr2[i9 + 1] = map[((b8 & 3) << 4) | ((b9 & 255) >> 4)];
            int i11 = i9 + 3;
            bArr2[i9 + 2] = map[((b9 & 15) << 2) | ((b10 & 255) >> 6)];
            i9 += 4;
            bArr2[i11] = map[b10 & 63];
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b11 = bArr[i8];
            bArr2[i9] = map[(b11 & 255) >> 2];
            bArr2[i9 + 1] = map[(b11 & 3) << 4];
            bArr2[i9 + 2] = 61;
            bArr2[i9 + 3] = 61;
        } else if (length2 == 2) {
            int i12 = i8 + 1;
            byte b12 = bArr[i8];
            byte b13 = bArr[i12];
            bArr2[i9] = map[(b12 & 255) >> 2];
            bArr2[i9 + 1] = map[((b12 & 3) << 4) | ((b13 & 255) >> 4)];
            bArr2[i9 + 2] = map[(b13 & 15) << 2];
            bArr2[i9 + 3] = 61;
        }
        return Y.c(bArr2);
    }

    public static /* synthetic */ String b(byte[] bArr, byte[] bArr2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            bArr2 = f23621a;
        }
        return a(bArr, bArr2);
    }
}
