package i2;

import P1.C0653g;
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
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.measurement.zzcu;
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

/* JADX INFO: loaded from: classes.dex */
public final class l7 extends U3 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String[] f15895i = {"firebase_", "google_", "ga_"};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String[] f15896j = {"_err"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SecureRandom f15897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicLong f15898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f15899e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public A0.a f15900f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Boolean f15901g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f15902h;

    public l7(C1898q3 c1898q3) {
        super(c1898q3);
        this.f15902h = null;
        this.f15898d = new AtomicLong(0L);
    }

    public static MessageDigest C() {
        MessageDigest messageDigest;
        for (int i7 = 0; i7 < 2; i7++) {
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
        AbstractC1207s.k(bArr);
        int length = bArr.length;
        int i7 = 0;
        AbstractC1207s.n(length > 0);
        long j7 = 0;
        for (int i8 = length - 1; i8 >= 0 && i8 >= bArr.length - 8; i8--) {
            j7 += (((long) bArr[i8]) & 255) << i7;
            i7 += 8;
        }
        return j7;
    }

    public static boolean E(Context context, boolean z7) {
        AbstractC1207s.k(context);
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
        AbstractC1207s.k(strArr);
        for (String str2 : strArr) {
            if (Objects.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean U(String str) {
        return !f15896j[0].equals(str);
    }

    public static ArrayList h0(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C1830i c1830i = (C1830i) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", c1830i.f15826a);
            bundle.putString("origin", c1830i.f15827b);
            bundle.putLong("creation_timestamp", c1830i.f15829d);
            bundle.putString("name", c1830i.f15828c.f15820b);
            W3.a(bundle, AbstractC1207s.k(c1830i.f15828c.A()));
            bundle.putBoolean("active", c1830i.f15830e);
            String str = c1830i.f15831f;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            C1750J c1750j = c1830i.f15832g;
            if (c1750j != null) {
                bundle.putString("timed_out_event_name", c1750j.f15164a);
                C1748H c1748h = c1750j.f15165b;
                if (c1748h != null) {
                    bundle.putBundle("timed_out_event_params", c1748h.F());
                }
            }
            bundle.putLong("trigger_timeout", c1830i.f15833h);
            C1750J c1750j2 = c1830i.f15834i;
            if (c1750j2 != null) {
                bundle.putString("triggered_event_name", c1750j2.f15164a);
                C1748H c1748h2 = c1750j2.f15165b;
                if (c1748h2 != null) {
                    bundle.putBundle("triggered_event_params", c1748h2.F());
                }
            }
            bundle.putLong("triggered_timestamp", c1830i.f15828c.f15821c);
            bundle.putLong("time_to_live", c1830i.f15835j);
            C1750J c1750j3 = c1830i.f15836k;
            if (c1750j3 != null) {
                bundle.putString("expired_event_name", c1750j3.f15164a);
                C1748H c1748h3 = c1750j3.f15165b;
                if (c1748h3 != null) {
                    bundle.putBundle("expired_event_params", c1748h3.F());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static boolean j0(Context context) {
        ActivityInfo receiverInfo;
        AbstractC1207s.k(context);
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

    public static void k0(C1868m5 c1868m5, Bundle bundle, boolean z7) {
        if (bundle != null && c1868m5 != null) {
            if (!bundle.containsKey("_sc") || z7) {
                String str = c1868m5.f15910a;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = c1868m5.f15911b;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", c1868m5.f15912c);
                return;
            }
            z7 = false;
        }
        if (bundle != null && c1868m5 == null && z7) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public static final boolean m0(Bundle bundle, int i7) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i7);
        return true;
    }

    public static boolean r0(String str) {
        AbstractC1207s.e(str);
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
            C1898q3 c1898q3 = this.f15404a;
            c1898q3.a().t().c("Not putting event parameter. Invalid value type. name, type", c1898q3.D().b(str), simpleName);
        }
    }

    public final int A0(String str) {
        if (!u0("event param", str)) {
            return 3;
        }
        if (!v0("event param", null, null, str)) {
            return 14;
        }
        this.f15404a.w();
        return !w0("event param", 40, str) ? 3 : 0;
    }

    public final void B(k7 k7Var, String str, int i7, String str2, String str3, int i8) {
        Bundle bundle = new Bundle();
        m0(bundle, i7);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i7 == 6 || i7 == 7 || i7 == 2) {
            bundle.putLong("_el", i8);
        }
        k7Var.a(str, "_err", bundle);
    }

    public final boolean B0(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    public final boolean C0(String str, String str2, int i7, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String string = obj.toString();
            if (string.codePointCount(0, string.length()) > i7) {
                this.f15404a.a().t().d("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(string.length()));
                return false;
            }
        }
        return true;
    }

    public final void D0(String str, String str2, String str3, Bundle bundle, List list, boolean z7) {
        int iZ0;
        int i7;
        char c7;
        String str4;
        int i8;
        int iR;
        if (bundle == null) {
            return;
        }
        C1898q3 c1898q3 = this.f15404a;
        char c8 = 20064;
        int i9 = true != c1898q3.w().f15404a.C().V(231100000, true) ? 0 : 35;
        int i10 = 0;
        boolean z8 = false;
        for (String str5 : new TreeSet(bundle.keySet())) {
            if (list == null || !list.contains(str5)) {
                iZ0 = !z7 ? z0(str5) : 0;
                if (iZ0 == 0) {
                    iZ0 = A0(str5);
                }
            } else {
                iZ0 = 0;
            }
            if (iZ0 != 0) {
                x(bundle, iZ0, str5, iZ0 == 3 ? str5 : null);
                bundle.remove(str5);
                i7 = i9;
                c7 = c8;
            } else {
                if (B0(bundle.get(str5))) {
                    c1898q3.a().t().d("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str5);
                    iR = 22;
                    str4 = str5;
                    i8 = i9;
                } else {
                    str4 = str5;
                    i8 = i9;
                    iR = r(str, str2, str5, bundle.get(str5), bundle, list, z7, false);
                }
                if (iR != 0 && !"_ev".equals(str4)) {
                    x(bundle, iR, str4, bundle.get(str4));
                    bundle.remove(str4);
                } else if (r0(str4) && !O(str4, AbstractC1787c4.f15589d)) {
                    int i11 = i10 + 1;
                    c7 = 20064;
                    if (V(231100000, true)) {
                        i7 = i8;
                        if (i11 > i7) {
                            if (!c1898q3.w().H(null, AbstractC1809f2.f15733g1) || !z8) {
                                A2 a2Q = c1898q3.a().q();
                                StringBuilder sb = new StringBuilder(String.valueOf(i7).length() + 55);
                                sb.append("Item can't contain more than ");
                                sb.append(i7);
                                sb.append(" item-scoped custom params");
                                a2Q.c(sb.toString(), c1898q3.D().a(str2), c1898q3.D().e(bundle));
                            }
                            m0(bundle, 28);
                            bundle.remove(str4);
                            i10 = i11;
                            c8 = 20064;
                            i9 = i7;
                            z8 = true;
                        }
                    } else {
                        c1898q3.a().q().c("Item array not supported on client's version of Google Play Services (Android Only)", c1898q3.D().a(str2), c1898q3.D().e(bundle));
                        m0(bundle, 23);
                        bundle.remove(str4);
                        i7 = i8;
                    }
                    i10 = i11;
                }
                i7 = i8;
                c7 = 20064;
            }
            c8 = c7;
            i9 = i7;
        }
    }

    public final boolean G() {
        h();
        return J() == 1;
    }

    public final A0.a H() {
        if (this.f15900f == null) {
            this.f15900f = A0.a.a(this.f15404a.e());
        }
        return this.f15900f;
    }

    public final int I() {
        if (Build.VERSION.SDK_INT < 30 || SdkExtensions.getExtensionVersion(30) <= 3) {
            return 0;
        }
        return SdkExtensions.getExtensionVersion(1000000);
    }

    public final long J() {
        long j7;
        h();
        if (!L(this.f15404a.L().q())) {
            return 0L;
        }
        if (Build.VERSION.SDK_INT < 30) {
            j7 = 4;
        } else if (SdkExtensions.getExtensionVersion(30) < 4) {
            j7 = 8;
        } else {
            C1898q3 c1898q3 = this.f15404a;
            int I6 = I();
            c1898q3.w();
            j7 = I6 < ((Integer) AbstractC1809f2.f15749m0.b(null)).intValue() ? 16L : 0L;
        }
        if (!M("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")) {
            j7 |= 2;
        }
        if (j7 == 0 && !K()) {
            j7 = 64;
        }
        if (j7 == 0) {
            return 1L;
        }
        return j7;
    }

    public final boolean K() {
        Object e7;
        Integer num;
        if (this.f15901g == null) {
            A0.a aVarH = H();
            boolean z7 = false;
            if (aVarH == null) {
                return false;
            }
            try {
                num = (Integer) aVarH.b().get(10000L, TimeUnit.MILLISECONDS);
                if (num != null) {
                    try {
                        if (num.intValue() == 1) {
                            z7 = true;
                        }
                    } catch (InterruptedException e8) {
                        e7 = e8;
                        this.f15404a.a().r().b("Measurement manager api exception", e7);
                        this.f15901g = Boolean.FALSE;
                    } catch (CancellationException e9) {
                        e7 = e9;
                        this.f15404a.a().r().b("Measurement manager api exception", e7);
                        this.f15901g = Boolean.FALSE;
                    } catch (ExecutionException e10) {
                        e7 = e10;
                        this.f15404a.a().r().b("Measurement manager api exception", e7);
                        this.f15901g = Boolean.FALSE;
                    } catch (TimeoutException e11) {
                        e7 = e11;
                        this.f15404a.a().r().b("Measurement manager api exception", e7);
                        this.f15901g = Boolean.FALSE;
                    }
                }
                this.f15901g = Boolean.valueOf(z7);
            } catch (InterruptedException | CancellationException | ExecutionException | TimeoutException e12) {
                e7 = e12;
                num = null;
            }
            this.f15404a.a().w().b("Measurement manager api status result", num);
        }
        return this.f15901g.booleanValue();
    }

    public final boolean L(String str) {
        String str2 = (String) AbstractC1809f2.f15761s0.b(null);
        return str2.equals("*") || Arrays.asList(str2.split(com.amazon.a.a.o.b.f.f9989a)).contains(str);
    }

    public final boolean M(String str) {
        h();
        C1898q3 c1898q3 = this.f15404a;
        if (Y1.f.a(c1898q3.e()).a(str) == 0) {
            return true;
        }
        c1898q3.a().v().b("Permission not granted", str);
        return false;
    }

    public final boolean P(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        C1898q3 c1898q3 = this.f15404a;
        String strI = c1898q3.w().i();
        c1898q3.c();
        return strI.equals(str);
    }

    public final Bundle Q(Bundle bundle, String str) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str2 : bundle.keySet()) {
                Object objS = s(str2, bundle.get(str2));
                if (objS == null) {
                    C1898q3 c1898q3 = this.f15404a;
                    c1898q3.a().t().b("Param value can't be null", c1898q3.D().b(str2));
                } else {
                    A(bundle2, str2, objS);
                }
            }
        }
        return bundle2;
    }

    public final C1750J R(String str, String str2, Bundle bundle, String str3, long j7, boolean z7, boolean z8) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (x0(str2) != 0) {
            C1898q3 c1898q3 = this.f15404a;
            c1898q3.a().o().b("Invalid conditional property event name", c1898q3.D().c(str2));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str3);
        Bundle bundleT = t(str, str2, bundle2, W1.e.a("_o"), true);
        if (z7) {
            bundleT = Q(bundleT, str);
        }
        AbstractC1207s.k(bundleT);
        return new C1750J(str2, new C1748H(bundleT), str3, j7);
    }

    public final boolean S(Context context, String str) {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfoE = Y1.f.a(context).e(str, 64);
            if (packageInfoE == null || (signatureArr = packageInfoE.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e7) {
            this.f15404a.a().o().b("Package name not found", e7);
            return true;
        } catch (CertificateException e8) {
            this.f15404a.a().o().b("Error obtaining certificate", e8);
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

    public final boolean V(int i7, boolean z7) {
        Boolean boolX = this.f15404a.J().x();
        if (W() < i7 / 1000) {
            return (boolX == null || boolX.booleanValue()) ? false : true;
        }
        return true;
    }

    public final int W() {
        if (this.f15902h == null) {
            this.f15902h = Integer.valueOf(C0653g.f().a(this.f15404a.e()) / 1000);
        }
        return this.f15902h.intValue();
    }

    public final int X(int i7) {
        return C0653g.f().h(this.f15404a.e(), 12451000);
    }

    public final long Y(long j7, long j8) {
        return (j7 + (j8 * 60000)) / 86400000;
    }

    public final void Z(Bundle bundle, long j7) {
        long j8 = bundle.getLong("_et");
        if (j8 != 0) {
            this.f15404a.a().r().b("Params already contained engagement", Long.valueOf(j8));
        } else {
            j8 = 0;
        }
        bundle.putLong("_et", j7 + j8);
    }

    public final void a0(zzcu zzcuVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e7) {
            this.f15404a.a().r().b("Error returning string value to wrapper", e7);
        }
    }

    public final void b0(zzcu zzcuVar, long j7) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j7);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e7) {
            this.f15404a.a().r().b("Error returning long value to wrapper", e7);
        }
    }

    public final void c0(zzcu zzcuVar, int i7) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i7);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e7) {
            this.f15404a.a().r().b("Error returning int value to wrapper", e7);
        }
    }

    public final void d0(zzcu zzcuVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e7) {
            this.f15404a.a().r().b("Error returning byte array to wrapper", e7);
        }
    }

    public final void e0(zzcu zzcuVar, boolean z7) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z7);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e7) {
            this.f15404a.a().r().b("Error returning boolean value to wrapper", e7);
        }
    }

    public final void f0(zzcu zzcuVar, Bundle bundle) {
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e7) {
            this.f15404a.a().r().b("Error returning bundle value to wrapper", e7);
        }
    }

    public final void g0(zzcu zzcuVar, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzcuVar.zzb(bundle);
        } catch (RemoteException e7) {
            this.f15404a.a().r().b("Error returning bundle list to wrapper", e7);
        }
    }

    @Override // i2.U3
    public final boolean i() {
        return true;
    }

    public final URL i0(long j7, String str, String str2, long j8, String str3) {
        try {
            AbstractC1207s.e(str2);
            AbstractC1207s.e(str);
            String strConcat = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", 130000L, Integer.valueOf(W())), str2, str, Long.valueOf(j8));
            if (str.equals(this.f15404a.w().j())) {
                strConcat = strConcat.concat("&ddl_test=1");
            }
            if (!str3.isEmpty()) {
                if (str3.charAt(0) != '&') {
                    strConcat = strConcat.concat("&");
                }
                strConcat = strConcat.concat(str3);
            }
            return new URL(strConcat);
        } catch (IllegalArgumentException e7) {
            e = e7;
            this.f15404a.a().o().b("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        } catch (MalformedURLException e8) {
            e = e8;
            this.f15404a.a().o().b("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    @Override // i2.U3
    public final void j() {
        h();
        SecureRandom secureRandom = new SecureRandom();
        long jNextLong = secureRandom.nextLong();
        if (jNextLong == 0) {
            jNextLong = secureRandom.nextLong();
            if (jNextLong == 0) {
                this.f15404a.a().r().a("Utils falling back to Random for random id");
            }
        }
        this.f15898d.set(jNextLong);
    }

    public final String l0() {
        byte[] bArr = new byte[16];
        q0().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public final Object n0(int i7, Object obj, boolean z7, boolean z8, String str) {
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
            return q(obj.toString(), i7, z7);
        }
        if (!z8 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
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
            this.f15404a.a().q().a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            return false;
        }
        AbstractC1207s.k(str);
        if (str.matches("^1:\\d+:android:[a-f0-9]+$")) {
            return true;
        }
        this.f15404a.a().q().b("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", C2.x(str));
        return false;
    }

    public final int o0(String str) {
        if ("_ldl".equals(str)) {
            this.f15404a.w();
            return 2048;
        }
        if ("_id".equals(str)) {
            this.f15404a.w();
            return 256;
        }
        if ("_lgclid".equals(str)) {
            this.f15404a.w();
            return 100;
        }
        this.f15404a.w();
        return 36;
    }

    public final boolean p(String str, String str2) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        boolean zIsEmpty2 = TextUtils.isEmpty(str2);
        if (!zIsEmpty && !zIsEmpty2) {
            AbstractC1207s.k(str);
            if (!str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public final long p0() {
        long andIncrement;
        long j7;
        AtomicLong atomicLong = this.f15898d;
        if (atomicLong.get() != 0) {
            AtomicLong atomicLong2 = this.f15898d;
            synchronized (atomicLong2) {
                atomicLong2.compareAndSet(-1L, 1L);
                andIncrement = atomicLong2.getAndIncrement();
            }
            return andIncrement;
        }
        synchronized (atomicLong) {
            long jNextLong = new Random(System.nanoTime() ^ this.f15404a.f().a()).nextLong();
            int i7 = this.f15899e + 1;
            this.f15899e = i7;
            j7 = jNextLong + ((long) i7);
        }
        return j7;
    }

    public final String q(String str, int i7, boolean z7) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i7) {
            return str;
        }
        if (z7) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i7))).concat("...");
        }
        return null;
    }

    public final SecureRandom q0() {
        h();
        if (this.f15897c == null) {
            this.f15897c = new SecureRandom();
        }
        return this.f15897c;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int r(java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.Object r17, android.os.Bundle r18, java.util.List r19, boolean r20, boolean r21) {
        /*
            Method dump skipped, instruction units count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.l7.r(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    public final Object s(String str, Object obj) {
        if ("_ev".equals(str)) {
            return n0(this.f15404a.w().y(null, false), obj, true, true, null);
        }
        return n0(N(str) ? this.f15404a.w().y(null, false) : this.f15404a.w().x(null, false), obj, false, true, null);
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
                bundle.putString("term", queryParameter11);
            }
            String queryParameter12 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter12)) {
                bundle.putString("content", queryParameter12);
            }
            String queryParameter13 = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter13)) {
                bundle.putString("aclid", queryParameter13);
            }
            String queryParameter14 = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter14)) {
                bundle.putString("cp1", queryParameter14);
            }
            String queryParameter15 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter15)) {
                bundle.putString("anid", queryParameter15);
            }
            if (!TextUtils.isEmpty(queryParameter6)) {
                bundle.putString("campaign_id", queryParameter6);
            }
            if (!TextUtils.isEmpty(queryParameter7)) {
                bundle.putString("dclid", queryParameter7);
            }
            String queryParameter16 = uri.getQueryParameter("utm_source_platform");
            if (!TextUtils.isEmpty(queryParameter16)) {
                bundle.putString("source_platform", queryParameter16);
            }
            String queryParameter17 = uri.getQueryParameter("utm_creative_format");
            if (!TextUtils.isEmpty(queryParameter17)) {
                bundle.putString("creative_format", queryParameter17);
            }
            String queryParameter18 = uri.getQueryParameter("utm_marketing_tactic");
            if (!TextUtils.isEmpty(queryParameter18)) {
                bundle.putString("marketing_tactic", queryParameter18);
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
        } catch (UnsupportedOperationException e7) {
            this.f15404a.a().r().b("Install referrer url isn't a hierarchical URI", e7);
            return null;
        }
    }

    public final Bundle t(String str, String str2, Bundle bundle, List list, boolean z7) {
        int iZ0;
        int i7;
        C1898q3 c1898q3;
        List list2 = list;
        boolean zO = O(str2, AbstractC1779b4.f15512d);
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        C1898q3 c1898q32 = this.f15404a;
        int iV = c1898q32.w().v();
        int i8 = 0;
        boolean z8 = false;
        for (String str3 : new TreeSet(bundle.keySet())) {
            if (list2 == null || !list2.contains(str3)) {
                iZ0 = !z7 ? z0(str3) : 0;
                if (iZ0 == 0) {
                    iZ0 = A0(str3);
                }
            } else {
                iZ0 = 0;
            }
            if (iZ0 != 0) {
                x(bundle2, iZ0, str3, iZ0 == 3 ? str3 : null);
                bundle2.remove(str3);
                i7 = iV;
                c1898q3 = c1898q32;
            } else {
                i7 = iV;
                c1898q3 = c1898q32;
                int iR = r(str, str2, str3, bundle.get(str3), bundle2, list, z7, zO);
                if (iR == 17) {
                    x(bundle2, 17, str3, Boolean.FALSE);
                } else if (iR != 0 && !"_ev".equals(str3)) {
                    x(bundle2, iR, iR == 21 ? str2 : str3, bundle.get(str3));
                    bundle2.remove(str3);
                }
                if (r0(str3)) {
                    int i9 = i8 + 1;
                    if (i9 > i7) {
                        if (!c1898q3.w().H(null, AbstractC1809f2.f15733g1) || !z8) {
                            StringBuilder sb = new StringBuilder(String.valueOf(i7).length() + 37);
                            sb.append("Event can't contain more than ");
                            sb.append(i7);
                            sb.append(" params");
                            c1898q3.a().q().c(sb.toString(), c1898q3.D().a(str2), c1898q3.D().e(bundle));
                        }
                        m0(bundle2, 5);
                        bundle2.remove(str3);
                        z8 = true;
                    }
                    i8 = i9;
                }
                iV = i7;
                c1898q32 = c1898q3;
                list2 = list;
            }
            iV = i7;
            c1898q32 = c1898q3;
            list2 = list;
        }
        return bundle2;
    }

    public final boolean t0(String str, String str2) {
        if (str2 == null) {
            this.f15404a.a().q().b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            this.f15404a.a().q().b("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            this.f15404a.a().q().c("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                this.f15404a.a().q().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final void u(D2 d22, int i7) {
        Bundle bundle = d22.f15062d;
        int i8 = 0;
        boolean z7 = false;
        for (String str : new TreeSet(bundle.keySet())) {
            if (r0(str) && (i8 = i8 + 1) > i7) {
                C1898q3 c1898q3 = this.f15404a;
                if (!c1898q3.w().H(null, AbstractC1809f2.f15733g1) || !z7) {
                    StringBuilder sb = new StringBuilder(String.valueOf(i7).length() + 37);
                    sb.append("Event can't contain more than ");
                    sb.append(i7);
                    sb.append(" params");
                    c1898q3.a().q().c(sb.toString(), c1898q3.D().a(d22.f15059a), c1898q3.D().e(bundle));
                    m0(bundle, 5);
                }
                bundle.remove(str);
                z7 = true;
            }
        }
    }

    public final boolean u0(String str, String str2) {
        if (str2 == null) {
            this.f15404a.a().q().b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            this.f15404a.a().q().b("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            if (iCodePointAt != 95) {
                this.f15404a.a().q().c("Name must start with a letter or _ (underscore). Type, name", str, str2);
                return false;
            }
            iCodePointAt = 95;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                this.f15404a.a().q().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final void v(Parcelable[] parcelableArr, int i7) {
        AbstractC1207s.k(parcelableArr);
        for (Parcelable parcelable : parcelableArr) {
            Bundle bundle = (Bundle) parcelable;
            int i8 = 0;
            boolean z7 = false;
            for (String str : new TreeSet(bundle.keySet())) {
                if (r0(str) && !O(str, AbstractC1787c4.f15589d) && (i8 = i8 + 1) > i7) {
                    C1898q3 c1898q3 = this.f15404a;
                    if (!c1898q3.w().H(null, AbstractC1809f2.f15733g1) || !z7) {
                        A2 a2Q = c1898q3.a().q();
                        StringBuilder sb = new StringBuilder(String.valueOf(i7).length() + 60);
                        sb.append("Param can't contain more than ");
                        sb.append(i7);
                        sb.append(" item-scoped custom parameters");
                        a2Q.c(sb.toString(), c1898q3.D().b(str), c1898q3.D().e(bundle));
                    }
                    m0(bundle, 28);
                    bundle.remove(str);
                    z7 = true;
                }
            }
        }
    }

    public final boolean v0(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            this.f15404a.a().q().b("Name is required and can't be null. Type", str);
            return false;
        }
        AbstractC1207s.k(str2);
        String[] strArr3 = f15895i;
        for (int i7 = 0; i7 < 3; i7++) {
            if (str2.startsWith(strArr3[i7])) {
                this.f15404a.a().q().c("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !O(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && O(str2, strArr2)) {
            return true;
        }
        this.f15404a.a().q().c("Name is reserved. Type, name", str, str2);
        return false;
    }

    public final void w(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                this.f15404a.C().A(bundle, str, bundle2.get(str));
            }
        }
    }

    public final boolean w0(String str, int i7, String str2) {
        if (str2 == null) {
            this.f15404a.a().q().b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i7) {
            return true;
        }
        this.f15404a.a().q().d("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i7), str2);
        return false;
    }

    public final void x(Bundle bundle, int i7, String str, Object obj) {
        if (m0(bundle, i7)) {
            this.f15404a.w();
            bundle.putString("_ev", q(str, 40, true));
            if (obj != null) {
                AbstractC1207s.k(bundle);
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
        if (!v0("event", AbstractC1779b4.f15509a, AbstractC1779b4.f15510b, str)) {
            return 13;
        }
        this.f15404a.w();
        return !w0("event", 40, str) ? 2 : 0;
    }

    public final int y(String str, Object obj) {
        return "_ldl".equals(str) ? C0("user property referrer", str, o0(str), obj) : C0("user property", str, o0(str), obj) ? 0 : 7;
    }

    public final int y0(String str) {
        if (!u0("user property", str)) {
            return 6;
        }
        if (!v0("user property", AbstractC1795d4.f15610a, null, str)) {
            return 15;
        }
        this.f15404a.w();
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
        this.f15404a.w();
        return !w0("event param", 40, str) ? 3 : 0;
    }
}
