package rb;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e1 extends g {
    @Override // rb.g
    public void a(String str, Throwable th) {
        f().a(str, th);
    }

    @Override // rb.g
    public void b() {
        f().b();
    }

    @Override // rb.g
    public void c(int i10) {
        f().c(i10);
    }

    public abstract g f();

    public String toString() {
        return p6.h.b(this).d("delegate", f()).toString();
    }
}
