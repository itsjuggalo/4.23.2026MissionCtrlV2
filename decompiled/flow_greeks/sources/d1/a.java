package d1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.ResultReceiver;
import com.google.android.gms.common.api.a;
import dd.u0;
import java.util.Set;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import y0.f;
import y0.h;
import y0.i;
import y0.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0138a f7493b = new C0138a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f7494c = u0.h(7, 20);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f7495d = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7496a;

    /* JADX INFO: renamed from: d1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0138a {
        public /* synthetic */ C0138a(k kVar) {
            this();
        }

        public final int a() {
            return a.f7495d;
        }

        public final h b(String str, String str2) {
            if (str != null) {
                int iHashCode = str.hashCode();
                if (iHashCode != -1567968963) {
                    if (iHashCode != -154594663) {
                        if (iHashCode == 1996705159 && str.equals("GET_NO_CREDENTIALS")) {
                            return new m(str2);
                        }
                    } else if (str.equals("GET_INTERRUPTED")) {
                        return new i(str2);
                    }
                } else if (str.equals("GET_CANCELED_TAG")) {
                    return new f(str2);
                }
            }
            return new y0.k(str2);
        }

        public final Set c() {
            return a.f7494c;
        }

        public final void d(ResultReceiver resultReceiver, String errName, String errMsg) {
            t.f(resultReceiver, "<this>");
            t.f(errName, "errName");
            t.f(errMsg, "errMsg");
            Bundle bundle = new Bundle();
            bundle.putBoolean("FAILURE_RESPONSE", true);
            bundle.putString("EXCEPTION_TYPE", errName);
            bundle.putString("EXCEPTION_MESSAGE", errMsg);
            resultReceiver.send(a.e.API_PRIORITY_OTHER, bundle);
        }

        public final void e(ResultReceiver resultReceiver, int i10, int i11, Intent intent) {
            t.f(resultReceiver, "<this>");
            Bundle bundle = new Bundle();
            bundle.putBoolean("FAILURE_RESPONSE", false);
            bundle.putInt("ACTIVITY_REQUEST_CODE", i10);
            bundle.putParcelable("RESULT_DATA", intent);
            resultReceiver.send(i11, bundle);
        }

        public C0138a() {
        }
    }

    public a(Context context) {
        t.f(context, "context");
        this.f7496a = context;
    }

    public final void c(ResultReceiver resultReceiver, Intent hiddenIntent, String typeTag) {
        t.f(resultReceiver, "resultReceiver");
        t.f(hiddenIntent, "hiddenIntent");
        t.f(typeTag, "typeTag");
        hiddenIntent.putExtra("TYPE", typeTag);
        hiddenIntent.putExtra("ACTIVITY_REQUEST_CODE", f7495d);
        hiddenIntent.putExtra("RESULT_RECEIVER", d(resultReceiver));
        hiddenIntent.setFlags(65536);
    }

    public final ResultReceiver d(ResultReceiver resultReceiver) {
        Parcel parcelObtain = Parcel.obtain();
        t.e(parcelObtain, "obtain(...)");
        t.c(resultReceiver);
        resultReceiver.writeToParcel(parcelObtain, 0);
        parcelObtain.setDataPosition(0);
        ResultReceiver resultReceiver2 = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return resultReceiver2;
    }
}
