package f9;

import android.util.Base64;
import bb.b;
import bb.d0;
import bb.u;
import com.google.protobuf.d1;
import com.google.protobuf.s1;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import g9.a1;
import g9.b1;
import g9.p;
import io.flutter.plugins.firebase.database.Constants;
import j$.util.DesugarTimeZone;
import j9.k;
import j9.q;
import j9.r;
import j9.s;
import j9.t;
import j9.v;
import j9.y;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import m9.o0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f9430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o0 f9431b;

    public g(o0 o0Var) {
        this.f9431b = o0Var;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        this.f9430a = simpleDateFormat;
        GregorianCalendar gregorianCalendar = new GregorianCalendar(DesugarTimeZone.getTimeZone("UTC"));
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        simpleDateFormat.setCalendar(gregorianCalendar);
    }

    public static int D(String str) {
        int iCharAt = 0;
        for (int i10 = 0; i10 < 9; i10++) {
            iCharAt *= 10;
            if (i10 < str.length()) {
                if (str.charAt(i10) < '0' || str.charAt(i10) > '9') {
                    throw new IllegalArgumentException("Invalid nanoseconds: " + str);
                }
                iCharAt += str.charAt(i10) - '0';
            }
        }
        return iCharAt;
    }

    public static long z(String str) {
        int iIndexOf = str.indexOf(58);
        if (iIndexOf != -1) {
            return ((Long.parseLong(str.substring(0, iIndexOf)) * 60) + Long.parseLong(str.substring(iIndexOf + 1))) * 60;
        }
        throw new IllegalArgumentException("Invalid offset value: " + str);
    }

    public final void A(List list, JSONObject jSONObject) throws JSONException {
        q qVarJ;
        String string;
        qVarJ = j(jSONObject.getJSONObject("field"));
        string = jSONObject.getString("op");
        string.getClass();
        switch (string) {
            case "IS_NAN":
                list.add(p.e(qVarJ, p.b.EQUAL, y.f14284a));
                return;
            case "IS_NULL":
                list.add(p.e(qVarJ, p.b.EQUAL, y.f14285b));
                return;
            case "IS_NOT_NAN":
                list.add(p.e(qVarJ, p.b.NOT_EQUAL, y.f14284a));
                return;
            case "IS_NOT_NULL":
                list.add(p.e(qVarJ, p.b.NOT_EQUAL, y.f14285b));
                return;
            default:
                throw new IllegalArgumentException("Unexpected unary filter: " + string);
        }
    }

    public final d0 B(JSONObject jSONObject) {
        d0.b bVarY0 = d0.y0();
        if (jSONObject.has("nullValue")) {
            bVarY0.H(d1.NULL_VALUE);
        } else if (jSONObject.has("booleanValue")) {
            bVarY0.A(jSONObject.optBoolean("booleanValue", false));
        } else if (jSONObject.has("integerValue")) {
            bVarY0.E(jSONObject.optLong("integerValue"));
        } else if (jSONObject.has("doubleValue")) {
            bVarY0.C(jSONObject.optDouble("doubleValue"));
        } else if (jSONObject.has("timestampValue")) {
            y(bVarY0, jSONObject.get("timestampValue"));
        } else if (jSONObject.has("stringValue")) {
            bVarY0.J(jSONObject.optString("stringValue", ""));
        } else if (jSONObject.has("bytesValue")) {
            bVarY0.B(com.google.protobuf.i.r(Base64.decode(jSONObject.getString("bytesValue"), 0)));
        } else if (jSONObject.has("referenceValue")) {
            bVarY0.I(jSONObject.getString("referenceValue"));
        } else if (jSONObject.has("geoPointValue")) {
            l(bVarY0, jSONObject.getJSONObject("geoPointValue"));
        } else if (jSONObject.has("arrayValue")) {
            a(bVarY0, jSONObject.getJSONObject("arrayValue").optJSONArray("values"));
        } else {
            if (!jSONObject.has("mapValue")) {
                throw new IllegalArgumentException("Unexpected value type: " + jSONObject);
            }
            o(bVarY0, jSONObject.getJSONObject("mapValue").optJSONObject("fields"));
        }
        return (d0) bVarY0.n();
    }

    public final List C(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null) {
            k(arrayList, jSONObject);
        }
        return arrayList;
    }

    public final void E(JSONArray jSONArray) {
        if (jSONArray.length() != 1) {
            throw new IllegalArgumentException("Only queries with a single 'from' clause are supported by the Android SDK");
        }
    }

    public final void F(JSONObject jSONObject) {
        if (jSONObject.has(com.amazon.device.iap.internal.c.b.as)) {
            throw new IllegalArgumentException("Queries with offsets are not supported by the Android SDK");
        }
    }

    public final void G(JSONObject jSONObject) {
        if (jSONObject.has("select")) {
            throw new IllegalArgumentException("Queries with 'select' statements are not supported by the Android SDK");
        }
    }

    public final void a(d0.b bVar, JSONArray jSONArray) {
        b.C0055b c0055bJ0 = bb.b.j0();
        if (jSONArray != null) {
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                c0055bJ0.y(B(jSONArray.getJSONObject(i10)));
            }
        }
        bVar.y(c0055bJ0);
    }

    public e b(JSONObject jSONObject) {
        return new e(jSONObject.getString(DiagnosticsEntry.ID_KEY), jSONObject.getInt(DiagnosticsEntry.VERSION_KEY), t(jSONObject.get("createTime")), jSONObject.getInt("totalDocuments"), jSONObject.getLong("totalBytes"));
    }

    public h c(JSONObject jSONObject) {
        k kVarK = k.k(p(jSONObject.getString("name")));
        v vVarT = t(jSONObject.get("readTime"));
        boolean zOptBoolean = jSONObject.optBoolean("exists", false);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("queries");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null) {
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                arrayList.add(jSONArrayOptJSONArray.getString(i10));
            }
        }
        return new h(kVarK, vVarT, zOptBoolean, arrayList);
    }

    public final i d(JSONObject jSONObject) throws JSONException {
        String string;
        JSONObject jSONObject2 = jSONObject.getJSONObject("structuredQuery");
        G(jSONObject2);
        t tVarP = p(jSONObject.getString("parent"));
        JSONArray jSONArray = jSONObject2.getJSONArray("from");
        E(jSONArray);
        JSONObject jSONObject3 = jSONArray.getJSONObject(0);
        if (jSONObject3.optBoolean("allDescendants", false)) {
            string = jSONObject3.getString("collectionId");
        } else {
            tVarP = (t) tVarP.b(jSONObject3.getString("collectionId"));
            string = null;
        }
        t tVar = tVarP;
        String str = string;
        List listC = C(jSONObject2.optJSONObject("where"));
        List listR = r(jSONObject2.optJSONArray(Constants.ORDER_BY));
        g9.i iVarU = u(jSONObject2.optJSONObject(Constants.START_AT));
        g9.i iVarG = g(jSONObject2.optJSONObject(Constants.END_AT));
        F(jSONObject2);
        return new i(new b1(tVar, str, listC, listR, m(jSONObject2), b1.a.LIMIT_TO_FIRST, iVarU, iVarG).D(), n(jSONObject));
    }

    public final void e(List list, JSONObject jSONObject) {
        if (!jSONObject.getString("op").equals("AND")) {
            throw new IllegalArgumentException("The Android SDK only supports composite filters of type 'AND'");
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("filters");
        if (jSONArrayOptJSONArray != null) {
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                k(list, jSONArrayOptJSONArray.getJSONObject(i10));
            }
        }
    }

    public b f(JSONObject jSONObject) {
        k kVarK = k.k(p(jSONObject.getString("name")));
        v vVarT = t(jSONObject.get("updateTime"));
        d0.b bVarY0 = d0.y0();
        o(bVarY0, jSONObject.getJSONObject("fields"));
        return new b(r.p(kVarK, vVarT, s.h(bVarY0.x().d0())));
    }

    public final g9.i g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new g9.i(s(jSONObject), !jSONObject.optBoolean("before", false));
    }

    public final void h(List list, JSONObject jSONObject) {
        list.add(p.e(j(jSONObject.getJSONObject("field")), i(jSONObject.getString("op")), B(jSONObject.getJSONObject("value"))));
    }

    public final p.b i(String str) {
        return p.b.valueOf(str);
    }

    public final q j(JSONObject jSONObject) {
        return q.B(jSONObject.getString("fieldPath"));
    }

    public final void k(List list, JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("compositeFilter")) {
            e(list, jSONObject.getJSONObject("compositeFilter"));
        } else if (jSONObject.has("fieldFilter")) {
            h(list, jSONObject.getJSONObject("fieldFilter"));
        } else if (jSONObject.has("unaryFilter")) {
            A(list, jSONObject.getJSONObject("unaryFilter"));
        }
    }

    public final void l(d0.b bVar, JSONObject jSONObject) {
        bVar.D(kb.a.f0().x(jSONObject.optDouble("latitude")).y(jSONObject.optDouble("longitude")));
    }

    public final int m(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(Constants.LIMIT);
        return jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optInt("value", -1) : jSONObject.optInt(Constants.LIMIT, -1);
    }

    public final b1.a n(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("limitType", "FIRST");
        if (strOptString.equals("FIRST")) {
            return b1.a.LIMIT_TO_FIRST;
        }
        if (strOptString.equals("LAST")) {
            return b1.a.LIMIT_TO_LAST;
        }
        throw new IllegalArgumentException("Invalid limit type for bundle query: " + strOptString);
    }

    public final void o(d0.b bVar, JSONObject jSONObject) {
        u.b bVarJ0 = u.j0();
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                bVarJ0.z(next, B(jSONObject.getJSONObject(next)));
            }
        }
        bVar.F(bVarJ0);
    }

    public final t p(String str) {
        t tVarB = t.B(str);
        if (this.f9431b.c0(tVarB)) {
            return (t) tVarB.v(5);
        }
        throw new IllegalArgumentException("Resource name is not valid for current instance: " + str);
    }

    public j q(JSONObject jSONObject) {
        return new j(jSONObject.getString("name"), d(jSONObject.getJSONObject("bundledQuery")), t(jSONObject.get("readTime")));
    }

    public final List r(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                arrayList.add(a1.d(jSONObject.optString("direction", "ASCENDING").equals("ASCENDING") ? a1.a.ASCENDING : a1.a.DESCENDING, j(jSONObject.getJSONObject("field"))));
            }
        }
        return arrayList;
    }

    public final List s(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("values");
        if (jSONArrayOptJSONArray != null) {
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                arrayList.add(B(jSONArrayOptJSONArray.getJSONObject(i10)));
            }
        }
        return arrayList;
    }

    public final v t(Object obj) {
        return new v(v(obj));
    }

    public final g9.i u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new g9.i(s(jSONObject), jSONObject.optBoolean("before", false));
    }

    public final a7.s v(Object obj) {
        if (obj instanceof String) {
            return w((String) obj);
        }
        if (obj instanceof JSONObject) {
            return x((JSONObject) obj);
        }
        throw new IllegalArgumentException("Timestamps must be either ISO 8601-formatted strings or JSON objects");
    }

    public final a7.s w(String str) {
        try {
            int iIndexOf = str.indexOf(84);
            if (iIndexOf == -1) {
                throw new IllegalArgumentException("Invalid timestamp: " + str);
            }
            int iIndexOf2 = str.indexOf(90, iIndexOf);
            if (iIndexOf2 == -1) {
                iIndexOf2 = str.indexOf(43, iIndexOf);
            }
            if (iIndexOf2 == -1) {
                iIndexOf2 = str.indexOf(45, iIndexOf);
            }
            if (iIndexOf2 == -1) {
                throw new IllegalArgumentException("Invalid timestamp: Missing valid timezone offset: " + str);
            }
            int iD = 0;
            String strSubstring = str.substring(0, iIndexOf2);
            String strSubstring2 = "";
            int iIndexOf3 = strSubstring.indexOf(46);
            if (iIndexOf3 != -1) {
                String strSubstring3 = strSubstring.substring(0, iIndexOf3);
                strSubstring2 = strSubstring.substring(iIndexOf3 + 1);
                strSubstring = strSubstring3;
            }
            long time = this.f9430a.parse(strSubstring).getTime() / 1000;
            if (!strSubstring2.isEmpty()) {
                iD = D(strSubstring2);
            }
            if (str.charAt(iIndexOf2) != 'Z') {
                long jZ = z(str.substring(iIndexOf2 + 1));
                time = str.charAt(iIndexOf2) == '+' ? time - jZ : time + jZ;
            } else if (str.length() != iIndexOf2 + 1) {
                throw new IllegalArgumentException("Invalid timestamp: Invalid trailing data \"" + str.substring(iIndexOf2) + "\"");
            }
            return new a7.s(time, iD);
        } catch (ParseException e10) {
            throw new IllegalArgumentException("Failed to parse timestamp", e10);
        }
    }

    public final a7.s x(JSONObject jSONObject) {
        return new a7.s(jSONObject.optLong("seconds"), jSONObject.optInt("nanos"));
    }

    public final void y(d0.b bVar, Object obj) {
        a7.s sVarV = v(obj);
        bVar.K(s1.f0().y(sVarV.h()).x(sVarV.b()));
    }
}
