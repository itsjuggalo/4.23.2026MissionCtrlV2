package t5;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import r5.InterfaceC2596l;
import r5.InterfaceC2598n;
import r5.InterfaceC2606w;

/* JADX INFO: renamed from: t5.n0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2690n0 implements P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f24064a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public V0 f24066c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final W0 f24071h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final O0 f24072i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f24073j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f24074k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f24076m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f24065b = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InterfaceC2598n f24067d = InterfaceC2596l.b.f22703a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f24068e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f24069f = new c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ByteBuffer f24070g = ByteBuffer.allocate(5);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f24075l = -1;

    /* JADX INFO: renamed from: t5.n0$d */
    public interface d {
        void f(V0 v02, boolean z7, boolean z8, int i7);
    }

    public C2690n0(d dVar, W0 w02, O0 o02) {
        this.f24064a = (d) H2.m.o(dVar, "sink");
        this.f24071h = (W0) H2.m.o(w02, "bufferAllocator");
        this.f24072i = (O0) H2.m.o(o02, "statsTraceCtx");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int p(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream instanceof InterfaceC2606w) {
            return ((InterfaceC2606w) inputStream).h(outputStream);
        }
        long jB = J2.b.b(inputStream, outputStream);
        H2.m.i(jB <= 2147483647L, "Message size overflow: %s", jB);
        return (int) jB;
    }

    @Override // t5.P
    public boolean b() {
        return this.f24073j;
    }

    @Override // t5.P
    public void c(InputStream inputStream) {
        k();
        this.f24074k++;
        int i7 = this.f24075l + 1;
        this.f24075l = i7;
        this.f24076m = 0L;
        this.f24072i.i(i7);
        boolean z7 = this.f24068e && this.f24067d != InterfaceC2596l.b.f22703a;
        try {
            int iG = g(inputStream);
            int iQ = (iG == 0 || !z7) ? q(inputStream, iG) : m(inputStream, iG);
            if (iG != -1 && iQ != iG) {
                throw r5.l0.f22719s.q(String.format("Message length inaccurate %s != %s", Integer.valueOf(iQ), Integer.valueOf(iG))).d();
            }
            long j7 = iQ;
            this.f24072i.k(j7);
            this.f24072i.l(this.f24076m);
            this.f24072i.j(this.f24075l, this.f24076m, j7);
        } catch (IOException e7) {
            throw r5.l0.f22719s.q("Failed to frame message").p(e7).d();
        } catch (r5.n0 e8) {
            throw e8;
        } catch (RuntimeException e9) {
            throw r5.l0.f22719s.q("Failed to frame message").p(e9).d();
        }
    }

    @Override // t5.P
    public void close() {
        if (b()) {
            return;
        }
        this.f24073j = true;
        V0 v02 = this.f24066c;
        if (v02 != null && v02.e() == 0) {
            h();
        }
        f(true, true);
    }

    public final void f(boolean z7, boolean z8) {
        V0 v02 = this.f24066c;
        this.f24066c = null;
        this.f24064a.f(v02, z7, z8, this.f24074k);
        this.f24074k = 0;
    }

    @Override // t5.P
    public void flush() {
        V0 v02 = this.f24066c;
        if (v02 == null || v02.e() <= 0) {
            return;
        }
        f(false, true);
    }

    public final int g(InputStream inputStream) {
        if ((inputStream instanceof r5.Q) || (inputStream instanceof ByteArrayInputStream)) {
            return inputStream.available();
        }
        return -1;
    }

    public final void h() {
        V0 v02 = this.f24066c;
        if (v02 != null) {
            v02.release();
            this.f24066c = null;
        }
    }

    @Override // t5.P
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public C2690n0 a(InterfaceC2598n interfaceC2598n) {
        this.f24067d = (InterfaceC2598n) H2.m.o(interfaceC2598n, "Can't pass an empty compressor");
        return this;
    }

    @Override // t5.P
    public void j(int i7) {
        H2.m.u(this.f24065b == -1, "max size already set");
        this.f24065b = i7;
    }

    public final void k() {
        if (b()) {
            throw new IllegalStateException("Framer already closed");
        }
    }

    public final void l(b bVar, boolean z7) {
        int iE = bVar.e();
        int i7 = this.f24065b;
        if (i7 >= 0 && iE > i7) {
            throw r5.l0.f22714n.q(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(iE), Integer.valueOf(this.f24065b))).d();
        }
        this.f24070g.clear();
        this.f24070g.put(z7 ? (byte) 1 : (byte) 0).putInt(iE);
        V0 v0A = this.f24071h.a(5);
        v0A.g(this.f24070g.array(), 0, this.f24070g.position());
        if (iE == 0) {
            this.f24066c = v0A;
            return;
        }
        this.f24064a.f(v0A, false, false, this.f24074k - 1);
        this.f24074k = 1;
        List list = bVar.f24077a;
        for (int i8 = 0; i8 < list.size() - 1; i8++) {
            this.f24064a.f((V0) list.get(i8), false, false, 0);
        }
        this.f24066c = (V0) list.get(list.size() - 1);
        this.f24076m = iE;
    }

    public final int m(InputStream inputStream, int i7) throws IOException {
        b bVar = new b();
        OutputStream outputStreamC = this.f24067d.c(bVar);
        try {
            int iP = p(inputStream, outputStreamC);
            outputStreamC.close();
            int i8 = this.f24065b;
            if (i8 >= 0 && iP > i8) {
                throw r5.l0.f22714n.q(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(iP), Integer.valueOf(this.f24065b))).d();
            }
            l(bVar, true);
            return iP;
        } catch (Throwable th) {
            outputStreamC.close();
            throw th;
        }
    }

    public final int n(InputStream inputStream, int i7) {
        int i8 = this.f24065b;
        if (i8 >= 0 && i7 > i8) {
            throw r5.l0.f22714n.q(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(i7), Integer.valueOf(this.f24065b))).d();
        }
        this.f24070g.clear();
        this.f24070g.put((byte) 0).putInt(i7);
        if (this.f24066c == null) {
            this.f24066c = this.f24071h.a(this.f24070g.position() + i7);
        }
        o(this.f24070g.array(), 0, this.f24070g.position());
        return p(inputStream, this.f24069f);
    }

    public final void o(byte[] bArr, int i7, int i8) {
        while (i8 > 0) {
            V0 v02 = this.f24066c;
            if (v02 != null && v02.h() == 0) {
                f(false, false);
            }
            if (this.f24066c == null) {
                this.f24066c = this.f24071h.a(i8);
            }
            int iMin = Math.min(i8, this.f24066c.h());
            this.f24066c.g(bArr, i7, iMin);
            i7 += iMin;
            i8 -= iMin;
        }
    }

    public final int q(InputStream inputStream, int i7) throws IOException {
        if (i7 != -1) {
            this.f24076m = i7;
            return n(inputStream, i7);
        }
        b bVar = new b();
        int iP = p(inputStream, bVar);
        l(bVar, false);
        return iP;
    }

    /* JADX INFO: renamed from: t5.n0$c */
    public class c extends OutputStream {
        public c() {
        }

        @Override // java.io.OutputStream
        public void write(int i7) {
            write(new byte[]{(byte) i7}, 0, 1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i7, int i8) {
            C2690n0.this.o(bArr, i7, i8);
        }
    }

    /* JADX INFO: renamed from: t5.n0$b */
    public final class b extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f24077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public V0 f24078b;

        public b() {
            this.f24077a = new ArrayList();
        }

        public final int e() {
            Iterator it = this.f24077a.iterator();
            int iE = 0;
            while (it.hasNext()) {
                iE += ((V0) it.next()).e();
            }
            return iE;
        }

        @Override // java.io.OutputStream
        public void write(int i7) {
            V0 v02 = this.f24078b;
            if (v02 == null || v02.h() <= 0) {
                write(new byte[]{(byte) i7}, 0, 1);
            } else {
                this.f24078b.i((byte) i7);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i7, int i8) {
            if (this.f24078b == null) {
                V0 v0A = C2690n0.this.f24071h.a(i8);
                this.f24078b = v0A;
                this.f24077a.add(v0A);
            }
            while (i8 > 0) {
                int iMin = Math.min(i8, this.f24078b.h());
                if (iMin == 0) {
                    V0 v0A2 = C2690n0.this.f24071h.a(Math.max(i8, this.f24078b.e() * 2));
                    this.f24078b = v0A2;
                    this.f24077a.add(v0A2);
                } else {
                    this.f24078b.g(bArr, i7, iMin);
                    i7 += iMin;
                    i8 -= iMin;
                }
            }
        }
    }
}
