package x1;

import A1.f;
import A1.g;
import A1.m;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
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
import w1.C2900c;
import w3.InterfaceC2922a;
import x1.d;
import y1.AbstractC2970a;
import y1.n;
import y1.o;
import y1.p;
import y1.q;
import y1.r;
import y1.s;
import y1.t;
import y1.u;
import y1.v;
import y1.w;
import y1.x;
import z1.h;
import z1.i;

/* JADX INFO: loaded from: classes.dex */
public final class d implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2922a f24155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f24156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f24157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final URL f24158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final J1.a f24159e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final J1.a f24160f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f24161g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final URL f24162a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n f24163b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f24164c;

        public a(URL url, n nVar, String str) {
            this.f24162a = url;
            this.f24163b = nVar;
            this.f24164c = str;
        }

        public a a(URL url) {
            return new a(url, this.f24163b, this.f24164c);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f24165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final URL f24166b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f24167c;

        public b(int i8, URL url, long j8) {
            this.f24165a = i8;
            this.f24166b = url;
            this.f24167c = j8;
        }
    }

    public d(Context context, J1.a aVar, J1.a aVar2) {
        this(context, aVar, aVar2, 130000);
    }

    public static String f(Context context) {
        String simOperator = k(context).getSimOperator();
        return simOperator != null ? simOperator : "";
    }

    public static int g(NetworkInfo networkInfo) {
        w.b bVar;
        if (networkInfo == null) {
            bVar = w.b.UNKNOWN_MOBILE_SUBTYPE;
        } else {
            int subtype = networkInfo.getSubtype();
            if (subtype != -1) {
                if (w.b.a(subtype) != null) {
                    return subtype;
                }
                return 0;
            }
            bVar = w.b.COMBINED;
        }
        return bVar.b();
    }

    public static int h(NetworkInfo networkInfo) {
        return networkInfo == null ? w.c.NONE.b() : networkInfo.getType();
    }

    public static int i(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e8) {
            D1.a.d("CctTransportBackend", "Unable to find version code for package", e8);
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

    public static /* synthetic */ a m(a aVar, b bVar) {
        URL url = bVar.f24166b;
        if (url == null) {
            return null;
        }
        D1.a.b("CctTransportBackend", "Following redirect to: %s", url);
        return aVar.a(bVar.f24166b);
    }

    public static InputStream n(InputStream inputStream, String str) {
        return "gzip".equals(str) ? new GZIPInputStream(inputStream) : inputStream;
    }

    public static URL o(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e8) {
            throw new IllegalArgumentException("Invalid url: " + str, e8);
        }
    }

    @Override // A1.m
    public i a(i iVar) {
        NetworkInfo activeNetworkInfo = this.f24156b.getActiveNetworkInfo();
        return iVar.p().a("sdk-version", Build.VERSION.SDK_INT).c("model", Build.MODEL).c("hardware", Build.HARDWARE).c("device", Build.DEVICE).c("product", Build.PRODUCT).c("os-uild", Build.ID).c("manufacturer", Build.MANUFACTURER).c("fingerprint", Build.FINGERPRINT).b("tz-offset", l()).a("net-type", h(activeNetworkInfo)).a("mobile-subtype", g(activeNetworkInfo)).c("country", Locale.getDefault().getCountry()).c("locale", Locale.getDefault().getLanguage()).c("mcc_mnc", f(this.f24157c)).c("application_build", Integer.toString(i(this.f24157c))).d();
    }

    @Override // A1.m
    public g b(f fVar) {
        n nVarJ = j(fVar);
        URL urlO = this.f24158d;
        if (fVar.c() != null) {
            try {
                C2952a c2952aD = C2952a.d(fVar.c());
                strE = c2952aD.e() != null ? c2952aD.e() : null;
                if (c2952aD.f() != null) {
                    urlO = o(c2952aD.f());
                }
            } catch (IllegalArgumentException unused) {
                return g.a();
            }
        }
        try {
            b bVar = (b) E1.b.a(5, new a(urlO, nVarJ, strE), new E1.a() { // from class: x1.b
                @Override // E1.a
                public final Object apply(Object obj) {
                    return this.f24154a.e((d.a) obj);
                }
            }, new E1.c() { // from class: x1.c
                @Override // E1.c
                public final Object a(Object obj, Object obj2) {
                    return d.m((d.a) obj, (d.b) obj2);
                }
            });
            int i8 = bVar.f24165a;
            if (i8 == 200) {
                return g.e(bVar.f24167c);
            }
            if (i8 < 500 && i8 != 404) {
                return i8 == 400 ? g.d() : g.a();
            }
            return g.f();
        } catch (IOException e8) {
            D1.a.d("CctTransportBackend", "Could not make request to the backend", e8);
            return g.f();
        }
    }

    public final b e(a aVar) throws IOException {
        D1.a.f("CctTransportBackend", "Making request to: %s", aVar.f24162a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) aVar.f24162a.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(this.f24161g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", "3.3.0"));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = aVar.f24164c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    this.f24155a.a(aVar.f24163b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    D1.a.f("CctTransportBackend", "Status Code: %d", Integer.valueOf(responseCode));
                    D1.a.b("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField("Content-Type"));
                    D1.a.b("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new b(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream inputStreamN = n(inputStream, httpURLConnection.getHeaderField("Content-Encoding"));
                        try {
                            b bVar = new b(responseCode, null, v.b(new BufferedReader(new InputStreamReader(inputStreamN))).c());
                            if (inputStreamN != null) {
                                inputStreamN.close();
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
        } catch (ConnectException e8) {
            e = e8;
            D1.a.d("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (UnknownHostException e9) {
            e = e9;
            D1.a.d("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (IOException e10) {
            e = e10;
            D1.a.d("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(RCHTTPStatusCodes.BAD_REQUEST, null, 0L);
        } catch (w3.c e11) {
            e = e11;
            D1.a.d("CctTransportBackend", "Couldn't encode request, returning with 400", e);
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
            u.a aVarB = u.a().f(x.DEFAULT).g(this.f24160f.a()).h(this.f24159e.a()).b(o.a().c(o.b.ANDROID_FIREBASE).b(AbstractC2970a.a().m(Integer.valueOf(iVar2.i("sdk-version"))).j(iVar2.b("model")).f(iVar2.b("hardware")).d(iVar2.b("device")).l(iVar2.b("product")).k(iVar2.b("os-uild")).h(iVar2.b("manufacturer")).e(iVar2.b("fingerprint")).c(iVar2.b("country")).g(iVar2.b("locale")).i(iVar2.b("mcc_mnc")).b(iVar2.b("application_build")).a()).a());
            try {
                aVarB.i(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                aVarB.j((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (i iVar3 : (List) entry.getValue()) {
                h hVarE = iVar3.e();
                C2900c c2900cB = hVarE.b();
                if (c2900cB.equals(C2900c.b("proto"))) {
                    aVarL = t.l(hVarE.a());
                } else if (c2900cB.equals(C2900c.b("json"))) {
                    aVarL = t.k(new String(hVarE.a(), Charset.forName("UTF-8")));
                } else {
                    D1.a.g("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", c2900cB);
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

    public d(Context context, J1.a aVar, J1.a aVar2, int i8) {
        this.f24155a = n.b();
        this.f24157c = context;
        this.f24156b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f24158d = o(C2952a.f24146c);
        this.f24159e = aVar2;
        this.f24160f = aVar;
        this.f24161g = i8;
    }
}
