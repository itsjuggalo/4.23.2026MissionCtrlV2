package w4;

import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f11241a = Logger.getLogger(d2.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f11242b = "-bin".getBytes(U1.d.f3106a);

    public static boolean a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length - bArr2.length;
        if (length < 0) {
            return false;
        }
        for (int i = length; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i - length]) {
                return false;
            }
        }
        return true;
    }
}
