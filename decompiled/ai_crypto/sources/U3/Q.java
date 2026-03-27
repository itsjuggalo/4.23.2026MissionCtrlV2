package U3;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.tasks.OnSuccessListener;

/* JADX INFO: loaded from: classes.dex */
public abstract class Q {
    public static SharedPreferences b(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return context.getSharedPreferences("com.google.firebase.messaging", 0);
    }

    public static boolean c(Context context) {
        return b(context).getBoolean("proxy_notification_initialized", false);
    }

    public static boolean d(SharedPreferences sharedPreferences, boolean z7) {
        return sharedPreferences.contains("proxy_retention") && sharedPreferences.getBoolean("proxy_retention", false) == z7;
    }

    public static void f(Context context, boolean z7) {
        SharedPreferences.Editor editorEdit = b(context).edit();
        editorEdit.putBoolean("proxy_notification_initialized", z7);
        editorEdit.apply();
    }

    public static void g(final Context context, F f7, final boolean z7) {
        if (W1.m.g() && !d(b(context), z7)) {
            f7.l(z7).addOnSuccessListener(new B0.k(), new OnSuccessListener() { // from class: U3.P
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    Q.h(context, z7);
                }
            });
        }
    }

    public static void h(Context context, boolean z7) {
        SharedPreferences.Editor editorEdit = b(context).edit();
        editorEdit.putBoolean("proxy_retention", z7);
        editorEdit.apply();
    }
}
