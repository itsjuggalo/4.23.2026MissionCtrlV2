package j1;

import O5.h;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import f1.AbstractC1549a;
import h1.InterfaceC1668a;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import k1.AbstractC2065a;
import kotlin.jvm.internal.r;
import l1.C2155a;
import o0.C2287f;

/* JADX INFO: renamed from: j1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2043a implements InterfaceC1668a {
    @Override // h1.InterfaceC1668a
    public void a(Context context, byte[] byteArray, OutputStream outputStream, int i7, int i8, int i9, int i10, boolean z7, int i11) throws IOException {
        r.f(context, "context");
        r.f(byteArray, "byteArray");
        r.f(outputStream, "outputStream");
        File fileA = C2155a.f18291a.a(context);
        String absolutePath = fileA.getAbsolutePath();
        r.e(absolutePath, "getAbsolutePath(...)");
        d(byteArray, i7, i8, i9, i10, i11, absolutePath);
        outputStream.write(h.c(fileA));
    }

    @Override // h1.InterfaceC1668a
    public void b(Context context, String path, OutputStream outputStream, int i7, int i8, int i9, int i10, boolean z7, int i11, int i12) throws IOException {
        r.f(context, "context");
        r.f(path, "path");
        r.f(outputStream, "outputStream");
        File fileA = C2155a.f18291a.a(context);
        String absolutePath = fileA.getAbsolutePath();
        r.e(absolutePath, "getAbsolutePath(...)");
        c(path, i7, i8, i9, i10, i11, absolutePath);
        outputStream.write(h.c(fileA));
    }

    public final void c(String str, int i7, int i8, int i9, int i10, int i11, String str2) {
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str, f(i11));
        r.c(bitmapDecodeFile);
        e(bitmapDecodeFile, i7, i8, i10, str2, i9);
    }

    public final void d(byte[] bArr, int i7, int i8, int i9, int i10, int i11, String str) {
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, f(i11));
        r.c(bitmapDecodeByteArray);
        e(bitmapDecodeByteArray, i7, i8, i10, str, i9);
    }

    public final void e(Bitmap bitmap, int i7, int i8, int i9, String str, int i10) {
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        AbstractC2065a.a("src width = " + width);
        AbstractC2065a.a("src height = " + height);
        float fA = AbstractC1549a.a(bitmap, i7, i8);
        AbstractC2065a.a("scale = " + fA);
        float f7 = width / fA;
        float f8 = height / fA;
        AbstractC2065a.a("dst width = " + f7);
        AbstractC2065a.a("dst height = " + f8);
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) f7, (int) f8, true);
        r.e(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        Bitmap bitmapF = AbstractC1549a.f(bitmapCreateScaledBitmap, i9);
        C2287f c2287fA = new C2287f.b(str, bitmapF.getWidth(), bitmapF.getHeight(), 2).c(i10).b(1).a();
        c2287fA.M();
        c2287fA.h(bitmapF);
        c2287fA.O(5000L);
        c2287fA.close();
    }

    public final BitmapFactory.Options f(int i7) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inSampleSize = i7;
        return options;
    }

    @Override // h1.InterfaceC1668a
    public int getType() {
        return 2;
    }
}
