package p1;

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
import o1.C2291c;
import p1.C2369d;
import q1.AbstractC2550a;
import q1.n;
import q1.o;
import q1.p;
import q1.q;
import q1.r;
import q1.s;
import q1.t;
import q1.u;
import q1.v;
import q1.w;
import q1.x;
import r1.h;
import r1.i;
import s1.f;
import s1.g;
import s1.m;
import v1.AbstractC2763a;
import v3.InterfaceC2765a;
import w1.AbstractC2772b;
import w1.InterfaceC2771a;
import w1.InterfaceC2773c;

/* JADX INFO: renamed from: p1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2369d implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2765a f21459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f21460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f21461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final URL f21462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final B1.a f21463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final B1.a f21464f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f21465g;

    /* JADX INFO: renamed from: p1.d$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final URL f21466a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n f21467b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f21468c;

        public a(URL url, n nVar, String str) {
            this.f21466a = url;
            this.f21467b = nVar;
            this.f21468c = str;
        }

        public a a(URL url) {
            return new a(url, this.f21467b, this.f21468c);
        }
    }

    /* JADX INFO: renamed from: p1.d$b */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21469a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final URL f21470b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f21471c;

        public b(int i7, URL url, long j7) {
            this.f21469a = i7;
            this.f21470b = url;
            this.f21471c = j7;
        }
    }

    public C2369d(Context context, B1.a aVar, B1.a aVar2, int i7) {
        this.f21459a = n.b();
        this.f21461c = context;
        this.f21460b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f21462d = o(C2366a.f21450c);
        this.f21463e = aVar2;
        this.f21464f = aVar;
        this.f21465g = i7;
    }

    public static String f(Context context) {
        String simOperator = k(context).getSimOperator();
        return simOperator != null ? simOperator : "";
    }

    public static int g(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return w.b.UNKNOWN_MOBILE_SUBTYPE.b();
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == -1) {
            return w.b.COMBINED.b();
        }
        if (w.b.a(subtype) != null) {
            return subtype;
        }
        return 0;
    }

    public static int h(NetworkInfo networkInfo) {
        return networkInfo == null ? w.c.NONE.b() : networkInfo.getType();
    }

    public static int i(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e7) {
            AbstractC2763a.d("CctTransportBackend", "Unable to find version code for package", e7);
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
        URL url = bVar.f21470b;
        if (url == null) {
            return null;
        }
        AbstractC2763a.b("CctTransportBackend", "Following redirect to: %s", url);
        return aVar.a(bVar.f21470b);
    }

    public static InputStream n(InputStream inputStream, String str) {
        return "gzip".equals(str) ? new GZIPInputStream(inputStream) : inputStream;
    }

    public static URL o(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e7) {
            throw new IllegalArgumentException("Invalid url: " + str, e7);
        }
    }

    @Override // s1.m
    public g a(f fVar) {
        n nVarJ = j(fVar);
        URL urlO = this.f21462d;
        if (fVar.c() != null) {
            try {
                C2366a c2366aD = C2366a.d(fVar.c());
                strE = c2366aD.e() != null ? c2366aD.e() : null;
                if (c2366aD.f() != null) {
                    urlO = o(c2366aD.f());
                }
            } catch (IllegalArgumentException unused) {
                return g.a();
            }
        }
        try {
            b bVar = (b) AbstractC2772b.a(5, new a(urlO, nVarJ, strE), new InterfaceC2771a() { // from class: p1.b
                @Override // w1.InterfaceC2771a
                public final Object apply(Object obj) {
                    return this.f21458a.e((C2369d.a) obj);
                }
            }, new InterfaceC2773c() { // from class: p1.c
                @Override // w1.InterfaceC2773c
                public final Object a(Object obj, Object obj2) {
                    return C2369d.m((C2369d.a) obj, (C2369d.b) obj2);
                }
            });
            int i7 = bVar.f21469a;
            if (i7 == 200) {
                return g.e(bVar.f21471c);
            }
            if (i7 < 500 && i7 != 404) {
                return i7 == 400 ? g.d() : g.a();
            }
            return g.f();
        } catch (IOException e7) {
            AbstractC2763a.d("CctTransportBackend", "Could not make request to the backend", e7);
            return g.f();
        }
    }

    @Override // s1.m
    public i b(i iVar) {
        NetworkInfo activeNetworkInfo = this.f21460b.getActiveNetworkInfo();
        return iVar.p().a("sdk-version", Build.VERSION.SDK_INT).c("model", Build.MODEL).c("hardware", Build.HARDWARE).c("device", Build.DEVICE).c("product", Build.PRODUCT).c("os-uild", Build.ID).c("manufacturer", Build.MANUFACTURER).c("fingerprint", Build.FINGERPRINT).b("tz-offset", l()).a("net-type", h(activeNetworkInfo)).a("mobile-subtype", g(activeNetworkInfo)).c("country", Locale.getDefault().getCountry()).c("locale", Locale.getDefault().getLanguage()).c("mcc_mnc", f(this.f21461c)).c("application_build", Integer.toString(i(this.f21461c))).d();
    }

    public final b e(a aVar) throws IOException {
        AbstractC2763a.f("CctTransportBackend", "Making request to: %s", aVar.f21466a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) aVar.f21466a.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(this.f21465g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", "3.3.0"));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = aVar.f21468c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    this.f21459a.a(aVar.f21467b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    AbstractC2763a.f("CctTransportBackend", "Status Code: %d", Integer.valueOf(responseCode));
                    AbstractC2763a.b("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField("Content-Type"));
                    AbstractC2763a.b("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField("Content-Encoding"));
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
        } catch (ConnectException e7) {
            e = e7;
            AbstractC2763a.d("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (UnknownHostException e8) {
            e = e8;
            AbstractC2763a.d("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (IOException e9) {
            e = e9;
            AbstractC2763a.d("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(RCHTTPStatusCodes.BAD_REQUEST, null, 0L);
        } catch (v3.c e10) {
            e = e10;
            AbstractC2763a.d("CctTransportBackend", "Couldn't encode request, returning with 400", e);
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
            u.a aVarB = u.a().f(x.DEFAULT).g(this.f21464f.a()).h(this.f21463e.a()).b(o.a().c(o.b.ANDROID_FIREBASE).b(AbstractC2550a.a().m(Integer.valueOf(iVar2.i("sdk-version"))).j(iVar2.b("model")).f(iVar2.b("hardware")).d(iVar2.b("device")).l(iVar2.b("product")).k(iVar2.b("os-uild")).h(iVar2.b("manufacturer")).e(iVar2.b("fingerprint")).c(iVar2.b("country")).g(iVar2.b("locale")).i(iVar2.b("mcc_mnc")).b(iVar2.b("application_build")).a()).a());
            try {
                aVarB.i(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                aVarB.j((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (i iVar3 : (List) entry.getValue()) {
                h hVarE = iVar3.e();
                C2291c c2291cB = hVarE.b();
                if (c2291cB.equals(C2291c.b("proto"))) {
                    aVarL = t.l(hVarE.a());
                } else if (c2291cB.equals(C2291c.b("json"))) {
                    aVarL = t.k(new String(hVarE.a(), Charset.forName("UTF-8")));
                } else {
                    AbstractC2763a.g("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", c2291cB);
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

    public C2369d(Context context, B1.a aVar, B1.a aVar2) {
        this(context, aVar, aVar2, 130000);
    }
}
