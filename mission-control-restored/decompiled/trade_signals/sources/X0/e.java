package X0;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public class e implements d {
    @Override // X0.d
    public void c(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // X0.d
    public Bitmap d(int i8, int i9, Bitmap.Config config) {
        return Bitmap.createBitmap(i8, i9, config);
    }

    @Override // X0.d
    public Bitmap e(int i8, int i9, Bitmap.Config config) {
        return d(i8, i9, config);
    }

    @Override // X0.d
    public void b() {
    }

    @Override // X0.d
    public void a(int i8) {
    }
}
