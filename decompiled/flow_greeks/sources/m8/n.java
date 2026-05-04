package m8;

import j8.d0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import r8.o;
import r8.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f16114a = Pattern.compile("[\\[\\]\\.#$]");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f16115b = Pattern.compile("[\\[\\]\\.#\\$\\/\\u0000-\\u001F\\u007F]");

    public static boolean a(String str) {
        return str.equals(".info") || !f16115b.matcher(str).find() || str.equals(r8.b.k().b()) || str.equals(r8.b.l().b());
    }

    public static boolean b(String str) {
        return !f16114a.matcher(str).find();
    }

    public static boolean c(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        if (str.equals(".value") || str.equals(".priority")) {
            return true;
        }
        return (str.startsWith(".") || f16115b.matcher(str).find()) ? false : true;
    }

    public static boolean d(j8.l lVar) {
        r8.b bVarK = lVar.K();
        return bVarK == null || !bVarK.b().startsWith(".");
    }

    public static Map e(j8.l lVar, Map map) {
        TreeMap treeMap = new TreeMap();
        for (Map.Entry entry : map.entrySet()) {
            j8.l lVar2 = new j8.l((String) entry.getKey());
            Object value = entry.getValue();
            d0.g(lVar.u(lVar2), value);
            String strB = !lVar2.isEmpty() ? lVar2.A().b() : "";
            if (strB.equals(".sv") || strB.equals(".value")) {
                throw new e8.d("Path '" + lVar2 + "' contains disallowed child name: " + strB);
            }
            r8.n nVarC = strB.equals(".priority") ? r.c(lVar2, value) : o.a(value);
            k(value);
            treeMap.put(lVar2, nVarC);
        }
        j8.l lVar3 = null;
        for (j8.l lVar4 : treeMap.keySet()) {
            m.f(lVar3 == null || lVar3.compareTo(lVar4) < 0);
            if (lVar3 != null && lVar3.y(lVar4)) {
                throw new e8.d("Path '" + lVar3 + "' is an ancestor of '" + lVar4 + "' in an update.");
            }
            lVar3 = lVar4;
        }
        return treeMap;
    }

    public static void f(double d10) {
        if (Double.isInfinite(d10) || Double.isNaN(d10)) {
            throw new e8.d("Invalid value: Value cannot be NaN, Inf or -Inf.");
        }
    }

    public static void g(String str) {
        if (str == null || a(str)) {
            return;
        }
        throw new e8.d("Invalid key: " + str + ". Keys must not contain '/', '.', '#', '$', '[', or ']'");
    }

    public static void h(String str) {
        if (b(str)) {
            return;
        }
        throw new e8.d("Invalid Firebase Database path: " + str + ". Firebase Database paths must not contain '.', '#', '$', '[', or ']'");
    }

    public static void i(String str) {
        if (str.startsWith(".info")) {
            h(str.substring(5));
        } else if (str.startsWith("/.info")) {
            h(str.substring(6));
        } else {
            h(str);
        }
    }

    public static void j(String str) {
        if (c(str)) {
            return;
        }
        throw new e8.d("Invalid key: " + str + ". Keys must not contain '/', '.', '#', '$', '[', or ']'");
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

    public static void l(j8.l lVar) {
        if (d(lVar)) {
            return;
        }
        throw new e8.d("Invalid write location: " + lVar.toString());
    }
}
