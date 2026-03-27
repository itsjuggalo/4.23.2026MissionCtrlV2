package L3;

/* JADX INFO: renamed from: L3.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0390m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f1540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1541b;

    public C0390m(T writer) {
        kotlin.jvm.internal.r.f(writer, "writer");
        this.f1540a = writer;
        this.f1541b = true;
    }

    public final boolean a() {
        return this.f1541b;
    }

    public void b() {
        this.f1541b = true;
    }

    public void c() {
        this.f1541b = false;
    }

    public void d(byte b4) {
        this.f1540a.c(b4);
    }

    public final void e(char c4) {
        this.f1540a.a(c4);
    }

    public void f(double d4) {
        this.f1540a.d(String.valueOf(d4));
    }

    public void g(float f4) {
        this.f1540a.d(String.valueOf(f4));
    }

    public void h(int i4) {
        this.f1540a.c(i4);
    }

    public void i(long j4) {
        this.f1540a.c(j4);
    }

    public final void j(String v4) {
        kotlin.jvm.internal.r.f(v4, "v");
        this.f1540a.d(v4);
    }

    public void k(short s4) {
        this.f1540a.c(s4);
    }

    public void l(boolean z4) {
        this.f1540a.d(String.valueOf(z4));
    }

    public void m(String value) {
        kotlin.jvm.internal.r.f(value, "value");
        this.f1540a.b(value);
    }

    public final void n(boolean z4) {
        this.f1541b = z4;
    }

    public void o() {
    }

    public void p() {
    }
}
