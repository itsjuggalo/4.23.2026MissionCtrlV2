package n1;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.TokenData;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException;
import com.google.android.gms.common.internal.AbstractC0931i;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.auth.zzbw;
import com.google.android.gms.internal.auth.zzby;
import com.google.android.gms.internal.auth.zzdc;
import com.google.android.gms.internal.auth.zze;
import com.google.android.gms.internal.auth.zzg;
import com.google.android.gms.internal.auth.zzh;
import com.google.android.gms.internal.auth.zzht;
import com.google.android.gms.internal.auth.zzhw;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeoutException;
import z1.AbstractC1993k;
import z1.C1988f;
import z1.C1990h;
import z1.C1991i;
import z1.ServiceConnectionC1983a;

/* JADX INFO: renamed from: n1.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1629o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f13625a = {"com.google", "com.google.work", "cn.google"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f13626b = "androidPackageName";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ComponentName f13627c = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C1.a f13628d = AbstractC1624j.a("GoogleAuthUtil");

    public static void a(Context context, String str) throws IOException, C1618d {
        g(context, str, 0L);
    }

    public static String b(Context context, Account account, String str) {
        return c(context, account, str, new Bundle());
    }

    public static String c(Context context, Account account, String str, Bundle bundle) {
        p(account);
        return d(context, account, str, bundle, 0L, null).zza();
    }

    public static TokenData d(final Context context, final Account account, final String str, Bundle bundle, long j4, Executor executor) throws IOException, C1618d {
        AbstractC0940s.j("Calling this from your main thread can lead to deadlock");
        AbstractC0940s.f(str, "Scope cannot be empty or null.");
        p(account);
        l(context, 8400000);
        final Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        n(context, bundle2);
        zzdc.zzd(context);
        if (zzhw.zze() && q(context)) {
            try {
                Bundle bundle3 = (Bundle) j(zzh.zza(context).zzc(account, str, bundle2), "token retrieval");
                k(bundle3);
                return h(context, "getTokenWithDetails", bundle3);
            } catch (com.google.android.gms.common.api.b e4) {
                m(e4, "token retrieval");
            }
        }
        return (TokenData) i(context, f13627c, new InterfaceC1628n() { // from class: n1.l
            @Override // n1.InterfaceC1628n
            public final Object a(IBinder iBinder) {
                return AbstractC1629o.e(account, str, bundle2, context, iBinder);
            }
        }, 0L, null);
    }

    public static /* synthetic */ TokenData e(Account account, String str, Bundle bundle, Context context, IBinder iBinder) throws IOException {
        Bundle bundleZze = zze.zzb(iBinder).zze(account, str, bundle);
        if (bundleZze != null) {
            return h(context, "getTokenWithDetails", bundleZze);
        }
        throw new IOException("Service call returned null");
    }

    public static /* bridge */ /* synthetic */ Object f(Object obj) throws IOException {
        k(obj);
        return obj;
    }

    public static void g(Context context, String str, long j4) throws IOException, C1618d {
        AbstractC0940s.j("Calling this from your main thread can lead to deadlock");
        l(context, 8400000);
        Bundle bundle = new Bundle();
        n(context, bundle);
        zzdc.zzd(context);
        if (zzhw.zze() && q(context)) {
            zzg zzgVarZza = zzh.zza(context);
            zzbw zzbwVar = new zzbw();
            zzbwVar.zza(str);
            try {
                j(zzgVarZza.zza(zzbwVar), "clear token");
                return;
            } catch (com.google.android.gms.common.api.b e4) {
                m(e4, "clear token");
            }
        }
        i(context, f13627c, new C1627m(str, bundle), 0L, null);
    }

    public static TokenData h(Context context, String str, Bundle bundle) throws IOException, C1618d {
        TokenData tokenData;
        Parcelable.Creator<TokenData> creator = TokenData.CREATOR;
        ClassLoader classLoader = TokenData.class.getClassLoader();
        if (classLoader != null) {
            bundle.setClassLoader(classLoader);
        }
        Bundle bundle2 = bundle.getBundle("tokenDetails");
        if (bundle2 == null) {
            tokenData = null;
        } else {
            if (classLoader != null) {
                bundle2.setClassLoader(classLoader);
            }
            tokenData = (TokenData) bundle2.getParcelable("TokenData");
        }
        if (tokenData != null) {
            return tokenData;
        }
        o(context, "getTokenWithDetails", bundle.getString("Error"), (Intent) bundle.getParcelable("userRecoveryIntent"), (PendingIntent) bundle.getParcelable("userRecoveryPendingIntent"));
        throw new C1618d("Invalid state. Shouldn't happen");
    }

    public static Object i(Context context, ComponentName componentName, InterfaceC1628n interfaceC1628n, long j4, Executor executor) throws IOException {
        ServiceConnectionC1983a serviceConnectionC1983a = new ServiceConnectionC1983a();
        AbstractC0931i abstractC0931iB = AbstractC0931i.b(context);
        try {
            try {
                if (!abstractC0931iB.a(componentName, serviceConnectionC1983a, "GoogleAuthUtil", null)) {
                    throw new IOException("Could not bind to service.");
                }
                try {
                    return interfaceC1628n.a(serviceConnectionC1983a.a());
                } catch (RemoteException | InterruptedException | TimeoutException e4) {
                    Log.i("GoogleAuthUtil", "Error on service connection.", e4);
                    throw new IOException("Error on service connection.", e4);
                }
            } finally {
                abstractC0931iB.d(componentName, serviceConnectionC1983a, "GoogleAuthUtil");
            }
        } catch (SecurityException e5) {
            Log.w("GoogleAuthUtil", String.format("SecurityException while bind to auth service: %s", e5.getMessage()));
            throw new IOException("SecurityException while binding to Auth service.", e5);
        }
    }

    public static Object j(Task task, String str) throws IOException, com.google.android.gms.common.api.b {
        try {
            return Tasks.await(task);
        } catch (InterruptedException e4) {
            String str2 = String.format("Interrupted while waiting for the task of %s to finish.", str);
            f13628d.h(str2, new Object[0]);
            throw new IOException(str2, e4);
        } catch (CancellationException e5) {
            String str3 = String.format("Canceled while waiting for the task of %s to finish.", str);
            f13628d.h(str3, new Object[0]);
            throw new IOException(str3, e5);
        } catch (ExecutionException e6) {
            Throwable cause = e6.getCause();
            if (cause instanceof com.google.android.gms.common.api.b) {
                throw ((com.google.android.gms.common.api.b) cause);
            }
            String str4 = String.format("Unable to get a result for %s due to ExecutionException.", str);
            f13628d.h(str4, new Object[0]);
            throw new IOException(str4, e6);
        }
    }

    public static Object k(Object obj) throws IOException {
        if (obj != null) {
            return obj;
        }
        f13628d.h("Service call returned null.", new Object[0]);
        throw new IOException("Service unavailable.");
    }

    public static void l(Context context, int i4) throws C1618d {
        try {
            AbstractC1993k.a(context.getApplicationContext(), i4);
        } catch (GooglePlayServicesIncorrectManifestValueException | C1990h e4) {
            throw new C1618d(e4.getMessage(), e4);
        } catch (C1991i e5) {
            throw new C1620f(e5.b(), e5.getMessage(), e5.a());
        }
    }

    public static void m(com.google.android.gms.common.api.b bVar, String str) {
        f13628d.h("%s failed via GoogleAuthServiceClient, falling back to previous approach:\n%s", str, Log.getStackTraceString(bVar));
    }

    public static void n(Context context, Bundle bundle) {
        String str = context.getApplicationInfo().packageName;
        bundle.putString("clientPackageName", str);
        String str2 = f13626b;
        if (TextUtils.isEmpty(bundle.getString(str2))) {
            bundle.putString(str2, str);
        }
        bundle.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
    }

    public static void o(Context context, String str, String str2, Intent intent, PendingIntent pendingIntent) throws IOException, C1618d {
        zzby zzbyVarZza = zzby.zza(str2);
        C1.a aVar = f13628d;
        aVar.h(String.format("[GoogleAuthUtil] error status:%s with method:%s", zzbyVarZza, str), new Object[0]);
        if (!zzby.BAD_AUTHENTICATION.equals(zzbyVarZza) && !zzby.CAPTCHA.equals(zzbyVarZza) && !zzby.NEED_PERMISSION.equals(zzbyVarZza) && !zzby.NEED_REMOTE_CONSENT.equals(zzbyVarZza) && !zzby.NEEDS_BROWSER.equals(zzbyVarZza) && !zzby.USER_CANCEL.equals(zzbyVarZza) && !zzby.DEVICE_MANAGEMENT_REQUIRED.equals(zzbyVarZza) && !zzby.DM_INTERNAL_ERROR.equals(zzbyVarZza) && !zzby.DM_SYNC_DISABLED.equals(zzbyVarZza) && !zzby.DM_ADMIN_BLOCKED.equals(zzbyVarZza) && !zzby.DM_ADMIN_PENDING_APPROVAL.equals(zzbyVarZza) && !zzby.DM_STALE_SYNC_REQUIRED.equals(zzbyVarZza) && !zzby.DM_DEACTIVATED.equals(zzbyVarZza) && !zzby.DM_REQUIRED.equals(zzbyVarZza) && !zzby.THIRD_PARTY_DEVICE_MANAGEMENT_REQUIRED.equals(zzbyVarZza) && !zzby.DM_SCREENLOCK_REQUIRED.equals(zzbyVarZza)) {
            if (!zzby.NETWORK_ERROR.equals(zzbyVarZza) && !zzby.SERVICE_UNAVAILABLE.equals(zzbyVarZza) && !zzby.INTNERNAL_ERROR.equals(zzbyVarZza) && !zzby.AUTH_SECURITY_ERROR.equals(zzbyVarZza) && !zzby.ACCOUNT_NOT_PRESENT.equals(zzbyVarZza)) {
                throw new C1618d(str2);
            }
            throw new IOException(str2);
        }
        zzdc.zzd(context);
        if (!zzht.zzc()) {
            throw new UserRecoverableAuthException(str2, intent);
        }
        if (pendingIntent != null && intent != null) {
            throw UserRecoverableAuthException.b(str2, intent, pendingIntent);
        }
        if (C1988f.n().a(context) >= Integer.MAX_VALUE && pendingIntent == null) {
            aVar.c(String.format("Recovery PendingIntent is missing on current Gms version: %s for method: %s. It should always be present on or above Gms version %s. This indicates a bug in Gms implementation.", Integer.MAX_VALUE, str, Integer.MAX_VALUE), new Object[0]);
        }
        if (intent == null) {
            aVar.c(String.format("no recovery Intent found with status=%s for method=%s. This shouldn't happen", str2, str), new Object[0]);
        }
        throw new UserRecoverableAuthException(str2, intent);
    }

    public static void p(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        }
        if (TextUtils.isEmpty(account.name)) {
            throw new IllegalArgumentException("Account name cannot be empty!");
        }
        String[] strArr = f13625a;
        for (int i4 = 0; i4 < 3; i4++) {
            if (strArr[i4].equals(account.type)) {
                return;
            }
        }
        throw new IllegalArgumentException("Account type not supported");
    }

    public static boolean q(Context context) {
        if (C1988f.n().h(context, 17895000) != 0) {
            return false;
        }
        List listZzq = zzhw.zzb().zzq();
        String str = context.getApplicationInfo().packageName;
        Iterator it = listZzq.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).equals(str)) {
                return false;
            }
        }
        return true;
    }
}
