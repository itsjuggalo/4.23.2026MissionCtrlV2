package O1;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.internal.cloudmessaging.zza;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.revenuecat.purchases.common.Constants;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: O1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0641c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f4067h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static PendingIntent f4068i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Executor f4069j = new Executor() { // from class: O1.G
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            runnable.run();
        }
    };

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f4070k = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f4072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final E f4073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f4074d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Messenger f4076f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public l f4077g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u.g f4071a = new u.g();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Messenger f4075e = new Messenger(new i(this, Looper.getMainLooper()));

    public C0641c(Context context) {
        this.f4072b = context;
        this.f4073c = new E(context);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f4074d = scheduledThreadPoolExecutor;
    }

    public static /* synthetic */ Task e(Bundle bundle) {
        return m(bundle) ? Tasks.forResult(null) : Tasks.forResult(bundle);
    }

    public static /* bridge */ /* synthetic */ void g(C0641c c0641c, Message message) {
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new k());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof l) {
                        c0641c.f4077g = (l) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        c0641c.f4076f = (Messenger) parcelableExtra;
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
                    Matcher matcher = f4070k.matcher(stringExtra);
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
                        c0641c.l(strGroup, extras);
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
                if (!stringExtra2.startsWith(com.amazon.a.a.o.b.f.f9991c)) {
                    synchronized (c0641c.f4071a) {
                        for (int i7 = 0; i7 < c0641c.f4071a.size(); i7++) {
                            try {
                                c0641c.l((String) c0641c.f4071a.j(i7), intent2.getExtras());
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
                c0641c.l(str, intent2.putExtra("error", strSubstring).getExtras());
                return;
            }
        }
        Log.w("Rpc", "Dropping invalid message");
    }

    public static synchronized String j() {
        int i7;
        i7 = f4067h;
        f4067h = i7 + 1;
        return Integer.toString(i7);
    }

    public static synchronized void k(Context context, Intent intent) {
        try {
            if (f4068i == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                f4068i = PendingIntent.getBroadcast(context, 0, intent2, zza.zza);
            }
            intent.putExtra("app", f4068i);
        } catch (Throwable th) {
            throw th;
        }
    }

    public static boolean m(Bundle bundle) {
        return bundle != null && bundle.containsKey("google.messenger");
    }

    public Task a() {
        return this.f4073c.a() >= 241100000 ? D.b(this.f4072b).d(5, Bundle.EMPTY).continueWith(f4069j, new Continuation() { // from class: O1.f
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Intent intent = (Intent) ((Bundle) task.getResult()).getParcelable("notification_data");
                if (intent != null) {
                    return new C0639a(intent);
                }
                return null;
            }
        }) : Tasks.forException(new IOException("SERVICE_NOT_AVAILABLE"));
    }

    public Task b(C0639a c0639a) {
        if (this.f4073c.a() < 233700000) {
            return Tasks.forException(new IOException("SERVICE_NOT_AVAILABLE"));
        }
        Bundle bundle = new Bundle();
        bundle.putString("google.message_id", c0639a.B());
        Integer numC = c0639a.C();
        if (numC != null) {
            bundle.putInt("google.product_id", numC.intValue());
        }
        return D.b(this.f4072b).c(3, bundle);
    }

    public Task c(final Bundle bundle) {
        return this.f4073c.a() < 12000000 ? this.f4073c.b() != 0 ? i(bundle).continueWithTask(f4069j, new Continuation() { // from class: O1.H
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.f4062a.f(bundle, task);
            }
        }) : Tasks.forException(new IOException("MISSING_INSTANCEID_SERVICE")) : D.b(this.f4072b).d(1, bundle).continueWith(f4069j, new Continuation() { // from class: O1.e
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) throws IOException {
                if (task.isSuccessful()) {
                    return (Bundle) task.getResult();
                }
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Error making request: ".concat(String.valueOf(task.getException())));
                }
                throw new IOException("SERVICE_NOT_AVAILABLE", task.getException());
            }
        });
    }

    public Task d(boolean z7) {
        if (this.f4073c.a() < 241100000) {
            return Tasks.forException(new IOException("SERVICE_NOT_AVAILABLE"));
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("proxy_retention", z7);
        return D.b(this.f4072b).c(4, bundle);
    }

    public final /* synthetic */ Task f(Bundle bundle, Task task) {
        return (task.isSuccessful() && m((Bundle) task.getResult())) ? i(bundle).onSuccessTask(f4069j, new SuccessContinuation() { // from class: O1.F
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return C0641c.e((Bundle) obj);
            }
        }) : task;
    }

    public final /* synthetic */ void h(String str, ScheduledFuture scheduledFuture, Task task) {
        synchronized (this.f4071a) {
            this.f4071a.remove(str);
        }
        scheduledFuture.cancel(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.tasks.Task i(android.os.Bundle r8) {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: O1.C0641c.i(android.os.Bundle):com.google.android.gms.tasks.Task");
    }

    public final void l(String str, Bundle bundle) {
        synchronized (this.f4071a) {
            try {
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.f4071a.remove(str);
                if (taskCompletionSource != null) {
                    taskCompletionSource.setResult(bundle);
                    return;
                }
                Log.w("Rpc", "Missing callback for " + str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
