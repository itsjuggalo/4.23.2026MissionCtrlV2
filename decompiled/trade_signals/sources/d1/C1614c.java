package d1;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import q1.AbstractC2624g;
import q1.AbstractC2629l;
import r1.AbstractC2671b;

/* JADX INFO: renamed from: d1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1614c implements U0.k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final U0.g f16776b = U0.g.f("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final U0.g f16777c = U0.g.e("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final X0.b f16778a;

    public C1614c(X0.b bVar) {
        this.f16778a = bVar;
    }

    @Override // U0.k
    public U0.c b(U0.h hVar) {
        return U0.c.TRANSFORMED;
    }

    @Override // U0.d
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(W0.v vVar, File file, U0.h hVar) {
        boolean z7;
        FileOutputStream fileOutputStream;
        Bitmap bitmap = (Bitmap) vVar.get();
        Bitmap.CompressFormat compressFormatD = d(bitmap, hVar);
        AbstractC2671b.d("encode: [%dx%d] %s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), compressFormatD);
        try {
            long jB = AbstractC2624g.b();
            int iIntValue = ((Integer) hVar.c(f16776b)).intValue();
            OutputStream cVar = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e8) {
                e = e8;
            }
            try {
                cVar = this.f16778a != null ? new com.bumptech.glide.load.data.c(fileOutputStream, this.f16778a) : fileOutputStream;
                bitmap.compress(compressFormatD, iIntValue, cVar);
                cVar.close();
                try {
                    cVar.close();
                } catch (IOException unused) {
                }
                z7 = true;
            } catch (IOException e9) {
                e = e9;
                cVar = fileOutputStream;
                if (Log.isLoggable("BitmapEncoder", 3)) {
                    Log.d("BitmapEncoder", "Failed to encode Bitmap", e);
                }
                if (cVar != null) {
                    try {
                        cVar.close();
                    } catch (IOException unused2) {
                    }
                }
                z7 = false;
            } catch (Throwable th2) {
                th = th2;
                cVar = fileOutputStream;
                if (cVar != null) {
                    try {
                        cVar.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
            if (Log.isLoggable("BitmapEncoder", 2)) {
                Log.v("BitmapEncoder", "Compressed with type: " + compressFormatD + " of size " + AbstractC2629l.h(bitmap) + " in " + AbstractC2624g.a(jB) + ", options format: " + hVar.c(f16777c) + ", hasAlpha: " + bitmap.hasAlpha());
            }
            return z7;
        } finally {
            AbstractC2671b.e();
        }
    }

    public final Bitmap.CompressFormat d(Bitmap bitmap, U0.h hVar) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) hVar.c(f16777c);
        return compressFormat != null ? compressFormat : bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }
}
