package h7;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.tasks.Tasks;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f11081f = "h7.o";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f11085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final fa.b f11086e;

    public o(a7.g gVar) {
        this(gVar.m(), gVar.r(), ((j) e7.e.f(gVar)).r());
    }

    public static String f(int i10) {
        if (i10 == 2) {
            return "https://firebaseappcheck.googleapis.com/v1/projects/%s/apps/%s:exchangeDebugToken?key=%s";
        }
        if (i10 == 3) {
            return "https://firebaseappcheck.googleapis.com/v1/projects/%s/apps/%s:exchangePlayIntegrityToken?key=%s";
        }
        if (i10 == 4) {
            return "https://firebaseappcheck.googleapis.com/v1/projects/%s/apps/%s:exchangeRecaptchaEnterpriseToken?key=%s";
        }
        throw new IllegalArgumentException("Unknown token type.");
    }

    public static boolean g(int i10) {
        return i10 >= 200 && i10 < 300;
    }

    public HttpURLConnection a(URL url) {
        return (HttpURLConnection) url.openConnection();
    }

    public a b(byte[] bArr, int i10, p pVar) throws a7.m {
        if (pVar.a()) {
            return a.a(h(new URL(String.format(f(i10), this.f11085d, this.f11084c, this.f11083b)), bArr, pVar, true));
        }
        throw new a7.m("Too many attempts.");
    }

    public String c(byte[] bArr, p pVar) throws a7.m {
        if (pVar.a()) {
            return h(new URL(String.format("https://firebaseappcheck.googleapis.com/v1/projects/%s/apps/%s:generatePlayIntegrityChallenge?key=%s", this.f11085d, this.f11084c, this.f11083b)), bArr, pVar, false);
        }
        throw new a7.m("Too many attempts.");
    }

    public final String d() {
        try {
            Context context = this.f11082a;
            byte[] bArrA = t5.a.a(context, context.getPackageName());
            if (bArrA != null) {
                return t5.j.c(bArrA, false);
            }
            Log.e(f11081f, "Could not get fingerprint hash for package: " + this.f11082a.getPackageName());
            return null;
        } catch (PackageManager.NameNotFoundException e10) {
            Log.e(f11081f, "No such package: " + this.f11082a.getPackageName(), e10);
            return null;
        }
    }

    public String e() {
        o9.i iVar = (o9.i) this.f11086e.get();
        if (iVar != null) {
            try {
                return (String) Tasks.await(iVar.a());
            } catch (Exception unused) {
                Log.w(f11081f, "Unable to get heartbeats!");
            }
        }
        return null;
    }

    public final String h(URL url, byte[] bArr, p pVar, boolean z10) {
        HttpURLConnection httpURLConnectionA = a(url);
        try {
            httpURLConnectionA.setDoOutput(true);
            httpURLConnectionA.setFixedLengthStreamingMode(bArr.length);
            httpURLConnectionA.setRequestProperty("Content-Type", "application/json");
            String strE = e();
            if (strE != null) {
                httpURLConnectionA.setRequestProperty("X-Firebase-Client", strE);
            }
            httpURLConnectionA.setRequestProperty("X-Android-Package", this.f11082a.getPackageName());
            httpURLConnectionA.setRequestProperty("X-Android-Cert", d());
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnectionA.getOutputStream(), bArr.length);
            try {
                bufferedOutputStream.write(bArr, 0, bArr.length);
                bufferedOutputStream.close();
                int responseCode = httpURLConnectionA.getResponseCode();
                InputStream inputStream = g(responseCode) ? httpURLConnectionA.getInputStream() : httpURLConnectionA.getErrorStream();
                StringBuilder sb2 = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb2.append(line);
                    } finally {
                    }
                }
                bufferedReader.close();
                String string = sb2.toString();
                if (g(responseCode)) {
                    if (z10) {
                        pVar.c();
                    }
                    httpURLConnectionA.disconnect();
                    return string;
                }
                pVar.d(responseCode);
                n nVarA = n.a(string);
                throw new a7.m("Error returned from API. code: " + nVarA.b() + " body: " + nVarA.c());
            } finally {
            }
        } catch (Throwable th) {
            httpURLConnectionA.disconnect();
            throw th;
        }
    }

    public o(Context context, a7.p pVar, fa.b bVar) {
        com.google.android.gms.common.internal.s.k(context);
        com.google.android.gms.common.internal.s.k(pVar);
        com.google.android.gms.common.internal.s.k(bVar);
        this.f11082a = context;
        this.f11083b = pVar.b();
        this.f11084c = pVar.c();
        String strG = pVar.g();
        this.f11085d = strG;
        if (strG != null) {
            this.f11086e = bVar;
            return;
        }
        throw new IllegalArgumentException("FirebaseOptions#getProjectId cannot be null.");
    }
}
