package zg;

import bh.c;
import bh.l;
import cd.h0;
import cd.n;
import dd.f0;
import dd.n0;
import dd.o0;
import dd.r;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s0;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends dh.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wd.d f26564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f26565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final cd.k f26566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f26567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map f26568e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements f0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f26569a;

        public a(Iterable iterable) {
            this.f26569a = iterable;
        }

        @Override // dd.f0
        public Object a(Object obj) {
            return ((b) ((Map.Entry) obj).getValue()).getDescriptor().i();
        }

        @Override // dd.f0
        public Iterator b() {
            return this.f26569a.iterator();
        }
    }

    public h(final String serialName, wd.d baseClass, wd.d[] subclasses, b[] subclassSerializers) {
        t.f(serialName, "serialName");
        t.f(baseClass, "baseClass");
        t.f(subclasses, "subclasses");
        t.f(subclassSerializers, "subclassSerializers");
        this.f26564a = baseClass;
        this.f26565b = r.k();
        this.f26566c = cd.l.a(n.f3864b, new Function0() { // from class: zg.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return h.i(serialName, this);
            }
        });
        if (subclasses.length != subclassSerializers.length) {
            throw new IllegalArgumentException("All subclasses of sealed class " + e().c() + " should be marked @Serializable");
        }
        Map mapT = o0.t(dd.n.P0(subclasses, subclassSerializers));
        this.f26567d = mapT;
        a aVar = new a(mapT.entrySet());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator itB = aVar.b();
        while (itB.hasNext()) {
            Object next = itB.next();
            Object objA = aVar.a(next);
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
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(n0.d(linkedHashMap.size()));
        for (Map.Entry entry3 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry3.getKey(), (b) ((Map.Entry) entry3.getValue()).getValue());
        }
        this.f26568e = linkedHashMap2;
    }

    public static final bh.e i(String str, final h hVar) {
        return bh.k.d(str, c.a.f3370a, new bh.e[0], new pd.k() { // from class: zg.f
            @Override // pd.k
            public final Object invoke(Object obj) {
                return h.j(this.f26562a, (bh.a) obj);
            }
        });
    }

    public static final h0 j(final h hVar, bh.a buildSerialDescriptor) {
        t.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
        bh.a.b(buildSerialDescriptor, "type", ah.a.D(s0.f14953a).getDescriptor(), null, false, 12, null);
        bh.a.b(buildSerialDescriptor, "value", bh.k.d("kotlinx.serialization.Sealed<" + hVar.e().c() + '>', l.a.f3400a, new bh.e[0], new pd.k() { // from class: zg.g
            @Override // pd.k
            public final Object invoke(Object obj) {
                return h.k(this.f26563a, (bh.a) obj);
            }
        }), null, false, 12, null);
        buildSerialDescriptor.h(hVar.f26565b);
        return h0.f3852a;
    }

    public static final h0 k(h hVar, bh.a buildSerialDescriptor) {
        t.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
        for (Map.Entry entry : hVar.f26568e.entrySet()) {
            bh.a.b(buildSerialDescriptor, (String) entry.getKey(), ((b) entry.getValue()).getDescriptor(), null, false, 12, null);
        }
        return h0.f3852a;
    }

    @Override // dh.b
    public zg.a c(ch.c decoder, String str) {
        t.f(decoder, "decoder");
        b bVar = (b) this.f26568e.get(str);
        return bVar != null ? bVar : super.c(decoder, str);
    }

    @Override // dh.b
    public k d(ch.f encoder, Object value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        k kVarD = (b) this.f26567d.get(kotlin.jvm.internal.n0.b(value.getClass()));
        if (kVarD == null) {
            kVarD = super.d(encoder, value);
        }
        if (kVarD != null) {
            return kVarD;
        }
        return null;
    }

    @Override // dh.b
    public wd.d e() {
        return this.f26564a;
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return (bh.e) this.f26566c.getValue();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(String serialName, wd.d baseClass, wd.d[] subclasses, b[] subclassSerializers, Annotation[] classAnnotations) {
        this(serialName, baseClass, subclasses, subclassSerializers);
        t.f(serialName, "serialName");
        t.f(baseClass, "baseClass");
        t.f(subclasses, "subclasses");
        t.f(subclassSerializers, "subclassSerializers");
        t.f(classAnnotations, "classAnnotations");
        this.f26565b = dd.l.d(classAnnotations);
    }
}
