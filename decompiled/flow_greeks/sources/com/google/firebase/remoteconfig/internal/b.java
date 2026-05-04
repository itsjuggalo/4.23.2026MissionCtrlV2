package com.google.firebase.remoteconfig.internal;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Date f6481h = new Date(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f6482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f6483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Date f6484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONArray f6485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f6486e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f6487f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONArray f6488g;

    /* JADX INFO: renamed from: com.google.firebase.remoteconfig.internal.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0104b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public JSONObject f6489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Date f6490b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public JSONArray f6491c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public JSONObject f6492d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f6493e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public JSONArray f6494f;

        public b a() {
            return new b(this.f6489a, this.f6490b, this.f6491c, this.f6492d, this.f6493e, this.f6494f);
        }

        public C0104b b(Map map) {
            this.f6489a = new JSONObject(map);
            return this;
        }

        public C0104b c(JSONObject jSONObject) {
            try {
                this.f6489a = new JSONObject(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public C0104b d(JSONArray jSONArray) {
            try {
                this.f6491c = new JSONArray(jSONArray.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public C0104b e(Date date) {
            this.f6490b = date;
            return this;
        }

        public C0104b f(JSONObject jSONObject) {
            try {
                this.f6492d = new JSONObject(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public C0104b g(JSONArray jSONArray) {
            try {
                this.f6494f = new JSONArray(jSONArray.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public C0104b h(long j10) {
            this.f6493e = j10;
            return this;
        }

        public C0104b() {
            this.f6489a = new JSONObject();
            this.f6490b = b.f6481h;
            this.f6491c = new JSONArray();
            this.f6492d = new JSONObject();
            this.f6493e = 0L;
            this.f6494f = new JSONArray();
        }
    }

    public static b b(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("personalization_metadata_key");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
        }
        JSONObject jSONObject2 = jSONObjectOptJSONObject;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("rollout_metadata_key");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
        }
        return new b(jSONObject.getJSONObject("configs_key"), new Date(jSONObject.getLong("fetch_time_key")), jSONObject.getJSONArray("abt_experiments_key"), jSONObject2, jSONObject.optLong("template_version_number_key"), jSONArrayOptJSONArray);
    }

    public static b d(JSONObject jSONObject) {
        return b(new JSONObject(jSONObject.toString()));
    }

    public static C0104b l() {
        return new C0104b();
    }

    public final Map c() throws JSONException {
        HashMap map = new HashMap();
        for (int i10 = 0; i10 < j().length(); i10++) {
            JSONObject jSONObject = j().getJSONObject(i10);
            String string = jSONObject.getString("rolloutId");
            String string2 = jSONObject.getString("variantId");
            JSONArray jSONArray = jSONObject.getJSONArray("affectedParameterKeys");
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                String string3 = jSONArray.getString(i11);
                if (!map.containsKey(string3)) {
                    map.put(string3, new HashMap());
                }
                Map map2 = (Map) map.get(string3);
                if (map2 != null) {
                    map2.put(string, string2);
                }
            }
        }
        return map;
    }

    public JSONArray e() {
        return this.f6485d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return this.f6482a.toString().equals(((b) obj).toString());
        }
        return false;
    }

    public Set f(b bVar) throws JSONException {
        JSONObject jSONObjectG = d(bVar.f6482a).g();
        Map mapC = c();
        Map mapC2 = bVar.c();
        HashSet hashSet = new HashSet();
        Iterator<String> itKeys = g().keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!bVar.g().has(next)) {
                hashSet.add(next);
            } else if (!g().get(next).equals(bVar.g().get(next))) {
                hashSet.add(next);
            } else if ((i().has(next) && !bVar.i().has(next)) || (!i().has(next) && bVar.i().has(next))) {
                hashSet.add(next);
            } else if (i().has(next) && bVar.i().has(next) && !i().getJSONObject(next).toString().equals(bVar.i().getJSONObject(next).toString())) {
                hashSet.add(next);
            } else if (mapC.containsKey(next) != mapC2.containsKey(next)) {
                hashSet.add(next);
            } else if (mapC.containsKey(next) && mapC2.containsKey(next) && !((Map) mapC.get(next)).equals(mapC2.get(next))) {
                hashSet.add(next);
            } else {
                jSONObjectG.remove(next);
            }
        }
        Iterator<String> itKeys2 = jSONObjectG.keys();
        while (itKeys2.hasNext()) {
            hashSet.add(itKeys2.next());
        }
        return hashSet;
    }

    public JSONObject g() {
        return this.f6483b;
    }

    public Date h() {
        return this.f6484c;
    }

    public int hashCode() {
        return this.f6482a.hashCode();
    }

    public JSONObject i() {
        return this.f6486e;
    }

    public JSONArray j() {
        return this.f6488g;
    }

    public long k() {
        return this.f6487f;
    }

    public String toString() {
        return this.f6482a.toString();
    }

    public b(JSONObject jSONObject, Date date, JSONArray jSONArray, JSONObject jSONObject2, long j10, JSONArray jSONArray2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("configs_key", jSONObject);
        jSONObject3.put("fetch_time_key", date.getTime());
        jSONObject3.put("abt_experiments_key", jSONArray);
        jSONObject3.put("personalization_metadata_key", jSONObject2);
        jSONObject3.put("template_version_number_key", j10);
        jSONObject3.put("rollout_metadata_key", jSONArray2);
        this.f6483b = jSONObject;
        this.f6484c = date;
        this.f6485d = jSONArray;
        this.f6486e = jSONObject2;
        this.f6487f = j10;
        this.f6488g = jSONArray2;
        this.f6482a = jSONObject3;
    }
}
