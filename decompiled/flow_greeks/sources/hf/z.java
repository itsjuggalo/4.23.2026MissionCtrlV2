package hf;

import dd.u0;
import fe.s1;
import hf.b;
import hf.n;
import hf.w;
import io.flutter.plugins.firebase.database.Constants;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.n0;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class z implements w {
    public static final /* synthetic */ wd.m[] Z = {n0.e(new kotlin.jvm.internal.a0(z.class, "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "withDefinedIn", "getWithDefinedIn()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, Constants.MODIFIERS, "getModifiers()Ljava/util/Set;", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "startFromName", "getStartFromName()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "debugMode", "getDebugMode()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "verbose", "getVerbose()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "unitReturnType", "getUnitReturnType()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "withoutReturnType", "getWithoutReturnType()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "enhancedTypes", "getEnhancedTypes()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "normalizedVisibilities", "getNormalizedVisibilities()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "renderDefaultVisibility", "getRenderDefaultVisibility()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "renderDefaultModality", "getRenderDefaultModality()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "renderConstructorDelegation", "getRenderConstructorDelegation()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "includePropertyConstant", "getIncludePropertyConstant()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "propertyConstantRenderer", "getPropertyConstantRenderer()Lkotlin/jvm/functions/Function1;", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "withoutTypeParameters", "getWithoutTypeParameters()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "withoutSuperTypes", "getWithoutSuperTypes()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "receiverAfterName", "getReceiverAfterName()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "renderCompanionObjectName", "getRenderCompanionObjectName()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "renderConstructorKeyword", "getRenderConstructorKeyword()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "renderTypeExpansions", "getRenderTypeExpansions()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "renderAbbreviatedTypeComments", "getRenderAbbreviatedTypeComments()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "renderFunctionContracts", "getRenderFunctionContracts()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z", 0)), n0.e(new kotlin.jvm.internal.a0(z.class, "informativeErrorType", "getInformativeErrorType()Z", 0))};
    public final sd.d A;
    public final sd.d B;
    public final sd.d C;
    public final sd.d D;
    public final sd.d E;
    public final sd.d F;
    public final sd.d G;
    public final sd.d H;
    public final sd.d I;
    public final sd.d J;
    public final sd.d K;
    public final sd.d L;
    public final sd.d M;
    public final sd.d N;
    public final sd.d O;
    public final sd.d P;
    public final sd.d Q;
    public final sd.d R;
    public final sd.d S;
    public final sd.d T;
    public final sd.d U;
    public final sd.d V;
    public final sd.d W;
    public final sd.d X;
    public final sd.d Y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f11395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final sd.d f11396b = r0(b.c.f11315a);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final sd.d f11397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final sd.d f11398d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final sd.d f11399e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final sd.d f11400f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final sd.d f11401g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final sd.d f11402h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final sd.d f11403i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final sd.d f11404j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final sd.d f11405k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final sd.d f11406l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final sd.d f11407m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final sd.d f11408n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final sd.d f11409o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final sd.d f11410p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final sd.d f11411q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final sd.d f11412r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final sd.d f11413s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final sd.d f11414t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final sd.d f11415u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final sd.d f11416v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final sd.d f11417w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final sd.d f11418x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final sd.d f11419y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final sd.d f11420z;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends sd.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ z f11421b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Object obj, z zVar) {
            super(obj);
            this.f11421b = zVar;
        }

        @Override // sd.b
        public boolean d(wd.m property, Object obj, Object obj2) {
            kotlin.jvm.internal.t.f(property, "property");
            if (this.f11421b.p0()) {
                throw new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
            }
            return true;
        }
    }

    public z() {
        Boolean bool = Boolean.TRUE;
        this.f11397c = r0(bool);
        this.f11398d = r0(bool);
        this.f11399e = r0(v.f11374c);
        Boolean bool2 = Boolean.FALSE;
        this.f11400f = r0(bool2);
        this.f11401g = r0(bool2);
        this.f11402h = r0(bool2);
        this.f11403i = r0(bool2);
        this.f11404j = r0(bool2);
        this.f11405k = r0(bool);
        this.f11406l = r0(bool2);
        this.f11407m = r0(bool2);
        this.f11408n = r0(bool2);
        this.f11409o = r0(bool);
        this.f11410p = r0(bool);
        this.f11411q = r0(bool2);
        this.f11412r = r0(bool2);
        this.f11413s = r0(bool2);
        this.f11414t = r0(bool2);
        this.f11415u = r0(bool2);
        this.f11416v = r0(null);
        this.f11417w = r0(bool2);
        this.f11418x = r0(bool2);
        this.f11419y = r0(x.f11393a);
        this.f11420z = r0(y.f11394a);
        this.A = r0(bool);
        this.B = r0(c0.f11319b);
        this.C = r0(n.b.a.f11360a);
        this.D = r0(f0.f11336a);
        this.E = r0(d0.f11324a);
        this.F = r0(bool2);
        this.G = r0(bool2);
        this.H = r0(e0.f11331b);
        this.I = r0(bool2);
        this.J = r0(bool2);
        this.K = r0(u0.d());
        this.L = r0(a0.f11311a.a());
        this.M = r0(null);
        this.N = r0(hf.a.f11304c);
        this.O = r0(bool2);
        this.P = r0(bool);
        this.Q = r0(bool);
        this.R = r0(bool2);
        this.S = r0(bool2);
        this.T = r0(bool);
        this.U = r0(bool);
        this.V = r0(bool2);
        this.W = r0(bool2);
        this.X = r0(bool2);
        this.Y = r0(bool);
    }

    public static final r0 s0(r0 it) {
        kotlin.jvm.internal.t.f(it, "it");
        return it;
    }

    public static final String t(s1 it) {
        kotlin.jvm.internal.t.f(it, "it");
        return "...";
    }

    public pd.k A() {
        return (pd.k) this.f11420z.a(this, Z[24]);
    }

    public boolean B() {
        return ((Boolean) this.J.a(this, Z[34])).booleanValue();
    }

    public Set C() {
        return (Set) this.K.a(this, Z[35]);
    }

    public boolean D() {
        return ((Boolean) this.T.a(this, Z[44])).booleanValue();
    }

    public boolean E() {
        return w.a.a(this);
    }

    public boolean F() {
        return w.a.b(this);
    }

    public boolean G() {
        return ((Boolean) this.f11415u.a(this, Z[19])).booleanValue();
    }

    public boolean H() {
        return ((Boolean) this.Y.a(this, Z[49])).booleanValue();
    }

    public Set I() {
        return (Set) this.f11399e.a(this, Z[3]);
    }

    public boolean J() {
        return ((Boolean) this.f11408n.a(this, Z[12])).booleanValue();
    }

    public c0 K() {
        return (c0) this.B.a(this, Z[26]);
    }

    public d0 L() {
        return (d0) this.E.a(this, Z[29]);
    }

    public boolean M() {
        return ((Boolean) this.U.a(this, Z[45])).booleanValue();
    }

    public boolean N() {
        return ((Boolean) this.W.a(this, Z[47])).booleanValue();
    }

    public e0 O() {
        return (e0) this.H.a(this, Z[32]);
    }

    public pd.k P() {
        return (pd.k) this.f11416v.a(this, Z[20]);
    }

    public boolean Q() {
        return ((Boolean) this.F.a(this, Z[30])).booleanValue();
    }

    public boolean R() {
        return ((Boolean) this.S.a(this, Z[43])).booleanValue();
    }

    public boolean S() {
        return ((Boolean) this.G.a(this, Z[31])).booleanValue();
    }

    public boolean T() {
        return ((Boolean) this.f11411q.a(this, Z[15])).booleanValue();
    }

    public boolean U() {
        return ((Boolean) this.P.a(this, Z[40])).booleanValue();
    }

    public boolean V() {
        return ((Boolean) this.I.a(this, Z[33])).booleanValue();
    }

    public boolean W() {
        return ((Boolean) this.f11410p.a(this, Z[14])).booleanValue();
    }

    public boolean X() {
        return ((Boolean) this.f11409o.a(this, Z[13])).booleanValue();
    }

    public boolean Y() {
        return ((Boolean) this.f11412r.a(this, Z[16])).booleanValue();
    }

    public boolean Z() {
        return ((Boolean) this.R.a(this, Z[42])).booleanValue();
    }

    @Override // hf.w
    public void a(Set set) {
        kotlin.jvm.internal.t.f(set, "<set-?>");
        this.L.b(this, Z[36], set);
    }

    public boolean a0() {
        return ((Boolean) this.Q.a(this, Z[41])).booleanValue();
    }

    @Override // hf.w
    public void b(boolean z10) {
        this.f11400f.b(this, Z[4], Boolean.valueOf(z10));
    }

    public boolean b0() {
        return ((Boolean) this.A.a(this, Z[25])).booleanValue();
    }

    @Override // hf.w
    public void c(Set set) {
        kotlin.jvm.internal.t.f(set, "<set-?>");
        this.f11399e.b(this, Z[3], set);
    }

    public boolean c0() {
        return ((Boolean) this.f11401g.a(this, Z[5])).booleanValue();
    }

    @Override // hf.w
    public void d(boolean z10) {
        this.f11397c.b(this, Z[1], Boolean.valueOf(z10));
    }

    public boolean d0() {
        return ((Boolean) this.f11400f.a(this, Z[4])).booleanValue();
    }

    @Override // hf.w
    public void e(b bVar) {
        kotlin.jvm.internal.t.f(bVar, "<set-?>");
        this.f11396b.b(this, Z[0], bVar);
    }

    public f0 e0() {
        return (f0) this.D.a(this, Z[28]);
    }

    @Override // hf.w
    public boolean f() {
        return ((Boolean) this.f11407m.a(this, Z[11])).booleanValue();
    }

    public pd.k f0() {
        return (pd.k) this.f11419y.a(this, Z[23]);
    }

    @Override // hf.w
    public void g(d0 d0Var) {
        kotlin.jvm.internal.t.f(d0Var, "<set-?>");
        this.E.b(this, Z[29], d0Var);
    }

    public boolean g0() {
        return ((Boolean) this.f11414t.a(this, Z[18])).booleanValue();
    }

    @Override // hf.w
    public void h(boolean z10) {
        this.f11418x.b(this, Z[22], Boolean.valueOf(z10));
    }

    public boolean h0() {
        return ((Boolean) this.f11405k.a(this, Z[9])).booleanValue();
    }

    @Override // hf.w
    public void i(boolean z10) {
        this.f11402h.b(this, Z[6], Boolean.valueOf(z10));
    }

    public n.b i0() {
        return (n.b) this.C.a(this, Z[27]);
    }

    @Override // hf.w
    public void j(f0 f0Var) {
        kotlin.jvm.internal.t.f(f0Var, "<set-?>");
        this.D.b(this, Z[28], f0Var);
    }

    public boolean j0() {
        return ((Boolean) this.f11404j.a(this, Z[8])).booleanValue();
    }

    @Override // hf.w
    public void k(boolean z10) {
        this.G.b(this, Z[31], Boolean.valueOf(z10));
    }

    public boolean k0() {
        return ((Boolean) this.f11397c.a(this, Z[1])).booleanValue();
    }

    @Override // hf.w
    public void l(boolean z10) {
        this.F.b(this, Z[30], Boolean.valueOf(z10));
    }

    public boolean l0() {
        return ((Boolean) this.f11398d.a(this, Z[2])).booleanValue();
    }

    @Override // hf.w
    public Set m() {
        return (Set) this.L.a(this, Z[36]);
    }

    public boolean m0() {
        return ((Boolean) this.f11406l.a(this, Z[10])).booleanValue();
    }

    @Override // hf.w
    public boolean n() {
        return ((Boolean) this.f11402h.a(this, Z[6])).booleanValue();
    }

    public boolean n0() {
        return ((Boolean) this.f11418x.a(this, Z[22])).booleanValue();
    }

    @Override // hf.w
    public hf.a o() {
        return (hf.a) this.N.a(this, Z[38]);
    }

    public boolean o0() {
        return ((Boolean) this.f11417w.a(this, Z[21])).booleanValue();
    }

    @Override // hf.w
    public void p(boolean z10) {
        this.f11417w.b(this, Z[21], Boolean.valueOf(z10));
    }

    public final boolean p0() {
        return this.f11395a;
    }

    public final void q0() {
        this.f11395a = true;
    }

    public final sd.d r0(Object obj) {
        sd.a aVar = sd.a.f20211a;
        return new a(obj, this);
    }

    public final z s() {
        z zVar = new z();
        Iterator itA = kotlin.jvm.internal.c.a(z.class.getDeclaredFields());
        while (itA.hasNext()) {
            Field field = (Field) itA.next();
            if ((field.getModifiers() & 8) == 0) {
                field.setAccessible(true);
                Object obj = field.get(this);
                sd.b bVar = obj instanceof sd.b ? (sd.b) obj : null;
                if (bVar != null) {
                    String name = field.getName();
                    kotlin.jvm.internal.t.e(name, "getName(...)");
                    kg.z.J(name, "is", false, 2, null);
                    wd.d dVarB = n0.b(z.class);
                    String name2 = field.getName();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(com.amazon.a.a.o.b.au);
                    String name3 = field.getName();
                    kotlin.jvm.internal.t.e(name3, "getName(...)");
                    if (name3.length() > 0) {
                        char upperCase = Character.toUpperCase(name3.charAt(0));
                        String strSubstring = name3.substring(1);
                        kotlin.jvm.internal.t.e(strSubstring, "substring(...)");
                        name3 = upperCase + strSubstring;
                    }
                    sb2.append(name3);
                    field.set(zVar, zVar.r0(bVar.a(this, new kotlin.jvm.internal.g0(dVarB, name2, sb2.toString()))));
                }
            }
        }
        return zVar;
    }

    public boolean u() {
        return ((Boolean) this.f11413s.a(this, Z[17])).booleanValue();
    }

    public boolean v() {
        return ((Boolean) this.O.a(this, Z[39])).booleanValue();
    }

    public pd.k w() {
        return (pd.k) this.M.a(this, Z[37]);
    }

    public boolean x() {
        return ((Boolean) this.X.a(this, Z[48])).booleanValue();
    }

    public boolean y() {
        return ((Boolean) this.f11403i.a(this, Z[7])).booleanValue();
    }

    public b z() {
        return (b) this.f11396b.a(this, Z[0]);
    }
}
