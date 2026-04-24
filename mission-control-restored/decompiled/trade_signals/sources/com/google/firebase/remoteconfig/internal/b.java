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

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Date f15828h = new Date(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f15829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f15830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Date f15831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONArray f15832d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f15833e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f15834f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONArray f15835g;

    /* JADX INFO: renamed from: com.google.firebase.remoteconfig.internal.b$b, reason: collision with other inner class name */
    public static class C0254b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public JSONObject f15836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Date f15837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public JSONArray f15838c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public JSONObject f15839d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f15840e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public JSONArray f15841f;

        public C0254b() {
            this.f15836a = new JSONObject();
            this.f15837b = b.f15828h;
            this.f15838c = new JSONArray();
            this.f15839d = new JSONObject();
            this.f15840e = 0L;
            this.f15841f = new JSONArray();
        }

        public b a() {
            return new b(this.f15836a, this.f15837b, this.f15838c, this.f15839d, this.f15840e, this.f15841f);
        }

        public C0254b b(Map map) {
            this.f15836a = new JSONObject(map);
            return this;
        }

        public C0254b c(JSONObject jSONObject) {
            try {
                this.f15836a = new JSONObject(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public C0254b d(JSONArray jSONArray) {
            try {
                this.f15838c = new JSONArray(jSONArray.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public C0254b e(Date date) {
            this.f15837b = date;
            return this;
        }

        public C0254b f(JSONObject jSONObject) {
            try {
                this.f15839d = new JSONObject(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public C0254b g(JSONArray jSONArray) {
            try {
                this.f15841f = new JSONArray(jSONArray.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public C0254b h(long j8) {
            this.f15840e = j8;
            return this;
        }
    }

    public b(JSONObject jSONObject, Date date, JSONArray jSONArray, JSONObject jSONObject2, long j8, JSONArray jSONArray2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("configs_key", jSONObject);
        jSONObject3.put("fetch_time_key", date.getTime());
        jSONObject3.put("abt_experiments_key", jSONArray);
        jSONObject3.put("personalization_metadata_key", jSONObject2);
        jSONObject3.put("template_version_number_key", j8);
        jSONObject3.put("rollout_metadata_key", jSONArray2);
        this.f15830b = jSONObject;
        this.f15831c = date;
        this.f15832d = jSONArray;
        this.f15833e = jSONObject2;
        this.f15834f = j8;
        this.f15835g = jSONArray2;
        this.f15829a = jSONObject3;
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

    public static C0254b l() {
        return new C0254b();
    }

    public final Map c() throws JSONException {
        HashMap map = new HashMap();
        for (int i8 = 0; i8 < j().length(); i8++) {
            JSONObject jSONObject = j().getJSONObject(i8);
            String string = jSONObject.getString("rolloutId");
            String string2 = jSONObject.getString("variantId");
            JSONArray jSONArray = jSONObject.getJSONArray("affectedParameterKeys");
            for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                String string3 = jSONArray.getString(i9);
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
        return this.f15832d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return this.f15829a.toString().equals(((b) obj).toString());
        }
        return false;
    }

    public Set f(b bVar) throws JSONException {
        JSONObject jSONObjectG = d(bVar.f15829a).g();
        Map mapC = c();
        Map mapC2 = bVar.c();
        HashSet hashSet = new HashSet();
        Iterator<String> itKeys = g().keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (bVar.g().has(next) && g().get(next).equals(bVar.g().get(next)) && ((!i().has(next) || bVar.i().has(next)) && ((i().has(next) || !bVar.i().has(next)) && !((i().has(next) && bVar.i().has(next) && !i().getJSONObject(next).toString().equals(bVar.i().getJSONObject(next).toString())) || mapC.containsKey(next) != mapC2.containsKey(next) || (mapC.containsKey(next) && mapC2.containsKey(next) && !((Map) mapC.get(next)).equals(mapC2.get(next))))))) {
                jSONObjectG.remove(next);
            } else {
                hashSet.add(next);
            }
        }
        Iterator<String> itKeys2 = jSONObjectG.keys();
        while (itKeys2.hasNext()) {
            hashSet.add(itKeys2.next());
        }
        return hashSet;
    }

    public JSONObject g() {
        return this.f15830b;
    }

    public Date h() {
        return this.f15831c;
    }

    public int hashCode() {
        return this.f15829a.hashCode();
    }

    public JSONObject i() {
        return this.f15833e;
    }

    public JSONArray j() {
        return this.f15835g;
    }

    public long k() {
        return this.f15834f;
    }

    public String toString() {
        return this.f15829a.toString();
    }
}
