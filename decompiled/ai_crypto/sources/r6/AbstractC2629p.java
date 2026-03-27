package r6;

import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2148j;
import q6.c;

/* JADX INFO: renamed from: r6.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2629p extends AbstractC2610a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n6.b f22911a;

    public /* synthetic */ AbstractC2629p(n6.b bVar, AbstractC2148j abstractC2148j) {
        this(bVar);
    }

    @Override // r6.AbstractC2610a
    public final void g(q6.c decoder, Object obj, int i7, int i8) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        if (i8 < 0) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL");
        }
        for (int i9 = 0; i9 < i8; i9++) {
            h(decoder, i7 + i9, obj, false);
        }
    }

    @Override // n6.b, n6.h, n6.a
    public abstract p6.e getDescriptor();

    @Override // r6.AbstractC2610a
    public void h(q6.c decoder, int i7, Object obj, boolean z7) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        n(obj, i7, c.a.c(decoder, getDescriptor(), i7, this.f22911a, null, 8, null));
    }

    public abstract void n(Object obj, int i7, Object obj2);

    @Override // n6.h
    public void serialize(q6.f encoder, Object obj) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        int iE = e(obj);
        p6.e descriptor = getDescriptor();
        q6.d dVarV = encoder.v(descriptor, iE);
        Iterator itD = d(obj);
        for (int i7 = 0; i7 < iE; i7++) {
            dVarV.x(getDescriptor(), i7, this.f22911a, itD.next());
        }
        dVarV.b(descriptor);
    }

    public AbstractC2629p(n6.b bVar) {
        super(null);
        this.f22911a = bVar;
    }
}
