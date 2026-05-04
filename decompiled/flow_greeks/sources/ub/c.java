package ub;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c implements wb.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wb.c f22749a;

    public c(wb.c cVar) {
        this.f22749a = (wb.c) p6.n.o(cVar, "delegate");
    }

    @Override // wb.c
    public int T() {
        return this.f22749a.T();
    }

    @Override // wb.c
    public void U(boolean z10, boolean z11, int i10, int i11, List list) {
        this.f22749a.U(z10, z11, i10, i11, list);
    }

    @Override // wb.c
    public void X(wb.i iVar) {
        this.f22749a.X(iVar);
    }

    @Override // wb.c
    public void a(int i10, long j10) {
        this.f22749a.a(i10, j10);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f22749a.close();
    }

    @Override // wb.c
    public void f(boolean z10, int i10, int i11) {
        this.f22749a.f(z10, i10, i11);
    }

    @Override // wb.c
    public void flush() {
        this.f22749a.flush();
    }

    @Override // wb.c
    public void g(int i10, wb.a aVar) {
        this.f22749a.g(i10, aVar);
    }

    @Override // wb.c
    public void j(boolean z10, int i10, hh.d dVar, int i11) {
        this.f22749a.j(z10, i10, dVar, i11);
    }

    @Override // wb.c
    public void m(int i10, wb.a aVar, byte[] bArr) {
        this.f22749a.m(i10, aVar, bArr);
    }

    @Override // wb.c
    public void r() {
        this.f22749a.r();
    }

    @Override // wb.c
    public void v(wb.i iVar) {
        this.f22749a.v(iVar);
    }
}
