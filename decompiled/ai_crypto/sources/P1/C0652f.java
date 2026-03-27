package P1;

import F.k;
import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.InterfaceC1174k;
import com.google.android.gms.common.api.internal.T;
import com.google.android.gms.common.api.internal.U;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.internal.base.zao;
import com.google.android.gms.internal.base.zap;
import m0.AbstractActivityC2221u;

/* JADX INFO: renamed from: P1.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0652f extends C0653g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4298c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f4296e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0652f f4297f = new C0652f();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f4295d = C0653g.f4299a;

    public static C0652f n() {
        return f4297f;
    }

    @Override // P1.C0653g
    public Intent b(Context context, int i7, String str) {
        return super.b(context, i7, str);
    }

    @Override // P1.C0653g
    public PendingIntent c(Context context, int i7, int i8) {
        return super.c(context, i7, i8);
    }

    @Override // P1.C0653g
    public final String e(int i7) {
        return super.e(i7);
    }

    @Override // P1.C0653g
    public int g(Context context) {
        return super.g(context);
    }

    @Override // P1.C0653g
    public int h(Context context, int i7) {
        return super.h(context, i7);
    }

    @Override // P1.C0653g
    public final boolean j(int i7) {
        return super.j(i7);
    }

    public Dialog l(Activity activity, int i7, int i8, DialogInterface.OnCancelListener onCancelListener) {
        return q(activity, i7, com.google.android.gms.common.internal.H.b(activity, b(activity, i7, "d"), i8), onCancelListener, null);
    }

    public PendingIntent m(Context context, C0648b c0648b) {
        return c0648b.D() ? c0648b.C() : c(context, c0648b.A(), 0);
    }

    public boolean o(Activity activity, int i7, int i8, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogL = l(activity, i7, i8, onCancelListener);
        if (dialogL == null) {
            return false;
        }
        t(activity, dialogL, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void p(Context context, int i7) {
        u(context, i7, null, d(context, i7, 0, "n"));
    }

    public final Dialog q(Context context, int i7, com.google.android.gms.common.internal.H h7, DialogInterface.OnCancelListener onCancelListener, DialogInterface.OnClickListener onClickListener) {
        if (i7 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(com.google.android.gms.common.internal.E.c(context, i7));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String strB = com.google.android.gms.common.internal.E.b(context, i7);
        DialogInterface.OnClickListener onClickListener2 = h7;
        if (strB != null) {
            if (h7 == null) {
                onClickListener2 = onClickListener;
            }
            builder.setPositiveButton(strB, onClickListener2);
        }
        String strF = com.google.android.gms.common.internal.E.f(context, i7);
        if (strF != null) {
            builder.setTitle(strF);
        }
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", Integer.valueOf(i7)), new IllegalArgumentException());
        return builder.create();
    }

    public final Dialog r(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(com.google.android.gms.common.internal.E.c(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog alertDialogCreate = builder.create();
        t(activity, alertDialogCreate, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return alertDialogCreate;
    }

    public final U s(Context context, T t7) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        U u7 = new U(t7);
        zao.zaa(context, u7, intentFilter);
        u7.a(context);
        if (i(context, "com.google.android.gms")) {
            return u7;
        }
        t7.a();
        u7.b();
        return null;
    }

    public final void t(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof AbstractActivityC2221u) {
                n.S1(dialog, onCancelListener).R1(((AbstractActivityC2221u) activity).a0(), str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        DialogFragmentC0649c.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    public final void u(Context context, int i7, String str, PendingIntent pendingIntent) {
        int i8;
        String str2;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(i7), null), new IllegalArgumentException());
        if (i7 == 18) {
            v(context);
            return;
        }
        if (pendingIntent == null) {
            if (i7 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strE = com.google.android.gms.common.internal.E.e(context, i7);
        String strD = com.google.android.gms.common.internal.E.d(context, i7);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) AbstractC1207s.k(context.getSystemService("notification"));
        k.e eVarI = new k.e(context).x(true).f(true).n(strE).I(new k.c().n(strD));
        if (W1.h.c(context)) {
            AbstractC1207s.n(W1.m.b());
            eVarI.G(context.getApplicationInfo().icon).B(2);
            if (W1.h.d(context)) {
                eVarI.a(N1.a.f3945a, resources.getString(N1.b.f3960o), pendingIntent);
            } else {
                eVarI.l(pendingIntent);
            }
        } else {
            eVarI.G(R.drawable.stat_sys_warning).K(resources.getString(N1.b.f3953h)).P(System.currentTimeMillis()).l(pendingIntent).m(strD);
        }
        if (W1.m.e()) {
            AbstractC1207s.n(W1.m.e());
            synchronized (f4296e) {
                str2 = this.f4298c;
            }
            if (str2 == null) {
                str2 = "com.google.android.gms.availability";
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                String string = context.getResources().getString(N1.b.f3952g);
                if (notificationChannel == null) {
                    notificationManager.createNotificationChannel(com.dexterous.flutterlocalnotifications.B.a("com.google.android.gms.availability", string, 4));
                } else if (!string.contentEquals(notificationChannel.getName())) {
                    notificationChannel.setName(string);
                    notificationManager.createNotificationChannel(notificationChannel);
                }
            }
            eVarI.h(str2);
        }
        Notification notificationC = eVarI.c();
        if (i7 == 1 || i7 == 2 || i7 == 3) {
            AbstractC0657k.f4305b.set(false);
            i8 = 10436;
        } else {
            i8 = 39789;
        }
        notificationManager.notify(i8, notificationC);
    }

    public final void v(Context context) {
        new p(this, context).sendEmptyMessageDelayed(1, 120000L);
    }

    public final boolean w(Activity activity, InterfaceC1174k interfaceC1174k, int i7, int i8, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogQ = q(activity, i7, com.google.android.gms.common.internal.H.c(interfaceC1174k, b(activity, i7, "d"), 2), onCancelListener, null);
        if (dialogQ == null) {
            return false;
        }
        t(activity, dialogQ, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public final boolean x(Context context, C0648b c0648b, int i7) {
        PendingIntent pendingIntentM;
        if (Y1.c.a(context) || (pendingIntentM = m(context, c0648b)) == null) {
            return false;
        }
        u(context, c0648b.A(), null, PendingIntent.getActivity(context, 0, GoogleApiActivity.a(context, pendingIntentM, i7, true), zap.zaa | 134217728));
        return true;
    }
}
