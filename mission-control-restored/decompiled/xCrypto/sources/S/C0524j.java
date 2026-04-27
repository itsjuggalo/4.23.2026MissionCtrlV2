package S;

import X2.AbstractC0768o;
import java.util.List;
import t3.L;

/* JADX INFO: renamed from: S.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0524j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0524j f3626a = new C0524j();

    public final InterfaceC0523i a(E storage, T.b bVar, List migrations, L scope) {
        kotlin.jvm.internal.r.f(storage, "storage");
        kotlin.jvm.internal.r.f(migrations, "migrations");
        kotlin.jvm.internal.r.f(scope, "scope");
        InterfaceC0519e aVar = bVar;
        if (bVar == null) {
            aVar = new T.a();
        }
        return new C0525k(storage, AbstractC0768o.b(AbstractC0522h.f3609a.b(migrations)), aVar, scope);
    }
}
