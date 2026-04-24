package com.google.android.gms.common.internal;

import P1.C0648b;
import P1.C0650d;
import P1.C0653g;
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
public abstract class AbstractC1192c {
    public static final int CONNECT_STATE_CONNECTED = 4;
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    private volatile String zzA;
    private volatile Y1.a zzB;
    private C0648b zzC;
    private boolean zzD;
    private volatile m0 zzE;
    x0 zza;
    final Handler zzb;
    protected InterfaceC0181c zzc;
    protected AtomicInteger zzd;
    private int zzf;
    private long zzg;
    private long zzh;
    private int zzi;
    private long zzj;
    private volatile String zzk;
    private final Context zzl;
    private final Looper zzm;
    private final AbstractC1198i zzn;
    private final C0653g zzo;
    private final Object zzp;
    private final Object zzq;
    private InterfaceC1203n zzr;
    private IInterface zzs;
    private final ArrayList zzt;
    private j0 zzu;
    private int zzv;
    private final a zzw;
    private final b zzx;
    private final int zzy;
    private final String zzz;
    private static final C0650d[] zze = new C0650d[0];
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.c$a */
    public interface a {
        void b(int i7);

        void f(Bundle bundle);
    }

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.c$b */
    public interface b {
        void c(C0648b c0648b);
    }

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.c$c, reason: collision with other inner class name */
    public interface InterfaceC0181c {
        void b(C0648b c0648b);
    }

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.c$d */
    public class d implements InterfaceC0181c {
        public d() {
        }

