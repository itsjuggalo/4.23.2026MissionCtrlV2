package xe;

import fe.g1;
import fe.m0;
import fe.s1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import xe.x;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final fe.h0 f24844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m0 f24845e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final tf.g f24846f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public df.e f24847g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public abstract class a implements x.a {

        /* JADX INFO: renamed from: xe.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0455a implements x.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ x.a f24849a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ x.a f24850b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ a f24851c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ef.f f24852d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ ArrayList f24853e;

            public C0455a(x.a aVar, a aVar2, ef.f fVar, ArrayList arrayList) {
                this.f24850b = aVar;
                this.f24851c = aVar2;
                this.f24852d = fVar;
                this.f24853e = arrayList;
                this.f24849a = aVar;
            }

            @Override // xe.x.a
            public void a() {
                this.f24850b.a();
                this.f24851c.h(this.f24852d, new lf.a((ge.c) dd.a0.v0(this.f24853e)));
            }

            @Override // xe.x.a
            public x.a b(ef.f fVar, ef.b classId) {
                kotlin.jvm.internal.t.f(classId, "classId");
                return this.f24849a.b(fVar, classId);
            }

            @Override // xe.x.a
            public void c(ef.f fVar, ef.b enumClassId, ef.f enumEntryName) {
                kotlin.jvm.internal.t.f(enumClassId, "enumClassId");
                kotlin.jvm.internal.t.f(enumEntryName, "enumEntryName");
                this.f24849a.c(fVar, enumClassId, enumEntryName);
            }

            @Override // xe.x.a
            public void d(ef.f fVar, lf.f value) {
                kotlin.jvm.internal.t.f(value, "value");
                this.f24849a.d(fVar, value);
            }

            @Override // xe.x.a
            public x.b e(ef.f fVar) {
                return this.f24849a.e(fVar);
            }

            @Override // xe.x.a
            public void f(ef.f fVar, Object obj) {
                this.f24849a.f(fVar, obj);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class b implements x.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ArrayList f24854a = new ArrayList();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h f24855b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ef.f f24856c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ a f24857d;

            /* JADX INFO: renamed from: xe.h$a$b$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public static final class C0456a implements x.a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ x.a f24858a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ x.a f24859b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public final /* synthetic */ b f24860c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public final /* synthetic */ ArrayList f24861d;

                public C0456a(x.a aVar, b bVar, ArrayList arrayList) {
                    this.f24859b = aVar;
                    this.f24860c = bVar;
                    this.f24861d = arrayList;
                    this.f24858a = aVar;
                }

                @Override // xe.x.a
                public void a() {
                    this.f24859b.a();
                    this.f24860c.f24854a.add(new lf.a((ge.c) dd.a0.v0(this.f24861d)));
                }

                @Override // xe.x.a
                public x.a b(ef.f fVar, ef.b classId) {
                    kotlin.jvm.internal.t.f(classId, "classId");
                    return this.f24858a.b(fVar, classId);
                }

                @Override // xe.x.a
                public void c(ef.f fVar, ef.b enumClassId, ef.f enumEntryName) {
                    kotlin.jvm.internal.t.f(enumClassId, "enumClassId");
                    kotlin.jvm.internal.t.f(enumEntryName, "enumEntryName");
                    this.f24858a.c(fVar, enumClassId, enumEntryName);
                }

                @Override // xe.x.a
                public void d(ef.f fVar, lf.f value) {
                    kotlin.jvm.internal.t.f(value, "value");
                    this.f24858a.d(fVar, value);
                }

                @Override // xe.x.a
                public x.b e(ef.f fVar) {
                    return this.f24858a.e(fVar);
                }

                @Override // xe.x.a
                public void f(ef.f fVar, Object obj) {
                    this.f24858a.f(fVar, obj);
                }
            }

            public b(h hVar, ef.f fVar, a aVar) {
                this.f24855b = hVar;
                this.f24856c = fVar;
                this.f24857d = aVar;
            }

            @Override // xe.x.b
            public void a() {
                this.f24857d.g(this.f24856c, this.f24854a);
            }

            @Override // xe.x.b
            public x.a b(ef.b classId) {
                kotlin.jvm.internal.t.f(classId, "classId");
                ArrayList arrayList = new ArrayList();
                h hVar = this.f24855b;
                g1 NO_SOURCE = g1.f9483a;
                kotlin.jvm.internal.t.e(NO_SOURCE, "NO_SOURCE");
                x.a aVarX = hVar.x(classId, NO_SOURCE, arrayList);
                kotlin.jvm.internal.t.c(aVarX);
                return new C0456a(aVarX, this, arrayList);
            }

            @Override // xe.x.b
            public void c(Object obj) {
                this.f24854a.add(this.f24855b.O(this.f24856c, obj));
            }

            @Override // xe.x.b
            public void d(lf.f value) {
                kotlin.jvm.internal.t.f(value, "value");
                this.f24854a.add(new lf.s(value));
            }

            @Override // xe.x.b
            public void e(ef.b enumClassId, ef.f enumEntryName) {
                kotlin.jvm.internal.t.f(enumClassId, "enumClassId");
                kotlin.jvm.internal.t.f(enumEntryName, "enumEntryName");
                this.f24854a.add(new lf.k(enumClassId, enumEntryName));
            }
        }

        public a() {
        }

        @Override // xe.x.a
        public x.a b(ef.f fVar, ef.b classId) {
            kotlin.jvm.internal.t.f(classId, "classId");
            ArrayList arrayList = new ArrayList();
            h hVar = h.this;
            g1 NO_SOURCE = g1.f9483a;
            kotlin.jvm.internal.t.e(NO_SOURCE, "NO_SOURCE");
            x.a aVarX = hVar.x(classId, NO_SOURCE, arrayList);
            kotlin.jvm.internal.t.c(aVarX);
            return new C0455a(aVarX, this, fVar, arrayList);
        }

        @Override // xe.x.a
        public void c(ef.f fVar, ef.b enumClassId, ef.f enumEntryName) {
            kotlin.jvm.internal.t.f(enumClassId, "enumClassId");
            kotlin.jvm.internal.t.f(enumEntryName, "enumEntryName");
            h(fVar, new lf.k(enumClassId, enumEntryName));
        }

        @Override // xe.x.a
        public void d(ef.f fVar, lf.f value) {
            kotlin.jvm.internal.t.f(value, "value");
            h(fVar, new lf.s(value));
        }

        @Override // xe.x.a
        public x.b e(ef.f fVar) {
            return new b(h.this, fVar, this);
        }

        @Override // xe.x.a
        public void f(ef.f fVar, Object obj) {
            h(fVar, h.this.O(fVar, obj));
        }

        public abstract void g(ef.f fVar, ArrayList arrayList);

        public abstract void h(ef.f fVar, lf.g gVar);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap f24862b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ fe.e f24864d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ef.b f24865e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ List f24866f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ g1 f24867g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(fe.e eVar, ef.b bVar, List list, g1 g1Var) {
            super();
            this.f24864d = eVar;
            this.f24865e = bVar;
            this.f24866f = list;
            this.f24867g = g1Var;
            this.f24862b = new HashMap();
        }

        @Override // xe.x.a
        public void a() {
            if (h.this.F(this.f24865e, this.f24862b) || h.this.w(this.f24865e)) {
                return;
            }
            this.f24866f.add(new ge.d(this.f24864d.s(), this.f24862b, this.f24867g));
        }

        @Override // xe.h.a
        public void g(ef.f fVar, ArrayList elements) {
            kotlin.jvm.internal.t.f(elements, "elements");
            if (fVar == null) {
                return;
            }
            s1 s1VarB = pe.a.b(fVar, this.f24864d);
            if (s1VarB != null) {
                HashMap map = this.f24862b;
                lf.i iVar = lf.i.f15656a;
                List listC = hg.a.c(elements);
                r0 type = s1VarB.getType();
                kotlin.jvm.internal.t.e(type, "getType(...)");
                map.put(fVar, iVar.c(listC, type));
                return;
            }
            if (h.this.w(this.f24865e) && kotlin.jvm.internal.t.b(fVar.b(), "value")) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : elements) {
                    if (obj instanceof lf.a) {
                        arrayList.add(obj);
                    }
                }
                List list = this.f24866f;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    list.add((ge.c) ((lf.a) it.next()).b());
                }
            }
        }

        @Override // xe.h.a
        public void h(ef.f fVar, lf.g value) {
            kotlin.jvm.internal.t.f(value, "value");
            if (fVar != null) {
                this.f24862b.put(fVar, value);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(fe.h0 module, m0 notFoundClasses, wf.n storageManager, v kotlinClassFinder) {
        super(storageManager, kotlinClassFinder);
        kotlin.jvm.internal.t.f(module, "module");
        kotlin.jvm.internal.t.f(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.t.f(storageManager, "storageManager");
        kotlin.jvm.internal.t.f(kotlinClassFinder, "kotlinClassFinder");
        this.f24844d = module;
        this.f24845e = notFoundClasses;
        this.f24846f = new tf.g(module, notFoundClasses);
        this.f24847g = df.e.f8098i;
    }

    public final lf.g O(ef.f fVar, Object obj) {
        lf.g gVarE = lf.i.f15656a.e(obj, this.f24844d);
        if (gVarE != null) {
            return gVarE;
        }
        return lf.l.f15659b.a("Unsupported annotation argument: " + fVar);
    }

    @Override // xe.e, tf.h
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public ge.c f(ze.b proto, bf.c nameResolver) {
        kotlin.jvm.internal.t.f(proto, "proto");
        kotlin.jvm.internal.t.f(nameResolver, "nameResolver");
        return this.f24846f.a(proto, nameResolver);
    }

    @Override // xe.d
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public lf.g I(String desc, Object initializer) {
        kotlin.jvm.internal.t.f(desc, "desc");
        kotlin.jvm.internal.t.f(initializer, "initializer");
        if (kg.c0.P("ZBCS", desc, false, 2, null)) {
            int iIntValue = ((Integer) initializer).intValue();
            int iHashCode = desc.hashCode();
            if (iHashCode == 66) {
                if (desc.equals("B")) {
                    initializer = Byte.valueOf((byte) iIntValue);
                }
                throw new AssertionError(desc);
            }
            if (iHashCode == 67) {
                if (desc.equals("C")) {
                    initializer = Character.valueOf((char) iIntValue);
                }
                throw new AssertionError(desc);
            }
            if (iHashCode == 83) {
                if (desc.equals("S")) {
                    initializer = Short.valueOf((short) iIntValue);
                }
                throw new AssertionError(desc);
            }
            if (iHashCode == 90 && desc.equals("Z")) {
                initializer = Boolean.valueOf(iIntValue != 0);
            }
            throw new AssertionError(desc);
        }
        return lf.i.f15656a.e(initializer, this.f24844d);
    }

    public final fe.e R(ef.b bVar) {
        return fe.y.d(this.f24844d, bVar, this.f24845e);
    }

    public void S(df.e eVar) {
        kotlin.jvm.internal.t.f(eVar, "<set-?>");
        this.f24847g = eVar;
    }

    @Override // xe.d
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public lf.g M(lf.g constant) {
        kotlin.jvm.internal.t.f(constant, "constant");
        return constant instanceof lf.d ? new lf.a0(((Number) ((lf.d) constant).b()).byteValue()) : constant instanceof lf.w ? new lf.d0(((Number) ((lf.w) constant).b()).shortValue()) : constant instanceof lf.n ? new lf.b0(((Number) ((lf.n) constant).b()).intValue()) : constant instanceof lf.t ? new lf.c0(((Number) ((lf.t) constant).b()).longValue()) : constant;
    }

    @Override // xe.e
    public df.e u() {
        return this.f24847g;
    }

    @Override // xe.e
    public x.a x(ef.b annotationClassId, g1 source, List result) {
        kotlin.jvm.internal.t.f(annotationClassId, "annotationClassId");
        kotlin.jvm.internal.t.f(source, "source");
        kotlin.jvm.internal.t.f(result, "result");
        return new b(R(annotationClassId), annotationClassId, result, source);
    }
}
