package u1;

import com.google.android.gms.common.internal.I;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: u1.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CallableC1211m implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f10300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f10301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BinderC1214p f10302c;

    public /* synthetic */ CallableC1211m(boolean z6, String str, BinderC1214p binderC1214p) {
        this.f10300a = z6;
        this.f10301b = str;
        this.f10302c = binderC1214p;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        MessageDigest messageDigest;
        BinderC1214p binderC1214p = this.f10302c;
        boolean z6 = this.f10300a;
        String str = this.f10301b;
        String str2 = (z6 || !r.a(str, binderC1214p, true, false).f10327a) ? "not allowed" : "debug cert rejected";
        int i = 0;
        while (true) {
            if (i >= 2) {
                messageDigest = null;
                break;
            }
            try {
                messageDigest = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                break;
            }
            i++;
        }
        I.g(messageDigest);
        byte[] bArrDigest = messageDigest.digest(binderC1214p.f10307c);
        int length = bArrDigest.length;
        char[] cArr = new char[length + length];
        int i6 = 0;
        for (byte b3 : bArrDigest) {
            char[] cArr2 = B1.c.f113b;
            cArr[i6] = cArr2[(b3 & 255) >>> 4];
            cArr[i6 + 1] = cArr2[b3 & 15];
            i6 += 2;
        }
        return str2 + ": pkg=" + str + ", sha256=" + new String(cArr) + ", atk=" + z6 + ", ver=12451000.false";
    }
}
