package z;

import java.util.Locale;

/* JADX INFO: renamed from: z.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1451i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C1451i f11725b = new C1451i(new C1452j(AbstractC1450h.a(new Locale[0])));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1452j f11726a;

    public C1451i(C1452j c1452j) {
        this.f11726a = c1452j;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1451i) {
            return this.f11726a.equals(((C1451i) obj).f11726a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f11726a.f11727a.hashCode();
    }

    public final String toString() {
        return this.f11726a.f11727a.toString();
    }
}
