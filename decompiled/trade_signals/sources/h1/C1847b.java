package h1;

import T0.a;
import android.graphics.Bitmap;

/* JADX INFO: renamed from: h1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1847b implements a.InterfaceC0112a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final X0.d f18342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final X0.b f18343b;

    public C1847b(X0.d dVar, X0.b bVar) {
        this.f18342a = dVar;
        this.f18343b = bVar;
    }

    @Override // T0.a.InterfaceC0112a
    public Bitmap a(int i8, int i9, Bitmap.Config config) {
        return this.f18342a.e(i8, i9, config);
    }

    @Override // T0.a.InterfaceC0112a
    public int[] b(int i8) {
        X0.b bVar = this.f18343b;
        return bVar == null ? new int[i8] : (int[]) bVar.e(i8, int[].class);
    }

    @Override // T0.a.InterfaceC0112a
    public void c(Bitmap bitmap) {
        this.f18342a.c(bitmap);
    }

    @Override // T0.a.InterfaceC0112a
    public void d(byte[] bArr) {
        X0.b bVar = this.f18343b;
        if (bVar == null) {
            return;
        }
        bVar.d(bArr);
    }

    @Override // T0.a.InterfaceC0112a
    public byte[] e(int i8) {
        X0.b bVar = this.f18343b;
        return bVar == null ? new byte[i8] : (byte[]) bVar.e(i8, byte[].class);
    }

    @Override // T0.a.InterfaceC0112a
    public void f(int[] iArr) {
        X0.b bVar = this.f18343b;
        if (bVar == null) {
            return;
        }
        bVar.d(iArr);
    }
}
