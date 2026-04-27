package R0;

import N0.b;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Q0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bitmap.CompressFormat f3559c;

    public a(int i4) {
        this.f3557a = i4;
        int type = getType();
        this.f3558b = type != 1 ? type != 3 ? "jpeg" : "webp" : "png";
        int type2 = getType();
        this.f3559c = type2 != 1 ? type2 != 3 ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.WEBP : Bitmap.CompressFormat.PNG;
    }

    @Override // Q0.a
    public void a(Context context, byte[] byteArray, OutputStream outputStream, int i4, int i5, int i6, int i7, boolean z4, int i8) throws IOException {
        r.f(context, "context");
        r.f(byteArray, "byteArray");
        r.f(outputStream, "outputStream");
        byte[] bArrC = c(byteArray, i4, i5, i6, i7, i8);
        if (!z4 || this.f3559c != Bitmap.CompressFormat.JPEG) {
            outputStream.write(bArrC);
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(bArrC);
        outputStream.write(new b(byteArray).c(context, byteArrayOutputStream).toByteArray());
    }

    @Override // Q0.a
    public void b(Context context, String path, OutputStream outputStream, int i4, int i5, int i6, int i7, boolean z4, int i8, int i9) throws IOException {
        r.f(context, "context");
        r.f(path, "path");
        r.f(outputStream, "outputStream");
        if (i9 <= 0) {
            return;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            options.inSampleSize = i8;
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(path, options);
            r.c(bitmapDecodeFile);
            byte[] bArrC = O0.a.c(bitmapDecodeFile, i4, i5, i6, i7, getType());
            if (!z4 || this.f3559c != Bitmap.CompressFormat.JPEG) {
                outputStream.write(bArrC);
                return;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(bArrC);
            outputStream.write(new b(path).c(context, byteArrayOutputStream).toByteArray());
        } catch (OutOfMemoryError unused) {
            System.gc();
            b(context, path, outputStream, i4, i5, i6, i7, z4, i8 * 2, i9 - 1);
        }
    }

    public final byte[] c(byte[] bArr, int i4, int i5, int i6, int i7, int i8) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inSampleSize = i8;
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        float width = bitmapDecodeByteArray.getWidth();
        float height = bitmapDecodeByteArray.getHeight();
        T0.a.a("src width = " + width);
        T0.a.a("src height = " + height);
        r.c(bitmapDecodeByteArray);
        float fA = O0.a.a(bitmapDecodeByteArray, i4, i5);
        T0.a.a("scale = " + fA);
        float f4 = width / fA;
        float f5 = height / fA;
        T0.a.a("dst width = " + f4);
        T0.a.a("dst height = " + f5);
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeByteArray, (int) f4, (int) f5, true);
        r.e(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        O0.a.f(bitmapCreateScaledBitmap, i7).compress(this.f3559c, i6, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        r.e(byteArray, "toByteArray(...)");
        return byteArray;
    }

    @Override // Q0.a
    public int getType() {
        return this.f3557a;
    }
}
