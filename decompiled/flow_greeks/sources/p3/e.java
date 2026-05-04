package p3;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements g3.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j3.d f18222a = new j3.e();

    @Override // g3.j
    public /* bridge */ /* synthetic */ i3.v a(Object obj, int i10, int i11, g3.h hVar) {
        return c(d.a(obj), i10, i11, hVar);
    }

    @Override // g3.j
    public /* bridge */ /* synthetic */ boolean b(Object obj, g3.h hVar) {
        return d(d.a(obj), hVar);
    }

    public i3.v c(ImageDecoder.Source source, int i10, int i11, g3.h hVar) throws IOException {
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, new o3.c(i10, i11, hVar));
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            Log.v("BitmapImageDecoder", "Decoded [" + bitmapDecodeBitmap.getWidth() + "x" + bitmapDecodeBitmap.getHeight() + "] for [" + i10 + "x" + i11 + "]");
        }
        return new f(bitmapDecodeBitmap, this.f18222a);
    }

    public boolean d(ImageDecoder.Source source, g3.h hVar) {
        return true;
    }
}
