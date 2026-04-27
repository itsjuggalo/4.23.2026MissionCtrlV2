package o7;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import n7.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class T extends AbstractC2493a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k7.b f22144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k7.b f22145b;

    public T(k7.b bVar, k7.b bVar2) {
        super(null);
        this.f22144a = bVar;
        this.f22145b = bVar2;
    }

    @Override // k7.b, k7.k, k7.a
    public abstract m7.e getDescriptor();

    public final k7.b m() {
        return this.f22144a;
    }

    public final k7.b n() {
        return this.f22145b;
    }

    @Override // o7.AbstractC2493a
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final void g(n7.c decoder, Map builder, int i8, int i9) {
        AbstractC2304t.f(decoder, "decoder");
        AbstractC2304t.f(builder, "builder");
        if (i9 < 0) {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL".toString());
        }
        H5.b bVarK = H5.i.k(H5.i.l(0, i9 * 2), 2);
        int iE = bVarK.e();
        int iF = bVarK.f();
        int iH = bVarK.h();
        if ((iH <= 0 || iE > iF) && (iH >= 0 || iF > iE)) {
            return;
        }
        while (true) {
            h(decoder, i8 + iE, builder, false);
            if (iE == iF) {
                return;
            } else {
                iE += iH;
            }
        }
    }

    @Override // o7.AbstractC2493a
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public final void h(n7.c decoder, int i8, Map builder, boolean z7) {
        int iE;
        AbstractC2304t.f(decoder, "decoder");
        AbstractC2304t.f(builder, "builder");
        Object objC = c.a.c(decoder, getDescriptor(), i8, this.f22144a, null, 8, null);
        if (z7) {
            iE = decoder.E(getDescriptor());
            if (iE != i8 + 1) {
                throw new IllegalArgumentException(("Value must follow key in a map, index for key: " + i8 + ", returned index for value: " + iE).toString());
            }
        } else {
            iE = i8 + 1;
        }
        int i9 = iE;
        builder.put(objC, (!builder.containsKey(objC) || (this.f22145b.getDescriptor().i() instanceof m7.d)) ? c.a.c(decoder, getDescriptor(), i9, this.f22145b, null, 8, null) : decoder.u(getDescriptor(), i9, this.f22145b, p5.M.i(builder, objC)));
    }

    @Override // k7.k
    public void serialize(n7.f encoder, Object obj) {
        AbstractC2304t.f(encoder, "encoder");
        int iE = e(obj);
        m7.e descriptor = getDescriptor();
        n7.d dVarZ = encoder.z(descriptor, iE);
        Iterator itD = d(obj);
        int i8 = 0;
        while (itD.hasNext()) {
            Map.Entry entry = (Map.Entry) itD.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            int i9 = i8 + 1;
            dVarZ.B(getDescriptor(), i8, m(), key);
            i8 += 2;
            dVarZ.B(getDescriptor(), i9, n(), value);
        }
        dVarZ.d(descriptor);
    }

    public /* synthetic */ T(k7.b bVar, k7.b bVar2, AbstractC2296k abstractC2296k) {
        this(bVar, bVar2);
    }
}
