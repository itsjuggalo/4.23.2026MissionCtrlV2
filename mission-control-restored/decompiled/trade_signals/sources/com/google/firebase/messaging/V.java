package com.google.firebase.messaging;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.messaging.AbstractC1434e;
import java.util.Map;
import w.C2882a;

/* JADX INFO: loaded from: classes.dex */
public final class V extends T1.a {
    public static final Parcelable.Creator<V> CREATOR = new W();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bundle f15635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f15636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f15637c;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f15638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f15639b;

        public b(String str) {
            Bundle bundle = new Bundle();
            this.f15638a = bundle;
            this.f15639b = new C2882a();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("google.to", str);
                return;
            }
            throw new IllegalArgumentException("Invalid to: " + str);
        }

        public V a() {
            Bundle bundle = new Bundle();
            for (Map.Entry entry : this.f15639b.entrySet()) {
                bundle.putString((String) entry.getKey(), (String) entry.getValue());
            }
            bundle.putAll(this.f15638a);
            this.f15638a.remove("from");
            return new V(bundle);
        }

        public b b(String str) {
            this.f15638a.putString("collapse_key", str);
            return this;
        }

        public b c(Map map) {
            this.f15639b.clear();
            this.f15639b.putAll(map);
            return this;
        }

        public b d(String str) {
            this.f15638a.putString("google.message_id", str);
            return this;
        }

        public b e(String str) {
            this.f15638a.putString("message_type", str);
            return this;
        }

        public b f(int i8) {
            this.f15638a.putString("google.ttl", String.valueOf(i8));
            return this;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f15640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f15641b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String[] f15642c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f15643d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f15644e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String[] f15645f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f15646g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f15647h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f15648i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f15649j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final String f15650k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final String f15651l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final String f15652m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final Uri f15653n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final String f15654o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final Integer f15655p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final Integer f15656q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final Integer f15657r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final int[] f15658s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final Long f15659t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final boolean f15660u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final boolean f15661v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final boolean f15662w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final boolean f15663x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final boolean f15664y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public final long[] f15665z;

        public c(M m8) {
            this.f15640a = m8.p("gcm.n.title");
            this.f15641b = m8.h("gcm.n.title");
            this.f15642c = j(m8, "gcm.n.title");
            this.f15643d = m8.p("gcm.n.body");
            this.f15644e = m8.h("gcm.n.body");
            this.f15645f = j(m8, "gcm.n.body");
            this.f15646g = m8.p("gcm.n.icon");
            this.f15648i = m8.o();
            this.f15649j = m8.p("gcm.n.tag");
            this.f15650k = m8.p("gcm.n.color");
            this.f15651l = m8.p("gcm.n.click_action");
            this.f15652m = m8.p("gcm.n.android_channel_id");
            this.f15653n = m8.f();
            this.f15647h = m8.p("gcm.n.image");
            this.f15654o = m8.p("gcm.n.ticker");
            this.f15655p = m8.b("gcm.n.notification_priority");
            this.f15656q = m8.b("gcm.n.visibility");
            this.f15657r = m8.b("gcm.n.notification_count");
            this.f15660u = m8.a("gcm.n.sticky");
            this.f15661v = m8.a("gcm.n.local_only");
            this.f15662w = m8.a("gcm.n.default_sound");
            this.f15663x = m8.a("gcm.n.default_vibrate_timings");
            this.f15664y = m8.a("gcm.n.default_light_settings");
            this.f15659t = m8.j("gcm.n.event_time");
            this.f15658s = m8.e();
            this.f15665z = m8.q();
        }

        public static String[] j(M m8, String str) {
            Object[] objArrG = m8.g(str);
            if (objArrG == null) {
                return null;
            }
            String[] strArr = new String[objArrG.length];
            for (int i8 = 0; i8 < objArrG.length; i8++) {
                strArr[i8] = String.valueOf(objArrG[i8]);
            }
            return strArr;
        }

        public String a() {
            return this.f15643d;
        }

        public String[] b() {
            return this.f15645f;
        }

        public String c() {
            return this.f15644e;
        }

        public String d() {
            return this.f15652m;
        }

        public String e() {
            return this.f15651l;
        }

        public String f() {
            return this.f15650k;
        }

        public String g() {
            return this.f15646g;
        }

        public Uri h() {
            String str = this.f15647h;
            if (str != null) {
                return Uri.parse(str);
            }
            return null;
        }

        public Uri i() {
            return this.f15653n;
        }

        public Integer k() {
            return this.f15657r;
        }

        public Integer l() {
            return this.f15655p;
        }

        public String m() {
            return this.f15648i;
        }

        public String n() {
            return this.f15649j;
        }

        public String o() {
            return this.f15654o;
        }

        public String p() {
            return this.f15640a;
        }

        public String[] q() {
            return this.f15642c;
        }

        public String r() {
            return this.f15641b;
        }

        public Integer s() {
            return this.f15656q;
        }
    }

    public V(Bundle bundle) {
        this.f15635a = bundle;
    }

    public c C() {
        if (this.f15637c == null && M.t(this.f15635a)) {
            this.f15637c = new c(new M(this.f15635a));
        }
        return this.f15637c;
    }

    public int F() {
        String string = this.f15635a.getString("google.original_priority");
        if (string == null) {
            string = this.f15635a.getString("google.priority");
        }
        return h(string);
    }

    public long H() {
        Object obj = this.f15635a.get("google.sent_time");
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

    public String I() {
        return this.f15635a.getString("google.to");
    }

    public int J() {
        Object obj = this.f15635a.get("google.ttl");
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

    public void K(Intent intent) {
        intent.putExtras(this.f15635a);
    }

    public String a() {
        return this.f15635a.getString("collapse_key");
    }

    public Map d() {
        if (this.f15636b == null) {
            this.f15636b = AbstractC1434e.a.a(this.f15635a);
        }
        return this.f15636b;
    }

    public String e() {
        return this.f15635a.getString("from");
    }

    public String f() {
        String string = this.f15635a.getString("google.message_id");
        return string == null ? this.f15635a.getString("message_id") : string;
    }

    public final int h(String str) {
        if ("high".equals(str)) {
            return 1;
        }
        return "normal".equals(str) ? 2 : 0;
    }

    public String n() {
        return this.f15635a.getString("message_type");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        W.c(this, parcel, i8);
    }
}
