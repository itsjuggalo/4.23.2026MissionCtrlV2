package o7;

import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import n7.c;

/* JADX INFO: renamed from: o7.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2523p extends AbstractC2493a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k7.b f22196a;

    public AbstractC2523p(k7.b bVar) {
        super(null);
        this.f22196a = bVar;
    }

    @Override // o7.AbstractC2493a
    public final void g(n7.c decoder, Object obj, int i8, int i9) {
        AbstractC2304t.f(decoder, "decoder");
        if (i9 < 0) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL".toString());
        }
        for (int i10 = 0; i10 < i9; i10++) {
            h(decoder, i8 + i10, obj, false);
        }
    }

    @Override // k7.b, k7.k, k7.a
    public abstract m7.e getDescriptor();

    @Override // o7.AbstractC2493a
    public void h(n7.c decoder, int i8, Object obj, boolean z7) {
        AbstractC2304t.f(decoder, "decoder");
        n(obj, i8, c.a.c(decoder, getDescriptor(), i8, this.f22196a, null, 8, null));
    }

    public abstract void n(Object obj, int i8, Object obj2);

    @Override // k7.k
    public void serialize(n7.f encoder, Object obj) {
        AbstractC2304t.f(encoder, "encoder");
        int iE = e(obj);
        m7.e descriptor = getDescriptor();
        n7.d dVarZ = encoder.z(descriptor, iE);
        Iterator itD = d(obj);
        for (int i8 = 0; i8 < iE; i8++) {
            dVarZ.B(getDescriptor(), i8, this.f22196a, itD.next());
        }
        dVarZ.d(descriptor);
    }

    public /* synthetic */ AbstractC2523p(k7.b bVar, AbstractC2296k abstractC2296k) {
        this(bVar);
    }
}
