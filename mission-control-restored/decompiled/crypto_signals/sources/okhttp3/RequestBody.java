package okhttp3;

import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes.dex */
public abstract class RequestBody {

    /* JADX INFO: renamed from: okhttp3.RequestBody$1, reason: invalid class name */
    class AnonymousClass1 extends RequestBody {
    }

    /* JADX INFO: renamed from: okhttp3.RequestBody$2, reason: invalid class name */
    class AnonymousClass2 extends RequestBody {
    }

    /* JADX INFO: renamed from: okhttp3.RequestBody$3, reason: invalid class name */
    class AnonymousClass3 extends RequestBody {
    }

    public static void a(byte[] bArr) {
        int length = bArr.length;
        long length2 = bArr.length;
        long j4 = 0;
        long j6 = length;
        byte[] bArr2 = Util.f8827a;
        if ((j4 | j6) < 0 || j4 > length2 || length2 - j4 < j6) {
            throw new ArrayIndexOutOfBoundsException();
        }
        new AnonymousClass2();
    }
}
