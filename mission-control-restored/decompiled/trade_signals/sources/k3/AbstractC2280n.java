package k3;

import h3.C1859C;
import h3.C1875k;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import p3.AbstractC2561o;
import p3.AbstractC2564r;
import p3.C2548b;
import p3.InterfaceC2560n;

/* JADX INFO: renamed from: k3.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2280n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f20389a = Pattern.compile("[\\[\\]\\.#$]");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f20390b = Pattern.compile("[\\[\\]\\.#\\$\\/\\u0000-\\u001F\\u007F]");

    public static boolean a(String str) {
        return str.equals(".info") || !f20390b.matcher(str).find() || str.equals(C2548b.l().b()) || str.equals(C2548b.m().b());
    }

    public static boolean b(String str) {
        return !f20389a.matcher(str).find();
    }

    public static boolean c(String str) {
        return str != null && str.length() > 0 && (str.equals(".value") || str.equals(".priority") || !(str.startsWith(".") || f20390b.matcher(str).find()));
    }

    public static boolean d(C1875k c1875k) {
        C2548b c2548bP = c1875k.P();
        return c2548bP == null || !c2548bP.b().startsWith(".");
    }

    public static Map e(C1875k c1875k, Map map) {
        TreeMap treeMap = new TreeMap();
        for (Map.Entry entry : map.entrySet()) {
            C1875k c1875k2 = new C1875k((String) entry.getKey());
            Object value = entry.getValue();
            C1859C.g(c1875k.J(c1875k2), value);
            String strB = !c1875k2.isEmpty() ? c1875k2.N().b() : "";
            if (strB.equals(".sv") || strB.equals(".value")) {
                throw new c3.d("Path '" + c1875k2 + "' contains disallowed child name: " + strB);
            }
            InterfaceC2560n interfaceC2560nC = strB.equals(".priority") ? AbstractC2564r.c(c1875k2, value) : AbstractC2561o.a(value);
            k(value);
            treeMap.put(c1875k2, interfaceC2560nC);
        }
        C1875k c1875k3 = null;
        for (C1875k c1875k4 : treeMap.keySet()) {
            AbstractC2279m.f(c1875k3 == null || c1875k3.compareTo(c1875k4) < 0);
            if (c1875k3 != null && c1875k3.M(c1875k4)) {
                throw new c3.d("Path '" + c1875k3 + "' is an ancestor of '" + c1875k4 + "' in an update.");
            }
            c1875k3 = c1875k4;
        }
        return treeMap;
    }

    public static void f(double d8) {
        if (Double.isInfinite(d8) || Double.isNaN(d8)) {
            throw new c3.d("Invalid value: Value cannot be NaN, Inf or -Inf.");
        }
    }

    public static void g(String str) {
        if (str == null || a(str)) {
            return;
        }
        throw new c3.d("Invalid key: " + str + ". Keys must not contain '/', '.', '#', '$', '[', or ']'");
    }

    public static void h(String str) {
        if (b(str)) {
            return;
        }
        throw new c3.d("Invalid Firebase Database path: " + str + ". Firebase Database paths must not contain '.', '#', '$', '[', or ']'");
    }

    public static void i(String str) {
        int i8;
        if (!str.startsWith(".info")) {
            i8 = str.startsWith("/.info") ? 6 : 5;
            h(str);
        }
        str = str.substring(i8);
        h(str);
    }

    public static void j(String str) {
        if (c(str)) {
            return;
        }
        throw new c3.d("Invalid key: " + str + ". Keys must not contain '/', '.', '#', '$', '[', or ']'");
    }

    public static void k(Object obj) {
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.containsKey(".sv")) {
                return;
            }
            for (Map.Entry entry : map.entrySet()) {
                j((String) entry.getKey());
                k(entry.getValue());
            }
            return;
        }
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                k(it.next());
            }
        } else if ((obj instanceof Double) || (obj instanceof Float)) {
            f(((Double) obj).doubleValue());
        }
    }

    public static void l(C1875k c1875k) {
        if (d(c1875k)) {
            return;
        }
        throw new c3.d("Invalid write location: " + c1875k.toString());
    }
}
