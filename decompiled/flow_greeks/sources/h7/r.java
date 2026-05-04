package h7;

import android.content.Context;
import android.content.SharedPreferences;
import o7.w;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i7.b f11092b = new i7.b(r.class.getSimpleName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w f11093a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11094a;

        static {
            int[] iArr = new int[b.values().length];
            f11094a = iArr;
            try {
                iArr[b.DEFAULT_APP_CHECK_TOKEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11094a[b.UNKNOWN_APP_CHECK_TOKEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum b {
        DEFAULT_APP_CHECK_TOKEN,
        UNKNOWN_APP_CHECK_TOKEN
    }

    public r(final Context context, String str) {
        com.google.android.gms.common.internal.s.k(context);
        com.google.android.gms.common.internal.s.e(str);
        final String str2 = String.format("com.google.firebase.appcheck.store.%s", str);
        this.f11093a = new w(new fa.b() { // from class: h7.q
            @Override // fa.b
            public final Object get() {
                return context.getSharedPreferences(str2, 0);
            }
        });
    }

    public void b() {
        ((SharedPreferences) this.f11093a.get()).edit().remove("com.google.firebase.appcheck.APP_CHECK_TOKEN").remove("com.google.firebase.appcheck.TOKEN_TYPE").apply();
    }

    public e7.c c() {
        String string = ((SharedPreferences) this.f11093a.get()).getString("com.google.firebase.appcheck.TOKEN_TYPE", null);
        String string2 = ((SharedPreferences) this.f11093a.get()).getString("com.google.firebase.appcheck.APP_CHECK_TOKEN", null);
        if (string != null && string2 != null) {
            try {
                int i10 = a.f11094a[b.valueOf(string).ordinal()];
                if (i10 == 1) {
                    return h7.b.e(string2);
                }
                if (i10 == 2) {
                    return h7.b.d(string2);
                }
                f11092b.d("Reached unreachable section in #retrieveAppCheckToken()");
                return null;
            } catch (IllegalArgumentException e10) {
                f11092b.d("Failed to parse TokenType of stored token  with type [" + string + "] with exception: " + e10.getMessage());
                b();
            }
        }
        return null;
    }

    public void d(e7.c cVar) {
        if (cVar instanceof h7.b) {
            ((SharedPreferences) this.f11093a.get()).edit().putString("com.google.firebase.appcheck.APP_CHECK_TOKEN", ((h7.b) cVar).i()).putString("com.google.firebase.appcheck.TOKEN_TYPE", b.DEFAULT_APP_CHECK_TOKEN.name()).apply();
        } else {
            ((SharedPreferences) this.f11093a.get()).edit().putString("com.google.firebase.appcheck.APP_CHECK_TOKEN", cVar.b()).putString("com.google.firebase.appcheck.TOKEN_TYPE", b.UNKNOWN_APP_CHECK_TOKEN.name()).apply();
        }
    }
}
