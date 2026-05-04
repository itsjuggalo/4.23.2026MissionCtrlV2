package n7;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzaen;
import com.google.android.gms.internal.p002firebaseauthapi.zzah;
import com.google.android.gms.internal.p002firebaseauthapi.zzajb;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class p0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f16839d = 3600000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final zzah f16840e = zzah.zza("firebaseAppName", "firebaseUserUid", "operation", "tenantId", "verifyAssertionRequest", "statusCode", "statusMessage", DiagnosticsEntry.TIMESTAMP_KEY);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final p0 f16841f = new p0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Task f16842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Task f16843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f16844c = 0;

    public static void b(Context context, Status status) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putInt("statusCode", status.S());
        editorEdit.putString("statusMessage", status.T());
        editorEdit.putLong(DiagnosticsEntry.TIMESTAMP_KEY, t5.h.d().a());
        editorEdit.commit();
    }

    public static void c(Context context, zzajb zzajbVar, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putString("verifyAssertionRequest", n5.e.f(zzajbVar));
        editorEdit.putString("operation", str);
        editorEdit.putString("tenantId", str2);
        editorEdit.putLong(DiagnosticsEntry.TIMESTAMP_KEY, t5.h.d().a());
        editorEdit.commit();
    }

    public static void d(Context context, FirebaseAuth firebaseAuth) {
        com.google.android.gms.common.internal.s.k(context);
        com.google.android.gms.common.internal.s.k(firebaseAuth);
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putString("firebaseAppName", firebaseAuth.l().q());
        editorEdit.commit();
    }

    public static void e(Context context, FirebaseAuth firebaseAuth, m7.a0 a0Var) {
        com.google.android.gms.common.internal.s.k(context);
        com.google.android.gms.common.internal.s.k(firebaseAuth);
        com.google.android.gms.common.internal.s.k(a0Var);
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putString("firebaseAppName", firebaseAuth.l().q());
        editorEdit.putString("firebaseUserUid", a0Var.a());
        editorEdit.commit();
    }

    public static void f(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        editorEdit.putString("recaptchaToken", str);
        editorEdit.putString("operation", str2);
        editorEdit.putLong(DiagnosticsEntry.TIMESTAMP_KEY, t5.h.d().a());
        editorEdit.commit();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void g(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        zzah zzahVar = f16840e;
        int size = zzahVar.size();
        int i10 = 0;
        while (i10 < size) {
            E e10 = zzahVar.get(i10);
            i10++;
            editorEdit.remove((String) e10);
        }
        editorEdit.commit();
    }

    public static p0 j() {
        return f16841f;
    }

    public final void a(Context context) {
        com.google.android.gms.common.internal.s.k(context);
        g(context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
        this.f16842a = null;
        this.f16844c = 0L;
    }

    public final void h(FirebaseAuth firebaseAuth) {
        zzajb zzajbVar;
        String string;
        com.google.android.gms.common.internal.s.k(firebaseAuth);
        SharedPreferences sharedPreferences = firebaseAuth.l().m().getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0);
        if (firebaseAuth.l().q().equals(sharedPreferences.getString("firebaseAppName", ""))) {
            if (!sharedPreferences.contains("verifyAssertionRequest")) {
                if (sharedPreferences.contains("recaptchaToken")) {
                    String string2 = sharedPreferences.getString("recaptchaToken", "");
                    String string3 = sharedPreferences.getString("operation", "");
                    this.f16844c = sharedPreferences.getLong(DiagnosticsEntry.TIMESTAMP_KEY, 0L);
                    string3.getClass();
                    this.f16843b = string3.equals("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA") ? Tasks.forResult(string2) : null;
                    g(sharedPreferences);
                    return;
                }
                if (sharedPreferences.contains("statusCode")) {
                    Status status = new Status(sharedPreferences.getInt("statusCode", 17062), sharedPreferences.getString("statusMessage", ""));
                    this.f16844c = sharedPreferences.getLong(DiagnosticsEntry.TIMESTAMP_KEY, 0L);
                    g(sharedPreferences);
                    this.f16842a = Tasks.forException(zzaen.zza(status));
                    return;
                }
                return;
            }
            zzajbVar = (zzajb) n5.e.c(sharedPreferences.getString("verifyAssertionRequest", ""), zzajb.CREATOR);
            String string4 = sharedPreferences.getString("operation", "");
            String string5 = sharedPreferences.getString("tenantId", null);
            string = sharedPreferences.getString("firebaseUserUid", "");
            this.f16844c = sharedPreferences.getLong(DiagnosticsEntry.TIMESTAMP_KEY, 0L);
            if (string5 != null) {
                firebaseAuth.z(string5);
                zzajbVar.zzb(string5);
            }
            string4.getClass();
            switch (string4) {
                case "com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE":
                    if (!firebaseAuth.m().a().equals(string)) {
                        this.f16842a = null;
                        break;
                    } else {
                        this.f16842a = firebaseAuth.u0(firebaseAuth.m(), m7.z1.Y(zzajbVar));
                        break;
                    }
                    break;
                case "com.google.firebase.auth.internal.NONGMSCORE_LINK":
                    if (!firebaseAuth.m().a().equals(string)) {
                        this.f16842a = null;
                        break;
                    } else {
                        this.f16842a = firebaseAuth.U(firebaseAuth.m(), m7.z1.Y(zzajbVar));
                        break;
                    }
                    break;
                case "com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN":
                    this.f16842a = firebaseAuth.B(m7.z1.Y(zzajbVar));
                    break;
                default:
                    this.f16842a = null;
                    break;
            }
            g(sharedPreferences);
        }
    }

    public final Task i() {
        if (t5.h.d().a() - this.f16844c < f16839d) {
            return this.f16843b;
        }
        return null;
    }
}
