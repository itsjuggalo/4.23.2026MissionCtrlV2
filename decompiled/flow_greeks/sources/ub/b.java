package ub;

import io.flutter.embedding.android.KeyboardMap;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ub.j;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements wb.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f22745d = Logger.getLogger(i.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f22746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final wb.c f22747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f22748c = new j(Level.FINE, i.class);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        void e(Throwable th);
    }

    public b(a aVar, wb.c cVar) {
        this.f22746a = (a) p6.n.o(aVar, "transportExceptionHandler");
        this.f22747b = (wb.c) p6.n.o(cVar, "frameWriter");
    }

    public static Level b(Throwable th) {
        return th.getClass().equals(IOException.class) ? Level.FINE : Level.INFO;
    }

    @Override // wb.c
    public int T() {
        return this.f22747b.T();
    }

    @Override // wb.c
    public void U(boolean z10, boolean z11, int i10, int i11, List list) {
        try {
            this.f22747b.U(z10, z11, i10, i11, list);
        } catch (IOException e10) {
            this.f22746a.e(e10);
        }
    }

    @Override // wb.c
    public void X(wb.i iVar) {
        this.f22748c.i(j.a.OUTBOUND, iVar);
        try {
            this.f22747b.X(iVar);
        } catch (IOException e10) {
            this.f22746a.e(e10);
        }
    }

    @Override // wb.c
    public void a(int i10, long j10) {
        this.f22748c.k(j.a.OUTBOUND, i10, j10);
        try {
            this.f22747b.a(i10, j10);
        } catch (IOException e10) {
            this.f22746a.e(e10);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.f22747b.close();
        } catch (IOException e10) {
            f22745d.log(b(e10), "Failed closing connection", (Throwable) e10);
        }
    }

    @Override // wb.c
    public void f(boolean z10, int i10, int i11) {
        if (z10) {
            this.f22748c.f(j.a.OUTBOUND, (KeyboardMap.kValueMask & ((long) i11)) | (((long) i10) << 32));
        } else {
            this.f22748c.e(j.a.OUTBOUND, (KeyboardMap.kValueMask & ((long) i11)) | (((long) i10) << 32));
        }
        try {
            this.f22747b.f(z10, i10, i11);
        } catch (IOException e10) {
            this.f22746a.e(e10);
        }
    }

    @Override // wb.c
    public void flush() {
        try {
            this.f22747b.flush();
        } catch (IOException e10) {
            this.f22746a.e(e10);
        }
    }

    @Override // wb.c
    public void g(int i10, wb.a aVar) {
        this.f22748c.h(j.a.OUTBOUND, i10, aVar);
        try {
            this.f22747b.g(i10, aVar);
        } catch (IOException e10) {
            this.f22746a.e(e10);
        }
    }

    @Override // wb.c
    public void j(boolean z10, int i10, hh.d dVar, int i11) {
        this.f22748c.b(j.a.OUTBOUND, i10, dVar.b(), i11, z10);
        try {
            this.f22747b.j(z10, i10, dVar, i11);
        } catch (IOException e10) {
            this.f22746a.e(e10);
        }
    }

    @Override // wb.c
    public void m(int i10, wb.a aVar, byte[] bArr) {
        this.f22748c.c(j.a.OUTBOUND, i10, aVar, hh.g.u(bArr));
        try {
            this.f22747b.m(i10, aVar, bArr);
            this.f22747b.flush();
        } catch (IOException e10) {
            this.f22746a.e(e10);
        }
    }

    @Override // wb.c
    public void r() {
        try {
            this.f22747b.r();
        } catch (IOException e10) {
            this.f22746a.e(e10);
        }
    }

    @Override // wb.c
    public void v(wb.i iVar) {
        this.f22748c.j(j.a.OUTBOUND);
        try {
            this.f22747b.v(iVar);
        } catch (IOException e10) {
            this.f22746a.e(e10);
        }
    }
}