        @Override // com.google.android.gms.common.internal.AbstractC1192c.InterfaceC0181c
        public final void b(C0648b c0648b) {
            if (c0648b.E()) {
                AbstractC1192c abstractC1192c = AbstractC1192c.this;
                abstractC1192c.getRemoteService(null, abstractC1192c.getScopes());
            } else if (AbstractC1192c.this.zzx != null) {
                AbstractC1192c.this.zzx.c(c0648b);
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.c$e */
    public interface e {
        void a();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AbstractC1192c(Context context, Looper looper, int i7, a aVar, b bVar, String str) {
        AbstractC1198i abstractC1198iB = AbstractC1198i.b(context);
        C0653g c0653gF = C0653g.f();
        AbstractC1207s.k(aVar);
        AbstractC1207s.k(bVar);
        this(context, looper, abstractC1198iB, c0653gF, i7, aVar, bVar, str);
    }

    public static /* bridge */ /* synthetic */ void zzj(AbstractC1192c abstractC1192c, m0 m0Var) {
        abstractC1192c.zzE = m0Var;
        if (abstractC1192c.usesClientTelemetry()) {
            C1195f c1195f = m0Var.f11121d;
            C1208t.b().c(c1195f == null ? null : c1195f.F());
        }
    }

    public static /* bridge */ /* synthetic */ void zzk(AbstractC1192c abstractC1192c, int i7) {
        int i8;
        int i9;
        synchronized (abstractC1192c.zzp) {
            i8 = abstractC1192c.zzv;
        }
        if (i8 == 3) {
            abstractC1192c.zzD = true;
            i9 = 5;
        } else {
            i9 = 4;
        }
        Handler handler = abstractC1192c.zzb;
        handler.sendMessage(handler.obtainMessage(i9, abstractC1192c.zzd.get(), 16));
    }

    public static /* bridge */ /* synthetic */ boolean zzn(AbstractC1192c abstractC1192c, int i7, int i8, IInterface iInterface) {
        synchronized (abstractC1192c.zzp) {
            try {
                if (abstractC1192c.zzv != i7) {
                    return false;
                }
                abstractC1192c.c(i8, iInterface);
                return true;
            } finally {
            }
        }
    }

    public static /* bridge */ /* synthetic */ boolean zzo(AbstractC1192c abstractC1192c) {
        if (abstractC1192c.zzD || TextUtils.isEmpty(abstractC1192c.getServiceDescriptor()) || TextUtils.isEmpty(abstractC1192c.getLocalStartServiceAction())) {
            return false;
        }
        try {
            Class.forName(abstractC1192c.getServiceDescriptor());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void c(int i7, IInterface iInterface) {
        x0 x0Var;
        AbstractC1207s.a((i7 == 4) == (iInterface != null));
        synchronized (this.zzp) {
            try {
                this.zzv = i7;
                this.zzs = iInterface;
                Bundle bundle = null;
                if (i7 == 1) {
                    j0 j0Var = this.zzu;
                    if (j0Var != null) {
                        AbstractC1198i abstractC1198i = this.zzn;
                        String strB = this.zza.b();
                        AbstractC1207s.k(strB);
                        abstractC1198i.g(strB, this.zza.a(), 4225, j0Var, zze(), this.zza.c());
                        this.zzu = null;
                    }
                } else if (i7 == 2 || i7 == 3) {
                    j0 j0Var2 = this.zzu;
                    if (j0Var2 != null && (x0Var = this.zza) != null) {
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + x0Var.b() + " on " + x0Var.a());
                        AbstractC1198i abstractC1198i2 = this.zzn;
                        String strB2 = this.zza.b();
                        AbstractC1207s.k(strB2);
                        abstractC1198i2.g(strB2, this.zza.a(), 4225, j0Var2, zze(), this.zza.c());
                        this.zzd.incrementAndGet();
                    }
                    j0 j0Var3 = new j0(this, this.zzd.get());
                    this.zzu = j0Var3;
                    x0 x0Var2 = (this.zzv != 3 || getLocalStartServiceAction() == null) ? new x0(getStartServicePackage(), getStartServiceAction(), false, 4225, getUseDynamicLookup()) : new x0(getContext().getPackageName(), getLocalStartServiceAction(), true, 4225, false);
                    this.zza = x0Var2;
                    if (x0Var2.c() && getMinApkVersion() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.zza.b())));
                    }
                    AbstractC1198i abstractC1198i3 = this.zzn;
                    String strB3 = this.zza.b();
                    AbstractC1207s.k(strB3);
                    C0648b c0648bE = abstractC1198i3.e(new q0(strB3, this.zza.a(), 4225, this.zza.c()), j0Var3, zze(), getBindServiceExecutor());
                    if (!c0648bE.E()) {
                        Log.w("GmsClient", "unable to connect to service: " + this.zza.b() + " on " + this.zza.a());
                        int iA = c0648bE.A() == -1 ? 16 : c0648bE.A();
                        if (c0648bE.C() != null) {
                            bundle = new Bundle();
                            bundle.putParcelable(KEY_PENDING_INTENT, c0648bE.C());
                        }
                        zzl(iA, bundle, this.zzd.get());
                    }
                } else if (i7 == 4) {
                    AbstractC1207s.k(iInterface);
                    onConnectedLocked(iInterface);
                }
            } finally {
            }
        }
    }

    public void checkAvailabilityAndConnect() {
        int iH = this.zzo.h(this.zzl, getMinApkVersion());
        if (iH == 0) {
            connect(new d());
        } else {
            c(1, null);
            triggerNotAvailable(new d(), iH, null);
        }
    }

    public final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect(InterfaceC0181c interfaceC0181c) {
        AbstractC1207s.l(interfaceC0181c, "Connection progress callbacks cannot be null.");
        this.zzc = interfaceC0181c;
        c(2, null);
    }

    public abstract IInterface createServiceInterface(IBinder iBinder);

    public void disconnect() {
        this.zzd.incrementAndGet();
        synchronized (this.zzt) {
            try {
                int size = this.zzt.size();
                for (int i7 = 0; i7 < size; i7++) {
                    ((h0) this.zzt.get(i7)).d();
                }
                this.zzt.clear();
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
        int i7;
        IInterface iInterface;
        InterfaceC1203n interfaceC1203n;
        synchronized (this.zzp) {
            i7 = this.zzv;
            iInterface = this.zzs;
        }
        synchronized (this.zzq) {
            interfaceC1203n = this.zzr;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        if (i7 == 1) {
            printWriter.print("DISCONNECTED");
        } else if (i7 == 2) {
            printWriter.print("REMOTE_CONNECTING");
        } else if (i7 == 3) {
            printWriter.print("LOCAL_CONNECTING");
        } else if (i7 == 4) {
            printWriter.print("CONNECTED");
        } else if (i7 != 5) {
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
        if (interfaceC1203n == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(interfaceC1203n.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzh > 0) {
            PrintWriter printWriterAppend = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j7 = this.zzh;
            printWriterAppend.println(j7 + " " + simpleDateFormat.format(new Date(j7)));
        }
        if (this.zzg > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i8 = this.zzf;
            if (i8 == 1) {
                printWriter.append("CAUSE_SERVICE_DISCONNECTED");
            } else if (i8 == 2) {
                printWriter.append("CAUSE_NETWORK_LOST");
            } else if (i8 != 3) {
                printWriter.append((CharSequence) String.valueOf(i8));
            } else {
                printWriter.append("CAUSE_DEAD_OBJECT_EXCEPTION");
            }
            PrintWriter printWriterAppend2 = printWriter.append(" lastSuspendedTime=");
            long j8 = this.zzg;
            printWriterAppend2.println(j8 + " " + simpleDateFormat.format(new Date(j8)));
        }
        if (this.zzj > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) com.google.android.gms.common.api.c.a(this.zzi));
            PrintWriter printWriterAppend3 = printWriter.append(" lastFailedTime=");
            long j9 = this.zzj;
            printWriterAppend3.println(j9 + " " + simpleDateFormat.format(new Date(j9)));
        }
    }

    public boolean enableLocalFallback() {
        return false;
    }

    public Account getAccount() {
        return null;
    }

    public C0650d[] getApiFeatures() {
        return zze;
    }

    public Y1.a getAttributionSourceWrapper() {
        return null;
    }

    public final C0650d[] getAvailableFeatures() {
        m0 m0Var = this.zzE;
        if (m0Var == null) {
            return null;
        }
        return m0Var.f11119b;
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
        x0 x0Var;
        if (!isConnected() || (x0Var = this.zza) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return x0Var.a();
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

    public void getRemoteService(InterfaceC1200k interfaceC1200k, Set<Scope> set) {
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        String str = Build.VERSION.SDK_INT < 31 ? this.zzA : this.zzA;
        int i7 = this.zzy;
        int i8 = C0653g.f4299a;
        Scope[] scopeArr = C1196g.f11083o;
        Bundle bundle = new Bundle();
        C0650d[] c0650dArr = C1196g.f11084p;
        C1196g c1196g = new C1196g(6, i7, i8, null, null, scopeArr, bundle, null, c0650dArr, c0650dArr, true, 0, false, str);
        c1196g.f11088d = this.zzl.getPackageName();
        c1196g.f11091g = getServiceRequestExtraArgs;
        if (set != null) {
            c1196g.f11090f = (Scope[]) set.toArray(new Scope[0]);
        }
        if (requiresSignIn()) {
            Account account = getAccount();
            if (account == null) {
                account = new Account(DEFAULT_ACCOUNT, "com.google");
            }
            c1196g.f11092h = account;
            if (interfaceC1200k != null) {
                c1196g.f11089e = interfaceC1200k.asBinder();
            }
        } else if (requiresAccount()) {
            c1196g.f11092h = getAccount();
        }
        c1196g.f11093i = zze;
        c1196g.f11094j = getApiFeatures();
        if (usesClientTelemetry()) {
            c1196g.f11097m = true;
        }
        try {
            synchronized (this.zzq) {
                try {
                    InterfaceC1203n interfaceC1203n = this.zzr;
                    if (interfaceC1203n != null) {
                        interfaceC1203n.m(new i0(this, this.zzd.get()), c1196g);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } finally {
                }
            }
        } catch (DeadObjectException e7) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e7);
            triggerConnectionSuspended(3);
        } catch (RemoteException e8) {
            e = e8;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            onPostInitHandler(8, null, null, this.zzd.get());
        } catch (SecurityException e9) {
            throw e9;
        } catch (RuntimeException e10) {
            e = e10;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            onPostInitHandler(8, null, null, this.zzd.get());
        }
    }

    public Set getScopes() {
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
                iInterface = this.zzs;
                AbstractC1207s.l(iInterface, "Client is connected but service is null");
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    public IBinder getServiceBrokerBinder() {
        synchronized (this.zzq) {
            try {
                InterfaceC1203n interfaceC1203n = this.zzr;
                if (interfaceC1203n == null) {
                    return null;
                }
                return interfaceC1203n.asBinder();
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

    public C1195f getTelemetryConfiguration() {
        m0 m0Var = this.zzE;
        if (m0Var == null) {
            return null;
        }
        return m0Var.f11121d;
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
            int i7 = this.zzv;
            z7 = true;
            if (i7 != 2 && i7 != 3) {
                z7 = false;
            }
        }
        return z7;
    }

    public void onConnectedLocked(IInterface iInterface) {
        this.zzh = System.currentTimeMillis();
    }

    public void onConnectionFailed(C0648b c0648b) {
        this.zzi = c0648b.A();
        this.zzj = System.currentTimeMillis();
    }

    public void onConnectionSuspended(int i7) {
        this.zzf = i7;
        this.zzg = System.currentTimeMillis();
    }

    public void onPostInitHandler(int i7, IBinder iBinder, Bundle bundle, int i8) {
        this.zzb.sendMessage(this.zzb.obtainMessage(1, i8, -1, new k0(this, i7, iBinder, bundle)));
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

    public void triggerConnectionSuspended(int i7) {
        this.zzb.sendMessage(this.zzb.obtainMessage(6, this.zzd.get(), i7));
    }

    public void triggerNotAvailable(InterfaceC0181c interfaceC0181c, int i7, PendingIntent pendingIntent) {
        AbstractC1207s.l(interfaceC0181c, "Connection progress callbacks cannot be null.");
        this.zzc = interfaceC0181c;
        this.zzb.sendMessage(this.zzb.obtainMessage(3, this.zzd.get(), i7, pendingIntent));
    }

    public boolean usesClientTelemetry() {
        return false;
    }

    public final String zze() {
        String str = this.zzz;
        return str == null ? this.zzl.getClass().getName() : str;
    }

    public final void zzl(int i7, Bundle bundle, int i8) {
        this.zzb.sendMessage(this.zzb.obtainMessage(7, i8, -1, new l0(this, i7, bundle)));
    }

    public AbstractC1192c(Context context, Looper looper, AbstractC1198i abstractC1198i, C0653g c0653g, int i7, a aVar, b bVar, String str) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList();
        this.zzv = 1;
        this.zzC = null;
        this.zzD = false;
        this.zzE = null;
        this.zzd = new AtomicInteger(0);
        AbstractC1207s.l(context, "Context must not be null");
        this.zzl = context;
        AbstractC1207s.l(looper, "Looper must not be null");
        this.zzm = looper;
        AbstractC1207s.l(abstractC1198i, "Supervisor must not be null");
        this.zzn = abstractC1198i;
        AbstractC1207s.l(c0653g, "API availability must not be null");
        this.zzo = c0653g;
        this.zzb = new g0(this, looper);
        this.zzy = i7;
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
