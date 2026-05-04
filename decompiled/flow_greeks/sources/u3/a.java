package u3;

import android.graphics.Bitmap;
import g3.h;
import i3.v;
import java.io.ByteArrayOutputStream;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap.CompressFormat f22158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22159b;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // u3.e
    public v a(v vVar, h hVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) vVar.get()).compress(this.f22158a, this.f22159b, byteArrayOutputStream);
        vVar.b();
        return new q3.b(byteArrayOutputStream.toByteArray());
    }

    public a(Bitmap.CompressFormat compressFormat, int i10) {
        this.f22158a = compressFormat;
        this.f22159b = i10;
    }
}
