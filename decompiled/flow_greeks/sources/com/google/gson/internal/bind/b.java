package com.google.gson.internal.bind;

import com.google.gson.f;
import com.google.gson.i;
import com.google.gson.k;
import com.google.gson.l;
import com.google.gson.n;
import gb.c;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends c {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Writer f6806r = new a();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final n f6807s = new n("closed");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List f6808o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f6809p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public i f6810q;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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
        public void write(char[] cArr, int i10, int i11) {
            throw new AssertionError();
        }
    }

    public b() {
        super(f6806r);
        this.f6808o = new ArrayList();
        this.f6810q = k.f6876a;
    }

    @Override // gb.c
    public c E() {
        if (this.f6808o.isEmpty() || this.f6809p != null) {
            throw new IllegalStateException();
        }
        if (!(s0() instanceof f)) {
            throw new IllegalStateException();
        }
        this.f6808o.remove(r0.size() - 1);
        return this;
    }

    @Override // gb.c
    public c G() {
        if (this.f6808o.isEmpty() || this.f6809p != null) {
            throw new IllegalStateException();
        }
        if (!(s0() instanceof l)) {
            throw new IllegalStateException();
        }
        this.f6808o.remove(r0.size() - 1);
        return this;
    }

    @Override // gb.c
    public c R(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f6808o.isEmpty() || this.f6809p != null) {
            throw new IllegalStateException("Did not expect a name");
        }
        if (!(s0() instanceof l)) {
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        this.f6809p = str;
        return this;
    }

    @Override // gb.c
    public c a0() {
        t0(k.f6876a);
        return this;
    }

    @Override // gb.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f6808o.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.f6808o.add(f6807s);
    }

    @Override // gb.c
    public c k0(double d10) {
        if (O() || !(Double.isNaN(d10) || Double.isInfinite(d10))) {
            t0(new n(Double.valueOf(d10)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d10);
    }

    @Override // gb.c
    public c l0(long j10) {
        t0(new n(Long.valueOf(j10)));
        return this;
    }

    @Override // gb.c
    public c m0(Boolean bool) {
        if (bool == null) {
            return a0();
        }
        t0(new n(bool));
        return this;
    }

    @Override // gb.c
    public c n0(Number number) {
        if (number == null) {
            return a0();
        }
        if (!O()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        t0(new n(number));
        return this;
    }

    @Override // gb.c
    public c o() {
        f fVar = new f();
        t0(fVar);
        this.f6808o.add(fVar);
        return this;
    }

    @Override // gb.c
    public c o0(String str) {
        if (str == null) {
            return a0();
        }
        t0(new n(str));
        return this;
    }

    @Override // gb.c
    public c p0(boolean z10) {
        t0(new n(Boolean.valueOf(z10)));
        return this;
    }

    public i r0() {
        if (this.f6808o.isEmpty()) {
            return this.f6810q;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f6808o);
    }

    public final i s0() {
        return (i) this.f6808o.get(r0.size() - 1);
    }

    public final void t0(i iVar) {
        if (this.f6809p != null) {
            if (!iVar.p() || H()) {
                ((l) s0()).s(this.f6809p, iVar);
            }
            this.f6809p = null;
            return;
        }
        if (this.f6808o.isEmpty()) {
            this.f6810q = iVar;
            return;
        }
        i iVarS0 = s0();
        if (!(iVarS0 instanceof f)) {
            throw new IllegalStateException();
        }
        ((f) iVarS0).s(iVar);
    }

    @Override // gb.c
    public c u() {
        l lVar = new l();
        t0(lVar);
        this.f6808o.add(lVar);
        return this;
    }

    @Override // gb.c, java.io.Flushable
    public void flush() {
    }
}
