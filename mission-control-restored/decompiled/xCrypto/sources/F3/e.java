package F3;

import H3.c;
import H3.i;
import J3.AbstractC0326b;
import W2.E;
import W2.l;
import X2.AbstractC0763j;
import X2.AbstractC0765l;
import X2.AbstractC0769p;
import X2.C;
import X2.K;
import X2.L;
import i3.k;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.J;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import p3.InterfaceC1716c;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends AbstractC0326b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1716c f438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final W2.j f440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f442e;

    public static final class a extends s implements Function0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f443a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f444b;

        /* JADX INFO: renamed from: F3.e$a$a, reason: collision with other inner class name */
        public static final class C0020a extends s implements k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f445a;

            /* JADX INFO: renamed from: F3.e$a$a$a, reason: collision with other inner class name */
            public static final class C0021a extends s implements k {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ e f446a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0021a(e eVar) {
                    super(1);
                    this.f446a = eVar;
                }

                @Override // i3.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((H3.a) obj);
                    return E.f5463a;
                }

                public final void invoke(H3.a buildSerialDescriptor) {
                    r.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
                    for (Map.Entry entry : this.f446a.f442e.entrySet()) {
                        H3.a.b(buildSerialDescriptor, (String) entry.getKey(), ((F3.b) entry.getValue()).getDescriptor(), null, false, 12, null);
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0020a(e eVar) {
                super(1);
                this.f445a = eVar;
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((H3.a) obj);
                return E.f5463a;
            }

            public final void invoke(H3.a buildSerialDescriptor) {
                r.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
                H3.a.b(buildSerialDescriptor, "type", G3.a.D(J.f13414a).getDescriptor(), null, false, 12, null);
                H3.a.b(buildSerialDescriptor, "value", H3.h.c("kotlinx.serialization.Sealed<" + this.f445a.e().b() + '>', i.a.f764a, new H3.e[0], new C0021a(this.f445a)), null, false, 12, null);
                buildSerialDescriptor.h(this.f445a.f439b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, e eVar) {
            super(0);
            this.f443a = str;
            this.f444b = eVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final H3.e invoke() {
            return H3.h.c(this.f443a, c.a.f733a, new H3.e[0], new C0020a(this.f444b));
        }
    }

    public static final class b implements C {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f447a;

        public b(Iterable iterable) {
            this.f447a = iterable;
        }

        @Override // X2.C
        public Object a(Object obj) {
            return ((F3.b) ((Map.Entry) obj).getValue()).getDescriptor().a();
        }

        @Override // X2.C
        public Iterator b() {
            return this.f447a.iterator();
        }
    }

    public e(String serialName, InterfaceC1716c baseClass, InterfaceC1716c[] subclasses, F3.b[] subclassSerializers) {
        r.f(serialName, "serialName");
        r.f(baseClass, "baseClass");
        r.f(subclasses, "subclasses");
        r.f(subclassSerializers, "subclassSerializers");
        this.f438a = baseClass;
        this.f439b = AbstractC0769p.g();
        this.f440c = W2.k.a(l.f5481b, new a(serialName, this));
        if (subclasses.length != subclassSerializers.length) {
            throw new IllegalArgumentException("All subclasses of sealed class " + e().b() + " should be marked @Serializable");
        }
        Map mapO = L.o(AbstractC0765l.v0(subclasses, subclassSerializers));
        this.f441d = mapO;
        b bVar = new b(mapO.entrySet());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator itB = bVar.b();
        while (itB.hasNext()) {
            Object next = itB.next();
            Object objA = bVar.a(next);
            Object obj = linkedHashMap.get(objA);
            if (obj == null) {
                linkedHashMap.containsKey(objA);
            }
            Map.Entry entry = (Map.Entry) next;
            Map.Entry entry2 = (Map.Entry) obj;
            String str = (String) objA;
            if (entry2 != null) {
                throw new IllegalStateException(("Multiple sealed subclasses of '" + e() + "' have the same serial name '" + str + "': '" + entry2.getKey() + "', '" + entry.getKey() + '\'').toString());
            }
            linkedHashMap.put(objA, entry);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(K.b(linkedHashMap.size()));
        for (Map.Entry entry3 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry3.getKey(), (F3.b) ((Map.Entry) entry3.getValue()).getValue());
        }
        this.f442e = linkedHashMap2;
    }

    @Override // J3.AbstractC0326b
    public F3.a c(I3.c decoder, String str) {
        r.f(decoder, "decoder");
        F3.b bVar = (F3.b) this.f442e.get(str);
        return bVar != null ? bVar : super.c(decoder, str);
    }

    @Override // J3.AbstractC0326b
    public h d(I3.f encoder, Object value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        h hVarD = (F3.b) this.f441d.get(G.b(value.getClass()));
        if (hVarD == null) {
            hVarD = super.d(encoder, value);
        }
        if (hVarD != null) {
            return hVarD;
        }
        return null;
    }

    @Override // J3.AbstractC0326b
    public InterfaceC1716c e() {
        return this.f438a;
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return (H3.e) this.f440c.getValue();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(String serialName, InterfaceC1716c baseClass, InterfaceC1716c[] subclasses, F3.b[] subclassSerializers, Annotation[] classAnnotations) {
        this(serialName, baseClass, subclasses, subclassSerializers);
        r.f(serialName, "serialName");
        r.f(baseClass, "baseClass");
        r.f(subclasses, "subclasses");
        r.f(subclassSerializers, "subclassSerializers");
        r.f(classAnnotations, "classAnnotations");
        this.f439b = AbstractC0763j.c(classAnnotations);
    }
}
