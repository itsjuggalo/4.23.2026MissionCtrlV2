package H4;

import H4.j;
import io.flutter.embedding.android.KeyboardMap;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import u7.C2811d;
import u7.C2814g;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements J4.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f3753d = Logger.getLogger(i.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f3754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final J4.c f3755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f3756c = new j(Level.FINE, i.class);

    public interface a {
        void g(Throwable th);
    }

    public b(a aVar, J4.c cVar) {
        this.f3754a = (a) AbstractC2848n.o(aVar, "transportExceptionHandler");
        this.f3755b = (J4.c) AbstractC2848n.o(cVar, "frameWriter");
    }

    public static Level a(Throwable th) {
        return th.getClass().equals(IOException.class) ? Level.FINE : Level.INFO;
    }

    @Override // J4.c
    public void F(boolean z7, int i8, C2811d c2811d, int i9) {
        this.f3756c.b(j.a.OUTBOUND, i8, c2811d.c(), i9, z7);
        try {
            this.f3755b.F(z7, i8, c2811d, i9);
        } catch (IOException e8) {
            this.f3754a.g(e8);
        }
    }

    @Override // J4.c
    public void b(int i8, long j8) {
        this.f3756c.k(j.a.OUTBOUND, i8, j8);
        try {
            this.f3755b.b(i8, j8);
        } catch (IOException e8) {
            this.f3754a.g(e8);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.f3755b.close();
        } catch (IOException e8) {
            f3753d.log(a(e8), "Failed closing connection", (Throwable) e8);
        }
    }

    @Override // J4.c
    public void flush() {
        try {
            this.f3755b.flush();
        } catch (IOException e8) {
            this.f3754a.g(e8);
        }
    }

    @Override // J4.c
    public void g(boolean z7, int i8, int i9) {
        j jVar = this.f3756c;
        j.a aVar = j.a.OUTBOUND;
        long j8 = (KeyboardMap.kValueMask & ((long) i9)) | (((long) i8) << 32);
        if (z7) {
            jVar.f(aVar, j8);
        } else {
            jVar.e(aVar, j8);
        }
        try {
            this.f3755b.g(z7, i8, i9);
        } catch (IOException e8) {
            this.f3754a.g(e8);
        }
    }

    @Override // J4.c
    public void h(int i8, J4.a aVar) {
        this.f3756c.h(j.a.OUTBOUND, i8, aVar);
        try {
            this.f3755b.h(i8, aVar);
        } catch (IOException e8) {
            this.f3754a.g(e8);
        }
    }

    @Override // J4.c
    public void h0(int i8, J4.a aVar, byte[] bArr) {
        this.f3756c.c(j.a.OUTBOUND, i8, aVar, C2814g.M(bArr));
        try {
            this.f3755b.h0(i8, aVar, bArr);
            this.f3755b.flush();
        } catch (IOException e8) {
            this.f3754a.g(e8);
        }
    }

    @Override // J4.c
    public int k0() {
        return this.f3755b.k0();
    }

    @Override // J4.c
    public void l(J4.i iVar) {
        this.f3756c.i(j.a.OUTBOUND, iVar);
        try {
            this.f3755b.l(iVar);
        } catch (IOException e8) {
            this.f3754a.g(e8);
        }
    }

    @Override // J4.c
    public void l0(boolean z7, boolean z8, int i8, int i9, List list) {
        try {
            this.f3755b.l0(z7, z8, i8, i9, list);
        } catch (IOException e8) {
            this.f3754a.g(e8);
        }
    }

    @Override // J4.c
    public void m(J4.i iVar) {
        this.f3756c.j(j.a.OUTBOUND);
        try {
            this.f3755b.m(iVar);
        } catch (IOException e8) {
            this.f3754a.g(e8);
        }
    }

    @Override // J4.c
    public void y() {
        try {
            this.f3755b.y();
        } catch (IOException e8) {
            this.f3754a.g(e8);
        }
    }
}
