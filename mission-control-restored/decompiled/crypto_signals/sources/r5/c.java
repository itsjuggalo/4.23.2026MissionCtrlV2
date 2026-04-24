package r5;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f9482a = new char[117];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f9483b = new byte[126];

    static {
        int i = 0;
        for (int i6 = 0; i6 < 32; i6++) {
        }
        a('b', 8);
        a('t', 9);
        a('n', 10);
        a('f', 12);
        a('r', 13);
        a('/', 47);
        a('\"', 34);
        a('\\', 92);
        while (true) {
            byte[] bArr = f9483b;
            if (i >= 33) {
                bArr[9] = 3;
                bArr[10] = 3;
                bArr[13] = 3;
                bArr[32] = 3;
                bArr[44] = 4;
                bArr[58] = 5;
                bArr[123] = 6;
                bArr[125] = 7;
                bArr[91] = 8;
                bArr[93] = 9;
                bArr[34] = 1;
                bArr[92] = 2;
                return;
            }
            bArr[i] = 127;
            i++;
        }
    }

    public static void a(char c6, int i) {
        if (c6 != 'u') {
            f9482a[c6] = (char) i;
        }
    }
}
