package com.google.android.gms.common.internal;

import Q1.C0790b;
import Q1.C0792d;
import Q1.C0795g;
import android.accounts.Account;
import android.app.PendingIntent;
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
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1283c {
    public static final int CONNECT_STATE_CONNECTED = 4;
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    private volatile String zzA;
    private volatile Y1.a zzB;
    private C0790b zzC;
    private boolean zzD;
    private volatile c0 zzE;
    n0 zza;
    final Handler zzb;
    protected InterfaceC0250c zzc;
    protected AtomicInteger zzd;
    private int zzf;
    private long zzg;
    private long zzh;
    private int zzi;
    private long zzj;
    private volatile String zzk;
    private final Context zzl;
    private final Looper zzm;
    private final AbstractC1288h zzn;
    private final C0795g zzo;
    private final Object zzp;
    private final Object zzq;
    private InterfaceC1291k zzr;
    private IInterface zzs;
    private final ArrayList zzt;
    private Z zzu;
    private int zzv;
    private final a zzw;
    private final b zzx;
    private final int zzy;
    private final String zzz;
    private static final C0792d[] zze = new C0792d[0];
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.c$a */
    public interface a {
        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i8);
    }

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.c$b */
    public interface b {
        void onConnectionFailed(C0790b c0790b);
    }

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.c$c, reason: collision with other inner class name */
    public interface InterfaceC0250c {
        void a(C0790b c0790b);
    }

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.c$d */
    public class d implements InterfaceC0250c {
        public d() {
        }

        @Override // com.google.android.gms.common.internal.AbstractC1283c.InterfaceC0250c
        public final void a(C0790b c0790b) {
            if (c0790b.h()) {
                AbstractC1283c abstractC1283c = AbstractC1283c.this;
                abstractC1283c.getRemoteService(null, abstractC1283c.getScopes());
            } else if (AbstractC1283c.this.zzx != null) {
                AbstractC1283c.this.zzx.onConnectionFailed(c0790b);
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.c$e */
    public interface e {
        void a();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AbstractC1283c(Context context, Looper looper, int i8, a aVar, b bVar, String str) {
        AbstractC1288h abstractC1288hA = AbstractC1288h.a(context);
        C0795g c0795gF = C0795g.f();
        AbstractC1294n.j(aVar);
        AbstractC1294n.j(bVar);
        this(context, looper, abstractC1288hA, c0795gF, i8, aVar, bVar, str);
    }

    public static /* bridge */ /* synthetic */ void zzj(AbstractC1283c abstractC1283c, c0 c0Var) {
        abstractC1283c.zzE = c0Var;
        if (abstractC1283c.usesClientTelemetry()) {
            C1285e c1285e = c0Var.f14958d;
            C1295o.b().c(c1285e == null ? null : c1285e.n());
        }
    }

    public static /* bridge */ /* synthetic */ void zzk(AbstractC1283c abstractC1283c, int i8) {
        int i9;
        int i10;
        synchronized (abstractC1283c.zzp) {
            i9 = abstractC1283c.zzv;
        }
        if (i9 == 3) {
            abstractC1283c.zzD = true;
            i10 = 5;
        } else {
            i10 = 4;
        }
        Handler handler = abstractC1283c.zzb;
        handler.sendMessage(handler.obtainMessage(i10, abstractC1283c.zzd.get(), 16));
    }

    public static /* bridge */ /* synthetic */ boolean zzn(AbstractC1283c abstractC1283c, int i8, int i9, IInterface iInterface) {
        synchronized (abstractC1283c.zzp) {
            try {
                if (abstractC1283c.zzv != i8) {
                    return false;
                }
                abstractC1283c.d(i9, iInterface);
                return true;
            } finally {
            }
        }
    }

    public static /* bridge */ /* synthetic */ boolean zzo(AbstractC1283c abstractC1283c) {
        if (abstractC1283c.zzD || TextUtils.isEmpty(abstractC1283c.getServiceDescriptor()) || TextUtils.isEmpty(abstractC1283c.getLocalStartServiceAction())) {
            return false;
        }
        try {
            Class.forName(abstractC1283c.getServiceDescriptor());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public void checkAvailabilityAndConnect() {
        int iH = this.zzo.h(this.zzl, getMinApkVersion());
        if (iH == 0) {
            connect(new d());
        } else {
            d(1, null);
            triggerNotAvailable(new d(), iH, null);
        }
    }

    public final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect(InterfaceC0250c interfaceC0250c) {
        AbstractC1294n.k(interfaceC0250c, "Connection progress callbacks cannot be null.");
        this.zzc = interfaceC0250c;
        d(2, null);
    }

    public abstract IInterface createServiceInterface(IBinder iBinder);

    public final void d(int i8, IInterface iInterface) {
        n0 n0Var;
        AbstractC1294n.a((i8 == 4) == (iInterface != null));
        synchronized (this.zzp) {
            try {
                this.zzv = i8;
                this.zzs = iInterface;
                Bundle bundle = null;
                if (i8 == 1) {
                    Z z7 = this.zzu;
                    if (z7 != null) {
                        AbstractC1288h abstractC1288h = this.zzn;
                        String strB = this.zza.b();
                        AbstractC1294n.j(strB);
                        abstractC1288h.e(strB, this.zza.a(), 4225, z7, zze(), this.zza.c());
                        this.zzu = null;
                    }
                } else if (i8 == 2 || i8 == 3) {
                    Z z8 = this.zzu;
                    if (z8 != null && (n0Var = this.zza) != null) {
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + n0Var.b() + " on " + n0Var.a());
                        AbstractC1288h abstractC1288h2 = this.zzn;
                        String strB2 = this.zza.b();
                        AbstractC1294n.j(strB2);
                        abstractC1288h2.e(strB2, this.zza.a(), 4225, z8, zze(), this.zza.c());
                        this.zzd.incrementAndGet();
                    }
                    Z z9 = new Z(this, this.zzd.get());
                    this.zzu = z9;
                    n0 n0Var2 = (this.zzv != 3 || getLocalStartServiceAction() == null) ? new n0(getStartServicePackage(), getStartServiceAction(), false, 4225, getUseDynamicLookup()) : new n0(getContext().getPackageName(), getLocalStartServiceAction(), true, 4225, false);
                    this.zza = n0Var2;
                    if (n0Var2.c() && getMinApkVersion() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.zza.b())));
                    }
                    AbstractC1288h abstractC1288h3 = this.zzn;
                    String strB3 = this.zza.b();
                    AbstractC1294n.j(strB3);
                    C0790b c0790bC = abstractC1288h3.c(new g0(strB3, this.zza.a(), 4225, this.zza.c()), z9, zze(), getBindServiceExecutor());
                    if (!c0790bC.h()) {
                        Log.w("GmsClient", "unable to connect to service: " + this.zza.b() + " on " + this.zza.a());
                        int iA = c0790bC.a() == -1 ? 16 : c0790bC.a();
                        if (c0790bC.e() != null) {
                            bundle = new Bundle();
                            bundle.putParcelable(KEY_PENDING_INTENT, c0790bC.e());
                        }
                        zzl(iA, bundle, this.zzd.get());
                    }
                } else if (i8 == 4) {
                    AbstractC1294n.j(iInterface);
                    onConnectedLocked(iInterface);
                }
            } finally {
            }
        }
    }

    public void disconnect() {
        this.zzd.incrementAndGet();
        synchronized (this.zzt) {
            try {
                int size = this.zzt.size();
                for (int i8 = 0; i8 < size; i8++) {
                    ((X) this.zzt.get(i8)).d();
                }
                this.zzt.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.zzq) {
            this.zzr = null;
        }
        d(1, null);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i8;
        IInterface iInterface;
        InterfaceC1291k interfaceC1291k;
        synchronized (this.zzp) {
            i8 = this.zzv;
            iInterface = this.zzs;
        }
        synchronized (this.zzq) {
            interfaceC1291k = this.zzr;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        printWriter.print(i8 != 1 ? i8 != 2 ? i8 != 3 ? i8 != 4 ? i8 != 5 ? "UNKNOWN" : "DISCONNECTING" : "CONNECTED" : "LOCAL_CONNECTING" : "REMOTE_CONNECTING" : "DISCONNECTED");
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.append("null");
        } else {
            printWriter.append((CharSequence) getServiceDescriptor()).append("@").append((CharSequence) Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (interfaceC1291k == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(interfaceC1291k.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzh > 0) {
            PrintWriter printWriterAppend = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j8 = this.zzh;
            printWriterAppend.println(j8 + " " + simpleDateFormat.format(new Date(j8)));
        }
        if (this.zzg > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i9 = this.zzf;
            printWriter.append((CharSequence) (i9 != 1 ? i9 != 2 ? i9 != 3 ? String.valueOf(i9) : "CAUSE_DEAD_OBJECT_EXCEPTION" : "CAUSE_NETWORK_LOST" : "CAUSE_SERVICE_DISCONNECTED"));
            PrintWriter printWriterAppend2 = printWriter.append(" lastSuspendedTime=");
            long j9 = this.zzg;
            printWriterAppend2.println(j9 + " " + simpleDateFormat.format(new Date(j9)));
        }
        if (this.zzj > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) R1.c.a(this.zzi));
            PrintWriter printWriterAppend3 = printWriter.append(" lastFailedTime=");
            long j10 = this.zzj;
            printWriterAppend3.println(j10 + " " + simpleDateFormat.format(new Date(j10)));
        }
    }

    public boolean enableLocalFallback() {
        return false;
    }

    public Account getAccount() {
        return null;
    }

    public C0792d[] getApiFeatures() {
        return zze;
    }

    public Y1.a getAttributionSourceWrapper() {
        return null;
    }

    public final C0792d[] getAvailableFeatures() {
        c0 c0Var = this.zzE;
        if (c0Var == null) {
            return null;
        }
        return c0Var.f14956b;
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
        n0 n0Var;
        if (!isConnected() || (n0Var = this.zza) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return n0Var.a();
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

    public void getRemoteService(InterfaceC1289i interfaceC1289i, Set<Scope> set) {
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        int i8 = Build.VERSION.SDK_INT;
        String str = this.zzA;
        int i9 = this.zzy;
        int i10 = C0795g.f6693a;
        Scope[] scopeArr = C1286f.f14980o;
        Bundle bundle = new Bundle();
        C0792d[] c0792dArr = C1286f.f14981p;
        C1286f c1286f = new C1286f(6, i9, i10, null, null, scopeArr, bundle, null, c0792dArr, c0792dArr, true, 0, false, str);
        c1286f.f14985d = this.zzl.getPackageName();
        c1286f.f14988g = getServiceRequestExtraArgs;
        if (set != null) {
            c1286f.f14987f = (Scope[]) set.toArray(new Scope[0]);
        }
        if (requiresSignIn()) {
            Account account = getAccount();
            if (account == null) {
                account = new Account(DEFAULT_ACCOUNT, "com.google");
            }
            c1286f.f14989h = account;
            if (interfaceC1289i != null) {
                c1286f.f14986e = interfaceC1289i.asBinder();
            }
        } else if (requiresAccount()) {
            c1286f.f14989h = getAccount();
        }
        c1286f.f14990i = zze;
        c1286f.f14991j = getApiFeatures();
        if (usesClientTelemetry()) {
            c1286f.f14994m = true;
        }
        try {
            synchronized (this.zzq) {
                try {
                    InterfaceC1291k interfaceC1291k = this.zzr;
                    if (interfaceC1291k != null) {
                        interfaceC1291k.g(new Y(this, this.zzd.get()), c1286f);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } finally {
                }
            }
        } catch (DeadObjectException e8) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e8);
            triggerConnectionSuspended(3);
        } catch (RemoteException e9) {
            e = e9;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            onPostInitHandler(8, null, null, this.zzd.get());
        } catch (SecurityException e10) {
            throw e10;
        } catch (RuntimeException e11) {
            e = e11;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            onPostInitHandler(8, null, null, this.zzd.get());
        }
    }

    public Set<Scope> getScopes() {
        return Collections.emptySet();
    }

    public final IInterface getService() {
        IInterface iInterface;
        synchronized (this.zzp) {
            try {
                if (this.zzv == 5) {
                    throw new DeadObjectException();
                }
                checkConnected();
                IInterface iInterface2 = this.zzs;
                AbstractC1294n.k(iInterface2, "Client is connected but service is null");
                iInterface = iInterface2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    public IBinder getServiceBrokerBinder() {
        synchronized (this.zzq) {
            try {
                InterfaceC1291k interfaceC1291k = this.zzr;
                if (interfaceC1291k == null) {
                    return null;
                }
                return interfaceC1291k.asBinder();
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

    public C1285e getTelemetryConfiguration() {
        c0 c0Var = this.zzE;
        if (c0Var == null) {
            return null;
        }
        return c0Var.f14958d;
    }

    public boolean getUseDynamicLookup() {
        return getMinApkVersion() >= 211700000;
    }

    public boolean hasConnectionInfo() {
        return this.zzE != null;
    }

    public boolean isConnected() {
        boolean z7;
        synchronized (this.zzp) {
            z7 = this.zzv == 4;
        }
        return z7;
    }

    public boolean isConnecting() {
        boolean z7;
        synchronized (this.zzp) {
            int i8 = this.zzv;
            z7 = true;
            if (i8 != 2 && i8 != 3) {
                z7 = false;
            }
        }
        return z7;
    }

    public void onConnectedLocked(IInterface iInterface) {
        this.zzh = System.currentTimeMillis();
    }

    public void onConnectionFailed(C0790b c0790b) {
        this.zzi = c0790b.a();
        this.zzj = System.currentTimeMillis();
    }

    public void onConnectionSuspended(int i8) {
        this.zzf = i8;
        this.zzg = System.currentTimeMillis();
    }

    public void onPostInitHandler(int i8, IBinder iBinder, Bundle bundle, int i9) {
        this.zzb.sendMessage(this.zzb.obtainMessage(1, i9, -1, new a0(this, i8, iBinder, bundle)));
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

    public void setAttributionTag(String str) {
        this.zzA = str;
    }

    public void triggerConnectionSuspended(int i8) {
        this.zzb.sendMessage(this.zzb.obtainMessage(6, this.zzd.get(), i8));
    }

    public void triggerNotAvailable(InterfaceC0250c interfaceC0250c, int i8, PendingIntent pendingIntent) {
        AbstractC1294n.k(interfaceC0250c, "Connection progress callbacks cannot be null.");
        this.zzc = interfaceC0250c;
        this.zzb.sendMessage(this.zzb.obtainMessage(3, this.zzd.get(), i8, pendingIntent));
    }

    public boolean usesClientTelemetry() {
        return false;
    }

    public final String zze() {
        String str = this.zzz;
        return str == null ? this.zzl.getClass().getName() : str;
    }

    public final void zzl(int i8, Bundle bundle, int i9) {
        this.zzb.sendMessage(this.zzb.obtainMessage(7, i9, -1, new b0(this, i8, bundle)));
    }

    public AbstractC1283c(Context context, Looper looper, AbstractC1288h abstractC1288h, C0795g c0795g, int i8, a aVar, b bVar, String str) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList();
        this.zzv = 1;
        this.zzC = null;
        this.zzD = false;
        this.zzE = null;
        this.zzd = new AtomicInteger(0);
        AbstractC1294n.k(context, "Context must not be null");
        this.zzl = context;
        AbstractC1294n.k(looper, "Looper must not be null");
        this.zzm = looper;
        AbstractC1294n.k(abstractC1288h, "Supervisor must not be null");
        this.zzn = abstractC1288h;
        AbstractC1294n.k(c0795g, "API availability must not be null");
        this.zzo = c0795g;
        this.zzb = new W(this, looper);
        this.zzy = i8;
        this.zzw = aVar;
        this.zzx = bVar;
        this.zzz = str;
    }

    public void disconnect(String str) {
        this.zzk = str;
        disconnect();
    }

    public void setAttributionSourceWrapper(Y1.a aVar) {
    }
}
