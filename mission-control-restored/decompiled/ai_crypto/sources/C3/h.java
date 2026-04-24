package C3;

import G3.k;
import G3.v;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class h implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f1054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f1055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f1057d;

    public h(k kVar, v vVar, boolean z7, List list) {
        this.f1054a = kVar;
        this.f1055b = vVar;
        this.f1056c = z7;
        this.f1057d = list;
    }

    public boolean a() {
        return this.f1056c;
    }

    public k b() {
        return this.f1054a;
    }

    public List c() {
        return this.f1057d;
    }

    public v d() {
        return this.f1055b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f1056c == hVar.f1056c && this.f1054a.equals(hVar.f1054a) && this.f1055b.equals(hVar.f1055b)) {
            return this.f1057d.equals(hVar.f1057d);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f1054a.hashCode() * 31) + this.f1055b.hashCode()) * 31) + (this.f1056c ? 1 : 0)) * 31) + this.f1057d.hashCode();
    }
}
