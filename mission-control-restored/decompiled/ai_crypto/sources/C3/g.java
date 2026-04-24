package C3;

import D3.C0439i;
import D3.C0446p;
import D3.b0;
import D3.c0;
import G3.k;
import G3.q;
import G3.r;
import G3.s;
import G3.t;
import G3.v;
import G3.y;
import J3.O;
import android.util.Base64;
import com.google.protobuf.AbstractC1240i;
import com.google.protobuf.e0;
import com.google.protobuf.t0;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import k4.C2105D;
import k4.C2111b;
import k4.C2130u;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import v4.C2767a;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f1052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final O f1053b;

    public g(O o7) {
        this.f1053b = o7;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        this.f1052a = simpleDateFormat;
        GregorianCalendar gregorianCalendar = new GregorianCalendar(DesugarTimeZone.getTimeZone("UTC"));
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        simpleDateFormat.setCalendar(gregorianCalendar);
    }

    public static int D(String str) {
        int iCharAt = 0;
        for (int i7 = 0; i7 < 9; i7++) {
            iCharAt *= 10;
            if (i7 < str.length()) {
                if (str.charAt(i7) < '0' || str.charAt(i7) > '9') {
                    throw new IllegalArgumentException("Invalid nanoseconds: " + str);
                }
                iCharAt += str.charAt(i7) - '0';
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
        string.hashCode();
        switch (string) {
            case "IS_NAN":
                list.add(C0446p.e(qVarJ, C0446p.b.EQUAL, y.f2481a));
                return;
            case "IS_NULL":
                list.add(C0446p.e(qVarJ, C0446p.b.EQUAL, y.f2482b));
                return;
            case "IS_NOT_NAN":
                list.add(C0446p.e(qVarJ, C0446p.b.NOT_EQUAL, y.f2481a));
                return;
            case "IS_NOT_NULL":
                list.add(C0446p.e(qVarJ, C0446p.b.NOT_EQUAL, y.f2482b));
                return;
            default:
                throw new IllegalArgumentException("Unexpected unary filter: " + string);
        }
    }

    public final C2105D B(JSONObject jSONObject) {
        C2105D.b bVarY0 = C2105D.y0();
        if (jSONObject.has("nullValue")) {
            bVarY0.G(e0.NULL_VALUE);
        } else if (jSONObject.has("booleanValue")) {
            bVarY0.z(jSONObject.optBoolean("booleanValue", false));
        } else if (jSONObject.has("integerValue")) {
            bVarY0.D(jSONObject.optLong("integerValue"));
        } else if (jSONObject.has("doubleValue")) {
            bVarY0.B(jSONObject.optDouble("doubleValue"));
        } else if (jSONObject.has("timestampValue")) {
            y(bVarY0, jSONObject.get("timestampValue"));
        } else if (jSONObject.has("stringValue")) {
            bVarY0.I(jSONObject.optString("stringValue", ""));
        } else if (jSONObject.has("bytesValue")) {
            bVarY0.A(AbstractC1240i.m(Base64.decode(jSONObject.getString("bytesValue"), 0)));
        } else if (jSONObject.has("referenceValue")) {
            bVarY0.H(jSONObject.getString("referenceValue"));
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
        return (C2105D) bVarY0.n();
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

    public final void a(C2105D.b bVar, JSONArray jSONArray) {
        C2111b.C0290b c0290bJ0 = C2111b.j0();
        if (jSONArray != null) {
            for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                c0290bJ0.x(B(jSONArray.getJSONObject(i7)));
            }
        }
        bVar.x(c0290bJ0);
    }

    public e b(JSONObject jSONObject) {
        return new e(jSONObject.getString(DiagnosticsEntry.ID_KEY), jSONObject.getInt(DiagnosticsEntry.VERSION_KEY), t(jSONObject.get("createTime")), jSONObject.getInt("totalDocuments"), jSONObject.getLong("totalBytes"));
    }

    public h c(JSONObject jSONObject) {
        k kVarJ = k.j(p(jSONObject.getString("name")));
        v vVarT = t(jSONObject.get("readTime"));
        boolean zOptBoolean = jSONObject.optBoolean("exists", false);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("queries");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null) {
            for (int i7 = 0; i7 < jSONArrayOptJSONArray.length(); i7++) {
                arrayList.add(jSONArrayOptJSONArray.getString(i7));
            }
        }
        return new h(kVarJ, vVarT, zOptBoolean, arrayList);
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
        List listR = r(jSONObject2.optJSONArray("orderBy"));
        C0439i c0439iU = u(jSONObject2.optJSONObject("startAt"));
        C0439i c0439iG = g(jSONObject2.optJSONObject("endAt"));
        F(jSONObject2);
        return new i(new c0(tVar, str, listC, listR, m(jSONObject2), c0.a.LIMIT_TO_FIRST, c0439iU, c0439iG).D(), n(jSONObject));
    }

    public final void e(List list, JSONObject jSONObject) {
        if (!jSONObject.getString("op").equals("AND")) {
            throw new IllegalArgumentException("The Android SDK only supports composite filters of type 'AND'");
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("filters");
        if (jSONArrayOptJSONArray != null) {
            for (int i7 = 0; i7 < jSONArrayOptJSONArray.length(); i7++) {
                k(list, jSONArrayOptJSONArray.getJSONObject(i7));
            }
        }
    }

    public b f(JSONObject jSONObject) {
        k kVarJ = k.j(p(jSONObject.getString("name")));
        v vVarT = t(jSONObject.get("updateTime"));
        C2105D.b bVarY0 = C2105D.y0();
        o(bVarY0, jSONObject.getJSONObject("fields"));
        return new b(r.q(kVarJ, vVarT, s.g(bVarY0.w().d0())));
    }

    public final C0439i g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new C0439i(s(jSONObject), !jSONObject.optBoolean("before", false));
    }

    public final void h(List list, JSONObject jSONObject) {
        list.add(C0446p.e(j(jSONObject.getJSONObject("field")), i(jSONObject.getString("op")), B(jSONObject.getJSONObject("value"))));
    }

    public final C0446p.b i(String str) {
        return C0446p.b.valueOf(str);
    }

    public final q j(JSONObject jSONObject) {
        return q.v(jSONObject.getString("fieldPath"));
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

    public final void l(C2105D.b bVar, JSONObject jSONObject) {
        bVar.C(C2767a.f0().w(jSONObject.optDouble("latitude")).x(jSONObject.optDouble("longitude")));
    }

    public final int m(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("limit");
        return jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optInt("value", -1) : jSONObject.optInt("limit", -1);
    }

    public final c0.a n(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("limitType", "FIRST");
        if (strOptString.equals("FIRST")) {
            return c0.a.LIMIT_TO_FIRST;
        }
        if (strOptString.equals("LAST")) {
            return c0.a.LIMIT_TO_LAST;
        }
        throw new IllegalArgumentException("Invalid limit type for bundle query: " + strOptString);
    }

    public final void o(C2105D.b bVar, JSONObject jSONObject) {
        C2130u.b bVarJ0 = C2130u.j0();
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                bVarJ0.y(next, B(jSONObject.getJSONObject(next)));
            }
        }
        bVar.E(bVarJ0);
    }

    public final t p(String str) {
        t tVarV = t.v(str);
        if (this.f1053b.c0(tVarV)) {
            return (t) tVarV.r(5);
        }
        throw new IllegalArgumentException("Resource name is not valid for current instance: " + str);
    }

    public j q(JSONObject jSONObject) {
        return new j(jSONObject.getString("name"), d(jSONObject.getJSONObject("bundledQuery")), t(jSONObject.get("readTime")));
    }

    public final List r(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i7);
                arrayList.add(b0.d(jSONObject.optString("direction", "ASCENDING").equals("ASCENDING") ? b0.a.ASCENDING : b0.a.DESCENDING, j(jSONObject.getJSONObject("field"))));
            }
        }
        return arrayList;
    }

    public final List s(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("values");
        if (jSONArrayOptJSONArray != null) {
            for (int i7 = 0; i7 < jSONArrayOptJSONArray.length(); i7++) {
                arrayList.add(B(jSONArrayOptJSONArray.getJSONObject(i7)));
            }
        }
        return arrayList;
    }

    public final v t(Object obj) {
        return new v(v(obj));
    }

    public final C0439i u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new C0439i(s(jSONObject), jSONObject.optBoolean("before", false));
    }

    public final Q2.s v(Object obj) {
        if (obj instanceof String) {
            return w((String) obj);
        }
        if (obj instanceof JSONObject) {
            return x((JSONObject) obj);
        }
        throw new IllegalArgumentException("Timestamps must be either ISO 8601-formatted strings or JSON objects");
    }

    public final Q2.s w(String str) {
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
            long time = this.f1052a.parse(strSubstring).getTime() / 1000;
            if (!strSubstring2.isEmpty()) {
                iD = D(strSubstring2);
            }
            if (str.charAt(iIndexOf2) != 'Z') {
                long jZ = z(str.substring(iIndexOf2 + 1));
                time = str.charAt(iIndexOf2) == '+' ? time - jZ : time + jZ;
            } else if (str.length() != iIndexOf2 + 1) {
                throw new IllegalArgumentException("Invalid timestamp: Invalid trailing data \"" + str.substring(iIndexOf2) + "\"");
            }
            return new Q2.s(time, iD);
        } catch (ParseException e7) {
            throw new IllegalArgumentException("Failed to parse timestamp", e7);
        }
    }

    public final Q2.s x(JSONObject jSONObject) {
        return new Q2.s(jSONObject.optLong("seconds"), jSONObject.optInt("nanos"));
    }

    public final void y(C2105D.b bVar, Object obj) {
        Q2.s sVarV = v(obj);
        bVar.J(t0.f0().x(sVarV.h()).w(sVarV.c()));
    }
}
