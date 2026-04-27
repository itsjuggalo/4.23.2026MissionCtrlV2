package com.google.firebase.storage;

import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f12462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C1220f f12463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p f12464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f12465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f12466e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f12467f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f12468g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f12469h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f12470i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f12471j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f12472k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c f12473l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public c f12474m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public c f12475n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public c f12476o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public c f12477p;

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f12480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f12481b;

        public c(Object obj, boolean z7) {
            this.f12480a = z7;
            this.f12481b = obj;
        }

        public static c c(Object obj) {
            return new c(obj, false);
        }

        public static c d(Object obj) {
            return new c(obj, true);
        }

        public Object a() {
            return this.f12481b;
        }

        public boolean b() {
            return this.f12480a;
        }
    }

    public String A() {
        return this.f12466e;
    }

    public String B() {
        return this.f12472k;
    }

    public String C() {
        return this.f12468g;
    }

    public String D() {
        String strE = E();
        if (TextUtils.isEmpty(strE)) {
            return null;
        }
        int iLastIndexOf = strE.lastIndexOf(47);
        return iLastIndexOf != -1 ? strE.substring(iLastIndexOf + 1) : strE;
    }

    public String E() {
        String str = this.f12462a;
        return str != null ? str : "";
    }

    public long F() {
        return this.f12471j;
    }

    public long G() {
        return e4.i.e(this.f12470i);
    }

    public JSONObject q() {
        HashMap map = new HashMap();
        if (this.f12467f.b()) {
            map.put("contentType", w());
        }
        if (this.f12477p.b()) {
            map.put("metadata", new JSONObject((Map) this.f12477p.a()));
        }
        if (this.f12473l.b()) {
            map.put("cacheControl", s());
        }
        if (this.f12474m.b()) {
            map.put("contentDisposition", t());
        }
        if (this.f12475n.b()) {
            map.put("contentEncoding", u());
        }
        if (this.f12476o.b()) {
            map.put("contentLanguage", v());
        }
        return new JSONObject(map);
    }

    public String r() {
        return this.f12465d;
    }

    public String s() {
        return (String) this.f12473l.a();
    }

    public String t() {
        return (String) this.f12474m.a();
    }

    public String u() {
        return (String) this.f12475n.a();
    }

    public String v() {
        return (String) this.f12476o.a();
    }

    public String w() {
        return (String) this.f12467f.a();
    }

    public long x() {
        return e4.i.e(this.f12469h);
    }

    public String y(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (String) ((Map) this.f12477p.a()).get(str);
    }

    public Set z() {
        return ((Map) this.f12477p.a()).keySet();
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public o f12478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f12479b;

        public b() {
            this.f12478a = new o();
        }

        public o a() {
            return new o(this.f12479b);
        }

        public final String b(JSONObject jSONObject, String str) {
            if (!jSONObject.has(str) || jSONObject.isNull(str)) {
                return null;
            }
            return jSONObject.getString(str);
        }

        public final void c(JSONObject jSONObject) throws JSONException {
            this.f12478a.f12466e = jSONObject.optString("generation");
            this.f12478a.f12462a = jSONObject.optString("name");
            this.f12478a.f12465d = jSONObject.optString("bucket");
            this.f12478a.f12468g = jSONObject.optString("metageneration");
            this.f12478a.f12469h = jSONObject.optString("timeCreated");
            this.f12478a.f12470i = jSONObject.optString("updated");
            this.f12478a.f12471j = jSONObject.optLong("size");
            this.f12478a.f12472k = jSONObject.optString("md5Hash");
            if (jSONObject.has("metadata") && !jSONObject.isNull("metadata")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("metadata");
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    i(next, jSONObject2.getString(next));
                }
            }
            String strB = b(jSONObject, "contentType");
            if (strB != null) {
                h(strB);
            }
            String strB2 = b(jSONObject, "cacheControl");
            if (strB2 != null) {
                d(strB2);
            }
            String strB3 = b(jSONObject, "contentDisposition");
            if (strB3 != null) {
                e(strB3);
            }
            String strB4 = b(jSONObject, "contentEncoding");
            if (strB4 != null) {
                f(strB4);
            }
            String strB5 = b(jSONObject, "contentLanguage");
            if (strB5 != null) {
                g(strB5);
            }
        }

        public b d(String str) {
            this.f12478a.f12473l = c.d(str);
            return this;
        }

        public b e(String str) {
            this.f12478a.f12474m = c.d(str);
            return this;
        }

        public b f(String str) {
            this.f12478a.f12475n = c.d(str);
            return this;
        }

        public b g(String str) {
            this.f12478a.f12476o = c.d(str);
            return this;
        }

        public b h(String str) {
            this.f12478a.f12467f = c.d(str);
            return this;
        }

        public b i(String str, String str2) {
            if (!this.f12478a.f12477p.b()) {
                this.f12478a.f12477p = c.d(new HashMap());
            }
            ((Map) this.f12478a.f12477p.a()).put(str, str2);
            return this;
        }

        public b(JSONObject jSONObject, p pVar) {
            this(jSONObject);
            this.f12478a.f12464c = pVar;
        }

        public b(JSONObject jSONObject) throws JSONException {
            this.f12478a = new o();
            if (jSONObject != null) {
                c(jSONObject);
                this.f12479b = true;
            }
        }
    }

    public o() {
        this.f12462a = null;
        this.f12463b = null;
        this.f12464c = null;
        this.f12465d = null;
        this.f12466e = null;
        this.f12467f = c.c("");
        this.f12468g = null;
        this.f12469h = null;
        this.f12470i = null;
        this.f12472k = null;
        this.f12473l = c.c("");
        this.f12474m = c.c("");
        this.f12475n = c.c("");
        this.f12476o = c.c("");
        this.f12477p = c.c(Collections.emptyMap());
    }

    public o(o oVar, boolean z7) {
        this.f12462a = null;
        this.f12463b = null;
        this.f12464c = null;
        this.f12465d = null;
        this.f12466e = null;
        this.f12467f = c.c("");
        this.f12468g = null;
        this.f12469h = null;
        this.f12470i = null;
        this.f12472k = null;
        this.f12473l = c.c("");
        this.f12474m = c.c("");
        this.f12475n = c.c("");
        this.f12476o = c.c("");
        this.f12477p = c.c(Collections.emptyMap());
        AbstractC1207s.k(oVar);
        this.f12462a = oVar.f12462a;
        this.f12463b = oVar.f12463b;
        this.f12464c = oVar.f12464c;
        this.f12465d = oVar.f12465d;
        this.f12467f = oVar.f12467f;
        this.f12473l = oVar.f12473l;
        this.f12474m = oVar.f12474m;
        this.f12475n = oVar.f12475n;
        this.f12476o = oVar.f12476o;
        this.f12477p = oVar.f12477p;
        if (z7) {
            this.f12472k = oVar.f12472k;
            this.f12471j = oVar.f12471j;
            this.f12470i = oVar.f12470i;
            this.f12469h = oVar.f12469h;
            this.f12468g = oVar.f12468g;
            this.f12466e = oVar.f12466e;
        }
    }
}
