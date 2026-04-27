package t;

import android.app.Notification;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: renamed from: t.E, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1083E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f9769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f9770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Y f9771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f9772d = new Bundle();
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Uri f9773f;

    public C1083E(CharSequence charSequence, long j4, Y y) {
        this.f9769a = charSequence;
        this.f9770b = j4;
        this.f9771c = y;
    }

    public static Bundle[] a(ArrayList arrayList) {
        Bundle[] bundleArr = new Bundle[arrayList.size()];
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            C1083E c1083e = (C1083E) arrayList.get(i);
            c1083e.getClass();
            Bundle bundle = new Bundle();
            CharSequence charSequence = c1083e.f9769a;
            if (charSequence != null) {
                bundle.putCharSequence("text", charSequence);
            }
            bundle.putLong("time", c1083e.f9770b);
            Y y = c1083e.f9771c;
            if (y != null) {
                bundle.putCharSequence("sender", y.f9801a);
                if (Build.VERSION.SDK_INT >= 28) {
                    bundle.putParcelable("sender_person", AbstractC1082D.a(X.b(y)));
                } else {
                    bundle.putBundle("person", y.b());
                }
            }
            String str = c1083e.e;
            if (str != null) {
                bundle.putString("type", str);
            }
            Uri uri = c1083e.f9773f;
            if (uri != null) {
                bundle.putParcelable("uri", uri);
            }
            Bundle bundle2 = c1083e.f9772d;
            if (bundle2 != null) {
                bundle.putBundle("extras", bundle2);
            }
            bundleArr[i] = bundle;
        }
        return bundleArr;
    }

    public static ArrayList b(Parcelable[] parcelableArr) {
        Y yA;
        ArrayList arrayList = new ArrayList(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable instanceof Bundle) {
                Bundle bundle = (Bundle) parcelable;
                C1083E c1083e = null;
                try {
                    if (bundle.containsKey("text") && bundle.containsKey("time")) {
                        if (bundle.containsKey("person")) {
                            yA = Y.a(bundle.getBundle("person"));
                        } else if (bundle.containsKey("sender_person") && Build.VERSION.SDK_INT >= 28) {
                            yA = X.a(Q3.i.c(bundle.getParcelable("sender_person")));
                        } else if (bundle.containsKey("sender")) {
                            CharSequence charSequence = bundle.getCharSequence("sender");
                            Y y = new Y();
                            y.f9801a = charSequence;
                            y.f9802b = null;
                            y.f9803c = null;
                            y.f9804d = null;
                            y.e = false;
                            y.f9805f = false;
                            yA = y;
                        } else {
                            yA = null;
                        }
                        C1083E c1083e2 = new C1083E(bundle.getCharSequence("text"), bundle.getLong("time"), yA);
                        if (bundle.containsKey("type") && bundle.containsKey("uri")) {
                            String string = bundle.getString("type");
                            Uri uri = (Uri) bundle.getParcelable("uri");
                            c1083e2.e = string;
                            c1083e2.f9773f = uri;
                        }
                        if (bundle.containsKey("extras")) {
                            c1083e2.f9772d.putAll(bundle.getBundle("extras"));
                        }
                        c1083e = c1083e2;
                    }
                } catch (ClassCastException unused) {
                }
                if (c1083e != null) {
                    arrayList.add(c1083e);
                }
            }
        }
        return arrayList;
    }

    public final Notification.MessagingStyle.Message c() {
        Notification.MessagingStyle.Message messageA;
        int i = Build.VERSION.SDK_INT;
        long j4 = this.f9770b;
        CharSequence charSequence = this.f9769a;
        Y y = this.f9771c;
        if (i >= 28) {
            messageA = AbstractC1082D.b(charSequence, j4, y != null ? X.b(y) : null);
        } else {
            messageA = AbstractC1081C.a(charSequence, j4, y != null ? y.f9801a : null);
        }
        String str = this.e;
        if (str != null) {
            AbstractC1081C.b(messageA, str, this.f9773f);
        }
        return messageA;
    }
}
