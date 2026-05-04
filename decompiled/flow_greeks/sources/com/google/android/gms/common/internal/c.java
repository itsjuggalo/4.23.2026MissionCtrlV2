package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.AttributionSource;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static final int CONNECT_STATE_CONNECTED = 4;
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    private volatile String zzA;
    private volatile v5.a zzB;
    private m5.b zzC;
    private boolean zzD;
    private volatile h1 zzE;
    q1 zza;
    final Handler zzb;
    protected InterfaceC0097c zzc;
    protected AtomicInteger zzd;
    private int zzf;
    private long zzg;
    private long zzh;
    private int zzi;
    private long zzj;
    private volatile String zzk;
    private final Context zzl;
    private final Looper zzm;
    private final i zzn;
    private final m5.f zzo;
    private final Object zzp;
    private final Object zzq;
    private n zzr;
    private IInterface zzs;
    private final ArrayList zzt;
    private e1 zzu;
    private int zzv;
    private final a zzw;
    private final b zzx;
    private final int zzy;
    private final String zzz;
    private static final m5.d[] zze = new m5.d[0];
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i10);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
        void onConnectionFailed(m5.b bVar);
    }

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface InterfaceC0097c {
        void d(m5.b bVar);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements InterfaceC0097c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f5664a;

        public d(c cVar) {
            Objects.requireNonNull(cVar);
            this.f5664a = cVar;
        }

        @Override // com.google.android.gms.common.internal.c.InterfaceC0097c
        public final void d(m5.b bVar) {
            if (bVar.V()) {
                c cVar = this.f5664a;
                cVar.getRemoteService(null, cVar.getScopes());
            } else {
                c cVar2 = this.f5664a;
                if (cVar2.zzl() != null) {
                    cVar2.zzl().onConnectionFailed(bVar);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface e {
        void a();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public c(Context context, Looper looper, int i10, a aVar, b bVar, String str) {
        i iVarA = i.a(context);
        m5.f fVarF = m5.f.f();
        s.k(aVar);
        s.k(bVar);
        this(context, looper, iVarA, fVarF, i10, aVar, bVar, str);
    }

    public final void c(int i10, IInterface iInterface) {
        q1 q1Var;
        s.a((i10 == 4) == (iInterface != null));
        synchronized (this.zzp) {
            try {
                this.zzv = i10;
                this.zzs = iInterface;
                Bundle bundle = null;
                if (i10 == 1) {
                    e1 e1Var = this.zzu;
                    if (e1Var != null) {
                        i iVar = this.zzn;
                        String strA = this.zza.a();
                        s.k(strA);
                        iVar.d(strA, this.zza.b(), 4225, e1Var, zza(), this.zza.c());
                        this.zzu = null;
                    }
                } else if (i10 == 2 || i10 == 3) {
                    e1 e1Var2 = this.zzu;
                    if (e1Var2 != null && (q1Var = this.zza) != null) {
                        String strA2 = q1Var.a();
                        String strB = q1Var.b();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(strA2).length() + 70 + String.valueOf(strB).length());
                        sb2.append("Calling connect() while still connected, missing disconnect() for ");
                        sb2.append(strA2);
                        sb2.append(" on ");
                        sb2.append(strB);
                        Log.e("GmsClient", sb2.toString());
                        i iVar2 = this.zzn;
                        String strA3 = this.zza.a();
                        s.k(strA3);
                        iVar2.d(strA3, this.zza.b(), 4225, e1Var2, zza(), this.zza.c());
                        this.zzd.incrementAndGet();
                    }
                    e1 e1Var3 = new e1(this, this.zzd.get());
                    this.zzu = e1Var3;
                    q1 q1Var2 = (this.zzv != 3 || getLocalStartServiceAction() == null) ? new q1(getStartServicePackage(), getStartServiceAction(), false, 4225, getUseDynamicLookup()) : new q1(getContext().getPackageName(), getLocalStartServiceAction(), true, 4225, false);
                    this.zza = q1Var2;
                    if (q1Var2.c() && getMinApkVersion() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.zza.a())));
                    }
                    i iVar3 = this.zzn;
                    String strA4 = this.zza.a();
                    s.k(strA4);
                    m5.b bVarC = iVar3.c(new l1(strA4, this.zza.b(), 4225, this.zza.c()), e1Var3, zza(), getBindServiceExecutor());
                    if (!bVarC.V()) {
                        String strA5 = this.zza.a();
                        String strB2 = this.zza.b();
                        StringBuilder sb3 = new StringBuilder(String.valueOf(strA5).length() + 34 + String.valueOf(strB2).length());
                        sb3.append("unable to connect to service: ");
                        sb3.append(strA5);
                        sb3.append(" on ");
                        sb3.append(strB2);
                        Log.w("GmsClient", sb3.toString());
                        int iR = bVarC.R() == -1 ? 16 : bVarC.R();
                        if (bVarC.T() != null) {
                            bundle = new Bundle();
                            bundle.putParcelable(KEY_PENDING_INTENT, bVarC.T());
                        }
                        zzb(iR, bundle, this.zzd.get());
                    }
                } else if (i10 == 4) {
                    s.k(iInterface);
                    onConnectedLocked(iInterface);
                }
            } finally {
            }
        }
    }

    public void checkAvailabilityAndConnect() {
        int iH = this.zzo.h(this.zzl, getMinApkVersion());
        if (iH == 0) {
            connect(new d(this));
        } else {
            c(1, null);
            triggerNotAvailable(new d(this), iH, null);
        }
    }

    public final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect(InterfaceC0097c interfaceC0097c) {
        s.l(interfaceC0097c, "Connection progress callbacks cannot be null.");
        this.zzc = interfaceC0097c;
        c(2, null);
    }

    public abstract IInterface createServiceInterface(IBinder iBinder);

    public void disconnect() {
        this.zzd.incrementAndGet();
        ArrayList arrayList = this.zzt;
        synchronized (arrayList) {
            try {
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((c1) arrayList.get(i10)).d();
                }
                arrayList.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.zzq) {
            this.zzr = null;
        }
        c(1, null);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i10;
        IInterface iInterface;
        n nVar;
        long j10;
        synchronized (this.zzp) {
            i10 = this.zzv;
            iInterface = this.zzs;
        }
        synchronized (this.zzq) {
            nVar = this.zzr;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        if (i10 == 1) {
            printWriter.print("DISCONNECTED");
        } else if (i10 == 2) {
            printWriter.print("REMOTE_CONNECTING");
        } else if (i10 == 3) {
            printWriter.print("LOCAL_CONNECTING");
        } else if (i10 == 4) {
            printWriter.print("CONNECTED");
        } else if (i10 != 5) {
            printWriter.print("UNKNOWN");
        } else {
            printWriter.print("DISCONNECTING");
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.append("null");
        } else {
            printWriter.append((CharSequence) getServiceDescriptor()).append("@").append((CharSequence) Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (nVar == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(nVar.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzh > 0) {
            PrintWriter printWriterAppend = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j11 = this.zzh;
            String str2 = simpleDateFormat.format(new Date(j11));
            j10 = 0;
            StringBuilder sb2 = new StringBuilder(String.valueOf(j11).length() + 1 + String.valueOf(str2).length());
            sb2.append(j11);
            sb2.append(" ");
            sb2.append(str2);
            printWriterAppend.println(sb2.toString());
        } else {
            j10 = 0;
        }
        if (this.zzg > j10) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i11 = this.zzf;
            if (i11 == 1) {
                printWriter.append("CAUSE_SERVICE_DISCONNECTED");
            } else if (i11 == 2) {
                printWriter.append("CAUSE_NETWORK_LOST");
            } else if (i11 != 3) {
                printWriter.append((CharSequence) String.valueOf(i11));
            } else {
                printWriter.append("CAUSE_DEAD_OBJECT_EXCEPTION");
            }
            PrintWriter printWriterAppend2 = printWriter.append(" lastSuspendedTime=");
            long j12 = this.zzg;
            String str3 = simpleDateFormat.format(new Date(j12));
            StringBuilder sb3 = new StringBuilder(String.valueOf(j12).length() + 1 + String.valueOf(str3).length());
            sb3.append(j12);
            sb3.append(" ");
            sb3.append(str3);
            printWriterAppend2.println(sb3.toString());
        }
        if (this.zzj > j10) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) com.google.android.gms.common.api.d.a(this.zzi));
            PrintWriter printWriterAppend3 = printWriter.append(" lastFailedTime=");
            long j13 = this.zzj;
            String str4 = simpleDateFormat.format(new Date(j13));
            StringBuilder sb4 = new StringBuilder(String.valueOf(j13).length() + 1 + String.valueOf(str4).length());
            sb4.append(j13);
            sb4.append(" ");
            sb4.append(str4);
            printWriterAppend3.println(sb4.toString());
        }
    }

    public boolean enableLocalFallback() {
        return false;
    }

    public Account getAccount() {
        return null;
    }

    public m5.d[] getApiFeatures() {
        return zze;
    }

    public v5.a getAttributionSourceWrapper() {
        return this.zzB;
    }

    public final m5.d[] getAvailableFeatures() {
        h1 h1Var = this.zzE;
        if (h1Var == null) {
            return null;
        }
        return h1Var.f5724b;
    }

    public Executor getBindServiceExecutor() {
        return null;
    }

    public Bundle getConnectionHint() {
        return null;
    }

    public final Context getContext() {
        return this.zzl;
    }

    public String getEndpointPackageName() {
        q1 q1Var;
        if (!isConnected() || (q1Var = this.zza) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return q1Var.b();
    }

    public int getGCoreServiceId() {
        return this.zzy;
    }

    public Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    public String getLastDisconnectMessage() {
        return this.zzk;
    }

    public String getLocalStartServiceAction() {
        return null;
    }

    public final Looper getLooper() {
        return this.zzm;
    }

    public abstract int getMinApkVersion();

    public void getRemoteService(k kVar, Set<Scope> set) {
        AttributionSource attributionSourceA;
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        String attributionTag = (Build.VERSION.SDK_INT < 31 || this.zzB == null || (attributionSourceA = this.zzB.a()) == null || attributionSourceA.getAttributionTag() == null) ? this.zzA : attributionSourceA.getAttributionTag();
        String str = attributionTag;
        int i10 = this.zzy;
        int i11 = m5.f.f15915a;
        Scope[] scopeArr = g.f5704o;
        Bundle bundle = new Bundle();
        m5.d[] dVarArr = g.f5705p;
        g gVar = new g(6, i10, i11, null, null, scopeArr, bundle, null, dVarArr, dVarArr, true, 0, false, str);
        gVar.f5709d = this.zzl.getPackageName();
        gVar.f5712g = getServiceRequestExtraArgs;
        if (set != null) {
            gVar.f5711f = (Scope[]) set.toArray(new Scope[0]);
        }
        if (requiresSignIn()) {
            Account account = getAccount();
            if (account == null) {
                account = new Account(DEFAULT_ACCOUNT, "com.google");
            }
            gVar.f5713h = account;
            if (kVar != null) {
                gVar.f5710e = kVar.asBinder();
            }
        } else if (requiresAccount()) {
            gVar.f5713h = getAccount();
        }
        gVar.f5714i = zze;
        gVar.f5715j = getApiFeatures();
        if (usesClientTelemetry()) {
            gVar.f5718m = true;
        }
        try {
            synchronized (this.zzq) {
                try {
                    n nVar = this.zzr;
                    if (nVar != null) {
                        nVar.e(new d1(this, this.zzd.get()), gVar);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } finally {
                }
            }
        } catch (DeadObjectException e10) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e10);
            triggerConnectionSuspended(3);
        } catch (RemoteException e11) {
            e = e11;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            onPostInitHandler(8, null, null, this.zzd.get());
        } catch (SecurityException e12) {
            throw e12;
        } catch (RuntimeException e13) {
            e = e13;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            onPostInitHandler(8, null, null, this.zzd.get());
        }
    }

    public Set<Scope> getScopes() {
        return Collections.EMPTY_SET;
    }

    public final IInterface getService() {
        IInterface iInterface;
        synchronized (this.zzp) {
            try {
                if (this.zzv == 5) {
                    throw new DeadObjectException();
                }
                checkConnected();
                iInterface = this.zzs;
                s.l(iInterface, "Client is connected but service is null");
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    public IBinder getServiceBrokerBinder() {
        synchronized (this.zzq) {
            try {
                n nVar = this.zzr;
                if (nVar == null) {
                    return null;
                }
                return nVar.asBinder();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract String getServiceDescriptor();

    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public abstract String getStartServiceAction();

    public String getStartServicePackage() {
        return "com.google.android.gms";
    }

    public f getTelemetryConfiguration() {
        h1 h1Var = this.zzE;
        if (h1Var == null) {
            return null;
        }
        return h1Var.f5726d;
    }

    public boolean getUseDynamicLookup() {
        return getMinApkVersion() >= 211700000;
    }

    public boolean hasConnectionInfo() {
        return this.zzE != null;
    }

    public boolean isConnected() {
        boolean z10;
        synchronized (this.zzp) {
            z10 = this.zzv == 4;
        }
        return z10;
    }

    public boolean isConnecting() {
        boolean z10;
        synchronized (this.zzp) {
            int i10 = this.zzv;
            z10 = true;
            if (i10 != 2 && i10 != 3) {
                z10 = false;
            }
        }
        return z10;
    }

    public void onConnectedLocked(IInterface iInterface) {
        this.zzh = System.currentTimeMillis();
    }

    public void onConnectionFailed(m5.b bVar) {
        this.zzi = bVar.R();
        this.zzj = System.currentTimeMillis();
    }

    public void onConnectionSuspended(int i10) {
        this.zzf = i10;
        this.zzg = System.currentTimeMillis();
    }

    public void onPostInitHandler(int i10, IBinder iBinder, Bundle bundle, int i11) {
        f1 f1Var = new f1(this, i10, iBinder, bundle);
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(1, i11, -1, f1Var));
    }

    public void onUserSignOut(e eVar) {
        eVar.a();
    }

    public boolean providesSignIn() {
        return false;
    }

    public boolean requiresAccount() {
        return false;
    }

    public boolean requiresGooglePlayServices() {
        return true;
    }

    public boolean requiresSignIn() {
        return false;
    }

    public void setAttributionSourceWrapper(v5.a aVar) {
        this.zzB = aVar;
    }

    public void setAttributionTag(String str) {
        this.zzA = str;
    }

    public void triggerConnectionSuspended(int i10) {
        int i11 = this.zzd.get();
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(6, i11, i10));
    }

    public void triggerNotAvailable(InterfaceC0097c interfaceC0097c, int i10, PendingIntent pendingIntent) {
        s.l(interfaceC0097c, "Connection progress callbacks cannot be null.");
        this.zzc = interfaceC0097c;
        int i11 = this.zzd.get();
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(3, i11, i10, pendingIntent));
    }

    public boolean usesClientTelemetry() {
        return false;
    }

    public final String zza() {
        String str = this.zzz;
        return str == null ? this.zzl.getClass().getName() : str;
    }

    public final void zzb(int i10, Bundle bundle, int i11) {
        g1 g1Var = new g1(this, i10, bundle);
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(7, i11, -1, g1Var));
    }

    public final /* synthetic */ void zzc(h1 h1Var) {
        this.zzE = h1Var;
        if (usesClientTelemetry()) {
            f fVar = h1Var.f5726d;
            t.b().c(fVar == null ? null : fVar.W());
        }
    }

    public final /* synthetic */ void zzd(int i10, IInterface iInterface) {
        c(i10, null);
    }

    public final /* synthetic */ boolean zze(int i10, int i11, IInterface iInterface) {
        synchronized (this.zzp) {
            try {
                if (this.zzv != i10) {
                    return false;
                }
                c(i11, iInterface);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ void zzf(int i10) {
        int i11;
        int i12;
        synchronized (this.zzp) {
            i11 = this.zzv;
        }
        if (i11 == 3) {
            this.zzD = true;
            i12 = 5;
        } else {
            i12 = 4;
        }
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(i12, this.zzd.get(), 16));
    }

    public final /* synthetic */ boolean zzg() {
        if (this.zzD || TextUtils.isEmpty(getServiceDescriptor()) || TextUtils.isEmpty(getLocalStartServiceAction())) {
            return false;
        }
        try {
            Class.forName(getServiceDescriptor());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final /* synthetic */ Object zzh() {
        return this.zzq;
    }

    public final /* synthetic */ void zzi(n nVar) {
        this.zzr = nVar;
    }

    public final /* synthetic */ ArrayList zzj() {
        return this.zzt;
    }

    public final /* synthetic */ a zzk() {
        return this.zzw;
    }

    public final /* synthetic */ b zzl() {
        return this.zzx;
    }

    public final /* synthetic */ m5.b zzm() {
        return this.zzC;
    }

    public final /* synthetic */ void zzn(m5.b bVar) {
        this.zzC = bVar;
    }

    public final /* synthetic */ boolean zzo() {
        return this.zzD;
    }

    public c(Context context, Looper looper, i iVar, m5.f fVar, int i10, a aVar, b bVar, String str) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList();
        this.zzv = 1;
        this.zzC = null;
        this.zzD = false;
        this.zzE = null;
        this.zzd = new AtomicInteger(0);
        s.l(context, "Context must not be null");
        this.zzl = context;
        s.l(looper, "Looper must not be null");
        this.zzm = looper;
        s.l(iVar, "Supervisor must not be null");
        this.zzn = iVar;
        s.l(fVar, "API availability must not be null");
        this.zzo = fVar;
        this.zzb = new b1(this, looper);
        this.zzy = i10;
        this.zzw = aVar;
        this.zzx = bVar;
        this.zzz = str;
    }

    public void disconnect(String str) {
        this.zzk = str;
        disconnect();
    }
}
