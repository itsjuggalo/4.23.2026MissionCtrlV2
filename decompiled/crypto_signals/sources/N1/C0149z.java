package N1;

import O.C0174c;
import O.InterfaceC0176d;
import P3.AbstractActivityC0229d;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import com.cryptosignals.ap.android.R;
import com.google.android.gms.common.internal.InterfaceC0440s;
import com.google.android.gms.internal.measurement.zzow;
import com.google.android.gms.internal.measurement.zzpc;
import com.google.android.gms.internal.measurement.zzpr;
import com.google.android.gms.internal.measurement.zzpu;
import com.google.android.gms.internal.measurement.zzqg;
import com.google.android.gms.internal.measurement.zzqp;
import com.google.android.gms.internal.measurement.zzrq;
import e0.C0527b;
import h1.InterfaceC0618a;
import i0.InterfaceC0645a;
import java.io.File;
import java.util.List;
import o2.InterfaceC0885a;

/* JADX INFO: renamed from: N1.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C0149z implements InterfaceC0137v, InterfaceC0176d, Z3.o, InterfaceC0440s, androidx.lifecycle.W, InterfaceC0618a, InterfaceC0645a, i5.a, InterfaceC0885a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ C0149z f1881b = new C0149z(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ C0149z f1882c = new C0149z(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ C0149z f1883d = new C0149z(2);
    public static final /* synthetic */ C0149z e = new C0149z(3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ C0149z f1884f = new C0149z(4);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ C0149z f1885k = new C0149z(5);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ C0149z f1886l = new C0149z(6);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ C0149z f1887m = new C0149z(7);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ C0149z f1888n = new C0149z(8);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ C0149z f1889o = new C0149z(9);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ C0149z f1890p = new C0149z(10);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ C0149z f1891q = new C0149z(11);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static C0149z f1892r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static C0149z f1893s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1894a;

    public /* synthetic */ C0149z(int i) {
        this.f1894a = i;
    }

    public static String e(AbstractActivityC0229d abstractActivityC0229d, Uri uri) {
        try {
            String extensionFromMimeType = uri.getScheme().equals("content") ? MimeTypeMap.getSingleton().getExtensionFromMimeType(abstractActivityC0229d.getContentResolver().getType(uri)) : MimeTypeMap.getFileExtensionFromUrl(Uri.fromFile(new File(uri.getPath())).toString());
            if (extensionFromMimeType == null || extensionFromMimeType.isEmpty()) {
                return null;
            }
            return "." + j(extensionFromMimeType);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String g(P3.AbstractActivityC0229d r13, android.net.Uri r14) {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N1.C0149z.g(P3.d, android.net.Uri):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0045, code lost:
    
        if (java.lang.Character.isHighSurrogate(r5) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0082, code lost:
    
        if (java.lang.Character.isLowSurrogate(r5) != false) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x006c A[EDGE_INSN: B:92:0x006c->B:46:0x006c BREAK  A[LOOP:2: B:47:0x006e->B:58:0x0085], EDGE_INSN: B:93:0x006c->B:46:0x006c BREAK  A[LOOP:2: B:47:0x006e->B:58:0x0085, LOOP_LABEL: LOOP:2: B:47:0x006e->B:58:0x0085]] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00a2 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean h(W.b r7, android.text.Editable r8, int r9, int r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N1.C0149z.h(W.b, android.text.Editable, int, int, boolean):boolean");
    }

    public static File i(String str, String str2) {
        File file = new File(str);
        if (file.getCanonicalPath().startsWith(str2)) {
            return file;
        }
        throw new IllegalArgumentException("Trying to open path outside of the expected directory. File: " + file.getCanonicalPath() + " was expected to be within directory: " + str2 + ".");
    }

    public static String j(String str) {
        if (str == null) {
            return null;
        }
        String[] strArr = {"..", "/"};
        String strReplace = str.split("/")[r4.length - 1];
        for (int i = 0; i < 2; i++) {
            strReplace = strReplace.replace(strArr[i], "_");
        }
        return strReplace;
    }

    @Override // androidx.lifecycle.W
    public androidx.lifecycle.T a(Class cls) {
        return new C0527b();
    }

    @Override // com.google.android.gms.common.internal.InterfaceC0440s
    public /* bridge */ /* synthetic */ Object b(com.google.android.gms.common.api.s sVar) {
        return null;
    }

    @Override // i0.InterfaceC0645a
    public CharSequence c(Preference preference) {
        ListPreference listPreference = (ListPreference) preference;
        listPreference.getClass();
        if (TextUtils.isEmpty(null)) {
            return listPreference.f4714a.getString(R.string.not_set);
        }
        return null;
    }

    @Override // h1.InterfaceC0618a
    public long d() {
        return SystemClock.elapsedRealtime();
    }

    @Override // Z3.o
    public void onMethodCall(Z3.n nVar, Z3.p pVar) {
        ((Y3.h) pVar).c(null);
    }

    @Override // o2.InterfaceC0885a
    public void q(Bundle bundle) {
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Skipping logging Crashlytics event to Firebase, no Firebase Analytics", null);
        }
    }

    @Override // N1.InterfaceC0137v
    public /* synthetic */ Object zza() {
        switch (this.f1894a) {
            case 0:
                List list = E.f1180a;
                return Integer.valueOf((int) zzpc.zzX());
            case 1:
                List list2 = E.f1180a;
                return Boolean.valueOf(zzpc.zzc());
            case 2:
                List list3 = E.f1180a;
                return Boolean.valueOf(zzpu.zzc());
            case 3:
                List list4 = E.f1180a;
                return Boolean.valueOf(zzpu.zzd());
            case 4:
                List list5 = E.f1180a;
                return Boolean.valueOf(zzrq.zza());
            case 5:
                List list6 = E.f1180a;
                return Boolean.valueOf(zzpr.zzc());
            case 6:
                List list7 = E.f1180a;
                return Boolean.valueOf(zzqp.zzg());
            case 7:
                List list8 = E.f1180a;
                return Boolean.valueOf(zzqp.zzi());
            case 8:
                List list9 = E.f1180a;
                return Boolean.valueOf(zzqp.zzf());
            case s3.I0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                List list10 = E.f1180a;
                return Boolean.valueOf(zzow.zza());
            case s3.I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                List list11 = E.f1180a;
                return Integer.valueOf((int) zzpc.zzan());
            default:
                return new Boolean(zzqg.zza());
        }
    }

    public C0149z(a5.p0 p0Var) {
        this.f1894a = 25;
    }

    @Override // O.InterfaceC0176d
    public Object k(C0174c c0174c) throws C0174c {
        throw c0174c;
    }
}
