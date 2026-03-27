package W1;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f9262a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f9263b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length + length];
        int i8 = 0;
        for (byte b8 : bArr) {
            char[] cArr2 = f9263b;
            cArr[i8] = cArr2[(b8 & 255) >>> 4];
            cArr[i8 + 1] = cArr2[b8 & 15];
            i8 += 2;
        }
        return new String(cArr);
    }

    public static String b(byte[] bArr, boolean z7) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (int i8 = 0; i8 < length && (!z7 || i8 != length - 1 || (bArr[i8] & 255) != 0); i8++) {
            char[] cArr = f9262a;
            sb.append(cArr[(bArr[i8] & 240) >>> 4]);
            sb.append(cArr[bArr[i8] & 15]);
        }
        return sb.toString();
    }
}
