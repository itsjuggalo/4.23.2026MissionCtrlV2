package G4;

import F4.InterfaceC0498l;
import F4.InterfaceC0500n;
import F4.InterfaceC0508w;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import v2.AbstractC2848n;
import x2.AbstractC2955b;

/* JADX INFO: renamed from: G4.n0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0543n0 implements P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f3091a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public V0 f3093c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final W0 f3098h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final O0 f3099i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3100j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3101k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f3103m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3092b = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InterfaceC0500n f3094d = InterfaceC0498l.b.f1851a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3095e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f3096f = new c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ByteBuffer f3097g = ByteBuffer.allocate(5);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3102l = -1;

    /* JADX INFO: renamed from: G4.n0$b */
    public final class b extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f3104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public V0 f3105b;

        public b() {
            this.f3104a = new ArrayList();
        }

        public final int d() {
            Iterator it = this.f3104a.iterator();
            int iD = 0;
            while (it.hasNext()) {
                iD += ((V0) it.next()).d();
            }
            return iD;
        }

        @Override // java.io.OutputStream
        public void write(int i8) {
            V0 v02 = this.f3105b;
            if (v02 == null || v02.b() <= 0) {
                write(new byte[]{(byte) i8}, 0, 1);
            } else {
                this.f3105b.c((byte) i8);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i8, int i9) {
            if (this.f3105b == null) {
                V0 v0A = C0543n0.this.f3098h.a(i9);
                this.f3105b = v0A;
                this.f3104a.add(v0A);
            }
            while (i9 > 0) {
                int iMin = Math.min(i9, this.f3105b.b());
                if (iMin == 0) {
                    V0 v0A2 = C0543n0.this.f3098h.a(Math.max(i9, this.f3105b.d() * 2));
                    this.f3105b = v0A2;
                    this.f3104a.add(v0A2);
                } else {
                    this.f3105b.a(bArr, i8, iMin);
                    i8 += iMin;
                    i9 -= iMin;
                }
            }
        }
    }

    /* JADX INFO: renamed from: G4.n0$c */
    public class c extends OutputStream {
        public c() {
        }

        @Override // java.io.OutputStream
        public void write(int i8) {
            write(new byte[]{(byte) i8}, 0, 1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i8, int i9) {
            C0543n0.this.o(bArr, i8, i9);
        }
    }

    /* JADX INFO: renamed from: G4.n0$d */
    public interface d {
        void n(V0 v02, boolean z7, boolean z8, int i8);
    }

    public C0543n0(d dVar, W0 w02, O0 o02) {
        this.f3091a = (d) AbstractC2848n.o(dVar, "sink");
        this.f3098h = (W0) AbstractC2848n.o(w02, "bufferAllocator");
        this.f3099i = (O0) AbstractC2848n.o(o02, "statsTraceCtx");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int p(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream instanceof InterfaceC0508w) {
            return ((InterfaceC0508w) inputStream).a(outputStream);
        }
        long jB = AbstractC2955b.b(inputStream, outputStream);
        AbstractC2848n.i(jB <= 2147483647L, "Message size overflow: %s", jB);
        return (int) jB;
    }

    @Override // G4.P
    public boolean c() {
        return this.f3100j;
    }

    @Override // G4.P
    public void close() {
        if (c()) {
            return;
        }
        this.f3100j = true;
        V0 v02 = this.f3093c;
        if (v02 != null && v02.d() == 0) {
            i();
        }
        f(true, true);
    }

    @Override // G4.P
    public void d(InputStream inputStream) {
        k();
        this.f3101k++;
        int i8 = this.f3102l + 1;
        this.f3102l = i8;
        this.f3103m = 0L;
        this.f3099i.i(i8);
        boolean z7 = this.f3095e && this.f3094d != InterfaceC0498l.b.f1851a;
        try {
            int iH = h(inputStream);
            int iQ = (iH == 0 || !z7) ? q(inputStream, iH) : m(inputStream, iH);
            if (iH != -1 && iQ != iH) {
                throw F4.j0.f1811s.r(String.format("Message length inaccurate %s != %s", Integer.valueOf(iQ), Integer.valueOf(iH))).d();
            }
            long j8 = iQ;
            this.f3099i.k(j8);
            this.f3099i.l(this.f3103m);
            this.f3099i.j(this.f3102l, this.f3103m, j8);
        } catch (F4.l0 e8) {
            throw e8;
        } catch (IOException e9) {
            throw F4.j0.f1811s.r("Failed to frame message").q(e9).d();
        } catch (RuntimeException e10) {
            throw F4.j0.f1811s.r("Failed to frame message").q(e10).d();
        }
    }

    public final void f(boolean z7, boolean z8) {
        V0 v02 = this.f3093c;
        this.f3093c = null;
        this.f3091a.n(v02, z7, z8, this.f3101k);
        this.f3101k = 0;
    }

    @Override // G4.P
    public void flush() {
        V0 v02 = this.f3093c;
        if (v02 == null || v02.d() <= 0) {
            return;
        }
        f(false, true);
    }

    @Override // G4.P
    public void g(int i8) {
        AbstractC2848n.u(this.f3092b == -1, "max size already set");
        this.f3092b = i8;
    }

    public final int h(InputStream inputStream) {
        if ((inputStream instanceof F4.O) || (inputStream instanceof ByteArrayInputStream)) {
            return inputStream.available();
        }
        return -1;
    }

    public final void i() {
        V0 v02 = this.f3093c;
        if (v02 != null) {
            v02.release();
            this.f3093c = null;
        }
    }

    @Override // G4.P
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0543n0 b(InterfaceC0500n interfaceC0500n) {
        this.f3094d = (InterfaceC0500n) AbstractC2848n.o(interfaceC0500n, "Can't pass an empty compressor");
        return this;
    }

    public final void k() {
        if (c()) {
            throw new IllegalStateException("Framer already closed");
        }
    }

    public final void l(b bVar, boolean z7) {
        int iD = bVar.d();
        int i8 = this.f3092b;
        if (i8 >= 0 && iD > i8) {
            throw F4.j0.f1806n.r(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(iD), Integer.valueOf(this.f3092b))).d();
        }
        this.f3097g.clear();
        this.f3097g.put(z7 ? (byte) 1 : (byte) 0).putInt(iD);
        V0 v0A = this.f3098h.a(5);
        v0A.a(this.f3097g.array(), 0, this.f3097g.position());
        if (iD == 0) {
            this.f3093c = v0A;
            return;
        }
        this.f3091a.n(v0A, false, false, this.f3101k - 1);
        this.f3101k = 1;
        List list = bVar.f3104a;
        for (int i9 = 0; i9 < list.size() - 1; i9++) {
            this.f3091a.n((V0) list.get(i9), false, false, 0);
        }
        this.f3093c = (V0) list.get(list.size() - 1);
        this.f3103m = iD;
    }

    public final int m(InputStream inputStream, int i8) throws IOException {
        b bVar = new b();
        OutputStream outputStreamC = this.f3094d.c(bVar);
        try {
            int iP = p(inputStream, outputStreamC);
            outputStreamC.close();
            int i9 = this.f3092b;
            if (i9 >= 0 && iP > i9) {
                throw F4.j0.f1806n.r(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(iP), Integer.valueOf(this.f3092b))).d();
            }
            l(bVar, true);
            return iP;
        } catch (Throwable th) {
            outputStreamC.close();
            throw th;
        }
    }

    public final int n(InputStream inputStream, int i8) {
        int i9 = this.f3092b;
        if (i9 >= 0 && i8 > i9) {
            throw F4.j0.f1806n.r(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(i8), Integer.valueOf(this.f3092b))).d();
        }
        this.f3097g.clear();
        this.f3097g.put((byte) 0).putInt(i8);
        if (this.f3093c == null) {
            this.f3093c = this.f3098h.a(this.f3097g.position() + i8);
        }
        o(this.f3097g.array(), 0, this.f3097g.position());
        return p(inputStream, this.f3096f);
    }

    public final void o(byte[] bArr, int i8, int i9) {
        while (i9 > 0) {
            V0 v02 = this.f3093c;
            if (v02 != null && v02.b() == 0) {
                f(false, false);
            }
            if (this.f3093c == null) {
                this.f3093c = this.f3098h.a(i9);
            }
            int iMin = Math.min(i9, this.f3093c.b());
            this.f3093c.a(bArr, i8, iMin);
            i8 += iMin;
            i9 -= iMin;
        }
    }

    public final int q(InputStream inputStream, int i8) throws IOException {
        if (i8 != -1) {
            this.f3103m = i8;
            return n(inputStream, i8);
        }
        b bVar = new b();
        int iP = p(inputStream, bVar);
        l(bVar, false);
        return iP;
    }
}
