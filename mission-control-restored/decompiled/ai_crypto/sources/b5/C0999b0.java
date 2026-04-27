package b5;

import b5.AbstractC1001c0;

/* JADX INFO: renamed from: b5.b0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0999b0 implements AbstractC1001c0.l {
    @Override // b5.AbstractC1001c0.l
    public void e(String str, String str2, AbstractC1001c0.G g7) {
        ((Z2.Z) C0997a0.f8645a.get(str)).h(str2);
        g7.a();
    }

    @Override // b5.AbstractC1001c0.l
    public void f(String str, String str2, String str3, AbstractC1001c0.F f7) {
        Z2.Z z7 = (Z2.Z) C0997a0.f8645a.get(str);
        if (str2 == null || str3 == null) {
            f7.a(z7.e());
        } else {
            f7.a(z7.d(str2, str3));
        }
    }
}
