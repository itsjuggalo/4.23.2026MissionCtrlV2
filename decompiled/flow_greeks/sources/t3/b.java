package t3;

import android.graphics.Bitmap;
import f3.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements a.InterfaceC0172a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j3.d f20685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j3.b f20686b;

    public b(j3.d dVar, j3.b bVar) {
        this.f20685a = dVar;
        this.f20686b = bVar;
    }

    @Override // f3.a.InterfaceC0172a
    public Bitmap a(int i10, int i11, Bitmap.Config config) {
        return this.f20685a.e(i10, i11, config);
    }

    @Override // f3.a.InterfaceC0172a
    public int[] b(int i10) {
        j3.b bVar = this.f20686b;
        return bVar == null ? new int[i10] : (int[]) bVar.d(i10, int[].class);
    }

    @Override // f3.a.InterfaceC0172a
    public void c(Bitmap bitmap) {
        this.f20685a.c(bitmap);
    }

    @Override // f3.a.InterfaceC0172a
    public void d(byte[] bArr) {
        j3.b bVar = this.f20686b;
        if (bVar == null) {
            return;
        }
        bVar.put(bArr);
    }

    @Override // f3.a.InterfaceC0172a
    public byte[] e(int i10) {
        j3.b bVar = this.f20686b;
        return bVar == null ? new byte[i10] : (byte[]) bVar.d(i10, byte[].class);
    }

    @Override // f3.a.InterfaceC0172a
    public void f(int[] iArr) {
        j3.b bVar = this.f20686b;
        if (bVar == null) {
            return;
        }
        bVar.put(iArr);
    }
}
