package d1;

import android.graphics.ImageDecoder;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class j implements U0.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1617f f16783a = new C1617f();

    @Override // U0.j
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public W0.v a(ByteBuffer byteBuffer, int i8, int i9, U0.h hVar) {
        return this.f16783a.c(ImageDecoder.createSource(byteBuffer), i8, i9, hVar);
    }

    @Override // U0.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(ByteBuffer byteBuffer, U0.h hVar) {
        return true;
    }
}
