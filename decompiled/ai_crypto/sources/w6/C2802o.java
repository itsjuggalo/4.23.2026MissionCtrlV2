package w6;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: renamed from: w6.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2802o implements Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f25136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f25137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Inflater f25138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C2803p f25139d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CRC32 f25140e;

    public C2802o(Z source) {
        kotlin.jvm.internal.r.f(source, "source");
        T t7 = new T(source);
        this.f25137b = t7;
        Inflater inflater = new Inflater(true);
        this.f25138c = inflater;
        this.f25139d = new C2803p((InterfaceC2794g) t7, inflater);
        this.f25140e = new CRC32();
    }

    public final void A() throws IOException {
        h("CRC", this.f25137b.W(), (int) this.f25140e.getValue());
        h("ISIZE", this.f25137b.W(), (int) this.f25138c.getBytesWritten());
    }

    public final void G(C2792e c2792e, long j7, long j8) {
        U u7 = c2792e.f25095a;
        kotlin.jvm.internal.r.c(u7);
        while (true) {
            int i7 = u7.f25054c;
            int i8 = u7.f25053b;
            if (j7 < i7 - i8) {
                break;
            }
            j7 -= (long) (i7 - i8);
            u7 = u7.f25057f;
            kotlin.jvm.internal.r.c(u7);
        }
        while (j8 > 0) {
            int i9 = (int) (((long) u7.f25053b) + j7);
            int iMin = (int) Math.min(u7.f25054c - i9, j8);
            this.f25140e.update(u7.f25052a, i9, iMin);
            j8 -= (long) iMin;
            u7 = u7.f25057f;
            kotlin.jvm.internal.r.c(u7);
            j7 = 0;
        }
    }

    @Override // w6.Z, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f25139d.close();
    }

    @Override // w6.Z
    public a0 f() {
        return this.f25137b.f();
    }

    public final void h(String str, int i7, int i8) throws IOException {
        if (i8 == i7) {
            return;
        }
        String str2 = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i8), Integer.valueOf(i7)}, 3));
        kotlin.jvm.internal.r.e(str2, "format(this, *args)");
        throw new IOException(str2);
    }

    public final void i() throws IOException {
        this.f25137b.o0(10L);
        byte bT = this.f25137b.f25048b.T(3L);
        boolean z7 = ((bT >> 1) & 1) == 1;
        if (z7) {
            G(this.f25137b.f25048b, 0L, 10L);
        }
        h("ID1ID2", 8075, this.f25137b.readShort());
        this.f25137b.skip(8L);
        if (((bT >> 2) & 1) == 1) {
            this.f25137b.o0(2L);
            if (z7) {
                G(this.f25137b.f25048b, 0L, 2L);
            }
            long jD0 = this.f25137b.f25048b.d0() & 65535;
            this.f25137b.o0(jD0);
            if (z7) {
                G(this.f25137b.f25048b, 0L, jD0);
            }
            this.f25137b.skip(jD0);
        }
        if (((bT >> 3) & 1) == 1) {
            long jH = this.f25137b.h((byte) 0);
            if (jH == -1) {
                throw new EOFException();
            }
            if (z7) {
                G(this.f25137b.f25048b, 0L, jH + 1);
            }
            this.f25137b.skip(jH + 1);
        }
        if (((bT >> 4) & 1) == 1) {
            long jH2 = this.f25137b.h((byte) 0);
            if (jH2 == -1) {
                throw new EOFException();
            }
            if (z7) {
                G(this.f25137b.f25048b, 0L, jH2 + 1);
            }
            this.f25137b.skip(jH2 + 1);
        }
        if (z7) {
            h("FHCRC", this.f25137b.d0(), (short) this.f25140e.getValue());
            this.f25140e.reset();
        }
    }

    @Override // w6.Z
    public long z(C2792e sink, long j7) throws IOException {
        kotlin.jvm.internal.r.f(sink, "sink");
        if (j7 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j7).toString());
        }
        if (j7 == 0) {
            return 0L;
        }
        if (this.f25136a == 0) {
            i();
            this.f25136a = (byte) 1;
        }
        if (this.f25136a == 1) {
            long jE0 = sink.E0();
            long jZ = this.f25139d.z(sink, j7);
            if (jZ != -1) {
                G(sink, jE0, jZ);
                return jZ;
            }
            this.f25136a = (byte) 2;
        }
        if (this.f25136a == 2) {
            A();
            this.f25136a = (byte) 3;
            if (!this.f25137b.u()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }
}
