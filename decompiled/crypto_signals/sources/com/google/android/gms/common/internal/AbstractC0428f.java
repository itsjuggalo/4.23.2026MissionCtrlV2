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
import u1.C1200b;
import u1.C1202d;
import u1.C1204f;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0428f {
    public static final int CONNECT_STATE_CONNECTED = 4;
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    private volatile String zzA;
    private volatile D1.a zzB;
    X zza;
    final Handler zzb;
    protected InterfaceC0426d zzc;
    private int zzf;
    private long zzg;
    private long zzh;
    private int zzi;
    private long zzj;
    private final Context zzl;
    private final Looper zzm;
    private final AbstractC0434l zzn;
    private final C1204f zzo;
    private InterfaceC0438p zzr;
    private IInterface zzs;
    private M zzu;
    private final InterfaceC0424b zzw;
    private final InterfaceC0425c zzx;
    private final int zzy;
    private final String zzz;
    private static final C1202d[] zze = new C1202d[0];
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};
    private volatile String zzk = null;
    private final Object zzp = new Object();
    private final Object zzq = new Object();
    private final ArrayList zzt = new ArrayList();
    private int zzv = 1;
    private C1200b zzC = null;
    private boolean zzD = false;
    private volatile P zzE = null;
    protected AtomicInteger zzd = new AtomicInteger(0);

    public AbstractC0428f(Context context, Looper looper, V v2, C1204f c1204f, int i, InterfaceC0424b interfaceC0424b, InterfaceC0425c interfaceC0425c, String str) {
        I.h(context, "Context must not be null");
        this.zzl = context;
        I.h(looper, "Looper must not be null");
        this.zzm = looper;
        I.h(v2, "Supervisor must not be null");
        this.zzn = v2;
        I.h(c1204f, "API availability must not be null");
        this.zzo = c1204f;
        this.zzb = new K(this, looper);
        this.zzy = i;
        this.zzw = interfaceC0424b;
        this.zzx = interfaceC0425c;
        this.zzz = str;
    }

    public static void zzj(AbstractC0428f abstractC0428f, P p3) {
        abstractC0428f.zzE = p3;
        if (abstractC0428f.usesClientTelemetry()) {
            C0431i c0431i = p3.f5212d;
            C0441t c0441tE = C0441t.e();
            C0442u c0442u = c0431i == null ? null : c0431i.f5243a;
            synchronized (c0441tE) {
                if (c0442u == null) {
                    c0441tE.f5281a = C0441t.f5280c;
                    return;
                }
                C0442u c0442u2 = (C0442u) c0441tE.f5281a;
                if (c0442u2 == null || c0442u2.f5282a < c0442u.f5282a) {
                    c0441tE.f5281a = c0442u;
                }
            }
        }
    }

    public static /* bridge */ /* synthetic */ void zzk(AbstractC0428f abstractC0428f, int i) {
        int i6;
        int i7;
        synchronized (abstractC0428f.zzp) {
            i6 = abstractC0428f.zzv;
        }
        if (i6 == 3) {
            abstractC0428f.zzD = true;
            i7 = 5;
        } else {
            i7 = 4;
        }
        Handler handler = abstractC0428f.zzb;
        handler.sendMessage(handler.obtainMessage(i7, abstractC0428f.zzd.get(), 16));
    }

    public static /* bridge */ /* synthetic */ boolean zzn(AbstractC0428f abstractC0428f, int i, int i6, IInterface iInterface) {
        synchronized (abstractC0428f.zzp) {
            try {
                if (abstractC0428f.zzv != i) {
                    return false;
                }
                abstractC0428f.a(i6, iInterface);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* bridge */ /* synthetic */ boolean zzo(AbstractC0428f abstractC0428f) {
        if (abstractC0428f.zzD || TextUtils.isEmpty(abstractC0428f.getServiceDescriptor()) || TextUtils.isEmpty(abstractC0428f.getLocalStartServiceAction())) {
            return false;
        }
        try {
            Class.forName(abstractC0428f.getServiceDescriptor());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final void a(int i, IInterface iInterface) {
        X x6;
        I.b((i == 4) == (iInterface != null));
        synchronized (this.zzp) {
            try {
                this.zzv = i;
                this.zzs = iInterface;
                Bundle bundle = null;
                if (i == 1) {
                    M m5 = this.zzu;
                    if (m5 != null) {
                        AbstractC0434l abstractC0434l = this.zzn;
                        String str = this.zza.f5230a;
                        I.g(str);
                        String str2 = this.zza.f5231b;
                        zze();
                        boolean z6 = this.zza.f5232c;
                        abstractC0434l.getClass();
                        abstractC0434l.c(new S(str, str2, z6), m5);
                        this.zzu = null;
                    }
                } else if (i == 2 || i == 3) {
                    M m6 = this.zzu;
                    if (m6 != null && (x6 = this.zza) != null) {
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + x6.f5230a + " on " + x6.f5231b);
                        AbstractC0434l abstractC0434l2 = this.zzn;
                        String str3 = this.zza.f5230a;
                        I.g(str3);
                        String str4 = this.zza.f5231b;
                        zze();
                        boolean z7 = this.zza.f5232c;
                        abstractC0434l2.getClass();
                        abstractC0434l2.c(new S(str3, str4, z7), m6);
                        this.zzd.incrementAndGet();
                    }
                    M m7 = new M(this, this.zzd.get());
                    this.zzu = m7;
                    X x7 = (this.zzv != 3 || getLocalStartServiceAction() == null) ? new X(getStartServicePackage(), getStartServiceAction(), getUseDynamicLookup()) : new X(getContext().getPackageName(), getLocalStartServiceAction(), false);
                    this.zza = x7;
                    if (x7.f5232c && getMinApkVersion() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.zza.f5230a)));
                    }
                    AbstractC0434l abstractC0434l3 = this.zzn;
                    String str5 = this.zza.f5230a;
                    I.g(str5);
                    C1200b c1200bB = abstractC0434l3.b(new S(str5, this.zza.f5231b, this.zza.f5232c), m7, zze(), getBindServiceExecutor());
                    if (!c1200bB.m()) {
                        X x8 = this.zza;
                        Log.w("GmsClient", "unable to connect to service: " + x8.f5230a + " on " + x8.f5231b);
                        int i6 = c1200bB.f10274b;
                        if (i6 == -1) {
                            i6 = 16;
                        }
                        if (c1200bB.f10275c != null) {
                            bundle = new Bundle();
                            bundle.putParcelable(KEY_PENDING_INTENT, c1200bB.f10275c);
                        }
                        zzl(i6, bundle, this.zzd.get());
                    }
                } else if (i == 4) {
                    I.g(iInterface);
                    onConnectedLocked(iInterface);
                }
            } finally {
            }
        }
    }

    public void checkAvailabilityAndConnect() {
        int iC = this.zzo.c(this.zzl, getMinApkVersion());
        if (iC == 0) {
            connect(new C0441t(this));
        } else {
            a(1, null);
            triggerNotAvailable(new C0441t(this), iC, null);
        }
    }

    public final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect(InterfaceC0426d interfaceC0426d) {
        I.h(interfaceC0426d, "Connection progress callbacks cannot be null.");
        this.zzc = interfaceC0426d;
        a(2, null);
    }

    public abstract IInterface createServiceInterface(IBinder iBinder);

    public void disconnect() {
        this.zzd.incrementAndGet();
        synchronized (this.zzt) {
            try {
                int size = this.zzt.size();
                for (int i = 0; i < size; i++) {
                    C c6 = (C) this.zzt.get(i);
                    synchronized (c6) {
                        c6.f5190a = null;
                    }
                }
                this.zzt.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.zzq) {
            this.zzr = null;
        }
        a(1, null);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        IInterface iInterface;
        InterfaceC0438p interfaceC0438p;
        synchronized (this.zzp) {
            i = this.zzv;
            iInterface = this.zzs;
        }
        synchronized (this.zzq) {
            interfaceC0438p = this.zzr;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        if (i == 1) {
            printWriter.print("DISCONNECTED");
        } else if (i == 2) {
            printWriter.print("REMOTE_CONNECTING");
        } else if (i == 3) {
            printWriter.print("LOCAL_CONNECTING");
        } else if (i == 4) {
            printWriter.print("CONNECTED");
        } else if (i != 5) {
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
        if (interfaceC0438p == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(((E) interfaceC0438p).asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzh > 0) {
            PrintWriter printWriterAppend = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j4 = this.zzh;
            printWriterAppend.println(j4 + " " + simpleDateFormat.format(new Date(j4)));
        }
        if (this.zzg > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i6 = this.zzf;
            if (i6 == 1) {
                printWriter.append("CAUSE_SERVICE_DISCONNECTED");
            } else if (i6 == 2) {
                printWriter.append("CAUSE_NETWORK_LOST");
            } else if (i6 != 3) {
                printWriter.append((CharSequence) String.valueOf(i6));
            } else {
                printWriter.append("CAUSE_DEAD_OBJECT_EXCEPTION");
            }
            PrintWriter printWriterAppend2 = printWriter.append(" lastSuspendedTime=");
            long j6 = this.zzg;
            printWriterAppend2.println(j6 + " " + simpleDateFormat.format(new Date(j6)));
        }
        if (this.zzj > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) android.support.v4.media.session.a.o(this.zzi));
            PrintWriter printWriterAppend3 = printWriter.append(" lastFailedTime=");
            long j7 = this.zzj;
            printWriterAppend3.println(j7 + " " + simpleDateFormat.format(new Date(j7)));
        }
    }

    public boolean enableLocalFallback() {
        return false;
    }

    public Account getAccount() {
        return null;
    }

    public C1202d[] getApiFeatures() {
        return zze;
    }

    public D1.a getAttributionSourceWrapper() {
        return null;
    }

    public final C1202d[] getAvailableFeatures() {
        P p3 = this.zzE;
        if (p3 == null) {
            return null;
        }
        return p3.f5210b;
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
        X x6;
        if (!isConnected() || (x6 = this.zza) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return x6.f5231b;
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

    public void getRemoteService(InterfaceC0436n interfaceC0436n, Set<Scope> set) {
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        String str = Build.VERSION.SDK_INT < 31 ? this.zzA : this.zzA;
        int i = this.zzy;
        int i6 = C1204f.f10285a;
        Scope[] scopeArr = C0432j.f5248s;
        Bundle bundle = new Bundle();
        C1202d[] c1202dArr = C0432j.f5249t;
        C0432j c0432j = new C0432j(6, i, i6, null, null, scopeArr, bundle, null, c1202dArr, c1202dArr, true, 0, false, str);
        c0432j.f5253d = this.zzl.getPackageName();
        c0432j.f5255k = getServiceRequestExtraArgs;
        if (set != null) {
            c0432j.f5254f = (Scope[]) set.toArray(new Scope[0]);
        }
        if (requiresSignIn()) {
            Account account = getAccount();
            if (account == null) {
                account = new Account(DEFAULT_ACCOUNT, "com.google");
            }
            c0432j.f5256l = account;
            if (interfaceC0436n != null) {
                c0432j.e = interfaceC0436n.asBinder();
            }
        } else if (requiresAccount()) {
            c0432j.f5256l = getAccount();
        }
        c0432j.f5257m = zze;
        c0432j.f5258n = getApiFeatures();
        if (usesClientTelemetry()) {
            c0432j.f5261q = true;
        }
        try {
            synchronized (this.zzq) {
                try {
                    InterfaceC0438p interfaceC0438p = this.zzr;
                    if (interfaceC0438p != null) {
                        ((E) interfaceC0438p).a(new L(this, this.zzd.get()), c0432j);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } finally {
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            triggerConnectionSuspended(3);
        } catch (RemoteException e2) {
            e = e2;
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
                I.h(iInterface, "Client is connected but service is null");
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    public IBinder getServiceBrokerBinder() {
        synchronized (this.zzq) {
            try {
                InterfaceC0438p interfaceC0438p = this.zzr;
                if (interfaceC0438p == null) {
                    return null;
                }
                return ((E) interfaceC0438p).asBinder();
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

    public C0431i getTelemetryConfiguration() {
        P p3 = this.zzE;
        if (p3 == null) {
            return null;
        }
        return p3.f5212d;
    }

    public boolean getUseDynamicLookup() {
        return getMinApkVersion() >= 211700000;
    }

    public boolean hasConnectionInfo() {
        return this.zzE != null;
    }

    public boolean isConnected() {
        boolean z6;
        synchronized (this.zzp) {
            z6 = this.zzv == 4;
        }
        return z6;
    }

    public boolean isConnecting() {
        boolean z6;
        synchronized (this.zzp) {
            int i = this.zzv;
            z6 = true;
            if (i != 2 && i != 3) {
                z6 = false;
            }
        }
        return z6;
    }

    public void onConnectedLocked(IInterface iInterface) {
        this.zzh = System.currentTimeMillis();
    }

    public void onConnectionFailed(C1200b c1200b) {
        this.zzi = c1200b.f10274b;
        this.zzj = System.currentTimeMillis();
    }

    public void onConnectionSuspended(int i) {
        this.zzf = i;
        this.zzg = System.currentTimeMillis();
    }

    public void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i6) {
        this.zzb.sendMessage(this.zzb.obtainMessage(1, i6, -1, new N(this, i, iBinder, bundle)));
    }

    public void onUserSignOut(InterfaceC0427e interfaceC0427e) {
        Z.B b3 = (Z.B) interfaceC0427e;
        ((com.google.android.gms.common.api.internal.E) b3.f3700b).f5090o.f5163n.post(new A.b(b3, 18));
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

    public void triggerConnectionSuspended(int i) {
        this.zzb.sendMessage(this.zzb.obtainMessage(6, this.zzd.get(), i));
    }

    public void triggerNotAvailable(InterfaceC0426d interfaceC0426d, int i, PendingIntent pendingIntent) {
        I.h(interfaceC0426d, "Connection progress callbacks cannot be null.");
        this.zzc = interfaceC0426d;
        this.zzb.sendMessage(this.zzb.obtainMessage(3, this.zzd.get(), i, pendingIntent));
    }

    public boolean usesClientTelemetry() {
        return false;
    }

    public final String zze() {
        String str = this.zzz;
        return str == null ? this.zzl.getClass().getName() : str;
    }

    public final void zzl(int i, Bundle bundle, int i6) {
        this.zzb.sendMessage(this.zzb.obtainMessage(7, i6, -1, new O(this, i, bundle)));
    }

    public void disconnect(String str) {
        this.zzk = str;
        disconnect();
    }

    public void setAttributionSourceWrapper(D1.a aVar) {
    }
}
