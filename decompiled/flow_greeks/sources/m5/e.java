package m5;

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
import com.google.android.gms.internal.base.zak;
import h0.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f15905c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f15903e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f15904f = new e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f15902d = f.f15915a;

    public static e n() {
        return f15904f;
    }

    @Override // m5.f
    public Intent b(Context context, int i10, String str) {
        return super.b(context, i10, str);
    }

    @Override // m5.f
    public PendingIntent c(Context context, int i10, int i11) {
        return super.c(context, i10, i11);
    }

    @Override // m5.f
    public final String e(int i10) {
        return super.e(i10);
    }

    @Override // m5.f
    public int g(Context context) {
        return super.g(context);
    }

    @Override // m5.f
    public int h(Context context, int i10) {
        return super.h(context, i10);
    }

    @Override // m5.f
    public final boolean j(int i10) {
        return super.j(i10);
    }

    public Dialog l(Activity activity, int i10, int i11, DialogInterface.OnCancelListener onCancelListener) {
        return q(activity, i10, com.google.android.gms.common.internal.f0.b(activity, b(activity, i10, "d"), i11), onCancelListener, null);
    }

    public PendingIntent m(Context context, b bVar) {
        return bVar.U() ? bVar.T() : c(context, bVar.R(), 0);
    }

    public boolean o(Activity activity, int i10, int i11, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogL = l(activity, i10, i11, onCancelListener);
        if (dialogL == null) {
            return false;
        }
        w(activity, dialogL, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void p(Context context, int i10) {
        s(context, i10, null, d(context, i10, 0, "n"));
    }

    public final Dialog q(Context context, int i10, com.google.android.gms.common.internal.f0 f0Var, DialogInterface.OnCancelListener onCancelListener, DialogInterface.OnClickListener onClickListener) {
        if (i10 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(com.google.android.gms.common.internal.c0.c(context, i10));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String strE = com.google.android.gms.common.internal.c0.e(context, i10);
        DialogInterface.OnClickListener onClickListener2 = f0Var;
        if (strE != null) {
            if (f0Var == null) {
                onClickListener2 = onClickListener;
            }
            builder.setPositiveButton(strE, onClickListener2);
        }
        String strA = com.google.android.gms.common.internal.c0.a(context, i10);
        if (strA != null) {
            builder.setTitle(strA);
        }
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", Integer.valueOf(i10)), new IllegalArgumentException());
        return builder.create();
    }

    public final boolean r(Activity activity, com.google.android.gms.common.api.internal.k kVar, int i10, int i11, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogQ = q(activity, i10, com.google.android.gms.common.internal.f0.c(kVar, b(activity, i10, "d"), 2), onCancelListener, null);
        if (dialogQ == null) {
            return false;
        }
        w(activity, dialogQ, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public final void s(Context context, int i10, String str, PendingIntent pendingIntent) {
        int i11;
        String str2;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(i10), null), new IllegalArgumentException());
        if (i10 == 18) {
            x(context);
            return;
        }
        if (pendingIntent == null) {
            if (i10 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strB = com.google.android.gms.common.internal.c0.b(context, i10);
        String strD = com.google.android.gms.common.internal.c0.d(context, i10);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) com.google.android.gms.common.internal.s.k(context.getSystemService("notification"));
        i.e eVarJ = new i.e(context).y(true).g(true).o(strB).J(new i.c().n(strD));
        boolean zC = t5.i.c(context);
        int i12 = R.drawable.stat_sys_warning;
        if (zC) {
            com.google.android.gms.common.internal.s.n(t5.n.b());
            int i13 = context.getApplicationInfo().icon;
            if (i13 != 0) {
                i12 = i13;
            }
            eVarJ.H(i12).C(2);
            if (t5.i.d(context)) {
                eVarJ.a(k5.a.f14716a, resources.getString(k5.b.f14731o), pendingIntent);
            } else {
                eVarJ.m(pendingIntent);
            }
        } else {
            eVarJ.H(R.drawable.stat_sys_warning).L(resources.getString(k5.b.f14724h)).Q(System.currentTimeMillis()).m(pendingIntent).n(strD);
        }
        if (t5.n.e()) {
            com.google.android.gms.common.internal.s.n(t5.n.e());
            synchronized (f15903e) {
                str2 = this.f15905c;
            }
            if (str2 == null) {
                str2 = "com.google.android.gms.availability";
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                String string = context.getResources().getString(k5.b.f14723g);
                if (notificationChannel == null) {
                    notificationManager.createNotificationChannel(com.dexterous.flutterlocalnotifications.d.a("com.google.android.gms.availability", string, 4));
                } else if (!string.contentEquals(notificationChannel.getName())) {
                    notificationChannel.setName(string);
                    notificationManager.createNotificationChannel(notificationChannel);
                }
            }
            eVarJ.i(str2);
        }
        Notification notificationD = eVarJ.d();
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            j.f15933b.set(false);
            i11 = 10436;
        } else {
            i11 = 39789;
        }
        notificationManager.notify(i11, notificationD);
    }

    public final boolean t(Context context, b bVar, int i10) {
        PendingIntent pendingIntentM;
        if (v5.b.a(context) || (pendingIntentM = m(context, bVar)) == null) {
            return false;
        }
        s(context, bVar.R(), null, PendingIntent.getActivity(context, 0, GoogleApiActivity.a(context, pendingIntentM, i10, true), zak.zaa | 134217728));
        return true;
    }

    public final Dialog u(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(com.google.android.gms.common.internal.c0.c(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog alertDialogCreate = builder.create();
        w(activity, alertDialogCreate, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return alertDialogCreate;
    }

    public final com.google.android.gms.common.api.internal.p0 v(Context context, com.google.android.gms.common.api.internal.o0 o0Var) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        com.google.android.gms.common.api.internal.p0 p0Var = new com.google.android.gms.common.api.internal.p0(o0Var);
        i0.a.l(context, p0Var, intentFilter, 2);
        p0Var.a(context);
        if (i(context, "com.google.android.gms")) {
            return p0Var;
        }
        o0Var.a();
        p0Var.b();
        return null;
    }

    public final void w(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof androidx.fragment.app.u) {
                n.x(dialog, onCancelListener).w(((androidx.fragment.app.u) activity).getSupportFragmentManager(), str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        c.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    public final void x(Context context) {
        new p(this, context).sendEmptyMessageDelayed(1, 120000L);
    }
}
