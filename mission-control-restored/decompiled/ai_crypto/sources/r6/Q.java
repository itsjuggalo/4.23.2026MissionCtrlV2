package r6;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2148j;
import q6.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Q extends AbstractC2610a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n6.b f22845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n6.b f22846b;

    public /* synthetic */ Q(n6.b bVar, n6.b bVar2, AbstractC2148j abstractC2148j) {
        this(bVar, bVar2);
    }

    @Override // n6.b, n6.h, n6.a
    public abstract p6.e getDescriptor();

    public final n6.b m() {
        return this.f22845a;
    }

    public final n6.b n() {
        return this.f22846b;
    }

    @Override // r6.AbstractC2610a
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final void g(q6.c decoder, Map builder, int i7, int i8) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        kotlin.jvm.internal.r.f(builder, "builder");
        if (i8 < 0) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL");
        }
        W5.e eVarK = W5.l.k(W5.l.l(0, i8 * 2), 2);
        int iG = eVarK.g();
        int iH = eVarK.h();
        int iJ = eVarK.j();
        if ((iJ <= 0 || iG > iH) && (iJ >= 0 || iH > iG)) {
            return;
        }
        while (true) {
            h(decoder, i7 + iG, builder, false);
            if (iG == iH) {
                return;
            } else {
                iG += iJ;
            }
        }
    }

    @Override // r6.AbstractC2610a
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public final void h(q6.c decoder, int i7, Map builder, boolean z7) {
        int iQ;
        kotlin.jvm.internal.r.f(decoder, "decoder");
        kotlin.jvm.internal.r.f(builder, "builder");
        Object objC = c.a.c(decoder, getDescriptor(), i7, this.f22845a, null, 8, null);
        if (z7) {
            iQ = decoder.q(getDescriptor());
            if (iQ != i7 + 1) {
                throw new IllegalArgumentException(("Value must follow key in a map, index for key: " + i7 + ", returned index for value: " + iQ).toString());
            }
        } else {
            iQ = i7 + 1;
        }
        int i8 = iQ;
        builder.put(objC, (!builder.containsKey(objC) || (this.f22846b.getDescriptor().e() instanceof p6.d)) ? c.a.c(decoder, getDescriptor(), i8, this.f22846b, null, 8, null) : decoder.A(getDescriptor(), i8, this.f22846b, F5.J.f(builder, objC)));
    }

    @Override // n6.h
    public void serialize(q6.f encoder, Object obj) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        int iE = e(obj);
        p6.e descriptor = getDescriptor();
        q6.d dVarV = encoder.v(descriptor, iE);
        Iterator itD = d(obj);
        int i7 = 0;
        while (itD.hasNext()) {
            Map.Entry entry = (Map.Entry) itD.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            int i8 = i7 + 1;
            dVarV.x(getDescriptor(), i7, m(), key);
            i7 += 2;
            dVarV.x(getDescriptor(), i8, n(), value);
        }
        dVarV.b(descriptor);
    }

    public Q(n6.b bVar, n6.b bVar2) {
        super(null);
        this.f22845a = bVar;
        this.f22846b = bVar2;
    }
}
