package u5;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import u5.j;
import w5.C2786i;
import w5.EnumC2778a;
import w5.InterfaceC2780c;
import w6.C2792e;
import w6.C2795h;

/* JADX INFO: renamed from: u5.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2755b implements InterfaceC2780c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f24488d = Logger.getLogger(i.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f24489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2780c f24490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f24491c = new j(Level.FINE, i.class);

    /* JADX INFO: renamed from: u5.b$a */
    public interface a {
        void g(Throwable th);
    }

    public C2755b(a aVar, InterfaceC2780c interfaceC2780c) {
        this.f24489a = (a) H2.m.o(aVar, "transportExceptionHandler");
        this.f24490b = (InterfaceC2780c) H2.m.o(interfaceC2780c, "frameWriter");
    }

    public static Level h(Throwable th) {
        return th.getClass().equals(IOException.class) ? Level.FINE : Level.INFO;
    }

    @Override // w5.InterfaceC2780c
    public void D(C2786i c2786i) {
        this.f24491c.i(j.a.OUTBOUND, c2786i);
        try {
            this.f24490b.D(c2786i);
        } catch (IOException e7) {
            this.f24489a.g(e7);
        }
    }

    @Override // w5.InterfaceC2780c
    public void S(C2786i c2786i) {
        this.f24491c.j(j.a.OUTBOUND);
        try {
            this.f24490b.S(c2786i);
        } catch (IOException e7) {
            this.f24489a.g(e7);
        }
    }

    @Override // w5.InterfaceC2780c
    public void a(int i7, long j7) {
        this.f24491c.k(j.a.OUTBOUND, i7, j7);
        try {
            this.f24490b.a(i7, j7);
        } catch (IOException e7) {
            this.f24489a.g(e7);
        }
    }

    @Override // w5.InterfaceC2780c
    public void b(boolean z7, int i7, int i8) {
        if (z7) {
            this.f24491c.f(j.a.OUTBOUND, (4294967295L & ((long) i8)) | (((long) i7) << 32));
        } else {
            this.f24491c.e(j.a.OUTBOUND, (4294967295L & ((long) i8)) | (((long) i7) << 32));
        }
        try {
            this.f24490b.b(z7, i7, i8);
        } catch (IOException e7) {
            this.f24489a.g(e7);
        }
    }

    @Override // w5.InterfaceC2780c
    public void c(int i7, EnumC2778a enumC2778a) {
        this.f24491c.h(j.a.OUTBOUND, i7, enumC2778a);
        try {
            this.f24490b.c(i7, enumC2778a);
        } catch (IOException e7) {
            this.f24489a.g(e7);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.f24490b.close();
        } catch (IOException e7) {
            f24488d.log(h(e7), "Failed closing connection", (Throwable) e7);
        }
    }

    @Override // w5.InterfaceC2780c
    public void flush() {
        try {
            this.f24490b.flush();
        } catch (IOException e7) {
            this.f24489a.g(e7);
        }
    }

    @Override // w5.InterfaceC2780c
    public void k0(boolean z7, int i7, C2792e c2792e, int i8) {
        this.f24491c.b(j.a.OUTBOUND, i7, c2792e.d(), i8, z7);
        try {
            this.f24490b.k0(z7, i7, c2792e, i8);
        } catch (IOException e7) {
            this.f24489a.g(e7);
        }
    }

    @Override // w5.InterfaceC2780c
    public int m0() {
        return this.f24490b.m0();
    }

    @Override // w5.InterfaceC2780c
    public void n0(boolean z7, boolean z8, int i7, int i8, List list) {
        try {
            this.f24490b.n0(z7, z8, i7, i8, list);
        } catch (IOException e7) {
            this.f24489a.g(e7);
        }
    }

    @Override // w5.InterfaceC2780c
    public void u0(int i7, EnumC2778a enumC2778a, byte[] bArr) {
        this.f24491c.c(j.a.OUTBOUND, i7, enumC2778a, C2795h.A(bArr));
        try {
            this.f24490b.u0(i7, enumC2778a, bArr);
            this.f24490b.flush();
        } catch (IOException e7) {
            this.f24489a.g(e7);
        }
    }

    @Override // w5.InterfaceC2780c
    public void w() {
        try {
            this.f24490b.w();
        } catch (IOException e7) {
            this.f24489a.g(e7);
        }
    }
}
