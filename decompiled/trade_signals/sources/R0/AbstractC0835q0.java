package R0;

import com.google.android.gms.internal.play_billing.H2;
import com.google.android.gms.internal.play_billing.J2;
import com.google.android.gms.internal.play_billing.L2;
import com.google.android.gms.internal.play_billing.O2;
import com.google.android.gms.internal.play_billing.P2;
import com.google.android.gms.internal.play_billing.R2;
import com.google.android.gms.internal.play_billing.T2;
import com.google.android.gms.internal.play_billing.Y2;
import com.revenuecat.purchases.common.Constants;

/* JADX INFO: renamed from: R0.q0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0835q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f7070a = 0;

    static {
        int i8 = r0.f7071a;
    }

    public static String a(Exception exc) {
        if (exc == null) {
            return null;
        }
        try {
            String str = exc.getClass().getSimpleName() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + com.google.android.gms.internal.play_billing.D.b(exc.getMessage());
            int i8 = com.google.android.gms.internal.play_billing.V.f15366a;
            return str.length() > 40 ? str.substring(0, 40) : str;
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.V.n("BillingLogger", "Unable to get truncated exception info", th);
            return null;
        }
    }

    public static J2 b(R2 r22, int i8, com.android.billingclient.api.a aVar, String str, Y2 y22) {
        try {
            P2 p2D = T2.D();
            p2D.p(aVar.c());
            p2D.l(aVar.a());
            if (aVar.b() != 0) {
                p2D.m(aVar.b());
            }
            if (r22 != null) {
                p2D.o(r22);
            }
            if (str != null) {
                p2D.k(str);
            }
            H2 h2G = J2.G();
            h2G.l(p2D);
            h2G.q(i8);
            if (!y22.equals(Y2.BROADCAST_ACTION_UNSPECIFIED)) {
                h2G.k(y22);
            }
            return (J2) h2G.g();
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.V.n("BillingLogger", "Unable to create logging payload", th);
            return null;
        }
    }

    public static O2 c(int i8, Y2 y22) {
        try {
            L2 l2E = O2.E();
            l2E.p(i8);
            if (!y22.equals(Y2.BROADCAST_ACTION_UNSPECIFIED)) {
                l2E.k(y22);
            }
            return (O2) l2E.g();
        } catch (Exception e8) {
            com.google.android.gms.internal.play_billing.V.n("BillingLogger", "Unable to create logging payload", e8);
            return null;
        }
    }
}
