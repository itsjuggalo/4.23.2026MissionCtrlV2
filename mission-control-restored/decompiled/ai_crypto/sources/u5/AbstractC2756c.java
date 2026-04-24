package u5;

import java.io.IOException;
import java.util.List;
import w5.C2786i;
import w5.EnumC2778a;
import w5.InterfaceC2780c;
import w6.C2792e;

/* JADX INFO: renamed from: u5.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2756c implements InterfaceC2780c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2780c f24492a;

    public AbstractC2756c(InterfaceC2780c interfaceC2780c) {
        this.f24492a = (InterfaceC2780c) H2.m.o(interfaceC2780c, "delegate");
    }

    @Override // w5.InterfaceC2780c
    public void D(C2786i c2786i) {
        this.f24492a.D(c2786i);
    }

    @Override // w5.InterfaceC2780c
    public void S(C2786i c2786i) {
        this.f24492a.S(c2786i);
    }

    @Override // w5.InterfaceC2780c
    public void a(int i7, long j7) {
        this.f24492a.a(i7, j7);
    }

    @Override // w5.InterfaceC2780c
    public void b(boolean z7, int i7, int i8) {
        this.f24492a.b(z7, i7, i8);
    }

    @Override // w5.InterfaceC2780c
    public void c(int i7, EnumC2778a enumC2778a) {
        this.f24492a.c(i7, enumC2778a);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f24492a.close();
    }

    @Override // w5.InterfaceC2780c
    public void flush() {
        this.f24492a.flush();
    }

    @Override // w5.InterfaceC2780c
    public void k0(boolean z7, int i7, C2792e c2792e, int i8) {
        this.f24492a.k0(z7, i7, c2792e, i8);
    }

    @Override // w5.InterfaceC2780c
    public int m0() {
        return this.f24492a.m0();
    }

    @Override // w5.InterfaceC2780c
    public void n0(boolean z7, boolean z8, int i7, int i8, List list) {
        this.f24492a.n0(z7, z8, i7, i8, list);
    }

    @Override // w5.InterfaceC2780c
    public void u0(int i7, EnumC2778a enumC2778a, byte[] bArr) {
        this.f24492a.u0(i7, enumC2778a, bArr);
    }

    @Override // w5.InterfaceC2780c
    public void w() {
        this.f24492a.w();
    }
}
