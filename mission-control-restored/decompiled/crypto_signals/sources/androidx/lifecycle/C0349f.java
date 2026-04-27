package androidx.lifecycle;

import java.util.HashMap;
import java.util.List;

/* JADX INFO: renamed from: androidx.lifecycle.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0349f implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4677a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f4679c;

    public C0349f(DefaultLifecycleObserver defaultLifecycleObserver, r rVar) {
        kotlin.jvm.internal.j.e(defaultLifecycleObserver, "defaultLifecycleObserver");
        this.f4678b = defaultLifecycleObserver;
        this.f4679c = rVar;
    }

    @Override // androidx.lifecycle.r
    public final void d(InterfaceC0362t interfaceC0362t, EnumC0356m enumC0356m) {
        switch (this.f4677a) {
            case 0:
                int i = AbstractC0348e.f4676a[enumC0356m.ordinal()];
                DefaultLifecycleObserver defaultLifecycleObserver = (DefaultLifecycleObserver) this.f4678b;
                switch (i) {
                    case 1:
                        defaultLifecycleObserver.c(interfaceC0362t);
                        break;
                    case 2:
                        defaultLifecycleObserver.f(interfaceC0362t);
                        break;
                    case 3:
                        defaultLifecycleObserver.a(interfaceC0362t);
                        break;
                    case 4:
                        defaultLifecycleObserver.e(interfaceC0362t);
                        break;
                    case 5:
                        defaultLifecycleObserver.g(interfaceC0362t);
                        break;
                    case 6:
                        defaultLifecycleObserver.b(interfaceC0362t);
                        break;
                    case 7:
                        throw new IllegalArgumentException("ON_ANY must not been send by anybody");
                }
                r rVar = (r) this.f4679c;
                if (rVar != null) {
                    rVar.d(interfaceC0362t, enumC0356m);
                    return;
                }
                return;
            case 1:
                if (enumC0356m == EnumC0356m.ON_START) {
                    ((AbstractC0358o) this.f4678b).b(this);
                    ((Y3.i) this.f4679c).e();
                    return;
                }
                return;
            default:
                HashMap map = ((C0345b) this.f4679c).f4669a;
                List list = (List) map.get(enumC0356m);
                InterfaceC0361s interfaceC0361s = (InterfaceC0361s) this.f4678b;
                C0345b.a(list, interfaceC0362t, enumC0356m, interfaceC0361s);
                C0345b.a((List) map.get(EnumC0356m.ON_ANY), interfaceC0362t, enumC0356m, interfaceC0361s);
                return;
        }
    }

    public C0349f(InterfaceC0361s interfaceC0361s) {
        this.f4678b = interfaceC0361s;
        C0347d c0347d = C0347d.f4673c;
        Class<?> cls = interfaceC0361s.getClass();
        C0345b c0345b = (C0345b) c0347d.f4674a.get(cls);
        this.f4679c = c0345b == null ? c0347d.a(cls, null) : c0345b;
    }

    public C0349f(Y3.i iVar, AbstractC0358o abstractC0358o) {
        this.f4678b = abstractC0358o;
        this.f4679c = iVar;
    }
}
