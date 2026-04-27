package com.google.android.gms.common.internal;

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
import z1.C1984b;
import z1.C1986d;
import z1.C1989g;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0925c {
    public static final int CONNECT_STATE_CONNECTED = 4;
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    private volatile String zzA;
    private volatile I1.a zzB;
    private C1984b zzC;
    private boolean zzD;
    private volatile m0 zzE;
    x0 zza;
    final Handler zzb;
    protected InterfaceC0148c zzc;
    protected AtomicInteger zzd;
    private int zzf;
    private long zzg;
    private long zzh;
    private int zzi;
    private long zzj;
    private volatile String zzk;
    private final Context zzl;
    private final Looper zzm;
    private final AbstractC0931i zzn;
    private final C1989g zzo;
    private final Object zzp;
    private final Object zzq;
    private InterfaceC0936n zzr;
    private IInterface zzs;
    private final ArrayList zzt;
    private j0 zzu;
    private int zzv;
    private final a zzw;
    private final b zzx;
    private final int zzy;
    private final String zzz;
    private static final C1986d[] zze = new C1986d[0];
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.c$a */
    public interface a {
        void c(int i4);

        void f(Bundle bundle);
    }

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.c$b */
    public interface b {
        void b(C1984b c1984b);
    }

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.c$c, reason: collision with other inner class name */
    public interface InterfaceC0148c {
        void b(C1984b c1984b);
    }

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.c$d */
    public class d implements InterfaceC0148c {
        public d() {
        }

        @Override // com.google.android.gms.common.internal.AbstractC0925c.InterfaceC0148c
        public final void b(C1984b c1984b) {
            if (c1984b.n()) {
                AbstractC0925c abstractC0925c = AbstractC0925c.this;
                abstractC0925c.getRemoteService(null, abstractC0925c.getScopes());
            } else if (AbstractC0925c.this.zzx != null) {
                AbstractC0925c.this.zzx.b(c1984b);
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.common.internal.c$e */
    public interface e {
        void a();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AbstractC0925c(Context context, Looper looper, int i4, a aVar, b bVar, String str) {
        AbstractC0931i abstractC0931iB = AbstractC0931i.b(context);
        C1989g c1989gF = C1989g.f();
        AbstractC0940s.k(aVar);
        AbstractC0940s.k(bVar);
        this(context, looper, abstractC0931iB, c1989gF, i4, aVar, bVar, str);
    }

    public static /* bridge */ /* synthetic */ void zzj(AbstractC0925c abstractC0925c, m0 m0Var) {
        abstractC0925c.zzE = m0Var;
        if (abstractC0925c.usesClientTelemetry()) {
            C0928f c0928f = m0Var.f9938d;
            C0941t.b().c(c0928f == null ? null : c0928f.o());
        }
    }

    public static /* bridge */ /* synthetic */ void zzk(AbstractC0925c abstractC0925c, int i4) {
        int i5;
        int i6;
        synchronized (abstractC0925c.zzp) {
            i5 = abstractC0925c.zzv;
        }
        if (i5 == 3) {
            abstractC0925c.zzD = true;
            i6 = 5;
        } else {
            i6 = 4;
        }
        Handler handler = abstractC0925c.zzb;
        handler.sendMessage(handler.obtainMessage(i6, abstractC0925c.zzd.get(), 16));
    }

    public static /* bridge */ /* synthetic */ boolean zzn(AbstractC0925c abstractC0925c, int i4, int i5, IInterface iInterface) {
        synchronized (abstractC0925c.zzp) {
            try {
                if (abstractC0925c.zzv != i4) {
                    return false;
                }
                abstractC0925c.c(i5, iInterface);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* bridge */ /* synthetic */ boolean zzo(AbstractC0925c abstractC0925c) {
        if (abstractC0925c.zzD || TextUtils.isEmpty(abstractC0925c.getServiceDescriptor()) || TextUtils.isEmpty(abstractC0925c.getLocalStartServiceAction())) {
            return false;
        }
        try {
            Class.forName(abstractC0925c.getServiceDescriptor());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void c(int i4, IInterface iInterface) {
        x0 x0Var;
        AbstractC0940s.a((i4 == 4) == (iInterface != null));
        synchronized (this.zzp) {
            try {
                this.zzv = i4;
                this.zzs = iInterface;
                Bundle bundle = null;
                if (i4 == 1) {
                    j0 j0Var = this.zzu;
                    if (j0Var != null) {
                        AbstractC0931i abstractC0931i = this.zzn;
                        String strB = this.zza.b();
                        AbstractC0940s.k(strB);
                        abstractC0931i.g(strB, this.zza.a(), 4225, j0Var, zze(), this.zza.c());
                        this.zzu = null;
                    }
                } else if (i4 == 2 || i4 == 3) {
                    j0 j0Var2 = this.zzu;
                    if (j0Var2 != null && (x0Var = this.zza) != null) {
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + x0Var.b() + " on " + x0Var.a());
                        AbstractC0931i abstractC0931i2 = this.zzn;
                        String strB2 = this.zza.b();
                        AbstractC0940s.k(strB2);
                        abstractC0931i2.g(strB2, this.zza.a(), 4225, j0Var2, zze(), this.zza.c());
                        this.zzd.incrementAndGet();
                    }
                    j0 j0Var3 = new j0(this, this.zzd.get());
                    this.zzu = j0Var3;
                    x0 x0Var2 = (this.zzv != 3 || getLocalStartServiceAction() == null) ? new x0(getStartServicePackage(), getStartServiceAction(), false, 4225, getUseDynamicLookup()) : new x0(getContext().getPackageName(), getLocalStartServiceAction(), true, 4225, false);
                    this.zza = x0Var2;
                    if (x0Var2.c() && getMinApkVersion() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.zza.b())));
                    }
                    AbstractC0931i abstractC0931i3 = this.zzn;
                    String strB3 = this.zza.b();
                    AbstractC0940s.k(strB3);
                    C1984b c1984bE = abstractC0931i3.e(new q0(strB3, this.zza.a(), 4225, this.zza.c()), j0Var3, zze(), getBindServiceExecutor());
                    if (!c1984bE.n()) {
                        Log.w("GmsClient", "unable to connect to service: " + this.zza.b() + " on " + this.zza.a());
                        int i5 = c1984bE.i() == -1 ? 16 : c1984bE.i();
                        if (c1984bE.l() != null) {
                            bundle = new Bundle();
                            bundle.putParcelable(KEY_PENDING_INTENT, c1984bE.l());
                        }
                        zzl(i5, bundle, this.zzd.get());
                    }
                } else if (i4 == 4) {
                    AbstractC0940s.k(iInterface);
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

    public void connect(InterfaceC0148c interfaceC0148c) {
        AbstractC0940s.l(interfaceC0148c, "Connection progress callbacks cannot be null.");
        this.zzc = interfaceC0148c;
        c(2, null);
    }

    public abstract IInterface createServiceInterface(IBinder iBinder);

    public void disconnect() {
        this.zzd.incrementAndGet();
        synchronized (this.zzt) {
            try {
                int size = this.zzt.size();
                for (int i4 = 0; i4 < size; i4++) {
                    ((h0) this.zzt.get(i4)).d();
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
        int i4;
        IInterface iInterface;
        InterfaceC0936n interfaceC0936n;
        synchronized (this.zzp) {
            i4 = this.zzv;
            iInterface = this.zzs;
        }
        synchronized (this.zzq) {
            interfaceC0936n = this.zzr;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        if (i4 == 1) {
            printWriter.print("DISCONNECTED");
        } else if (i4 == 2) {
            printWriter.print("REMOTE_CONNECTING");
        } else if (i4 == 3) {
            printWriter.print("LOCAL_CONNECTING");
        } else if (i4 == 4) {
            printWriter.print("CONNECTED");
        } else if (i4 != 5) {
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
        if (interfaceC0936n == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(interfaceC0936n.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzh > 0) {
            PrintWriter printWriterAppend = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j4 = this.zzh;
            printWriterAppend.println(j4 + " " + simpleDateFormat.format(new Date(j4)));
        }
        if (this.zzg > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i5 = this.zzf;
            if (i5 == 1) {
                printWriter.append("CAUSE_SERVICE_DISCONNECTED");
            } else if (i5 == 2) {
                printWriter.append("CAUSE_NETWORK_LOST");
            } else if (i5 != 3) {
                printWriter.append((CharSequence) String.valueOf(i5));
            } else {
                printWriter.append("CAUSE_DEAD_OBJECT_EXCEPTION");
            }
            PrintWriter printWriterAppend2 = printWriter.append(" lastSuspendedTime=");
            long j5 = this.zzg;
            printWriterAppend2.println(j5 + " " + simpleDateFormat.format(new Date(j5)));
        }
        if (this.zzj > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) com.google.android.gms.common.api.c.a(this.zzi));
            PrintWriter printWriterAppend3 = printWriter.append(" lastFailedTime=");
            long j6 = this.zzj;
            printWriterAppend3.println(j6 + " " + simpleDateFormat.format(new Date(j6)));
        }
    }

    public boolean enableLocalFallback() {
        return false;
    }

    public Account getAccount() {
        return null;
    }

    public C1986d[] getApiFeatures() {
        return zze;
    }

    public I1.a getAttributionSourceWrapper() {
        return null;
    }

    public final C1986d[] getAvailableFeatures() {
        m0 m0Var = this.zzE;
        if (m0Var == null) {
            return null;
        }
        return m0Var.f9936b;
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

    public void getRemoteService(InterfaceC0933k interfaceC0933k, Set<Scope> set) {
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        String str = Build.VERSION.SDK_INT < 31 ? this.zzA : this.zzA;
        int i4 = this.zzy;
        int i5 = C1989g.f16096a;
        Scope[] scopeArr = C0929g.f9900o;
        Bundle bundle = new Bundle();
        C1986d[] c1986dArr = C0929g.f9901p;
        C0929g c0929g = new C0929g(6, i4, i5, null, null, scopeArr, bundle, null, c1986dArr, c1986dArr, true, 0, false, str);
        c0929g.f9905d = this.zzl.getPackageName();
        c0929g.f9908g = getServiceRequestExtraArgs;
        if (set != null) {
            c0929g.f9907f = (Scope[]) set.toArray(new Scope[0]);
        }
        if (requiresSignIn()) {
            Account account = getAccount();
            if (account == null) {
                account = new Account(DEFAULT_ACCOUNT, "com.google");
            }
            c0929g.f9909h = account;
            if (interfaceC0933k != null) {
                c0929g.f9906e = interfaceC0933k.asBinder();
            }
        } else if (requiresAccount()) {
            c0929g.f9909h = getAccount();
        }
        c0929g.f9910i = zze;
        c0929g.f9911j = getApiFeatures();
        if (usesClientTelemetry()) {
            c0929g.f9914m = true;
        }
        try {
            synchronized (this.zzq) {
                try {
                    InterfaceC0936n interfaceC0936n = this.zzr;
                    if (interfaceC0936n != null) {
                        interfaceC0936n.m(new i0(this, this.zzd.get()), c0929g);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } finally {
                }
            }
        } catch (DeadObjectException e4) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e4);
            triggerConnectionSuspended(3);
        } catch (RemoteException e5) {
            e = e5;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            onPostInitHandler(8, null, null, this.zzd.get());
        } catch (SecurityException e6) {
            throw e6;
        } catch (RuntimeException e7) {
            e = e7;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            onPostInitHandler(8, null, null, this.zzd.get());
        }
    }

    public Set getScopes() {
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
                AbstractC0940s.l(iInterface, "Client is connected but service is null");
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    public IBinder getServiceBrokerBinder() {
        synchronized (this.zzq) {
            try {
                InterfaceC0936n interfaceC0936n = this.zzr;
                if (interfaceC0936n == null) {
                    return null;
                }
                return interfaceC0936n.asBinder();
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

    public C0928f getTelemetryConfiguration() {
        m0 m0Var = this.zzE;
        if (m0Var == null) {
            return null;
        }
        return m0Var.f9938d;
    }

    public boolean getUseDynamicLookup() {
        return getMinApkVersion() >= 211700000;
    }

    public boolean hasConnectionInfo() {
        return this.zzE != null;
    }

    public boolean isConnected() {
        boolean z4;
        synchronized (this.zzp) {
            z4 = this.zzv == 4;
        }
        return z4;
    }

    public boolean isConnecting() {
        boolean z4;
        synchronized (this.zzp) {
            int i4 = this.zzv;
            z4 = true;
            if (i4 != 2 && i4 != 3) {
                z4 = false;
            }
        }
        return z4;
    }

    public void onConnectedLocked(IInterface iInterface) {
        this.zzh = System.currentTimeMillis();
    }

    public void onConnectionFailed(C1984b c1984b) {
        this.zzi = c1984b.i();
        this.zzj = System.currentTimeMillis();
    }

    public void onConnectionSuspended(int i4) {
        this.zzf = i4;
        this.zzg = System.currentTimeMillis();
    }

    public void onPostInitHandler(int i4, IBinder iBinder, Bundle bundle, int i5) {
        this.zzb.sendMessage(this.zzb.obtainMessage(1, i5, -1, new k0(this, i4, iBinder, bundle)));
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

    public void triggerConnectionSuspended(int i4) {
        this.zzb.sendMessage(this.zzb.obtainMessage(6, this.zzd.get(), i4));
    }

    public void triggerNotAvailable(InterfaceC0148c interfaceC0148c, int i4, PendingIntent pendingIntent) {
        AbstractC0940s.l(interfaceC0148c, "Connection progress callbacks cannot be null.");
        this.zzc = interfaceC0148c;
        this.zzb.sendMessage(this.zzb.obtainMessage(3, this.zzd.get(), i4, pendingIntent));
    }

    public boolean usesClientTelemetry() {
        return false;
    }

    public final String zze() {
        String str = this.zzz;
        return str == null ? this.zzl.getClass().getName() : str;
    }

    public final void zzl(int i4, Bundle bundle, int i5) {
        this.zzb.sendMessage(this.zzb.obtainMessage(7, i5, -1, new l0(this, i4, bundle)));
    }

    public AbstractC0925c(Context context, Looper looper, AbstractC0931i abstractC0931i, C1989g c1989g, int i4, a aVar, b bVar, String str) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList();
        this.zzv = 1;
        this.zzC = null;
        this.zzD = false;
        this.zzE = null;
        this.zzd = new AtomicInteger(0);
        AbstractC0940s.l(context, "Context must not be null");
        this.zzl = context;
        AbstractC0940s.l(looper, "Looper must not be null");
        this.zzm = looper;
        AbstractC0940s.l(abstractC0931i, "Supervisor must not be null");
        this.zzn = abstractC0931i;
        AbstractC0940s.l(c1989g, "API availability must not be null");
        this.zzo = c1989g;
        this.zzb = new g0(this, looper);
        this.zzy = i4;
        this.zzw = aVar;
        this.zzx = bVar;
        this.zzz = str;
    }

    public void disconnect(String str) {
        this.zzk = str;
        disconnect();
    }

    public void setAttributionSourceWrapper(I1.a aVar) {
    }
}
