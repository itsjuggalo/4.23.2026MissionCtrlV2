package i2;

import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class F2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final E2 f15101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f15103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f15104d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f15105e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f15106f;

    public /* synthetic */ F2(String str, E2 e22, int i7, Throwable th, byte[] bArr, Map map, byte[] bArr2) {
        AbstractC1207s.k(e22);
        this.f15101a = e22;
        this.f15102b = i7;
        this.f15103c = th;
        this.f15104d = bArr;
        this.f15105e = str;
        this.f15106f = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f15101a.a(this.f15105e, this.f15102b, this.f15103c, this.f15104d, this.f15106f);
    }
}
