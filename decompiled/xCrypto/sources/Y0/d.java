package Y0;

import Y0.d;
import Z0.n;
import Z0.o;
import Z0.p;
import Z0.q;
import Z0.r;
import Z0.s;
import Z0.t;
import Z0.u;
import Z0.v;
import Z0.w;
import Z0.x;
import a1.h;
import a1.i;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import b1.f;
import b1.g;
import b1.m;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import e1.AbstractC1228a;
import f1.AbstractC1244b;
import f1.InterfaceC1243a;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import k1.InterfaceC1567a;

/* JADX INFO: loaded from: classes.dex */
public final class d implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataEncoder f5659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f5660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f5661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final URL f5662d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InterfaceC1567a f5663e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final InterfaceC1567a f5664f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f5665g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final URL f5666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n f5667b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f5668c;

        public a(URL url, n nVar, String str) {
            this.f5666a = url;
            this.f5667b = nVar;
            this.f5668c = str;
        }

        public a a(URL url) {
            return new a(url, this.f5667b, this.f5668c);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final URL f5670b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f5671c;

        public b(int i4, URL url, long j4) {
            this.f5669a = i4;
            this.f5670b = url;
            this.f5671c = j4;
        }
    }

    public d(Context context, InterfaceC1567a interfaceC1567a, InterfaceC1567a interfaceC1567a2, int i4) {
        this.f5659a = n.b();
        this.f5661c = context;
        this.f5660b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f5662d = n(Y0.a.f5650c);
        this.f5663e = interfaceC1567a2;
        this.f5664f = interfaceC1567a;
        this.f5665g = i4;
    }

    public static /* synthetic */ a d(a aVar, b bVar) {
        URL url = bVar.f5670b;
        if (url == null) {
            return null;
        }
        AbstractC1228a.b("CctTransportBackend", "Following redirect to: %s", url);
        return aVar.a(bVar.f5670b);
    }

    public static String f(Context context) {
        String simOperator = k(context).getSimOperator();
        return simOperator != null ? simOperator : "";
    }

    public static int g(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return w.b.UNKNOWN_MOBILE_SUBTYPE.c();
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == -1) {
            return w.b.COMBINED.c();
        }
        if (w.b.a(subtype) != null) {
            return subtype;
        }
        return 0;
    }

    public static int h(NetworkInfo networkInfo) {
        return networkInfo == null ? w.c.NONE.c() : networkInfo.getType();
    }

    public static int i(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e4) {
            AbstractC1228a.d("CctTransportBackend", "Unable to find version code for package", e4);
            return -1;
        }
    }

    public static TelephonyManager k(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    public static long l() {
        Calendar.getInstance();
        return TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
    }

    public static InputStream m(InputStream inputStream, String str) {
        return "gzip".equals(str) ? new GZIPInputStream(inputStream) : inputStream;
    }

    public static URL n(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e4) {
            throw new IllegalArgumentException("Invalid url: " + str, e4);
        }
    }

    @Override // b1.m
    public i a(i iVar) {
        NetworkInfo activeNetworkInfo = this.f5660b.getActiveNetworkInfo();
        return iVar.p().a("sdk-version", Build.VERSION.SDK_INT).c("model", Build.MODEL).c("hardware", Build.HARDWARE).c("device", Build.DEVICE).c("product", Build.PRODUCT).c("os-uild", Build.ID).c("manufacturer", Build.MANUFACTURER).c("fingerprint", Build.FINGERPRINT).b("tz-offset", l()).a("net-type", h(activeNetworkInfo)).a("mobile-subtype", g(activeNetworkInfo)).c("country", Locale.getDefault().getCountry()).c("locale", Locale.getDefault().getLanguage()).c("mcc_mnc", f(this.f5661c)).c("application_build", Integer.toString(i(this.f5661c))).d();
    }

    @Override // b1.m
    public g b(f fVar) {
        n nVarJ = j(fVar);
        URL urlN = this.f5662d;
        if (fVar.c() != null) {
            try {
                Y0.a aVarD = Y0.a.d(fVar.c());
                strE = aVarD.e() != null ? aVarD.e() : null;
                if (aVarD.f() != null) {
                    urlN = n(aVarD.f());
                }
            } catch (IllegalArgumentException unused) {
                return g.a();
            }
        }
        try {
            b bVar = (b) AbstractC1244b.a(5, new a(urlN, nVarJ, strE), new InterfaceC1243a() { // from class: Y0.b
                @Override // f1.InterfaceC1243a
                public final Object apply(Object obj) {
                    return this.f5658a.e((d.a) obj);
                }
            }, new f1.c() { // from class: Y0.c
                @Override // f1.c
                public final Object a(Object obj, Object obj2) {
                    return d.d((d.a) obj, (d.b) obj2);
                }
            });
            int i4 = bVar.f5669a;
            if (i4 == 200) {
                return g.e(bVar.f5671c);
            }
            if (i4 < 500 && i4 != 404) {
                return i4 == 400 ? g.d() : g.a();
            }
            return g.f();
        } catch (IOException e4) {
            AbstractC1228a.d("CctTransportBackend", "Could not make request to the backend", e4);
            return g.f();
        }
    }

    public final b e(a aVar) throws IOException {
        AbstractC1228a.f("CctTransportBackend", "Making request to: %s", aVar.f5666a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) aVar.f5666a.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(this.f5665g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", "3.3.0"));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = aVar.f5668c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    this.f5659a.encode(aVar.f5667b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    AbstractC1228a.f("CctTransportBackend", "Status Code: %d", Integer.valueOf(responseCode));
                    AbstractC1228a.b("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField("Content-Type"));
                    AbstractC1228a.b("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new b(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream inputStreamM = m(inputStream, httpURLConnection.getHeaderField("Content-Encoding"));
                        try {
                            b bVar = new b(responseCode, null, v.b(new BufferedReader(new InputStreamReader(inputStreamM))).c());
                            if (inputStreamM != null) {
                                inputStreamM.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return bVar;
                        } finally {
                        }
                    } catch (Throwable th) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } finally {
                }
            } catch (Throwable th3) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        } catch (EncodingException e4) {
            e = e4;
            AbstractC1228a.d("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(RCHTTPStatusCodes.BAD_REQUEST, null, 0L);
        } catch (ConnectException e5) {
            e = e5;
            AbstractC1228a.d("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (UnknownHostException e6) {
            e = e6;
            AbstractC1228a.d("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (IOException e7) {
            e = e7;
            AbstractC1228a.d("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(RCHTTPStatusCodes.BAD_REQUEST, null, 0L);
        }
    }

    public final n j(f fVar) {
        t.a aVarL;
        HashMap map = new HashMap();
        for (i iVar : fVar.b()) {
            String strN = iVar.n();
            if (map.containsKey(strN)) {
                ((List) map.get(strN)).add(iVar);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(iVar);
                map.put(strN, arrayList);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            i iVar2 = (i) ((List) entry.getValue()).get(0);
            u.a aVarB = u.a().f(x.DEFAULT).g(this.f5664f.a()).h(this.f5663e.a()).b(o.a().c(o.b.ANDROID_FIREBASE).b(Z0.a.a().m(Integer.valueOf(iVar2.i("sdk-version"))).j(iVar2.b("model")).f(iVar2.b("hardware")).d(iVar2.b("device")).l(iVar2.b("product")).k(iVar2.b("os-uild")).h(iVar2.b("manufacturer")).e(iVar2.b("fingerprint")).c(iVar2.b("country")).g(iVar2.b("locale")).i(iVar2.b("mcc_mnc")).b(iVar2.b("application_build")).a()).a());
            try {
                aVarB.i(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                aVarB.j((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (i iVar3 : (List) entry.getValue()) {
                h hVarE = iVar3.e();
                X0.c cVarB = hVarE.b();
                if (cVarB.equals(X0.c.b("proto"))) {
                    aVarL = t.l(hVarE.a());
                } else if (cVarB.equals(X0.c.b("json"))) {
                    aVarL = t.k(new String(hVarE.a(), Charset.forName("UTF-8")));
                } else {
                    AbstractC1228a.g("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", cVarB);
                }
                aVarL.d(iVar3.f()).e(iVar3.o()).j(iVar3.j("tz-offset")).g(w.a().c(w.c.a(iVar3.i("net-type"))).b(w.b.a(iVar3.i("mobile-subtype"))).a());
                if (iVar3.d() != null) {
                    aVarL.c(iVar3.d());
                }
                if (iVar3.l() != null) {
                    aVarL.b(p.a().b(s.a().b(r.a().b(iVar3.l()).a()).a()).c(p.b.EVENT_OVERRIDE).a());
                }
                if (iVar3.g() != null || iVar3.h() != null) {
                    q.a aVarA = q.a();
                    if (iVar3.g() != null) {
                        aVarA.b(iVar3.g());
                    }
                    if (iVar3.h() != null) {
                        aVarA.c(iVar3.h());
                    }
                    aVarL.f(aVarA.a());
                }
                arrayList3.add(aVarL.a());
            }
            aVarB.c(arrayList3);
            arrayList2.add(aVarB.a());
        }
        return n.a(arrayList2);
    }

    public d(Context context, InterfaceC1567a interfaceC1567a, InterfaceC1567a interfaceC1567a2) {
        this(context, interfaceC1567a, interfaceC1567a2, 130000);
    }
}
