package g;

import E5.m;
import F5.v;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.ext.SdkExtensions;
import f.C1541h;
import g.AbstractC1624a;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public class f extends AbstractC1624a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14234a = new a(null);

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final ResolveInfo a(Context context) {
            r.f(context, "context");
            return context.getPackageManager().resolveActivity(new Intent("com.google.android.gms.provider.action.PICK_IMAGES"), 1114112);
        }

        public final ResolveInfo b(Context context) {
            r.f(context, "context");
            return context.getPackageManager().resolveActivity(new Intent("androidx.activity.result.contract.action.PICK_IMAGES"), 1114112);
        }

        public final String c(e input) {
            r.f(input, "input");
            if (input instanceof c) {
                return "image/*";
            }
            if (input instanceof d) {
                return "video/*";
            }
            if (input instanceof b) {
                return null;
            }
            throw new m();
        }

        public final boolean d(Context context) {
            r.f(context, "context");
            return a(context) != null;
        }

        public final boolean e(Context context) {
            r.f(context, "context");
            return b(context) != null;
        }

        public final boolean f() {
            int i7 = Build.VERSION.SDK_INT;
            if (i7 >= 33) {
                return true;
            }
            return i7 >= 30 && SdkExtensions.getExtensionVersion(30) >= 2;
        }

        public a() {
        }
    }

    public static final class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f14235a = new b();
    }

    public static final class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f14236a = new c();
    }

    public static final class d implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f14237a = new d();
    }

    public interface e {
    }

    public static final boolean f() {
        return f14234a.f();
    }

    @Override // g.AbstractC1624a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, C1541h input) {
        Intent intent;
        r.f(context, "context");
        r.f(input, "input");
        a aVar = f14234a;
        if (aVar.f()) {
            Intent intent2 = new Intent("android.provider.action.PICK_IMAGES");
            intent2.setType(aVar.c(input.a()));
            return intent2;
        }
        if (aVar.e(context)) {
            ResolveInfo resolveInfoB = aVar.b(context);
            if (resolveInfoB == null) {
                throw new IllegalStateException("Required value was null.");
            }
            ActivityInfo activityInfo = resolveInfoB.activityInfo;
            intent = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
            intent.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
            intent.setType(aVar.c(input.a()));
        } else {
            if (!aVar.d(context)) {
                Intent intent3 = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent3.setType(aVar.c(input.a()));
                if (intent3.getType() != null) {
                    return intent3;
                }
                intent3.setType("*/*");
                intent3.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
                return intent3;
            }
            ResolveInfo resolveInfoA = aVar.a(context);
            if (resolveInfoA == null) {
                throw new IllegalStateException("Required value was null.");
            }
            ActivityInfo activityInfo2 = resolveInfoA.activityInfo;
            intent = new Intent("com.google.android.gms.provider.action.PICK_IMAGES");
            intent.setClassName(activityInfo2.applicationInfo.packageName, activityInfo2.name);
            intent.setType(aVar.c(input.a()));
        }
        return intent;
    }

    @Override // g.AbstractC1624a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final AbstractC1624a.C0243a b(Context context, C1541h input) {
        r.f(context, "context");
        r.f(input, "input");
        return null;
    }

    @Override // g.AbstractC1624a
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final Uri c(int i7, Intent intent) {
        if (i7 != -1) {
            intent = null;
        }
        if (intent == null) {
            return null;
        }
        Uri data = intent.getData();
        if (data == null) {
            data = (Uri) v.K(AbstractC1625b.f14231a.a(intent));
        }
        return data;
    }
}
