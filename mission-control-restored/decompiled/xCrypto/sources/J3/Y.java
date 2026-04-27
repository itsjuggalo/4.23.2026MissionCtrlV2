package J3;

import H3.j;
import X2.AbstractC0763j;
import X2.AbstractC0769p;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class Y implements F3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final W2.j f901c;

    public static final class a extends kotlin.jvm.internal.s implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Y f903b;

        /* JADX INFO: renamed from: J3.Y$a$a, reason: collision with other inner class name */
        public static final class C0027a extends kotlin.jvm.internal.s implements i3.k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Y f904a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0027a(Y y4) {
                super(1);
                this.f904a = y4;
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((H3.a) obj);
                return W2.E.f5463a;
            }

            public final void invoke(H3.a buildSerialDescriptor) {
                kotlin.jvm.internal.r.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
                buildSerialDescriptor.h(this.f904a.f900b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Y y4) {
            super(0);
            this.f902a = str;
            this.f903b = y4;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final H3.e invoke() {
            return H3.h.c(this.f902a, j.d.f769a, new H3.e[0], new C0027a(this.f903b));
        }
    }

    public Y(String serialName, Object objectInstance) {
        kotlin.jvm.internal.r.f(serialName, "serialName");
        kotlin.jvm.internal.r.f(objectInstance, "objectInstance");
        this.f899a = objectInstance;
        this.f900b = AbstractC0769p.g();
        this.f901c = W2.k.a(W2.l.f5481b, new a(serialName, this));
    }

    @Override // F3.a
    public Object deserialize(I3.e decoder) {
        int i4;
        kotlin.jvm.internal.r.f(decoder, "decoder");
        H3.e descriptor = getDescriptor();
        I3.c cVarD = decoder.d(descriptor);
        if (cVarD.w() || (i4 = cVarD.i(getDescriptor())) == -1) {
            W2.E e4 = W2.E.f5463a;
            cVarD.c(descriptor);
            return this.f899a;
        }
        throw new F3.g("Unexpected index " + i4);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return (H3.e) this.f901c.getValue();
    }

    @Override // F3.h
    public void serialize(I3.f encoder, Object value) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        kotlin.jvm.internal.r.f(value, "value");
        encoder.d(getDescriptor()).c(getDescriptor());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Y(String serialName, Object objectInstance, Annotation[] classAnnotations) {
        this(serialName, objectInstance);
        kotlin.jvm.internal.r.f(serialName, "serialName");
        kotlin.jvm.internal.r.f(objectInstance, "objectInstance");
        kotlin.jvm.internal.r.f(classAnnotations, "classAnnotations");
        this.f900b = AbstractC0763j.c(classAnnotations);
    }
}
