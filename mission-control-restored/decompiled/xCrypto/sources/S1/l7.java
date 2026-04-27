package S1;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ext.SdkExtensions;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.measurement.zzcu;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.firestore.util.ExponentialBackoff;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import k0.AbstractC1566a;
import z1.C1989g;

/* JADX INFO: loaded from: classes.dex */
public final class l7 extends U3 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String[] f4736i = {"firebase_", "google_", "ga_"};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String[] f4737j = {"_err"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SecureRandom f4738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicLong f4739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4740e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AbstractC1566a f4741f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Boolean f4742g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f4743h;

    public l7(C0658q3 c0658q3) {
        super(c0658q3);
        this.f4743h = null;
        this.f4739d = new AtomicLong(0L);
    }

    public static MessageDigest C() {
        MessageDigest messageDigest;
        for (int i4 = 0; i4 < 2; i4++) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    public static long D(byte[] bArr) {
        AbstractC0940s.k(bArr);
        int length = bArr.length;
        int i4 = 0;
        AbstractC0940s.n(length > 0);
        long j4 = 0;
        for (int i5 = length - 1; i5 >= 0 && i5 >= bArr.length - 8; i5--) {
            j4 += (((long) bArr[i5]) & 255) << i4;
            i4 += 8;
        }
        return j4;
    }

    public static boolean E(Context context, boolean z4) {
        AbstractC0940s.k(context);
        return F(context, "com.google.android.gms.measurement.AppMeasurementJobService");
    }

    public static boolean F(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean N(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public static boolean O(String str, String[] strArr) {
        AbstractC0940s.k(strArr);
        for (String str2 : strArr) {
            if (Objects.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean U(String str) {
        return !f4737j[0].equals(str);
    }

    public static ArrayList h0(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0590i c0590i = (C0590i) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", c0590i.f4667a);
            bundle.putString(FirebaseAnalytics.Param.ORIGIN, c0590i.f4668b);
            bundle.putLong("creation_timestamp", c0590i.f4670d);
            bundle.putString("name", c0590i.f4669c.f4661b);
            W3.a(bundle, AbstractC0940s.k(c0590i.f4669c.i()));
            bundle.putBoolean("active", c0590i.f4671e);
            String str = c0590i.f4672f;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            J j4 = c0590i.f4673g;
            if (j4 != null) {
                bundle.putString("timed_out_event_name", j4.f4005a);
                H h4 = j4.f4006b;
                if (h4 != null) {
                    bundle.putBundle("timed_out_event_params", h4.o());
                }
            }
            bundle.putLong("trigger_timeout", c0590i.f4674h);
            J j5 = c0590i.f4675i;
            if (j5 != null) {
                bundle.putString("triggered_event_name", j5.f4005a);
                H h5 = j5.f4006b;
                if (h5 != null) {
                    bundle.putBundle("triggered_event_params", h5.o());
                }
            }
            bundle.putLong("triggered_timestamp", c0590i.f4669c.f4662c);
            bundle.putLong("time_to_live", c0590i.f4676j);
            J j6 = c0590i.f4677k;
            if (j6 != null) {
                bundle.putString("expired_event_name", j6.f4005a);
                H h6 = j6.f4006b;
                if (h6 != null) {
                    bundle.putBundle("expired_event_params", h6.o());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static boolean j0(Context context) {
        ActivityInfo receiverInfo;
        AbstractC0940s.k(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static void k0(C0628m5 c0628m5, Bundle bundle, boolean z4) {
        if (bundle != null && c0628m5 != null) {
            if (!bundle.containsKey("_sc") || z4) {
                String str = c0628m5.f4751a;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = c0628m5.f4752b;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", c0628m5.f4753c);
                return;
            }
            z4 = false;
        }
        if (bundle != null && c0628m5 == null && z4) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public static final boolean m0(Bundle bundle, int i4) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i4);
        return true;
    }

    public static boolean r0(String str) {
        AbstractC0940s.e(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    public final void A(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
        } else if (str != null) {
            String simpleName = obj != null ? obj.getClass().getSimpleName() : null;
            C0658q3 c0658q3 = this.f4245a;
            c0658q3.a().t().c("Not putting event parameter. Invalid value type. name, type", c0658q3.D().b(str), simpleName);
        }
    }

    public final int A0(String str) {
        if (!u0("event param", str)) {
            return 3;
        }
        if (!v0("event param", null, null, str)) {
            return 14;
        }
        this.f4245a.w();
        return !w0("event param", 40, str) ? 3 : 0;
    }

    public final void B(k7 k7Var, String str, int i4, String str2, String str3, int i5) {
        Bundle bundle = new Bundle();
        m0(bundle, i4);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i4 == 6 || i4 == 7 || i4 == 2) {
            bundle.putLong("_el", i5);
        }
        k7Var.zza(str, "_err", bundle);
    }

    public final boolean B0(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    public final boolean C0(String str, String str2, int i4, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String string = obj.toString();
            if (string.codePointCount(0, string.length()) > i4) {
                this.f4245a.a().t().d("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(string.length()));
                return false;
            }
        }
        return true;
    }

    public final void D0(String str, String str2, String str3, Bundle bundle, List list, boolean z4) {
        int iZ0;
        String str4;
        int iR;
        List list2 = list;
        if (bundle == null) {
            return;
        }
        C0658q3 c0658q3 = this.f4245a;
        int i4 = true != c0658q3.w().f4245a.C().V(231100000, true) ? 0 : 35;
        int i5 = 0;
        boolean z5 = false;
        for (String str5 : new TreeSet(bundle.keySet())) {
            if (list2 == null || !list2.contains(str5)) {
                iZ0 = !z4 ? z0(str5) : 0;
                if (iZ0 == 0) {
                    iZ0 = A0(str5);
                }
            } else {
                iZ0 = 0;
            }
            if (iZ0 != 0) {
                x(bundle, iZ0, str5, iZ0 == 3 ? str5 : null);
                bundle.remove(str5);
            } else {
                if (B0(bundle.get(str5))) {
                    c0658q3.a().t().d("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str5);
                    iR = 22;
                    str4 = null;
                } else {
                    str4 = null;
                    iR = r(str, str2, str5, bundle.get(str5), bundle, list2, z4, false);
                }
                if (iR != 0 && !"_ev".equals(str5)) {
                    x(bundle, iR, str5, bundle.get(str5));
                    bundle.remove(str5);
                } else if (r0(str5) && !O(str5, AbstractC0547c4.f4430d)) {
                    i5++;
                    if (!V(231100000, true)) {
                        c0658q3.a().q().c("Item array not supported on client's version of Google Play Services (Android Only)", c0658q3.D().a(str2), c0658q3.D().e(bundle));
                        m0(bundle, 23);
                        bundle.remove(str5);
                    } else if (i5 > i4) {
                        if (!c0658q3.w().H(str4, AbstractC0569f2.f4574g1) || !z5) {
                            A2 a2Q = c0658q3.a().q();
                            StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 55);
                            sb.append("Item can't contain more than ");
                            sb.append(i4);
                            sb.append(" item-scoped custom params");
                            a2Q.c(sb.toString(), c0658q3.D().a(str2), c0658q3.D().e(bundle));
                        }
                        m0(bundle, 28);
                        bundle.remove(str5);
                        list2 = list;
                        z5 = true;
                    }
                }
            }
            list2 = list;
        }
    }

    public final boolean G() {
        h();
        return J() == 1;
    }

    public final AbstractC1566a H() {
        if (this.f4741f == null) {
            this.f4741f = AbstractC1566a.a(this.f4245a.e());
        }
        return this.f4741f;
    }

    public final int I() {
        if (Build.VERSION.SDK_INT < 30 || SdkExtensions.getExtensionVersion(30) <= 3) {
            return 0;
        }
        return SdkExtensions.getExtensionVersion(1000000);
    }

    public final long J() {
        long j4;
        h();
        if (!L(this.f4245a.L().q())) {
            return 0L;
        }
        if (Build.VERSION.SDK_INT < 30) {
            j4 = 4;
        } else if (SdkExtensions.getExtensionVersion(30) < 4) {
            j4 = 8;
        } else {
            C0658q3 c0658q3 = this.f4245a;
            int I4 = I();
            c0658q3.w();
            j4 = I4 < ((Integer) AbstractC0569f2.f4590m0.b(null)).intValue() ? 16L : 0L;
        }
        if (!M("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")) {
            j4 |= 2;
        }
        if (j4 == 0 && !K()) {
            j4 = 64;
        }
        if (j4 == 0) {
            return 1L;
        }
        return j4;
    }

    public final boolean K() {
        Object e4;
        Integer num;
        if (this.f4742g == null) {
            AbstractC1566a abstractC1566aH = H();
            boolean z4 = false;
            if (abstractC1566aH == null) {
                return false;
            }
            try {
                num = (Integer) abstractC1566aH.b().get(10000L, TimeUnit.MILLISECONDS);
                if (num != null) {
                    try {
                        if (num.intValue() == 1) {
                            z4 = true;
                        }
                    } catch (InterruptedException e5) {
                        e4 = e5;
                        this.f4245a.a().r().b("Measurement manager api exception", e4);
                        this.f4742g = Boolean.FALSE;
                    } catch (CancellationException e6) {
                        e4 = e6;
                        this.f4245a.a().r().b("Measurement manager api exception", e4);
                        this.f4742g = Boolean.FALSE;
                    } catch (ExecutionException e7) {
                        e4 = e7;
                        this.f4245a.a().r().b("Measurement manager api exception", e4);
                        this.f4742g = Boolean.FALSE;
                    } catch (TimeoutException e8) {
                        e4 = e8;
                        this.f4245a.a().r().b("Measurement manager api exception", e4);
                        this.f4742g = Boolean.FALSE;
                    }
                }
                this.f4742g = Boolean.valueOf(z4);
            } catch (InterruptedException | CancellationException | ExecutionException | TimeoutException e9) {
                e4 = e9;
                num = null;
            }
            this.f4245a.a().w().b("Measurement manager api status result", num);
        }
        return this.f4742g.booleanValue();
    }

    public final boolean L(String str) {
        String str2 = (String) AbstractC0569f2.f4602s0.b(null);
        return str2.equals("*") || Arrays.asList(str2.split(com.amazon.a.a.o.b.f.f8804a)).contains(str);
    }

    public final boolean M(String str) {
        h();
        C0658q3 c0658q3 = this.f4245a;
        if (I1.f.a(c0658q3.e()).a(str) == 0) {
            return true;
        }
        c0658q3.a().v().b("Permission not granted", str);
        return false;
    }

    public final boolean P(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        C0658q3 c0658q3 = this.f4245a;
        String strI = c0658q3.w().i();
        c0658q3.c();
        return strI.equals(str);
    }

    public final Bundle Q(Bundle bundle, String str) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str2 : bundle.keySet()) {
                Object objS = s(str2, bundle.get(str2));
                if (objS == null) {
                    C0658q3 c0658q3 = this.f4245a;
                    c0658q3.a().t().b("Param value can't be null", c0658q3.D().b(str2));
                } else {
                    A(bundle2, str2, objS);
                }
            }
        }
        return bundle2;
    }

    public final J R(String str, String str2, Bundle bundle, String str3, long j4, boolean z4, boolean z5) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (x0(str2) != 0) {
            C0658q3 c0658q3 = this.f4245a;
            c0658q3.a().o().b("Invalid conditional property event name", c0658q3.D().c(str2));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str3);
        Bundle bundleT = t(str, str2, bundle2, G1.e.a("_o"), true);
        if (z4) {
            bundleT = Q(bundleT, str);
        }
        AbstractC0940s.k(bundleT);
        return new J(str2, new H(bundleT), str3, j4);
    }

    public final boolean S(Context context, String str) {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfoE = I1.f.a(context).e(str, 64);
            if (packageInfoE == null || (signatureArr = packageInfoE.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e4) {
            this.f4245a.a().o().b("Package name not found", e4);
            return true;
        } catch (CertificateException e5) {
            this.f4245a.a().o().b("Error obtaining certificate", e5);
            return true;
        }
    }

    public final byte[] T(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(parcelObtain, 0);
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    public final boolean V(int i4, boolean z4) {
        Boolean boolX = this.f4245a.J().x();
        if (W() < i4 / 1000) {
            return (boolX == null || boolX.booleanValue()) ? false : true;
        }
        return true;
    }

    public final int W() {
        if (this.f4743h == null) {
            this.f4743h = Integer.valueOf(C1989g.f().a(this.f4245a.e()) / 1000);
        }
        return this.f4743h.intValue();
    }

    public final int X(int i4) {
        return C1989g.f().h(this.f4245a.e(), 12451000);
    }

    public final long Y(long j4, long j5) {
        return (j4 + (j5 * ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS)) / 86400000;
    }

    public final void Z(Bundle bundle, long j4) {
        long j5 = bundle.getLong("_et");
        if (j5 != 0) {
            this.f4245a.a().r().b("Params already contained engagement", Long.valueOf(j5));
        } else {
            j5 = 0;
        }
        bundle.putLong("_et", j4 + j5);
    }

    public final void a0(zzcu zzcuVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e4) {
            this.f4245a.a().r().b("Error returning string value to wrapper", e4);
        }
    }

    public final void b0(zzcu zzcuVar, long j4) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j4);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e4) {
            this.f4245a.a().r().b("Error returning long value to wrapper", e4);
        }
    }

    public final void c0(zzcu zzcuVar, int i4) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i4);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e4) {
            this.f4245a.a().r().b("Error returning int value to wrapper", e4);
        }
    }

    public final void d0(zzcu zzcuVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e4) {
            this.f4245a.a().r().b("Error returning byte array to wrapper", e4);
        }
    }

    public final void e0(zzcu zzcuVar, boolean z4) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z4);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e4) {
            this.f4245a.a().r().b("Error returning boolean value to wrapper", e4);
        }
    }

    public final void f0(zzcu zzcuVar, Bundle bundle) {
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e4) {
            this.f4245a.a().r().b("Error returning bundle value to wrapper", e4);
        }
    }

    public final void g0(zzcu zzcuVar, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e4) {
            this.f4245a.a().r().b("Error returning bundle list to wrapper", e4);
        }
    }

    @Override // S1.U3
    public final boolean i() {
        return true;
    }

    public final URL i0(long j4, String str, String str2, long j5, String str3) {
        try {
            AbstractC0940s.e(str2);
            AbstractC0940s.e(str);
            String strConcat = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", 130000L, Integer.valueOf(W())), str2, str, Long.valueOf(j5));
            if (str.equals(this.f4245a.w().j())) {
                strConcat = strConcat.concat("&ddl_test=1");
            }
            if (!str3.isEmpty()) {
                if (str3.charAt(0) != '&') {
                    strConcat = strConcat.concat("&");
                }
                strConcat = strConcat.concat(str3);
            }
            return new URL(strConcat);
        } catch (IllegalArgumentException e4) {
            e = e4;
            this.f4245a.a().o().b("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        } catch (MalformedURLException e5) {
            e = e5;
            this.f4245a.a().o().b("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    @Override // S1.U3
    public final void j() {
        h();
        SecureRandom secureRandom = new SecureRandom();
        long jNextLong = secureRandom.nextLong();
        if (jNextLong == 0) {
            jNextLong = secureRandom.nextLong();
            if (jNextLong == 0) {
                this.f4245a.a().r().a("Utils falling back to Random for random id");
            }
        }
        this.f4739d.set(jNextLong);
    }

    public final String l0() {
        byte[] bArr = new byte[16];
        q0().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public final Object n0(int i4, Object obj, boolean z4, boolean z5, String str) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(true != ((Boolean) obj).booleanValue() ? 0L : 1L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return q(obj.toString(), i4, z4);
        }
        if (!z5 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : (Parcelable[]) obj) {
            if (parcelable instanceof Bundle) {
                Bundle bundleQ = Q((Bundle) parcelable, null);
                if (!bundleQ.isEmpty()) {
                    arrayList.add(bundleQ);
                }
            }
        }
        return arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public final boolean o(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f4245a.a().q().a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            return false;
        }
        AbstractC0940s.k(str);
        if (str.matches("^1:\\d+:android:[a-f0-9]+$")) {
            return true;
        }
        this.f4245a.a().q().b("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", C2.x(str));
        return false;
    }

    public final int o0(String str) {
        if ("_ldl".equals(str)) {
            this.f4245a.w();
            return 2048;
        }
        if ("_id".equals(str)) {
            this.f4245a.w();
            return 256;
        }
        if ("_lgclid".equals(str)) {
            this.f4245a.w();
            return 100;
        }
        this.f4245a.w();
        return 36;
    }

    public final boolean p(String str, String str2) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        boolean zIsEmpty2 = TextUtils.isEmpty(str2);
        if (!zIsEmpty && !zIsEmpty2) {
            AbstractC0940s.k(str);
            if (!str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public final long p0() {
        long andIncrement;
        long j4;
        AtomicLong atomicLong = this.f4739d;
        if (atomicLong.get() != 0) {
            AtomicLong atomicLong2 = this.f4739d;
            synchronized (atomicLong2) {
                atomicLong2.compareAndSet(-1L, 1L);
                andIncrement = atomicLong2.getAndIncrement();
            }
            return andIncrement;
        }
        synchronized (atomicLong) {
            long jNextLong = new Random(System.nanoTime() ^ this.f4245a.f().currentTimeMillis()).nextLong();
            int i4 = this.f4740e + 1;
            this.f4740e = i4;
            j4 = jNextLong + ((long) i4);
        }
        return j4;
    }

    public final String q(String str, int i4, boolean z4) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i4) {
            return str;
        }
        if (z4) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i4))).concat("...");
        }
        return null;
    }

    public final SecureRandom q0() {
        h();
        if (this.f4738c == null) {
            this.f4738c = new SecureRandom();
        }
        return this.f4738c;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int r(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.Object r16, android.os.Bundle r17, java.util.List r18, boolean r19, boolean r20) {
        /*
            Method dump skipped, instruction units count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.l7.r(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    public final Object s(String str, Object obj) {
        if ("_ev".equals(str)) {
            return n0(this.f4245a.w().y(null, false), obj, true, true, null);
        }
        return n0(N(str) ? this.f4245a.w().y(null, false) : this.f4245a.w().x(null, false), obj, false, true, null);
    }

    public final Bundle s0(Uri uri) {
        String queryParameter;
        String queryParameter2;
        String queryParameter3;
        String queryParameter4;
        String queryParameter5;
        String queryParameter6;
        String queryParameter7;
        String queryParameter8;
        String queryParameter9;
        String str;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                queryParameter = uri.getQueryParameter("utm_campaign");
                queryParameter2 = uri.getQueryParameter("utm_source");
                queryParameter3 = uri.getQueryParameter("utm_medium");
                queryParameter4 = uri.getQueryParameter("gclid");
                queryParameter5 = uri.getQueryParameter("gbraid");
                queryParameter6 = uri.getQueryParameter("utm_id");
                queryParameter7 = uri.getQueryParameter("dclid");
                queryParameter8 = uri.getQueryParameter("srsltid");
                queryParameter9 = uri.getQueryParameter("sfmc_id");
            } else {
                queryParameter = null;
                queryParameter2 = null;
                queryParameter3 = null;
                queryParameter4 = null;
                queryParameter5 = null;
                queryParameter6 = null;
                queryParameter7 = null;
                queryParameter8 = null;
                queryParameter9 = null;
            }
            if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4) && TextUtils.isEmpty(queryParameter5) && TextUtils.isEmpty(queryParameter6) && TextUtils.isEmpty(queryParameter7) && TextUtils.isEmpty(queryParameter8) && TextUtils.isEmpty(queryParameter9)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(queryParameter)) {
                str = "sfmc_id";
            } else {
                str = "sfmc_id";
                bundle.putString("campaign", queryParameter);
            }
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("source", queryParameter2);
            }
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("medium", queryParameter3);
            }
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("gclid", queryParameter4);
            }
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("gbraid", queryParameter5);
            }
            String queryParameter10 = uri.getQueryParameter("gad_source");
            if (!TextUtils.isEmpty(queryParameter10)) {
                bundle.putString("gad_source", queryParameter10);
            }
            String queryParameter11 = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter11)) {
                bundle.putString(FirebaseAnalytics.Param.TERM, queryParameter11);
            }
            String queryParameter12 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter12)) {
                bundle.putString(FirebaseAnalytics.Param.CONTENT, queryParameter12);
            }
            String queryParameter13 = uri.getQueryParameter(FirebaseAnalytics.Param.ACLID);
            if (!TextUtils.isEmpty(queryParameter13)) {
                bundle.putString(FirebaseAnalytics.Param.ACLID, queryParameter13);
            }
            String queryParameter14 = uri.getQueryParameter(FirebaseAnalytics.Param.CP1);
            if (!TextUtils.isEmpty(queryParameter14)) {
                bundle.putString(FirebaseAnalytics.Param.CP1, queryParameter14);
            }
            String queryParameter15 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter15)) {
                bundle.putString("anid", queryParameter15);
            }
            if (!TextUtils.isEmpty(queryParameter6)) {
                bundle.putString(FirebaseAnalytics.Param.CAMPAIGN_ID, queryParameter6);
            }
            if (!TextUtils.isEmpty(queryParameter7)) {
                bundle.putString("dclid", queryParameter7);
            }
            String queryParameter16 = uri.getQueryParameter("utm_source_platform");
            if (!TextUtils.isEmpty(queryParameter16)) {
                bundle.putString(FirebaseAnalytics.Param.SOURCE_PLATFORM, queryParameter16);
            }
            String queryParameter17 = uri.getQueryParameter("utm_creative_format");
            if (!TextUtils.isEmpty(queryParameter17)) {
                bundle.putString(FirebaseAnalytics.Param.CREATIVE_FORMAT, queryParameter17);
            }
            String queryParameter18 = uri.getQueryParameter("utm_marketing_tactic");
            if (!TextUtils.isEmpty(queryParameter18)) {
                bundle.putString(FirebaseAnalytics.Param.MARKETING_TACTIC, queryParameter18);
            }
            if (!TextUtils.isEmpty(queryParameter8)) {
                bundle.putString("srsltid", queryParameter8);
            }
            if (!TextUtils.isEmpty(queryParameter9)) {
                bundle.putString(str, queryParameter9);
            }
            for (String str2 : uri.getQueryParameterNames()) {
                if (str2.startsWith("gad_")) {
                    String queryParameter19 = uri.getQueryParameter(str2);
                    if (!TextUtils.isEmpty(queryParameter19)) {
                        bundle.putString(str2, queryParameter19);
                    }
                }
            }
            return bundle;
        } catch (UnsupportedOperationException e4) {
            this.f4245a.a().r().b("Install referrer url isn't a hierarchical URI", e4);
            return null;
        }
    }

    public final Bundle t(String str, String str2, Bundle bundle, List list, boolean z4) {
        int iZ0;
        List list2 = list;
        boolean zO = O(str2, AbstractC0539b4.f4353d);
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        C0658q3 c0658q3 = this.f4245a;
        int iV = c0658q3.w().v();
        int i4 = 0;
        boolean z5 = false;
        for (String str3 : new TreeSet(bundle.keySet())) {
            if (list2 == null || !list2.contains(str3)) {
                iZ0 = !z4 ? z0(str3) : 0;
                if (iZ0 == 0) {
                    iZ0 = A0(str3);
                }
            } else {
                iZ0 = 0;
            }
            if (iZ0 != 0) {
                x(bundle2, iZ0, str3, iZ0 == 3 ? str3 : null);
                bundle2.remove(str3);
            } else {
                int iR = r(str, str2, str3, bundle.get(str3), bundle2, list2, z4, zO);
                if (iR == 17) {
                    x(bundle2, 17, str3, Boolean.FALSE);
                } else if (iR != 0 && !"_ev".equals(str3)) {
                    x(bundle2, iR, iR == 21 ? str2 : str3, bundle.get(str3));
                    bundle2.remove(str3);
                }
                if (r0(str3) && (i4 = i4 + 1) > iV) {
                    if (!c0658q3.w().H(null, AbstractC0569f2.f4574g1) || !z5) {
                        StringBuilder sb = new StringBuilder(String.valueOf(iV).length() + 37);
                        sb.append("Event can't contain more than ");
                        sb.append(iV);
                        sb.append(" params");
                        c0658q3.a().q().c(sb.toString(), c0658q3.D().a(str2), c0658q3.D().e(bundle));
                    }
                    m0(bundle2, 5);
                    bundle2.remove(str3);
                    z5 = true;
                }
            }
            list2 = list;
        }
        return bundle2;
    }

    public final boolean t0(String str, String str2) {
        if (str2 == null) {
            this.f4245a.a().q().b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            this.f4245a.a().q().b("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            this.f4245a.a().q().c("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                this.f4245a.a().q().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final void u(D2 d22, int i4) {
        Bundle bundle = d22.f3903d;
        int i5 = 0;
        boolean z4 = false;
        for (String str : new TreeSet(bundle.keySet())) {
            if (r0(str) && (i5 = i5 + 1) > i4) {
                C0658q3 c0658q3 = this.f4245a;
                if (!c0658q3.w().H(null, AbstractC0569f2.f4574g1) || !z4) {
                    StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 37);
                    sb.append("Event can't contain more than ");
                    sb.append(i4);
                    sb.append(" params");
                    c0658q3.a().q().c(sb.toString(), c0658q3.D().a(d22.f3900a), c0658q3.D().e(bundle));
                    m0(bundle, 5);
                }
                bundle.remove(str);
                z4 = true;
            }
        }
    }

    public final boolean u0(String str, String str2) {
        if (str2 == null) {
            this.f4245a.a().q().b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            this.f4245a.a().q().b("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            if (iCodePointAt != 95) {
                this.f4245a.a().q().c("Name must start with a letter or _ (underscore). Type, name", str, str2);
                return false;
            }
            iCodePointAt = 95;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                this.f4245a.a().q().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final void v(Parcelable[] parcelableArr, int i4) {
        AbstractC0940s.k(parcelableArr);
        for (Parcelable parcelable : parcelableArr) {
            Bundle bundle = (Bundle) parcelable;
            int i5 = 0;
            boolean z4 = false;
            for (String str : new TreeSet(bundle.keySet())) {
                if (r0(str) && !O(str, AbstractC0547c4.f4430d) && (i5 = i5 + 1) > i4) {
                    C0658q3 c0658q3 = this.f4245a;
                    if (!c0658q3.w().H(null, AbstractC0569f2.f4574g1) || !z4) {
                        A2 a2Q = c0658q3.a().q();
                        StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 60);
                        sb.append("Param can't contain more than ");
                        sb.append(i4);
                        sb.append(" item-scoped custom parameters");
                        a2Q.c(sb.toString(), c0658q3.D().b(str), c0658q3.D().e(bundle));
                    }
                    m0(bundle, 28);
                    bundle.remove(str);
                    z4 = true;
                }
            }
        }
    }

    public final boolean v0(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            this.f4245a.a().q().b("Name is required and can't be null. Type", str);
            return false;
        }
        AbstractC0940s.k(str2);
        String[] strArr3 = f4736i;
        for (int i4 = 0; i4 < 3; i4++) {
            if (str2.startsWith(strArr3[i4])) {
                this.f4245a.a().q().c("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !O(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && O(str2, strArr2)) {
            return true;
        }
        this.f4245a.a().q().c("Name is reserved. Type, name", str, str2);
        return false;
    }

    public final void w(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                this.f4245a.C().A(bundle, str, bundle2.get(str));
            }
        }
    }

    public final boolean w0(String str, int i4, String str2) {
        if (str2 == null) {
            this.f4245a.a().q().b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i4) {
            return true;
        }
        this.f4245a.a().q().d("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i4), str2);
        return false;
    }

    public final void x(Bundle bundle, int i4, String str, Object obj) {
        if (m0(bundle, i4)) {
            this.f4245a.w();
            bundle.putString("_ev", q(str, 40, true));
            if (obj != null) {
                AbstractC0940s.k(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", obj.toString().length());
                }
            }
        }
    }

    public final int x0(String str) {
        if (!u0("event", str)) {
            return 2;
        }
        if (!v0("event", AbstractC0539b4.f4350a, AbstractC0539b4.f4351b, str)) {
            return 13;
        }
        this.f4245a.w();
        return !w0("event", 40, str) ? 2 : 0;
    }

    public final int y(String str, Object obj) {
        return "_ldl".equals(str) ? C0("user property referrer", str, o0(str), obj) : C0("user property", str, o0(str), obj) ? 0 : 7;
    }

    public final int y0(String str) {
        if (!u0("user property", str)) {
            return 6;
        }
        if (!v0("user property", AbstractC0555d4.f4451a, null, str)) {
            return 15;
        }
        this.f4245a.w();
        return !w0("user property", 24, str) ? 6 : 0;
    }

    public final Object z(String str, Object obj) {
        return "_ldl".equals(str) ? n0(o0(str), obj, true, false, null) : n0(o0(str), obj, false, false, null);
    }

    public final int z0(String str) {
        if (!t0("event param", str)) {
            return 3;
        }
        if (!v0("event param", null, null, str)) {
            return 14;
        }
        this.f4245a.w();
        return !w0("event param", 40, str) ? 3 : 0;
    }
}
