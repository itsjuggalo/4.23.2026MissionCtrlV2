package t8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static Map a(String str) throws IOException {
        try {
            return h(new JSONObject(str));
        } catch (JSONException e10) {
            throw new IOException(e10);
        }
    }

    public static Object b(String str) throws IOException {
        try {
            return f(new JSONTokener(str).nextValue());
        } catch (JSONException e10) {
            throw new IOException(e10);
        }
    }

    public static String c(Map map) {
        return d(map);
    }

    public static String d(Object obj) throws IOException {
        if (obj == null) {
            return "null";
        }
        if (obj instanceof String) {
            return JSONObject.quote((String) obj);
        }
        if (obj instanceof Number) {
            try {
                return JSONObject.numberToString((Number) obj);
            } catch (JSONException e10) {
                throw new IOException("Could not serialize number", e10);
            }
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? com.amazon.a.a.o.b.f4545af : com.amazon.a.a.o.b.f4546ag;
        }
        try {
            JSONStringer jSONStringer = new JSONStringer();
            e(obj, jSONStringer);
            return jSONStringer.toString();
        } catch (JSONException e11) {
            throw new IOException("Failed to serialize JSON", e11);
        }
    }

    public static void e(Object obj, JSONStringer jSONStringer) throws JSONException {
        if (obj instanceof Map) {
            jSONStringer.object();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                jSONStringer.key((String) entry.getKey());
                e(entry.getValue(), jSONStringer);
            }
            jSONStringer.endObject();
            return;
        }
        if (!(obj instanceof Collection)) {
            jSONStringer.value(obj);
            return;
        }
        jSONStringer.array();
        Iterator it = ((Collection) obj).iterator();
        while (it.hasNext()) {
            e(it.next(), jSONStringer);
        }
        jSONStringer.endArray();
    }

    public static Object f(Object obj) {
        if (obj instanceof JSONObject) {
            return h((JSONObject) obj);
        }
        if (obj instanceof JSONArray) {
            return g((JSONArray) obj);
        }
        if (obj.equals(JSONObject.NULL)) {
            return null;
        }
        return obj;
    }

    public static List g(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            arrayList.add(f(jSONArray.get(i10)));
        }
        return arrayList;
    }

    public static Map h(JSONObject jSONObject) {
        HashMap map = new HashMap(jSONObject.length());
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, f(jSONObject.get(next)));
        }
        return map;
    }
}
