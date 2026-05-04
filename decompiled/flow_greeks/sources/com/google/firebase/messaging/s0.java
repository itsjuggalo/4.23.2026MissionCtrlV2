package com.google.firebase.messaging;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.messaging.e;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class s0 extends n5.a {
    public static final Parcelable.Creator<s0> CREATOR = new t0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bundle f6400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f6401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f6402c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f6403a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f6404b;

        public b(String str) {
            Bundle bundle = new Bundle();
            this.f6403a = bundle;
            this.f6404b = new w.a();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("google.to", str);
                return;
            }
            throw new IllegalArgumentException("Invalid to: " + str);
        }

        public s0 a() {
            Bundle bundle = new Bundle();
            for (Map.Entry entry : this.f6404b.entrySet()) {
                bundle.putString((String) entry.getKey(), (String) entry.getValue());
            }
            bundle.putAll(this.f6403a);
            this.f6403a.remove("from");
            return new s0(bundle);
        }

        public b b(String str) {
            this.f6403a.putString("collapse_key", str);
            return this;
        }

        public b c(Map map) {
            this.f6404b.clear();
            this.f6404b.putAll(map);
            return this;
        }

        public b d(String str) {
            this.f6403a.putString("google.message_id", str);
            return this;
        }

        public b e(String str) {
            this.f6403a.putString("message_type", str);
            return this;
        }

        public b f(int i10) {
            this.f6403a.putString("google.ttl", String.valueOf(i10));
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f6405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f6406b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String[] f6407c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f6408d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f6409e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String[] f6410f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f6411g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f6412h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f6413i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f6414j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final String f6415k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final String f6416l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final String f6417m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final Uri f6418n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final String f6419o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final Integer f6420p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final Integer f6421q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final Integer f6422r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final int[] f6423s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final Long f6424t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final boolean f6425u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final boolean f6426v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final boolean f6427w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final boolean f6428x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final boolean f6429y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public final long[] f6430z;

        public static String[] j(m0 m0Var, String str) {
            Object[] objArrG = m0Var.g(str);
            if (objArrG == null) {
                return null;
            }
            String[] strArr = new String[objArrG.length];
            for (int i10 = 0; i10 < objArrG.length; i10++) {
                strArr[i10] = String.valueOf(objArrG[i10]);
            }
            return strArr;
        }

        public String a() {
            return this.f6408d;
        }

        public String[] b() {
            return this.f6410f;
        }

        public String c() {
            return this.f6409e;
        }

        public String d() {
            return this.f6417m;
        }

        public String e() {
            return this.f6416l;
        }

        public String f() {
            return this.f6415k;
        }

        public String g() {
            return this.f6411g;
        }

        public Uri h() {
            String str = this.f6412h;
            if (str != null) {
                return Uri.parse(str);
            }
            return null;
        }

        public Uri i() {
            return this.f6418n;
        }

        public Integer k() {
            return this.f6422r;
        }

        public Integer l() {
            return this.f6420p;
        }

        public String m() {
            return this.f6413i;
        }

        public String n() {
            return this.f6414j;
        }

        public String o() {
            return this.f6419o;
        }

        public String p() {
            return this.f6405a;
        }

        public String[] q() {
            return this.f6407c;
        }

        public String r() {
            return this.f6406b;
        }

        public Integer s() {
            return this.f6421q;
        }

        public c(m0 m0Var) {
            this.f6405a = m0Var.p("gcm.n.title");
            this.f6406b = m0Var.h("gcm.n.title");
            this.f6407c = j(m0Var, "gcm.n.title");
            this.f6408d = m0Var.p("gcm.n.body");
            this.f6409e = m0Var.h("gcm.n.body");
            this.f6410f = j(m0Var, "gcm.n.body");
            this.f6411g = m0Var.p("gcm.n.icon");
            this.f6413i = m0Var.o();
            this.f6414j = m0Var.p("gcm.n.tag");
            this.f6415k = m0Var.p("gcm.n.color");
            this.f6416l = m0Var.p("gcm.n.click_action");
            this.f6417m = m0Var.p("gcm.n.android_channel_id");
            this.f6418n = m0Var.f();
            this.f6412h = m0Var.p("gcm.n.image");
            this.f6419o = m0Var.p("gcm.n.ticker");
            this.f6420p = m0Var.b("gcm.n.notification_priority");
            this.f6421q = m0Var.b("gcm.n.visibility");
            this.f6422r = m0Var.b("gcm.n.notification_count");
            this.f6425u = m0Var.a("gcm.n.sticky");
            this.f6426v = m0Var.a("gcm.n.local_only");
            this.f6427w = m0Var.a("gcm.n.default_sound");
            this.f6428x = m0Var.a("gcm.n.default_vibrate_timings");
            this.f6429y = m0Var.a("gcm.n.default_light_settings");
            this.f6424t = m0Var.j("gcm.n.event_time");
            this.f6423s = m0Var.e();
            this.f6430z = m0Var.q();
        }
    }

    public s0(Bundle bundle) {
        this.f6400a = bundle;
    }

    public String R() {
        return this.f6400a.getString("collapse_key");
    }

    public Map S() {
        if (this.f6401b == null) {
            this.f6401b = e.a.a(this.f6400a);
        }
        return this.f6401b;
    }

    public String T() {
        return this.f6400a.getString("from");
    }

    public String U() {
        String string = this.f6400a.getString("google.message_id");
        return string == null ? this.f6400a.getString("message_id") : string;
    }

    public final int V(String str) {
        if ("high".equals(str)) {
            return 1;
        }
        return "normal".equals(str) ? 2 : 0;
    }

    public String W() {
        return this.f6400a.getString("message_type");
    }

    public c X() {
        if (this.f6402c == null && m0.t(this.f6400a)) {
            this.f6402c = new c(new m0(this.f6400a));
        }
        return this.f6402c;
    }

    public int Y() {
        String string = this.f6400a.getString("google.original_priority");
        if (string == null) {
            string = this.f6400a.getString("google.priority");
        }
        return V(string);
    }

    public long Z() {
        Object obj = this.f6400a.get("google.sent_time");
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

    public String a0() {
        return this.f6400a.getString("google.to");
    }

    public int b0() {
        Object obj = this.f6400a.get("google.ttl");
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

    public void c0(Intent intent) {
        intent.putExtras(this.f6400a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        t0.c(this, parcel, i10);
    }
}
