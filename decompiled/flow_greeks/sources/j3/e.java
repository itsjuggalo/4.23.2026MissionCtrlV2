package j3;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e implements d {
    @Override // j3.d
    public void c(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // j3.d
    public Bitmap d(int i10, int i11, Bitmap.Config config) {
        return Bitmap.createBitmap(i10, i11, config);
    }

    @Override // j3.d
    public Bitmap e(int i10, int i11, Bitmap.Config config) {
        return d(i10, i11, config);
    }

    @Override // j3.d
    public void b() {
    }

    @Override // j3.d
    public void a(int i10) {
    }
}
