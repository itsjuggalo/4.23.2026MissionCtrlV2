package R1;

import Q1.C0792d;
import R1.f;
import S1.InterfaceC0872d;
import S1.InterfaceC0879k;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.AbstractC1283c;
import com.google.android.gms.common.internal.AbstractC1294n;
import com.google.android.gms.common.internal.C1284d;
import com.google.android.gms.common.internal.InterfaceC1289i;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0099a f7092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f7093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f7094c;

    /* JADX INFO: renamed from: R1.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0099a extends e {
        public f a(Context context, Looper looper, C1284d c1284d, Object obj, f.a aVar, f.b bVar) {
            return b(context, looper, c1284d, obj, aVar, bVar);
        }

        public f b(Context context, Looper looper, C1284d c1284d, Object obj, InterfaceC0872d interfaceC0872d, InterfaceC0879k interfaceC0879k) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    public interface b {
    }

    public static class c {
    }

    public interface d {
    }

    public static abstract class e {
    }

    public interface f extends b {
        Set a();

        void connect(AbstractC1283c.InterfaceC0250c interfaceC0250c);

        void disconnect();

        void disconnect(String str);

        C0792d[] getAvailableFeatures();

        String getEndpointPackageName();

        String getLastDisconnectMessage();

        int getMinApkVersion();

        void getRemoteService(InterfaceC1289i interfaceC1289i, Set set);

        boolean isConnected();

        boolean isConnecting();

        void onUserSignOut(AbstractC1283c.e eVar);

        boolean requiresGooglePlayServices();

        boolean requiresSignIn();
    }

    public static final class g extends c {
    }

    public a(String str, AbstractC0099a abstractC0099a, g gVar) {
        AbstractC1294n.k(abstractC0099a, "Cannot construct an Api with a null ClientBuilder");
        AbstractC1294n.k(gVar, "Cannot construct an Api with a null ClientKey");
        this.f7094c = str;
        this.f7092a = abstractC0099a;
        this.f7093b = gVar;
    }

    public final AbstractC0099a a() {
        return this.f7092a;
    }

    public final String b() {
        return this.f7094c;
    }
}
