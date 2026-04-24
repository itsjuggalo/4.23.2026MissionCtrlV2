package O0;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final float a(Bitmap bitmap, int i4, int i5) {
        r.f(bitmap, "<this>");
        float width = bitmap.getWidth() / i4;
        float height = bitmap.getHeight() / i5;
        e("width scale = " + width);
        e("height scale = " + height);
        return Math.max(1.0f, Math.min(width, height));
    }

    public static final void b(Bitmap bitmap, int i4, int i5, int i6, int i7, OutputStream outputStream, int i8) {
        r.f(bitmap, "<this>");
        r.f(outputStream, "outputStream");
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        e("src width = " + width);
        e("src height = " + height);
        float fA = a(bitmap, i4, i5);
        e("scale = " + fA);
        float f4 = width / fA;
        float f5 = height / fA;
        e("dst width = " + f4);
        e("dst height = " + f5);
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) f4, (int) f5, true);
        r.e(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        f(bitmapCreateScaledBitmap, i7).compress(d(i8), i6, outputStream);
    }

    public static final byte[] c(Bitmap bitmap, int i4, int i5, int i6, int i7, int i8) {
        r.f(bitmap, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b(bitmap, i4, i5, i6, i7, byteArrayOutputStream, i8);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        r.e(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public static final Bitmap.CompressFormat d(int i4) {
        return i4 != 1 ? i4 != 3 ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.WEBP : Bitmap.CompressFormat.PNG;
    }

    public static final void e(Object obj) {
        if (L0.a.f1391c.a()) {
            if (obj == null) {
                obj = "null";
            }
            System.out.println(obj);
        }
    }

    public static final Bitmap f(Bitmap bitmap, int i4) {
        r.f(bitmap, "<this>");
        if (i4 % 360 == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i4);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        r.c(bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }
}
