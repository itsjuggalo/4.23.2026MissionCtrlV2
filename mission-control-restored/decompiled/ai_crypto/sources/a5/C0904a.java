package a5;

import F5.AbstractC0556n;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: renamed from: a5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0904a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0115a f6369c = new C0115a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f6371b;

    /* JADX INFO: renamed from: a5.a$a, reason: collision with other inner class name */
    public static final class C0115a {
        public /* synthetic */ C0115a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final C0904a a(List pigeonVar_list) {
            kotlin.jvm.internal.r.f(pigeonVar_list, "pigeonVar_list");
            Object obj = pigeonVar_list.get(0);
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.String");
            return new C0904a((String) obj, (Map) pigeonVar_list.get(1));
        }

        public C0115a() {
        }
    }

    public C0904a(String name, Map map) {
        kotlin.jvm.internal.r.f(name, "name");
        this.f6370a = name;
        this.f6371b = map;
    }

    public final List a() {
        return AbstractC0556n.j(this.f6370a, this.f6371b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0904a)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return Z.f6368a.a(a(), ((C0904a) obj).a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return "AnalyticsEvent(name=" + this.f6370a + ", parameters=" + this.f6371b + ")";
    }
}
