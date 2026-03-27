package Q1;

import H.i;
import S1.InterfaceC0876h;
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
import androidx.fragment.app.AbstractActivityC1143u;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.AbstractC1294n;
import com.google.android.gms.common.internal.AbstractC1304y;

/* JADX INFO: renamed from: Q1.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0794f extends C0795g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6692c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f6690e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0794f f6691f = new C0794f();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f6689d = C0795g.f6693a;

    public static C0794f n() {
        return f6691f;
    }

    @Override // Q1.C0795g
    public Intent b(Context context, int i8, String str) {
        return super.b(context, i8, str);
    }

    @Override // Q1.C0795g
    public PendingIntent c(Context context, int i8, int i9) {
        return super.c(context, i8, i9);
    }

    @Override // Q1.C0795g
    public final String e(int i8) {
        return super.e(i8);
    }

    @Override // Q1.C0795g
    public int g(Context context) {
        return super.g(context);
    }

    @Override // Q1.C0795g
    public int h(Context context, int i8) {
        return super.h(context, i8);
    }

    @Override // Q1.C0795g
    public final boolean j(int i8) {
        return super.j(i8);
    }

    public Dialog l(Activity activity, int i8, int i9, DialogInterface.OnCancelListener onCancelListener) {
        return q(activity, i8, com.google.android.gms.common.internal.B.b(activity, b(activity, i8, "d"), i9), onCancelListener, null);
    }

    public PendingIntent m(Context context, C0790b c0790b) {
        return c0790b.f() ? c0790b.e() : c(context, c0790b.a(), 0);
    }

    public boolean o(Activity activity, int i8, int i9, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogL = l(activity, i8, i9, onCancelListener);
        if (dialogL == null) {
            return false;
        }
        t(activity, dialogL, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void p(Context context, int i8) {
        u(context, i8, null, d(context, i8, 0, "n"));
    }

    public final Dialog q(Context context, int i8, com.google.android.gms.common.internal.B b8, DialogInterface.OnCancelListener onCancelListener, DialogInterface.OnClickListener onClickListener) {
        if (i8 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(AbstractC1304y.c(context, i8));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String strB = AbstractC1304y.b(context, i8);
        DialogInterface.OnClickListener onClickListener2 = b8;
        if (strB != null) {
            if (b8 == null) {
                onClickListener2 = onClickListener;
            }
            builder.setPositiveButton(strB, onClickListener2);
        }
        String strF = AbstractC1304y.f(context, i8);
        if (strF != null) {
            builder.setTitle(strF);
        }
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", Integer.valueOf(i8)), new IllegalArgumentException());
        return builder.create();
    }

    public final Dialog r(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(AbstractC1304y.c(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog alertDialogCreate = builder.create();
        t(activity, alertDialogCreate, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return alertDialogCreate;
    }

    public final S1.F s(Context context, S1.E e8) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        S1.F f8 = new S1.F(e8);
        c2.f.o(context, f8, intentFilter);
        f8.a(context);
        if (i(context, "com.google.android.gms")) {
            return f8;
        }
        e8.a();
        f8.b();
        return null;
    }

    public final void t(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof AbstractActivityC1143u) {
                n.y(dialog, onCancelListener).x(((AbstractActivityC1143u) activity).getSupportFragmentManager(), str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        DialogFragmentC0791c.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    public final void u(Context context, int i8, String str, PendingIntent pendingIntent) {
        int i9;
        String str2;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(i8), null), new IllegalArgumentException());
        if (i8 == 18) {
            v(context);
            return;
        }
        if (pendingIntent == null) {
            if (i8 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strE = AbstractC1304y.e(context, i8);
        String strD = AbstractC1304y.d(context, i8);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) AbstractC1294n.j(context.getSystemService("notification"));
        i.e eVarJ = new i.e(context).y(true).g(true).o(strE).J(new i.c().n(strD));
        if (W1.i.c(context)) {
            AbstractC1294n.m(W1.l.b());
            eVarJ.H(context.getApplicationInfo().icon).C(2);
            if (W1.i.d(context)) {
                eVarJ.a(O1.a.f5897a, resources.getString(O1.b.f5912o), pendingIntent);
            } else {
                eVarJ.m(pendingIntent);
            }
        } else {
            eVarJ.H(R.drawable.stat_sys_warning).L(resources.getString(O1.b.f5905h)).Q(System.currentTimeMillis()).m(pendingIntent).n(strD);
        }
        if (W1.l.e()) {
            AbstractC1294n.m(W1.l.e());
            synchronized (f6690e) {
                str2 = this.f6692c;
            }
            if (str2 == null) {
                str2 = "com.google.android.gms.availability";
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                String string = context.getResources().getString(O1.b.f5904g);
                if (notificationChannel == null) {
                    notificationManager.createNotificationChannel(com.dexterous.flutterlocalnotifications.C.a("com.google.android.gms.availability", string, 4));
                } else if (!string.contentEquals(notificationChannel.getName())) {
                    notificationChannel.setName(string);
                    notificationManager.createNotificationChannel(notificationChannel);
                }
            }
            eVarJ.i(str2);
        }
        Notification notificationD = eVarJ.d();
        if (i8 == 1 || i8 == 2 || i8 == 3) {
            AbstractC0799k.f6699b.set(false);
            i9 = 10436;
        } else {
            i9 = 39789;
        }
        notificationManager.notify(i9, notificationD);
    }

    public final void v(Context context) {
        new p(this, context).sendEmptyMessageDelayed(1, 120000L);
    }

    public final boolean w(Activity activity, InterfaceC0876h interfaceC0876h, int i8, int i9, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogQ = q(activity, i8, com.google.android.gms.common.internal.B.c(interfaceC0876h, b(activity, i8, "d"), 2), onCancelListener, null);
        if (dialogQ == null) {
            return false;
        }
        t(activity, dialogQ, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public final boolean x(Context context, C0790b c0790b, int i8) {
        PendingIntent pendingIntentM;
        if (Y1.c.a(context) || (pendingIntentM = m(context, c0790b)) == null) {
            return false;
        }
        u(context, c0790b.a(), null, PendingIntent.getActivity(context, 0, GoogleApiActivity.a(context, pendingIntentM, i8, true), c2.g.f13344a | 134217728));
        return true;
    }
}
