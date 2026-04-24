package a1;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: a1.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1051k implements InterfaceC1049i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f9846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Map f9847d;

    /* JADX INFO: renamed from: a1.k$a */
    public static final class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f9848d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Map f9849e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f9850a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map f9851b = f9849e;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f9852c = true;

        static {
            String strG = g();
            f9848d = strG;
            HashMap map = new HashMap(2);
            if (!TextUtils.isEmpty(strG)) {
                map.put("User-Agent", Collections.singletonList(new b(strG)));
            }
            f9849e = Collections.unmodifiableMap(map);
        }

        public static String g() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i8 = 0; i8 < length; i8++) {
                char cCharAt = property.charAt(i8);
                if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= 127) {
                    cCharAt = '?';
                }
                sb.append(cCharAt);
            }
            return sb.toString();
        }

        public a a(String str, InterfaceC1050j interfaceC1050j) {
            if (this.f9852c && "User-Agent".equalsIgnoreCase(str)) {
                return h(str, interfaceC1050j);
            }
            e();
            f(str).add(interfaceC1050j);
            return this;
        }

        public a b(String str, String str2) {
            return a(str, new b(str2));
        }

        public C1051k c() {
            this.f9850a = true;
            return new C1051k(this.f9851b);
        }

        public final Map d() {
            HashMap map = new HashMap(this.f9851b.size());
            for (Map.Entry entry : this.f9851b.entrySet()) {
                map.put(entry.getKey(), new ArrayList((Collection) entry.getValue()));
            }
            return map;
        }

        public final void e() {
            if (this.f9850a) {
                this.f9850a = false;
                this.f9851b = d();
            }
        }

        public final List f(String str) {
            List list = (List) this.f9851b.get(str);
            if (list != null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            this.f9851b.put(str, arrayList);
            return arrayList;
        }

        public a h(String str, InterfaceC1050j interfaceC1050j) {
            e();
            if (interfaceC1050j == null) {
                this.f9851b.remove(str);
            } else {
                List listF = f(str);
                listF.clear();
                listF.add(interfaceC1050j);
            }
            if (this.f9852c && "User-Agent".equalsIgnoreCase(str)) {
                this.f9852c = false;
            }
            return this;
        }
    }

    /* JADX INFO: renamed from: a1.k$b */
    public static final class b implements InterfaceC1050j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f9853a;

        public b(String str) {
            this.f9853a = str;
        }

        @Override // a1.InterfaceC1050j
        public String a() {
            return this.f9853a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f9853a.equals(((b) obj).f9853a);
            }
            return false;
        }

        public int hashCode() {
            return this.f9853a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f9853a + "'}";
        }
    }

    public C1051k(Map map) {
        this.f9846c = Collections.unmodifiableMap(map);
    }

    @Override // a1.InterfaceC1049i
    public Map a() {
        if (this.f9847d == null) {
            synchronized (this) {
                try {
                    if (this.f9847d == null) {
                        this.f9847d = Collections.unmodifiableMap(c());
                    }
                } finally {
                }
            }
        }
        return this.f9847d;
    }

    public final String b(List list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            String strA = ((InterfaceC1050j) list.get(i8)).a();
            if (!TextUtils.isEmpty(strA)) {
                sb.append(strA);
                if (i8 != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    public final Map c() {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f9846c.entrySet()) {
            String strB = b((List) entry.getValue());
            if (!TextUtils.isEmpty(strB)) {
                map.put(entry.getKey(), strB);
            }
        }
        return map;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1051k) {
            return this.f9846c.equals(((C1051k) obj).f9846c);
        }
        return false;
    }

    public int hashCode() {
        return this.f9846c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f9846c + '}';
    }
}
