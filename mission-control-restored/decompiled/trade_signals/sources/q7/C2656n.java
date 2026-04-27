package q7;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: q7.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2656n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f22898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f22899b;

    public C2656n(A writer) {
        AbstractC2304t.f(writer, "writer");
        this.f22898a = writer;
        this.f22899b = true;
    }

    public final boolean a() {
        return this.f22899b;
    }

    public void b() {
        this.f22899b = true;
    }

    public void c() {
        this.f22899b = false;
    }

    public void d() {
        this.f22899b = false;
    }

    public void e(byte b8) {
        this.f22898a.c(b8);
    }

    public final void f(char c8) {
        this.f22898a.a(c8);
    }

    public void g(double d8) {
        this.f22898a.d(String.valueOf(d8));
    }

    public void h(float f8) {
        this.f22898a.d(String.valueOf(f8));
    }

    public void i(int i8) {
        this.f22898a.c(i8);
    }

    public void j(long j8) {
        this.f22898a.c(j8);
    }

    public final void k(String v8) {
        AbstractC2304t.f(v8, "v");
        this.f22898a.d(v8);
    }

    public void l(short s8) {
        this.f22898a.c(s8);
    }

    public void m(boolean z7) {
        this.f22898a.d(String.valueOf(z7));
    }

    public void n(String value) {
        AbstractC2304t.f(value, "value");
        this.f22898a.b(value);
    }

    public final void o(boolean z7) {
        this.f22899b = z7;
    }

    public void p() {
    }

    public void q() {
    }
}
