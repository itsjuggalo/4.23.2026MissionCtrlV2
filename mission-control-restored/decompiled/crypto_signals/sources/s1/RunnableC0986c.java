package s1;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C0418v;
import com.google.android.gms.common.internal.I;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import x1.C1402a;

/* JADX INFO: renamed from: s1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0986c implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C1402a f9509c = new C1402a("RevokeAccessOperation", new String[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0418v f9511b;

    public RunnableC0986c(String str) {
        I.d(str);
        this.f9510a = str;
        this.f9511b = new C0418v(null, 0);
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1402a c1402a = f9509c;
        Status status = Status.f5059k;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://accounts.google.com/o/oauth2/revoke?token=" + this.f9510a).openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.e;
            } else {
                c1402a.c("Unable to revoke access!", new Object[0]);
            }
            c1402a.a("Response Code: " + responseCode, new Object[0]);
        } catch (IOException e) {
            c1402a.c("IOException when revoking access: ".concat(String.valueOf(e.toString())), new Object[0]);
        } catch (Exception e2) {
            c1402a.c("Exception when revoking access: ".concat(String.valueOf(e2.toString())), new Object[0]);
        }
        this.f9511b.setResult(status);
    }
}
