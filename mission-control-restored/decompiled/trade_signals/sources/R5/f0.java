package R5;

import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import y6.AbstractC2996e;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0848e f7245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B5.k f7246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final J6.g f7247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final H6.i f7248d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ I5.m[] f7244f = {kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(f0.class, "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", 0))};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f7243e = new a(null);

    public static final class a {
        public a() {
        }

        public final f0 a(InterfaceC0848e classDescriptor, H6.n storageManager, J6.g kotlinTypeRefinerForOwnerModule, B5.k scopeFactory) {
            AbstractC2304t.f(classDescriptor, "classDescriptor");
            AbstractC2304t.f(storageManager, "storageManager");
            AbstractC2304t.f(kotlinTypeRefinerForOwnerModule, "kotlinTypeRefinerForOwnerModule");
            AbstractC2304t.f(scopeFactory, "scopeFactory");
            return new f0(classDescriptor, storageManager, scopeFactory, kotlinTypeRefinerForOwnerModule, null);
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public f0(InterfaceC0848e interfaceC0848e, H6.n nVar, B5.k kVar, J6.g gVar) {
        this.f7245a = interfaceC0848e;
        this.f7246b = kVar;
        this.f7247c = gVar;
        this.f7248d = nVar.e(new d0(this));
    }

    public static final B6.k d(f0 f0Var, J6.g gVar) {
        return (B6.k) f0Var.f7246b.invoke(gVar);
    }

    public static final B6.k f(f0 f0Var) {
        return (B6.k) f0Var.f7246b.invoke(f0Var.f7247c);
    }

    public final B6.k c(J6.g kotlinTypeRefiner) {
        AbstractC2304t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (!kotlinTypeRefiner.d(AbstractC2996e.s(this.f7245a))) {
            return e();
        }
        I6.v0 v0VarL = this.f7245a.l();
        AbstractC2304t.e(v0VarL, "getTypeConstructor(...)");
        return !kotlinTypeRefiner.e(v0VarL) ? e() : kotlinTypeRefiner.c(this.f7245a, new e0(this, kotlinTypeRefiner));
    }

    public final B6.k e() {
        return (B6.k) H6.m.a(this.f7248d, this, f7244f[0]);
    }

    public /* synthetic */ f0(InterfaceC0848e interfaceC0848e, H6.n nVar, B5.k kVar, J6.g gVar, AbstractC2296k abstractC2296k) {
        this(interfaceC0848e, nVar, kVar, gVar);
    }
}
