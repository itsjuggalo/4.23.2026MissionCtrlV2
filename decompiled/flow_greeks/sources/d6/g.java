package d6;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.n;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a.g f7830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f7831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.google.android.gms.common.api.a f7832c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends a.AbstractC0094a {
        @Override // com.google.android.gms.common.api.a.AbstractC0094a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public d buildClient(Context context, Looper looper, com.google.android.gms.common.internal.e commonSettings, a.d.C0095a apiOptions, com.google.android.gms.common.api.internal.f connectedListener, n connectionFailedListener) {
            t.f(context, "context");
            t.f(looper, "looper");
            t.f(commonSettings, "commonSettings");
            t.f(apiOptions, "apiOptions");
            t.f(connectedListener, "connectedListener");
            t.f(connectionFailedListener, "connectionFailedListener");
            return new d(context, looper, commonSettings, connectedListener, connectionFailedListener);
        }
    }

    static {
        a.g gVar = new a.g();
        f7830a = gVar;
        a aVar = new a();
        f7831b = aVar;
        f7832c = new com.google.android.gms.common.api.a("IdentityCredentials.API", aVar, gVar);
    }
}
