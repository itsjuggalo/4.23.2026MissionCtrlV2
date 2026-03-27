package A4;

import V4.j;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c extends A4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f256b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f257c;

    public class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f259b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f260c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f261d;

        public a() {
        }

        @Override // A4.f
        public void a(Object obj) {
            this.f258a = obj;
        }

        @Override // A4.f
        public void b(String str, String str2, Object obj) {
            this.f259b = str;
            this.f260c = str2;
            this.f261d = obj;
        }
    }

    public c(Map map, boolean z7) {
        this.f255a = map;
        this.f257c = z7;
    }

    @Override // A4.e
    public Object c(String str) {
        return this.f255a.get(str);
    }

    @Override // A4.b, A4.e
    public boolean e() {
        return this.f257c;
    }

    @Override // A4.e
    public String h() {
        return (String) this.f255a.get("method");
    }

    @Override // A4.e
    public boolean i(String str) {
        return this.f255a.containsKey(str);
    }

    @Override // A4.a
    public f o() {
        return this.f256b;
    }

    public Map p() {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        map2.put("code", this.f256b.f259b);
        map2.put("message", this.f256b.f260c);
        map2.put("data", this.f256b.f261d);
        map.put("error", map2);
        return map;
    }

    public Map q() {
        HashMap map = new HashMap();
        map.put("result", this.f256b.f258a);
        return map;
    }

    public void r(j.d dVar) {
        a aVar = this.f256b;
        dVar.b(aVar.f259b, aVar.f260c, aVar.f261d);
    }

    public void s(List list) {
        if (e()) {
            return;
        }
        list.add(p());
    }

    public void t(List list) {
        if (e()) {
            return;
        }
        list.add(q());
    }
}
