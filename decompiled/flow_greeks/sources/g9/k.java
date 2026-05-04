package g9;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class k extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f10254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f10255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f10256c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum a {
        AND("and"),
        OR("or");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10260a;

        a(String str) {
            this.f10260a = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f10260a;
        }
    }

    public k(List list, a aVar) {
        this.f10254a = new ArrayList(list);
        this.f10255b = aVar;
    }

    @Override // g9.q
    public String a() {
        StringBuilder sb2 = new StringBuilder();
        if (i()) {
            Iterator it = this.f10254a.iterator();
            while (it.hasNext()) {
                sb2.append(((q) it.next()).a());
            }
            return sb2.toString();
        }
        sb2.append(this.f10255b.toString() + "(");
        sb2.append(TextUtils.join(com.amazon.a.a.o.b.f.f4598a, this.f10254a));
        sb2.append(")");
        return sb2.toString();
    }

    @Override // g9.q
    public List b() {
        return Collections.unmodifiableList(this.f10254a);
    }

    @Override // g9.q
    public List c() {
        List list = this.f10256c;
        if (list != null) {
            return Collections.unmodifiableList(list);
        }
        this.f10256c = new ArrayList();
        Iterator it = this.f10254a.iterator();
        while (it.hasNext()) {
            this.f10256c.addAll(((q) it.next()).c());
        }
        return Collections.unmodifiableList(this.f10256c);
    }

    @Override // g9.q
    public boolean d(j9.h hVar) {
        if (f()) {
            Iterator it = this.f10254a.iterator();
            while (it.hasNext()) {
                if (!((q) it.next()).d(hVar)) {
                    return false;
                }
            }
            return true;
        }
        Iterator it2 = this.f10254a.iterator();
        while (it2.hasNext()) {
            if (((q) it2.next()).d(hVar)) {
                return true;
            }
        }
        return false;
    }

    public a e() {
        return this.f10255b;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof k)) {
            k kVar = (k) obj;
            if (this.f10255b == kVar.f10255b && this.f10254a.equals(kVar.f10254a)) {
                return true;
            }
        }
        return false;
    }

    public boolean f() {
        return this.f10255b == a.AND;
    }

    public boolean g() {
        return this.f10255b == a.OR;
    }

    public boolean h() {
        Iterator it = this.f10254a.iterator();
        while (it.hasNext()) {
            if (((q) it.next()) instanceof k) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return ((1147 + this.f10255b.hashCode()) * 31) + this.f10254a.hashCode();
    }

    public boolean i() {
        return h() && f();
    }

    public k j(List list) {
        ArrayList arrayList = new ArrayList(this.f10254a);
        arrayList.addAll(list);
        return new k(arrayList, this.f10255b);
    }

    public String toString() {
        return a();
    }
}
