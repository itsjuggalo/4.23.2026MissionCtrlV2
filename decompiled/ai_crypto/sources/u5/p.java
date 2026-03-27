package u5;

import t5.V0;
import w6.C2792e;

/* JADX INFO: loaded from: classes2.dex */
public class p implements V0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2792e f24672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f24673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f24674c;

    public p(C2792e c2792e, int i7) {
        this.f24672a = c2792e;
        this.f24673b = i7;
    }

    public C2792e a() {
        return this.f24672a;
    }

    @Override // t5.V0
    public int e() {
        return this.f24674c;
    }

    @Override // t5.V0
    public void g(byte[] bArr, int i7, int i8) {
        this.f24672a.g(bArr, i7, i8);
        this.f24673b -= i8;
        this.f24674c += i8;
    }

    @Override // t5.V0
    public int h() {
        return this.f24673b;
    }

    @Override // t5.V0
    public void i(byte b7) {
        this.f24672a.v(b7);
        this.f24673b--;
        this.f24674c++;
    }

    @Override // t5.V0
    public void release() {
    }
}
