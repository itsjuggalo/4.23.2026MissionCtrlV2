package f4;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.C1228n;
import g4.C1639b;
import g4.InterfaceC1638a;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Uri f14121k = Uri.parse("https://firebasestorage.googleapis.com/v0");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static InterfaceC1638a f14122l = new C1639b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Exception f14123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e4.h f14124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f14125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map f14126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14127e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f14128f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14129g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public InputStream f14130h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HttpURLConnection f14131i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map f14132j = new HashMap();

    public e(e4.h hVar, Q2.g gVar) {
        AbstractC1207s.k(hVar);
        AbstractC1207s.k(gVar);
        this.f14124b = hVar;
        this.f14125c = gVar.m();
        G("x-firebase-gmpid", gVar.r().c());
    }

    public static String k(Uri uri) {
        String path = uri.getPath();
        return path == null ? "" : path.startsWith("/") ? path.substring(1) : path;
    }

    public final void A(String str, String str2) {
        D(str, str2);
        try {
            E();
        } catch (IOException e7) {
            Log.w("NetworkRequest", "error sending network request " + e() + " " + u(), e7);
            this.f14123a = e7;
            this.f14127e = -2;
        }
        C();
    }

    public void B(String str, String str2, Context context) {
        if (d(context)) {
            A(str, str2);
        }
    }

    public void C() {
        HttpURLConnection httpURLConnection = this.f14131i;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public void D(String str, String str2) {
        if (this.f14123a != null) {
            this.f14127e = -1;
            return;
        }
        if (Log.isLoggable("NetworkRequest", 3)) {
            Log.d("NetworkRequest", "sending network request " + e() + " " + u());
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f14125c.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            this.f14127e = -2;
            this.f14123a = new SocketException("Network subsystem is unavailable");
            return;
        }
        try {
            HttpURLConnection httpURLConnectionC = c();
            this.f14131i = httpURLConnectionC;
            httpURLConnectionC.setRequestMethod(e());
            b(this.f14131i, str, str2);
            y(this.f14131i);
            if (Log.isLoggable("NetworkRequest", 3)) {
                Log.d("NetworkRequest", "network request result " + this.f14127e);
            }
        } catch (IOException e7) {
            Log.w("NetworkRequest", "error sending network request " + e() + " " + u(), e7);
            this.f14123a = e7;
            this.f14127e = -2;
        }
    }

    public final void E() throws IOException {
        if (v()) {
            z(this.f14130h);
        } else {
            w(this.f14130h);
        }
    }

    public final void F() {
        this.f14123a = null;
        this.f14127e = 0;
    }

    public void G(String str, String str2) {
        this.f14132j.put(str, str2);
    }

    public void a(TaskCompletionSource taskCompletionSource, Object obj) {
        Exception excF = f();
        if (v() && excF == null) {
            taskCompletionSource.setResult(obj);
        } else {
            taskCompletionSource.setException(C1228n.e(excF, o()));
        }
    }

    public final void b(HttpURLConnection httpURLConnection, String str, String str2) throws IOException {
        byte[] bArrH;
        int i7;
        AbstractC1207s.k(httpURLConnection);
        if (TextUtils.isEmpty(str)) {
            Log.w("NetworkRequest", "no auth token for request");
        } else {
            httpURLConnection.setRequestProperty("Authorization", "Firebase " + str);
        }
        if (TextUtils.isEmpty(str2)) {
            Log.w("NetworkRequest", "No App Check token for request.");
        } else {
            httpURLConnection.setRequestProperty("x-firebase-appcheck", str2);
        }
        httpURLConnection.setRequestProperty("X-Firebase-Storage-Version", "Android/21.0.2");
        for (Map.Entry entry : this.f14132j.entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        JSONObject jSONObjectG = g();
        if (jSONObjectG != null) {
            bArrH = jSONObjectG.toString().getBytes("UTF-8");
            i7 = bArrH.length;
        } else {
            bArrH = h();
            i7 = i();
            if (i7 == 0 && bArrH != null) {
                i7 = bArrH.length;
            }
        }
        if (bArrH == null || bArrH.length <= 0) {
            httpURLConnection.setRequestProperty("Content-Length", "0");
        } else {
            if (jSONObjectG != null) {
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
            }
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Length", Integer.toString(i7));
        }
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        if (bArrH == null || bArrH.length <= 0) {
            return;
        }
        OutputStream outputStream = httpURLConnection.getOutputStream();
        if (outputStream == null) {
            Log.e("NetworkRequest", "Unable to write to the http request!");
            return;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        try {
            bufferedOutputStream.write(bArrH, 0, i7);
        } finally {
            bufferedOutputStream.close();
        }
    }

    public final HttpURLConnection c() {
        Uri uriU = u();
        Map mapL = l();
        if (mapL != null) {
            Uri.Builder builderBuildUpon = uriU.buildUpon();
            for (Map.Entry entry : mapL.entrySet()) {
                builderBuildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
            }
            uriU = builderBuildUpon.build();
        }
        return f14122l.a(new URL(uriU.toString()));
    }

    public final boolean d(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        this.f14123a = new SocketException("Network subsystem is unavailable");
        this.f14127e = -2;
        return false;
    }

    public abstract String e();

    public Exception f() {
        return this.f14123a;
    }

    public JSONObject g() {
        return null;
    }

    public byte[] h() {
        return null;
    }

    public int i() {
        return 0;
    }

    public String j() {
        return k(this.f14124b.a());
    }

    public Map l() {
        return null;
    }

    public String m() {
        return this.f14128f;
    }

    public JSONObject n() {
        if (TextUtils.isEmpty(this.f14128f)) {
            return new JSONObject();
        }
        try {
            return new JSONObject(this.f14128f);
        } catch (JSONException e7) {
            Log.e("NetworkRequest", "error parsing result into JSON:" + this.f14128f, e7);
            return new JSONObject();
        }
    }

    public int o() {
        return this.f14127e;
    }

    public Map p() {
        return this.f14126d;
    }

    public String q(String str) {
        List list;
        Map mapP = p();
        if (mapP == null || (list = (List) mapP.get(str)) == null || list.size() <= 0) {
            return null;
        }
        return (String) list.get(0);
    }

    public int r() {
        return this.f14129g;
    }

    public e4.h s() {
        return this.f14124b;
    }

    public InputStream t() {
        return this.f14130h;
    }

    public Uri u() {
        return this.f14124b.c();
    }

    public boolean v() {
        int i7 = this.f14127e;
        return i7 >= 200 && i7 < 300;
    }

    public void w(InputStream inputStream) throws IOException {
        x(inputStream);
    }

    public final void x(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        if (inputStream != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    } else {
                        sb.append(line);
                    }
                } finally {
                    bufferedReader.close();
                }
            }
        }
        this.f14128f = sb.toString();
        if (v()) {
            return;
        }
        this.f14123a = new IOException(this.f14128f);
    }

    public final void y(HttpURLConnection httpURLConnection) {
        AbstractC1207s.k(httpURLConnection);
        this.f14127e = httpURLConnection.getResponseCode();
        this.f14126d = httpURLConnection.getHeaderFields();
        this.f14129g = httpURLConnection.getContentLength();
        if (v()) {
            this.f14130h = httpURLConnection.getInputStream();
        } else {
            this.f14130h = httpURLConnection.getErrorStream();
        }
    }

    public void z(InputStream inputStream) throws IOException {
        x(inputStream);
    }
}
