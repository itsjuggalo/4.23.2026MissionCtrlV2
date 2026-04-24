package o7;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;
import m7.m;
import o5.AbstractC2484l;
import o5.C2470H;
import o5.EnumC2486n;
import o5.InterfaceC2483k;
import p5.AbstractC2590l;
import p5.AbstractC2595q;

/* JADX INFO: renamed from: o7.c0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2498c0 implements k7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f22158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f22159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2483k f22160c;

    public C2498c0(final String serialName, Object objectInstance) {
        AbstractC2304t.f(serialName, "serialName");
        AbstractC2304t.f(objectInstance, "objectInstance");
        this.f22158a = objectInstance;
        this.f22159b = AbstractC2595q.i();
        this.f22160c = AbstractC2484l.b(EnumC2486n.f21975b, new Function0() { // from class: o7.a0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return C2498c0.c(serialName, this);
            }
        });
    }

    public static final m7.e c(String str, final C2498c0 c2498c0) {
        return m7.k.d(str, m.d.f21534a, new m7.e[0], new B5.k() { // from class: o7.b0
            @Override // B5.k
            public final Object invoke(Object obj) {
                return C2498c0.d(this.f22157a, (m7.a) obj);
            }
        });
    }

    public static final C2470H d(C2498c0 c2498c0, m7.a buildSerialDescriptor) {
        AbstractC2304t.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
        buildSerialDescriptor.h(c2498c0.f22159b);
        return C2470H.f21956a;
    }

    @Override // k7.a
    public Object deserialize(n7.e decoder) {
        int iE;
        AbstractC2304t.f(decoder, "decoder");
        m7.e descriptor = getDescriptor();
        n7.c cVarC = decoder.c(descriptor);
        if (cVarC.w() || (iE = cVarC.E(getDescriptor())) == -1) {
            C2470H c2470h = C2470H.f21956a;
            cVarC.d(descriptor);
            return this.f22158a;
        }
        throw new k7.j("Unexpected index " + iE);
    }

    @Override // k7.b, k7.k, k7.a
    public m7.e getDescriptor() {
        return (m7.e) this.f22160c.getValue();
    }

    @Override // k7.k
    public void serialize(n7.f encoder, Object value) {
        AbstractC2304t.f(encoder, "encoder");
        AbstractC2304t.f(value, "value");
        encoder.c(getDescriptor()).d(getDescriptor());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C2498c0(String serialName, Object objectInstance, Annotation[] classAnnotations) {
        this(serialName, objectInstance);
        AbstractC2304t.f(serialName, "serialName");
        AbstractC2304t.f(objectInstance, "objectInstance");
        AbstractC2304t.f(classAnnotations, "classAnnotations");
        this.f22159b = AbstractC2590l.d(classAnnotations);
    }
}
