package com.google.firebase.messaging;

import U3.S;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.messaging.a;
import java.util.Map;
import u.C2736a;

/* JADX INFO: loaded from: classes.dex */
public final class d extends Q1.a {
    public static final Parcelable.Creator<d> CREATOR = new S();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bundle f12219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f12220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f12221c;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f12222a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f12223b;

        public b(String str) {
            Bundle bundle = new Bundle();
            this.f12222a = bundle;
            this.f12223b = new C2736a();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("google.to", str);
                return;
            }
            throw new IllegalArgumentException("Invalid to: " + str);
        }

        public d a() {
            Bundle bundle = new Bundle();
            for (Map.Entry entry : this.f12223b.entrySet()) {
                bundle.putString((String) entry.getKey(), (String) entry.getValue());
            }
            bundle.putAll(this.f12222a);
            this.f12222a.remove("from");
            return new d(bundle);
        }

        public b b(String str) {
            this.f12222a.putString("collapse_key", str);
            return this;
        }

        public b c(Map map) {
            this.f12223b.clear();
            this.f12223b.putAll(map);
            return this;
        }

        public b d(String str) {
            this.f12222a.putString("google.message_id", str);
            return this;
        }

        public b e(String str) {
            this.f12222a.putString("message_type", str);
            return this;
        }

        public b f(int i7) {
            this.f12222a.putString("google.ttl", String.valueOf(i7));
            return this;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f12224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f12225b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String[] f12226c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f12227d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f12228e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String[] f12229f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f12230g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f12231h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f12232i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f12233j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final String f12234k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final String f12235l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final String f12236m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final Uri f12237n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final String f12238o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final Integer f12239p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final Integer f12240q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final Integer f12241r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final int[] f12242s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final Long f12243t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final boolean f12244u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final boolean f12245v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final boolean f12246w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final boolean f12247x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final boolean f12248y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public final long[] f12249z;

        public static String[] j(com.google.firebase.messaging.c cVar, String str) {
            Object[] objArrG = cVar.g(str);
            if (objArrG == null) {
                return null;
            }
            String[] strArr = new String[objArrG.length];
            for (int i7 = 0; i7 < objArrG.length; i7++) {
                strArr[i7] = String.valueOf(objArrG[i7]);
            }
            return strArr;
        }

        public String a() {
            return this.f12227d;
        }

        public String[] b() {
            return this.f12229f;
        }

        public String c() {
            return this.f12228e;
        }

        public String d() {
            return this.f12236m;
        }

        public String e() {
            return this.f12235l;
        }

        public String f() {
            return this.f12234k;
        }

        public String g() {
            return this.f12230g;
        }

        public Uri h() {
            String str = this.f12231h;
            if (str != null) {
                return Uri.parse(str);
            }
            return null;
        }

        public Uri i() {
            return this.f12237n;
        }

        public Integer k() {
            return this.f12241r;
        }

        public Integer l() {
            return this.f12239p;
        }

        public String m() {
            return this.f12232i;
        }

        public String n() {
            return this.f12233j;
        }

        public String o() {
            return this.f12238o;
        }

        public String p() {
            return this.f12224a;
        }

        public String[] q() {
            return this.f12226c;
        }

        public String r() {
            return this.f12225b;
        }

        public Integer s() {
            return this.f12240q;
        }

        public c(com.google.firebase.messaging.c cVar) {
            this.f12224a = cVar.p("gcm.n.title");
            this.f12225b = cVar.h("gcm.n.title");
            this.f12226c = j(cVar, "gcm.n.title");
            this.f12227d = cVar.p("gcm.n.body");
            this.f12228e = cVar.h("gcm.n.body");
            this.f12229f = j(cVar, "gcm.n.body");
            this.f12230g = cVar.p("gcm.n.icon");
            this.f12232i = cVar.o();
            this.f12233j = cVar.p("gcm.n.tag");
            this.f12234k = cVar.p("gcm.n.color");
            this.f12235l = cVar.p("gcm.n.click_action");
            this.f12236m = cVar.p("gcm.n.android_channel_id");
            this.f12237n = cVar.f();
            this.f12231h = cVar.p("gcm.n.image");
            this.f12238o = cVar.p("gcm.n.ticker");
            this.f12239p = cVar.b("gcm.n.notification_priority");
            this.f12240q = cVar.b("gcm.n.visibility");
            this.f12241r = cVar.b("gcm.n.notification_count");
            this.f12244u = cVar.a("gcm.n.sticky");
            this.f12245v = cVar.a("gcm.n.local_only");
            this.f12246w = cVar.a("gcm.n.default_sound");
            this.f12247x = cVar.a("gcm.n.default_vibrate_timings");
            this.f12248y = cVar.a("gcm.n.default_light_settings");
            this.f12243t = cVar.j("gcm.n.event_time");
            this.f12242s = cVar.e();
            this.f12249z = cVar.q();
        }
    }

    public d(Bundle bundle) {
        this.f12219a = bundle;
    }

    public String A() {
        return this.f12219a.getString("collapse_key");
    }

    public Map B() {
        if (this.f12220b == null) {
            this.f12220b = a.C0194a.a(this.f12219a);
        }
        return this.f12220b;
    }

    public String C() {
        return this.f12219a.getString("from");
    }

    public String D() {
        String string = this.f12219a.getString("google.message_id");
        return string == null ? this.f12219a.getString("message_id") : string;
    }

    public final int E(String str) {
        if ("high".equals(str)) {
            return 1;
        }
        return "normal".equals(str) ? 2 : 0;
    }

    public String F() {
        return this.f12219a.getString("message_type");
    }

    public c G() {
        if (this.f12221c == null && com.google.firebase.messaging.c.t(this.f12219a)) {
            this.f12221c = new c(new com.google.firebase.messaging.c(this.f12219a));
        }
        return this.f12221c;
    }

    public int H() {
        String string = this.f12219a.getString("google.original_priority");
        if (string == null) {
            string = this.f12219a.getString("google.priority");
        }
        return E(string);
    }

    public long I() {
        Object obj = this.f12219a.get("google.sent_time");
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (!(obj instanceof String)) {
            return 0L;
        }
        try {
            return Long.parseLong((String) obj);
        } catch (NumberFormatException unused) {
            Log.w("FirebaseMessaging", "Invalid sent time: " + obj);
            return 0L;
        }
    }

    public String J() {
        return this.f12219a.getString("google.to");
    }

    public int K() {
        Object obj = this.f12219a.get("google.ttl");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            Log.w("FirebaseMessaging", "Invalid TTL: " + obj);
            return 0;
        }
    }

    public void L(Intent intent) {
        intent.putExtras(this.f12219a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        S.c(this, parcel, i7);
    }
}
