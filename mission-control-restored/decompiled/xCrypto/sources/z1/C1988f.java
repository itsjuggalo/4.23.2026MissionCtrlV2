package z1;

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
import androidx.fragment.app.AbstractActivityC0832u;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.InterfaceC0908l;
import com.google.android.gms.common.api.internal.W;
import com.google.android.gms.common.api.internal.X;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.base.zao;
import com.google.android.gms.internal.base.zap;
import w.k;
import x1.AbstractC1923a;
import x1.AbstractC1924b;

/* JADX INFO: renamed from: z1.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1988f extends C1989g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16095c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f16093e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C1988f f16094f = new C1988f();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f16092d = C1989g.f16096a;

    public static C1988f n() {
        return f16094f;
    }

    @Override // z1.C1989g
    public Intent b(Context context, int i4, String str) {
        return super.b(context, i4, str);
    }

    @Override // z1.C1989g
    public PendingIntent c(Context context, int i4, int i5) {
        return super.c(context, i4, i5);
    }

    @Override // z1.C1989g
    public final String e(int i4) {
        return super.e(i4);
    }

    @Override // z1.C1989g
    public int g(Context context) {
        return super.g(context);
    }

    @Override // z1.C1989g
    public int h(Context context, int i4) {
        return super.h(context, i4);
    }

    @Override // z1.C1989g
    public final boolean j(int i4) {
        return super.j(i4);
    }

    public Dialog l(Activity activity, int i4, int i5, DialogInterface.OnCancelListener onCancelListener) {
        return q(activity, i4, com.google.android.gms.common.internal.H.b(activity, b(activity, i4, "d"), i5), onCancelListener, null);
    }

    public PendingIntent m(Context context, C1984b c1984b) {
        return c1984b.m() ? c1984b.l() : c(context, c1984b.i(), 0);
    }

    public boolean o(Activity activity, int i4, int i5, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogL = l(activity, i4, i5, onCancelListener);
        if (dialogL == null) {
            return false;
        }
        t(activity, dialogL, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void p(Context context, int i4) {
        u(context, i4, null, d(context, i4, 0, "n"));
    }

    public final Dialog q(Context context, int i4, com.google.android.gms.common.internal.H h4, DialogInterface.OnCancelListener onCancelListener, DialogInterface.OnClickListener onClickListener) {
        if (i4 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(com.google.android.gms.common.internal.E.c(context, i4));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String strB = com.google.android.gms.common.internal.E.b(context, i4);
        DialogInterface.OnClickListener onClickListener2 = h4;
        if (strB != null) {
            if (h4 == null) {
                onClickListener2 = onClickListener;
            }
            builder.setPositiveButton(strB, onClickListener2);
        }
        String strF = com.google.android.gms.common.internal.E.f(context, i4);
        if (strF != null) {
            builder.setTitle(strF);
        }
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", Integer.valueOf(i4)), new IllegalArgumentException());
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

    public final X s(Context context, W w4) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        X x4 = new X(w4);
        zao.zaa(context, x4, intentFilter);
        x4.a(context);
        if (i(context, "com.google.android.gms")) {
            return x4;
        }
        w4.a();
        x4.b();
        return null;
    }

    public final void t(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof AbstractActivityC0832u) {
                C1996n.x(dialog, onCancelListener).w(((AbstractActivityC0832u) activity).getSupportFragmentManager(), str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        DialogFragmentC1985c.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    public final void u(Context context, int i4, String str, PendingIntent pendingIntent) {
        int i5;
        String str2;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(i4), null), new IllegalArgumentException());
        if (i4 == 18) {
            v(context);
            return;
        }
        if (pendingIntent == null) {
            if (i4 == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strE = com.google.android.gms.common.internal.E.e(context, i4);
        String strD = com.google.android.gms.common.internal.E.d(context, i4);
        Resources resources = context.getResources();
        NotificationManager notificationManager = (NotificationManager) AbstractC0940s.k(context.getSystemService("notification"));
        k.e eVarJ = new k.e(context).y(true).g(true).o(strE).J(new k.c().n(strD));
        if (G1.h.c(context)) {
            AbstractC0940s.n(G1.m.b());
            eVarJ.H(context.getApplicationInfo().icon).C(2);
            if (G1.h.d(context)) {
                eVarJ.a(AbstractC1923a.f15733a, resources.getString(AbstractC1924b.f15748o), pendingIntent);
            } else {
                eVarJ.m(pendingIntent);
            }
        } else {
            eVarJ.H(R.drawable.stat_sys_warning).L(resources.getString(AbstractC1924b.f15741h)).Q(System.currentTimeMillis()).m(pendingIntent).n(strD);
        }
        if (G1.m.e()) {
            AbstractC0940s.n(G1.m.e());
            synchronized (f16093e) {
                str2 = this.f16095c;
            }
            if (str2 == null) {
                str2 = "com.google.android.gms.availability";
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                String string = context.getResources().getString(AbstractC1924b.f15740g);
                if (notificationChannel == null) {
                    notificationManager.createNotificationChannel(com.dexterous.flutterlocalnotifications.B.a("com.google.android.gms.availability", string, 4));
                } else if (!string.contentEquals(notificationChannel.getName())) {
                    notificationChannel.setName(string);
                    notificationManager.createNotificationChannel(notificationChannel);
                }
            }
            eVarJ.i(str2);
        }
        Notification notificationD = eVarJ.d();
        if (i4 == 1 || i4 == 2 || i4 == 3) {
            AbstractC1993k.f16102b.set(false);
            i5 = 10436;
        } else {
            i5 = 39789;
        }
        notificationManager.notify(i5, notificationD);
    }

    public final void v(Context context) {
        new HandlerC1998p(this, context).sendEmptyMessageDelayed(1, 120000L);
    }

    public final boolean w(Activity activity, InterfaceC0908l interfaceC0908l, int i4, int i5, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialogQ = q(activity, i4, com.google.android.gms.common.internal.H.c(interfaceC0908l, b(activity, i4, "d"), 2), onCancelListener, null);
        if (dialogQ == null) {
            return false;
        }
        t(activity, dialogQ, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public final boolean x(Context context, C1984b c1984b, int i4) {
        PendingIntent pendingIntentM;
        if (I1.c.a(context) || (pendingIntentM = m(context, c1984b)) == null) {
            return false;
        }
        u(context, c1984b.i(), null, PendingIntent.getActivity(context, 0, GoogleApiActivity.a(context, pendingIntentM, i4, true), zap.zaa | 134217728));
        return true;
    }
}
