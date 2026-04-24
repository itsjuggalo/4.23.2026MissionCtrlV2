package M1;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C1185w;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final S1.a f3812c = new S1.a("RevokeAccessOperation", new String[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1185w f3814b = new C1185w(null);

    public f(String str) {
        this.f3813a = AbstractC1207s.e(str);
    }

    public static com.google.android.gms.common.api.h a(String str) {
        if (str == null) {
            return com.google.android.gms.common.api.i.a(new Status(4), null);
        }
        f fVar = new f(str);
        new Thread(fVar).start();
        return fVar.f3814b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Status status = Status.f10840h;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://accounts.google.com/o/oauth2/revoke?token=" + this.f3813a).openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.f10838f;
            } else {
                f3812c.c("Unable to revoke access!", new Object[0]);
            }
            f3812c.a("Response Code: " + responseCode, new Object[0]);
        } catch (IOException e7) {
            f3812c.c("IOException when revoking access: ".concat(String.valueOf(e7.toString())), new Object[0]);
        } catch (Exception e8) {
            f3812c.c("Exception when revoking access: ".concat(String.valueOf(e8.toString())), new Object[0]);
        }
        this.f3814b.setResult(status);
    }
}
