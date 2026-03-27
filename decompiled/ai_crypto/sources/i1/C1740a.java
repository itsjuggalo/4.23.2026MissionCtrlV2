package i1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import e1.C1470b;
import f1.AbstractC1549a;
import h1.InterfaceC1668a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import k1.AbstractC2065a;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: i1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1740a implements InterfaceC1668a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bitmap.CompressFormat f14989c;

    public C1740a(int i7) {
        this.f14987a = i7;
        int type = getType();
        this.f14988b = type != 1 ? type != 3 ? "jpeg" : "webp" : "png";
        int type2 = getType();
        this.f14989c = type2 != 1 ? type2 != 3 ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.WEBP : Bitmap.CompressFormat.PNG;
    }

    @Override // h1.InterfaceC1668a
    public void a(Context context, byte[] byteArray, OutputStream outputStream, int i7, int i8, int i9, int i10, boolean z7, int i11) throws IOException {
        r.f(context, "context");
        r.f(byteArray, "byteArray");
        r.f(outputStream, "outputStream");
        byte[] bArrC = c(byteArray, i7, i8, i9, i10, i11);
        if (!z7 || this.f14989c != Bitmap.CompressFormat.JPEG) {
            outputStream.write(bArrC);
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(bArrC);
        outputStream.write(new C1470b(byteArray).c(context, byteArrayOutputStream).toByteArray());
    }

    @Override // h1.InterfaceC1668a
    public void b(Context context, String path, OutputStream outputStream, int i7, int i8, int i9, int i10, boolean z7, int i11, int i12) throws IOException {
        r.f(context, "context");
        r.f(path, "path");
        r.f(outputStream, "outputStream");
        if (i12 <= 0) {
            return;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            options.inSampleSize = i11;
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(path, options);
            r.c(bitmapDecodeFile);
            byte[] bArrC = AbstractC1549a.c(bitmapDecodeFile, i7, i8, i9, i10, getType());
            if (z7) {
                try {
                    if (this.f14989c == Bitmap.CompressFormat.JPEG) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byteArrayOutputStream.write(bArrC);
                        outputStream.write(new C1470b(path).c(context, byteArrayOutputStream).toByteArray());
                    }
                } catch (OutOfMemoryError unused) {
                    System.gc();
                    b(context, path, outputStream, i7, i8, i9, i10, z7, i11 * 2, i12 - 1);
                    return;
                }
            }
            outputStream.write(bArrC);
        } catch (OutOfMemoryError unused2) {
        }
    }

    public final byte[] c(byte[] bArr, int i7, int i8, int i9, int i10, int i11) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inSampleSize = i11;
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        float width = bitmapDecodeByteArray.getWidth();
        float height = bitmapDecodeByteArray.getHeight();
        AbstractC2065a.a("src width = " + width);
        AbstractC2065a.a("src height = " + height);
        r.c(bitmapDecodeByteArray);
        float fA = AbstractC1549a.a(bitmapDecodeByteArray, i7, i8);
        AbstractC2065a.a("scale = " + fA);
        float f7 = width / fA;
        float f8 = height / fA;
        AbstractC2065a.a("dst width = " + f7);
        AbstractC2065a.a("dst height = " + f8);
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeByteArray, (int) f7, (int) f8, true);
        r.e(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        AbstractC1549a.f(bitmapCreateScaledBitmap, i10).compress(this.f14989c, i9, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        r.e(byteArray, "toByteArray(...)");
        return byteArray;
    }

    @Override // h1.InterfaceC1668a
    public int getType() {
        return this.f14987a;
    }
}
