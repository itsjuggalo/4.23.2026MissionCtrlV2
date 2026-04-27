package v1;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C0919x;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: renamed from: v1.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1888f implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C1.a f15296c = new C1.a("RevokeAccessOperation", new String[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0919x f15298b = new C0919x(null);

    public RunnableC1888f(String str) {
        this.f15297a = AbstractC0940s.e(str);
    }

    public static com.google.android.gms.common.api.h a(String str) {
        if (str == null) {
            return com.google.android.gms.common.api.i.a(new Status(4), null);
        }
        RunnableC1888f runnableC1888f = new RunnableC1888f(str);
        new Thread(runnableC1888f).start();
        return runnableC1888f.f15298b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Status status = Status.f9655h;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://accounts.google.com/o/oauth2/revoke?token=" + this.f15297a).openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.f9653f;
            } else {
                f15296c.c("Unable to revoke access!", new Object[0]);
            }
            f15296c.a("Response Code: " + responseCode, new Object[0]);
        } catch (IOException e4) {
            f15296c.c("IOException when revoking access: ".concat(String.valueOf(e4.toString())), new Object[0]);
        } catch (Exception e5) {
            f15296c.c("Exception when revoking access: ".concat(String.valueOf(e5.toString())), new Object[0]);
        }
        this.f15298b.setResult(status);
    }
}
