package H4;

import java.io.IOException;
import java.util.List;
import u7.C2811d;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements J4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final J4.c f3757a;

    public c(J4.c cVar) {
        this.f3757a = (J4.c) AbstractC2848n.o(cVar, "delegate");
    }

    @Override // J4.c
    public void F(boolean z7, int i8, C2811d c2811d, int i9) {
        this.f3757a.F(z7, i8, c2811d, i9);
    }

    @Override // J4.c
    public void b(int i8, long j8) {
        this.f3757a.b(i8, j8);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3757a.close();
    }

    @Override // J4.c
    public void flush() {
        this.f3757a.flush();
    }

    @Override // J4.c
    public void g(boolean z7, int i8, int i9) {
        this.f3757a.g(z7, i8, i9);
    }

    @Override // J4.c
    public void h(int i8, J4.a aVar) {
        this.f3757a.h(i8, aVar);
    }

    @Override // J4.c
    public void h0(int i8, J4.a aVar, byte[] bArr) {
        this.f3757a.h0(i8, aVar, bArr);
    }

    @Override // J4.c
    public int k0() {
        return this.f3757a.k0();
    }

    @Override // J4.c
    public void l(J4.i iVar) {
        this.f3757a.l(iVar);
    }

    @Override // J4.c
    public void l0(boolean z7, boolean z8, int i8, int i9, List list) {
        this.f3757a.l0(z7, z8, i8, i9, list);
    }

    @Override // J4.c
    public void m(J4.i iVar) {
        this.f3757a.m(iVar);
    }

    @Override // J4.c
    public void y() {
        this.f3757a.y();
    }
}
