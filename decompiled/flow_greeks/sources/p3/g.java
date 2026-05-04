package p3;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g implements g3.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f18231a;

    public g(p pVar) {
        this.f18231a = pVar;
    }

    @Override // g3.j
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public i3.v a(ByteBuffer byteBuffer, int i10, int i11, g3.h hVar) {
        return this.f18231a.f(byteBuffer, i10, i11, hVar);
    }

    @Override // g3.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(ByteBuffer byteBuffer, g3.h hVar) {
        return this.f18231a.q(byteBuffer);
    }
}
