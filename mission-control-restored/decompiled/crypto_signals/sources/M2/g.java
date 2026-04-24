package M2;

import Q2.n;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class g implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Q2.h f1077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f1078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f1080d;

    public g(Q2.h hVar, n nVar, boolean z6, ArrayList arrayList) {
        this.f1077a = hVar;
        this.f1078b = nVar;
        this.f1079c = z6;
        this.f1080d = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f1079c == gVar.f1079c && this.f1077a.equals(gVar.f1077a) && this.f1078b.equals(gVar.f1078b)) {
            return this.f1080d.equals(gVar.f1080d);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1080d.hashCode() + ((((this.f1078b.f2688a.hashCode() + (this.f1077a.f2674a.hashCode() * 31)) * 31) + (this.f1079c ? 1 : 0)) * 31);
    }
}
