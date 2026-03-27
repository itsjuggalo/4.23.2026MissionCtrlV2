package S1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.common.internal.AbstractC0940s;
import m1.C1602a;

/* JADX INFO: loaded from: classes.dex */
public final class Q2 extends U3 {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final Pair f4180A = new Pair("", 0L);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SharedPreferences f4181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SharedPreferences f4182d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public O2 f4183e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final N2 f4184f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final N2 f4185g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final P2 f4186h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f4187i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f4188j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f4189k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final N2 f4190l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final L2 f4191m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final P2 f4192n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final M2 f4193o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final L2 f4194p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final N2 f4195q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final N2 f4196r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f4197s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final L2 f4198t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final L2 f4199u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final N2 f4200v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final P2 f4201w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final P2 f4202x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final N2 f4203y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final M2 f4204z;

    public Q2(C0658q3 c0658q3) {
        super(c0658q3);
        this.f4190l = new N2(this, "session_timeout", 1800000L);
        this.f4191m = new L2(this, "start_new_session", true);
        this.f4195q = new N2(this, "last_pause_time", 0L);
        this.f4196r = new N2(this, "session_id", 0L);
        this.f4192n = new P2(this, "non_personalized_ads", null);
        this.f4193o = new M2(this, "last_received_uri_timestamps_by_source", null);
        this.f4194p = new L2(this, "allow_remote_dynamite", false);
        this.f4184f = new N2(this, "first_open_time", 0L);
        this.f4185g = new N2(this, "app_install_time", 0L);
        this.f4186h = new P2(this, "app_instance_id", null);
        this.f4198t = new L2(this, "app_backgrounded", false);
        this.f4199u = new L2(this, "deep_link_retrieval_complete", false);
        this.f4200v = new N2(this, "deep_link_retrieval_attempts", 0L);
        this.f4201w = new P2(this, "firebase_feature_rollouts", null);
        this.f4202x = new P2(this, "deferred_attribution_cache", null);
        this.f4203y = new N2(this, "deferred_attribution_cache_timestamp", 0L);
        this.f4204z = new M2(this, "default_event_parameters", null);
    }

    public final boolean A(long j4) {
        return j4 - this.f4190l.a() > this.f4195q.a();
    }

    @Override // S1.U3
    public final boolean i() {
        return true;
    }

    @Override // S1.U3
    public final void j() {
        C0658q3 c0658q3 = this.f4245a;
        SharedPreferences sharedPreferences = c0658q3.e().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f4181c = sharedPreferences;
        boolean z4 = sharedPreferences.getBoolean("has_been_opened", false);
        this.f4197s = z4;
        if (!z4) {
            SharedPreferences.Editor editorEdit = this.f4181c.edit();
            editorEdit.putBoolean("has_been_opened", true);
            editorEdit.apply();
        }
        c0658q3.w();
        this.f4183e = new O2(this, "health_monitor", Math.max(0L, ((Long) AbstractC0569f2.f4563d.b(null)).longValue()), null);
    }

    public final Pair o(String str) {
        h();
        if (!w().o(Z3.AD_STORAGE)) {
            return new Pair("", Boolean.FALSE);
        }
        C0658q3 c0658q3 = this.f4245a;
        long jA = c0658q3.f().a();
        String str2 = this.f4187i;
        if (str2 != null && jA < this.f4189k) {
            return new Pair(str2, Boolean.valueOf(this.f4188j));
        }
        this.f4189k = jA + c0658q3.w().D(str, AbstractC0569f2.f4557b);
        C1602a.b(true);
        try {
            C1602a.C0210a c0210aA = C1602a.a(c0658q3.e());
            this.f4187i = "";
            String strA = c0210aA.a();
            if (strA != null) {
                this.f4187i = strA;
            }
            this.f4188j = c0210aA.b();
        } catch (Exception e4) {
            this.f4245a.a().v().b("Unable to get advertising id", e4);
            this.f4187i = "";
        }
        C1602a.b(false);
        return new Pair(this.f4187i, Boolean.valueOf(this.f4188j));
    }

    public final SharedPreferences p() {
        h();
        l();
        AbstractC0940s.k(this.f4181c);
        return this.f4181c;
    }

    public final SharedPreferences q() {
        h();
        l();
        if (this.f4182d == null) {
            C0658q3 c0658q3 = this.f4245a;
            String strValueOf = String.valueOf(c0658q3.e().getPackageName());
            A2 a2W = c0658q3.a().w();
            String strConcat = strValueOf.concat("_preferences");
            a2W.b("Default prefs file", strConcat);
            this.f4182d = c0658q3.e().getSharedPreferences(strConcat, 0);
        }
        return this.f4182d;
    }

    public final SparseArray r() {
        Bundle bundleA = this.f4193o.a();
        int[] intArray = bundleA.getIntArray("uriSources");
        long[] longArray = bundleA.getLongArray("uriTimestamps");
        if (intArray == null || longArray == null) {
            return new SparseArray();
        }
        if (intArray.length != longArray.length) {
            this.f4245a.a().o().a("Trigger URI source and timestamp array lengths do not match");
            return new SparseArray();
        }
        SparseArray sparseArray = new SparseArray();
        for (int i4 = 0; i4 < intArray.length; i4++) {
            sparseArray.put(intArray[i4], Long.valueOf(longArray[i4]));
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

    public final B u() {
        h();
        return B.g(p().getString("dma_consent_settings", null));
    }

    public final boolean v(int i4) {
        return C0531a4.u(i4, p().getInt("consent_source", 100));
    }

    public final C0531a4 w() {
        h();
        return C0531a4.f(p().getString("consent_settings", "G1"), p().getInt("consent_source", 100));
    }

    public final boolean x(C0716x6 c0716x6) {
        h();
        String string = p().getString("stored_tcf_param", "");
        String strA = c0716x6.a();
        if (strA.equals(string)) {
            return false;
        }
        SharedPreferences.Editor editorEdit = p().edit();
        editorEdit.putString("stored_tcf_param", strA);
        editorEdit.apply();
        return true;
    }

    public final void y(boolean z4) {
        h();
        this.f4245a.a().w().b("App measurement setting deferred collection", Boolean.valueOf(z4));
        SharedPreferences.Editor editorEdit = p().edit();
        editorEdit.putBoolean("deferred_analytics_collection", z4);
        editorEdit.apply();
    }

    public final boolean z() {
        SharedPreferences sharedPreferences = this.f4181c;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }
}
