package q3;

import java.util.Iterator;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j extends i {

    public static final class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f14303a;

        public a(Iterator it) {
            this.f14303a = it;
        }

        @Override // q3.e
        public Iterator iterator() {
            return this.f14303a;
        }
    }

    public static e c(Iterator it) {
        r.f(it, "<this>");
        return d(new a(it));
    }

    public static e d(e eVar) {
        r.f(eVar, "<this>");
        return eVar instanceof C1724a ? eVar : new C1724a(eVar);
    }

    public static e e() {
        return d.f14297a;
    }
}
