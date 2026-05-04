package eg;

import eg.g;
import java.util.Arrays;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ef.f f8891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kg.n f8892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Collection f8893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final pd.k f8894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f[] f8895e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements pd.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8896a = new a();

        @Override // pd.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(fe.z zVar) {
            kotlin.jvm.internal.t.f(zVar, "<this>");
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements pd.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f8897a = new b();

        @Override // pd.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(fe.z zVar) {
            kotlin.jvm.internal.t.f(zVar, "<this>");
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements pd.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f8898a = new c();

        @Override // pd.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(fe.z zVar) {
            kotlin.jvm.internal.t.f(zVar, "<this>");
            return null;
        }
    }

    public h(ef.f fVar, kg.n nVar, Collection collection, pd.k kVar, f... fVarArr) {
        this.f8891a = fVar;
        this.f8892b = nVar;
        this.f8893c = collection;
        this.f8894d = kVar;
        this.f8895e = fVarArr;
    }

    public final g a(fe.z functionDescriptor) {
        kotlin.jvm.internal.t.f(functionDescriptor, "functionDescriptor");
        for (f fVar : this.f8895e) {
            String strB = fVar.b(functionDescriptor);
            if (strB != null) {
                return new g.b(strB);
            }
        }
        String str = (String) this.f8894d.invoke(functionDescriptor);
        return str != null ? new g.b(str) : g.c.f8890b;
    }

    public final boolean b(fe.z functionDescriptor) {
        kotlin.jvm.internal.t.f(functionDescriptor, "functionDescriptor");
        if (this.f8891a != null && !kotlin.jvm.internal.t.b(functionDescriptor.getName(), this.f8891a)) {
            return false;
        }
        if (this.f8892b != null) {
            String strB = functionDescriptor.getName().b();
            kotlin.jvm.internal.t.e(strB, "asString(...)");
            if (!this.f8892b.b(strB)) {
                return false;
            }
        }
        Collection collection = this.f8893c;
        return collection == null || collection.contains(functionDescriptor.getName());
    }

    public /* synthetic */ h(ef.f fVar, f[] fVarArr, pd.k kVar, int i10, kotlin.jvm.internal.k kVar2) {
        this(fVar, fVarArr, (i10 & 4) != 0 ? a.f8896a : kVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(ef.f name, f[] checks, pd.k additionalChecks) {
        this(name, (kg.n) null, (Collection) null, additionalChecks, (f[]) Arrays.copyOf(checks, checks.length));
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(checks, "checks");
        kotlin.jvm.internal.t.f(additionalChecks, "additionalChecks");
    }

    public /* synthetic */ h(kg.n nVar, f[] fVarArr, pd.k kVar, int i10, kotlin.jvm.internal.k kVar2) {
        this(nVar, fVarArr, (i10 & 4) != 0 ? b.f8897a : kVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(kg.n regex, f[] checks, pd.k additionalChecks) {
        this((ef.f) null, regex, (Collection) null, additionalChecks, (f[]) Arrays.copyOf(checks, checks.length));
        kotlin.jvm.internal.t.f(regex, "regex");
        kotlin.jvm.internal.t.f(checks, "checks");
        kotlin.jvm.internal.t.f(additionalChecks, "additionalChecks");
    }

    public /* synthetic */ h(Collection collection, f[] fVarArr, pd.k kVar, int i10, kotlin.jvm.internal.k kVar2) {
        this(collection, fVarArr, (i10 & 4) != 0 ? c.f8898a : kVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(Collection nameList, f[] checks, pd.k additionalChecks) {
        this((ef.f) null, (kg.n) null, nameList, additionalChecks, (f[]) Arrays.copyOf(checks, checks.length));
        kotlin.jvm.internal.t.f(nameList, "nameList");
        kotlin.jvm.internal.t.f(checks, "checks");
        kotlin.jvm.internal.t.f(additionalChecks, "additionalChecks");
    }
}
