package F4;

import v2.AbstractC2842h;

/* JADX INFO: loaded from: classes.dex */
public abstract class d0 extends AbstractC0493g {
    @Override // F4.AbstractC0493g
    public void a(String str, Throwable th) {
        f().a(str, th);
    }

    @Override // F4.AbstractC0493g
    public void b() {
        f().b();
    }

    @Override // F4.AbstractC0493g
    public void c(int i8) {
        f().c(i8);
    }

    public abstract AbstractC0493g f();

    public String toString() {
        return AbstractC2842h.b(this).d("delegate", f()).toString();
    }
}
