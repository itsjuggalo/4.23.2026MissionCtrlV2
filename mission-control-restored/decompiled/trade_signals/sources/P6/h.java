package P6;

import P6.g;
import R5.InterfaceC0868z;
import java.util.Arrays;
import java.util.Collection;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q6.f f6497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V6.n f6498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Collection f6499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final B5.k f6500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f[] f6501e;

    public static final class a implements B5.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6502a = new a();

        @Override // B5.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(InterfaceC0868z interfaceC0868z) {
            AbstractC2304t.f(interfaceC0868z, "<this>");
            return null;
        }
    }

    public static final class b implements B5.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f6503a = new b();

        @Override // B5.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(InterfaceC0868z interfaceC0868z) {
            AbstractC2304t.f(interfaceC0868z, "<this>");
            return null;
        }
    }

    public static final class c implements B5.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f6504a = new c();

        @Override // B5.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(InterfaceC0868z interfaceC0868z) {
            AbstractC2304t.f(interfaceC0868z, "<this>");
            return null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(V6.n regex, f[] checks, B5.k additionalChecks) {
        this((q6.f) null, regex, (Collection) null, additionalChecks, (f[]) Arrays.copyOf(checks, checks.length));
        AbstractC2304t.f(regex, "regex");
        AbstractC2304t.f(checks, "checks");
        AbstractC2304t.f(additionalChecks, "additionalChecks");
    }

    public final g a(InterfaceC0868z functionDescriptor) {
        AbstractC2304t.f(functionDescriptor, "functionDescriptor");
        for (f fVar : this.f6501e) {
            String strB = fVar.b(functionDescriptor);
            if (strB != null) {
                return new g.b(strB);
            }
        }
        String str = (String) this.f6500d.invoke(functionDescriptor);
        return str != null ? new g.b(str) : g.c.f6496b;
    }

    public final boolean b(InterfaceC0868z functionDescriptor) {
        AbstractC2304t.f(functionDescriptor, "functionDescriptor");
        if (this.f6497a != null && !AbstractC2304t.b(functionDescriptor.getName(), this.f6497a)) {
            return false;
        }
        if (this.f6498b != null) {
            String strB = functionDescriptor.getName().b();
            AbstractC2304t.e(strB, "asString(...)");
            if (!this.f6498b.b(strB)) {
                return false;
            }
        }
        Collection collection = this.f6499c;
        return collection == null || collection.contains(functionDescriptor.getName());
    }

    public /* synthetic */ h(V6.n nVar, f[] fVarArr, B5.k kVar, int i8, AbstractC2296k abstractC2296k) {
        this(nVar, fVarArr, (i8 & 4) != 0 ? b.f6503a : kVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(Collection nameList, f[] checks, B5.k additionalChecks) {
        this((q6.f) null, (V6.n) null, nameList, additionalChecks, (f[]) Arrays.copyOf(checks, checks.length));
        AbstractC2304t.f(nameList, "nameList");
        AbstractC2304t.f(checks, "checks");
        AbstractC2304t.f(additionalChecks, "additionalChecks");
    }

    public /* synthetic */ h(Collection collection, f[] fVarArr, B5.k kVar, int i8, AbstractC2296k abstractC2296k) {
        this(collection, fVarArr, (i8 & 4) != 0 ? c.f6504a : kVar);
    }

    public h(q6.f fVar, V6.n nVar, Collection collection, B5.k kVar, f... fVarArr) {
        this.f6497a = fVar;
        this.f6498b = nVar;
        this.f6499c = collection;
        this.f6500d = kVar;
        this.f6501e = fVarArr;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(q6.f name, f[] checks, B5.k additionalChecks) {
        this(name, (V6.n) null, (Collection) null, additionalChecks, (f[]) Arrays.copyOf(checks, checks.length));
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(checks, "checks");
        AbstractC2304t.f(additionalChecks, "additionalChecks");
    }

    public /* synthetic */ h(q6.f fVar, f[] fVarArr, B5.k kVar, int i8, AbstractC2296k abstractC2296k) {
        this(fVar, fVarArr, (i8 & 4) != 0 ? a.f6502a : kVar);
    }
}
