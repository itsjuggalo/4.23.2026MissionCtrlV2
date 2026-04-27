package W2;

import android.content.Context;
import android.content.SharedPreferences;
import b3.w;
import com.google.android.gms.common.internal.AbstractC1207s;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final X2.b f5415b = new X2.b(j.class.getSimpleName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w f5416a;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5417a;

        static {
            int[] iArr = new int[b.values().length];
            f5417a = iArr;
            try {
                iArr[b.DEFAULT_APP_CHECK_TOKEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5417a[b.UNKNOWN_APP_CHECK_TOKEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum b {
        DEFAULT_APP_CHECK_TOKEN,
        UNKNOWN_APP_CHECK_TOKEN
    }

    public j(final Context context, String str) {
        AbstractC1207s.k(context);
        AbstractC1207s.e(str);
        final String str2 = String.format("com.google.firebase.appcheck.store.%s", str);
        this.f5416a = new w(new N3.b() { // from class: W2.i
            @Override // N3.b
            public final Object get() {
                return j.c(context, str2);
            }
        });
    }

    public static /* synthetic */ Object c(Context context, String str) {
        return context.getSharedPreferences(str, 0);
    }

    public void b() {
        ((SharedPreferences) this.f5416a.get()).edit().remove("com.google.firebase.appcheck.APP_CHECK_TOKEN").remove("com.google.firebase.appcheck.TOKEN_TYPE").apply();
    }

    public V2.a d() {
        String string = ((SharedPreferences) this.f5416a.get()).getString("com.google.firebase.appcheck.TOKEN_TYPE", null);
        String string2 = ((SharedPreferences) this.f5416a.get()).getString("com.google.firebase.appcheck.APP_CHECK_TOKEN", null);
        if (string != null && string2 != null) {
            try {
                int i7 = a.f5417a[b.valueOf(string).ordinal()];
                if (i7 == 1) {
                    return W2.a.d(string2);
                }
                if (i7 == 2) {
                    return W2.a.c(string2);
                }
                f5415b.d("Reached unreachable section in #retrieveAppCheckToken()");
                return null;
            } catch (IllegalArgumentException e7) {
                f5415b.d("Failed to parse TokenType of stored token  with type [" + string + "] with exception: " + e7.getMessage());
                b();
            }
        }
        return null;
    }
}
