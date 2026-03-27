package t2;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: t2.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1791h extends y2.c {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Writer f14776r = new a();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final q2.o f14777s = new q2.o("closed");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List f14778o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f14779p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public q2.j f14780q;

    /* JADX INFO: renamed from: t2.h$a */
    public class a extends Writer {
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i4, int i5) {
            throw new AssertionError();
        }
    }

    public C1791h() {
        super(f14776r);
        this.f14778o = new ArrayList();
        this.f14780q = q2.l.f14271a;
    }

    @Override // y2.c
    public y2.c E() {
        if (this.f14778o.isEmpty() || this.f14779p != null) {
            throw new IllegalStateException();
        }
        if (!(w0() instanceof q2.g)) {
            throw new IllegalStateException();
        }
        this.f14778o.remove(r0.size() - 1);
        return this;
    }

    @Override // y2.c
    public y2.c G() {
        if (this.f14778o.isEmpty() || this.f14779p != null) {
            throw new IllegalStateException();
        }
        if (!(w0() instanceof q2.m)) {
            throw new IllegalStateException();
        }
        this.f14778o.remove(r0.size() - 1);
        return this;
    }

    @Override // y2.c
    public y2.c a0(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f14778o.isEmpty() || this.f14779p != null) {
            throw new IllegalStateException("Did not expect a name");
        }
        if (!(w0() instanceof q2.m)) {
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        this.f14779p = str;
        return this;
    }

    @Override // y2.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f14778o.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.f14778o.add(f14777s);
    }

    @Override // y2.c
    public y2.c e0() {
        x0(q2.l.f14271a);
        return this;
    }

    @Override // y2.c
    public y2.c o0(double d4) {
        if (S() || !(Double.isNaN(d4) || Double.isInfinite(d4))) {
            x0(new q2.o(Double.valueOf(d4)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d4);
    }

    @Override // y2.c
    public y2.c p() {
        q2.g gVar = new q2.g();
        x0(gVar);
        this.f14778o.add(gVar);
        return this;
    }

    @Override // y2.c
    public y2.c p0(long j4) {
        x0(new q2.o(Long.valueOf(j4)));
        return this;
    }

    @Override // y2.c
    public y2.c q0(Boolean bool) {
        if (bool == null) {
            return e0();
        }
        x0(new q2.o(bool));
        return this;
    }

    @Override // y2.c
    public y2.c r0(Number number) {
        if (number == null) {
            return e0();
        }
        if (!S()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        x0(new q2.o(number));
        return this;
    }

    @Override // y2.c
    public y2.c s0(String str) {
        if (str == null) {
            return e0();
        }
        x0(new q2.o(str));
        return this;
    }

    @Override // y2.c
    public y2.c t0(boolean z4) {
        x0(new q2.o(Boolean.valueOf(z4)));
        return this;
    }

    public q2.j v0() {
        if (this.f14778o.isEmpty()) {
            return this.f14780q;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f14778o);
    }

    public final q2.j w0() {
        return (q2.j) this.f14778o.get(r0.size() - 1);
    }

    @Override // y2.c
    public y2.c x() {
        q2.m mVar = new q2.m();
        x0(mVar);
        this.f14778o.add(mVar);
        return this;
    }

    public final void x0(q2.j jVar) {
        if (this.f14779p != null) {
            if (!jVar.n() || J()) {
                ((q2.m) w0()).q(this.f14779p, jVar);
            }
            this.f14779p = null;
            return;
        }
        if (this.f14778o.isEmpty()) {
            this.f14780q = jVar;
            return;
        }
        q2.j jVarW0 = w0();
        if (!(jVarW0 instanceof q2.g)) {
            throw new IllegalStateException();
        }
        ((q2.g) jVarW0).q(jVar);
    }

    @Override // y2.c, java.io.Flushable
    public void flush() {
    }
}
