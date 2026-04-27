package r6;

import F5.AbstractC0551i;
import F5.AbstractC0556n;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.functions.Function0;
import p6.j;

/* JADX INFO: loaded from: classes2.dex */
public final class Y implements n6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f22856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f22857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final E5.j f22858c;

    public static final class a extends kotlin.jvm.internal.s implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Y f22860b;

        /* JADX INFO: renamed from: r6.Y$a$a, reason: collision with other inner class name */
        public static final class C0353a extends kotlin.jvm.internal.s implements Q5.k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Y f22861a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0353a(Y y7) {
                super(1);
                this.f22861a = y7;
            }

            @Override // Q5.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((p6.a) obj);
                return E5.E.f1657a;
            }

            public final void invoke(p6.a buildSerialDescriptor) {
                kotlin.jvm.internal.r.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
                buildSerialDescriptor.h(this.f22861a.f22857b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Y y7) {
            super(0);
            this.f22859a = str;
            this.f22860b = y7;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final p6.e invoke() {
            return p6.h.c(this.f22859a, j.d.f22097a, new p6.e[0], new C0353a(this.f22860b));
        }
    }

    public Y(String serialName, Object objectInstance) {
        kotlin.jvm.internal.r.f(serialName, "serialName");
        kotlin.jvm.internal.r.f(objectInstance, "objectInstance");
        this.f22856a = objectInstance;
        this.f22857b = AbstractC0556n.g();
        this.f22858c = E5.k.a(E5.l.f1675b, new a(serialName, this));
    }

    @Override // n6.a
    public Object deserialize(q6.e decoder) {
        int iQ;
        kotlin.jvm.internal.r.f(decoder, "decoder");
        p6.e descriptor = getDescriptor();
        q6.c cVarC = decoder.c(descriptor);
        if (cVarC.w() || (iQ = cVarC.q(getDescriptor())) == -1) {
            E5.E e7 = E5.E.f1657a;
            cVarC.b(descriptor);
            return this.f22856a;
        }
        throw new n6.g("Unexpected index " + iQ);
    }

    @Override // n6.b, n6.h, n6.a
    public p6.e getDescriptor() {
        return (p6.e) this.f22858c.getValue();
    }

    @Override // n6.h
    public void serialize(q6.f encoder, Object value) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        kotlin.jvm.internal.r.f(value, "value");
        encoder.c(getDescriptor()).b(getDescriptor());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Y(String serialName, Object objectInstance, Annotation[] classAnnotations) {
        this(serialName, objectInstance);
        kotlin.jvm.internal.r.f(serialName, "serialName");
        kotlin.jvm.internal.r.f(objectInstance, "objectInstance");
        kotlin.jvm.internal.r.f(classAnnotations, "classAnnotations");
        this.f22857b = AbstractC0551i.c(classAnnotations);
    }
}
