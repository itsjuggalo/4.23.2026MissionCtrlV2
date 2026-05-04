package p3;

import android.graphics.ImageDecoder;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class y implements g3.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f18298a = new e();

    @Override // g3.j
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public i3.v a(InputStream inputStream, int i10, int i11, g3.h hVar) {
        return this.f18298a.c(ImageDecoder.createSource(c4.a.b(inputStream)), i10, i11, hVar);
    }

    @Override // g3.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(InputStream inputStream, g3.h hVar) {
        return true;
    }
}
