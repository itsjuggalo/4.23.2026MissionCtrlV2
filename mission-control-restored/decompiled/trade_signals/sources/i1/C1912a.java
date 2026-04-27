package i1;

import U0.h;
import W0.v;
import android.graphics.Bitmap;
import e1.C1662b;
import java.io.ByteArrayOutputStream;

/* JADX INFO: renamed from: i1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1912a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap.CompressFormat f18751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18752b;

    public C1912a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // i1.e
    public v a(v vVar, h hVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) vVar.get()).compress(this.f18751a, this.f18752b, byteArrayOutputStream);
        vVar.b();
        return new C1662b(byteArrayOutputStream.toByteArray());
    }

    public C1912a(Bitmap.CompressFormat compressFormat, int i8) {
        this.f18751a = compressFormat;
        this.f18752b = i8;
    }
}
