package d1;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class h implements U0.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f16782a;

    public h(r rVar) {
        this.f16782a = rVar;
    }

    @Override // U0.j
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public W0.v a(ByteBuffer byteBuffer, int i8, int i9, U0.h hVar) {
        return this.f16782a.g(byteBuffer, i8, i9, hVar);
    }

    @Override // U0.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(ByteBuffer byteBuffer, U0.h hVar) {
        return this.f16782a.q(byteBuffer);
    }
}
