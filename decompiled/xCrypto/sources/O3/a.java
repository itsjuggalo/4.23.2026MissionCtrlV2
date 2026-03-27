package O3;

import O3.g;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f3304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f3305b;

    static {
        g.a aVar = g.f3330d;
        f3304a = aVar.a("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").i();
        f3305b = aVar.a("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").i();
    }

    public static final String a(byte[] bArr, byte[] map) {
        kotlin.jvm.internal.r.f(bArr, "<this>");
        kotlin.jvm.internal.r.f(map, "map");
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            byte b4 = bArr[i4];
            int i6 = i4 + 2;
            byte b5 = bArr[i4 + 1];
            i4 += 3;
            byte b6 = bArr[i6];
            bArr2[i5] = map[(b4 & 255) >> 2];
            bArr2[i5 + 1] = map[((b4 & 3) << 4) | ((b5 & 255) >> 4)];
            int i7 = i5 + 3;
            bArr2[i5 + 2] = map[((b5 & 15) << 2) | ((b6 & 255) >> 6)];
            i5 += 4;
            bArr2[i7] = map[b6 & 63];
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b7 = bArr[i4];
            bArr2[i5] = map[(b7 & 255) >> 2];
            bArr2[i5 + 1] = map[(b7 & 3) << 4];
            bArr2[i5 + 2] = 61;
            bArr2[i5 + 3] = 61;
        } else if (length2 == 2) {
            int i8 = i4 + 1;
            byte b8 = bArr[i4];
            byte b9 = bArr[i8];
            bArr2[i5] = map[(b8 & 255) >> 2];
            bArr2[i5 + 1] = map[((b8 & 3) << 4) | ((b9 & 255) >> 4)];
            bArr2[i5 + 2] = map[(b9 & 15) << 2];
            bArr2[i5 + 3] = 61;
        }
        return v.b(bArr2);
    }

    public static /* synthetic */ String b(byte[] bArr, byte[] bArr2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            bArr2 = f3304a;
        }
        return a(bArr, bArr2);
    }
}
