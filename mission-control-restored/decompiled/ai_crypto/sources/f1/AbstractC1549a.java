package f1;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import c1.C1124a;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: f1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1549a {
    public static final float a(Bitmap bitmap, int i7, int i8) {
        r.f(bitmap, "<this>");
        float width = bitmap.getWidth() / i7;
        float height = bitmap.getHeight() / i8;
        e("width scale = " + width);
        e("height scale = " + height);
        return Math.max(1.0f, Math.min(width, height));
    }

    public static final void b(Bitmap bitmap, int i7, int i8, int i9, int i10, OutputStream outputStream, int i11) {
        r.f(bitmap, "<this>");
        r.f(outputStream, "outputStream");
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        e("src width = " + width);
        e("src height = " + height);
        float fA = a(bitmap, i7, i8);
        e("scale = " + fA);
        float f7 = width / fA;
        float f8 = height / fA;
        e("dst width = " + f7);
        e("dst height = " + f8);
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) f7, (int) f8, true);
        r.e(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        f(bitmapCreateScaledBitmap, i10).compress(d(i11), i9, outputStream);
    }

    public static final byte[] c(Bitmap bitmap, int i7, int i8, int i9, int i10, int i11) {
        r.f(bitmap, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b(bitmap, i7, i8, i9, i10, byteArrayOutputStream, i11);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        r.e(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public static final Bitmap.CompressFormat d(int i7) {
        return i7 != 1 ? i7 != 3 ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.WEBP : Bitmap.CompressFormat.PNG;
    }

    public static final void e(Object obj) {
        if (C1124a.f9329e.a()) {
            if (obj == null) {
                obj = "null";
            }
            System.out.println(obj);
        }
    }

    public static final Bitmap f(Bitmap bitmap, int i7) {
        r.f(bitmap, "<this>");
        if (i7 % 360 == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i7);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        r.c(bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }
}
