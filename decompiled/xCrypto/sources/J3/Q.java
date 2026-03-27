package J3;

import I3.c;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.AbstractC1585j;
import o3.AbstractC1681l;
import o3.C1674e;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Q extends AbstractC0324a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F3.b f888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final F3.b f889b;

    public /* synthetic */ Q(F3.b bVar, F3.b bVar2, AbstractC1585j abstractC1585j) {
        this(bVar, bVar2);
    }

    @Override // F3.b, F3.h, F3.a
    public abstract H3.e getDescriptor();

    public final F3.b m() {
        return this.f888a;
    }

    public final F3.b n() {
        return this.f889b;
    }

    @Override // J3.AbstractC0324a
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final void g(I3.c decoder, Map builder, int i4, int i5) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        kotlin.jvm.internal.r.f(builder, "builder");
        if (i5 < 0) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL");
        }
        C1674e c1674eK = AbstractC1681l.k(AbstractC1681l.l(0, i5 * 2), 2);
        int iK = c1674eK.k();
        int iL = c1674eK.l();
        int iM = c1674eK.m();
        if ((iM <= 0 || iK > iL) && (iM >= 0 || iL > iK)) {
            return;
        }
        while (true) {
            h(decoder, i4 + iK, builder, false);
            if (iK == iL) {
                return;
            } else {
                iK += iM;
            }
        }
    }

    @Override // J3.AbstractC0324a
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public final void h(I3.c decoder, int i4, Map builder, boolean z4) {
        int i5;
        kotlin.jvm.internal.r.f(decoder, "decoder");
        kotlin.jvm.internal.r.f(builder, "builder");
        Object objC = c.a.c(decoder, getDescriptor(), i4, this.f888a, null, 8, null);
        if (z4) {
            i5 = decoder.i(getDescriptor());
            if (i5 != i4 + 1) {
                throw new IllegalArgumentException(("Value must follow key in a map, index for key: " + i4 + ", returned index for value: " + i5).toString());
            }
        } else {
            i5 = i4 + 1;
        }
        int i6 = i5;
        builder.put(objC, (!builder.containsKey(objC) || (this.f889b.getDescriptor().e() instanceof H3.d)) ? c.a.c(decoder, getDescriptor(), i6, this.f889b, null, 8, null) : decoder.m(getDescriptor(), i6, this.f889b, X2.L.f(builder, objC)));
    }

    @Override // F3.h
    public void serialize(I3.f encoder, Object obj) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        int iE = e(obj);
        H3.e descriptor = getDescriptor();
        I3.d dVarV = encoder.v(descriptor, iE);
        Iterator itD = d(obj);
        int i4 = 0;
        while (itD.hasNext()) {
            Map.Entry entry = (Map.Entry) itD.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            int i5 = i4 + 1;
            dVarV.u(getDescriptor(), i4, m(), key);
            i4 += 2;
            dVarV.u(getDescriptor(), i5, n(), value);
        }
        dVarV.c(descriptor);
    }

    public Q(F3.b bVar, F3.b bVar2) {
        super(null);
        this.f888a = bVar;
        this.f889b = bVar2;
    }
}
