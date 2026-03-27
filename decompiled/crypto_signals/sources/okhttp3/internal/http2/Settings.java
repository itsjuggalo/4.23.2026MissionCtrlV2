package okhttp3.internal.http2;

/* JADX INFO: loaded from: classes.dex */
public final class Settings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f8945b = new int[10];

    public final int a() {
        if ((this.f8944a & 128) != 0) {
            return this.f8945b[7];
        }
        return 65535;
    }

    public final void b(int i, int i6) {
        if (i >= 0) {
            int[] iArr = this.f8945b;
            if (i >= iArr.length) {
                return;
            }
            this.f8944a = (1 << i) | this.f8944a;
            iArr[i] = i6;
        }
    }
}
