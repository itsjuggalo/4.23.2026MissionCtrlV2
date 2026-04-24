package t6;

/* JADX INFO: renamed from: t6.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2723m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f24333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f24334b;

    public C2723m(T writer) {
        kotlin.jvm.internal.r.f(writer, "writer");
        this.f24333a = writer;
        this.f24334b = true;
    }

    public final boolean a() {
        return this.f24334b;
    }

    public void b() {
        this.f24334b = true;
    }

    public void c() {
        this.f24334b = false;
    }

    public void d(byte b7) {
        this.f24333a.c(b7);
    }

    public final void e(char c7) {
        this.f24333a.a(c7);
    }

    public void f(double d7) {
        this.f24333a.d(String.valueOf(d7));
    }

    public void g(float f7) {
        this.f24333a.d(String.valueOf(f7));
    }

    public void h(int i7) {
        this.f24333a.c(i7);
    }

    public void i(long j7) {
        this.f24333a.c(j7);
    }

    public final void j(String v7) {
        kotlin.jvm.internal.r.f(v7, "v");
        this.f24333a.d(v7);
    }

    public void k(short s7) {
        this.f24333a.c(s7);
    }

    public void l(boolean z7) {
        this.f24333a.d(String.valueOf(z7));
    }

    public void m(String value) {
        kotlin.jvm.internal.r.f(value, "value");
        this.f24333a.b(value);
    }

    public final void n(boolean z7) {
        this.f24334b = z7;
    }

    public void o() {
    }

    public void p() {
    }
}
