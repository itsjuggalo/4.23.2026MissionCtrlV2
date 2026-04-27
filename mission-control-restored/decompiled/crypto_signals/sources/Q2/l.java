package Q2;

import com.google.protobuf.C;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import s3.H0;
import s3.I;
import s3.I0;
import s3.K;

/* JADX INFO: loaded from: classes.dex */
public final class l implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public I0 f2684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f2685b;

    public l(I0 i02) {
        this.f2685b = new HashMap();
        D1.b.w("ObjectValues should be backed by a MapValue", i02.P() == 11, new Object[0]);
        D1.b.w("ServerTimestamps should not be used as an ObjectValue", !android.support.v4.media.session.a.s(i02), new Object[0]);
        this.f2684a = i02;
    }

    public static R2.f c(K k6) {
        HashSet hashSet = new HashSet();
        for (Map.Entry entry : k6.w().entrySet()) {
            j jVar = new j(Collections.singletonList((String) entry.getKey()));
            I0 i02 = (I0) entry.getValue();
            I0 i03 = o.f2689a;
            if (i02 == null || i02.P() != 11) {
                hashSet.add(jVar);
            } else {
                HashSet hashSet2 = c(((I0) entry.getValue()).L()).f2777a;
                if (hashSet2.isEmpty()) {
                    hashSet.add(jVar);
                } else {
                    Iterator it = hashSet2.iterator();
                    while (it.hasNext()) {
                        hashSet.add((j) jVar.a((j) it.next()));
                    }
                }
            }
        }
        return new R2.f(hashSet);
    }

    public static I0 d(j jVar, I0 i02) {
        if (jVar.h()) {
            return i02;
        }
        for (int i = 0; i < jVar.f2668a.size() - 1; i++) {
            i02 = i02.L().x(jVar.g(i));
            I0 i03 = o.f2689a;
            if (i02 == null || i02.P() != 11) {
                return null;
            }
        }
        return i02.L().x(jVar.f());
    }

    public static l e(Map map) {
        H0 h0R = I0.R();
        I iZ = K.z();
        iZ.d();
        K.t((K) iZ.f5636b).putAll(map);
        h0R.i(iZ);
        return new l((I0) h0R.b());
    }

    public final K a(j jVar, Map map) {
        I iZ;
        I0 i0D = d(jVar, this.f2684a);
        I0 i02 = o.f2689a;
        if (i0D == null || i0D.P() != 11) {
            iZ = K.z();
        } else {
            K kL = i0D.L();
            C c6 = (C) kL.h(5);
            if (!c6.f5635a.equals(kL)) {
                c6.d();
                C.e(c6.f5636b, kL);
            }
            iZ = (I) c6;
        }
        boolean z6 = false;
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Map) {
                K kA = a((j) jVar.b(str), (Map) value);
                if (kA != null) {
                    H0 h0R = I0.R();
                    h0R.j(kA);
                    iZ.f(str, (I0) h0R.b());
                    z6 = true;
                }
            } else {
                if (value instanceof I0) {
                    iZ.f(str, (I0) value);
                } else {
                    iZ.getClass();
                    str.getClass();
                    if (((K) iZ.f5636b).w().containsKey(str)) {
                        D1.b.w("Expected entry to be a Map, a Value or null", value == null, new Object[0]);
                        iZ.d();
                        K.t((K) iZ.f5636b).remove(str);
                    }
                }
                z6 = true;
            }
        }
        if (z6) {
            return (K) iZ.b();
        }
        return null;
    }

    public final I0 b() {
        synchronized (this.f2685b) {
            try {
                K kA = a(j.f2678c, this.f2685b);
                if (kA != null) {
                    H0 h0R = I0.R();
                    h0R.j(kA);
                    this.f2684a = (I0) h0R.b();
                    this.f2685b.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.f2684a;
    }

    public final Object clone() {
        return new l(b());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l) {
            return o.e(b(), ((l) obj).b());
        }
        return false;
    }

    public final I0 f(j jVar) {
        return d(jVar, b());
    }

    public final void g(j jVar, I0 i02) {
        D1.b.w("Cannot set field for empty path on ObjectValue", !jVar.h(), new Object[0]);
        i(jVar, i02);
    }

    public final void h(HashMap map) {
        for (Map.Entry entry : map.entrySet()) {
            j jVar = (j) entry.getKey();
            if (entry.getValue() == null) {
                D1.b.w("Cannot delete field for empty path on ObjectValue", !jVar.h(), new Object[0]);
                i(jVar, null);
            } else {
                g(jVar, (I0) entry.getValue());
            }
        }
    }

    public final int hashCode() {
        return b().hashCode();
    }

    public final void i(j jVar, I0 i02) {
        Map map;
        Map map2 = this.f2685b;
        for (int i = 0; i < jVar.f2668a.size() - 1; i++) {
            String strG = jVar.g(i);
            Object obj = map2.get(strG);
            if (obj instanceof Map) {
                map = (Map) obj;
            } else {
                if (obj instanceof I0) {
                    I0 i03 = (I0) obj;
                    if (i03.P() == 11) {
                        HashMap map3 = new HashMap(i03.L().w());
                        map2.put(strG, map3);
                        map2 = map3;
                    }
                }
                map = new HashMap();
                map2.put(strG, map);
            }
            map2 = map;
        }
        map2.put(jVar.f(), i02);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ObjectValue{internalValue=");
        I0 i0B = b();
        I0 i02 = o.f2689a;
        StringBuilder sb2 = new StringBuilder();
        o.a(sb2, i0B);
        sb.append(sb2.toString());
        sb.append('}');
        return sb.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public l() {
        H0 h0R = I0.R();
        h0R.j(K.u());
        this((I0) h0R.b());
    }
}
