package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.data.d;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class j implements d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f5296g = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m3.h f5297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f5299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HttpURLConnection f5300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public InputStream f5301e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f5302f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements b {
        @Override // com.bumptech.glide.load.data.j.b
        public HttpURLConnection a(URL url) {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
        HttpURLConnection a(URL url);
    }

    public j(m3.h hVar, int i10) {
        this(hVar, i10, f5296g);
    }

    public static int f(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e10) {
            if (!Log.isLoggable("HttpUrlFetcher", 3)) {
                return -1;
            }
            Log.d("HttpUrlFetcher", "Failed to get a response code", e10);
            return -1;
        }
    }

    public static boolean h(int i10) {
        return i10 / 100 == 2;
    }

    public static boolean i(int i10) {
        return i10 / 100 == 3;
    }

    @Override // com.bumptech.glide.load.data.d
    public Class a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        InputStream inputStream = this.f5301e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f5300d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f5300d = null;
    }

    public final HttpURLConnection c(URL url, Map map) throws g3.e {
        try {
            HttpURLConnection httpURLConnectionA = this.f5299c.a(url);
            for (Map.Entry entry : map.entrySet()) {
                httpURLConnectionA.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            httpURLConnectionA.setConnectTimeout(this.f5298b);
            httpURLConnectionA.setReadTimeout(this.f5298b);
            httpURLConnectionA.setUseCaches(false);
            httpURLConnectionA.setDoInput(true);
            httpURLConnectionA.setInstanceFollowRedirects(false);
            return httpURLConnectionA;
        } catch (IOException e10) {
            throw new g3.e("URL.openConnection threw", 0, e10);
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
        this.f5302f = true;
    }

    @Override // com.bumptech.glide.load.data.d
    public g3.a d() {
        return g3.a.REMOTE;
    }

    @Override // com.bumptech.glide.load.data.d
    public void e(com.bumptech.glide.g gVar, d.a aVar) {
        long jB = c4.g.b();
        try {
            try {
                aVar.f(j(this.f5297a.h(), 0, null, this.f5297a.e()));
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + c4.g.a(jB));
                }
            } catch (IOException e10) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e10);
                }
                aVar.c(e10);
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + c4.g.a(jB));
                }
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + c4.g.a(jB));
            }
            throw th;
        }
    }

    public final InputStream g(HttpURLConnection httpURLConnection) throws g3.e {
        try {
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                this.f5301e = c4.c.c(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
                }
                this.f5301e = httpURLConnection.getInputStream();
            }
            return this.f5301e;
        } catch (IOException e10) {
            throw new g3.e("Failed to obtain InputStream", f(httpURLConnection), e10);
        }
    }

    public final InputStream j(URL url, int i10, URL url2, Map map) throws g3.e {
        if (i10 >= 5) {
            throw new g3.e("Too many (> 5) redirects!", -1);
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new g3.e("In re-direct loop", -1);
                }
            } catch (URISyntaxException unused) {
            }
        }
        HttpURLConnection httpURLConnectionC = c(url, map);
        this.f5300d = httpURLConnectionC;
        try {
            httpURLConnectionC.connect();
            this.f5301e = this.f5300d.getInputStream();
            if (this.f5302f) {
                return null;
            }
            int iF = f(this.f5300d);
            if (h(iF)) {
                return g(this.f5300d);
            }
            if (!i(iF)) {
                if (iF == -1) {
                    throw new g3.e(iF);
                }
                try {
                    throw new g3.e(this.f5300d.getResponseMessage(), iF);
                } catch (IOException e10) {
                    throw new g3.e("Failed to get a response message", iF, e10);
                }
            }
            String headerField = this.f5300d.getHeaderField("Location");
            if (TextUtils.isEmpty(headerField)) {
                throw new g3.e("Received empty or null redirect url", iF);
            }
            try {
                URL url3 = new URL(url, headerField);
                b();
                return j(url3, i10 + 1, url, map);
            } catch (MalformedURLException e11) {
                throw new g3.e("Bad redirect url: " + headerField, iF, e11);
            }
        } catch (IOException e12) {
            throw new g3.e("Failed to connect or obtain data", f(this.f5300d), e12);
        }
    }

    public j(m3.h hVar, int i10, b bVar) {
        this.f5297a = hVar;
        this.f5298b = i10;
        this.f5299c = bVar;
    }
}
