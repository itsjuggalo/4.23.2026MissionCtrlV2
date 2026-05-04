package j5;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.internal.n;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.internal.auth_blockstore.zzab;
import j5.c;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13906a = new a(null);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context, Looper looper, com.google.android.gms.common.internal.e clientSettings, com.google.android.gms.common.api.internal.f connectionCallbacks, n connectionFailedListener) {
        super(context, looper, 381, clientSettings, connectionCallbacks, connectionFailedListener);
        t.f(context, "context");
        t.f(looper, "looper");
        t.f(clientSettings, "clientSettings");
        t.f(connectionCallbacks, "connectionCallbacks");
        t.f(connectionFailedListener, "connectionFailedListener");
    }

    @Override // com.google.android.gms.common.internal.c
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public c createServiceInterface(IBinder binder) {
        t.f(binder, "binder");
        c cVarH = c.a.H(binder);
        t.e(cVarH, "asInterface(...)");
        return cVarH;
    }

    @Override // com.google.android.gms.common.internal.c
    public m5.d[] getApiFeatures() {
        m5.d[] ALL_FEATURES = zzab.zzl;
        t.e(ALL_FEATURES, "ALL_FEATURES");
        return ALL_FEATURES;
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public int getMinApkVersion() {
        return 17895000;
    }

    @Override // com.google.android.gms.common.internal.c
    public String getServiceDescriptor() {
        return "com.google.android.gms.auth.blockstore.restorecredential.internal.IRestoreCredentialService";
    }

    @Override // com.google.android.gms.common.internal.c
    public String getStartServiceAction() {
        return "com.google.android.gms.auth.blockstore.restorecredential.service.START_RESTORE_CRED";
    }

    @Override // com.google.android.gms.common.internal.c
    public boolean getUseDynamicLookup() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.c
    public boolean usesClientTelemetry() {
        return true;
    }
}
