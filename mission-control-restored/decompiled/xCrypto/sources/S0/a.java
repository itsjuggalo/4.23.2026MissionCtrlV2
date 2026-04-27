package S0;

import Z.f;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import g3.h;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Q0.a {
    @Override // Q0.a
    public void a(Context context, byte[] byteArray, OutputStream outputStream, int i4, int i5, int i6, int i7, boolean z4, int i8) throws IOException {
        r.f(context, "context");
        r.f(byteArray, "byteArray");
        r.f(outputStream, "outputStream");
        File fileA = U0.a.f5248a.a(context);
        String absolutePath = fileA.getAbsolutePath();
        r.e(absolutePath, "getAbsolutePath(...)");
        d(byteArray, i4, i5, i6, i7, i8, absolutePath);
        outputStream.write(h.c(fileA));
    }

    @Override // Q0.a
    public void b(Context context, String path, OutputStream outputStream, int i4, int i5, int i6, int i7, boolean z4, int i8, int i9) throws IOException {
        r.f(context, "context");
        r.f(path, "path");
        r.f(outputStream, "outputStream");
        File fileA = U0.a.f5248a.a(context);
        String absolutePath = fileA.getAbsolutePath();
        r.e(absolutePath, "getAbsolutePath(...)");
        c(path, i4, i5, i6, i7, i8, absolutePath);
        outputStream.write(h.c(fileA));
    }

    public final void c(String str, int i4, int i5, int i6, int i7, int i8, String str2) {
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str, f(i8));
        r.c(bitmapDecodeFile);
        e(bitmapDecodeFile, i4, i5, i7, str2, i6);
    }

    public final void d(byte[] bArr, int i4, int i5, int i6, int i7, int i8, String str) {
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, f(i8));
        r.c(bitmapDecodeByteArray);
        e(bitmapDecodeByteArray, i4, i5, i7, str, i6);
    }

    public final void e(Bitmap bitmap, int i4, int i5, int i6, String str, int i7) {
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        T0.a.a("src width = " + width);
        T0.a.a("src height = " + height);
        float fA = O0.a.a(bitmap, i4, i5);
        T0.a.a("scale = " + fA);
        float f4 = width / fA;
        float f5 = height / fA;
        T0.a.a("dst width = " + f4);
        T0.a.a("dst height = " + f5);
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) f4, (int) f5, true);
        r.e(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        Bitmap bitmapF = O0.a.f(bitmapCreateScaledBitmap, i6);
        f fVarA = new f.b(str, bitmapF.getWidth(), bitmapF.getHeight(), 2).c(i7).b(1).a();
        fVarA.E();
        fVarA.e(bitmapF);
        fVarA.G(5000L);
        fVarA.close();
    }

    public final BitmapFactory.Options f(int i4) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inSampleSize = i4;
        return options;
    }

    @Override // Q0.a
    public int getType() {
        return 2;
    }
}
