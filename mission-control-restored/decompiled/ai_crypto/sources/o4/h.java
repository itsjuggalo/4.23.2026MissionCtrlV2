package o4;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import l4.AbstractC2177j;
import l4.C2174g;

/* JADX INFO: loaded from: classes.dex */
public final class h extends t4.c {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Writer f20085r = new a();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final l4.o f20086s = new l4.o("closed");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List f20087o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f20088p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public AbstractC2177j f20089q;

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
        public void write(char[] cArr, int i7, int i8) {
            throw new AssertionError();
        }
    }

    public h() {
        super(f20085r);
        this.f20087o = new ArrayList();
        this.f20089q = l4.l.f18379a;
    }

    @Override // t4.c
    public t4.c G() {
        C2174g c2174g = new C2174g();
        S0(c2174g);
        this.f20087o.add(c2174g);
        return this;
    }

    @Override // t4.c
    public t4.c H() {
        l4.m mVar = new l4.m();
        S0(mVar);
        this.f20087o.add(mVar);
        return this;
    }

    @Override // t4.c
    public t4.c J0(double d7) {
        if (c0() || !(Double.isNaN(d7) || Double.isInfinite(d7))) {
            S0(new l4.o(Double.valueOf(d7)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d7);
    }

    @Override // t4.c
    public t4.c K0(long j7) {
        S0(new l4.o(Long.valueOf(j7)));
        return this;
    }

    @Override // t4.c
    public t4.c L0(Boolean bool) {
        if (bool == null) {
            return z0();
        }
        S0(new l4.o(bool));
        return this;
    }

    @Override // t4.c
    public t4.c M() {
        if (this.f20087o.isEmpty() || this.f20088p != null) {
            throw new IllegalStateException();
        }
        if (!(R0() instanceof C2174g)) {
            throw new IllegalStateException();
        }
        this.f20087o.remove(r0.size() - 1);
        return this;
    }

    @Override // t4.c
    public t4.c M0(Number number) {
        if (number == null) {
            return z0();
        }
        if (!c0()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        S0(new l4.o(number));
        return this;
    }

    @Override // t4.c
    public t4.c N0(String str) {
        if (str == null) {
            return z0();
        }
        S0(new l4.o(str));
        return this;
    }

    @Override // t4.c
    public t4.c O() {
        if (this.f20087o.isEmpty() || this.f20088p != null) {
            throw new IllegalStateException();
        }
        if (!(R0() instanceof l4.m)) {
            throw new IllegalStateException();
        }
        this.f20087o.remove(r0.size() - 1);
        return this;
    }

    @Override // t4.c
    public t4.c O0(boolean z7) {
        S0(new l4.o(Boolean.valueOf(z7)));
        return this;
    }

    public AbstractC2177j Q0() {
        if (this.f20087o.isEmpty()) {
            return this.f20089q;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f20087o);
    }

    public final AbstractC2177j R0() {
        return (AbstractC2177j) this.f20087o.get(r0.size() - 1);
    }

    public final void S0(AbstractC2177j abstractC2177j) {
        if (this.f20088p != null) {
            if (!abstractC2177j.k() || T()) {
                ((l4.m) R0()).n(this.f20088p, abstractC2177j);
            }
            this.f20088p = null;
            return;
        }
        if (this.f20087o.isEmpty()) {
            this.f20089q = abstractC2177j;
            return;
        }
        AbstractC2177j abstractC2177jR0 = R0();
        if (!(abstractC2177jR0 instanceof C2174g)) {
            throw new IllegalStateException();
        }
        ((C2174g) abstractC2177jR0).n(abstractC2177j);
    }

    @Override // t4.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f20087o.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.f20087o.add(f20086s);
    }

    @Override // t4.c
    public t4.c i0(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f20087o.isEmpty() || this.f20088p != null) {
            throw new IllegalStateException("Did not expect a name");
        }
        if (!(R0() instanceof l4.m)) {
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        this.f20088p = str;
        return this;
    }

    @Override // t4.c
    public t4.c z0() {
        S0(l4.l.f18379a);
        return this;
    }

    @Override // t4.c, java.io.Flushable
    public void flush() {
    }
}
