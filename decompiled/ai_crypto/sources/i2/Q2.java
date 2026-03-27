package i2;

import D1.a;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: loaded from: classes.dex */
public final class Q2 extends U3 {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final Pair f15339A = new Pair("", 0L);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SharedPreferences f15340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SharedPreferences f15341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public O2 f15342e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final N2 f15343f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final N2 f15344g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final P2 f15345h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f15346i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f15347j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f15348k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final N2 f15349l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final L2 f15350m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final P2 f15351n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final M2 f15352o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final L2 f15353p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final N2 f15354q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final N2 f15355r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f15356s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final L2 f15357t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final L2 f15358u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final N2 f15359v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final P2 f15360w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final P2 f15361x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final N2 f15362y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final M2 f15363z;

    public Q2(C1898q3 c1898q3) {
        super(c1898q3);
        this.f15349l = new N2(this, "session_timeout", 1800000L);
        this.f15350m = new L2(this, "start_new_session", true);
        this.f15354q = new N2(this, "last_pause_time", 0L);
        this.f15355r = new N2(this, "session_id", 0L);
        this.f15351n = new P2(this, "non_personalized_ads", null);
        this.f15352o = new M2(this, "last_received_uri_timestamps_by_source", null);
        this.f15353p = new L2(this, "allow_remote_dynamite", false);
        this.f15343f = new N2(this, "first_open_time", 0L);
        this.f15344g = new N2(this, "app_install_time", 0L);
        this.f15345h = new P2(this, "app_instance_id", null);
        this.f15357t = new L2(this, "app_backgrounded", false);
        this.f15358u = new L2(this, "deep_link_retrieval_complete", false);
        this.f15359v = new N2(this, "deep_link_retrieval_attempts", 0L);
        this.f15360w = new P2(this, "firebase_feature_rollouts", null);
        this.f15361x = new P2(this, "deferred_attribution_cache", null);
        this.f15362y = new N2(this, "deferred_attribution_cache_timestamp", 0L);
        this.f15363z = new M2(this, "default_event_parameters", null);
    }

    public final boolean A(long j7) {
        return j7 - this.f15349l.a() > this.f15354q.a();
    }

    @Override // i2.U3
    public final boolean i() {
        return true;
    }

    @Override // i2.U3
    public final void j() {
        C1898q3 c1898q3 = this.f15404a;
        SharedPreferences sharedPreferences = c1898q3.e().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f15340c = sharedPreferences;
        boolean z7 = sharedPreferences.getBoolean("has_been_opened", false);
        this.f15356s = z7;
        if (!z7) {
            SharedPreferences.Editor editorEdit = this.f15340c.edit();
            editorEdit.putBoolean("has_been_opened", true);
            editorEdit.apply();
        }
        c1898q3.w();
        this.f15342e = new O2(this, "health_monitor", Math.max(0L, ((Long) AbstractC1809f2.f15722d.b(null)).longValue()), null);
    }

    public final Pair o(String str) {
        h();
        if (!w().o(Z3.AD_STORAGE)) {
            return new Pair("", Boolean.FALSE);
        }
        C1898q3 c1898q3 = this.f15404a;
        long jB = c1898q3.f().b();
        String str2 = this.f15346i;
        if (str2 != null && jB < this.f15348k) {
            return new Pair(str2, Boolean.valueOf(this.f15347j));
        }
        this.f15348k = jB + c1898q3.w().D(str, AbstractC1809f2.f15716b);
        D1.a.b(true);
        try {
            a.C0009a c0009aA = D1.a.a(c1898q3.e());
            this.f15346i = "";
            String strA = c0009aA.a();
            if (strA != null) {
                this.f15346i = strA;
            }
            this.f15347j = c0009aA.b();
        } catch (Exception e7) {
            this.f15404a.a().v().b("Unable to get advertising id", e7);
            this.f15346i = "";
        }
        D1.a.b(false);
        return new Pair(this.f15346i, Boolean.valueOf(this.f15347j));
    }

    public final SharedPreferences p() {
        h();
        l();
        AbstractC1207s.k(this.f15340c);
        return this.f15340c;
    }

    public final SharedPreferences q() {
        h();
        l();
        if (this.f15341d == null) {
            C1898q3 c1898q3 = this.f15404a;
            String strValueOf = String.valueOf(c1898q3.e().getPackageName());
            A2 a2W = c1898q3.a().w();
            String strConcat = strValueOf.concat("_preferences");
            a2W.b("Default prefs file", strConcat);
            this.f15341d = c1898q3.e().getSharedPreferences(strConcat, 0);
        }
        return this.f15341d;
    }

    public final SparseArray r() {
        Bundle bundleA = this.f15352o.a();
        int[] intArray = bundleA.getIntArray("uriSources");
        long[] longArray = bundleA.getLongArray("uriTimestamps");
        if (intArray == null || longArray == null) {
            return new SparseArray();
        }
        if (intArray.length != longArray.length) {
            this.f15404a.a().o().a("Trigger URI source and timestamp array lengths do not match");
            return new SparseArray();
        }
        SparseArray sparseArray = new SparseArray();
        for (int i7 = 0; i7 < intArray.length; i7++) {
            sparseArray.put(intArray[i7], Long.valueOf(longArray[i7]));
        }
        return sparseArray;
    }

    public final void s(Boolean bool) {
        h();
        SharedPreferences.Editor editorEdit = p().edit();
        if (bool != null) {
            editorEdit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            editorEdit.remove("measurement_enabled");
        }
        editorEdit.apply();
    }

    public final Boolean t() {
        h();
        if (p().contains("measurement_enabled")) {
            return Boolean.valueOf(p().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    public final C1742B u() {
        h();
        return C1742B.g(p().getString("dma_consent_settings", null));
    }

    public final boolean v(int i7) {
        return C1771a4.u(i7, p().getInt("consent_source", 100));
    }

    public final C1771a4 w() {
        h();
        return C1771a4.f(p().getString("consent_settings", "G1"), p().getInt("consent_source", 100));
    }

    public final boolean x(C1957x6 c1957x6) {
        h();
        String string = p().getString("stored_tcf_param", "");
        String strA = c1957x6.a();
        if (strA.equals(string)) {
            return false;
        }
        SharedPreferences.Editor editorEdit = p().edit();
        editorEdit.putString("stored_tcf_param", strA);
        editorEdit.apply();
        return true;
    }

    public final void y(boolean z7) {
        h();
        this.f15404a.a().w().b("App measurement setting deferred collection", Boolean.valueOf(z7));
        SharedPreferences.Editor editorEdit = p().edit();
        editorEdit.putBoolean("deferred_analytics_collection", z7);
        editorEdit.apply();
    }

    public final boolean z() {
        SharedPreferences sharedPreferences = this.f15340c;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }
}
