package dh;

import ch.c;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s0 extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zg.b f8219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zg.b f8220b;

    public /* synthetic */ s0(zg.b bVar, zg.b bVar2, kotlin.jvm.internal.k kVar) {
        this(bVar, bVar2);
    }

    @Override // zg.b, zg.k, zg.a
    public abstract bh.e getDescriptor();

    public final zg.b m() {
        return this.f8219a;
    }

    public final zg.b n() {
        return this.f8220b;
    }

    @Override // dh.a
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final void g(ch.c decoder, Map builder, int i10, int i11) {
        kotlin.jvm.internal.t.f(decoder, "decoder");
        kotlin.jvm.internal.t.f(builder, "builder");
        if (i11 < 0) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL");
        }
        vd.e eVarK = vd.l.k(vd.l.l(0, i11 * 2), 2);
        int iE = eVarK.e();
        int iF = eVarK.f();
        int iG = eVarK.g();
        if ((iG <= 0 || iE > iF) && (iG >= 0 || iF > iE)) {
            return;
        }
        while (true) {
            h(decoder, i10 + iE, builder, false);
            if (iE == iF) {
                return;
            } else {
                iE += iG;
            }
        }
    }

    @Override // dh.a
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public final void h(ch.c decoder, int i10, Map builder, boolean z10) {
        int iW;
        kotlin.jvm.internal.t.f(decoder, "decoder");
        kotlin.jvm.internal.t.f(builder, "builder");
        Object objC = c.a.c(decoder, getDescriptor(), i10, this.f8219a, null, 8, null);
        if (z10) {
            iW = decoder.w(getDescriptor());
            if (iW != i10 + 1) {
                throw new IllegalArgumentException(("Value must follow key in a map, index for key: " + i10 + ", returned index for value: " + iW).toString());
            }
        } else {
            iW = i10 + 1;
        }
        int i11 = iW;
        builder.put(objC, (!builder.containsKey(objC) || (this.f8220b.getDescriptor().h() instanceof bh.d)) ? c.a.c(decoder, getDescriptor(), i11, this.f8220b, null, 8, null) : decoder.h(getDescriptor(), i11, this.f8220b, dd.o0.i(builder, objC)));
    }

    @Override // zg.k
    public void serialize(ch.f encoder, Object obj) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        int iE = e(obj);
        bh.e descriptor = getDescriptor();
        ch.d dVarZ = encoder.z(descriptor, iE);
        Iterator itD = d(obj);
        int i10 = 0;
        while (itD.hasNext()) {
            Map.Entry entry = (Map.Entry) itD.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            int i11 = i10 + 1;
            dVarZ.n(getDescriptor(), i10, m(), key);
            i10 += 2;
            dVarZ.n(getDescriptor(), i11, n(), value);
        }
        dVarZ.c(descriptor);
    }

    public s0(zg.b bVar, zg.b bVar2) {
        super(null);
        this.f8219a = bVar;
        this.f8220b = bVar2;
    }
}
