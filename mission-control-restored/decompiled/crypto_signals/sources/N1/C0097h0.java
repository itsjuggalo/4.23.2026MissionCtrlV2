package N1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;

/* JADX INFO: renamed from: N1.h0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0097h0 extends E0 {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final Pair f1625D = new Pair("", 0L);

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final C0094g0 f1626A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final C0088e0 f1627B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final e3.w f1628C;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SharedPreferences f1629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SharedPreferences f1630d;
    public C0091f0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C0088e0 f1631f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C0094g0 f1632k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f1633l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f1634m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f1635n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final C0088e0 f1636o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final C0085d0 f1637p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final C0094g0 f1638q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final e3.w f1639r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final C0085d0 f1640s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final C0088e0 f1641t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final C0088e0 f1642u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f1643v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final C0085d0 f1644w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final C0085d0 f1645x;
    public final C0088e0 y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final C0094g0 f1646z;

    public C0097h0(C0138v0 c0138v0) {
        super(c0138v0);
        this.f1636o = new C0088e0(this, "session_timeout", 1800000L);
        this.f1637p = new C0085d0(this, "start_new_session", true);
        this.f1641t = new C0088e0(this, "last_pause_time", 0L);
        this.f1642u = new C0088e0(this, "session_id", 0L);
        this.f1638q = new C0094g0(this, "non_personalized_ads");
        this.f1639r = new e3.w(this, "last_received_uri_timestamps_by_source");
        this.f1640s = new C0085d0(this, "allow_remote_dynamite", false);
        this.f1631f = new C0088e0(this, "first_open_time", 0L);
        com.google.android.gms.common.internal.I.d("app_install_time");
        this.f1632k = new C0094g0(this, "app_instance_id");
        this.f1644w = new C0085d0(this, "app_backgrounded", false);
        this.f1645x = new C0085d0(this, "deep_link_retrieval_complete", false);
        this.y = new C0088e0(this, "deep_link_retrieval_attempts", 0L);
        this.f1646z = new C0094g0(this, "firebase_feature_rollouts");
        this.f1626A = new C0094g0(this, "deferred_attribution_cache");
        this.f1627B = new C0088e0(this, "deferred_attribution_cache_timestamp", 0L);
        this.f1628C = new e3.w(this, "default_event_parameters");
    }

    @Override // N1.E0
    public final boolean q() {
        return true;
    }

    public final SharedPreferences t() {
        p();
        r();
        com.google.android.gms.common.internal.I.g(this.f1629c);
        return this.f1629c;
    }

    public final SharedPreferences u() {
        p();
        r();
        if (this.f1630d == null) {
            C0138v0 c0138v0 = (C0138v0) this.f1130a;
            String strValueOf = String.valueOf(c0138v0.f1810a.getPackageName());
            W w6 = c0138v0.f1814f;
            C0138v0.l(w6);
            String strConcat = strValueOf.concat("_preferences");
            w6.f1419r.b(strConcat, "Default prefs file");
            this.f1630d = c0138v0.f1810a.getSharedPreferences(strConcat, 0);
        }
        return this.f1630d;
    }

    public final SparseArray v() {
        Bundle bundleN = this.f1639r.N();
        int[] intArray = bundleN.getIntArray("uriSources");
        long[] longArray = bundleN.getLongArray("uriTimestamps");
        if (intArray == null || longArray == null) {
            return new SparseArray();
        }
        if (intArray.length != longArray.length) {
            W w6 = ((C0138v0) this.f1130a).f1814f;
            C0138v0.l(w6);
            w6.f1411f.a("Trigger URI source and timestamp array lengths do not match");
            return new SparseArray();
        }
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < intArray.length; i++) {
            sparseArray.put(intArray[i], Long.valueOf(longArray[i]));
        }
        return sparseArray;
    }

    public final J0 w() {
        p();
        return J0.c(t().getInt("consent_source", 100), t().getString("consent_settings", "G1"));
    }

    public final boolean x(F1 f12) {
        p();
        String string = t().getString("stored_tcf_param", "");
        String strA = f12.a();
        if (strA.equals(string)) {
            return false;
        }
        SharedPreferences.Editor editorEdit = t().edit();
        editorEdit.putString("stored_tcf_param", strA);
        editorEdit.apply();
        return true;
    }

    public final void y(boolean z6) {
        p();
        W w6 = ((C0138v0) this.f1130a).f1814f;
        C0138v0.l(w6);
        w6.f1419r.b(Boolean.valueOf(z6), "App measurement setting deferred collection");
        SharedPreferences.Editor editorEdit = t().edit();
        editorEdit.putBoolean("deferred_analytics_collection", z6);
        editorEdit.apply();
    }

    public final boolean z(long j4) {
        return j4 - this.f1636o.a() > this.f1641t.a();
    }
}
