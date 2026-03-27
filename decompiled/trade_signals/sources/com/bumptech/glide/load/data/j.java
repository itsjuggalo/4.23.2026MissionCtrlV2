package com.bumptech.glide.load.data;

import a1.C1048h;
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
import q1.AbstractC2624g;
import q1.C2620c;

/* JADX INFO: loaded from: classes.dex */
public class j implements d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f14842g = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1048h f14843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f14845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HttpURLConnection f14846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public InputStream f14847e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f14848f;

    public static class a implements b {
        @Override // com.bumptech.glide.load.data.j.b
        public HttpURLConnection a(URL url) {
            return (HttpURLConnection) url.openConnection();
        }
    }

    public interface b {
        HttpURLConnection a(URL url);
    }

    public j(C1048h c1048h, int i8) {
        this(c1048h, i8, f14842g);
    }

    public static int f(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e8) {
            if (!Log.isLoggable("HttpUrlFetcher", 3)) {
                return -1;
            }
            Log.d("HttpUrlFetcher", "Failed to get a response code", e8);
            return -1;
        }
    }

    public static boolean h(int i8) {
        return i8 / 100 == 2;
    }

    public static boolean i(int i8) {
        return i8 / 100 == 3;
    }

    @Override // com.bumptech.glide.load.data.d
    public Class a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        InputStream inputStream = this.f14847e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f14846d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f14846d = null;
    }

    public final HttpURLConnection c(URL url, Map map) throws U0.e {
        try {
            HttpURLConnection httpURLConnectionA = this.f14845c.a(url);
            for (Map.Entry entry : map.entrySet()) {
                httpURLConnectionA.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            httpURLConnectionA.setConnectTimeout(this.f14844b);
            httpURLConnectionA.setReadTimeout(this.f14844b);
            httpURLConnectionA.setUseCaches(false);
            httpURLConnectionA.setDoInput(true);
            httpURLConnectionA.setInstanceFollowRedirects(false);
            return httpURLConnectionA;
        } catch (IOException e8) {
            throw new U0.e("URL.openConnection threw", 0, e8);
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
        this.f14848f = true;
    }

    @Override // com.bumptech.glide.load.data.d
    public U0.a d() {
        return U0.a.REMOTE;
    }

    @Override // com.bumptech.glide.load.data.d
    public void e(com.bumptech.glide.g gVar, d.a aVar) {
        StringBuilder sb;
        long jB = AbstractC2624g.b();
        try {
            try {
                aVar.f(j(this.f14843a.h(), 0, null, this.f14843a.e()));
            } catch (IOException e8) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e8);
                }
                aVar.c(e8);
                if (!Log.isLoggable("HttpUrlFetcher", 2)) {
                    return;
                } else {
                    sb = new StringBuilder();
                }
            }
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(AbstractC2624g.a(jB));
                Log.v("HttpUrlFetcher", sb.toString());
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + AbstractC2624g.a(jB));
            }
            throw th;
        }
    }

    public final InputStream g(HttpURLConnection httpURLConnection) throws U0.e {
        InputStream inputStream;
        try {
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                inputStream = C2620c.c(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
                }
                inputStream = httpURLConnection.getInputStream();
            }
            this.f14847e = inputStream;
            return this.f14847e;
        } catch (IOException e8) {
            throw new U0.e("Failed to obtain InputStream", f(httpURLConnection), e8);
        }
    }

    public final InputStream j(URL url, int i8, URL url2, Map map) throws U0.e {
        if (i8 >= 5) {
            throw new U0.e("Too many (> 5) redirects!", -1);
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new U0.e("In re-direct loop", -1);
                }
            } catch (URISyntaxException unused) {
            }
        }
        HttpURLConnection httpURLConnectionC = c(url, map);
        this.f14846d = httpURLConnectionC;
        try {
            httpURLConnectionC.connect();
            this.f14847e = this.f14846d.getInputStream();
            if (this.f14848f) {
                return null;
            }
            int iF = f(this.f14846d);
            if (h(iF)) {
                return g(this.f14846d);
            }
            if (!i(iF)) {
                if (iF == -1) {
                    throw new U0.e(iF);
                }
                try {
                    throw new U0.e(this.f14846d.getResponseMessage(), iF);
                } catch (IOException e8) {
                    throw new U0.e("Failed to get a response message", iF, e8);
                }
            }
            String headerField = this.f14846d.getHeaderField("Location");
            if (TextUtils.isEmpty(headerField)) {
                throw new U0.e("Received empty or null redirect url", iF);
            }
            try {
                URL url3 = new URL(url, headerField);
                b();
                return j(url3, i8 + 1, url, map);
            } catch (MalformedURLException e9) {
                throw new U0.e("Bad redirect url: " + headerField, iF, e9);
            }
        } catch (IOException e10) {
            throw new U0.e("Failed to connect or obtain data", f(this.f14846d), e10);
        }
    }

    public j(C1048h c1048h, int i8, b bVar) {
        this.f14843a = c1048h;
        this.f14844b = i8;
        this.f14845c = bVar;
    }
}
