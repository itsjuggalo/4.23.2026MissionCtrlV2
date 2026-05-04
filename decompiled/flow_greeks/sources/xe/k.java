package xe;

import ee.k;
import fe.m0;
import he.a;
import he.c;
import tf.b0;
import tf.o;
import xe.d0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f24890b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tf.n f24891a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: xe.k$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0457a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final k f24892a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final n f24893b;

            public C0457a(k deserializationComponentsForJava, n deserializedDescriptorResolver) {
                kotlin.jvm.internal.t.f(deserializationComponentsForJava, "deserializationComponentsForJava");
                kotlin.jvm.internal.t.f(deserializedDescriptorResolver, "deserializedDescriptorResolver");
                this.f24892a = deserializationComponentsForJava;
                this.f24893b = deserializedDescriptorResolver;
            }

            public final k a() {
                return this.f24892a;
            }

            public final n b() {
                return this.f24893b;
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final C0457a a(v kotlinClassFinder, v jvmBuiltInsKotlinClassFinder, oe.u javaClassFinder, String moduleName, tf.w errorReporter, ue.b javaSourceElementFactory) {
            kotlin.jvm.internal.t.f(kotlinClassFinder, "kotlinClassFinder");
            kotlin.jvm.internal.t.f(jvmBuiltInsKotlinClassFinder, "jvmBuiltInsKotlinClassFinder");
            kotlin.jvm.internal.t.f(javaClassFinder, "javaClassFinder");
            kotlin.jvm.internal.t.f(moduleName, "moduleName");
            kotlin.jvm.internal.t.f(errorReporter, "errorReporter");
            kotlin.jvm.internal.t.f(javaSourceElementFactory, "javaSourceElementFactory");
            wf.f fVar = new wf.f("DeserializationComponentsForJava.ModuleData");
            ee.k kVar = new ee.k(fVar, k.a.f8722a);
            ef.f fVarO = ef.f.o('<' + moduleName + '>');
            kotlin.jvm.internal.t.e(fVarO, "special(...)");
            ie.f0 f0Var = new ie.f0(fVarO, fVar, kVar, null, null, null, 56, null);
            kVar.F0(f0Var);
            kVar.N0(f0Var, true);
            n nVar = new n();
            re.o oVar = new re.o();
            m0 m0Var = new m0(fVar, f0Var);
            re.j jVarB = l.b(javaClassFinder, f0Var, fVar, m0Var, kotlinClassFinder, nVar, errorReporter, javaSourceElementFactory, oVar, (512 & 512) != 0 ? d0.a.f24828a : null);
            k kVarA = l.a(f0Var, fVar, m0Var, jVarB, kotlinClassFinder, nVar, errorReporter, df.e.f8098i);
            nVar.p(kVarA);
            pe.j EMPTY = pe.j.f18605a;
            kotlin.jvm.internal.t.e(EMPTY, "EMPTY");
            of.c cVar = new of.c(jVarB, EMPTY);
            oVar.c(cVar);
            ee.w wVar = new ee.w(fVar, jvmBuiltInsKotlinClassFinder, f0Var, m0Var, kVar.M0(), kVar.M0(), o.a.f22024a, yf.p.f25422b.a(), new pf.b(fVar, dd.r.k()));
            f0Var.W0(f0Var);
            f0Var.O0(new ie.l(dd.r.n(cVar.a(), wVar), "CompositeProvider@RuntimeModuleData for " + f0Var));
            return new C0457a(kVarA, nVar);
        }

        public a() {
        }
    }

    public k(wf.n storageManager, fe.h0 moduleDescriptor, tf.o configuration, o classDataFinder, h annotationAndConstantLoader, re.j packageFragmentProvider, m0 notFoundClasses, tf.w errorReporter, ne.c lookupTracker, tf.m contractDeserializer, yf.p kotlinTypeChecker, ag.a typeAttributeTranslators) {
        he.c cVarM0;
        he.a aVarM0;
        kotlin.jvm.internal.t.f(storageManager, "storageManager");
        kotlin.jvm.internal.t.f(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.t.f(configuration, "configuration");
        kotlin.jvm.internal.t.f(classDataFinder, "classDataFinder");
        kotlin.jvm.internal.t.f(annotationAndConstantLoader, "annotationAndConstantLoader");
        kotlin.jvm.internal.t.f(packageFragmentProvider, "packageFragmentProvider");
        kotlin.jvm.internal.t.f(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.t.f(errorReporter, "errorReporter");
        kotlin.jvm.internal.t.f(lookupTracker, "lookupTracker");
        kotlin.jvm.internal.t.f(contractDeserializer, "contractDeserializer");
        kotlin.jvm.internal.t.f(kotlinTypeChecker, "kotlinTypeChecker");
        kotlin.jvm.internal.t.f(typeAttributeTranslators, "typeAttributeTranslators");
        ce.i iVarP = moduleDescriptor.p();
        ee.k kVar = iVarP instanceof ee.k ? (ee.k) iVarP : null;
        this.f24891a = new tf.n(storageManager, moduleDescriptor, configuration, classDataFinder, annotationAndConstantLoader, packageFragmentProvider, b0.a.f21931a, errorReporter, lookupTracker, p.f24904a, dd.r.k(), notFoundClasses, contractDeserializer, (kVar == null || (aVarM0 = kVar.M0()) == null) ? a.C0208a.f11300a : aVarM0, (kVar == null || (cVarM0 = kVar.M0()) == null) ? c.b.f11302a : cVarM0, df.i.f8111a.a(), kotlinTypeChecker, new pf.b(storageManager, dd.r.k()), typeAttributeTranslators.a(), tf.z.f22082a);
    }

    public final tf.n a() {
        return this.f24891a;
    }
}
