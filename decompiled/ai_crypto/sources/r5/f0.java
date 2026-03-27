package r5;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f0 extends AbstractC2591g {
    @Override // r5.AbstractC2591g
    public void a(String str, Throwable th) {
        f().a(str, th);
    }

    @Override // r5.AbstractC2591g
    public void b() {
        f().b();
    }

    @Override // r5.AbstractC2591g
    public void c(int i7) {
        f().c(i7);
    }

    public abstract AbstractC2591g f();

    public String toString() {
        return H2.g.b(this).d("delegate", f()).toString();
    }
}
