package m3;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f15784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Map f15785d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f15786d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Map f15787e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f15788a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map f15789b = f15787e;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f15790c = true;

        static {
            String strG = g();
            f15786d = strG;
            HashMap map = new HashMap(2);
            if (!TextUtils.isEmpty(strG)) {
                map.put("User-Agent", Collections.singletonList(new b(strG)));
            }
            f15787e = Collections.unmodifiableMap(map);
        }

        public static String g() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb2 = new StringBuilder(property.length());
            for (int i10 = 0; i10 < length; i10++) {
                char cCharAt = property.charAt(i10);
                if ((cCharAt > 31 || cCharAt == '\t') && cCharAt < 127) {
                    sb2.append(cCharAt);
                } else {
                    sb2.append('?');
                }
            }
            return sb2.toString();
        }

        public a a(String str, String str2) {
            return b(str, new b(str2));
        }

        public a b(String str, j jVar) {
            if (this.f15790c && "User-Agent".equalsIgnoreCase(str)) {
                return h(str, jVar);
            }
            e();
            f(str).add(jVar);
            return this;
        }

        public k c() {
            this.f15788a = true;
            return new k(this.f15789b);
        }

        public final Map d() {
            HashMap map = new HashMap(this.f15789b.size());
            for (Map.Entry entry : this.f15789b.entrySet()) {
                map.put((String) entry.getKey(), new ArrayList((Collection) entry.getValue()));
            }
            return map;
        }

        public final void e() {
            if (this.f15788a) {
                this.f15788a = false;
                this.f15789b = d();
            }
        }

        public final List f(String str) {
            List list = (List) this.f15789b.get(str);
            if (list != null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            this.f15789b.put(str, arrayList);
            return arrayList;
        }

        public a h(String str, j jVar) {
            e();
            if (jVar == null) {
                this.f15789b.remove(str);
            } else {
                List listF = f(str);
                listF.clear();
                listF.add(jVar);
            }
            if (this.f15790c && "User-Agent".equalsIgnoreCase(str)) {
                this.f15790c = false;
            }
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f15791a;

        public b(String str) {
            this.f15791a = str;
        }

        @Override // m3.j
        public String a() {
            return this.f15791a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f15791a.equals(((b) obj).f15791a);
            }
            return false;
        }

        public int hashCode() {
            return this.f15791a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f15791a + "'}";
        }
    }

    public k(Map map) {
        this.f15784c = Collections.unmodifiableMap(map);
    }

    @Override // m3.i
    public Map a() {
        if (this.f15785d == null) {
            synchronized (this) {
                try {
                    if (this.f15785d == null) {
                        this.f15785d = Collections.unmodifiableMap(c());
                    }
                } finally {
                }
            }
        }
        return this.f15785d;
    }

    public final String b(List list) {
        StringBuilder sb2 = new StringBuilder();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            String strA = ((j) list.get(i10)).a();
            if (!TextUtils.isEmpty(strA)) {
                sb2.append(strA);
                if (i10 != list.size() - 1) {
                    sb2.append(',');
                }
            }
        }
        return sb2.toString();
    }

    public final Map c() {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f15784c.entrySet()) {
            String strB = b((List) entry.getValue());
            if (!TextUtils.isEmpty(strB)) {
                map.put((String) entry.getKey(), strB);
            }
        }
        return map;
    }

    public boolean equals(Object obj) {
        if (obj instanceof k) {
            return this.f15784c.equals(((k) obj).f15784c);
        }
        return false;
    }

    public int hashCode() {
        return this.f15784c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f15784c + '}';
    }
}
