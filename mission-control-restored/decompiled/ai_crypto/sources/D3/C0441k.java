package D3;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: D3.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0441k extends AbstractC0447q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f1345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f1346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f1347c;

    /* JADX INFO: renamed from: D3.k$a */
    public enum a {
        AND("and"),
        OR("or");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1351a;

        a(String str) {
            this.f1351a = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f1351a;
        }
    }

    public C0441k(List list, a aVar) {
        this.f1345a = new ArrayList(list);
        this.f1346b = aVar;
    }

    @Override // D3.AbstractC0447q
    public String a() {
        StringBuilder sb = new StringBuilder();
        if (i()) {
            Iterator it = this.f1345a.iterator();
            while (it.hasNext()) {
                sb.append(((AbstractC0447q) it.next()).a());
            }
            return sb.toString();
        }
        sb.append(this.f1346b.toString() + "(");
        sb.append(TextUtils.join(com.amazon.a.a.o.b.f.f9989a, this.f1345a));
        sb.append(")");
        return sb.toString();
    }

    @Override // D3.AbstractC0447q
    public List b() {
        return Collections.unmodifiableList(this.f1345a);
    }

    @Override // D3.AbstractC0447q
    public List c() {
        List list = this.f1347c;
        if (list != null) {
            return Collections.unmodifiableList(list);
        }
        this.f1347c = new ArrayList();
        Iterator it = this.f1345a.iterator();
        while (it.hasNext()) {
            this.f1347c.addAll(((AbstractC0447q) it.next()).c());
        }
        return Collections.unmodifiableList(this.f1347c);
    }

    @Override // D3.AbstractC0447q
    public boolean d(G3.h hVar) {
        if (f()) {
            Iterator it = this.f1345a.iterator();
            while (it.hasNext()) {
                if (!((AbstractC0447q) it.next()).d(hVar)) {
                    return false;
                }
            }
            return true;
        }
        Iterator it2 = this.f1345a.iterator();
        while (it2.hasNext()) {
            if (((AbstractC0447q) it2.next()).d(hVar)) {
                return true;
            }
        }
        return false;
    }

    public a e() {
        return this.f1346b;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C0441k)) {
            return false;
        }
        C0441k c0441k = (C0441k) obj;
        return this.f1346b == c0441k.f1346b && this.f1345a.equals(c0441k.f1345a);
    }

    public boolean f() {
        return this.f1346b == a.AND;
    }

    public boolean g() {
        return this.f1346b == a.OR;
    }

    public boolean h() {
        Iterator it = this.f1345a.iterator();
        while (it.hasNext()) {
            if (((AbstractC0447q) it.next()) instanceof C0441k) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return ((1147 + this.f1346b.hashCode()) * 31) + this.f1345a.hashCode();
    }

    public boolean i() {
        return h() && f();
    }

    public C0441k j(List list) {
        ArrayList arrayList = new ArrayList(this.f1345a);
        arrayList.addAll(list);
        return new C0441k(arrayList, this.f1346b);
    }

    public String toString() {
        return a();
    }
}
