package M2;

import K2.InterfaceC0364l;
import K2.InterfaceC0366n;
import K2.InterfaceC0374w;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: renamed from: M2.n0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C0435n0 implements P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f2513a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public V0 f2515c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final W0 f2520h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final O0 f2521i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2522j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2523k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f2525m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2514b = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InterfaceC0366n f2516d = InterfaceC0364l.b.f1213a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2517e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f2518f = new c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ByteBuffer f2519g = ByteBuffer.allocate(5);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2524l = -1;

    /* JADX INFO: renamed from: M2.n0$d */
    public interface d {
        void k(V0 v02, boolean z4, boolean z5, int i4);
    }

    public C0435n0(d dVar, W0 w02, O0 o02) {
        this.f2513a = (d) Z1.m.o(dVar, "sink");
        this.f2520h = (W0) Z1.m.o(w02, "bufferAllocator");
        this.f2521i = (O0) Z1.m.o(o02, "statsTraceCtx");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int r(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream instanceof InterfaceC0374w) {
            return ((InterfaceC0374w) inputStream).e(outputStream);
        }
        long jB = b2.b.b(inputStream, outputStream);
        Z1.m.i(jB <= 2147483647L, "Message size overflow: %s", jB);
        return (int) jB;
    }

    @Override // M2.P
    public boolean c() {
        return this.f2522j;
    }

    @Override // M2.P
    public void close() {
        if (c()) {
            return;
        }
        this.f2522j = true;
        V0 v02 = this.f2515c;
        if (v02 != null && v02.d() == 0) {
            j();
        }
        h(true, true);
    }

    @Override // M2.P
    public void d(InputStream inputStream) {
        m();
        this.f2523k++;
        int i4 = this.f2524l + 1;
        this.f2524l = i4;
        this.f2525m = 0L;
        this.f2521i.i(i4);
        boolean z4 = this.f2517e && this.f2516d != InterfaceC0364l.b.f1213a;
        try {
            int i5 = i(inputStream);
            int iS = (i5 == 0 || !z4) ? s(inputStream, i5) : o(inputStream, i5);
            if (i5 != -1 && iS != i5) {
                throw K2.l0.f1229s.q(String.format("Message length inaccurate %s != %s", Integer.valueOf(iS), Integer.valueOf(i5))).d();
            }
            long j4 = iS;
            this.f2521i.k(j4);
            this.f2521i.l(this.f2525m);
            this.f2521i.j(this.f2524l, this.f2525m, j4);
        } catch (K2.n0 e4) {
            throw e4;
        } catch (IOException e5) {
            throw K2.l0.f1229s.q("Failed to frame message").p(e5).d();
        } catch (RuntimeException e6) {
            throw K2.l0.f1229s.q("Failed to frame message").p(e6).d();
        }
    }

    @Override // M2.P
    public void flush() {
        V0 v02 = this.f2515c;
        if (v02 == null || v02.d() <= 0) {
            return;
        }
        h(false, true);
    }

    @Override // M2.P
    public void g(int i4) {
        Z1.m.u(this.f2514b == -1, "max size already set");
        this.f2514b = i4;
    }

    public final void h(boolean z4, boolean z5) {
        V0 v02 = this.f2515c;
        this.f2515c = null;
        this.f2513a.k(v02, z4, z5, this.f2523k);
        this.f2523k = 0;
    }

    public final int i(InputStream inputStream) {
        if ((inputStream instanceof K2.Q) || (inputStream instanceof ByteArrayInputStream)) {
            return inputStream.available();
        }
        return -1;
    }

    public final void j() {
        V0 v02 = this.f2515c;
        if (v02 != null) {
            v02.release();
            this.f2515c = null;
        }
    }

    @Override // M2.P
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0435n0 b(InterfaceC0366n interfaceC0366n) {
        this.f2516d = (InterfaceC0366n) Z1.m.o(interfaceC0366n, "Can't pass an empty compressor");
        return this;
    }

    @Override // M2.P
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public C0435n0 a(boolean z4) {
        this.f2517e = z4;
        return this;
    }

    public final void m() {
        if (c()) {
            throw new IllegalStateException("Framer already closed");
        }
    }

    public final void n(b bVar, boolean z4) {
        int iD = bVar.d();
        int i4 = this.f2514b;
        if (i4 >= 0 && iD > i4) {
            throw K2.l0.f1224n.q(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(iD), Integer.valueOf(this.f2514b))).d();
        }
        this.f2519g.clear();
        this.f2519g.put(z4 ? (byte) 1 : (byte) 0).putInt(iD);
        V0 v0A = this.f2520h.a(5);
        v0A.a(this.f2519g.array(), 0, this.f2519g.position());
        if (iD == 0) {
            this.f2515c = v0A;
            return;
        }
        this.f2513a.k(v0A, false, false, this.f2523k - 1);
        this.f2523k = 1;
        List list = bVar.f2526a;
        for (int i5 = 0; i5 < list.size() - 1; i5++) {
            this.f2513a.k((V0) list.get(i5), false, false, 0);
        }
        this.f2515c = (V0) list.get(list.size() - 1);
        this.f2525m = iD;
    }

    public final int o(InputStream inputStream, int i4) throws IOException {
        b bVar = new b();
        OutputStream outputStreamC = this.f2516d.c(bVar);
        try {
            int iR = r(inputStream, outputStreamC);
            outputStreamC.close();
            int i5 = this.f2514b;
            if (i5 >= 0 && iR > i5) {
                throw K2.l0.f1224n.q(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(iR), Integer.valueOf(this.f2514b))).d();
            }
            n(bVar, true);
            return iR;
        } catch (Throwable th) {
            outputStreamC.close();
            throw th;
        }
    }

    public final int p(InputStream inputStream, int i4) {
        int i5 = this.f2514b;
        if (i5 >= 0 && i4 > i5) {
            throw K2.l0.f1224n.q(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(i4), Integer.valueOf(this.f2514b))).d();
        }
        this.f2519g.clear();
        this.f2519g.put((byte) 0).putInt(i4);
        if (this.f2515c == null) {
            this.f2515c = this.f2520h.a(this.f2519g.position() + i4);
        }
        q(this.f2519g.array(), 0, this.f2519g.position());
        return r(inputStream, this.f2518f);
    }

    public final void q(byte[] bArr, int i4, int i5) {
        while (i5 > 0) {
            V0 v02 = this.f2515c;
            if (v02 != null && v02.b() == 0) {
                h(false, false);
            }
            if (this.f2515c == null) {
                this.f2515c = this.f2520h.a(i5);
            }
            int iMin = Math.min(i5, this.f2515c.b());
            this.f2515c.a(bArr, i4, iMin);
            i4 += iMin;
            i5 -= iMin;
        }
    }

    public final int s(InputStream inputStream, int i4) throws IOException {
        if (i4 != -1) {
            this.f2525m = i4;
            return p(inputStream, i4);
        }
        b bVar = new b();
        int iR = r(inputStream, bVar);
        n(bVar, false);
        return iR;
    }

    /* JADX INFO: renamed from: M2.n0$c */
    public class c extends OutputStream {
        public c() {
        }

        @Override // java.io.OutputStream
        public void write(int i4) {
            write(new byte[]{(byte) i4}, 0, 1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i4, int i5) {
            C0435n0.this.q(bArr, i4, i5);
        }
    }

    /* JADX INFO: renamed from: M2.n0$b */
    public final class b extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f2526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public V0 f2527b;

        public b() {
            this.f2526a = new ArrayList();
        }

        public final int d() {
            Iterator it = this.f2526a.iterator();
            int iD = 0;
            while (it.hasNext()) {
                iD += ((V0) it.next()).d();
            }
            return iD;
        }

        @Override // java.io.OutputStream
        public void write(int i4) {
            V0 v02 = this.f2527b;
            if (v02 == null || v02.b() <= 0) {
                write(new byte[]{(byte) i4}, 0, 1);
            } else {
                this.f2527b.c((byte) i4);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i4, int i5) {
            if (this.f2527b == null) {
                V0 v0A = C0435n0.this.f2520h.a(i5);
                this.f2527b = v0A;
                this.f2526a.add(v0A);
            }
            while (i5 > 0) {
                int iMin = Math.min(i5, this.f2527b.b());
                if (iMin == 0) {
                    V0 v0A2 = C0435n0.this.f2520h.a(Math.max(i5, this.f2527b.d() * 2));
                    this.f2527b = v0A2;
                    this.f2526a.add(v0A2);
                } else {
                    this.f2527b.a(bArr, i4, iMin);
                    i4 += iMin;
                    i5 -= iMin;
                }
            }
        }
    }
}
