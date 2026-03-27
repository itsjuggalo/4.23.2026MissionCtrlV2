package n3;

import N1.A;
import Z1.h;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.I;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.i;
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

/* JADX INFO: renamed from: n3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0876c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Uri f8559k = Uri.parse("https://firebasestorage.googleapis.com/v0");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final A f8560l = new A(28);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Exception f8561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f.d f8562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f8563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map f8564d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f8565f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8566g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public InputStream f8567h;
    public HttpURLConnection i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final HashMap f8568j = new HashMap();

    public AbstractC0876c(f.d dVar, h hVar) {
        I.g(hVar);
        this.f8562b = dVar;
        hVar.a();
        this.f8563c = hVar.f3962a;
        hVar.a();
        q("x-firebase-gmpid", hVar.f3964c.f3975b);
    }

    public final void a(TaskCompletionSource taskCompletionSource, Object obj) {
        Exception exc = this.f8561a;
        if (l() && exc == null) {
            taskCompletionSource.setResult(obj);
        } else {
            taskCompletionSource.setException(i.b(this.e, exc));
        }
    }

    public final void b(HttpURLConnection httpURLConnection, String str, String str2) throws IOException {
        byte[] bArrF;
        int iG;
        I.g(httpURLConnection);
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
        httpURLConnection.setRequestProperty("X-Firebase-Storage-Version", "Android/22.0.0");
        for (Map.Entry entry : this.f8568j.entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        JSONObject jSONObjectE = e();
        if (jSONObjectE != null) {
            bArrF = jSONObjectE.toString().getBytes("UTF-8");
            iG = bArrF.length;
        } else {
            bArrF = f();
            iG = g();
            if (iG == 0 && bArrF != null) {
                iG = bArrF.length;
            }
        }
        if (bArrF == null || bArrF.length <= 0) {
            httpURLConnection.setRequestProperty("Content-Length", "0");
        } else {
            if (jSONObjectE != null) {
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
            }
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Length", Integer.toString(iG));
        }
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        if (bArrF == null || bArrF.length <= 0) {
            return;
        }
        OutputStream outputStream = httpURLConnection.getOutputStream();
        if (outputStream == null) {
            Log.e("NetworkRequest", "Unable to write to the http request!");
            return;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        try {
            bufferedOutputStream.write(bArrF, 0, iG);
        } finally {
            bufferedOutputStream.close();
        }
    }

    public final HttpURLConnection c() {
        Uri uriK = k();
        Map mapH = h();
        if (mapH != null) {
            Uri.Builder builderBuildUpon = uriK.buildUpon();
            for (Map.Entry entry : mapH.entrySet()) {
                builderBuildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
            }
            uriK = builderBuildUpon.build();
        }
        URL url = new URL(uriK.toString());
        f8560l.getClass();
        return (HttpURLConnection) url.openConnection();
    }

    public abstract String d();

    public JSONObject e() {
        return null;
    }

    public byte[] f() {
        return null;
    }

    public int g() {
        return 0;
    }

    public Map h() {
        return null;
    }

    public final JSONObject i() {
        if (TextUtils.isEmpty(this.f8565f)) {
            return new JSONObject();
        }
        try {
            return new JSONObject(this.f8565f);
        } catch (JSONException e) {
            Log.e("NetworkRequest", "error parsing result into JSON:" + this.f8565f, e);
            return new JSONObject();
        }
    }

    public final String j(String str) {
        List list;
        Map map = this.f8564d;
        if (map == null || (list = (List) map.get(str)) == null || list.size() <= 0) {
            return null;
        }
        return (String) list.get(0);
    }

    public Uri k() {
        return (Uri) this.f8562b.f6382b;
    }

    public final boolean l() {
        int i = this.e;
        return i >= 200 && i < 300;
    }

    public final void m(InputStream inputStream) throws IOException {
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
        this.f8565f = sb.toString();
        if (l()) {
            return;
        }
        this.f8561a = new IOException(this.f8565f);
    }

    public final void n(Context context, String str, String str2) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            this.f8561a = new SocketException("Network subsystem is unavailable");
            this.e = -2;
            return;
        }
        p(str, str2);
        try {
            if (l()) {
                m(this.f8567h);
            } else {
                m(this.f8567h);
            }
        } catch (IOException e) {
            Log.w("NetworkRequest", "error sending network request " + d() + " " + k(), e);
            this.f8561a = e;
            this.e = -2;
        }
        o();
    }

    public final void o() {
        HttpURLConnection httpURLConnection = this.i;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public final void p(String str, String str2) {
        if (this.f8561a != null) {
            this.e = -1;
            return;
        }
        if (Log.isLoggable("NetworkRequest", 3)) {
            Log.d("NetworkRequest", "sending network request " + d() + " " + k());
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f8563c.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            this.e = -2;
            this.f8561a = new SocketException("Network subsystem is unavailable");
            return;
        }
        try {
            HttpURLConnection httpURLConnectionC = c();
            this.i = httpURLConnectionC;
            httpURLConnectionC.setRequestMethod(d());
            b(this.i, str, str2);
            HttpURLConnection httpURLConnection = this.i;
            I.g(httpURLConnection);
            this.e = httpURLConnection.getResponseCode();
            this.f8564d = httpURLConnection.getHeaderFields();
            this.f8566g = httpURLConnection.getContentLength();
            if (l()) {
                this.f8567h = httpURLConnection.getInputStream();
            } else {
                this.f8567h = httpURLConnection.getErrorStream();
            }
            if (Log.isLoggable("NetworkRequest", 3)) {
                Log.d("NetworkRequest", "network request result " + this.e);
            }
        } catch (IOException e) {
            Log.w("NetworkRequest", "error sending network request " + d() + " " + k(), e);
            this.f8561a = e;
            this.e = -2;
        }
    }

    public final void q(String str, String str2) {
        this.f8568j.put(str, str2);
    }
}
