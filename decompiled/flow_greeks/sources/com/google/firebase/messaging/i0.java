package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class i0 implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final URL f6354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Future f6355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Task f6356c;

    public i0(URL url) {
        this.f6354a = url;
    }

    public static /* synthetic */ void b(i0 i0Var, TaskCompletionSource taskCompletionSource) {
        i0Var.getClass();
        try {
            taskCompletionSource.setResult(i0Var.c());
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    public static i0 o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new i0(new URL(str));
        } catch (MalformedURLException unused) {
            Log.w("FirebaseMessaging", "Not downloading image, bad URL: " + str);
            return null;
        }
    }

    public void C(ExecutorService executorService) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f6355b = executorService.submit(new Runnable() { // from class: com.google.firebase.messaging.h0
            @Override // java.lang.Runnable
            public final void run() {
                i0.b(this.f6350a, taskCompletionSource);
            }
        });
        this.f6356c = taskCompletionSource.getTask();
    }

    public Bitmap c() throws IOException {
        if (Log.isLoggable("FirebaseMessaging", 4)) {
            Log.i("FirebaseMessaging", "Starting download of: " + this.f6354a);
        }
        byte[] bArrE = e();
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrE, 0, bArrE.length);
        if (bitmapDecodeByteArray == null) {
            throw new IOException("Failed to decode image: " + this.f6354a);
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Successfully downloaded image: " + this.f6354a);
        }
        return bitmapDecodeByteArray;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f6355b.cancel(true);
    }

    public final byte[] e() throws IOException {
        URLConnection uRLConnectionOpenConnection = this.f6354a.openConnection();
        if (uRLConnectionOpenConnection.getContentLength() > 1048576) {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        try {
            byte[] bArrD = b.d(b.b(inputStream, 1048577L));
            if (inputStream != null) {
                inputStream.close();
            }
            if (Log.isLoggable("FirebaseMessaging", 2)) {
                Log.v("FirebaseMessaging", "Downloaded " + bArrD.length + " bytes from " + this.f6354a);
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

    public Task u() {
        return (Task) com.google.android.gms.common.internal.s.k(this.f6356c);
    }
}
