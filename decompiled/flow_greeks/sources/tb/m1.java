package tb;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import rb.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class m1 implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f21520a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u2 f21522c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final v2 f21527h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final n2 f21528i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f21529j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f21530k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f21532m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21521b = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public rb.n f21523d = l.b.f19636a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f21524e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f21525f = new c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ByteBuffer f21526g = ByteBuffer.allocate(5);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f21531l = -1;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface d {
        void m(u2 u2Var, boolean z10, boolean z11, int i10);
    }

    public m1(d dVar, v2 v2Var, n2 n2Var) {
        this.f21520a = (d) p6.n.o(dVar, "sink");
        this.f21527h = (v2) p6.n.o(v2Var, "bufferAllocator");
        this.f21528i = (n2) p6.n.o(n2Var, "statsTraceCtx");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int o(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream instanceof rb.w) {
            return ((rb.w) inputStream).b(outputStream);
        }
        long jB = r6.b.b(inputStream, outputStream);
        p6.n.i(jB <= 2147483647L, "Message size overflow: %s", jB);
        return (int) jB;
    }

    @Override // tb.p0
    public void b(InputStream inputStream) {
        j();
        this.f21530k++;
        int i10 = this.f21531l + 1;
        this.f21531l = i10;
        this.f21532m = 0L;
        this.f21528i.i(i10);
        boolean z10 = this.f21524e && this.f21523d != l.b.f19636a;
        try {
            int iG = g(inputStream);
            int iP = (iG == 0 || !z10) ? p(inputStream, iG) : l(inputStream, iG);
            if (iG != -1 && iP != iG) {
                throw rb.k1.f19606s.r(String.format("Message length inaccurate %s != %s", Integer.valueOf(iP), Integer.valueOf(iG))).d();
            }
            long j10 = iP;
            this.f21528i.k(j10);
            this.f21528i.l(this.f21532m);
            this.f21528i.j(this.f21531l, this.f21532m, j10);
        } catch (IOException e10) {
            throw rb.k1.f19606s.r("Failed to frame message").q(e10).d();
        } catch (rb.m1 e11) {
            throw e11;
        } catch (RuntimeException e12) {
            throw rb.k1.f19606s.r("Failed to frame message").q(e12).d();
        }
    }

    @Override // tb.p0
    public void close() {
        if (isClosed()) {
            return;
        }
        this.f21529j = true;
        u2 u2Var = this.f21522c;
        if (u2Var != null && u2Var.d() == 0) {
            h();
        }
        f(true, true);
    }

    @Override // tb.p0
    public void d(int i10) {
        p6.n.u(this.f21521b == -1, "max size already set");
        this.f21521b = i10;
    }

    public final void f(boolean z10, boolean z11) {
        u2 u2Var = this.f21522c;
        this.f21522c = null;
        this.f21520a.m(u2Var, z10, z11, this.f21530k);
        this.f21530k = 0;
    }

    @Override // tb.p0
    public void flush() {
        u2 u2Var = this.f21522c;
        if (u2Var == null || u2Var.d() <= 0) {
            return;
        }
        f(false, true);
    }

    public final int g(InputStream inputStream) {
        if ((inputStream instanceof rb.q0) || (inputStream instanceof ByteArrayInputStream)) {
            return inputStream.available();
        }
        return -1;
    }

    public final void h() {
        u2 u2Var = this.f21522c;
        if (u2Var != null) {
            u2Var.release();
            this.f21522c = null;
        }
    }

    @Override // tb.p0
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public m1 a(rb.n nVar) {
        this.f21523d = (rb.n) p6.n.o(nVar, "Can't pass an empty compressor");
        return this;
    }

    @Override // tb.p0
    public boolean isClosed() {
        return this.f21529j;
    }

    public final void j() {
        if (isClosed()) {
            throw new IllegalStateException("Framer already closed");
        }
    }

    public final void k(b bVar, boolean z10) {
        int iD = bVar.d();
        int i10 = this.f21521b;
        if (i10 >= 0 && iD > i10) {
            throw rb.k1.f19601n.r(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(iD), Integer.valueOf(this.f21521b))).d();
        }
        this.f21526g.clear();
        this.f21526g.put(z10 ? (byte) 1 : (byte) 0).putInt(iD);
        u2 u2VarA = this.f21527h.a(5);
        u2VarA.write(this.f21526g.array(), 0, this.f21526g.position());
        if (iD == 0) {
            this.f21522c = u2VarA;
            return;
        }
        this.f21520a.m(u2VarA, false, false, this.f21530k - 1);
        this.f21530k = 1;
        List list = bVar.f21533a;
        for (int i11 = 0; i11 < list.size() - 1; i11++) {
            this.f21520a.m((u2) list.get(i11), false, false, 0);
        }
        this.f21522c = (u2) list.get(list.size() - 1);
        this.f21532m = iD;
    }

    public final int l(InputStream inputStream, int i10) throws IOException {
        b bVar = new b();
        OutputStream outputStreamC = this.f21523d.c(bVar);
        try {
            int iO = o(inputStream, outputStreamC);
            outputStreamC.close();
            int i11 = this.f21521b;
            if (i11 >= 0 && iO > i11) {
                throw rb.k1.f19601n.r(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(iO), Integer.valueOf(this.f21521b))).d();
            }
            k(bVar, true);
            return iO;
        } catch (Throwable th) {
            outputStreamC.close();
            throw th;
        }
    }

    public final int m(InputStream inputStream, int i10) {
        int i11 = this.f21521b;
        if (i11 >= 0 && i10 > i11) {
            throw rb.k1.f19601n.r(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(i10), Integer.valueOf(this.f21521b))).d();
        }
        this.f21526g.clear();
        this.f21526g.put((byte) 0).putInt(i10);
        if (this.f21522c == null) {
            this.f21522c = this.f21527h.a(this.f21526g.position() + i10);
        }
        n(this.f21526g.array(), 0, this.f21526g.position());
        return o(inputStream, this.f21525f);
    }

    public final void n(byte[] bArr, int i10, int i11) {
        while (i11 > 0) {
            u2 u2Var = this.f21522c;
            if (u2Var != null && u2Var.a() == 0) {
                f(false, false);
            }
            if (this.f21522c == null) {
                this.f21522c = this.f21527h.a(i11);
            }
            int iMin = Math.min(i11, this.f21522c.a());
            this.f21522c.write(bArr, i10, iMin);
            i10 += iMin;
            i11 -= iMin;
        }
    }

    public final int p(InputStream inputStream, int i10) throws IOException {
        if (i10 != -1) {
            this.f21532m = i10;
            return m(inputStream, i10);
        }
        b bVar = new b();
        int iO = o(inputStream, bVar);
        k(bVar, false);
        return iO;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c extends OutputStream {
        public c() {
        }

        @Override // java.io.OutputStream
        public void write(int i10) {
            write(new byte[]{(byte) i10}, 0, 1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) {
            m1.this.n(bArr, i10, i11);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class b extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f21533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public u2 f21534b;

        public b() {
            this.f21533a = new ArrayList();
        }

        public final int d() {
            Iterator it = this.f21533a.iterator();
            int iD = 0;
            while (it.hasNext()) {
                iD += ((u2) it.next()).d();
            }
            return iD;
        }

        @Override // java.io.OutputStream
        public void write(int i10) {
            u2 u2Var = this.f21534b;
            if (u2Var == null || u2Var.a() <= 0) {
                write(new byte[]{(byte) i10}, 0, 1);
            } else {
                this.f21534b.b((byte) i10);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) {
            if (this.f21534b == null) {
                u2 u2VarA = m1.this.f21527h.a(i11);
                this.f21534b = u2VarA;
                this.f21533a.add(u2VarA);
            }
            while (i11 > 0) {
                int iMin = Math.min(i11, this.f21534b.a());
                if (iMin == 0) {
                    u2 u2VarA2 = m1.this.f21527h.a(Math.max(i11, this.f21534b.d() * 2));
                    this.f21534b = u2VarA2;
                    this.f21533a.add(u2VarA2);
                } else {
                    this.f21534b.write(bArr, i10, iMin);
                    i10 += iMin;
                    i11 -= iMin;
                }
            }
        }
    }
}
