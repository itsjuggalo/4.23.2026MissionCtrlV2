package U3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1207s;
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

/* JADX INFO: loaded from: classes.dex */
public class H implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final URL f4803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Future f4804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Task f4805c;

    public H(URL url) {
        this.f4803a = url;
    }

    public static H G(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new H(new URL(str));
        } catch (MalformedURLException unused) {
            Log.w("FirebaseMessaging", "Not downloading image, bad URL: " + str);
            return null;
        }
    }

    public final byte[] A() throws IOException {
        URLConnection uRLConnectionOpenConnection = this.f4803a.openConnection();
        if (uRLConnectionOpenConnection.getContentLength() > 1048576) {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        try {
            byte[] bArrD = AbstractC0689b.d(AbstractC0689b.b(inputStream, 1048577L));
            if (inputStream != null) {
                inputStream.close();
            }
            if (Log.isLoggable("FirebaseMessaging", 2)) {
                Log.v("FirebaseMessaging", "Downloaded " + bArrD.length + " bytes from " + this.f4803a);
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

    public Task H() {
        return (Task) AbstractC1207s.k(this.f4805c);
    }

    public final /* synthetic */ void K(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(i());
        } catch (Exception e7) {
            taskCompletionSource.setException(e7);
        }
    }

    public void M(ExecutorService executorService) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f4804b = executorService.submit(new Runnable() { // from class: U3.G
            @Override // java.lang.Runnable
            public final void run() {
                this.f4801a.K(taskCompletionSource);
            }
        });
        this.f4805c = taskCompletionSource.getTask();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f4804b.cancel(true);
    }

    public Bitmap i() throws IOException {
        if (Log.isLoggable("FirebaseMessaging", 4)) {
            Log.i("FirebaseMessaging", "Starting download of: " + this.f4803a);
        }
        byte[] bArrA = A();
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrA, 0, bArrA.length);
        if (bitmapDecodeByteArray == null) {
            throw new IOException("Failed to decode image: " + this.f4803a);
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Successfully downloaded image: " + this.f4803a);
        }
        return bitmapDecodeByteArray;
    }
}
