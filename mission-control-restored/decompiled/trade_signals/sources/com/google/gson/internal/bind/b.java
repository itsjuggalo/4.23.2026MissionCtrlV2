package com.google.gson.internal.bind;

import com.google.gson.f;
import com.google.gson.i;
import com.google.gson.k;
import com.google.gson.l;
import com.google.gson.n;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import p4.C2570c;

/* JADX INFO: loaded from: classes.dex */
public final class b extends C2570c {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Writer f16194r = new a();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final n f16195s = new n("closed");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List f16196o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f16197p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public i f16198q;

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
        public void write(char[] cArr, int i8, int i9) {
            throw new AssertionError();
        }
    }

    public b() {
        super(f16194r);
        this.f16196o = new ArrayList();
        this.f16198q = k.f16252a;
    }

    @Override // p4.C2570c
    public C2570c B() {
        if (this.f16196o.isEmpty() || this.f16197p != null) {
            throw new IllegalStateException();
        }
        if (!(C0() instanceof f)) {
            throw new IllegalStateException();
        }
        this.f16196o.remove(r0.size() - 1);
        return this;
    }

    public i B0() {
        if (this.f16196o.isEmpty()) {
            return this.f16198q;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f16196o);
    }

    public final i C0() {
        return (i) this.f16196o.get(r0.size() - 1);
    }

    @Override // p4.C2570c
    public C2570c D() {
        if (this.f16196o.isEmpty() || this.f16197p != null) {
            throw new IllegalStateException();
        }
        if (!(C0() instanceof l)) {
            throw new IllegalStateException();
        }
        this.f16196o.remove(r0.size() - 1);
        return this;
    }

    public final void D0(i iVar) {
        if (this.f16197p != null) {
            if (!iVar.C() || E()) {
                ((l) C0()).I(this.f16197p, iVar);
            }
            this.f16197p = null;
            return;
        }
        if (this.f16196o.isEmpty()) {
            this.f16198q = iVar;
            return;
        }
        i iVarC0 = C0();
        if (!(iVarC0 instanceof f)) {
            throw new IllegalStateException();
        }
        ((f) iVarC0).I(iVar);
    }

    @Override // p4.C2570c
    public C2570c O(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f16196o.isEmpty() || this.f16197p != null) {
            throw new IllegalStateException("Did not expect a name");
        }
        if (!(C0() instanceof l)) {
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        this.f16197p = str;
        return this;
    }

    @Override // p4.C2570c
    public C2570c R() {
        D0(k.f16252a);
        return this;
    }

    @Override // p4.C2570c, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f16196o.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.f16196o.add(f16195s);
    }

    @Override // p4.C2570c
    public C2570c f() {
        f fVar = new f();
        D0(fVar);
        this.f16196o.add(fVar);
        return this;
    }

    @Override // p4.C2570c, java.io.Flushable
    public void flush() {
    }

    @Override // p4.C2570c
    public C2570c n() {
        l lVar = new l();
        D0(lVar);
        this.f16196o.add(lVar);
        return this;
    }

    @Override // p4.C2570c
    public C2570c s0(double d8) {
        if (N() || !(Double.isNaN(d8) || Double.isInfinite(d8))) {
            D0(new n(Double.valueOf(d8)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d8);
    }

    @Override // p4.C2570c
    public C2570c v0(long j8) {
        D0(new n(Long.valueOf(j8)));
        return this;
    }

    @Override // p4.C2570c
    public C2570c w0(Boolean bool) {
        if (bool == null) {
            return R();
        }
        D0(new n(bool));
        return this;
    }

    @Override // p4.C2570c
    public C2570c x0(Number number) {
        if (number == null) {
            return R();
        }
        if (!N()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        D0(new n(number));
        return this;
    }

    @Override // p4.C2570c
    public C2570c y0(String str) {
        if (str == null) {
            return R();
        }
        D0(new n(str));
        return this;
    }

    @Override // p4.C2570c
    public C2570c z0(boolean z7) {
        D0(new n(Boolean.valueOf(z7)));
        return this;
    }
}
