package d1;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: renamed from: d1.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1617f implements U0.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final X0.d f16779a = new X0.e();

    @Override // U0.j
    public /* bridge */ /* synthetic */ W0.v a(Object obj, int i8, int i9, U0.h hVar) {
        return c(AbstractC1615d.a(obj), i8, i9, hVar);
    }

    @Override // U0.j
    public /* bridge */ /* synthetic */ boolean b(Object obj, U0.h hVar) {
        return d(AbstractC1615d.a(obj), hVar);
    }

    public W0.v c(ImageDecoder.Source source, int i8, int i9, U0.h hVar) throws IOException {
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, new c1.l(i8, i9, hVar));
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            Log.v("BitmapImageDecoder", "Decoded [" + bitmapDecodeBitmap.getWidth() + "x" + bitmapDecodeBitmap.getHeight() + "] for [" + i8 + "x" + i9 + "]");
        }
        return new C1618g(bitmapDecodeBitmap, this.f16779a);
    }

    public boolean d(ImageDecoder.Source source, U0.h hVar) {
        return true;
    }
}
