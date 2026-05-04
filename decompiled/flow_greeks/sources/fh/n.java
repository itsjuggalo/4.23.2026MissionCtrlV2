package fh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f9600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9601b;

    public n(w writer) {
        kotlin.jvm.internal.t.f(writer, "writer");
        this.f9600a = writer;
        this.f9601b = true;
    }

    public final boolean a() {
        return this.f9601b;
    }

    public void b() {
        this.f9601b = true;
    }

    public void c() {
        this.f9601b = false;
    }

    public void d() {
        this.f9601b = false;
    }

    public void e(byte b10) {
        this.f9600a.writeLong(b10);
    }

    public final void f(char c10) {
        this.f9600a.a(c10);
    }

    public void g(double d10) {
        this.f9600a.c(String.valueOf(d10));
    }

    public void h(float f10) {
        this.f9600a.c(String.valueOf(f10));
    }

    public void i(int i10) {
        this.f9600a.writeLong(i10);
    }

    public void j(long j10) {
        this.f9600a.writeLong(j10);
    }

    public final void k(String v10) {
        kotlin.jvm.internal.t.f(v10, "v");
        this.f9600a.c(v10);
    }

    public void l(short s10) {
        this.f9600a.writeLong(s10);
    }

    public void m(boolean z10) {
        this.f9600a.c(String.valueOf(z10));
    }

    public void n(String value) {
        kotlin.jvm.internal.t.f(value, "value");
        this.f9600a.b(value);
    }

    public final void o(boolean z10) {
        this.f9601b = z10;
    }

    public void p() {
    }

    public void q() {
    }
}
