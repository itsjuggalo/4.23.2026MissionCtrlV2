package dh;

import ch.c;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zg.b f8202a;

    public /* synthetic */ p(zg.b bVar, kotlin.jvm.internal.k kVar) {
        this(bVar);
    }

    @Override // dh.a
    public final void g(ch.c decoder, Object obj, int i10, int i11) {
        kotlin.jvm.internal.t.f(decoder, "decoder");
        if (i11 < 0) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL");
        }
        for (int i12 = 0; i12 < i11; i12++) {
            h(decoder, i10 + i12, obj, false);
        }
    }

    @Override // zg.b, zg.k, zg.a
    public abstract bh.e getDescriptor();

    @Override // dh.a
    public void h(ch.c decoder, int i10, Object obj, boolean z10) {
        kotlin.jvm.internal.t.f(decoder, "decoder");
        n(obj, i10, c.a.c(decoder, getDescriptor(), i10, this.f8202a, null, 8, null));
    }

    public abstract void n(Object obj, int i10, Object obj2);

    @Override // zg.k
    public void serialize(ch.f encoder, Object obj) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        int iE = e(obj);
        bh.e descriptor = getDescriptor();
        ch.d dVarZ = encoder.z(descriptor, iE);
        Iterator itD = d(obj);
        for (int i10 = 0; i10 < iE; i10++) {
            dVarZ.n(getDescriptor(), i10, this.f8202a, itD.next());
        }
        dVarZ.c(descriptor);
    }

    public p(zg.b bVar) {
        super(null);
        this.f8202a = bVar;
    }
}
