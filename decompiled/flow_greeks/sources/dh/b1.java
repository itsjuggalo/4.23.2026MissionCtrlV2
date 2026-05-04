package dh;

import bh.m;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b1 implements zg.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f8124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f8125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final cd.k f8126c;

    public b1(final String serialName, Object objectInstance) {
        kotlin.jvm.internal.t.f(serialName, "serialName");
        kotlin.jvm.internal.t.f(objectInstance, "objectInstance");
        this.f8124a = objectInstance;
        this.f8125b = dd.r.k();
        this.f8126c = cd.l.a(cd.n.f3864b, new Function0() { // from class: dh.z0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return b1.c(serialName, this);
            }
        });
    }

    public static final bh.e c(String str, final b1 b1Var) {
        return bh.k.d(str, m.d.f3405a, new bh.e[0], new pd.k() { // from class: dh.a1
            @Override // pd.k
            public final Object invoke(Object obj) {
                return b1.d(this.f8120a, (bh.a) obj);
            }
        });
    }

    public static final cd.h0 d(b1 b1Var, bh.a buildSerialDescriptor) {
        kotlin.jvm.internal.t.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
        buildSerialDescriptor.h(b1Var.f8125b);
        return cd.h0.f3852a;
    }

    @Override // zg.a
    public Object deserialize(ch.e decoder) {
        int iW;
        kotlin.jvm.internal.t.f(decoder, "decoder");
        bh.e descriptor = getDescriptor();
        ch.c cVarB = decoder.b(descriptor);
        if (cVarB.z() || (iW = cVarB.w(getDescriptor())) == -1) {
            cd.h0 h0Var = cd.h0.f3852a;
            cVarB.c(descriptor);
            return this.f8124a;
        }
        throw new zg.j("Unexpected index " + iW);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return (bh.e) this.f8126c.getValue();
    }

    @Override // zg.k
    public void serialize(ch.f encoder, Object value) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        kotlin.jvm.internal.t.f(value, "value");
        encoder.b(getDescriptor()).c(getDescriptor());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b1(String serialName, Object objectInstance, Annotation[] classAnnotations) {
        this(serialName, objectInstance);
        kotlin.jvm.internal.t.f(serialName, "serialName");
        kotlin.jvm.internal.t.f(objectInstance, "objectInstance");
        kotlin.jvm.internal.t.f(classAnnotations, "classAnnotations");
        this.f8125b = dd.l.d(classAnnotations);
    }
}
