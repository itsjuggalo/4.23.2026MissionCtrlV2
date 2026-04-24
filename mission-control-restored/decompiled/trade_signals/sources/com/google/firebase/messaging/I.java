package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1294n;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import l2.AbstractC2328l;
import l2.C2329m;

/* JADX INFO: loaded from: classes.dex */
public class I implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final URL f15620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Future f15621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AbstractC2328l f15622c;

    public I(URL url) {
        this.f15620a = url;
    }

    public static I f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new I(new URL(str));
        } catch (MalformedURLException unused) {
            Log.w("FirebaseMessaging", "Not downloading image, bad URL: " + str);
            return null;
        }
    }

    public void B(ExecutorService executorService) {
        final C2329m c2329m = new C2329m();
        this.f15621b = executorService.submit(new Runnable() { // from class: com.google.firebase.messaging.H
            @Override // java.lang.Runnable
            public final void run() {
                this.f15618a.r(c2329m);
            }
        });
        this.f15622c = c2329m.a();
    }

    public Bitmap c() throws IOException {
        if (Log.isLoggable("FirebaseMessaging", 4)) {
            Log.i("FirebaseMessaging", "Starting download of: " + this.f15620a);
        }
        byte[] bArrE = e();
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrE, 0, bArrE.length);
        if (bitmapDecodeByteArray == null) {
            throw new IOException("Failed to decode image: " + this.f15620a);
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Successfully downloaded image: " + this.f15620a);
        }
        return bitmapDecodeByteArray;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f15621b.cancel(true);
    }

    public final byte[] e() throws IOException {
        URLConnection uRLConnectionOpenConnection = this.f15620a.openConnection();
        if (uRLConnectionOpenConnection.getContentLength() > 1048576) {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        try {
            byte[] bArrD = AbstractC1431b.d(AbstractC1431b.b(inputStream, 1048577L));
            if (inputStream != null) {
                inputStream.close();
            }
            if (Log.isLoggable("FirebaseMessaging", 2)) {
                Log.v("FirebaseMessaging", "Downloaded " + bArrD.length + " bytes from " + this.f15620a);
            }
            if (bArrD.length <= 1048576) {
                return bArrD;
            }
            throw new IOException("Image exceeds max size of 1048576");
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
    }

    public AbstractC2328l n() {
        return (AbstractC2328l) AbstractC1294n.j(this.f15622c);
    }

    public final /* synthetic */ void r(C2329m c2329m) {
        try {
            c2329m.c(c());
        } catch (Exception e8) {
            c2329m.b(e8);
        }
    }
}
