package N2;

import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c implements P2.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final P2.c f2900a;

    public c(P2.c cVar) {
        this.f2900a = (P2.c) Z1.m.o(cVar, "delegate");
    }

    @Override // P2.c
    public void F(P2.i iVar) {
        this.f2900a.F(iVar);
    }

    @Override // P2.c
    public void H(P2.i iVar) {
        this.f2900a.H(iVar);
    }

    @Override // P2.c
    public void N(int i4, P2.a aVar, byte[] bArr) {
        this.f2900a.N(i4, aVar, bArr);
    }

    @Override // P2.c
    public int V() {
        return this.f2900a.V();
    }

    @Override // P2.c
    public void W(boolean z4, boolean z5, int i4, int i5, List list) {
        this.f2900a.W(z4, z5, i4, i5, list);
    }

    @Override // P2.c
    public void X(boolean z4, int i4, O3.d dVar, int i5) {
        this.f2900a.X(z4, i4, dVar, i5);
    }

    @Override // P2.c
    public void a(int i4, P2.a aVar) {
        this.f2900a.a(i4, aVar);
    }

    @Override // P2.c
    public void b(int i4, long j4) {
        this.f2900a.b(i4, j4);
    }

    @Override // P2.c
    public void c(boolean z4, int i4, int i5) {
        this.f2900a.c(z4, i4, i5);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f2900a.close();
    }

    @Override // P2.c
    public void flush() {
        this.f2900a.flush();
    }

    @Override // P2.c
    public void t() {
        this.f2900a.t();
    }
}
