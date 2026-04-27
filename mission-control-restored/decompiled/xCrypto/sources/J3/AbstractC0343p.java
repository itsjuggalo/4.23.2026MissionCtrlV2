package J3;

import I3.c;
import java.util.Iterator;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: renamed from: J3.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0343p extends AbstractC0324a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F3.b f954a;

    public /* synthetic */ AbstractC0343p(F3.b bVar, AbstractC1585j abstractC1585j) {
        this(bVar);
    }

    @Override // J3.AbstractC0324a
    public final void g(I3.c decoder, Object obj, int i4, int i5) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        if (i5 < 0) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL");
        }
        for (int i6 = 0; i6 < i5; i6++) {
            h(decoder, i4 + i6, obj, false);
        }
    }

    @Override // F3.b, F3.h, F3.a
    public abstract H3.e getDescriptor();

    @Override // J3.AbstractC0324a
    public void h(I3.c decoder, int i4, Object obj, boolean z4) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        n(obj, i4, c.a.c(decoder, getDescriptor(), i4, this.f954a, null, 8, null));
    }

    public abstract void n(Object obj, int i4, Object obj2);

    @Override // F3.h
    public void serialize(I3.f encoder, Object obj) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        int iE = e(obj);
        H3.e descriptor = getDescriptor();
        I3.d dVarV = encoder.v(descriptor, iE);
        Iterator itD = d(obj);
        for (int i4 = 0; i4 < iE; i4++) {
            dVarV.u(getDescriptor(), i4, this.f954a, itD.next());
        }
        dVarV.c(descriptor);
    }

    public AbstractC0343p(F3.b bVar) {
        super(null);
        this.f954a = bVar;
    }
}
