package d1;

import android.graphics.ImageDecoder;
import java.io.InputStream;
import q1.AbstractC2618a;

/* JADX INFO: loaded from: classes.dex */
public final class x implements U0.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1617f f16835a = new C1617f();

    @Override // U0.j
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public W0.v a(InputStream inputStream, int i8, int i9, U0.h hVar) {
        return this.f16835a.c(ImageDecoder.createSource(AbstractC2618a.b(inputStream)), i8, i9, hVar);
    }

    @Override // U0.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(InputStream inputStream, U0.h hVar) {
        return true;
    }
}
