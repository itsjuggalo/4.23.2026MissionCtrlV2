package P1;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.util.Log;
import com.revenuecat.purchases.common.Constants;
import d2.AbstractC1619a;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l2.AbstractC2328l;
import l2.AbstractC2331o;
import l2.C2329m;
import l2.InterfaceC2319c;
import l2.InterfaceC2327k;

/* JADX INFO: renamed from: P1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0759c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f6301h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static PendingIntent f6302i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Executor f6303j = new Executor() { // from class: P1.G
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            runnable.run();
        }
    };

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f6304k = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f6306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final E f6307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f6308d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Messenger f6310f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public l f6311g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w.i f6305a = new w.i();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Messenger f6309e = new Messenger(new i(this, Looper.getMainLooper()));

    public C0759c(Context context) {
        this.f6306b = context;
        this.f6307c = new E(context);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f6308d = scheduledThreadPoolExecutor;
    }

    public static /* synthetic */ AbstractC2328l e(Bundle bundle) {
        return m(bundle) ? AbstractC2331o.e(null) : AbstractC2331o.e(bundle);
    }

    public static /* bridge */ /* synthetic */ void g(C0759c c0759c, Message message) {
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new k());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof l) {
                        c0759c.f6311g = (l) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        c0759c.f6310f = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if (!Objects.equals(action, "com.google.android.c2dm.intent.REGISTRATION")) {
                    if (Log.isLoggable("Rpc", 3)) {
                        Log.d("Rpc", "Unexpected response action: ".concat(String.valueOf(action)));
                        return;
                    }
                    return;
                }
                String stringExtra = intent2.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent2.getStringExtra("unregistered");
                }
                if (stringExtra != null) {
                    Matcher matcher = f6304k.matcher(stringExtra);
                    if (!matcher.matches()) {
                        if (Log.isLoggable("Rpc", 3)) {
                            Log.d("Rpc", "Unexpected response string: ".concat(stringExtra));
                            return;
                        }
                        return;
                    }
                    String strGroup = matcher.group(1);
                    String strGroup2 = matcher.group(2);
                    if (strGroup != null) {
                        Bundle extras = intent2.getExtras();
                        extras.putString("registration_id", strGroup2);
                        c0759c.l(strGroup, extras);
                        return;
                    }
                    return;
                }
                String stringExtra2 = intent2.getStringExtra("error");
                if (stringExtra2 == null) {
                    Log.w("Rpc", "Unexpected response, no error or registration id ".concat(String.valueOf(intent2.getExtras())));
                    return;
                }
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Received InstanceID error ".concat(stringExtra2));
                }
                if (!stringExtra2.startsWith(com.amazon.a.a.o.b.f.f14102c)) {
                    synchronized (c0759c.f6305a) {
                        for (int i8 = 0; i8 < c0759c.f6305a.size(); i8++) {
                            try {
                                c0759c.l((String) c0759c.f6305a.f(i8), intent2.getExtras());
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    return;
                }
                String[] strArrSplit = stringExtra2.split("\\|");
                if (strArrSplit.length <= 2 || !Objects.equals(strArrSplit[1], "ID")) {
                    Log.w("Rpc", "Unexpected structured response ".concat(stringExtra2));
                    return;
                }
                String str = strArrSplit[2];
                String strSubstring = strArrSplit[3];
                if (strSubstring.startsWith(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR)) {
                    strSubstring = strSubstring.substring(1);
                }
                c0759c.l(str, intent2.putExtra("error", strSubstring).getExtras());
                return;
            }
        }
        Log.w("Rpc", "Dropping invalid message");
    }

    public static synchronized String j() {
        int i8;
        i8 = f6301h;
        f6301h = i8 + 1;
        return Integer.toString(i8);
    }

    public static synchronized void k(Context context, Intent intent) {
        try {
            if (f6302i == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                f6302i = PendingIntent.getBroadcast(context, 0, intent2, AbstractC1619a.f16839a);
            }
            intent.putExtra("app", f6302i);
        } catch (Throwable th) {
            throw th;
        }
    }

    public static boolean m(Bundle bundle) {
        return bundle != null && bundle.containsKey("google.messenger");
    }

    public AbstractC2328l a() {
        return this.f6307c.a() >= 241100000 ? D.b(this.f6306b).d(5, Bundle.EMPTY).h(f6303j, new InterfaceC2319c() { // from class: P1.f
            @Override // l2.InterfaceC2319c
            public final Object a(AbstractC2328l abstractC2328l) {
                Intent intent = (Intent) ((Bundle) abstractC2328l.k()).getParcelable("notification_data");
                if (intent != null) {
                    return new C0757a(intent);
                }
                return null;
            }
        }) : AbstractC2331o.d(new IOException("SERVICE_NOT_AVAILABLE"));
    }

    public AbstractC2328l b(C0757a c0757a) {
        if (this.f6307c.a() < 233700000) {
            return AbstractC2331o.d(new IOException("SERVICE_NOT_AVAILABLE"));
        }
        Bundle bundle = new Bundle();
        bundle.putString("google.message_id", c0757a.d());
        Integer numE = c0757a.e();
        if (numE != null) {
            bundle.putInt("google.product_id", numE.intValue());
        }
        return D.b(this.f6306b).c(3, bundle);
    }

    public AbstractC2328l c(final Bundle bundle) {
        return this.f6307c.a() < 12000000 ? this.f6307c.b() != 0 ? i(bundle).i(f6303j, new InterfaceC2319c() { // from class: P1.H
            @Override // l2.InterfaceC2319c
            public final Object a(AbstractC2328l abstractC2328l) {
                return this.f6296a.f(bundle, abstractC2328l);
            }
        }) : AbstractC2331o.d(new IOException("MISSING_INSTANCEID_SERVICE")) : D.b(this.f6306b).d(1, bundle).h(f6303j, new InterfaceC2319c() { // from class: P1.e
            @Override // l2.InterfaceC2319c
            public final Object a(AbstractC2328l abstractC2328l) throws IOException {
                if (abstractC2328l.o()) {
                    return (Bundle) abstractC2328l.k();
                }
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Error making request: ".concat(String.valueOf(abstractC2328l.j())));
                }
                throw new IOException("SERVICE_NOT_AVAILABLE", abstractC2328l.j());
            }
        });
    }

    public AbstractC2328l d(boolean z7) {
        if (this.f6307c.a() < 241100000) {
            return AbstractC2331o.d(new IOException("SERVICE_NOT_AVAILABLE"));
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("proxy_retention", z7);
        return D.b(this.f6306b).c(4, bundle);
    }

    public final /* synthetic */ AbstractC2328l f(Bundle bundle, AbstractC2328l abstractC2328l) {
        return (abstractC2328l.o() && m((Bundle) abstractC2328l.k())) ? i(bundle).p(f6303j, new InterfaceC2327k() { // from class: P1.F
            @Override // l2.InterfaceC2327k
            public final AbstractC2328l a(Object obj) {
                return C0759c.e((Bundle) obj);
            }
        }) : abstractC2328l;
    }

    public final /* synthetic */ void h(String str, ScheduledFuture scheduledFuture, AbstractC2328l abstractC2328l) {
        synchronized (this.f6305a) {
            this.f6305a.remove(str);
        }
        scheduledFuture.cancel(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final l2.AbstractC2328l i(android.os.Bundle r8) {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: P1.C0759c.i(android.os.Bundle):l2.l");
    }

    public final void l(String str, Bundle bundle) {
        synchronized (this.f6305a) {
            try {
                C2329m c2329m = (C2329m) this.f6305a.remove(str);
                if (c2329m != null) {
                    c2329m.c(bundle);
                    return;
                }
                Log.w("Rpc", "Missing callback for " + str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
