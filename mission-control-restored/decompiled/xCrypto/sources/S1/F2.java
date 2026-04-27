package S1;

import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class F2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final E2 f3942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f3944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f3945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f3946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f3947f;

    public /* synthetic */ F2(String str, E2 e22, int i4, Throwable th, byte[] bArr, Map map, byte[] bArr2) {
        AbstractC0940s.k(e22);
        this.f3942a = e22;
        this.f3943b = i4;
        this.f3944c = th;
        this.f3945d = bArr;
        this.f3946e = str;
        this.f3947f = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3942a.a(this.f3946e, this.f3943b, this.f3944c, this.f3945d, this.f3947f);
    }
}
