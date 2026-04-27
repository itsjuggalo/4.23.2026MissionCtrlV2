package H4;

import G4.V0;
import u7.C2811d;

/* JADX INFO: loaded from: classes2.dex */
public class p implements V0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2811d f3937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3939c;

    public p(C2811d c2811d, int i8) {
        this.f3937a = c2811d;
        this.f3938b = i8;
    }

    @Override // G4.V0
    public void a(byte[] bArr, int i8, int i9) {
        this.f3937a.A0(bArr, i8, i9);
        this.f3938b -= i9;
        this.f3939c += i9;
    }

    @Override // G4.V0
    public int b() {
        return this.f3938b;
    }

    @Override // G4.V0
    public void c(byte b8) {
        this.f3937a.x(b8);
        this.f3938b--;
        this.f3939c++;
    }

    @Override // G4.V0
    public int d() {
        return this.f3939c;
    }

    public C2811d e() {
        return this.f3937a;
    }

    @Override // G4.V0
    public void release() {
    }
}
