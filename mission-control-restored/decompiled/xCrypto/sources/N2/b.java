package N2;

import N2.j;
import io.flutter.embedding.android.KeyboardMap;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements P2.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f2896d = Logger.getLogger(i.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f2897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final P2.c f2898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f2899c = new j(Level.FINE, i.class);

    public interface a {
        void g(Throwable th);
    }

    public b(a aVar, P2.c cVar) {
        this.f2897a = (a) Z1.m.o(aVar, "transportExceptionHandler");
        this.f2898b = (P2.c) Z1.m.o(cVar, "frameWriter");
    }

    public static Level e(Throwable th) {
        return th.getClass().equals(IOException.class) ? Level.FINE : Level.INFO;
    }

    @Override // P2.c
    public void F(P2.i iVar) {
        this.f2899c.i(j.a.OUTBOUND, iVar);
        try {
            this.f2898b.F(iVar);
        } catch (IOException e4) {
            this.f2897a.g(e4);
        }
    }

    @Override // P2.c
    public void H(P2.i iVar) {
        this.f2899c.j(j.a.OUTBOUND);
        try {
            this.f2898b.H(iVar);
        } catch (IOException e4) {
            this.f2897a.g(e4);
        }
    }

    @Override // P2.c
    public void N(int i4, P2.a aVar, byte[] bArr) {
        this.f2899c.c(j.a.OUTBOUND, i4, aVar, O3.g.q(bArr));
        try {
            this.f2898b.N(i4, aVar, bArr);
            this.f2898b.flush();
        } catch (IOException e4) {
            this.f2897a.g(e4);
        }
    }

    @Override // P2.c
    public int V() {
        return this.f2898b.V();
    }

    @Override // P2.c
    public void W(boolean z4, boolean z5, int i4, int i5, List list) {
        try {
            this.f2898b.W(z4, z5, i4, i5, list);
        } catch (IOException e4) {
            this.f2897a.g(e4);
        }
    }

    @Override // P2.c
    public void X(boolean z4, int i4, O3.d dVar, int i5) {
        this.f2899c.b(j.a.OUTBOUND, i4, dVar.e(), i5, z4);
        try {
            this.f2898b.X(z4, i4, dVar, i5);
        } catch (IOException e4) {
            this.f2897a.g(e4);
        }
    }

    @Override // P2.c
    public void a(int i4, P2.a aVar) {
        this.f2899c.h(j.a.OUTBOUND, i4, aVar);
        try {
            this.f2898b.a(i4, aVar);
        } catch (IOException e4) {
            this.f2897a.g(e4);
        }
    }

    @Override // P2.c
    public void b(int i4, long j4) {
        this.f2899c.k(j.a.OUTBOUND, i4, j4);
        try {
            this.f2898b.b(i4, j4);
        } catch (IOException e4) {
            this.f2897a.g(e4);
        }
    }

    @Override // P2.c
    public void c(boolean z4, int i4, int i5) {
        if (z4) {
            this.f2899c.f(j.a.OUTBOUND, (KeyboardMap.kValueMask & ((long) i5)) | (((long) i4) << 32));
        } else {
            this.f2899c.e(j.a.OUTBOUND, (KeyboardMap.kValueMask & ((long) i5)) | (((long) i4) << 32));
        }
        try {
            this.f2898b.c(z4, i4, i5);
        } catch (IOException e4) {
            this.f2897a.g(e4);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.f2898b.close();
        } catch (IOException e4) {
            f2896d.log(e(e4), "Failed closing connection", (Throwable) e4);
        }
    }

    @Override // P2.c
    public void flush() {
        try {
            this.f2898b.flush();
        } catch (IOException e4) {
            this.f2897a.g(e4);
        }
    }

    @Override // P2.c
    public void t() {
        try {
            this.f2898b.t();
        } catch (IOException e4) {
            this.f2897a.g(e4);
        }
    }
}
