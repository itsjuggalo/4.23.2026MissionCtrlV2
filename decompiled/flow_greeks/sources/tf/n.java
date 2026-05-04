package tf;

import he.a;
import he.c;
import java.util.List;
import tf.v;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wf.n f21993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fe.h0 f21994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f21995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f21996d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f21997e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final fe.o0 f21998f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b0 f21999g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final w f22000h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ne.c f22001i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final x f22002j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Iterable f22003k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final fe.m0 f22004l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final m f22005m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final he.a f22006n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final he.c f22007o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final gf.g f22008p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final yf.p f22009q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final pf.a f22010r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List f22011s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final v f22012t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final l f22013u;

    public n(wf.n storageManager, fe.h0 moduleDescriptor, o configuration, j classDataFinder, e annotationAndConstantLoader, fe.o0 packageFragmentProvider, b0 localClassifierTypeSettings, w errorReporter, ne.c lookupTracker, x flexibleTypeDeserializer, Iterable fictitiousClassDescriptorFactories, fe.m0 notFoundClasses, m contractDeserializer, he.a additionalClassPartsProvider, he.c platformDependentDeclarationFilter, gf.g extensionRegistryLite, yf.p kotlinTypeChecker, pf.a samConversionResolver, List typeAttributeTranslators, v enumEntriesDeserializationSupport) {
        kotlin.jvm.internal.t.f(storageManager, "storageManager");
        kotlin.jvm.internal.t.f(moduleDescriptor, "moduleDescriptor");
        kotlin.jvm.internal.t.f(configuration, "configuration");
        kotlin.jvm.internal.t.f(classDataFinder, "classDataFinder");
        kotlin.jvm.internal.t.f(annotationAndConstantLoader, "annotationAndConstantLoader");
        kotlin.jvm.internal.t.f(packageFragmentProvider, "packageFragmentProvider");
        kotlin.jvm.internal.t.f(localClassifierTypeSettings, "localClassifierTypeSettings");
        kotlin.jvm.internal.t.f(errorReporter, "errorReporter");
        kotlin.jvm.internal.t.f(lookupTracker, "lookupTracker");
        kotlin.jvm.internal.t.f(flexibleTypeDeserializer, "flexibleTypeDeserializer");
        kotlin.jvm.internal.t.f(fictitiousClassDescriptorFactories, "fictitiousClassDescriptorFactories");
        kotlin.jvm.internal.t.f(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.t.f(contractDeserializer, "contractDeserializer");
        kotlin.jvm.internal.t.f(additionalClassPartsProvider, "additionalClassPartsProvider");
        kotlin.jvm.internal.t.f(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        kotlin.jvm.internal.t.f(extensionRegistryLite, "extensionRegistryLite");
        kotlin.jvm.internal.t.f(kotlinTypeChecker, "kotlinTypeChecker");
        kotlin.jvm.internal.t.f(samConversionResolver, "samConversionResolver");
        kotlin.jvm.internal.t.f(typeAttributeTranslators, "typeAttributeTranslators");
        kotlin.jvm.internal.t.f(enumEntriesDeserializationSupport, "enumEntriesDeserializationSupport");
        this.f21993a = storageManager;
        this.f21994b = moduleDescriptor;
        this.f21995c = configuration;
        this.f21996d = classDataFinder;
        this.f21997e = annotationAndConstantLoader;
        this.f21998f = packageFragmentProvider;
        this.f21999g = localClassifierTypeSettings;
        this.f22000h = errorReporter;
        this.f22001i = lookupTracker;
        this.f22002j = flexibleTypeDeserializer;
        this.f22003k = fictitiousClassDescriptorFactories;
        this.f22004l = notFoundClasses;
        this.f22005m = contractDeserializer;
        this.f22006n = additionalClassPartsProvider;
        this.f22007o = platformDependentDeclarationFilter;
        this.f22008p = extensionRegistryLite;
        this.f22009q = kotlinTypeChecker;
        this.f22010r = samConversionResolver;
        this.f22011s = typeAttributeTranslators;
        this.f22012t = enumEntriesDeserializationSupport;
        this.f22013u = new l(this);
    }

    public final p a(fe.n0 descriptor, bf.c nameResolver, bf.g typeTable, bf.h versionRequirementTable, bf.a metadataVersion, vf.s sVar) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        kotlin.jvm.internal.t.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.t.f(typeTable, "typeTable");
        kotlin.jvm.internal.t.f(versionRequirementTable, "versionRequirementTable");
        kotlin.jvm.internal.t.f(metadataVersion, "metadataVersion");
        return new p(this, nameResolver, descriptor, typeTable, versionRequirementTable, metadataVersion, sVar, null, dd.r.k());
    }

    public final fe.e b(ef.b classId) {
        kotlin.jvm.internal.t.f(classId, "classId");
        return l.f(this.f22013u, classId, null, 2, null);
    }

    public final he.a c() {
        return this.f22006n;
    }

    public final e d() {
        return this.f21997e;
    }

    public final j e() {
        return this.f21996d;
    }

    public final l f() {
        return this.f22013u;
    }

    public final o g() {
        return this.f21995c;
    }

    public final m h() {
        return this.f22005m;
    }

    public final v i() {
        return this.f22012t;
    }

    public final w j() {
        return this.f22000h;
    }

    public final gf.g k() {
        return this.f22008p;
    }

    public final Iterable l() {
        return this.f22003k;
    }

    public final x m() {
        return this.f22002j;
    }

    public final yf.p n() {
        return this.f22009q;
    }

    public final b0 o() {
        return this.f21999g;
    }

    public final ne.c p() {
        return this.f22001i;
    }

    public final fe.h0 q() {
        return this.f21994b;
    }

    public final fe.m0 r() {
        return this.f22004l;
    }

    public final fe.o0 s() {
        return this.f21998f;
    }

    public final he.c t() {
        return this.f22007o;
    }

    public final wf.n u() {
        return this.f21993a;
    }

    public final List v() {
        return this.f22011s;
    }

    public /* synthetic */ n(wf.n nVar, fe.h0 h0Var, o oVar, j jVar, e eVar, fe.o0 o0Var, b0 b0Var, w wVar, ne.c cVar, x xVar, Iterable iterable, fe.m0 m0Var, m mVar, he.a aVar, he.c cVar2, gf.g gVar, yf.p pVar, pf.a aVar2, List list, v vVar, int i10, kotlin.jvm.internal.k kVar) {
        this(nVar, h0Var, oVar, jVar, eVar, o0Var, b0Var, wVar, cVar, xVar, iterable, m0Var, mVar, (i10 & 8192) != 0 ? a.C0208a.f11300a : aVar, (i10 & 16384) != 0 ? c.a.f11301a : cVar2, gVar, (65536 & i10) != 0 ? yf.p.f25422b.a() : pVar, aVar2, (262144 & i10) != 0 ? dd.q.e(xf.x.f25092a) : list, (i10 & 524288) != 0 ? v.a.f22063a : vVar);
    }
}
