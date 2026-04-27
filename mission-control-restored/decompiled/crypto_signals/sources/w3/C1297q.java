package w3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: renamed from: w3.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1297q extends B3.b {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final C1296p f10798v = new C1296p();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final t3.l f10799w = new t3.l("closed");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ArrayList f10800s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f10801t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public t3.h f10802u;

    public C1297q() {
        super(f10798v);
        this.f10800s = new ArrayList();
        this.f10802u = t3.j.f10247a;
    }

    @Override // B3.b, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        ArrayList arrayList = this.f10800s;
        if (!arrayList.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        arrayList.add(f10799w);
    }

    @Override // B3.b
    public final void f() {
        t3.f fVar = new t3.f();
        z(fVar);
        this.f10800s.add(fVar);
    }

    @Override // B3.b
    public final void g() {
        t3.k kVar = new t3.k();
        z(kVar);
        this.f10800s.add(kVar);
    }

    @Override // B3.b
    public final void i() {
        ArrayList arrayList = this.f10800s;
        if (arrayList.isEmpty() || this.f10801t != null) {
            throw new IllegalStateException();
        }
        if (!(y() instanceof t3.f)) {
            throw new IllegalStateException();
        }
        arrayList.remove(arrayList.size() - 1);
    }

    @Override // B3.b
    public final void j() {
        ArrayList arrayList = this.f10800s;
        if (arrayList.isEmpty() || this.f10801t != null) {
            throw new IllegalStateException();
        }
        if (!(y() instanceof t3.k)) {
            throw new IllegalStateException();
        }
        arrayList.remove(arrayList.size() - 1);
    }

    @Override // B3.b
    public final void k(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f10800s.isEmpty() || this.f10801t != null) {
            throw new IllegalStateException("Did not expect a name");
        }
        if (!(y() instanceof t3.k)) {
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        this.f10801t = str;
    }

    @Override // B3.b
    public final B3.b m() {
        z(t3.j.f10247a);
        return this;
    }

    @Override // B3.b
    public final void r(double d4) {
        if (this.f170l == 1 || (!Double.isNaN(d4) && !Double.isInfinite(d4))) {
            z(new t3.l(Double.valueOf(d4)));
        } else {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d4);
        }
    }

    @Override // B3.b
    public final void s(long j4) {
        z(new t3.l(Long.valueOf(j4)));
    }

    @Override // B3.b
    public final void t(Boolean bool) {
        if (bool == null) {
            z(t3.j.f10247a);
        } else {
            z(new t3.l(bool));
        }
    }

    @Override // B3.b
    public final void u(Number number) {
        if (number == null) {
            z(t3.j.f10247a);
            return;
        }
        if (this.f170l != 1) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        z(new t3.l(number));
    }

    @Override // B3.b
    public final void v(String str) {
        if (str == null) {
            z(t3.j.f10247a);
        } else {
            z(new t3.l(str));
        }
    }

    @Override // B3.b
    public final void w(boolean z6) {
        z(new t3.l(Boolean.valueOf(z6)));
    }

    public final t3.h y() {
        return (t3.h) this.f10800s.get(r0.size() - 1);
    }

    public final void z(t3.h hVar) {
        if (this.f10801t != null) {
            if (!(hVar instanceof t3.j) || this.f173o) {
                t3.k kVar = (t3.k) y();
                String str = this.f10801t;
                kVar.getClass();
                kVar.f10248a.put(str, hVar);
            }
            this.f10801t = null;
            return;
        }
        if (this.f10800s.isEmpty()) {
            this.f10802u = hVar;
            return;
        }
        t3.h hVarY = y();
        if (!(hVarY instanceof t3.f)) {
            throw new IllegalStateException();
        }
        ((t3.f) hVarY).f10246a.add(hVar);
    }

    @Override // B3.b, java.io.Flushable
    public final void flush() {
    }
}
